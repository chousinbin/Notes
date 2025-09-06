package Listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class HttpSessionAttributeListenerCase implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("session added" + event.getName() + " " + event.getValue());
    }
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("session removed" + event.getName() + " " + event.getValue());
    }
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("session replaced" + event.getName() + " " + event.getValue());
    }
}
