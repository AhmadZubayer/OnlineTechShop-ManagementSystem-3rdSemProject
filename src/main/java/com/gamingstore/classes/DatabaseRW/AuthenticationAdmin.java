package com.gamingstore.classes.DatabaseRW;

import com.gamingstore.database.DatabaseConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthenticationAdmin {
    public boolean adminLogIn(String username,String password) {


        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }


        String query = "SELECT * FROM employee WHERE empID = '" + username + "' AND empPassword = '" + password + "'";

        try (Connection connection = DatabaseConfig.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

}
