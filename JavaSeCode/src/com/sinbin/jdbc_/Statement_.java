package com.sinbin.jdbc_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Statement_ {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
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
        Statement statement = connection.createStatement();
        // 获取用户参数
        /*
            1' OR
            OR '1' = '1
         */
        Scanner scanner = new Scanner(System.in);
        String adminName = scanner.nextLine();
        String adminPassword = scanner.nextLine();
        // 执行 SQL
        String sql = "select * from admin where name = '" + adminName + "' and password = '" + adminPassword + "'";
        // 结果集
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            System.out.println("用户存在");
        } else {
            System.out.println("用户不存在");
        }
        // 关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
