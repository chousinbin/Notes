package com.zhouxinbin.tomcat.handler;

import com.zhouxinbin.tomcat.Tomcat;
import com.zhouxinbin.tomcat.http.MyRequest;
import com.zhouxinbin.tomcat.http.MyResponse;
import com.zhouxinbin.tomcat.servlet.MyCalServlet;
import com.zhouxinbin.tomcat.servlet.MyHttpServlet;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class RequestHandler implements Runnable{
    private Socket socket = null;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 创建 HttpRequest 对象读取 Socket 上的请求
            InputStream inputStream = socket.getInputStream();
            MyRequest myRequest = new MyRequest(socket.getInputStream());
            // 创建 HttpResponse 对象把响应返回到浏览器
            MyResponse myResponse = new MyResponse(socket.getOutputStream());
            // 获取 URI 获得实例
            String uri = myRequest.getUri();
            // 判断应用上下文是否正确
            String applicationContext = uri.substring(0, uri.lastIndexOf("/"));
            if (!applicationContext.equals(Tomcat.ApplicationConText)) {
                uri = "/";
            }
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
            } else {
                String responseBody = myResponse.responseHeader + "<h1> 404 NOT FOUND </h1>";
                OutputStream outputStream = myResponse.getOutputStream();
                outputStream.write(responseBody.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
            }
            // 关流
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}