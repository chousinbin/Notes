package com.sinbin.net_.udp_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/16 21:11
 * @Description:
 */
public class UDP01HostA {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        // 创建 buffer
        byte[] buffer = new byte[64 * 1024]; // UDP 数据报最大 64KB
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
        // 接收数据报，未收到会阻塞
        datagramSocket.receive(datagramPacket);
        // 拆包
        int length = datagramPacket.getLength(); // 数据实际长度
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data, 0, length));

        // 回复
        data = "hello\nUDP A".getBytes();
        // 装包
        datagramPacket = new DatagramPacket(
                data, data.length,
                InetAddress.getLocalHost(), 9998);

        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
