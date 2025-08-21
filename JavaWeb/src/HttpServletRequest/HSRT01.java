package HttpServletRequest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/HSRT01")
public class HSRT01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        /**
         * 获取请求行
         */
        System.out.println(request.getMethod());
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        System.out.println(request.getProtocol());
        /**
         * 获取请求头
         */
        System.out.println(request.getCookies());
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemotePort());
        System.out.println(request.getRemoteHost());
        System.out.println(request.getHeader("User-Agent"));
        /**
         * 获取请求参数
         */
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("password"));
        String[] teachers = request.getParameterValues("teacher");
        for (String teacher : teachers) {
            System.out.println(teacher);
        }


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}