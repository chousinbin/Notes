package com.SinbinZhou.JavaLab.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @ClassName: JDBCTest
 * @UserName: SinBin
 * @date: 2023-07-06 12:23
 * @Description:JDBC快速入门
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取MySQL连接
        String url = "jdbc:mysql://127.0.0.1:3306/db01";
        String username = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url, username, password);
        //定义SQL语句
        String sql = "update users set address = 'DL' where id = 1";
        //创建执行SQL语句对象
        Statement stat = conn.createStatement();
        //发送SQL语句并接收结果
        int count = stat.executeUpdate(sql);  //受影响行数的返回值
        //处理返回结果
        System.out.println(count);
        //释放资源
        stat.close();
        conn.close();
    }
}
