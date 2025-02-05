package com.gamingstore.classes.UIDesign;

import com.gamingstore.classes.*;
import com.gamingstore.classes.DatabaseRW.ProductDatabaseRW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductPageUI implements ActionListener {
    private JFrame frame;
    private JLabel lblName, lblPic, lblPrice, lblDscrtn;
    private JButton btnCancel, btnBuy;
    private JPanel pnlDownbar;
    private String productID;
    private String cUsername;

    public ProductPageUI(String cUsername, String productID, String description, String imagePath) {
        this.cUsername = cUsername;
        this.productID = productID;
        String productName = ProductDatabaseRW.getNameFromDatabase(productID);
        Double price = Double.parseDouble(ProductDatabaseRW.getPriceFromDatabase(productID));

        frame = new JFrame(productName);
        frame.getContentPane().setBackground(Color.decode("#fff8f0"));
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);

        lblName = new JLabel(productName);
        lblName.setBounds(315, 30, 450, 42);
        lblName.setFont(new Font("Roboto", Font.BOLD, 35));
        lblName.setForeground(Color.BLACK);
        frame.add(lblName);

        lblPic = new JLabel();
        lblPic.setIcon(new ImageIcon(imagePath));
        lblPic.setBounds(30, 60, 250, 360);
        frame.add(lblPic);

        lblDscrtn = new JLabel("<html>" + description + "</html>");
        lblDscrtn.setBounds(320, 100, 450, 300);
        lblDscrtn.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblDscrtn.setForeground(Color.BLACK);
        frame.add(lblDscrtn);

        pnlDownbar = new JPanel();
        pnlDownbar.setLayout(null);
        pnlDownbar.setBackground(Color.decode("#2c3e50"));
        pnlDownbar.setBounds(0, 410, 800, 160);
        frame.add(pnlDownbar);

        lblPrice = new JLabel("PRICE: $" + price);
        lblPrice.setBounds(50, 40, 300, 50);
        lblPrice.setFont(new Font("Roboto", Font.BOLD, 30));
        lblPrice.setForeground(Color.WHITE);
        pnlDownbar.add(lblPrice);

        btnCancel = new JButton("BACK");
        btnCancel.setBounds(510, 40, 100, 40);
        btnCancel.setFont(new Font("Roboto", Font.BOLD, 16));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setBackground(Color.RED);
        btnCancel.setBorderPainted(false);
        pnlDownbar.add(btnCancel);
        btnCancel.addActionListener(this);

        btnBuy = new JButton("BUY");
        btnBuy.setBounds(620, 40, 100, 40);
        btnBuy.setFont(new Font("Roboto", Font.BOLD, 16));
        btnBuy.setForeground(Color.WHITE);
        btnBuy.setBackground(Color.decode("#3CB371"));
        btnBuy.setBorderPainted(false);
        pnlDownbar.add(btnBuy);
        btnBuy.addActionListener(this);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancel) {
            frame.dispose();
        } else if (e.getSource() == btnBuy) {
            Cart cart = new Cart();
            cart.addToCart(cUsername, productID, 1);
            frame.dispose();
        }
    }
}
