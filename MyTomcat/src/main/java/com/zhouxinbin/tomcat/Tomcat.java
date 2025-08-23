package com.zhouxinbin.tomcat;

import com.zhouxinbin.tomcat.handler.RequestHandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Tomcat {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Tomcat 在 9090 监听");
        while (!serverSocket.isClosed()) {
            // 等待客户端连接
            Socket socket = serverSocket.accept();
            // 创建多线程
            new Thread(new RequestHandler(socket)).start();
        }
    }
}