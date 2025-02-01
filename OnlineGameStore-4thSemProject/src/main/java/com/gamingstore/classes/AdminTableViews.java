package com.gamingstore.classes;

import com.gamingstore.database.DatabaseConfig;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminTableViews extends JFrame {

    public AdminTableViews() {
        setTitle("Admin Table Views");
        setSize(900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    public JScrollPane createTable(String[][] data, String[] columnNames) {
        JTable table = new JTable(new DefaultTableModel(data, columnNames)) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(row)) {
                    // Alternate row colors
                    component.setBackground(row % 2 == 0 ? Color.decode("#1d2a35") : Color.decode("#2c3e50"));
                    component.setForeground(Color.WHITE);
                } else {
                    component.setBackground(Color.decode("#9763F6"));
                    component.setForeground(Color.WHITE);
                }
                return component;
            }
        };

        table.setBackground(Color.decode("#1d2a35"));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Roboto", Font.PLAIN, 15));
        table.setRowHeight(35);
        table.setShowHorizontalLines(false);
        table.setGridColor(Color.decode("#34495e"));

        //table.setIntercellSpacing(new Dimension(5, 1));

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Roboto", Font.BOLD, 16));
        header.setBackground(Color.WHITE);
        header.setForeground(Color.BLACK);

        JScrollPane tableScrollPane = new JScrollPane(table);

        tableScrollPane.getViewport().setBackground(Color.decode("#1d2a35"));
        tableScrollPane.setBackground(Color.decode("#1d2a35"));

        tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        return tableScrollPane;
    }



    public JScrollPane viewCustomerTable() {
        ArrayList<String[]> customerList = new ArrayList<>();
        String query = "SELECT * FROM customer;";

        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                String customerId = rs.getString("C_USERNAME");
                String customerName = rs.getString("CUSTOMER_NAME");
                String phoneNo = String.valueOf(rs.getInt("PHONE_NO"));
                String email = rs.getString("EMAIL");
                String address = rs.getString("ADDRESS");
                String password = rs.getString("PASSWORD");
                String dateRegistered = rs.getDate("DATE_REGISTERED").toString();

                customerList.add(new String[]{customerId, customerName, phoneNo, email, address, password, dateRegistered});
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading customer data: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            return new JScrollPane(new JTable());
        }

        String[][] data = customerList.toArray(new String[0][0]);
        String[] columnNames = {"Customer ID", "Customer Name", "Phone No", "Email", "Address", "Password", "Date Registered"};
        return createTable(data, columnNames);
    }

    public JScrollPane viewAllProductsTable(String sort) {
        ArrayList<String[]> productList = new ArrayList<>();
        String query;

        switch (sort.toLowerCase()) {
            case "all":
                query = "SELECT * FROM Products;";
                break;
            case "cpu":
                query = "SELECT * FROM Products WHERE CATEGORY = 'CPU';";
                break;
            case "gpu":
                query = "SELECT * FROM Products WHERE CATEGORY = 'GPU';";
                break;
            case "memory":
                query = "SELECT * FROM Products WHERE CATEGORY = 'MEMORY';";
                break;
            case "ssd":
                query = "SELECT * FROM Products WHERE CATEGORY = 'SSD';";
                break;
            case "motherboard":
                query = "SELECT * FROM Products WHERE CATEGORY = 'MOTHERBOARD';";
                break;
            case "case":
                query = "SELECT * FROM Products WHERE CATEGORY = 'CASE';";
                break;
            case "cooler":
                query = "SELECT * FROM Products WHERE CATEGORY = 'COOLER';";
                break;
            case "psu":
                query = "SELECT * FROM Products WHERE CATEGORY = 'PSU';";
                break;
            case "gaming consoles":
                query = "SELECT * FROM Products WHERE CATEGORY = 'Gaming Consoles';";
                break;
            case "gaming accessories":
                query = "SELECT * FROM Products WHERE CATEGORY = 'Gaming Accessories';";
                break;
            case "games":
                query = "SELECT * FROM Products WHERE CATEGORY = 'Games';";
                break;
            default:
                query = "SELECT * FROM Products;";
                break;
        }

        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                String productId = rs.getString("PRODUCT_ID");
                String productName = rs.getString("PRODUCT_NAME");
                String brand = rs.getString("BRAND");
                String category = rs.getString("CATEGORY");
                String price = String.valueOf(rs.getDouble("PRICE"));
                String vat = String.valueOf(rs.getDouble("VAT"));
                String availableQuantity = String.valueOf(rs.getInt("AVAILABLE_QUANTITY"));
                String sold = String.valueOf(rs.getInt("SOLD"));

                productList.add(new String[]{productId, productName, brand, category, price, vat, availableQuantity, sold});
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading product data: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            return new JScrollPane(new JTable());
        }

        String[][] data = productList.toArray(new String[0][0]);
        String[] columnNames = {"Product ID", "Product Name", "Brand", "Category", "Price", "VAT", "Available Quantity", "Sold"};
        return createTable(data, columnNames);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminTableViews frame = new AdminTableViews();
            JScrollPane customerTableScrollPane = frame.viewCustomerTable();
            frame.add(customerTableScrollPane, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}
