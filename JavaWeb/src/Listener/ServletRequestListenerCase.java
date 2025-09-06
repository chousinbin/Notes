package Listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class ServletRequestListenerCase implements ServletRequestListener {
    public void requestDestroyed(ServletRequestEvent arg0) {

    }
    public void requestInitialized(ServletRequestEvent arg0) {
        ServletRequest servletRequest = arg0.getServletRequest();
        System.out.println(servletRequest.getRemoteAddr());
        System.out.println(((HttpServletRequest)servletRequest).getRequestURL());
    }
}
