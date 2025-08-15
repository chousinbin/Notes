package com.sinbin.net_.file_upload;

import com.sinbin.net_.StreamUtil;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/15 21:03
 * @Description:
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        // 读取文件到字节数组
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream("resource\\client\\logo.jpg"));
        byte[] bytes = StreamUtil.streamToByteArray(bis);


        // 文件发送
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        socket.shutdownOutput();


        // 获取信息
        InputStream inputStream = socket.getInputStream();
        String res = StreamUtil.streamToString(inputStream);
        System.out.println(res);

        inputStream.close();
        bis.close();
        bos.close();
        socket.close();
    }
}
