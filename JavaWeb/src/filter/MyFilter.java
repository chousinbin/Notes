package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("MyFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter doFilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpServletRequest.getSession();
        // 判断 Session 放行
        if (session.getAttribute("username") != null) {
            // servletRequest 和 servletResponse 传递给目标资源
            filterChain.doFilter(servletRequest, servletResponse);
        } else { // 回到登陆界面
            httpServletResponse.sendRedirect(
                    httpServletRequest.getContextPath() + "/10Filter/login.jsp");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
