package com.example.project.classes;

import com.example.project.database.DatabaseConfig;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SignupPage implements ActionListener {

    JButton btnSignUp, btnSignIn;
    JFrame frame;
    JTextField txtCustomerId, txtCustomerName, txtPhone, txtEmail, txtAddress;
    JPasswordField txtPass, txtRetypePass;
    JPanel p1, pnlRight;
    String dateRegistered;

    public SignupPage() {

        dateRegistered = java.time.LocalDate.now().toString();

        frame = new JFrame("Sign Up");
        frame.setSize(1182, 850);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 641, 850);
        p1.setBackground(Color.decode("#2c3e50"));
        frame.add(p1);

        JLabel imlb2 = new JLabel();
        imlb2.setBounds(100, 200, 450, 250);
        imlb2.setIcon(new ImageIcon("Files\\signuplogo.gif"));
        imlb2.setVisible(true);
        p1.add(imlb2);

        JLabel label1 = new JLabel("IT'S FREE!");
        label1.setFont(new Font("Roboto", Font.BOLD, 50));
        label1.setForeground(Color.decode("#FAF9F6"));
        label1.setBounds(230, 430, 300, 100);
        label1.setVisible(true);
        p1.add(label1);

        JLabel arrowLabel = new JLabel();
        arrowLabel.setBounds(250, 600, 150, 150);
        arrowLabel.setIcon(new ImageIcon("Files\\arrow.gif"));
        arrowLabel.setVisible(true);
        p1.add(arrowLabel);

        pnlRight = new JPanel();
        pnlRight.setBounds(641, 0, 641, 850);
        pnlRight.setLayout(null);
        pnlRight.setBackground(Color.decode("#DADADA"));
        frame.add(pnlRight);

        JLabel lblCustomerId = new JLabel("ENTER CUSTOMER ID");
        lblCustomerId.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblCustomerId.setBounds(30, 30, 240, 35);
        pnlRight.add(lblCustomerId);

        txtCustomerId = new JTextField();
        txtCustomerId.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtCustomerId.setForeground(Color.decode("#2c3e50"));
        txtCustomerId.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        txtCustomerId.setCaretColor(Color.white);
        txtCustomerId.setBorder(null);
        txtCustomerId.setOpaque(false);
        txtCustomerId.setBounds(30, 70, 420, 35);
        pnlRight.add(txtCustomerId);

        JLabel customerIdBar = new JLabel();
        customerIdBar.setBounds(30, 105, 420, 3);
        customerIdBar.setOpaque(true);
        customerIdBar.setBackground(Color.decode("#2c3e50"));
        pnlRight.add(customerIdBar);

        JLabel lblCustomerName = new JLabel("ENTER CUSTOMER NAME");
        lblCustomerName.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblCustomerName.setBounds(30, 130, 240, 35);
        pnlRight.add(lblCustomerName);

        txtCustomerName = new JTextField();
        txtCustomerName.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtCustomerName.setForeground(Color.decode("#2c3e50"));
        txtCustomerName.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        txtCustomerName.setCaretColor(Color.white);
        txtCustomerName.setBorder(null);
        txtCustomerName.setOpaque(false);
        txtCustomerName.setBounds(30, 170, 420, 35);
        pnlRight.add(txtCustomerName);

        JLabel customerNameBar = new JLabel();
        customerNameBar.setBounds(30, 205, 420, 3);
        customerNameBar.setOpaque(true);
        customerNameBar.setBackground(Color.decode("#2c3e50"));
        pnlRight.add(customerNameBar);

        JLabel lblPhone = new JLabel("ENTER PHONE NO.");
        lblPhone.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblPhone.setBounds(30, 230, 240, 35);
        pnlRight.add(lblPhone);

        txtPhone = new JTextField();
        txtPhone.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtPhone.setForeground(Color.decode("#2c3e50"));
        txtPhone.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        txtPhone.setCaretColor(Color.white);
        txtPhone.setBorder(null);
        txtPhone.setOpaque(false);
        txtPhone.setBounds(30, 270, 420, 35);
        pnlRight.add(txtPhone);

        JLabel phoneBar = new JLabel();
        phoneBar.setBounds(30, 305, 420, 3);
        phoneBar.setOpaque(true);
        phoneBar.setBackground(Color.decode("#2c3e50"));
        pnlRight.add(phoneBar);

        JLabel lblEmail = new JLabel("ENTER EMAIL ADDRESS");
        lblEmail.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEmail.setBounds(30, 330, 240, 35);
        pnlRight.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtEmail.setForeground(Color.decode("#2c3e50"));
        txtEmail.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        txtEmail.setCaretColor(Color.white);
        txtEmail.setBorder(null);
        txtEmail.setOpaque(false);
        txtEmail.setBounds(30, 370, 420, 35);
        pnlRight.add(txtEmail);

        JLabel emailBar = new JLabel();
        emailBar.setBounds(30, 405, 420, 3);
        emailBar.setOpaque(true);
        emailBar.setBackground(Color.decode("#2c3e50"));
        pnlRight.add(emailBar);

        JLabel lblAddress = new JLabel("ENTER ADDRESS");
        lblAddress.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblAddress.setBounds(30, 430, 240, 35);
        pnlRight.add(lblAddress);

        txtAddress = new JTextField();
        txtAddress.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtAddress.setForeground(Color.decode("#2c3e50"));
        txtAddress.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        txtAddress.setCaretColor(Color.white);
        txtAddress.setBorder(null);
        txtAddress.setOpaque(false);
        txtAddress.setBounds(30, 470, 420, 35);
        pnlRight.add(txtAddress);

        JLabel addressBar = new JLabel();
        addressBar.setBounds(30, 505, 420, 3);
        addressBar.setOpaque(true);
        addressBar.setBackground(Color.decode("#2c3e50"));
        pnlRight.add(addressBar);

        JLabel lblPass = new JLabel("ENTER PASSCODE");
        lblPass.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblPass.setBounds(30, 530, 240, 35);
        pnlRight.add(lblPass);

        txtPass = new JPasswordField();
        txtPass.setForeground(Color.decode("#2c3e50"));
        txtPass.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        txtPass.setCaretColor(Color.white);
        txtPass.setBorder(null);
        txtPass.setOpaque(false);
        txtPass.setBounds(30, 570, 420, 35);
        pnlRight.add(txtPass);

        JLabel passBar = new JLabel();
        passBar.setBounds(30, 605, 420, 3);
        passBar.setOpaque(true);
        passBar.setBackground(Color.decode("#2c3e50"));
        pnlRight.add(passBar);

        JLabel lblRetypePass = new JLabel("RETYPE PASSCODE");
        lblRetypePass.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblRetypePass.setBounds(30, 630, 240, 35);
        pnlRight.add(lblRetypePass);

        txtRetypePass = new JPasswordField();
        txtRetypePass.setForeground(Color.decode("#2c3e50"));
        txtRetypePass.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        txtRetypePass.setCaretColor(Color.white);
        txtRetypePass.setBorder(null);
        txtRetypePass.setOpaque(false);
        txtRetypePass.setBounds(30, 670, 420, 35);
        pnlRight.add(txtRetypePass);

        JLabel retypePassBar = new JLabel();
        retypePassBar.setBounds(30, 705, 420, 3);
        retypePassBar.setOpaque(true);
        retypePassBar.setBackground(Color.decode("#2c3e50"));
        pnlRight.add(retypePassBar);

        btnSignUp = new JButton();
        btnSignUp.setIcon(new ImageIcon("Files\\Sign Up.png"));
        btnSignUp.setContentAreaFilled(false);
        btnSignUp.setBorderPainted(false);
        btnSignUp.setBounds(40, 750, 150, 60);
        pnlRight.add(btnSignUp);
        btnSignUp.addActionListener(this);

        btnSignIn = new JButton();
        btnSignIn.setIcon(new ImageIcon("Files\\Sign In Button Page1.png"));
        btnSignIn.setContentAreaFilled(false);
        btnSignIn.setBorderPainted(false);
        btnSignIn.setBounds(200, 750, 150, 60);
        pnlRight.add(btnSignIn);
        btnSignIn.addActionListener(this);

        frame.setVisible(true);
    }

    public void addErrors() {
        PopUp.lblErrorFace.setBounds(100, 30, 50, 60);
        PopUp.lblError.setBounds(150, 30, 240, 60);
        PopUp.btnErrorClose.setBounds(390, 30, 50, 60);

        p1.add(PopUp.lblErrorFace);
        p1.add(PopUp.lblError);
        p1.add(PopUp.btnErrorClose);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSignUp) {
            String customerId = txtCustomerId.getText();
            String customerName = txtCustomerName.getText();
            String phone = txtPhone.getText();
            String email = txtEmail.getText();
            String address = txtAddress.getText();
            String password = new String(txtPass.getPassword());
            String retypePassword = new String(txtRetypePass.getPassword());


            if (customerId.isEmpty() || customerName.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty() || password.isEmpty()) {
                PopUp.showBlankFieldError(p1);
                addErrors();
                return;
            }


            if (!phone.matches("\\d{10}")) {
                PopUp.showInvalidPhoneNoError(p1);
                addErrors();
                return;
            }


            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                PopUp.showInvalidEmailError(p1);
                addErrors();
                return;
            }


            if (!password.equals(retypePassword)) {
                PopUp.showPassDoesNotMatchError(p1);
                addErrors();
                return;
            }



            try (Connection connection = DatabaseConfig.getConnection()) {
                String checkCustomerIdQuery = "SELECT * FROM customer WHERE CUSTOMER_ID = ?";
                PreparedStatement checkCustomerIdStmt = connection.prepareStatement(checkCustomerIdQuery);
                checkCustomerIdStmt.setString(1, customerId);
                ResultSet rsCustomerId = checkCustomerIdStmt.executeQuery();
                if (rsCustomerId.next()) {
                    PopUp.showUsernameAlreadyExistsError(p1);
                    return;
                }


                String checkPhoneQuery = "SELECT * FROM customer WHERE PHONE_NO = ?";
                PreparedStatement checkPhoneStmt = connection.prepareStatement(checkPhoneQuery);
                checkPhoneStmt.setString(1, phone);
                ResultSet rsPhone = checkPhoneStmt.executeQuery();
                if (rsPhone.next()) {
                    PopUp.showPhoneNoAlreadyExistsError(p1);
                    return;
                }

                // Check if email already exists
                String checkQuery = "SELECT * FROM customer WHERE EMAIL = ?";
                PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
                checkStmt.setString(1, email);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    PopUp.showEmailAlreadyExistsError(p1);
                    return;
                }

                // Insert new customer into the database
                String insertQuery = "INSERT INTO customer (CUSTOMER_ID, CUSTOMER_NAME, PHONE_NO, EMAIL, ADDRESS, PASSWORD, DATE_REGISTERED) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
                insertStmt.setString(1, customerId);
                insertStmt.setString(2, customerName);
                insertStmt.setString(3, phone);
                insertStmt.setString(4, email);
                insertStmt.setString(5, address);
                insertStmt.setString(6, password);
                insertStmt.setString(7, dateRegistered);

                int rowsInserted = insertStmt.executeUpdate();
                if (rowsInserted > 0) {
                    PopUp.showSignupSuccessPopup();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                PopUp.showDatabaseErrorPopup();
            }
        } else if (e.getSource() == btnSignIn) {
            frame.dispose();
            new LoginPage2();
        }
    }
}