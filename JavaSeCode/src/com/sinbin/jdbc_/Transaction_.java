package com.sinbin.jdbc_;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transaction_ {
    public static void main(String[] args) {
        String sql1 = "update account set balance = balance - 100 where id = ?";
        String sql2 = "update account set balance = balance + 100 where id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Utils.getConnection();
            // 关闭默认自动提交，开启事务
            connection.setAutoCommit(false);
            // 转账 1
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setDouble(1, 1);
            preparedStatement.executeUpdate();
            // 转账 2
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setDouble(1, 2);
            preparedStatement.executeUpdate();
            // 提交事务
            connection.commit();
        } catch (SQLException e) {
            try {
                // 默认回滚到事务开启时
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            Utils.close(resultSet, preparedStatement, connection);
        }
    }
}