package com.net_.fle_download;

import com.net_.StreamUtil;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/18 14:42
 * @Description:
 */
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line = br.readLine();

        String path = "resource\\无名.mp3";
        if (line.equals("高山流水")) {
            path = "resource\\高山流水.mp3";
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
        byte[] bytes = StreamUtil.streamToByteArray(bis);

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        bos.flush();

        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
