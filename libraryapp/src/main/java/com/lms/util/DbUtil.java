package com.lms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    
    private static final String url = "jdbc:mysql://localhost:3306/library_db?useSSL=false";
    private static final String username = "root";
    private static final String password = "Pulkit@2006";

    // This static block runs automatically inside Tomcat!
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}