package HTTP;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        if ("POST".equals(method)) {
            doPost(httpServletRequest, httpServletResponse);
        } else if ("GET".equals(method)) {
            doGet(httpServletRequest, httpServletResponse);
        }
    }

    private void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        System.out.println("GET");
    }

    private void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        System.out.println("POST");
        httpServletResponse.setContentType("text/html;charset=utf-8");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.print("<h1>登录成功~</h1>");
        writer.flush();
        writer.close();
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}
