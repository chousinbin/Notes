package com.sinbin.net_.qq.client.controller;

import com.sinbin.net_.qq.client.utils.StreamUtil;
import com.sinbin.net_.qq.client.utils.Utility;
import com.sinbin.net_.qq.common.Message;
import com.sinbin.net_.qq.common.MessageType;

import java.io.*;
import java.util.Date;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/22 15:58
 * @Description:
 */
public class FileService {
    public void sendFile(String sender) {
        System.out.print("请输入接收者ID: ");
        String receiver = Utility.readString(10);
        System.out.print("请输入文件路径: ");
        String filePath = Utility.readString(100);
        // 读取文件
        if (!new File(filePath).exists()) {
            System.out.println("文件不存在");
            return;
        }
        byte[] fileBytes;
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
            fileBytes = StreamUtil.streamToByteArray(bis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 设置消息对象
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_FILE);
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setSendTime(new Date().toString());
        message.setContent(fileName(filePath));
        message.setFilebytes(fileBytes);
        message.setFileLen(fileBytes.length);
        // 将消息对象写入到对象流
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.query(sender).
                    getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(message.getSender() + "(" + message.getSendTime() + "): " +
                message.getContent());
    }

    public void saveFile(Message message) {
//        System.out.print("请输入保存的路径(以\\结尾): ");
//        String savePath = Utility.readString(100);
        String savePath = "D:\\QQDownload\\";
        byte[] fileBytes = message.getFilebytes();
        int fileLen = message.getFileLen();
        String fileName = message.getContent();

        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(savePath + fileName));
            bos.write(fileBytes);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("文件成功保存在: " + savePath + fileName);
    }

    public String fileName(String filepath) {
        String[] split = filepath.split("\\\\");
        return split[split.length - 1];
    }
}
