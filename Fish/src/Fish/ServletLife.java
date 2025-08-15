package Fish;

import javax.servlet.*;
import java.io.IOException;

public class ServletLife implements Servlet {

    /**
     * Servlet 加载时机
     * 1. 通过配置 web.xml Tomcat 启动时自动加载 Servlet时
     * 2. Tomcat 启动后，手动请求 Servlet
     * 3. 项目重新装载后 redeploy 再次请求时
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 处理浏览器请求阶段
     *  1. 每收到一个请求，创建一个线程，回应请求
     *  2. 创建一个 ServletRequest 和 ServletResponse 请求和响应
     *  3. 调用 service() 将请求和响应对象作为参数传递
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "";
    }

    /**
     * 终止 Servlet
     * 当 Web 应用被终止，Servlet 容器终止运行，Servlet 类重新加载
     * 比如 重启 Tomcat 或 Redeploy
     */
    @Override
    public void destroy() {

    }
}
