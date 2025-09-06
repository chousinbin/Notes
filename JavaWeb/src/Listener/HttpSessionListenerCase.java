package Listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionListenerCase implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(se.getSession().getId() + " session created");
    }
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(se.getSession().getId() + " session destroyed");
    }
}
