package com.sinbin.net_.file_upload;

import com.sinbin.net_.StreamUtil;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/15 20:58
 * @Description:
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        // 读取文件的字节数组
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtil.streamToByteArray(bis);

        // 字节数组写入本地磁盘
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream("resource\\server\\logo.jpg"));
        bos.write(bytes);


        // 回复客户端（字符）
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        bw.write("图片上传成功");
        bw.flush();
        socket.shutdownOutput();
        bw.close();

        bis.close();
        bos.close();
        socket.close();
        serverSocket.close();
    }
}
