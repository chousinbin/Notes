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
public class UDP01HostB {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9998);
        // 发送
        byte[] data = "hello\nUDP B".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(
                data, data.length,
                InetAddress.getLocalHost(), 9999);
        datagramSocket.send(datagramPacket);
        // 接收
        byte[] buffer = new byte[64 * 1024]; // UDP 数据报最大 64KB
        datagramPacket = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(datagramPacket);
        int length = datagramPacket.getLength(); // 数据实际长度
        data = datagramPacket.getData();
        System.out.println(new String(data, 0, length));
        // 关闭资源
        datagramSocket.close();
    }
}
