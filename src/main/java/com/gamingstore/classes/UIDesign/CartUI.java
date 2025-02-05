package com.gamingstore.classes.UIDesign;

import javax.swing.*;
import java.awt.*;

public class CartUI {

    public CartUI() {}

    public static JFrame frmDesign(String Heading, int w, int h) {
        JFrame frm = new JFrame(Heading);
        frm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frm.setSize(w, h);
        frm.setLayout(null);
        frm.setResizable(false);
        return frm;
    }

    public static JPanel pnlDesign(JFrame frm, String HexCode, int x, int y, int w, int h) {
        JPanel pnl = new JPanel();
        pnl.setLayout(null);
        pnl.setBackground(Color.decode(HexCode));
        pnl.setBounds(x, y, w, h);
        frm.add(pnl);
        return pnl;
    }

    public static JButton proceedToPaymentBtn(JPanel pnl, int x, int y) {
        JButton btn = new JButton("$ PROCEED TO CHECKOUT >");
        btn.setFont(new Font("Roboto", Font.BOLD, 17));
        btn.setBackground(Color.decode("#00bf63"));
        btn.setForeground(Color.decode("#FFF8F0"));
        btn.setContentAreaFilled(true);
        btn.setBorderPainted(false);
        btn.setBounds(x, y, 260, 35);
        pnl.add(btn);
        return btn;
    }

    public static JButton clearCartBtn(JPanel pnl, int x, int y) {
        JButton btn = new JButton("CLEAR CART");
        btn.setFont(new Font("Roboto", Font.BOLD, 17));
        btn.setBackground(Color.decode("#ff4d4d"));
        btn.setForeground(Color.decode("#FFF8F0"));
        btn.setContentAreaFilled(true);
        btn.setBorderPainted(false);
        btn.setBounds(x, y, 160, 35);
        pnl.add(btn);
        return btn;
    }

    public static JLabel addlbl(JPanel pnl, String Text, String hexCode, int s, int x, int y, int w, int h) {
        JLabel lbl = new JLabel(Text);
        lbl.setFont(new Font("Roboto", Font.BOLD, s));
        lbl.setForeground(Color.decode(hexCode));
        lbl.setBounds(x, y, w, h);
        pnl.add(lbl);
        return lbl;
    }


    public static JTextField textBar(JPanel pnl, String placeholder, String HexCode, int x, int y, int w, int h) {
        JTextField txtField = new JTextField(placeholder);
        txtField.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtField.setForeground(Color.decode("#000000"));
        txtField.setBackground(Color.decode(HexCode));
        txtField.setBounds(x, y, w, h);
        pnl.add(txtField);
        return txtField;
    }


    public static JButton applyDiscountBtn(JPanel pnl, int x, int y) {
        JButton btn = new JButton("APPLY DISCOUNT CODE!");
        btn.setFont(new Font("Roboto", Font.BOLD, 16));
        btn.setBackground(Color.decode("#ffba00"));
        btn.setForeground(Color.decode("#000000"));
        btn.setContentAreaFilled(true);
        btn.setBorderPainted(false);
        btn.setBounds(x, y, 250, 35);
        pnl.add(btn);
        return btn;
    }
}
