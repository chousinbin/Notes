package com.sinbin.net_.qq.server.controller;

import com.sinbin.net_.qq.common.User;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/22 20:11
 * @Description:
 */
public class ManageUser {
    private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>(); // 线程安全
    static {
        validUsers.put("10001", new User("10001", "123456"));
        validUsers.put("10002", new User("10002", "123456"));
        validUsers.put("10003", new User("10003", "123456"));
        validUsers.put("10004", new User("10004", "123456"));
    }
    public static Set<String> getKeySet() {
        return validUsers.keySet();
    }

    public static User getUser(String userId) {
        return validUsers.get(userId);
    }

    public static boolean checkPwd(String userId, String userPwd) {
        User user = validUsers.get(userId);
        if (user == null) {
            return false;
        }
        return user.getUserPwd().equals(userPwd);
    }
}
