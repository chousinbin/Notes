package com.net_.socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/15 18:37
 * @Description: 二次握手
 */
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket acceptSocket = serverSocket.accept();
        // 字节流写
        InputStream is = acceptSocket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = is.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, len));
        }
        // 字节流读
        OutputStream oos = acceptSocket.getOutputStream();
        oos.write("hello, client".getBytes());
        acceptSocket.shutdownOutput(); // 结束输出流

        is.close();
        oos.close();
        acceptSocket.close();
        serverSocket.close();
    }
}
