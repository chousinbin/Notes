package com.zhouxinbin.tomcat.handler;

import com.zhouxinbin.tomcat.http.MyRequest;
import com.zhouxinbin.tomcat.http.MyResponse;
import com.zhouxinbin.tomcat.servlet.MyCalServlet;

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
            // 创建 Servlet
            new MyCalServlet().doGet(myRequest, myResponse);
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