/*
Steps:
1. Payment method is pressed
2. Immediately generate unique cart ID using generateCartID()
3. CartID is inserted into the payment table
4. getFinalPrice gets the final price from the Cart class
5. getPaymentID() gets the Payment ID from the payment table
6. Inserts data into OrderList table
7. Cart is cleared associated with the username in the Cart class
 */


package com.gamingstore.classes;

import com.gamingstore.database.DatabaseConfig;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentFrame extends JFrame {
    private String username;
    private String productList, discountCode;
    private double totalPaid;
    private int cartID;


    public PaymentFrame(String username) {
        this.username = username;
        this.discountCode = Cart.getDiscountCode();


        setTitle("Payment Options");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel titleLabel = new JLabel("Select Payment Method", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton bkashButton = new JButton("Pay with bKash");
        JButton cardButton = new JButton("Pay with Card");
        JButton codButton = new JButton("Cash on Delivery");

        bkashButton.addActionListener(new PaymentActionListener("bkash"));
        cardButton.addActionListener(new PaymentActionListener("card"));
        codButton.addActionListener(new PaymentActionListener("cash on delivery"));


        panel.add(titleLabel);
        panel.add(bkashButton);
        panel.add(cardButton);
        panel.add(codButton);


        add(panel);


        setVisible(true);
    }

    private class PaymentActionListener implements ActionListener {
        private final String paymentMethod;

        public PaymentActionListener(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Cart cart = new Cart();
            cartID = generateCartID();
            insertPayment(cartID, paymentMethod);
            int paymentID = getPaymentID(cartID);
            productList = cart.productList(username);
            totalPaid = cart.getFinalPrice(username, discountCode);
            insertOrder(paymentID, productList, totalPaid);

            try (Connection conn = DatabaseConfig.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT product_id FROM cart WHERE C_USERNAME = ?")) {
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int productId = rs.getInt("product_id");
                    int quantity = getQuantity(username, productId);
                    updateProductQuantity(productId, quantity);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            cart.clearCart();
            new PurchaseConfirmed();
        }


        private int generateCartID() {
        int cartID = 1;
        String query = "SELECT MAX(cartID) AS last_cart_id FROM payment";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                cartID = rs.getInt("last_cart_id") + 1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cartID;
    }

    private void insertPayment(int cartID, String paymentMethod) {
        username = CurrentUser.getCurrentUser();
        Cart cart = new Cart();
        double totalPaid = cart.getFinalPrice(username, discountCode );

        String query = "INSERT INTO payment (cartID, payment_date, payment_method, c_username, totalPaid) VALUES (?,SYSDATE(), ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, cartID);
            stmt.setString(2, paymentMethod);
            stmt.setString(3, username);
            stmt.setDouble(4, totalPaid);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private int getPaymentID(int cartID) {
        int paymentID = 0;
        String query = "SELECT paymentID FROM payment WHERE cartID = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, cartID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                paymentID = rs.getInt("paymentID");
            }

            System.out.println("Payment ID: " + paymentID);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paymentID;
    }

    private void insertOrder(int paymentID, String productList, double totalPaid) {
        String query = "INSERT INTO orderlist (paymentID, C_USERNAME, orderDate, product_list, total_price) VALUES (?, ?, SYSDATE(), ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, paymentID);
            stmt.setString(2, username);
            stmt.setString(3, productList);
            stmt.setDouble(4, totalPaid);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private int getQuantity(String username, int productId) {
        int quantity = 0;
        String query = "SELECT QUANTITY FROM cart WHERE C_USERNAME = ? AND PRODUCT_ID = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setInt(2, productId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                quantity = rs.getInt("quantity");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return quantity;
    }

    private void updateProductQuantity(int productId, int quantity) {
        String updateQuery = "UPDATE products SET AVAILABLE_QUANTITY = AVAILABLE_QUANTITY - ? WHERE PRODUCT_ID = ? AND AVAILABLE_QUANTITY >= ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(updateQuery)) {

            stmt.setInt(1, quantity);
            stmt.setInt(2, productId);
            stmt.setInt(3, quantity);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated == 0) {
                System.out.println("Not enough stock for Product ID: " + productId);
            } else {
                System.out.println("Updated Product ID: " + productId + " by reducing quantity: " + quantity);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PaymentFrame("username");
    }
}
}
