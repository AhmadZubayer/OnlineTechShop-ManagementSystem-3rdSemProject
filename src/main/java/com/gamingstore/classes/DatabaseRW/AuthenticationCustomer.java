package com.gamingstore.classes.DatabaseRW;

import com.gamingstore.database.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationCustomer {
    public boolean customerLogIn(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }

        String query = "SELECT * FROM customer WHERE C_USERNAME = ? AND PASSWORD = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, username);
            pst.setString(2, password);

            try (ResultSet rs = pst.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}

