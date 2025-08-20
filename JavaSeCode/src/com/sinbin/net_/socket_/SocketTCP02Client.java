package com.sinbin.net_.socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/15 18:37
 * @Description:
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        // 字节流写
        OutputStream oos = socket.getOutputStream();
        oos.write("hello, server".getBytes());
        socket.shutdownOutput();
        // 字节流读
        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = is.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, len));
        }

        is.close();
        oos.close();
        socket.close();
    }
}
