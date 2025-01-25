package com.example.project.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminFrame implements ActionListener {
    public JFrame adminFrm;
    public JPanel pnl1, pnlAccount, pnlTabs,pnlOthersTab;
    public JLabel lbl1, lblAccDetails, lblNAME, lblUserAddress, lblADDRESS, lblUserPhone, lblPHONE, lblUserName, lblCART, lblCartBar, lblUserBar, lblTotalPrice;
    public JButton btnViewHome, btnUser, btnBack, btnEditDetails,btnPowerSupply, btnInventory, btnEmp, btnOthers,  btnBackCart;
    public JPanel  pnlPCComponents, pnlButtons, pnlCPU, pnlGPU, pnlMemory, pnlStorage, pnlMotherboard, pnlCase, pnlCooler, pnlPowerSupply ;
    public JPanel pnlButtonsSales, pnlOrders, pnlPayments, pnlCustomerAcc, pnlOthers, pnlOthers2, pnlEmp;
    //public JButton btnInventory;
    public JButton btnSales, btnCustomerAcc, btnOrders, btnPayments, btnOthers1, btnOthers2, btnOthers3, btnOthers4;
    //public JButton btnEmp;
    //public JButton btnOthers;
    public JButton btnAll, btnCPU, btnGPU, btnMemory, btnStorage, btnMotherboard, btnCase, btnCooler, btnConsoles, btnAccessories, btnGames;

    Color hoverTextColor = Color.decode("#9763F6");
    Color originalColor = Color.decode("#2C3E50");



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

        ImageIcon icong = new ImageIcon(getClass().getClassLoader().getResource("Files\\adminpanel.png"));
        JLabel lblGTitle = new JLabel(icong);
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

        pnlAccount = new JPanel();
        pnlAccount.setLayout(null);
        pnlAccount.setBackground(Color.decode("#1d2a35"));
        pnlAccount.setBounds(1300, 80, 400, 940);
        pnlAccount.setVisible(true);
        adminFrm.add(pnlAccount);

        lblAccDetails = new JLabel("Account Credentials");
        lblAccDetails.setBounds(30, 20, 250, 30);
        lblAccDetails.setFont(new Font("Roboto", Font.BOLD, 23));
        lblAccDetails.setForeground(Color.WHITE);
        pnlAccount.add(lblAccDetails);

        lblNAME = new JLabel("NAME");
        lblNAME.setBounds(30, 70, 200, 25);
        lblNAME.setFont(new Font("Roboto", Font.PLAIN, 17));
        lblNAME.setForeground(Color.WHITE);
        pnlAccount.add(lblNAME);

        lblUserName = new JLabel("Ahmad Zubayer");
        lblUserName.setBounds(30, 110, 200, 30);
        lblUserName.setFont(new Font("Roboto", Font.BOLD, 20));
        lblUserName.setForeground(Color.WHITE);
        pnlAccount.add(lblUserName);

        lblPHONE = new JLabel("PHONE NUMBER");
        lblPHONE.setBounds(30, 160, 200, 25);
        lblPHONE.setFont(new Font("Roboto", Font.PLAIN, 17));
        lblPHONE.setForeground(Color.WHITE);
        pnlAccount.add(lblPHONE);

        lblUserPhone = new JLabel("0100000000");
        lblUserPhone.setBounds(30, 200, 200, 30);
        lblUserPhone.setFont(new Font("Roboto", Font.BOLD, 20));
        lblUserPhone.setForeground(Color.WHITE);
        pnlAccount.add(lblUserPhone);

        lblADDRESS = new JLabel("ADDRESS");
        lblADDRESS.setBounds(30, 250, 200, 25);
        lblADDRESS.setFont(new Font("Roboto", Font.PLAIN, 17));
        lblADDRESS.setForeground(Color.WHITE);
        pnlAccount.add(lblADDRESS);

        lblUserAddress = new JLabel("AIUB");
        lblUserAddress.setBounds(30, 290, 200, 30);
        lblUserAddress.setFont(new Font("Roboto", Font.BOLD, 20));
        lblUserAddress.setForeground(Color.WHITE);
        pnlAccount.add(lblUserAddress);

        btnEditDetails = new JButton("Edit Account Info");
        btnEditDetails.setFont(new Font("Roboto", Font.BOLD, 17));
        btnEditDetails.setForeground(Color.decode("#2C3E50"));
        btnEditDetails.setBackground(Color.decode("#FFF8F0"));
        btnEditDetails.setContentAreaFilled(true);
        btnEditDetails.setBorderPainted(false);
        btnEditDetails.setBounds(90, 440, 200, 35);
        pnlAccount.add(btnEditDetails);

        btnViewHome = new JButton("View Store Homepage As Customer >");
        btnViewHome.setFont(new Font("Roboto", Font.PLAIN, 15));
        btnViewHome.setForeground(Color.decode("#04aa6d"));
        btnViewHome.setContentAreaFilled(false);
        btnViewHome.setBorderPainted(false);
        btnViewHome.setFocusPainted(false);
        btnViewHome.setOpaque(false);
        btnViewHome.setBounds(60, 750, 300, 35);
        btnViewHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnViewHome.addActionListener(this);
        btnViewHome.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnViewHome.setFont(new Font("Roboto", Font.BOLD, 17));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnViewHome.setFont(new Font("Roboto", Font.PLAIN, 15));
            }
        });
        btnViewHome.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#04aa6d")));
        pnlAccount.add(btnViewHome);


        btnBack = new JButton("< SIGN OUT");
        btnBack.setFont(new Font("Roboto", Font.BOLD, 17));
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(Color.decode("#9763F6"));
        btnBack.setContentAreaFilled(true);
        btnBack.setBorderPainted(false);
        btnBack.setBounds(130, 520, 125, 35);
        pnlAccount.add(btnBack);




        // Main big panel to hold the tabs
        pnlTabs = new JPanel();
        pnlTabs.setLayout(null);
        pnlTabs.setBackground(Color.decode("#1d2a35"));
        pnlTabs.setBounds(0, 85, 1300, 45);
        pnlTabs.setVisible(true);
        adminFrm.add(pnlTabs);

        btnSales = new JButton("SALES");
        btnSales.setFont(new Font("Roboto", Font.BOLD, 17));
        btnSales.setForeground(Color.decode("#2C3E50"));
        btnSales.setBackground(Color.decode("#FFF8F0"));
        btnSales.setContentAreaFilled(true);
        btnSales.setBorderPainted(false);
        btnSales.setBounds(200, 10, 250, 35);
        pnlTabs.add(btnSales);
        btnSales.addActionListener(this);


        btnInventory = new JButton("INVENTORY");
        btnInventory.setFont(new Font("Roboto", Font.BOLD, 17));
        btnInventory.setForeground(Color.decode("#FFF8F0"));
        btnInventory.setBackground(Color.decode("#2C3E50"));
        btnInventory.setContentAreaFilled(true);
        btnInventory.setBorderPainted(false);
        btnInventory.setBounds(450, 10, 250, 35);
        pnlTabs.add(btnInventory);
        btnInventory.addActionListener(this);

        btnEmp = new JButton("EMPLOYEES");
        btnEmp.setFont(new Font("Roboto", Font.BOLD, 17));
        btnEmp.setForeground(Color.decode("#FFF8F0"));
        btnEmp.setBackground(Color.decode("#2C3E50"));
        btnEmp.setContentAreaFilled(true);
        btnEmp.setBorderPainted(false);
        btnEmp.setBounds(700, 10, 260, 35);
        pnlTabs.add(btnEmp);
        btnEmp.addActionListener(this);

        btnOthers = new JButton("OTHERS");
        btnOthers.setFont(new Font("Roboto", Font.BOLD, 17));
        btnOthers.setForeground(Color.decode("#FFF8F0"));
        btnOthers.setBackground(Color.decode("#2C3E50"));
        btnOthers.setContentAreaFilled(true);
        btnOthers.setBorderPainted(false);
        btnOthers.setBounds(960, 10, 200, 35);
        btnOthers.addActionListener(this);
        pnlTabs.add(btnOthers);


       // Sales part starts here-----------------------------------------------------
        pnlButtonsSales = new JPanel();
        pnlButtonsSales.setLayout(null);
        pnlButtonsSales.setBackground(Color.decode("#1d2a35"));
        pnlButtonsSales.setBounds(10, 350, 230, 500);
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


        pnlOrders = new JPanel();
        pnlOrders.setLayout(null);
        pnlOrders.setBackground(Color.decode("#1d2a35"));
        pnlOrders.setBounds(250, 130, 1050, 800);
        pnlOrders.setVisible(false);
        adminFrm.add(pnlOrders);

        pnlPayments = new JPanel();
        pnlPayments.setLayout(null);
        pnlPayments.setBackground(Color.decode("#1d2a35"));
        pnlPayments.setBounds(250, 130, 1050, 800);
        pnlPayments.setVisible(false);
        adminFrm.add(pnlPayments);

        pnlCustomerAcc = new JPanel();
        pnlCustomerAcc.setLayout(new BorderLayout());
        pnlCustomerAcc.setBackground(Color.decode("#1d2a35"));
        pnlCustomerAcc.setBounds(250, 130, 1050, 800);
        pnlCustomerAcc.setVisible(false);
        adminFrm.add(pnlCustomerAcc);

        pnlOthers = new JPanel();
        pnlOthers.setLayout(null);
        pnlOthers.setBackground(Color.decode("#1c2121"));
        pnlOthers.setBounds(250, 130, 1050, 800);
        pnlOthers.setVisible(false);
        adminFrm.add(pnlOthers);

        pnlOthers2 = new JPanel();
        pnlOthers2.setLayout(null);
        pnlOthers2.setBackground(Color.decode("#1b3536"));
        pnlOthers2.setBounds(250, 130, 1050, 800);
        pnlOthers2.setVisible(false);
        adminFrm.add(pnlOthers2);

        
        // Inventory Tab Starts here-----------------------------------------------------------------
        pnlButtons = new JPanel();
        pnlButtons.setLayout(null);
        pnlButtons.setBackground(Color.decode("#1d2a35"));
        pnlButtons.setBounds(10, 350, 230, 600);
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

        pnlCPU = new JPanel();
        pnlCPU.setLayout(null);
        pnlCPU.setBackground(Color.decode("#1d2a35"));
        pnlCPU.setBounds(250, 130, 1050, 800);
        pnlCPU.setVisible(false);
        adminFrm.add(pnlCPU);

        pnlGPU = new JPanel();
        pnlGPU.setLayout(null);
        pnlGPU.setBackground(Color.decode("#454647"));
        pnlGPU.setBounds(250, 130, 1050, 800);
        pnlGPU.setVisible(false);
        adminFrm.add(pnlGPU);

        pnlMemory = new JPanel();
        pnlMemory.setLayout(new GridLayout(1, 4, 30, 30));
        pnlMemory.setBackground(Color.decode("#dae7f5"));
        pnlMemory.setBounds(250, 130, 1050, 800);
        pnlMemory.setVisible(false);
        adminFrm.add(pnlMemory);

        pnlStorage = new JPanel();
        pnlStorage.setLayout(new GridLayout(1, 4, 30, 30));
        pnlStorage.setBackground(Color.decode("#9aa2ab"));
        pnlStorage.setBounds(250, 130, 1050, 800);
        pnlStorage.setVisible(false);
        adminFrm.add(pnlStorage);

        pnlMotherboard = new JPanel();
        pnlMotherboard.setLayout(null);
        pnlMotherboard.setBackground(Color.decode("#03172b"));
        pnlMotherboard.setBounds(250, 130, 1050, 800);
        pnlMotherboard.setVisible(false);
        adminFrm.add(pnlMotherboard);

        pnlCase = new JPanel();
        pnlCase.setLayout(null);
        pnlCase.setBackground(Color.decode("#007af5"));
        pnlCase.setBounds(250, 130, 1050, 800);
        pnlCase.setVisible(false);
        adminFrm.add(pnlCase);

        pnlCooler = new JPanel();
        pnlCooler.setLayout(null);
        pnlCooler.setBackground(Color.decode("#93c0ed"));
        pnlCooler.setBounds(250, 130, 1050, 800);
        pnlCooler.setVisible(false);
        adminFrm.add(pnlCooler);

        pnlPowerSupply = new JPanel();
        pnlPowerSupply.setLayout(null);
        pnlPowerSupply.setBackground(Color.decode("#3b80c4"));
        pnlPowerSupply.setBounds(250, 130, 1050, 800);
        pnlPowerSupply.setVisible(false);
        adminFrm.add(pnlPowerSupply);

       
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


        btnUser.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnUser.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Files\\ACCOUNT hover.jpg")));

            }

            public void mouseExited(MouseEvent e) {
                btnUser.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Files\\ACCOUNT.png")));
            }
        });


        btnEditDetails.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnEditDetails.setBackground(Color.decode("#fe9104"));
            }

            public void mouseExited(MouseEvent e) {
                btnEditDetails.setBackground(Color.decode("#fff8f0"));
            }
        });



        addTables();
        btnBack.addActionListener(this);
        adminFrm.setVisible(true);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AdminFrame();

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton[] allLeftBtns = {
                btnAll, btnCPU, btnGPU, btnMemory, btnStorage,
                btnMotherboard, btnCooler, btnCase, btnPowerSupply,
                btnConsoles, btnAccessories, btnGames
        };


        if(e.getSource() == btnSales) {
            pnlButtonsSales.setVisible(true);
            pnlOrders.setVisible(true);
            pnlPayments.setVisible(false);
            pnlCustomerAcc.setVisible(false);
            pnlOthers.setVisible(false);
            pnlOthers2.setVisible(false);
            pnlButtons.setVisible(false);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlPowerSupply.setVisible(false);
            pnlCase.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            btnSales.setForeground(Color.decode("#2C3E50"));
            btnSales.setBackground(Color.decode("#FFF8F0"));
            btnInventory.setForeground(Color.decode("#FFF8F0"));
            btnInventory.setBackground(Color.decode("#2C3E50"));
            btnEmp.setForeground(Color.decode("#FFF8F0"));
            btnEmp.setBackground(Color.decode("#2C3E50"));
            btnOthers.setForeground(Color.decode("#FFF8F0"));
            btnOthers.setBackground(Color.decode("#2C3E50"));
            btnOrders.setForeground(Color.decode("#FFF8F0"));
            btnOrders.setBackground(Color.decode("#04aa6d"));
            btnPayments.setBackground(Color.decode("#2C3E50"));
            btnPayments.setForeground(Color.decode("#FFF8F0"));
            btnCustomerAcc.setBackground(Color.decode("#2C3E50"));
            btnCustomerAcc.setForeground(Color.decode("#FFF8F0"));
            btnOthers1.setBackground(Color.decode("#2C3E50"));
            btnOthers1.setForeground(Color.decode("#FFF8F0"));
            btnOthers2.setBackground(Color.decode("#2C3E50"));
            btnOthers2.setForeground(Color.decode("#FFF8F0"));
        } else if (e.getSource() == btnOrders) {
            pnlButtonsSales.setVisible(true);
            pnlOrders.setVisible(true);
            pnlPayments.setVisible(false);
            pnlCustomerAcc.setVisible(false);
            pnlOthers.setVisible(false);
            pnlOthers2.setVisible(false);
            pnlButtons.setVisible(false);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlPowerSupply.setVisible(false);
            pnlCase.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            btnOrders.setForeground(Color.decode("#FFF8F0"));
            btnOrders.setBackground(Color.decode("#04aa6d"));
            btnPayments.setBackground(Color.decode("#2C3E50"));
            btnPayments.setForeground(Color.decode("#FFF8F0"));
            btnCustomerAcc.setBackground(Color.decode("#2C3E50"));
            btnCustomerAcc.setForeground(Color.decode("#FFF8F0"));
            btnOthers1.setBackground(Color.decode("#2C3E50"));
            btnOthers1.setForeground(Color.decode("#FFF8F0"));
            btnOthers2.setBackground(Color.decode("#2C3E50"));
            btnOthers2.setForeground(Color.decode("#FFF8F0"));
        } else if (e.getSource() == btnPayments) {
            pnlButtonsSales.setVisible(true);
            pnlOrders.setVisible(false);
            pnlPayments.setVisible(true);
            pnlCustomerAcc.setVisible(false);
            pnlOthers.setVisible(false);
            pnlOthers2.setVisible(false);
            pnlButtons.setVisible(false);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlPowerSupply.setVisible(false);
            pnlCase.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            btnPayments.setForeground(Color.decode("#FFF8F0"));
            btnPayments.setBackground(Color.decode("#04aa6d"));
            btnOrders.setBackground(Color.decode("#2C3E50"));
            btnOrders.setForeground(Color.decode("#FFF8F0"));
            btnCustomerAcc.setBackground(Color.decode("#2C3E50"));
            btnCustomerAcc.setForeground(Color.decode("#FFF8F0"));
            btnOthers1.setBackground(Color.decode("#2C3E50"));
            btnOthers1.setForeground(Color.decode("#FFF8F0"));
            btnOthers2.setBackground(Color.decode("#2C3E50"));
            btnOthers2.setForeground(Color.decode("#FFF8F0"));
        } else if (e.getSource() == btnCustomerAcc) {
            pnlButtonsSales.setVisible(true);
            pnlOrders.setVisible(false);
            pnlPayments.setVisible(false);
            pnlCustomerAcc.setVisible(true);
            pnlOthers.setVisible(false);
            pnlOthers2.setVisible(false);
            pnlButtons.setVisible(false);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlPowerSupply.setVisible(false);
            pnlCase.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            btnCustomerAcc.setForeground(Color.decode("#FFF8F0"));
            btnCustomerAcc.setBackground(Color.decode("#04aa6d"));
            btnPayments.setBackground(Color.decode("#2C3E50"));
            btnPayments.setForeground(Color.decode("#FFF8F0"));
            btnOrders.setBackground(Color.decode("#2C3E50"));
            btnOrders.setForeground(Color.decode("#FFF8F0"));
            btnOthers1.setBackground(Color.decode("#2C3E50"));
            btnOthers1.setForeground(Color.decode("#FFF8F0"));
            btnOthers2.setBackground(Color.decode("#2C3E50"));
            btnOthers2.setForeground(Color.decode("#FFF8F0"));
            addTables();
        } else if (e.getSource() == btnOthers1) {
            pnlButtonsSales.setVisible(true);
            pnlOrders.setVisible(false);
            pnlPayments.setVisible(false);
            pnlCustomerAcc.setVisible(false);
            pnlOthers.setVisible(true);
            pnlOthers2.setVisible(false);
            pnlButtons.setVisible(false);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlPowerSupply.setVisible(false);
            pnlCase.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            btnOthers1.setForeground(Color.decode("#FFF8F0"));
            btnOthers1.setBackground(Color.decode("#04aa6d"));
            btnPayments.setBackground(Color.decode("#2C3E50"));
            btnPayments.setForeground(Color.decode("#FFF8F0"));
            btnCustomerAcc.setBackground(Color.decode("#2C3E50"));
            btnCustomerAcc.setForeground(Color.decode("#FFF8F0"));
            btnOrders.setBackground(Color.decode("#2C3E50"));
            btnOrders.setForeground(Color.decode("#FFF8F0"));
            btnOthers2.setBackground(Color.decode("#2C3E50"));
            btnOthers2.setForeground(Color.decode("#FFF8F0"));
        } else if (e.getSource() == btnOthers2) {
            pnlButtonsSales.setVisible(true);
            pnlOrders.setVisible(false);
            pnlPayments.setVisible(false);
            pnlCustomerAcc.setVisible(false);
            pnlOthers.setVisible(false);
            pnlOthers2.setVisible(true);
            pnlButtons.setVisible(false);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlPowerSupply.setVisible(false);
            pnlCase.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            btnOthers2.setForeground(Color.decode("#FFF8F0"));
            btnOthers2.setBackground(Color.decode("#04aa6d"));
            btnPayments.setBackground(Color.decode("#2C3E50"));
            btnPayments.setForeground(Color.decode("#FFF8F0"));
            btnCustomerAcc.setBackground(Color.decode("#2C3E50"));
            btnCustomerAcc.setForeground(Color.decode("#FFF8F0"));
            btnOthers1.setBackground(Color.decode("#2C3E50"));
            btnOthers1.setForeground(Color.decode("#FFF8F0"));
            btnOrders.setBackground(Color.decode("#2C3E50"));
            btnOrders.setForeground(Color.decode("#FFF8F0"));
        } else if (e.getSource() == btnInventory) {
            pnlButtonsSales.setVisible(false);
            pnlOrders.setVisible(false);
            pnlPayments.setVisible(false);
            pnlCustomerAcc.setVisible(false);
            pnlOthers.setVisible(false);
            pnlOthers2.setVisible(false);
            pnlButtons.setVisible(true);
            pnlCPU.setVisible(true);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlPowerSupply.setVisible(false);
            pnlCase.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            btnInventory.setForeground(Color.decode("#2C3E50"));
            btnInventory.setBackground(Color.decode("#FFF8F0"));
            btnSales.setForeground(Color.decode("#FFF8F0"));
            btnSales.setBackground(Color.decode("#2C3E50"));
            btnEmp.setForeground(Color.decode("#FFF8F0"));
            btnEmp.setBackground(Color.decode("#2C3E50"));
            btnOthers.setForeground(Color.decode("#FFF8F0"));
            btnOthers.setBackground(Color.decode("#2C3E50"));
            btnCPU.setForeground(Color.decode("#FFF8F0"));
            btnCPU.setBackground(Color.decode("#04aa6d"));
            btnGPU.setBackground(Color.decode("#2C3E50"));
            btnGPU.setForeground(Color.decode("#FFF8F0"));
            btnMemory.setBackground(Color.decode("#2C3E50"));
            btnMemory.setForeground(Color.decode("#FFF8F0"));
            btnStorage.setBackground(Color.decode("#2C3E50"));
            btnStorage.setForeground(Color.decode("#FFF8F0"));
            btnMotherboard.setBackground(Color.decode("#2C3E50"));
            btnMotherboard.setForeground(Color.decode("#FFF8F0"));
            btnCooler.setBackground(Color.decode("#2C3E50"));
            btnCooler.setForeground(Color.decode("#FFF8F0"));
            btnCase.setBackground(Color.decode("#2C3E50"));
            btnCase.setForeground(Color.decode("#FFF8F0"));
            btnPowerSupply.setBackground(Color.decode("#2C3E50"));
            btnPowerSupply.setForeground(Color.decode("#FFF8F0"));
        } else if (e.getSource() == btnAll) {
            pressedBtn(btnAll, allLeftBtns);
        } else if (e.getSource() == btnCPU) {
            pnlButtonsSales.setVisible(false);
            pnlOrders.setVisible(false);
            pnlPayments.setVisible(false);
            pnlCustomerAcc.setVisible(false);
            pnlOthers.setVisible(false);
            pnlOthers2.setVisible(false);
            pnlButtons.setVisible(true);
            pnlCPU.setVisible(true);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlPowerSupply.setVisible(false);
            pnlCase.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedBtn(btnCPU, allLeftBtns);
        } else if (e.getSource() == btnGPU) {
            pnlButtonsSales.setVisible(false);
            pnlOrders.setVisible(false);
            pnlPayments.setVisible(false);
            pnlCustomerAcc.setVisible(false);
            pnlOthers.setVisible(false);
            pnlOthers2.setVisible(false);
            pnlButtons.setVisible(true);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(true);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlPowerSupply.setVisible(false);
            pnlCase.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedBtn(btnGPU, allLeftBtns);
        } else if (e.getSource() == btnMemory) {
            pnlButtonsSales.setVisible(false);
            pnlOrders.setVisible(false);
            pnlPayments.setVisible(false);
            pnlCustomerAcc.setVisible(false);
            pnlOthers.setVisible(false);
            pnlOthers2.setVisible(false);
            pnlButtons.setVisible(true);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(true);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlPowerSupply.setVisible(false);
            pnlCase.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedBtn(btnMemory, allLeftBtns);
        } else if (e.getSource() == btnStorage) {
            pnlButtonsSales.setVisible(false);
            pnlOrders.setVisible(false);
            pnlPayments.setVisible(false);
            pnlCustomerAcc.setVisible(false);
            pnlOthers.setVisible(false);
            pnlOthers2.setVisible(false);
            pnlButtons.setVisible(true);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(true);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlPowerSupply.setVisible(false);
            pnlCase.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedBtn(btnStorage, allLeftBtns);
        } else if (e.getSource() == btnMotherboard) {
            pnlButtonsSales.setVisible(false);
            pnlOrders.setVisible(false);
            pnlPayments.setVisible(false);
            pnlCustomerAcc.setVisible(false);
            pnlOthers.setVisible(false);
            pnlOthers2.setVisible(false);
            pnlButtons.setVisible(true);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(true);
            pnlCooler.setVisible(false);
            pnlPowerSupply.setVisible(false);
            pnlCase.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedBtn(btnMotherboard, allLeftBtns);
        } else if (e.getSource() == btnCooler) {
            pnlButtonsSales.setVisible(false);
            pnlOrders.setVisible(false);
            pnlPayments.setVisible(false);
            pnlCustomerAcc.setVisible(false);
            pnlOthers.setVisible(false);
            pnlOthers2.setVisible(false);
            pnlButtons.setVisible(true);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(true); // Correct Panel Visibility
            pnlPowerSupply.setVisible(false);
            pnlCase.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);
            pressedBtn(btnCooler, allLeftBtns);

        } else if (e.getSource() == btnCase) {
            pnlButtonsSales.setVisible(false);
            pnlOrders.setVisible(false);
            pnlPayments.setVisible(false);
            pnlCustomerAcc.setVisible(false);
            pnlOthers.setVisible(false);
            pnlOthers2.setVisible(false);
            pnlButtons.setVisible(true);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlPowerSupply.setVisible(false);
            pnlCase.setVisible(true); // Correct Panel Visibility
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(false);

            pressedBtn(btnCase, allLeftBtns);
        } else if (e.getSource() == btnPowerSupply) {
            pnlButtonsSales.setVisible(false);
            pnlOrders.setVisible(false);
            pnlPayments.setVisible(false);
            pnlCustomerAcc.setVisible(false);
            pnlOthers.setVisible(false);
            pnlOthers2.setVisible(false);
            pnlButtons.setVisible(true);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlPowerSupply.setVisible(true);
            pnlCase.setVisible(false);
            pnlEmp.setVisible(false);
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
            pnlOrders.setVisible(false);
            pnlPayments.setVisible(false);
            pnlCustomerAcc.setVisible(false);
            pnlOthers.setVisible(false);
            pnlOthers2.setVisible(false);
            pnlButtons.setVisible(false);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlPowerSupply.setVisible(false);
            pnlCase.setVisible(false);
            pnlEmp.setVisible(true);
            pnlOthersTab.setVisible(false);
            btnEmp.setForeground(Color.decode("#2C3E50"));
            btnEmp.setBackground(Color.decode("#FFF8F0"));
            btnSales.setForeground(Color.decode("#FFF8F0"));
            btnSales.setBackground(Color.decode("#2C3E50"));
            btnInventory.setForeground(Color.decode("#FFF8F0"));
            btnInventory.setBackground(Color.decode("#2C3E50"));
            btnOthers.setForeground(Color.decode("#FFF8F0"));
            btnOthers.setBackground(Color.decode("#2C3E50"));
        } else if (e.getSource() == btnOthers) {
            pnlButtonsSales.setVisible(false);
            pnlOrders.setVisible(false);
            pnlPayments.setVisible(false);
            pnlCustomerAcc.setVisible(false);
            pnlOthers.setVisible(false);
            pnlOthers2.setVisible(false);
            pnlButtons.setVisible(false);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlPowerSupply.setVisible(false);
            pnlCase.setVisible(false);
            pnlEmp.setVisible(false);
            pnlOthersTab.setVisible(true);
            btnOthers.setForeground(Color.decode("#2C3E50"));
            btnOthers.setBackground(Color.decode("#FFF8F0"));
            btnSales.setForeground(Color.decode("#FFF8F0"));
            btnSales.setBackground(Color.decode("#2C3E50"));
            btnInventory.setForeground(Color.decode("#FFF8F0"));
            btnInventory.setBackground(Color.decode("#2C3E50"));
            btnEmp.setForeground(Color.decode("#FFF8F0"));
            btnEmp.setBackground(Color.decode("#2C3E50"));
        } else if (e.getSource() == btnBack) {
            adminFrm.dispose();
            new LoginPage2();
        } else if (e.getSource() == btnViewHome) {
            new HomePage();
        }
    }

    public static void pressedBtn(JButton selectedButton, JButton[] allButtons) {
        // Set selected button's background color and font style
        selectedButton.setBackground(Color.decode("#04aa6d"));
        selectedButton.setForeground(Color.WHITE);
        selectedButton.setFont(new Font("Roboto", Font.BOLD, 17));

        for (JButton btn : allButtons) {
            if (btn != selectedButton) {
                // Reset background color and style for other buttons
                btn.setBackground(Color.decode("#2C3E50"));
                btn.setForeground(Color.WHITE);
            }
        }
    }


    private void leftBtnDesigns(JButton btnLeft) {
        // Set only the initial button styles (no background color change here)
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


    /*private void pnlTables() {
        JPanel pnlTables = new JPanel();
        pnlTables.setLayout(null);
        pnlTables.setBackground(Color.decode("#95adad"));
        pnlTables.setBounds(250, 130, 1050, 800);
    }*/

    private void addTables() {
        AdminTableViews adminTableViews = new AdminTableViews();
        JScrollPane customerTableScrollPane = adminTableViews.viewCustomerTable();
        pnlCustomerAcc.removeAll();
        pnlCustomerAcc.add(customerTableScrollPane, BorderLayout.CENTER);
        pnlCustomerAcc.revalidate();
        pnlCustomerAcc.repaint();
    }



}

