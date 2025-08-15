package com.sinbin.net_.qq.client.controller;

import com.sinbin.net_.qq.common.Message;
import com.sinbin.net_.qq.common.MessageType;

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
        boolean loop = true;
        // 线程需要在后台监听服务器发来的未知消息
        while (loop) {
//            System.out.println("客户端线程等待服务器消息");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message)ois.readObject();
                // 判断 message 类型，做相应的处理
                switch (message.getMessageType()) {
                    case MessageType.MESSAGE_RET_ONLINE_USER:
                        String[] users = message.getContent().split(" ");
                        System.out.println("当前在线用户：");
                        for (int i = 0; i < users.length; i ++) {
                            System.out.println(users[i]);
                        }
                        break;
                    case MessageType.MESSAGE_CLIENT_EXIT:
                        ManageClientConnectServerThread.removeThread(message.getReceiver());
                        socket.close();
                        loop = false;
                        break;
                    case MessageType.MESSAGE_PRIVATE_MES:
                        System.out.println("\n" + message.getSender() + "(" + message.getSendTime() + "):");
                        System.out.println(message.getContent());
                        break;
                    case MessageType.MESSAGE_GROUP_MES:
                        System.out.println("\n" + message.getSender() + "(" + message.getSendTime() + ")2all:");
                        System.out.println(message.getContent());
                        break;
                    case MessageType.MESSAGE_FILE:
                        System.out.println("\n" + message.getSender() + "(" + message.getSendTime() + "): " +
                                message.getContent());
                        new FileService().saveFile(message);
                        break;
                }
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