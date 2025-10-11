package com.sinbin.jdbc_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class PrepareStatement_ {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        // 获取用户参数
        Scanner scanner = new Scanner(System.in);
        String adminName = scanner.nextLine();
        String adminPassword = scanner.nextLine();
        // 读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/sinbin/jdbc_/mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        // 注册驱动
        Class.forName(driver);
        // 获取连接对象
        Connection connection = DriverManager.getConnection(url, user, password);
        // 获取 PreparedStatement
        String sql = "select * from admin where name = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 设置参数
        preparedStatement.setString(1, adminName);
        preparedStatement.setString(2, adminPassword);
        // 结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("用户存在");
        } else {
            System.out.println("用户不存在");
        }
        // 关闭连接
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
