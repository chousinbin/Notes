package Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/pig1", "/pig2"})
public class ServletPig extends HttpServlet {
    private static int countGet = 0;
    private static int countPost = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        countGet++;
        System.out.println(countGet);
        System.out.println("doGet");
        System.out.println(req.getRemoteAddr());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        countPost++;
        System.out.println(countPost);
        System.out.println("doPost");
        System.out.println(req.getRemoteAddr());
    }
}