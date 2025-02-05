package com.gamingstore.classes.UIDesign;

import javax.swing.*;
import java.awt.*;

public class LogInPageUI {
    public JPanel pnlLeft, pnlRight;
    public JLabel lbl1, lbl2, lbl3, lblPnl3, lblPnl1, lblPnl2, txtBoxBar, passBoxBar, AdminLbl1, lblIAdminImg, lblErrorFace, lblError;
    public JTextField txtBx1;
    public JPasswordField pass;
    public JButton btnDarkMode, btnSignIn, btnSignUp, btnAdminSignIn, btnCustomerSignIn, btnErrorClose, btnAboutUs;

    public LogInPageUI(JFrame frm) {
        pnlLeft = new JPanel();
        pnlLeft.setLayout(null);
        pnlLeft.setBackground(Color.decode("#2c3e50"));
        pnlLeft.setBounds(0, 0, 550, 650);
        frm.add(pnlLeft);

        pnlRight = new JPanel();
        pnlRight.setLayout(null);
        pnlRight.setBackground(Color.decode("#FFF8F0"));
        pnlRight.setBounds(550, 0, 430, 650);
        frm.add(pnlRight);

        // Left Panel Content
        ImageIcon icon = new ImageIcon("Files/Untitled design.gif");
        JLabel lblImage = new JLabel(icon);
        lblImage.setBounds(0, 0, 550, 315);
        pnlLeft.add(lblImage);

        lbl1 = new JLabel("Hello Customer");
        lbl1.setFont(new Font("Roboto", Font.BOLD, 28));
        lbl1.setForeground(Color.LIGHT_GRAY);
        lbl1.setBounds(30, 350, 360, 30);
        pnlLeft.add(lbl1);

        lbl2 = new JLabel("<html>Welcome to <br/>Online Departmental Store </html>");
        lbl2.setFont(new Font("Roboto", Font.BOLD, 25));
        lbl2.setForeground(Color.LIGHT_GRAY);
        lbl2.setBounds(30, 390, 360, 70);
        pnlLeft.add(lbl2);

        lbl3 = new JLabel("Please Log in to Continue >>> ");
        lbl3.setFont(new Font("Roboto", Font.BOLD, 32));
        lbl3.setForeground(Color.WHITE);
        lbl3.setBounds(30, 470, 450, 90);
        pnlLeft.add(lbl3);

        btnAboutUs = new JButton("About Us >");
        btnAboutUs.setFont(new Font("Roboto", Font.BOLD, 17));
        btnAboutUs.setForeground(Color.BLACK);
        btnAboutUs.setBackground(Color.decode("#F7AC22"));
        btnAboutUs.setContentAreaFilled(true);
        btnAboutUs.setBorderPainted(false);
        btnAboutUs.setBounds(30, 560, 125, 25);
        pnlLeft.add(btnAboutUs);

        // Right Panel Content
        btnDarkMode = new JButton();
        btnDarkMode.setIcon(new ImageIcon("Files/LightMode.png"));
        btnDarkMode.setFont(new Font("Roboto", Font.BOLD, 16));
        btnDarkMode.setContentAreaFilled(false);
        btnDarkMode.setBorderPainted(false);
        btnDarkMode.setBounds(220, 10, 150, 130);
        pnlRight.add(btnDarkMode);

        lblPnl1 = new JLabel("Enter Username");
        lblPnl1.setFont(new Font("Roboto", Font.PLAIN, 20));
        lblPnl1.setBounds(30, 130, 240, 35);
        pnlRight.add(lblPnl1);

        txtBx1 = new JTextField();
        txtBx1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtBx1.setForeground(Color.decode("#CD1C35"));
        txtBx1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        txtBx1.setCaretColor(Color.white);
        txtBx1.setBorder(null);
        txtBx1.setOpaque(false);
        txtBx1.setBounds(30, 170, 320, 35);
        pnlRight.add(txtBx1);

        txtBoxBar = new JLabel();
        txtBoxBar.setBounds(30, 205, 320, 3);
        txtBoxBar.setOpaque(true);
        txtBoxBar.setBackground(Color.decode("#CD1C35"));
        pnlRight.add(txtBoxBar);

        lblPnl2 = new JLabel("Enter Passcode");
        lblPnl2.setFont(new Font("Roboto", Font.PLAIN, 20));
        lblPnl2.setBounds(30, 225, 240, 35);
        pnlRight.add(lblPnl2);

        pass = new JPasswordField();
        pass.setForeground(Color.decode("#CD1C35"));
        pass.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        pass.setCaretColor(Color.white);
        pass.setBorder(null);
        pass.setOpaque(false);
        pass.setBounds(30, 265, 320, 35);
        pnlRight.add(pass);

        passBoxBar = new JLabel();
        passBoxBar.setBounds(30, 300, 320, 3);
        passBoxBar.setOpaque(true);
        passBoxBar.setBackground(Color.decode("#CD1C35"));
        pnlRight.add(passBoxBar);

        btnSignIn = new JButton();
        btnSignIn.setIcon(new ImageIcon("Files/Sign In Button Page1.png"));
        btnSignIn.setContentAreaFilled(false);
        btnSignIn.setBorderPainted(false);
        btnSignIn.setBounds(40, 340, 150, 60);
        pnlRight.add(btnSignIn);

        btnSignUp = new JButton();
        btnSignUp.setIcon(new ImageIcon("Files/Sign Up.png"));
        btnSignUp.setContentAreaFilled(false);
        btnSignUp.setBorderPainted(false);
        btnSignUp.setBounds(170, 340, 150, 60);
        pnlRight.add(btnSignUp);

        ImageIcon iconErrorFace = new ImageIcon("Files/ErrorFace.png");
        lblErrorFace = new JLabel(iconErrorFace);
        lblErrorFace.setBounds(25, 420, 50, 60);
        pnlRight.add(lblErrorFace);
        lblErrorFace.setVisible(false);

        lblError = new JLabel("<html>No credentials Entered<br/>Please try again to continue...</html>");
        lblError.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblError.setForeground(Color.WHITE);
        lblError.setBackground(Color.decode("#C94F4F"));
        lblError.setOpaque(true);
        lblError.setBounds(75, 420, 240, 60);
        pnlRight.add(lblError);
        lblError.setVisible(false);

        btnErrorClose = new JButton();
        btnErrorClose.setIcon(new ImageIcon("Files/ErrorClosed.png"));
        btnErrorClose.setContentAreaFilled(false);
        btnErrorClose.setBorderPainted(false);
        btnErrorClose.setBounds(315, 420, 50, 60);
        pnlRight.add(btnErrorClose);
        btnErrorClose.setVisible(false);
    }

    public String getUsername() {
        return txtBx1.getText();
    }

    public String getPassword() {
        return new String(pass.getPassword());
    }


}

