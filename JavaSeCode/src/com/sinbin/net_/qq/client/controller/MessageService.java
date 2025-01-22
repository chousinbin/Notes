package com.sinbin.net_.qq.client.controller;

import com.sinbin.net_.qq.client.utils.Utility;
import com.sinbin.net_.qq.common.Message;
import com.sinbin.net_.qq.common.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLOutput;
import java.util.Date;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/22 12:58
 * @Description:
 */
public class MessageService {
    /**
     *
     * @param sender 发送者ID
     */
    public void sendPrivateMessage(String sender) {
        System.out.print("请输入接收者的ID(在线): ");
        String receiver = Utility.readString(10);
        System.out.print("请输入发送的消息: ");
        String content = Utility.readString(100);

        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_PRIVATE_MES);
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(content);
        message.setSendTime(new Date().toString());

        System.out.println("\n" + message.getSender() + "(" + message.getSendTime() + "):");
        System.out.println(message.getContent());

        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.
                    query(sender).getSocket().getOutputStream());
            oos.writeObject(message);
                    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendGroupMessage(String sender) {
        System.out.print("请输入发送的消息: ");
        String content = Utility.readString(100);

        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_GROUP_MES);
        message.setSender(sender);
        message.setContent(content);
        message.setSendTime(new Date().toString());

        System.out.println("\n" + message.getSender() + "(" + message.getSendTime() + "):");
        System.out.println(message.getContent());

        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.
                    query(sender).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
