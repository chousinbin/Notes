package com.sinbin.net_.socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/15 20:23
 * @Description:
 */
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket acceptSocket = serverSocket.accept();
        // 字符流读
        InputStream is = acceptSocket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        while((line = br.readLine()) != null && !line.equals("EOF")) {
            System.out.println(line);
        }

        // 字节流写
        OutputStream oos = acceptSocket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(oos));
        bw.write("hello, client");
        bw.newLine();
        bw.write("EOF");
        bw.newLine();
        bw.flush();

        bw.close();
        br.close();
        acceptSocket.close();
        serverSocket.close();
    }
}
