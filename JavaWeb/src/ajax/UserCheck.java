package ajax;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/UserCheck")
public class UserCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        System.out.println(username);

        response.setContentType("text/json;charset=UTF-8");
        if ("king".equals(username)) {
            System.out.println("king");
            User king = new User(1, "king", "king@gmail.com");
            String strKing = new Gson().toJson(king);
            response.getWriter().write(strKing + "");
        } else {
            response.getWriter().write("");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}