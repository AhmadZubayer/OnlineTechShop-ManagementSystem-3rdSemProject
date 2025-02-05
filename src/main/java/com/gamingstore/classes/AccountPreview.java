
package com.gamingstore.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import com.gamingstore.classes.UIDesign.TableDesign;
import com.gamingstore.database.DatabaseConfig;

public class AccountPreview extends JFrame implements ActionListener {
    private JButton signOutBtn;
    private String currentUser;
    private JFrame productPreview, cart, payment, homePage;

    public AccountPreview() {

        currentUser = CurrentUser.getCurrentUser();


        setTitle("Account Preview");
        setSize(500, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.decode("#1D2A35"));

        JLabel usernameLabel = new JLabel(currentUser, SwingConstants.CENTER);
        usernameLabel.setBounds(150, 20, 200, 30);
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(usernameLabel);

        JScrollPane tableScrollPane = viewCustomerTable(currentUser);
        tableScrollPane.setBounds(50, 100, 400, 200);
        add(tableScrollPane);

        signOutBtn = new JButton("Sign Out");
        signOutBtn.setBounds(175, 550, 150, 40);
        signOutBtn.setBackground(Color.RED);
        signOutBtn.setForeground(Color.WHITE);
        signOutBtn.setFont(new Font("Arial", Font.BOLD, 14));
        signOutBtn.addActionListener(this);
        add(signOutBtn);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JScrollPane viewCustomerTable(String username) {
        String[][] data = {
                {"Name", ""},
                {"Phone", ""},
                {"Email", ""},
                {"Address", ""},
                {"Registered", ""}
        };

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT CUSTOMER_NAME, PHONE_NO, EMAIL, ADDRESS, DATE_REGISTERED FROM customer WHERE C_USERNAME = ?")) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                data[0][1] = rs.getString("CUSTOMER_NAME");
                data[1][1] = rs.getString("PHONE_NO");
                data[2][1] = rs.getString("EMAIL");
                data[3][1] = rs.getString("ADDRESS");
                data[4][1] = rs.getString("DATE_REGISTERED");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return TableDesign.createTable(data, new String[]{"", ""});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        HomePage homePage = new HomePage();
        if (e.getSource() == signOutBtn) {
            dispose();
            homePage.closeHomePage();
            new LoginPage2();
        }
    }

    private JScrollPane viewEmpTable(String empID) {
        String[][] data = {
                {"Name", ""},
                {"Phone", ""},
                {"Email", ""}
        };

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT empName, empPhone, empEmail FROM employee WHERE empID = ?")) {
            stmt.setString(1, empID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                data[0][1] = rs.getString("empName");
                data[1][1] = rs.getString("empPhone");
                data[2][1] = rs.getString("empEmail");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return TableDesign.createTable(data, new String[]{"Field", "Value"});
    }


    public static void main(String[] args) {
        new AccountPreview();
    }
}
