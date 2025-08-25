package com.zhouxinbin.tomcat.handler;

import com.zhouxinbin.tomcat.Tomcat;
import com.zhouxinbin.tomcat.http.MyRequest;
import com.zhouxinbin.tomcat.http.MyResponse;
import com.zhouxinbin.tomcat.servlet.MyHttpServlet;
import com.zhouxinbin.tomcat.util.WebUtils;

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
            MyRequest myRequest = new MyRequest(inputStream);
            // 创建 HttpResponse 对象把响应返回到浏览器
            OutputStream outputStream = socket.getOutputStream();
            MyResponse myResponse = new MyResponse(outputStream);
            // 获取 URI 获得实例
            String uri = myRequest.getUri();
            // 判断应用上下文是否正确
            String applicationContext = uri.substring(0, uri.lastIndexOf("/"));
            if (applicationContext.equals(Tomcat.ApplicationConText)) {
                // 判断静态资源还是 Servlet
                if (uri.contains(".")) {
                    WebUtils.doStatic(uri, myRequest, myResponse);
                } else {
                    WebUtils.doServlet(uri, myRequest, myResponse);
                }
            } else { // 不符合上下文
                WebUtils.errorPage(myResponse);
            }

            // 关流
            inputStream.close();
            outputStream.close();
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