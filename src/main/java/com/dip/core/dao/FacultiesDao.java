package com.dip.core.dao;

import com.dip.core.database.JdbcHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Юрий on 30.10.2016.
 */
public class FacultiesDao {
    private static final String SELECT_FACULTIES_SQL = "SELECT VUZ, NAME FROM FACULTIES";
    public ResultSet getFaculties() {
        Connection connection = JdbcHelper.getConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FACULTIES_SQL);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
