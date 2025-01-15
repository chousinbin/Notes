package com.net_;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/11 18:51
 * @Description:
 */
public class InetAddress_ {
    public static void main(String[] args) throws UnknownHostException {
        // 获取主机名和主机 IP
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        // 根据主机名/域名获取 InetAddress 对象
        InetAddress host1 = InetAddress.getByName("Sinbin-Win10");
        System.out.println(host1);

        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);

        // 通过 InetAddress 对象获取 IP
        String hostAddress = localHost.getHostAddress();
        System.out.println(hostAddress);

        System.out.println(localHost.getHostName());
    }
}
