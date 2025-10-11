package com.sinbin.jdbc_;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch_ {
    @Test
    public void defaultMode() throws SQLException {
        Connection connection = Utils.getConnection();
        String sql = "insert into admin2 values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "zxb" + i);
            preparedStatement.setString(2, "123");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("普通耗时 " + (end - start)); //513
        Utils.close(null, preparedStatement, connection);
    }
    @Test
    public void batchMode() throws SQLException {
        Connection connection = Utils.getConnection();
        String sql = "insert into admin2 values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "zxb" + i);
            preparedStatement.setString(2, "123");
            preparedStatement.addBatch();
            // 每 1000 执行一次
            if ((i + 1) % 1000 == 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("批处理耗时 " + (end - start)); //55
        Utils.close(null, preparedStatement, connection);
    }
}
