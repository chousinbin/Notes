package com.zhouxinbin.tomcat.handler;

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
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            System.out.println("=== HTTP 请求数据 ===");
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                }
                System.out.println(line);
            }
            // 通过 Socket 把响应返回到浏览器
            String responseHeader =
                    "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html;charset=utf-8\r\n\r\n";
            responseHeader = responseHeader + "<h1>Hello World</h1>";

            System.out.println("=== HTTP 响应数据 ===");
            System.out.println(responseHeader);

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(responseHeader.getBytes(StandardCharsets.UTF_8));
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