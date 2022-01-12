package com.example.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    private static Connection connection;

    public static Connection connect() {
        if (connection == null) {
            try {
                connection =
                        DriverManager.getConnection("jdbc:mysql://localhost/volunteer?" +
                                "user=root&password=root");
            } catch (SQLException ex) {
                // Detailed error output
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        }

        return connection;
    }
}
