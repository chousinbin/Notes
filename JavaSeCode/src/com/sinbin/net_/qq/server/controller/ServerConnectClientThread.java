package com.sinbin.net_.qq.server.controller;

import com.sinbin.net_.qq.common.Message;
import com.sinbin.net_.qq.common.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Set;

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
        boolean loop = true;
        // 线程需要在后台监听客户端发来的未知消息
        while (loop) {
//            System.out.println("线程等待客户端" + userId + "消息");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message)ois.readObject();
                // 判断 message 类型，做相应的处理
                switch (message.getMessageType()) {
                    case MessageType.MESSAGE_GET_ONLINE_USER:
                        System.out.println(message.getSender() + " 获取在线列表");
                        String onlineUserList = ManageServerThread.getOnlineUserList();
                        Message message1 = new Message();
                        message1.setContent(onlineUserList);
                        message1.setMessageType(MessageType.MESSAGE_RET_ONLINE_USER);
                        message1.setReceiver(message.getSender());
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(message1);
                        break;
                    case MessageType.MESSAGE_CLIENT_EXIT:
                        System.out.println(message.getSender() + " 退出登录");
                        // 给要退出的客户端发送退出消息
                        Message message2 = new Message();
                        message2.setReceiver(message.getSender());
                        message2.setMessageType(MessageType.MESSAGE_CLIENT_EXIT);
                        ObjectOutputStream oos2 = new ObjectOutputStream(socket.getOutputStream());
                        oos2.writeObject(message2);
                        // 释放服务端的相关线程和 Socket 资源
                        ManageServerThread.removeThread(userId);
                        socket.close();
                        loop = false;
                        break;
                    case MessageType.MESSAGE_PRIVATE_MES:
                        System.out.println(message.getSender() + " to " + message.getReceiver() + ": " +
                                message.getContent());
                        if(ManageServerThread.isOnline(message.getReceiver())) {
                            // 得到服务器与接收者之间的线程
                            ServerConnectClientThread thread = ManageServerThread.getThread(message.getReceiver());
                            ObjectOutputStream oos3 = new ObjectOutputStream(thread.getSocket().getOutputStream());
                            oos3.writeObject(message);
                        } else { // 如果客户端不在线，可以保存到数据库

                        }
                        break;
                    case MessageType.MESSAGE_GROUP_MES:
                        System.out.println(message.getSender() + " to ALL: " +
                                message.getContent());
                        Set<String> users = ManageServerThread.getKeySet();
                        for (String user : users) {
                            if (user.equals(message.getSender())) {
                                continue;
                            }
                            ServerConnectClientThread thread = ManageServerThread.getThread(user);
                            ObjectOutputStream oos4 = new ObjectOutputStream(thread.getSocket().getOutputStream());
                            oos4.writeObject(message);
                        }
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
