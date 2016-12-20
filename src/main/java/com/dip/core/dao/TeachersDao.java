package com.dip.core.dao;

import com.dip.core.database.JdbcHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Юрий on 30.10.2016.
 */
public class TeachersDao {
    private static final String TEACHERS_AGREED_SQL = "SELECT F_NAME, I_NAME, O_NAME, PHONE FROM TEACHERS WHERE IS_AGREED = 1";
    private static final String TEACHERS_NOT_AGREED_SQL = "SELECT F_NAME, I_NAME, O_NAME, PHONE FROM TEACHERS WHERE IS_AGREED = 0";
    private static final String UPDATE_TEACHERS_AGREED_SQL = "UPDATE TEACHERS SET IS_AGREED = 1 WHERE PHONE = ?";


    public ResultSet getAgreedTeachers() {
        Connection connection = JdbcHelper.getConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(TEACHERS_AGREED_SQL);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getNotAgreedTeachers() {
        Connection connection = JdbcHelper.getConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(TEACHERS_NOT_AGREED_SQL);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void updateTeacherAgreedStatus(String phone) {
        Connection connection = JdbcHelper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TEACHERS_AGREED_SQL);
            preparedStatement.setString(1, phone);
            int countRows = preparedStatement.executeUpdate();
            System.out.println("countRows" + countRows);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {

                }
            }
        }

    }
}
