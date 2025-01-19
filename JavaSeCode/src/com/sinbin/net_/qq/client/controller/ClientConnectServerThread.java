package com.sinbin.net_.qq.client.controller;

import com.sinbin.net_.qq.common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/19 17:38
 * @Description:
 */
public class ClientConnectServerThread extends Thread{
    // 线程持有 Socket
    private Socket socket;
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 线程需要在后台监听服务器发来的未知消息
        while (true) {
            System.out.println("客户端线程等待服务器消息");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message)ois.readObject();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
