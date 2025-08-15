package com.sinbin.net_.qq.server.controller;

import com.sinbin.net_.qq.common.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.util.Vector;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/22 20:43
 * @Description:
 */
public class OfflineMessageService implements Runnable{
    @Override
    public void run() {
        while (true) {
            Set<String> users = ManageServerThread.getKeySet(); // 当前在线用户
            for (String user : users) {
                if (ManageOfflineMessage.isEmpty(user)) { // 当前在线用户无离线消息
                    continue;
                }
                Vector<Message> messages = ManageOfflineMessage.getMessages(user);
                for (Message message : messages) {
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(ManageServerThread.
                                getThread(user).getSocket().getOutputStream());
                        oos.writeObject(message);
                        oos.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                ManageOfflineMessage.clear(user);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
