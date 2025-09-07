package filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class FilterConfigCase implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String filterName = filterConfig.getFilterName();
        System.out.println(filterName);

        ServletContext servletContext = filterConfig.getServletContext();
        System.out.println(servletContext);

        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String initParameterName = initParameterNames.nextElement();
            System.out.println(initParameterName);
        }

        String ip = filterConfig.getInitParameter("ip");
        System.out.println(ip);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
