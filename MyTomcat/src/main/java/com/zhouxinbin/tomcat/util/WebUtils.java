package com.zhouxinbin.tomcat.util;

import com.zhouxinbin.tomcat.Tomcat;
import com.zhouxinbin.tomcat.http.MyRequest;
import com.zhouxinbin.tomcat.http.MyResponse;
import com.zhouxinbin.tomcat.servlet.MyHttpServlet;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class WebUtils {
    public static int parseInt(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println(str + "转换失败");
        }
        return defaultValue;
    }

    public static String getContentType(String filePath) {
        if (filePath.endsWith(".html")) {
            return "text/html;charset=utf-8";
        } else if (filePath.endsWith(".css")) {
            return "text/css";
        } else if (filePath.endsWith(".js")) {
            return "application/javascript";
        } else if (filePath.endsWith(".png")) {
            return "image/png";
        } else if (filePath.endsWith(".jpg") || filePath.endsWith(".jpeg")) {
            return "image/jpeg";
        } else {
            return "application/octet-stream"; // 默认二进制流（浏览器会下载）
        }
    }
    public static void doStatic(String uri, MyRequest myRequest, MyResponse myResponse) throws IOException {
        String path = Tomcat.class.getResource("/").getPath();
        path = path + uri.substring(Tomcat.ApplicationConText.length() + 1);
        // 判断是否存在
        if (!new File(path).exists()) {
            errorPage(myResponse);
            return;
        }
        // 创建响应头
        StringBuilder stringBuilder = new StringBuilder();
        String responseHeader = "HTTP/1.1 200 OK\r\nContent-Type: " + WebUtils.getContentType(path) + "\r\n\r\n";
        stringBuilder.append(responseHeader);
        // 读取文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        // 返回文件
        OutputStream outputStream = myResponse.getOutputStream();
        outputStream.write(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
    }

    public static void doServlet(String uri, MyRequest myRequest, MyResponse myResponse) throws IOException {
        // 判断是否存在实例
        uri = uri.substring(uri.lastIndexOf("/"));
        String servletName = Tomcat.servletUrlMapping.get(uri);
        // 避免获取 URL 时 空指针异常
        if (servletName == null) {
            servletName = "";
        }
        MyHttpServlet myHttpServlet = Tomcat.servletMapping.get(servletName);
        // 判断实例是否在 web.xml 中
        if (myHttpServlet != null) {
            // 动态绑定，调用运行类型的 GET 或 POST
            myHttpServlet.service(myRequest, myResponse);
        } else { // 不存在实例
            errorPage(myResponse);
        }
    }

    public static void errorPage(MyResponse myResponse) throws IOException {
        String responseBody ="HTTP/1.1 404 Not Found\r\nContent-Type: text/html\r\n\r\n<h1>404 Not Found</h1>";
        OutputStream outputStream = myResponse.getOutputStream();
        outputStream.write(responseBody.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
    }
}
