package filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterB implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterB 前置代码");
        System.out.println("FilterB 执行");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FilterB 后置代码");
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
