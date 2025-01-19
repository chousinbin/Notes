package com.sinbin.net_.qq.common;

import java.io.Serializable;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/19 15:43
 * @Description:
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;
    private String userPwd;
    public User() {}

    public User(String userId, String userPwd) {
        this.userId = userId;
        this.userPwd = userPwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
