package com.sinbin.net_.socket_;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/11 21:36
 * @Description:
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        // 阻塞代码，等待连接
        Socket accept = serverSocket.accept();
        System.out.println("建立连接");

        InputStream inputStream = accept.getInputStream();
        byte[] buffer = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buffer)) != -1) {
            System.out.print(new String(buffer, 0, readLen));
        }

        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
