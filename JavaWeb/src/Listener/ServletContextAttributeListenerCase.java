package Listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ServletContextAttributeListenerCase implements ServletContextAttributeListener {
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("添加的属性：" + event.getName() + event.getValue());
    }
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("删除的属性：" + event.getName() + event.getValue());
    }
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("改前的属性：" + event.getName() + event.getValue());
    }
}
