package cookie;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns="/cookieLogin")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = "";
        Cookie cookie = CookieUtils.readCookieByName("username", request.getCookies());
        if (cookie != null) {
            username = cookie.getValue();
        }

        PrintWriter out = response.getWriter();
        out.write("<form action=\"cookieLogin\" method=\"post\">");
        out.write("username: ");
        out.write("<input type=\"text\" name=\"username\" value=" + username +">");
        out.write("<br>");
        out.write("password: ");
        out.write("<input type=\"password\" name=\"password\" value=\"\">");
        out.write("<br>");
        out.write("<input type=\"submit\" value=\"Login\">");
        out.write("</form>");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("admin")) {
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60 * 24 * 3);
            response.addCookie(cookie);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write("<p1>登陆成功</p1>");
            writer.flush();
            writer.close();
        } else {
            response.sendRedirect("cookieLogin");
        }
    }
}