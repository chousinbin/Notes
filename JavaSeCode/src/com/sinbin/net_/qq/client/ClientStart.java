package com.sinbin.net_.qq.client;

import com.sinbin.net_.qq.client.view.Menu;

import java.io.IOException;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/19 23:53
 * @Description:
 */
public class ClientStart {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Menu().showLogin();
    }
}
