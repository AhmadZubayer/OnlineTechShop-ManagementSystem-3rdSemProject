package com.example.project.classes;

import com.example.project.database.DatabaseConfig;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
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
        JTable table = new JTable(new DefaultTableModel(data, columnNames));

        table.setBackground(Color.decode("#1d2a35"));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Roboto", Font.PLAIN, 15));
        table.setRowHeight(35);
        table.setGridColor(Color.WHITE);

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
            JOptionPane.showMessageDialog(this, "Error loading customer data: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            return new JScrollPane(new JTable());
        }

        String[][] data = customerList.toArray(new String[0][0]);
        String[] columnNames = {"Customer ID", "Customer Name", "Phone No", "Email", "Address", "Password", "Date Registered"};
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
