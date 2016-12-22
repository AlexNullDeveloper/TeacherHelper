package com.dip.core.database;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Юрий on 22.12.2016.
 */
public class JdbcHelperTest {

    @Test
    public void checkConnection() throws SQLException {
        Connection connection = JdbcHelper.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT USER FROM DUAL");
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("resultset result " + resultSet.getString(1));
        }
    }

}
