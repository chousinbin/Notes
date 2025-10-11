package com.sinbin.jdbc_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Utils {
    private static String user;
    private static String password;
    private static String url;
    private static String driver;
    // 获取配置文件信息
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/com/sinbin/jdbc_/mysql.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            // 将编译异常转为运行异常
            // 调用者可以捕获异常，也可以默认处理异常
            throw new RuntimeException(e);
        }
    }
    // 获取连接
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // 关闭资源
    public static void close(ResultSet rs, Statement st, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
