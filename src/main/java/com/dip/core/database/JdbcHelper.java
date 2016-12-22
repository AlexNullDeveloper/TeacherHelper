package com.dip.core.database;

import java.sql.*;
import java.util.Locale;

public class JdbcHelper {

    private static final String DB_URL = "jdbc:oracle:thin:@talismanov-pc:1521/XE";
    private static final String DB_USER_LOGIN = "HACKATON";
    private static final String DB_USER_PASSWORD = "HACKATON";

    public static Connection getConnection() {

        Locale.setDefault(new Locale("en", "US"));
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(DB_URL, DB_USER_LOGIN, DB_USER_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return connection;
    }
}