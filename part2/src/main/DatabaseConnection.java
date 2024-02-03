package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/gradingSystem";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    public static Connection getConnection() {

        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                System.err.println("Error connecting to the database: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing the database connection: " + e.getMessage());
            }
        }
    }
}

