package Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletCat implements Servlet {
    private static int count = 0;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        count++;
        System.out.println(count);

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if (method.equals("GET")) {
            System.out.println("GET");
        } else if (method.equals("POST")) {
            System.out.println("POST");
        }
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}
