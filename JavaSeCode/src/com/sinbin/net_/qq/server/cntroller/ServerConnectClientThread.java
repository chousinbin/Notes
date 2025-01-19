package com.sinbin.net_.qq.server.cntroller;

import com.sinbin.net_.qq.common.Message;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/19 18:28
 * @Description:
 */
public class ServerConnectClientThread extends Thread{
    private Socket socket;
    private String userId;

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {
        // 线程需要在后台监听客户端发来的未知消息
        while (true) {
            System.out.println("线程等待客户端" + userId + "消息");
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
