package com.zhouxinbin.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MySQL 数据库工具类
 * 提供数据库连接、CRUD操作和常用工具方法
 */
public class DBUtils {

    // 数据库连接信息
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mysql_test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "zxb19990079994...";

    // 静态代码块，加载数据库驱动
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("加载MySQL驱动失败: " + e.getMessage());
        }
    }

    /**
     * 获取数据库连接
     * @return Connection对象
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("获取数据库连接失败: " + e.getMessage());
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     * @param conn 数据库连接
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("关闭数据库连接失败: " + e.getMessage());
            }
        }
    }

    /**
     * 关闭Statement
     * @param stmt Statement对象
     */
    public static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.err.println("关闭Statement失败: " + e.getMessage());
            }
        }
    }

    /**
     * 关闭ResultSet
     * @param rs ResultSet对象
     */
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.err.println("关闭ResultSet失败: " + e.getMessage());
            }
        }
    }

    /**
     * 关闭所有数据库资源
     * @param conn 连接
     * @param stmt Statement
     * @param rs ResultSet
     */
    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        closeResultSet(rs);
        closeStatement(stmt);
        closeConnection(conn);
    }

    /**
     * 执行查询SQL，返回结果集
     * @param sql SQL语句
     * @param params 参数列表
     * @return ResultSet结果集
     */
    public static ResultSet executeQuery(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            // 设置参数
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

            rs = pstmt.executeQuery();
            // 注意：调用者需要负责关闭ResultSet
            return rs;
        } catch (SQLException e) {
            System.err.println("执行查询失败: " + e.getMessage());
            closeAll(conn, pstmt, rs);
            return null;
        }
    }

    /**
     * 执行更新SQL（INSERT, UPDATE, DELETE）
     * @param sql SQL语句
     * @param params 参数列表
     * @return 受影响的行数
     */
    public static int executeUpdate(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            // 设置参数
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("执行更新失败: " + e.getMessage());
            return -1;
        } finally {
            closeAll(conn, pstmt, null);
        }
    }

    /**
     * 查询单条记录，返回Map
     * @param sql SQL语句
     * @param params 参数列表
     * @return 包含字段名和值的Map
     */
    public static Map<String, Object> queryForMap(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            // 设置参数
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

            rs = pstmt.executeQuery();
            if (rs.next()) {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                Map<String, Object> map = new HashMap<>();

                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i);
                    Object value = rs.getObject(i);
                    map.put(columnName, value);
                }

                return map;
            }
            return null;
        } catch (SQLException e) {
            System.err.println("查询单条记录失败: " + e.getMessage());
            return null;
        } finally {
            closeAll(conn, pstmt, rs);
        }
    }

    /**
     * 查询多条记录，返回List<Map>
     * @param sql SQL语句
     * @param params 参数列表
     * @return 包含多条记录的List
     */
    public static List<Map<String, Object>> queryForList(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Map<String, Object>> resultList = new ArrayList<>();

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            // 设置参数
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

            rs = pstmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i);
                    Object value = rs.getObject(i);
                    map.put(columnName, value);
                }
                resultList.add(map);
            }

            return resultList;
        } catch (SQLException e) {
            System.err.println("查询多条记录失败: " + e.getMessage());
            return null;
        } finally {
            closeAll(conn, pstmt, rs);
        }
    }
}
