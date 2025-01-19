package com.sinbin.net_.qq.client.controller;

import java.util.HashMap;
import java.util.Set;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/19 17:48
 * @Description: 管理线程
 */
public class ManageClientConnectServerThread {
    /**
     * @ paras String 用户ID
     */
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    public static void add(String userId, ClientConnectServerThread thread) {
        hm.put(userId, thread);
    }

    public static ClientConnectServerThread query(String userId) {
        return hm.get(userId);
    }
    // 试图关闭所有线程
    public static void closeAllThread() {
        Set keySet = hm.keySet();
        for (Object key : keySet) {
            ClientConnectServerThread thread = hm.get(key);
            thread.stop();
        }
    }
}
