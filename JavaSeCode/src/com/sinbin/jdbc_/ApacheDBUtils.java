package com.sinbin.jdbc_;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApacheDBUtils {
    @Test
    public void dateToArrayList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Account> accounts = new ArrayList<>();

        connection = JDBCUtilsByDruid.getConnection();
        String sql = "select * from account";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double balance = resultSet.getDouble(3);
                accounts.add(new Account(id, name, balance));
            }
            System.out.println(accounts);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        }
    }

    // 使用 Apache DBUtils + Druid
    @Test
    public void apacheQuery() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from account where id >= ?";
        // 执行查询，返回结果集封装到集合
        List<Account> list = queryRunner.query(connection, sql, new BeanListHandler<>(Account.class), 0);
        for (Account account : list) {
            System.out.println(account);
        }
        JDBCUtilsByDruid.close(null, null, connection);
    }
    // 使用 Apache DBUtils + Druid
    // 返回的结果是单条对象
    @Test
    public void apacheQuerySingleResult() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from account where id = ?";
        // 执行查询
        Account account = queryRunner.query(connection, sql,
                new BeanHandler<>(Account.class), 1);

        System.out.println(account);

        JDBCUtilsByDruid.close(null, null, connection);
    }
    // 使用 Apache DBUtils + Druid
    // 返回的结果是单条对象，且单列数据
    @Test
    public void apacheQuerySingleColumn() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select name from account where id = ?";
        // 执行查询
        Object obj = queryRunner.query(connection, sql,
                new ScalarHandler(), 2);

        System.out.println(obj);

        JDBCUtilsByDruid.close(null, null, connection);
    }
    @Test
    public void update() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update account set balance = ? where id = ?";
        // 执行更新，返回受影响的行数
        int affectedRow = queryRunner.update(connection, sql, 999.9, 1);
        System.out.println(affectedRow > 0 ? "执行成功" : "没有影响数据库");

        JDBCUtilsByDruid.close(null, null, connection);
    }
    @Test
    public void insert() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into account values(null, ?, ?)";
        // 执行更新，返回受影响的行数
        int affectedRow = queryRunner.update(connection, sql, "zxb", "100");
        System.out.println(affectedRow > 0 ? "执行成功" : "没有影响数据库");

        JDBCUtilsByDruid.close(null, null, connection);
    }
    @Test
    public void delete() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "delete from account where id = ?";
        // 执行更新，返回受影响的行数
        int affectedRow = queryRunner.update(connection, sql, 3);
        System.out.println(affectedRow > 0 ? "执行成功" : "没有影响数据库");

        JDBCUtilsByDruid.close(null, null, connection);
    }
}
