package com.dip.core.dao;

import com.dip.core.database.JdbcHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDao {
    private static final String USER_ROLE_BY_LOGIN_SQL = "SELECT ROLE FROM USERS WHERE LOGIN = ?";
    private static final String USER_PASSWORD_BY_LOGIN_SQL = "SELECT PASSWORD FROM USERS WHERE LOGIN = ?";
    private static final int BAD_RESULT = -1;

    public void getUsersResultSet () {

    }

    public int getUserRoleByLogin(String login) {
        Connection connection = JdbcHelper.getConnection();
        ResultSet resultSet = null;
        int result = BAD_RESULT;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(USER_ROLE_BY_LOGIN_SQL);
            preparedStatement.setString(1,login);
             resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getInt("ROLE");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getPasswordByLogin(String login) {
        Connection connection = JdbcHelper.getConnection();
        ResultSet resultSet = null;
        String dbPassword = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(USER_PASSWORD_BY_LOGIN_SQL);
            preparedStatement.setString(1,login);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                dbPassword = resultSet.getString("PASSWORD");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbPassword;
    }
}
