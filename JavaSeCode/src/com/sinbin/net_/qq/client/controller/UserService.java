package com.sinbin.net_.qq.client.controller;

import com.sinbin.net_.qq.common.Message;
import com.sinbin.net_.qq.common.MessageType;
import com.sinbin.net_.qq.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/19 16:26
 * @Description:
 */
public class UserService {
    private boolean status = false;
    private User user = new User();
    private Socket socket;
    public boolean checkUser(String userId, String userPwd) throws IOException, ClassNotFoundException {
//        user = new User(userId, userPwd);
        user.setUserId(userId);
        user.setUserPwd(userPwd);
        // 发送 User 对象到服务器进行验证
        socket = new Socket(InetAddress.getLocalHost(), 9999);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(user);
        // 得到服务器返回的消息
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Message message = (Message)ois.readObject();

        if (message.getMessageType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
            status = true;
            // 创建一个与服务器保持通信的线程
            ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
            clientConnectServerThread.start();
            // 线程放入集合
            ManageClientConnectServerThread.add(userId, clientConnectServerThread);
        } else {
            // 防止重新登陆时自动返回上次的 true
            status = false;
            // 登录失败，不启动线程，关闭 Socket
            socket.close();
        }

        return status;
    }

    public void getOnlineUser() {
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_GET_ONLINE_USER);
        message.setSender(user.getUserId());
        // 获取当前线程的 Socket
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServerThread.query(user.getUserId()).
                            getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clientExit() {
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(user.getUserId());
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.query(user.getUserId()).
                    getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
