package com.sinbin.net_.qq.client.view;

import com.sinbin.net_.qq.client.utils.Utility;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/19 15:57
 * @Description:
 */
public class Menu {
    private boolean loginLoop = true;
    private boolean MenuLoop = true;
    private String option;
    private void showLogin() {
        while (loginLoop) {
            System.out.println("========网络通信系统-登录界面========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择: ");

            option = Utility.readString(1);

            switch (option) {
                case "1":
                    System.out.print("UserID: ");
                    String userId = Utility.readString(10);
                    System.out.print("UserPwd: ");
                    String userPwd = Utility.readString(20);

                    if (true) {
                        System.out.println("登录成功");
                        showMenu(userId);
                    } else {
                        System.out.println("登录失败");
                    }
                    break;
                case "9":
                    loginLoop = false;
                    break;
            }
        }
    }

    private void showMenu(String userId) {
        while (MenuLoop) {
            System.out.println("========网络通信系统-登录界面(" + userId + ")========");
            System.out.println("\t\t 1 在线用户");
            System.out.println("\t\t 2 消息群发");
            System.out.println("\t\t 3 消息私聊");
            System.out.println("\t\t 4 发送文件");
            System.out.println("\t\t 9 退出登录");
            option = Utility.readString(1);
            switch (option) {
                case "1":
                    System.out.println("在线用户：");
                    break;
                case "2":
                    System.out.println("消息群发：");
                    break;
                case "3":
                    System.out.println("消息私聊：");
                    break;
                case "4":
                    System.out.println("发送文件：");
                    break;
                case "9":
                    System.out.println("退出系统：");
                    MenuLoop = false;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new Menu().showLogin();
        System.out.println("退出客户端...");
    }
}
