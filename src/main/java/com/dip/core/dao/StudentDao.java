package com.dip.core.dao;

import com.dip.core.database.JdbcHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Юрий on 30.10.2016.
 */
public class StudentDao {
    private static final String GET_STUDENTS_SQL = "select STUDENT_FIO FROM STUDENTS WHERE GROUP_ID = (SELECT ID FROM GROUPS WHERE GROUP_NAME = ?)";

    public ResultSet getStudentsByGroup (String groupName) {
        Connection connection = JdbcHelper.getConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_STUDENTS_SQL);
            preparedStatement.setString(1, groupName);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
