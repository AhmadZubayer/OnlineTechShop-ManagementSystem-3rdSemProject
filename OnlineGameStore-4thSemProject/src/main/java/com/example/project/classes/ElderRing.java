package com.example.project.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElderRing implements ActionListener {
    public JFrame frm1;
    public JLabel lblName, lblPic, lblPrice, lblDscrtn;
    public JButton btnCancel, btnBuy;
    public JPanel pnlDownbar;

    ElderRing() {
        frm1 = new JFrame("Elder Ring");
        frm1.getContentPane().setBackground(Color.decode("#fff8f0"));
        frm1.setSize(800, 600);
        frm1.setLayout(null);
        frm1.setLocationRelativeTo(null);
        frm1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frm1.setResizable(false);

        lblName = new JLabel("Elder Ring");
        lblName.setBounds(315, 100, 450, 42);
        lblName.setFont(new Font("Roboto", Font.BOLD, 35));
        lblName.setForeground(Color.BLACK);
        //lblName.setForeground(Color.decode("#FFF8F0"));
        frm1.add(lblName);

        lblPic = new JLabel();
        lblPic.setIcon(new ImageIcon("Files\\DetailFrame\\ElderRing.jpeg"));
        lblPic.setBounds(30, 60, 250, 360);
        frm1.add(lblPic);

        lblDscrtn = new JLabel("<html>Elden Ring is an action RPG set in a vast open world,<br/> featuring challenging combat and exploration, developed<br/> by FromSoftware.<html>");
        lblDscrtn.setBounds(320, 100, 500, 400);
        lblDscrtn.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblDscrtn.setForeground(Color.BLACK);
        frm1.add(lblDscrtn);

        pnlDownbar = new JPanel();
        pnlDownbar.setLayout(null);
        pnlDownbar.setBackground(Color.decode("#2c3e50"));
        pnlDownbar.setBounds(0, 410, 800, 160);
        frm1.add(pnlDownbar);


        lblPrice = new JLabel("PRICE: $59.99");
        lblPrice.setBounds(50, 40, 300, 50);
        lblPrice.setFont(new Font("Roboto", Font.BOLD, 30));
        lblPrice.setForeground(Color.WHITE);
        pnlDownbar.add(lblPrice);


        btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(510, 40, 100, 40);
        btnCancel.setFont(new Font("Roboto", Font.BOLD, 16));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setBackground(Color.RED);
        btnCancel.setContentAreaFilled(true);
        btnCancel.setBorderPainted(false);
        pnlDownbar.add(btnCancel);
        btnCancel.addActionListener(this);


        btnBuy = new JButton("BUY");
        btnBuy.setBounds(620, 40, 100, 40);
        btnBuy.setFont(new Font("Roboto", Font.BOLD, 16));
        btnBuy.setForeground(Color.WHITE);
        btnBuy.setBackground(Color.decode("#3CB371"));
        btnBuy.setContentAreaFilled(true);
        btnBuy.setBorderPainted(false);
        pnlDownbar.add(btnBuy);
        btnBuy.addActionListener(this);

        frm1.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String productDetails = "";
        if (e.getSource() == btnCancel) {
            frm1.dispose();
        } else if(e.getSource() == btnBuy ) {
            productDetails = "ELDER RING...$59.99";
            HomePage.addToCart(productDetails);
            frm1.dispose();
        }

    }


}

