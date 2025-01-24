package com.example.project.classes;

import com.example.project.database.DatabaseConfig;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    }


    private void createTable(String[][] data, String[] columnNames) {
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().removeAll(); // Clear the existing content
        add(scrollPane, BorderLayout.CENTER);
        revalidate();
        repaint();
    }


    public void viewCustomerTable() {
        ArrayList<String[]> customerList = new ArrayList<>();
        String query = "SELECT * FROM customer;";

        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                String customerId = rs.getString("CUSTOMER_ID");
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
        }

        String[][] data = customerList.toArray(new String[0][0]);
        String[] columnNames = {"Customer ID", "Customer Name", "Phone No", "Email", "Address", "Password", "Date Registered"};
        createTable(data, columnNames);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminTableViews frame = new AdminTableViews();
            frame.setVisible(true);


            frame.viewCustomerTable();
        });
    }
}