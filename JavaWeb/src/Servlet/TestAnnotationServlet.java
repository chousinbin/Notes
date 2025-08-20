package Servlet;

import javax.servlet.annotation.WebServlet;
import java.lang.annotation.Annotation;
import java.util.HashMap;

public class TestAnnotationServlet {
    private static final HashMap<String, Object> hm = new HashMap<>();
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 扫描软件包，路径io，得到类的全路径
        String classPath = "Servlet/HelloServlet01";
        // 得到 class 对象
        Class<?> aClass = Class.forName(classPath);
        // 得到注解
        WebServlet annotation = aClass.getAnnotation(WebServlet.class);
        System.out.println(annotation);
        String[] strings = annotation.urlPatterns();
        for(String s : strings){
            System.out.println(s);
        }
        // 如果URL与请求的相匹配，创建实例，放入 HashMap
        Object instance = aClass.newInstance();
        hm.put("HelloServlet01", instance);
    }
}
