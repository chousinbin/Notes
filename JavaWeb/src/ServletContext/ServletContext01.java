package ServletContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/ServletContext01")
public class ServletContext01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 0. 获取 ServletContext 对象
        ServletContext servletContext = this.getServletContext();
        // 1. 获取上下文参数
        String website = servletContext.getInitParameter("website");
        System.out.println(website);
        // 2. 获取工程路径
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
        // 3. 获取项目资源实际位置
        String realPath = servletContext.getRealPath("/");
        System.out.println(realPath);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}