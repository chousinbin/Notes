package com.sinbin.net_.qq.common;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/19 15:49
 * @Description:
 */
public interface MessageType {
    String MESSAGE_LOGIN_SUCCEED = "1";
    String MESSAGE_LOGIN_FAIL = "0";
    String MESSAGE_PRIVATE_MES = "2"; // 私聊
    String MESSAGE_GROUP_MES = "6"; // 群聊
    String MESSAGE_GET_ONLINE_USER = "3"; // 请求返回在线用户
    String MESSAGE_RET_ONLINE_USER = "4"; // 返回在线用户
    String MESSAGE_CLIENT_EXIT = "5";  // 客户端请求退出
    String MESSAGE_FILE = "7";  // 文件
}
