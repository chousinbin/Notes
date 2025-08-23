package com.zhouxinbin.tomcat;

import com.zhouxinbin.tomcat.handler.RequestHandler;
import com.zhouxinbin.tomcat.servlet.MyHttpServlet;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Tomcat {
    public static final ConcurrentHashMap<String, MyHttpServlet> servletMapping = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, String> servletUrlMapping = new ConcurrentHashMap<>();
    public static final String ApplicationConText = "/MyTomcat";

    public static void main(String[] args) throws IOException {
        Tomcat tomcat = new Tomcat();
        tomcat.initHashMap();
        tomcat.listening();
    }
    // dom4j 读取 web.xml 存储到哈希表，并自动创建 Servlet 实例，后期可以改为第一次请求时创建实例
    public void initHashMap() throws IOException {
        String path = Tomcat.class.getResource("/").getPath();
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new File(path + "web.xml"));
            Element root = document.getRootElement();
            List<Element> elements = root.elements();
            // 遍历过滤 Servlet Servlet-Mapping
            for (Element element : elements) {
                if (element.getName().equalsIgnoreCase("servlet")) {
                    Element servletName = element.element("servlet-name");
                    Element servletClass = element.element("servlet-class");
                    servletMapping.put(servletName.getText(),
                            (MyHttpServlet) Class.forName(servletClass.getText().trim()).newInstance());
                } else if (element.getName().equalsIgnoreCase("servlet-mapping")) {
                    Element servletName = element.element("servlet-name");
                    Element urlPattern = element.element("url-pattern");
                    servletUrlMapping.put(urlPattern.getText(), servletName.getText());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void listening() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Tomcat 在 9090 监听");
        while (!serverSocket.isClosed()) {
            // 等待客户端连接
            Socket socket = serverSocket.accept();
            // 创建接收 HTTP 请求的多线程
            new Thread(new RequestHandler(socket)).start();
        }
    }
}