package com.sinbin.net_.qq.server.controller;

import com.sinbin.net_.qq.common.Message;
import com.sinbin.net_.qq.common.MessageType;
import com.sinbin.net_.qq.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/19 18:18
 * @Description:
 */
public class QQServer {
    private ServerSocket serverSocket = null;
    private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>(); // 线程安全
    // 静态代码块自动初始化
    static {
        validUsers.put("10001", new User("10001", "123456"));
        validUsers.put("10002", new User("10002", "123456"));
        validUsers.put("10003", new User("10001", "123456"));
    }

     public QQServer(){
        try {
            serverSocket = new ServerSocket(9999);
            // 服务器广播服务
            new Thread(new BroadcastService()).start();

            while (true) {
                Socket socket = serverSocket.accept();

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User user = (User)ois.readObject();

                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Message message = new Message();
                // 检查账户密码
                if (checkUser(user.getUserId(), user.getUserPwd())) {
                    System.out.println(user.getUserId() + " 登陆成功");
                    message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
                    // 创建一个线程，与客户端保持通信
                    ServerConnectClientThread thread = new ServerConnectClientThread(socket, user.getUserId());
                    thread.start();
                    // 添加到线程集合
                    ManageServerThread.addThread(user.getUserId(), thread);
                } else {
                    System.out.println(user.getUserId() + " 登陆失败");
                    message.setMessageType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    // 登录失败关闭 Socket
                    socket.close();
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean checkUser(String userId, String userPwd) {
        User user = validUsers.get(userId);
        if (user == null) {
            return false;
        }
        if (!user.getUserPwd().equals(userPwd)) {
            return false;
        }
        return true;
    }
}
