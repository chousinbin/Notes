package com.sinbin.net_.homework;

import java.io.IOException;
import java.net.*;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/18 14:13
 * @Description:
 */
public class Sender01 {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8889);

        byte[] question = "四大名著是那些".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(question, question.length,
                InetAddress.getLocalHost(), 8888);

        datagramSocket.send(datagramPacket);

        byte[] buffer = new byte[64 * 1024];
        datagramPacket = new DatagramPacket(buffer, buffer.length);

        datagramSocket.receive(datagramPacket);

        byte[] data = datagramPacket.getData();
        int length = datagramPacket.getLength();
        System.out.println(new String(data, 0, length));

        datagramSocket.close();
    }
}
