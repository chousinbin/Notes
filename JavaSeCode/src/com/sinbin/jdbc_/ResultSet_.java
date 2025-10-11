package com.sinbin.jdbc_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ResultSet_ {
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
        // 执行 SQL
        String sql = "select * from users";
        // 结果集
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            // 可以使用列序号，也可以使用列名
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt("age");
            String mail = resultSet.getString(3);
            System.out.println(id + " " + name + " " + age + " " + mail);
        }
        // 关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
