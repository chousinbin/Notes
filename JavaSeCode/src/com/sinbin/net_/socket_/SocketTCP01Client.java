package com.sinbin.net_.socket_;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/11 22:18
 * @Description:
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("socket connect success");
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello, server!".getBytes());
        outputStream.close();
        socket.close();
    }
}
