/*
Ahmad Zubayer
CartUI(): Connects to the main design of the cart
addToCart(): Adds selected products to the cart
viewCart(): view Cart
clearCart(): Clear cart table associated with the username
getFinalPrice(): Retrieves the final price
getDiscountPercentage(): gets the discount percentage using discount code string from database (if any)
recalculatePrice(): calculates price after discount is applied
productList(): converts all products added to the cart associated with the username and their quantity into a single String. 
getDiscountCode(): A helper method for the PaymentFrame class to use the getFinalPrice() method to insert data into OrderList table.
 */

package com.gamingstore.classes;

import com.gamingstore.classes.DatabaseRW.GetCartID;
import com.gamingstore.classes.UIDesign.CartUI;
import com.gamingstore.classes.UIDesign.TableDesign;
import com.gamingstore.classes.UIDesign.UIDesign;
import com.gamingstore.database.DatabaseConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cart implements ActionListener {

    JFrame frmCart;
    JPanel pnlCartLeft, pnlCartRight;
    JButton paymentBtn, backBtn, continueShoppingBtn, clearCartBtn, applyDiscountBtn;
    JLabel enterDiscountCodeLbl, cartTitle, pricelbl, vatlbl,  finalPriceLabel;
    private String username;
    String FinalPrice, discountCode;
    static JTextField discountCodeField;
    double discountPercentage;

    //public int cartID;

    public Cart() {
        this.username = CurrentUser.getCurrentUser();

    }

    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.CartUI();
    }

    public void CartUI() {
        frmCart = CartUI.frmDesign("CART", 1000, 800);
        pnlCartLeft = CartUI.pnlDesign(frmCart, "#1d2a35", 0, 0, 650, 800);
        pnlCartRight = CartUI.pnlDesign(frmCart, "#15202b", 650, 0, 350, 800);
        frmCart.setLocationRelativeTo(null);

        cartTitle = UIDesign.addlbl(pnlCartLeft, "YOUR CART" , "#ffffff", 28, 20, 8, 200, 60);
        backBtn = UIDesign.backBtnDesign(pnlCartLeft, 10, 700);
        enterDiscountCodeLbl = UIDesign.addlbl(pnlCartLeft, "Enter Discount Code: ", "#fcfcfc",17 , 360, 630, 250, 30);
        discountCodeField = UIDesign.textBar(pnlCartLeft, "Discount Code", "#CD1C35", 360, 660, 250, 35);
        applyDiscountBtn = UIDesign.lblBtnDesign(pnlCartLeft, "APPLY DISCOUNT CODE!", "#ffba00", 390, 700, 250, 35);

        clearCartBtn = CartUI.clearCartBtn(pnlCartRight, 95, 30);
        paymentBtn = CartUI.proceedToPaymentBtn(pnlCartRight, 50, 630);
        continueShoppingBtn = UIDesign.lblBtnDesign(pnlCartRight, "Continue Shopping", "#9763f6", 50, 680, 250, 35);

        viewCart();

        backBtn.addActionListener(this);
        applyDiscountBtn.addActionListener(this);
        clearCartBtn.addActionListener(this);
        paymentBtn.addActionListener(this);
        continueShoppingBtn.addActionListener(this);

        frmCart.setVisible(true);
        frmCart.revalidate();
        frmCart.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //cartID = GetCartID.getCartID(username);
        if (e.getSource() == backBtn || e.getSource() == continueShoppingBtn) {
            frmCart.dispose();
        } else if (e.getSource() == paymentBtn) {
            new PaymentFrame(username);
            frmCart.dispose();
        } else if (e.getSource() == clearCartBtn) {
            clearCart();
            frmCart.dispose();
            new Cart();
        } else if (e.getSource() == applyDiscountBtn) {
            discountCode = discountCodeField.getText();
            System.out.println("Discount Code: " + discountCode);
            discountPercentage = getDiscountPercentage(discountCode);
            System.out.println("Discount Percentage: " + getDiscountPercentage(discountCode));
            recalculateFinalPrice(discountPercentage);
        }
    }

    public void viewCart() {

        SwingUtilities.invokeLater(() -> {
            try (Connection conn = DatabaseConfig.getConnection()) {
                String query = "SELECT PRODUCT_NAME, QUANTITY, PRICE, TOTAL_PRICE, VAT_AMOUNT FROM CartDetails WHERE C_USERNAME = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, username);
                    ResultSet rs = stmt.executeQuery();

                    List<String[]> data = new ArrayList<>();
                    String[] columnNames = {"Product Name", "Quantity", "Price", "Total", "VAT"};

                    double totalPrice = 0.0;
                    double totalVAT = 0.0;

                    while (rs.next()) {
                        String productName = rs.getString("PRODUCT_NAME");
                        int quantity = rs.getInt("QUANTITY");
                        double price = rs.getDouble("PRICE");
                        double totalProductPrice = rs.getDouble("TOTAL_PRICE");
                        double productVAT = rs.getDouble("VAT_AMOUNT");

                        data.add(new String[]{
                                productName,
                                String.valueOf(quantity),
                                "$" + String.format("%.2f", price),
                                "$" + String.format("%.2f", totalProductPrice),
                                "$" + String.format("%.2f", productVAT)
                        });

                        totalPrice += totalProductPrice;
                        totalVAT += productVAT;
                    }

                    if (data.isEmpty()) {
                        System.out.println("No data found for the user: " + username);
                    }
                    for (String[] row : data) {
                        System.out.printf("%-20s %-10s %-10s %-10s %-10s%n", row[0], row[1], row[2], row[3], row[4]);
                    }


                    String totalPriceStr = String.format("$%.2f", totalPrice);
                    String totalVATStr = String.format("$%.2f", totalVAT);
                    String finalPriceStr = String.format("$%.2f", (totalPrice + totalVAT));

                    String[][] tableData = data.toArray(new String[0][]);

                    JScrollPane tableScrollPane = TableDesign.createTable(tableData, columnNames);
                    tableScrollPane.setBounds(20, 80, 620, 500);

                    pnlCartLeft.setLayout(null);
                    pnlCartLeft.add(tableScrollPane);
                    pnlCartLeft.revalidate();
                    pnlCartLeft.repaint();

                    pricelbl = UIDesign.addlbl(pnlCartRight, "Total Price: " + totalPriceStr, "#fff8f0", 17, 50, 200, 250, 30);
                    vatlbl = UIDesign.addlbl(pnlCartRight, "Total VAT: " + totalVATStr, "#fff8f0", 17, 50, 240, 250, 30);
                    finalPriceLabel = UIDesign.addlbl(pnlCartRight, "Final Price: " + finalPriceStr, "#42d02b", 25, 30, 400, 400, 80);

                    pnlCartRight.revalidate();
                    pnlCartRight.repaint();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }




    public double getFinalPrice(String username, String discountCode) {
        double finalPrice = 0.0;
        double discountPercentage = getDiscountPercentage(discountCode);

        try (Connection conn = DatabaseConfig.getConnection()) {
            String query = "SELECT c.QUANTITY, p.PRICE, p.VAT " +
                    "FROM cart c " +
                    "JOIN products p ON c.PRODUCT_ID = p.PRODUCT_ID " +
                    "WHERE c.C_USERNAME = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();

                double totalPrice = 0.0;
                double totalVAT = 0.0;

                while (rs.next()) {
                    int quantity = rs.getInt("QUANTITY");
                    double price = rs.getDouble("PRICE");
                    double vat = rs.getDouble("VAT");

                    double totalProductPrice = quantity * price;
                    double productVAT = (totalProductPrice * vat) / 100;

                    totalPrice += totalProductPrice;
                    totalVAT += productVAT;
                }

                double total = totalPrice + totalVAT;
                double discountAmount = total * (discountPercentage / 100);
                finalPrice = total - discountAmount;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        BigDecimal roundedPrice = new BigDecimal(finalPrice).setScale(2, RoundingMode.HALF_UP);
        return roundedPrice.doubleValue();
    }

    public void clearCart() {
        try (Connection conn = DatabaseConfig.getConnection()) {
            String query = "DELETE FROM cart WHERE C_USERNAME = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addToCart(String cUsername, String productID, int quantity) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            String checkQuery = "SELECT QUANTITY FROM cart WHERE C_USERNAME = ? AND PRODUCT_ID = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
                checkStmt.setString(1, cUsername);
                checkStmt.setString(2, productID);
                ResultSet rs = checkStmt.executeQuery();

                if (rs.next()) {
                    int existingQuantity = rs.getInt("QUANTITY");
                    String updateQuery = "UPDATE cart SET QUANTITY = ? WHERE C_USERNAME = ? AND PRODUCT_ID = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                        updateStmt.setInt(1, existingQuantity + quantity);
                        updateStmt.setString(2, cUsername);
                        updateStmt.setString(3, productID);
                        updateStmt.executeUpdate();
                    }
                    System.out.println("Updated quantity in cart for Product ID: " + productID);
                } else {
                    String insertQuery = "INSERT INTO cart (C_USERNAME, PRODUCT_ID, QUANTITY) VALUES (?, ?, ?)";
                    try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                        insertStmt.setString(1, cUsername);
                        insertStmt.setString(2, productID);
                        insertStmt.setInt(3, quantity);
                        insertStmt.executeUpdate();
                    }
                    System.out.println("Product added to cart: " + productID);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String productList(String cUsername) {
        String productList = "";

        try (Connection conn = DatabaseConfig.getConnection()) {
            String query = "SELECT PRODUCT_ID, QUANTITY FROM cart WHERE C_USERNAME = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, cUsername);
                ResultSet rs = stmt.executeQuery();

                StringBuilder productBuilder = new StringBuilder();
                while (rs.next()) {
                    if (productBuilder.length() > 0) {
                        productBuilder.append(", ");
                    }
                    productBuilder.append(rs.getString("PRODUCT_ID"))
                            .append("(")
                            .append(rs.getInt("QUANTITY"))
                            .append(")");
                }
                productList = productBuilder.toString();
                System.out.println("Product list: " + productList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public static double getDiscountPercentage(String discountCode) {
        double discountPercentage = 0.0;

        try (Connection conn = DatabaseConfig.getConnection()) {
            String query = "SELECT discount_percentage FROM discounts WHERE discount_code = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, discountCode);
                System.out.println("Executing query with discount code: " + discountCode);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    discountPercentage = rs.getDouble("discount_percentage");
                    System.out.println("Discount code found. Discount percentage: " + discountPercentage);
                } else {
                    System.out.println("Discount code not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return discountPercentage;
    }

    public void recalculateFinalPrice(double discountPercentage) {
        double finalPrice = getFinalPrice(username, discountCode);

        String finalPriceStr = String.format("$%.2f", finalPrice);
        finalPriceLabel.setText("Final Price: " + finalPriceStr);

        pnlCartRight.revalidate();
        pnlCartRight.repaint();

        System.out.println("Final Price after discount: " + finalPriceStr);
    }

    public static String getDiscountCode() {
        return discountCodeField.getText();
    }






}
