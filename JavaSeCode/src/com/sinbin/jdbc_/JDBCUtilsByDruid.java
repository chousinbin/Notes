package com.sinbin.jdbc_;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtilsByDruid {
    private static final DataSource ds;
    // DS 初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Paths.get("src/druid.properties")));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            System.err.println("druid.properties 文件加载失败，请检查路径和文件内容！");
            throw new RuntimeException(e);
        }
    }
    // 获取连接对象
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // 关闭连接：并非真正关闭连接，只是把连接对象放回连接池
    public static void close(ResultSet rs, Statement st, Connection connection) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}