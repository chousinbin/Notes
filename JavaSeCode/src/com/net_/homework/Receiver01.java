package com.net_.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/18 14:13
 * @Description:
 */
public class Receiver01 {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);

        byte[] buffer = new byte[64 * 1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

        datagramSocket.receive(datagramPacket);

        byte[] data = datagramPacket.getData();
        int length = datagramPacket.getLength();
        String str = new String(data, 0, length);

        byte[] ret;
        if (str.equals("四大名著是那些")) {
            ret = "四大名著是《红楼梦》...".getBytes();
        } else {
            ret = "what".getBytes();
        }

        datagramPacket = new DatagramPacket(ret, ret.length,
                InetAddress.getLocalHost(), 8889);
        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
