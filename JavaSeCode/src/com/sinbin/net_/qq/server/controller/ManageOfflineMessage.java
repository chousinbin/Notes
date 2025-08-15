package com.sinbin.net_.qq.server.controller;

import com.sinbin.net_.qq.common.Message;

import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/22 20:24
 * @Description:
 */
public class ManageOfflineMessage {
    private static ConcurrentHashMap<String, Vector<Message>> offlineMessages = new ConcurrentHashMap<>(); // 线程安全

    public static void add(String userId, Message message) {
        Vector<Message> messages;
        if (offlineMessages.get(userId) == null) {
            messages = new Vector<>();
        } else {
           messages = offlineMessages.get(userId);
        }
        messages.add(message);
        offlineMessages.put(userId, messages);
    }

    public static Set<String> getKeySet() {
        return offlineMessages.keySet();
    }

    public static boolean isEmpty(String userId) {
        return offlineMessages.get(userId) == null;
    }

    public static Vector<Message> getMessages(String userId) {
        return offlineMessages.get(userId);
    }

    public static void clear(String userId) {
        offlineMessages.remove(userId);
    }
}