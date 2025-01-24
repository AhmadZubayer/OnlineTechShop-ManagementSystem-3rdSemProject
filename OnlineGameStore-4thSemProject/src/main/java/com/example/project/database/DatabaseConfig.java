package com.example.project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/techshopjava";
    private static final String USER = "TechShopJava";
    private static final String PASSWORD = "TechShopJava4th";
    private static final Logger LOGGER = Logger.getLogger(DatabaseConfig.class.getName());

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            LOGGER.info("Connected to the database successfully!");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to create the database connection.", e);
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                LOGGER.info("Database connection closed successfully.");
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Failed to close the database connection.", e);
            }
        }
    }
}