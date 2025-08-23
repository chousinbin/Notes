package com.zhouxinbin.tomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TomcatV1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);

        while (!serverSocket.isClosed()) {
            // 等待客户端连接
            Socket socket = serverSocket.accept();
            // 接收浏览器发送的数据
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            // 按行获取请求行
            System.out.println("===HTTP 请求信息===");
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                }
                System.out.println(line);
            }
            // 响应
            String responseHeader = "HTTP/1.1 200 OK\r\n" +
                    "Server: Apache\r\n" +
                    "Content-Type: text/html;charset=utf-8\r\n" +
                    "Transfer-Encoding: chunked\r\n" +
                    "Date: 20250823\r\n\r\n";
            String responseBody = responseHeader + "hello";

            System.out.println("===HTTP 响应信息===");
            System.out.println(responseBody);

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(responseBody.getBytes());
            outputStream.flush();
            // 请求响应结束
            inputStream.close();
            outputStream.close();
            socket.close();

        }

    }
}
