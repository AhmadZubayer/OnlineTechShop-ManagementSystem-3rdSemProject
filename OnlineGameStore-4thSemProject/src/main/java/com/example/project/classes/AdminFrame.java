package com.example.project.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminFrame implements ActionListener {
    public JFrame adminFrm;
    public JPanel pnl1,pnlTabs,pnlOthersTab, pnlTools;
    public JLabel lblUserBar;
    public JButton btnUser,btnPowerSupply, btnInventory, btnEmp, btnOthers;
    public JPanel  pnlDBTable, pnlButtons ;
    public JPanel pnlButtonsSales, pnlEmp;
    public JButton btnSales, btnCustomerAcc, btnOrders, btnPayments, btnOthers1, btnOthers2;
    public JButton btnAll, btnCPU, btnGPU, btnMemory, btnStorage, btnMotherboard, btnCase, btnCooler, btnConsoles, btnAccessories, btnGames;

    Color hoverTextColor = Color.decode("#9763F6");



    public AdminFrame() {
        // Main Frame
        adminFrm = new JFrame("AdminFrame");
        adminFrm.getContentPane().setBackground(Color.decode("#1d2a35"));
        adminFrm.setSize(1700, 1020);
        adminFrm.setLayout(null);
        adminFrm.setLocationRelativeTo(null);
        adminFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrm.setResizable(false);

        // Upper Panel
        pnl1 = new JPanel();
        pnl1.setLayout(null);
        pnl1.setBackground(Color.decode("#1d2a35"));
        pnl1.setBounds(0, 0, 1700, 85);
        adminFrm.add(pnl1);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("Files\\adminpanel.png"));
        JLabel lblGTitle = new JLabel(icon);
        lblGTitle.setBounds(0, 5,600, 80);
        pnl1.add(lblGTitle);

        // Accounts Button
        btnUser = new JButton();
        btnUser.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Files\\ACCOUNT.png")));
        btnUser.setContentAreaFilled(false);
        btnUser.setBorderPainted(false);
        btnUser.setBounds(1310, 3, 120, 70);
        btnUser.addActionListener(this);
        pnl1.add(btnUser);

        lblUserBar = new JLabel();
        lblUserBar.setBounds(1310, 73, 120, 7);
        lblUserBar.setOpaque(true);
        lblUserBar.setBackground(Color.decode("#fe9104"));
        lblUserBar.setVisible(true);
        pnl1.add(lblUserBar);


        // Main big panel to hold the tabs
        pnlTabs = new JPanel();
        pnlTabs.setLayout(null);
        pnlTabs.setBackground(Color.decode("#1d2a35"));
        pnlTabs.setBounds(150, 85, 1300, 45);
        pnlTabs.setVisible(true);
        adminFrm.add(pnlTabs);

        pnlTools = new JPanel();
        pnlTools.setLayout(null);
        pnlTools.setBackground(Color.decode("#1d2a35"));
        pnlTools.setBounds(0,130 , 1700, 85);

        pnlDBTable = new JPanel();
        pnlDBTable.setLayout(new BorderLayout());
        pnlDBTable.setBackground(Color.decode("#1d2a35"));
        pnlDBTable.setBounds(300, 200, 1250, 780);
        pnlDBTable.setVisible(true);
        adminFrm.add(pnlDBTable);


        btnSales = new JButton("SALES");
        btnSales.setBounds(200, 10, 250, 35);
        tabBtnDesigns(btnSales);
        btnSales.addActionListener(this);
        pnlTabs.add(btnSales);

        btnInventory = new JButton("INVENTORY");
        btnInventory.setBounds(450, 10, 250, 35);
        tabBtnDesigns(btnInventory);
        btnInventory.addActionListener(this);
        pnlTabs.add(btnInventory);


        btnEmp = new JButton("EMPLOYEES");
        btnEmp.setBounds(700, 10, 260, 35);
        tabBtnDesigns(btnEmp);
        btnEmp.addActionListener(this);
        pnlTabs.add(btnEmp);


        btnOthers = new JButton("OTHERS");
        btnOthers.setBounds(960, 10, 200, 35);
        tabBtnDesigns(btnOthers);
        btnOthers.addActionListener(this);
        pnlTabs.add(btnOthers);


       // Sales part starts here-----------------------------------------------------
        pnlButtonsSales = new JPanel();
        pnlButtonsSales.setLayout(null);
        pnlButtonsSales.setBackground(Color.decode("#1d2a35"));
        pnlButtonsSales.setBounds(30, 350, 230, 500);
        pnlButtonsSales.setVisible(true);
        adminFrm.add(pnlButtonsSales);

        btnOrders = new JButton("ORDERS");
        btnOrders.setBounds(0, 0, 225, 35);

        btnPayments = new JButton("PAYMENTS");
        btnPayments.setBounds(0, 50, 225, 35);

        btnCustomerAcc = new JButton("CUSTOMERS");
        btnCustomerAcc.setBounds(0, 100, 225, 35);

        btnOthers1 = new JButton("OTHERS");
        btnOthers1.setBounds(0, 150, 225, 35);

        btnOthers2 = new JButton("OTHERS");
        btnOthers2.setBounds(0, 200, 225, 35);

        leftBtnDesigns(btnOrders);
        leftBtnDesigns(btnPayments);
        leftBtnDesigns(btnCustomerAcc);
        leftBtnDesigns(btnOthers1);
        leftBtnDesigns(btnOthers2);

        btnOrders.addActionListener(this);
        btnPayments.addActionListener(this);
        btnCustomerAcc.addActionListener(this);
        btnOthers.addActionListener(this);
        btnOthers1.addActionListener(this);

        pnlButtonsSales.add(btnOrders);
        pnlButtonsSales.add(btnPayments);
        pnlButtonsSales.add(btnCustomerAcc);
        pnlButtonsSales.add(btnOthers1);
        btnOthers2.addActionListener(this);
        //pnlButtonsSales.add(btnOthers2);




        
        // Inventory Tab Starts here-----------------------------------------------------------------
        pnlButtons = new JPanel();
        pnlButtons.setLayout(null);
        pnlButtons.setBackground(Color.decode("#1d2a35"));
        pnlButtons.setBounds(30, 250, 230, 600);
        adminFrm.add(pnlButtons);
        pnlButtons.setVisible(false);


        btnAll = new JButton("ALL");
        btnAll.setBounds(0, 0, 225, 35);

        btnCPU = new JButton("PROCESSOR");
        btnCPU.setBounds(0, 50, 225, 35);

        btnGPU = new JButton("GRAPHICS");
        btnGPU.setBounds(0, 100, 225, 35);

        btnMemory = new JButton("MEMORY");
        btnMemory.setBounds(0, 150, 225, 35);

        btnStorage = new JButton("STORAGE");
        btnStorage.setBounds(0, 200, 225, 35);

        btnMotherboard = new JButton("MOTHERBOARD");
        btnMotherboard.setBounds(0, 250, 225, 35);

        btnCooler = new JButton("COOLER");
        btnCooler.setBounds(0, 300, 225, 35);

        btnPowerSupply = new JButton("POWER SUPPLY");
        btnPowerSupply.setBounds(0, 350, 225, 35);

        btnCase = new JButton("CASE");
        btnCase.setBounds(0, 400, 225, 35);

        btnConsoles = new JButton("CONSOLES");
        btnConsoles.setBounds(0, 450, 225, 35);

        btnAccessories = new JButton("ACCESSORIES");
        btnAccessories.setBounds(0, 500, 225, 35);

        btnGames = new JButton("GAMES");
        btnGames.setBounds(0, 550, 225, 35);

        leftBtnDesigns(btnAll);
        leftBtnDesigns(btnCPU);
        leftBtnDesigns(btnGPU);
        leftBtnDesigns(btnMemory);
        leftBtnDesigns(btnStorage);
        leftBtnDesigns(btnMotherboard);
        leftBtnDesigns(btnCooler);
        leftBtnDesigns(btnPowerSupply);
        leftBtnDesigns(btnCase);
        leftBtnDesigns(btnConsoles);
        leftBtnDesigns(btnAccessories);
        leftBtnDesigns(btnGames);

        btnAll.addActionListener(this);
        btnCPU.addActionListener(this);
        btnGPU.addActionListener(this);
        btnMemory.addActionListener(this);
        btnStorage.addActionListener(this);
        btnMotherboard.addActionListener(this);
        btnCooler.addActionListener(this);
        btnPowerSupply.addActionListener(this);
        btnCase.addActionListener(this);
        btnConsoles.addActionListener(this);
        btnAccessories.addActionListener(this);
        btnGames.addActionListener(this);

        pnlButtons.add(btnAll);
        pnlButtons.add(btnCPU);
        pnlButtons.add(btnGPU);
        pnlButtons.add(btnMemory);
        pnlButtons.add(btnStorage);
        pnlButtons.add(btnMotherboard);
        pnlButtons.add(btnCooler);
        pnlButtons.add(btnPowerSupply);
        pnlButtons.add(btnCase);
        pnlButtons.add(btnConsoles);
        pnlButtons.add(btnAccessories);
        pnlButtons.add(btnGames);



       
        // Emp Tab-------------------------------------------------------------------
        pnlEmp = new JPanel();
        pnlEmp.setLayout(null);
        pnlEmp.setBackground(Color.decode("#1d2a35"));
        pnlEmp.setBounds(0, 130, 1280, 800);
        pnlEmp.setVisible(false);
        adminFrm.add(pnlEmp);

        // Others Tab------------------------------------------------------------------
        pnlOthersTab = new JPanel();
        pnlOthersTab.setLayout(null);
        pnlOthersTab.setBackground(Color.decode("#1d2a35"));
        pnlOthersTab.setBounds(0, 130, 1280, 800);
        pnlOthersTab.setVisible(false);
        adminFrm.add(pnlOthersTab);


        adminFrm.setVisible(true);
    }

    public static void main(String[] args) {
            new AdminFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton[] allLeftBtns = {
                btnOrders, btnPayments, btnCustomerAcc, btnOthers1,
                btnAll, btnCPU, btnGPU, btnMemory, btnStorage,
                btnMotherboard, btnCooler, btnCase, btnPowerSupply,
                btnConsoles, btnAccessories, btnGames
        };

        JButton[] allTabBtns = {btnSales, btnInventory, btnEmp, btnOthers};


        if(e.getSource() == btnSales) {
            pnlButtonsSales.setVisible(true);
            pnlButtons.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedTabBtn(btnSales, allTabBtns);
            pressedBtn(btnOrders, allLeftBtns);
        } else if (e.getSource() == btnOrders) {
            pnlButtonsSales.setVisible(true);
            pnlButtons.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedTabBtn(btnSales, allTabBtns);
            pressedBtn(btnOrders, allLeftBtns);
        } else if (e.getSource() == btnPayments) {
            pnlButtonsSales.setVisible(true);
            pnlButtons.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedTabBtn(btnSales, allTabBtns);
            pressedBtn(btnPayments, allLeftBtns);
        } else if (e.getSource() == btnCustomerAcc) {
            pnlButtonsSales.setVisible(true);
            pnlButtons.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedTabBtn(btnSales, allTabBtns);
            pressedBtn(btnCustomerAcc, allLeftBtns);
            showTable("Customer");
        } else if (e.getSource() == btnOthers1) {
            pnlButtonsSales.setVisible(true);
            pnlButtons.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedTabBtn(btnSales, allTabBtns);
            pressedBtn(btnOthers1, allLeftBtns);
        } else if (e.getSource() == btnOthers2) {
            pnlButtonsSales.setVisible(true);
            pnlButtons.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedTabBtn(btnSales, allTabBtns);
            pressedBtn(btnOthers2, allLeftBtns);
        } else if (e.getSource() == btnInventory) {
            pnlButtonsSales.setVisible(false);
            pnlButtons.setVisible(true);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedTabBtn(btnInventory, allTabBtns);
            pressedBtn(btnAll, allLeftBtns);
        } else if (e.getSource() == btnAll) {
            pressedBtn(btnAll, allLeftBtns);
        } else if (e.getSource() == btnCPU) {
            pnlButtonsSales.setVisible(false);
            pnlButtons.setVisible(true);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedTabBtn(btnInventory, allTabBtns);
            pressedBtn(btnCPU, allLeftBtns);
        } else if (e.getSource() == btnGPU) {
            pnlButtonsSales.setVisible(false);
            pnlButtons.setVisible(true);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedTabBtn(btnInventory, allTabBtns);
            pressedBtn(btnGPU, allLeftBtns);
        } else if (e.getSource() == btnMemory) {
            pnlButtonsSales.setVisible(false);
            pnlButtons.setVisible(true);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedTabBtn(btnInventory, allTabBtns);
            pressedBtn(btnMemory, allLeftBtns);
        } else if (e.getSource() == btnStorage) {
            pnlButtonsSales.setVisible(false);
            pnlButtons.setVisible(true);
            pnlOthersTab.setVisible(false);
            pressedTabBtn(btnInventory, allTabBtns);
            pressedBtn(btnStorage, allLeftBtns);
        } else if (e.getSource() == btnMotherboard) {
            pnlButtonsSales.setVisible(false);
            pnlButtons.setVisible(true);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedTabBtn(btnInventory, allTabBtns);
            pressedBtn(btnMotherboard, allLeftBtns);
        } else if (e.getSource() == btnCooler) {
            pnlButtonsSales.setVisible(false);
            pnlButtons.setVisible(true);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedTabBtn(btnInventory, allTabBtns);
            pressedBtn(btnCooler, allLeftBtns);

        } else if (e.getSource() == btnCase) {
            pnlButtonsSales.setVisible(false);
            pnlButtons.setVisible(true);
            pnlOthersTab.setVisible(false);
            pressedBtn(btnCase, allLeftBtns);
            pressedTabBtn(btnInventory, allTabBtns);
        } else if (e.getSource() == btnPowerSupply) {
            pnlButtonsSales.setVisible(false);
            pnlButtons.setVisible(true);
            pnlOthersTab.setVisible(false);
            pressedBtn(btnPowerSupply, allLeftBtns);
        } else if (e.getSource() == btnConsoles) {
            pressedBtn(btnConsoles, allLeftBtns);
        } else if (e.getSource() == btnAccessories) {
            pressedBtn(btnAccessories, allLeftBtns);
        } else if (e.getSource() == btnGames) {
            pressedBtn(btnGames, allLeftBtns);
        } else if (e.getSource() == btnEmp) {
            pnlButtonsSales.setVisible(false);
            pnlButtons.setVisible(false);
            pnlEmp.setVisible(true);
            pnlOthersTab.setVisible(false);
            pressedTabBtn(btnEmp, allTabBtns);
        } else if (e.getSource() == btnOthers) {
            pnlButtonsSales.setVisible(false);
            pnlButtons.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(true);
            pressedTabBtn(btnOthers, allTabBtns);
        }
    }

    public static void pressedBtn(JButton selectedButton, JButton[] allButtons) {

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



    private void leftBtnDesigns(JButton btnLeft) {

        btnLeft.setFont(new Font("Roboto", Font.BOLD, 17));
        btnLeft.setForeground(Color.WHITE);
        btnLeft.setBackground(Color.decode("#2C3E50"));
        btnLeft.setContentAreaFilled(true);
        btnLeft.setBorder(BorderFactory.createEmptyBorder());
        btnLeft.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnLeft.setForeground(hoverTextColor);
                btnLeft.setBorder(BorderFactory.createLineBorder(hoverTextColor, 4));
            }

            public void mouseExited(MouseEvent e) {
                btnLeft.setForeground(Color.WHITE);
                btnLeft.setBorder(BorderFactory.createEmptyBorder());
            }
        });
    }

    private void tabBtnDesigns(JButton btnTabs) {
        btnTabs.setFont(new Font("Roboto", Font.BOLD, 17));
        btnTabs.setForeground(Color.decode("#FFF8F0"));
        btnTabs.setBackground(Color.decode("#2C3E50"));
        btnTabs.setContentAreaFilled(true);
        btnTabs.setBorderPainted(false);
        /*btnTabs.setBorder(BorderFactory.createEmptyBorder());
        btnTabs.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnTabs.setBackground(Color.decode("#1d2a35"));
                btnTabs.setBorder(BorderFactory.createLineBorder(hoverTextColor, 9));
            }

            public void mouseExited(MouseEvent e) {
                btnTabs.setBackground(Color.decode("#2C3E50"));
                btnTabs.setBorder(BorderFactory.createEmptyBorder());
            }
        }); */
    }



    private void showTable(String tableType) {
        AdminTableViews adminTableViews = new AdminTableViews();
        JScrollPane tableScrollPane;

        switch (tableType) {
            case "Customer":
                tableScrollPane = adminTableViews.viewCustomerTable();
                break;
            default:
                throw new IllegalArgumentException("Unknown table type: " + tableType);
        }
        pnlDBTable.removeAll();
        pnlDBTable.add(tableScrollPane, BorderLayout.CENTER);
        pnlDBTable.revalidate();
        pnlDBTable.repaint();
    }



}

