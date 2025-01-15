package com.net_.socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/15 20:23
 * @Description:
 */
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        // 字节流转换为字符流
        OutputStream oos = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(oos));
        bw.write("hello, server");
        bw.newLine();
        bw.write("EOF");
        bw.newLine();
        bw.flush(); // 字符流手动刷新


        // 字符流读
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        while((line = br.readLine()) != null && !line.equals("EOF")) {
            System.out.println(line);
        }

        bw.close();
        br.close();
        socket.close();
    }
}
