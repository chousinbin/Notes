package Fish;

import javax.servlet.*;
import java.io.IOException;

public class HelloServlet implements Servlet {
    // Servlet 是单例
    private int count = 0;
    /**
     * 1. 初始化 Servlet
     * 2. 创建 HelloServlet 实例时，调用 init()
     * 3. 该方法只会被调用一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Initializing HelloServlet");
    }

    /**
     * 返回 ServletConfig
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 1. 处理浏览器的请求
     * 2. 每请求一次，被调用一次
     * 3. 当 Tomcat 调用方法时，会把 HTTP 请求封装成实现了 ServletRequest 接口的 Request 对象
     * 4. 通过 ServletRequest 对象获取提交的属性
     * 5. 把响应内容封装成 Response 对象给 Tomcat
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        count++;
        System.out.println("servlet 被调用 " + count);
        System.out.println(Thread.currentThread().getId());
    }

    /**
     * 返回 Servlet 信息
     * @return
     */
    @Override
    public String getServletInfo() {
        return "";
    }

    /**
     * 该方法用于 Servlet 被销毁时，被 Tomcat 调用，只调用一次
     */
    @Override
    public void destroy() {
        System.out.println("Destroying HelloServlet");
    }
}
