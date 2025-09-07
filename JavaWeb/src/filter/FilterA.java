package filter;

import javax.servlet.*;
import java.io.IOException;


public class FilterA implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterA 前置代码");
        System.out.println("FilterA 执行");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FilterA 后置代码");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
