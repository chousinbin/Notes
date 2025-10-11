package com.sinbin.jdbc_;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilsUsed {
    public static void main(String[] args) {
        Connection connection = Utils.getConnection();
        String sql = "select * from admin";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Utils.close(resultSet, preparedStatement, connection);
        }
    }
}
