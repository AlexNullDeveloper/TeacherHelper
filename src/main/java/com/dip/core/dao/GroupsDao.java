package com.dip.core.dao;

import com.dip.core.database.JdbcHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Юрий on 30.10.2016.
 */
public class GroupsDao {

    private static final String GET_GROUPS_BY_ID_SQL = "select GROUP_NAME FROM GROUPS where FAC_ID = (\n" +
            "select id from faculties where name = ?)";

    public ResultSet getGroupsByFacId (String facultyName) {
        Connection connection = JdbcHelper.getConnection();
        ResultSet resultSet = null;
       try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_GROUPS_BY_ID_SQL);
            preparedStatement.setString(1, facultyName);
            resultSet = preparedStatement.executeQuery();
       } catch (SQLException e) {
            e.printStackTrace();
       }
        return resultSet;
    }
}
