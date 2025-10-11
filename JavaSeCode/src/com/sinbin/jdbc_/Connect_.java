package com.sinbin.jdbc_;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Connect_ {
    public void type1() {
        // 使用反射加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 获取连接
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "123456";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void type2() {

    }

    public void type4() throws ClassNotFoundException, SQLException {
        // 自动注册驱动
        /*
            static {
                try {
                    DriverManager.registerDriver(new Driver());
                } catch (SQLException var1) {
                    throw new RuntimeException("Can't register driver!");
                }
            }
         */
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 配置信息
        String url = "jdbc:mysql://localhost:3306/mysql_test";
        String user = "root";
        String password = "zxb19990079994...";
        // 获取连接对象
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        // 执行 SQL
        String sql = "insert into users values(null, 'zxb', '23', 'zxb@neu.com')";
        int res = statement.executeUpdate(sql);
        System.out.println(res > 0 ? "成功" : "失败");
        // 关闭连接
        statement.close();
        connection.close();
    }
    @Test
    public void type5() throws ClassNotFoundException, SQLException, IOException {
        // 获取配置信息
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
        String sql = "insert into users values(null, 'xxb', '23', 'xxb@neu.com')";
        int res = statement.executeUpdate(sql);
        System.out.println(res > 0 ? "成功" : "失败");
        // 关闭连接
        statement.close();
        connection.close();
    }
}
