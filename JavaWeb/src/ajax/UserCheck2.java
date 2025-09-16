package ajax;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/UserCheck2")
public class UserCheck2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");

        response.setContentType("text/json;charset=UTF-8");
        if ("king".equals(username)) {
            User king = new User(1, "king", "king@gmail.com");
            String strKing = new Gson().toJson(king);
            response.getWriter().write(strKing);
        } else {
            User user = new User(-1, "", "");
            String json = new Gson().toJson(user);
            response.getWriter().write(json);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}