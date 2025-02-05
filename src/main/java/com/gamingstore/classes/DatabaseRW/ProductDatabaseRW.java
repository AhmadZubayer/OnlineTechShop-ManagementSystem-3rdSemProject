package com.gamingstore.classes.DatabaseRW;

import com.gamingstore.database.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDatabaseRW {
    public static String getPriceFromDatabase(String Product_ID) {
        String price = null;
        String query = "SELECT PRICE FROM products WHERE PRODUCT_ID = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, Product_ID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                price = resultSet.getString("price");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return price;
    }

    public static String getNameFromDatabase(String Product_ID) {
        String productName = null;
        String query = "SELECT PRODUCT_NAME FROM products WHERE PRODUCT_ID = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, Product_ID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                productName = resultSet.getString("product_name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productName;
    }
}
