/*package com.gamingstore.classes;

import com.gamingstore.database.DatabaseConfig;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.gamingstore.classes.UIDesign.TableDesign.createTable;

public class OrderDetailsFrame extends JFrame {
    public OrderDetailsFrame(int paymentID) {
        setTitle("Order Details");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#1d2a35"));
        setLayout(new BorderLayout());

        JScrollPane tableScrollPane = viewProductList(paymentID);
        add(tableScrollPane, BorderLayout.CENTER);
    }

    public JScrollPane viewProductList(int paymentID) {
        ArrayList<String[]> productList = new ArrayList<>();
        String query = "SELECT p.PRODUCT_ID, p.PRODUCT_NAME, c.quantity " +
                "FROM c_product_list c " +
                "JOIN products p ON c.productID = p.PRODUCT_ID " +
                "WHERE c.paymentID = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, paymentID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String productId = String.valueOf(rs.getInt("PRODUCT_ID"));
                String productName = rs.getString("PRODUCT_NAME");
                String quantity = String.valueOf(rs.getInt("quantity"));

                productList.add(new String[]{productId, productName, quantity});
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading product data: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            return new JScrollPane(new JTable());
        }

        String[][] data = productList.toArray(new String[0][0]);
        String[] columnNames = {"Product ID", "Product Name", "Quantity"};
        return createTable(data, columnNames);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OrderDetailsFrame(13).setVisible(true));
    }
}*/
