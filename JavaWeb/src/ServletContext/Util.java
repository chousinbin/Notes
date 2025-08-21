package ServletContext;

import javax.servlet.ServletContext;

public class Util {
    public static Integer counter(ServletContext servletContext) {
        Object counter = servletContext.getAttribute("counter");
        if (counter == null) {
            servletContext.setAttribute("counter", 1);
        } else {
            servletContext.setAttribute("counter", (Integer)counter + 1);
        }
        return (Integer) servletContext.getAttribute("counter");
    }
}
