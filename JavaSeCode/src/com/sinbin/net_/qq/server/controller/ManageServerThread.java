package com.sinbin.net_.qq.server.controller;

import java.util.HashMap;
import java.util.Set;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/19 18:35
 * @Description: 管理服务端线程
 */
public class ManageServerThread {
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    public static void addThread(String userId, ServerConnectClientThread thread) {
        hm.put(userId, thread);
    }

    public static ServerConnectClientThread getThread(String userId) {
        return hm.get(userId);
    }

    public static String getOnlineUserList() {
        String res = "";
        Set<String> keySet = hm.keySet();
        for (String key : keySet) {
            res += key + " ";
        }
        return res;
    }

    public static void removeThread(String userId) {
        hm.remove(userId);
    }
}
