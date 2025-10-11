package com.sinbin.jdbc_;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class C3P0_ {
    @Test
    public void noPool() throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = Utils.getConnection();
            Utils.close(null, null, connection);
        }
        System.out.println(System.currentTimeMillis() - start); //39589

    }
    @Test
    public void C3P0Mode1() throws Exception {
        // 创建数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        // 获取配置信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/sinbin/jdbc_/mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        // 给数据源设置相关参数
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        // 初始连接数
        comboPooledDataSource.setInitialPoolSize(10);
        // 最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        long start = System.currentTimeMillis();
        // 获取连接
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        System.out.println(System.currentTimeMillis() - start); //318
    }
    @Test
    // 使用配置文件
    public void C3P0Mode2() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("zxb_c3p0");
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("success");
        connection.close();
    }
}
