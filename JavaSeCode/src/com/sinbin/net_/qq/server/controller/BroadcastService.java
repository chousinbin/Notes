package com.sinbin.net_.qq.server.controller;

import com.sinbin.net_.qq.common.Message;
import com.sinbin.net_.qq.common.MessageType;
import com.sinbin.net_.qq.server.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Set;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/22 19:58
 * @Description:
 */
public class BroadcastService implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.print("请输入推送的消息(exit退出推送服务): ");
            String news = Utility.readString(100);
            if (news.equals("exit")) {
                break;
            }
            // 封装消息
            Message message = new Message();
            message.setMessageType(MessageType.MESSAGE_GROUP_MES);
            message.setSender("Server");
            message.setContent(news);
            message.setSendTime(new Date().toString());
            // 遍历所有用户
            Set<String> users = ManageUser.getKeySet();
            for (String user : users) {
                if (ManageServerThread.isOnline(user)) { // 在线的立即推送
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(ManageServerThread.getThread(user).
                                getSocket().getOutputStream());
                        oos.writeObject(message);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else { // 不在线的暂存服务器
                    ManageOfflineMessage.add(user, message);
                }
            }
        }
    }
}