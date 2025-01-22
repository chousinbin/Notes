package com.sinbin.net_.qq.client.view;

import com.sinbin.net_.qq.client.controller.ManageClientConnectServerThread;
import com.sinbin.net_.qq.client.controller.MessageService;
import com.sinbin.net_.qq.client.controller.UserService;
import com.sinbin.net_.qq.client.utils.Utility;

import java.io.IOException;

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
    private UserService userService = new UserService(); // 登录服务
    private MessageService messageService = new MessageService(); // 消息服务
    public void showLogin() throws IOException, ClassNotFoundException {
        while (loginLoop) {
            System.out.println("========网络通信系统-登录界面========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择: ");

            option = Utility.readString(1);

            switch (option) {
                case "1":
                    MenuLoop = true;
                    System.out.print("UserID: ");
                    String userId = Utility.readString(10);
                    System.out.print("UserPwd: ");
                    String userPwd = Utility.readString(20);

                    if (userService.checkUser(userId, userPwd)) {
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
                    System.out.println("获取在线用户...");
                    userService.getOnlineUser();
                    break;
                case "2":
                    System.out.println("消息群发：");
                    break;
                case "3":
                    messageService = new MessageService();
                    messageService.sendPrivateMessage(userId);
                    break;
                case "4":
                    System.out.println("发送文件：");
                    break;
                case "9": // 输入 9 之后，未处理线程，导致程序不能结束
                    System.out.println("退出登录...");
                    MenuLoop = false;
                    // 告诉服务器释放本账号相关线程和 Socket
                    userService.clientExit();
                    break;
            }
        }
    }
}
