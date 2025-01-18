package com.net_.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/18 13:55
 * @Description:
 */
public class Server01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);


        String ret;
        if (s.equals("name")) {
            ret = "我是nava";
        } else if (s.equals("hobby")) {
            ret = "编写程序";
        } else {
            ret = "你说啥呢";
        }

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(ret);
        bw.newLine();
        bw.flush();
        socket.shutdownOutput();

        br.close();
        bw.close();
        socket.close();
        serverSocket.close();
    }
}
