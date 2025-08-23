package com.zhouxinbin.tomcat.handler;

import com.zhouxinbin.tomcat.http.MyRequest;
import com.zhouxinbin.tomcat.http.MyResponse;

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
            // 读取 Socket 上的请求
            InputStream inputStream = socket.getInputStream();
            MyRequest myRequest = new MyRequest(inputStream);
            System.out.println(myRequest.toString());
            // 通过 Socket 把响应返回到浏览器
            OutputStream outputStream = socket.getOutputStream();
            MyResponse myResponse = new MyResponse(outputStream);
            String s = myResponse.responseHeader + "<h1>Hello World~</h1>";
            outputStream.write(s.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
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