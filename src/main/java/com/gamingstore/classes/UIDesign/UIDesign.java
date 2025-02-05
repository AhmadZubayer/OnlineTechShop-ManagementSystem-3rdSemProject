package com.gamingstore.classes.UIDesign;

import com.gamingstore.classes.DatabaseRW.ProductDatabaseRW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UIDesign {
    Color hoverTextColor = Color.decode("#9763F6");

    public UIDesign() {}

    public static void Frm3Design(JFrame frm3, String title) {
        frm3.setTitle(title);
        frm3.getContentPane().setBackground(Color.decode("#1d2a35"));
        frm3.setSize(1600, 1020);
        frm3.setLayout(null);
        frm3.setLocationRelativeTo(null);
        frm3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm3.setResizable(false);
    }

    public static void backBtnDesign(JButton btn) {
        btn.setText("< BACK");
        btn.setFont(new Font("Roboto", Font.BOLD, 17));
        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.decode("#2C3E50"));
        btn.setContentAreaFilled(true);
        btn.setBorderPainted(false);
    }

    public static void editAccBtn(JButton btn) {
        btn = new JButton("Edit Account Info");
        btn.setFont(new Font("Roboto", Font.BOLD, 17));
        btn.setForeground(Color.decode("#2C3E50"));
        btn.setBackground(Color.decode("#FFF8F0"));
        btn.setContentAreaFilled(true);
        btn.setBorderPainted(false);
    }

    public static void tabBtnDesign(JButton btn) {
        btn.setFont(new Font("Roboto", Font.BOLD, 17));
        btn.setForeground(Color.decode("#FFF8F0"));
        btn.setBackground(Color.decode("#2C3E50"));
        btn.setContentAreaFilled(true);
        btn.setBorderPainted(false);
    }

    public static JButton leftBtnDesigns(JPanel pnl, String title, int x, int y, int w, int h) {

        JButton btn = new JButton(title);
        btn.setFont(new Font("Roboto", Font.BOLD, 17));
        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.decode("#2C3E50"));
        btn.setContentAreaFilled(true);
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.setBounds(x, y, w, h);
        pnl.add(btn);
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setForeground(Color.decode("#9763F6"));
                btn.setBorder(BorderFactory.createLineBorder(Color.decode("#9763F6"), 4));
            }
            public void mouseExited(MouseEvent e) {
                btn.setForeground(Color.WHITE);
                btn.setBorder(BorderFactory.createEmptyBorder());
            }
        });
        return btn;
    }

    public static JButton productBtns(JPanel pnl, String imgPath, String productID) {
        JButton btn = new JButton();
        btn.setIcon(new ImageIcon(imgPath));
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setContentAreaFilled(true);
                btn.setBackground(Color.decode("#ffbd59"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setContentAreaFilled(false);
            }
        });

        String productName = ProductDatabaseRW.getNameFromDatabase(productID);
        String priceStr = ProductDatabaseRW.getPriceFromDatabase(productID);
        double price = 0.0;

        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException | NullPointerException ex) {
            System.err.println("Invalid price for product ID: " + productID);
        }


        JLabel productNameLabel = new JLabel(productName, SwingConstants.CENTER);
        productNameLabel.setFont(new Font("Roboto", Font.BOLD, 17));
        productNameLabel.setForeground(Color.WHITE);

        JLabel lblProductPrice = new JLabel("Price: $ " + price, SwingConstants.CENTER);
        lblProductPrice.setFont(new Font("Roboto", Font.BOLD, 17));
        lblProductPrice.setForeground(Color.WHITE);


        JPanel pnlHolder = new JPanel();
        pnlHolder.setLayout(new BoxLayout(pnlHolder, BoxLayout.Y_AXIS));
        pnlHolder.setBackground(Color.decode("#1d2a35"));

        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        productNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblProductPrice.setAlignmentX(Component.CENTER_ALIGNMENT);

        pnlHolder.add(btn);
        pnlHolder.add(Box.createVerticalStrut(10));
        pnlHolder.add(productNameLabel);
        pnlHolder.add(lblProductPrice);

        pnl.add(pnlHolder);

        return btn;
    }


    public static void leftBtnPnl(JFrame frm, JPanel pnl, int x, int y, int w, int h, boolean visibility) {
        pnl.setLayout(null);
        pnl.setBackground(Color.decode("#1d2a35"));
        pnl.setBounds(x, y, w, h);
        pnl.setVisible(visibility);
        frm.add(pnl);
    }

    public static void pressedLeftBtn(JButton selectedButton, JButton[] allButtons) {

        selectedButton.setBackground(Color.decode("#04aa6d"));
        selectedButton.setForeground(Color.WHITE);
        selectedButton.setFont(new Font("Roboto", Font.BOLD, 17));

        for (JButton btn : allButtons) {
            if (btn != selectedButton) {
                btn.setBackground(Color.decode("#2C3E50"));
                btn.setForeground(Color.WHITE);
            }
        }
    }

    public static void pressedTabBtn(JButton selectedButton, JButton[] allButtons) {

        selectedButton.setBackground(Color.WHITE);
        selectedButton.setForeground(Color.decode("#2C3E50"));
        selectedButton.setFont(new Font("Roboto", Font.BOLD, 17));

        for (JButton btn : allButtons) {
            if (btn != selectedButton) {
                btn.setBackground(Color.decode("#2c3e50"));
                btn.setForeground(Color.WHITE);
            }
        }
    }

    public static JPanel pcComponentsPnl(JFrame frm, boolean visibility) {
        JPanel pnl = new JPanel();
        pnl.setLayout(new GridLayout(1, 4, 30, 30));
        pnl.setBackground(Color.decode("#1d2a35"));
        pnl.setBounds(400, 350, 1000, 500);
        pnl.setVisible(visibility);
        frm.add(pnl);
        return pnl;
    }

    public static JButton backBtnDesign(JPanel pnl, int x, int y) {
        JButton btn = new JButton();
        btn.setText("< BACK");
        btn.setFont(new Font("Roboto", Font.BOLD, 17));
        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.decode("#2C3E50"));
        btn.setContentAreaFilled(true);
        btn.setBorderPainted(false);
        btn.setBounds(x, y, 125, 35);
        pnl.add(btn);
        return btn;
    }

    public static JButton lblBtnDesign(JPanel pnl, String Text, String Hexcode, int x, int y, int w, int h) {
        JButton btn = new JButton(Text);
        btn.setFont(new Font("Roboto", Font.BOLD, 17));
        btn.setForeground(Color.decode(Hexcode));
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setBounds(x, y, w, h);
        pnl.add(btn);
        return btn;
    }

    public static JLabel addlbl(JPanel pnl, String Text,  String hexCode, int s, int x, int y, int w, int h) {
        JLabel lbl = new JLabel(Text);
        lbl.setFont(new Font("Roboto", Font.BOLD, s));
        lbl.setForeground(Color.decode(hexCode));
        lbl.setBounds(x, y, w, h);
        pnl.add(lbl);
        return lbl;
    }

    public static JTextField textBar(JPanel pnl, String Text, String hexCode, int x, int y, int w, int h) {
        JTextField txtBx= new JTextField();
        txtBx.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtBx.setForeground(Color.decode("#CD1C35"));
        txtBx.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        txtBx.setCaretColor(Color.white);
        txtBx.setBorder(null);
        txtBx.setOpaque(false);
        txtBx.setBounds(x, y, w, h);
        pnl.add(txtBx);

        JLabel txtBoxBar = new JLabel();
        txtBoxBar.setBounds(x, y+30, w, 3);
        txtBoxBar.setOpaque(true);
        txtBoxBar.setBackground(Color.decode("#CD1C35"));
        pnl.add(txtBoxBar);
        return txtBx;
    }

}