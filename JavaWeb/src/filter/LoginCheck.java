package filter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns="/LoginCheck")
public class LoginCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("admin")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            // 请求转发不走过滤器
            request.getRequestDispatcher("/10Filter/filter/manage.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/10Filter/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}