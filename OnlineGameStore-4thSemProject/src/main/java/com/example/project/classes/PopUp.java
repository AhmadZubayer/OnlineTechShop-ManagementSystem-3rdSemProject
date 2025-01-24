package com.example.project.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PopUp {

    public JFrame frame;
    public static ImageIcon iconErrorFace;
    public static JButton btnErrorClose;
    public static JLabel lblError;
    public static JLabel lblErrorFace;

    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter a number(1-10): ");

            String option = new java.util.Scanner(System.in).nextLine();

            if (option == null || option.trim().isEmpty()) break;

            switch (option) {
                case "1":
                    showSignupSuccessPopup();
                    break;
                case "2":
                    showAccountAlreadyExistsPopup();
                    break;
                case "3":
                    showAccountDoesNotExistPopup();
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void showSignupSuccessPopup() {
        JFrame frame = createPopupFrame("Signup Successful", "Please login with your username to continue.");

        JButton btnLater = createLaterButton(frame);
        btnLater.setBounds(300, 100, 100, 30);
        frame.add(btnLater);

        JButton btnSignin = createSignInButton(frame);
        btnSignin.setBounds(120, 100, 100, 30);
        frame.add(btnSignin);

        frame.setVisible(true);
    }

    public static void showAccountAlreadyExistsPopup() {
        JFrame frame = createPopupFrame("Account Already Exists", "An account matches the information.");

        JButton btnSignin = createSignInButton(frame);
        btnSignin.setBounds(120, 100, 150, 30);
        frame.add(btnSignin);

        JButton btnOkay = createLaterButton(frame);
        btnOkay.setBounds(250, 100, 150, 30);
        frame.add(btnOkay);

        frame.setVisible(true);
    }

    public static void showAccountDoesNotExistPopup() {
        JFrame frame = createPopupFrame("Account Does not Exist", "Sign up!.");

        JButton btnSignin = createSignInButton(frame);
        btnSignin.setBounds(120, 100, 100, 30);
        frame.add(btnSignin);

        JButton btnOkay = createLaterButton(frame);
        btnOkay.setBounds(250, 100, 100, 30);
        frame.add(btnOkay);

        frame.setVisible(true);
    }

    public static void showUsernameAlreadyExistsError(JPanel pnl) {
        String errorMessage = "<html>Username Taken.<br/>Please select another username to continue.</html>";
        showError(errorMessage, pnl);
    }

    public static void showPhoneNoAlreadyExistsError(JPanel pnl) {
        String errorMessage = "<html>Phone No Exists.<br/>Please use another phone no to continue.</html>";
        showError(errorMessage, pnl);
    }

    public static void showEmailAlreadyExistsError(JPanel pnl) {
        String errorMessage = "<html>Email Exists.<br/>Please use another email to continue.</html>";
        showError(errorMessage, pnl);
    }

    public static void showInvalidEmailError(JPanel pnl) {
        String errorMessage = "<html>Invalid Email<br/>Please try again to continue...</html>";
        showError(errorMessage, pnl);
    }

    public static void showInvalidPhoneNoError(JPanel pnl) {
        String errorMessage = "<html>Invalid Phone No<br/>Please try again to continue...</html>";
        showError(errorMessage, pnl);
    }

    public static void showBlankFieldError(JPanel pnl) {
        String errorMessage = "<html>Unfilled Info<br/>Please fill all the fields to continue...</html>";
        showError(errorMessage, pnl);
    }

    public static void showPassDoesNotMatchError(JPanel pnl) {
        String errorMessage = "<html>Passwords Do Not Match<br/>Please try again to continue...</html>";
        showError(errorMessage, pnl);
    }

    private static void showError(String errorMessage, JPanel pnl) {
        ImageIcon iconErrorFace = new ImageIcon(PopUp.class.getClassLoader().getResource("Files/ErrorFace2.png"));
        JLabel lblErrorFace = new JLabel(iconErrorFace);
        lblErrorFace.setBounds(130, 30, 50, 60);

        JLabel lblError = new JLabel(errorMessage);
        lblError.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblError.setForeground(Color.WHITE);
        lblError.setBackground(Color.decode("#e23636"));
        lblError.setOpaque(true);
        lblError.setBounds(180, 30, 300, 60);

        JButton btnErrorClose = new JButton(new ImageIcon(PopUp.class.getClassLoader().getResource("Files/ErrorClosed2.png")));
        btnErrorClose.setContentAreaFilled(false);
        btnErrorClose.setBorderPainted(false);
        btnErrorClose.setBounds(480, 30, 50, 60);
        btnErrorClose.addActionListener(e -> pressErrorClose(lblErrorFace, lblError, btnErrorClose, pnl));

        pnl.add(lblErrorFace);
        pnl.add(lblError);
        pnl.add(btnErrorClose);

        pnl.revalidate();
        pnl.repaint();
    }

    private static void pressErrorClose(JLabel lblErrorFace, JLabel lblError, JButton btnErrorClose, JPanel pnl) {
        pnl.remove(lblErrorFace);
        pnl.remove(lblError);
        pnl.remove(btnErrorClose);
        pnl.revalidate();
        pnl.repaint();
    }

    private static JFrame createPopupFrame(String title, String message) {
        JFrame frame = new JFrame(title);
        frame.setSize(460, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#1d2a35"));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JLabel headingLabel = new JLabel(title);
        headingLabel.setFont(new Font("Roboto", Font.BOLD, 20));
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setBounds(120, 20, 430, 30);
        frame.add(headingLabel);

        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Roboto", Font.BOLD, 14));
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setBounds(120, 50, 430, 30);
        frame.add(messageLabel);

        return frame;
    }
    public static void showDatabaseErrorPopup() {
        JFrame frame = createPopupFrame("Database Error", "An error occurred while accessing the database.");

        JButton btnRetry = createRetryButton(frame);
        btnRetry.setBounds(120, 100, 150, 30);
        frame.add(btnRetry);

        JButton btnCancel = createCancelButton(frame);
        btnCancel.setBounds(250, 100, 150, 30);
        frame.add(btnCancel);

        frame.setVisible(true);
    }


    private static JButton createRetryButton(JFrame frame) {
        JButton btnRetry = new JButton("Retry");
        btnRetry.addActionListener(e -> {
            frame.dispose();
        });
        return btnRetry;
    }

    private static JButton createCancelButton(JFrame frame) {
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> frame.dispose());
        return btnCancel;
    }


    private static JButton createButton(String text, Color textColor, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setFont(new Font("Roboto", Font.BOLD, 17));
        button.setForeground(textColor);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.addActionListener(actionListener);
        return button;
    }

    private static JButton createSignInButton(JFrame frame) {
        return createButton("SIGN IN", Color.decode("#f7ac22"), e -> {
            frame.dispose();
            new LoginPage2();
        });
    }

    private static JButton createLaterButton(JFrame frame) {
        return createButton("LATER", Color.decode("#04aa6d"), e -> frame.dispose());
    }

    private static JButton createTryAgainButton(JFrame frame) {
        return createButton("TRY AGAIN", Color.decode("#9763f6"), e -> frame.dispose());
    }
}