package com.sinbin.net_.fle_download;

import com.sinbin.net_.StreamUtil;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/18 14:42
 * @Description:
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        // 发送字符
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(next);
        bw.newLine();
        bw.flush();
        // 接收文件的字节流
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtil.streamToByteArray(bis);
        // 写入硬盘
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\temp\\down.mp3"));
        bos.write(bytes);
        bos.flush();

        bos.close();
        bis.close();
        socket.close();
    }
}
