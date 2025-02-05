package com.gamingstore.classes.DatabaseRW;


import com.gamingstore.database.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCartID {

    public static int getCartID(String username) {
        int cartID = -1;
        try (Connection conn = DatabaseConfig.getConnection()) {
            String query = "SELECT Cart_ID FROM cart WHERE C_USERNAME = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    cartID = rs.getInt("cartID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartID;
    }
}

