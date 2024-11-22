package com.string_;

import java.util.Arrays;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/12 18:48
 * @Description: 注册格式验证
 */
public class Test02 {
    public static void main(String[] args) {
        try {
            registe("zxb", "123456", "zxb@sinbin.cn");
            System.out.println("注册成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void registe(String name, String pwd, String email) {
        if (name == null || pwd == null || email == null) {
            throw new RuntimeException("检查空字符串");
        }

        int nameLength = name.length();
        if (!(nameLength >= 2 && nameLength <= 4)) {
            throw new RuntimeException("用户名长度 2 ~ 4");
        }

        int pwdLength = pwd.length();
        if (!(pwdLength == 6 && checkPwd(pwd))) {
            throw new RuntimeException("密码格式不对");
        }

        if (!checkMail(email)) {
            throw new RuntimeException("邮箱格式不对");
        }
    }

    public static boolean checkPwd(String s) {
        char[] ch = s.toCharArray();

        for (char c : ch) {
            if (c < '0' || c > '9') {
                return false;
            }
        }

        return true;
    }

    public static boolean checkMail(String s) {
        int atIndexL = s.indexOf('@');
        int atIndexR = s.lastIndexOf('@');
        int pointIndexL = s.indexOf('.');

        if (atIndexL == atIndexR && atIndexL > 0 && pointIndexL - atIndexL > 1) {
            return true;
        } else {
            return false;
        }
    }
}