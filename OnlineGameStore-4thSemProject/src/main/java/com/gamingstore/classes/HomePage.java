package com.gamingstore.classes;

import com.gamingstore.classes.DatabaseRW.ProductDatabaseRW;
import com.gamingstore.classes.UIDesign.UIDesign;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomePage implements ActionListener {
    public JFrame frm, frmCart;
    public JPanel pnl1, pnlAccount, pnlCart, pnl4, pnl5, pnlConsoles, pnlPCParts ,pnlAccessories, pnlGames;
    public JLabel lblUser, lblAccDetails, lblNAME, lblUserAddress, lblADDRESS, lblUserPhone, lblPHONE, lblUserName, lblCART, lblCartBar, lblUserBar, lblTotalPrice;
    public JButton btnCart, btnUser, btnBack, btnEditDetails,btnProceedToCheckout, btnConsoles, btnPCComponents, btnAccessories, btnGames,  btnBackCart;
    public JButton btnConsole1, btnConsole2, btnConsole3, btnConsole4, btnConsole5,btnConsole6,btnConsole7,btnConsole8;
    public JButton btnPCComponents1, btnPCComponents2, btnPCComponents3, btnPCComponents4, btnPCComponents5,btnPCComponents6,btnPCComponents7,btnPCComponents8;
    public JButton btnAccessories1, btnAccessories2, btnAccessories3, btnAccessories4, btnAccessories5, btnAccessories6, btnAccessories7, btnAccessories8;
    public JButton btnGames1,btnGames2, btnGames3, btnGames4, btnGames5, btnGames6, btnGames7, btnGames8;
    JButton btnPowerSupply, btnPowerSupply1, btnPowerSupply2, btnPowerSupply3, btnPowerSupply4, btnPCBuilder;
    JPanel  pnlPCComponents, pnlLeftBtns, pnlCPU, pnlGPU, pnlMemory, pnlStorage, pnlMotherboard, pnlCase, pnlCooler, pnlPowerSupply ;

    JButton btnCPU, btnGPU, btnMemory, btnStorage, btnMotherboard, btnCase, btnCooler;
    JButton btnCPU1, btnCPU2, btnCPU3, btnCPU4;
    JButton btnGPU1, btnGPU2, btnGPU3, btnGPU4;
    JButton btnMemory1, btnMemory2, btnMemory3, btnMemory4;
    JButton btnStorage1, btnStorage2, btnStorage3, btnStorage4;
    JButton btnMotherboard1, btnMotherboard2, btnMotherboard3, btnMotherboard4;
    JButton btnCase1, btnCase2, btnCase3, btnCase4;
    JButton btnCooler1, btnCooler2, btnCooler3, btnCooler4;
    private static final String CART_FILE = "cart.txt";
    JTextArea cartTextArea;
    String username;

    //public List<Product> products = new ArrayList<>();


    public HomePage() {
        this.username = CurrentUser.getCurrentUser();
    }

    public void HomePageUI() {
        frm = new JFrame();
        UIDesign.Frm3Design(frm, "Home Page");



        btnBack = new JButton();
        UIDesign.backBtnDesign(btnBack);
        btnBack.setBounds(1430, 850, 125, 35);
        frm.add(btnBack);

        pnl1 = new JPanel();
        pnl1.setLayout(null);
        pnl1.setBackground(Color.decode("#2C3E50"));
        pnl1.setBounds(0, 0, 1700, 80);
        frm.add(pnl1);

        ImageIcon icong = new ImageIcon("Files\\Gameshop.png");
        JLabel lblGTitle = new JLabel(icong);
        lblGTitle.setBounds(0, 10,600, 55);
        pnl1.add(lblGTitle);

        btnPCBuilder = new JButton("BUILD YOUR OWN PC!");
        btnPCBuilder.setFont(new Font("Roboto", Font.BOLD, 17));
        btnPCBuilder.setForeground(Color.decode("#2C3E50"));
        btnPCBuilder.setBackground(Color.decode("#ff8f01"));
        btnPCBuilder.setContentAreaFilled(true);
        btnPCBuilder.setBorderPainted(false);
        btnPCBuilder.setBounds(950, 30, 300, 35);
        pnl1.add(btnPCBuilder);
        btnPCBuilder.addActionListener(this);

        /*lblUser = new JLabel("Hi "  +" !");
        lblUser.setBounds(1000, 30, 200, 40);
        lblUser.setFont(new Font("Roboto", Font.BOLD, 19));
        lblUser.setForeground(decode("#1d2a35"));
        pnl1.add(lblUser);*/

        btnCart = new JButton();
        btnCart.setIcon(new ImageIcon("Files\\YOUR CART.png"));
        btnCart.setContentAreaFilled(false);
        btnCart.setBorderPainted(false);
        btnCart.setBounds(1430, 3, 120, 70);
        btnCart.addActionListener(this);
        pnl1.add(btnCart);


        btnUser = new JButton();
        btnUser.setIcon(new ImageIcon("Files\\ACCOUNT.png"));
        btnUser.setContentAreaFilled(false);
        btnUser.setBorderPainted(false);
        btnUser.setBounds(1310, 3, 120, 70);
        btnUser.addActionListener(this);
        pnl1.add(btnUser);


        pnl4 = new JPanel();
        pnl4.setLayout(null);
        pnl4.setBackground(Color.decode("#000000"));
        pnl4.setBounds(0, 80, 1300, 220);
        frm.add(pnl4);

        ImageIcon icon = new ImageIcon("Files\\BestSelling.gif");
        JLabel lblBestSell = new JLabel(icon);
        lblBestSell.setBounds(0, 0,100, 220);
        pnl4.add(lblBestSell);

        ImageIcon icon2 = new ImageIcon("Files\\recommended.gif");
        JLabel lblRecommended = new JLabel(icon2);
        lblRecommended.setBounds(1240, 0,60, 220);
        pnl4.add(lblRecommended);

        ImageIcon icon3 = new ImageIcon("Files\\bestselling.png");
        JLabel lblBestselling = new JLabel(icon3);
        lblBestselling.setBounds(120, 0,1020, 220);
        pnl4.add(lblBestselling);

        pnl5 = new JPanel();
        pnl5.setLayout(null);
        pnl5.setBackground(Color.decode("#2C3E50"));
        pnl5.setBounds(0, 300, 1300, 45);
        frm.add(pnl5);

        btnConsoles = new JButton("GAMING CONSOLES");
        UIDesign.tabBtnDesign(btnConsoles);
        btnConsoles.setBounds(200, 10, 250, 35);
        pnl5.add(btnConsoles);
        btnConsoles.addActionListener(this);

        btnPCComponents = new JButton("PC COMPONENTS");
        UIDesign.tabBtnDesign(btnPCComponents);
        btnPCComponents.setBounds(450, 10, 250, 35);
        pnl5.add(btnPCComponents);
        btnPCComponents.addActionListener(this);

        btnAccessories = new JButton("GAMING ACCESSORIES");
        UIDesign.tabBtnDesign(btnAccessories);
        btnAccessories.setBounds(700, 10, 260, 35);
        pnl5.add(btnAccessories);
        btnAccessories.addActionListener(this);

        btnGames = new JButton("GAMES");
        UIDesign.tabBtnDesign(btnGames);
        btnGames.setBounds(960, 10, 200, 35);
        pnl5.add(btnGames);
        btnGames.addActionListener(this);

        pnlConsoles = new JPanel();
        pnlConsoles.setLayout(new GridLayout(2, 4, 0, 0));
        pnlConsoles.setBackground(Color.decode("#1d2a35"));
        pnlConsoles.setBounds(100, 345, 1300, 700);
        pnlConsoles.setVisible(true);
        btnConsole1 = UIDesign.productBtns(pnlConsoles, "Files\\Products\\1.png", "CONSL001");
        btnConsole2 = UIDesign.productBtns(pnlConsoles, "Files\\Products\\2.png", "CONSL002");
        btnConsole3 = UIDesign.productBtns(pnlConsoles, "Files\\Products\\3.png", "CONSL003");
        btnConsole4 = UIDesign.productBtns(pnlConsoles, "Files\\Products\\4.png", "CONSL004");
        btnConsole5 = UIDesign.productBtns(pnlConsoles, "Files\\Products\\5.png", "CONSL005");
        btnConsole6 = UIDesign.productBtns(pnlConsoles, "Files\\Products\\6.png", "CONSL006");
        btnConsole7 = UIDesign.productBtns(pnlConsoles, "Files\\Products\\7.png", "CONSL007");
        btnConsole8 = UIDesign.productBtns(pnlConsoles, "Files\\Products\\8.png", "CONSL008");
        btnConsole1.addActionListener(this);
        btnConsole2.addActionListener(this);
        btnConsole3.addActionListener(this);
        btnConsole4.addActionListener(this);
        btnConsole5.addActionListener(this);
        btnConsole6.addActionListener(this);
        btnConsole7.addActionListener(this);
        btnConsole8.addActionListener(this);
        frm.add(pnlConsoles);


        pnlLeftBtns = new JPanel();
        UIDesign.leftBtnPnl(frm, pnlLeftBtns, 100, 350, 250, 500, false);
        btnCPU = UIDesign.leftBtnDesigns(pnlLeftBtns, "CPU",0, 0, 225, 35 );
        btnGPU = UIDesign.leftBtnDesigns(pnlLeftBtns, "GPU",0, 50, 225, 35 );
        btnMemory = UIDesign.leftBtnDesigns(pnlLeftBtns, "Memory",0, 100, 225, 35 );
        btnStorage = UIDesign.leftBtnDesigns(pnlLeftBtns, "Storage", 0, 150, 225, 35 );
        btnMotherboard = UIDesign.leftBtnDesigns(pnlLeftBtns, "MOTHERBOARD",0, 200, 225, 35 );
        btnCooler = UIDesign.leftBtnDesigns(pnlLeftBtns, "COOLER",0, 250, 225, 35);
        btnPowerSupply = UIDesign.leftBtnDesigns(pnlLeftBtns, "POWER_SUPPLY",0, 300, 225, 35);
        btnCase = UIDesign.leftBtnDesigns(pnlLeftBtns, "CASE",0, 350, 225, 35);
        btnCPU.addActionListener(this);
        btnGPU.addActionListener(this);
        btnMemory.addActionListener(this);
        btnStorage.addActionListener(this);
        btnMotherboard.addActionListener(this);
        btnCooler.addActionListener(this);
        btnPowerSupply.addActionListener(this);
        btnCase.addActionListener(this);


        pnlCPU = UIDesign.pcComponentsPnl(frm,false);
        pnlGPU = UIDesign.pcComponentsPnl(frm,false);
        pnlMemory = UIDesign.pcComponentsPnl(frm,false);
        pnlMemory = UIDesign.pcComponentsPnl(frm,false);
        pnlStorage = UIDesign.pcComponentsPnl(frm,false);
        pnlMotherboard = UIDesign.pcComponentsPnl(frm,false);
        pnlCooler = UIDesign.pcComponentsPnl(frm,false);
        pnlPowerSupply = UIDesign.pcComponentsPnl(frm,false);
        pnlCase = UIDesign.pcComponentsPnl(frm,false);

        btnCPU1 = UIDesign.productBtns(pnlCPU, "Files\\PCComponents\\1.png", "CPU001");
        btnCPU2 = UIDesign.productBtns(pnlCPU, "Files\\PCComponents\\2.png", "CPU002");
        btnCPU3 = UIDesign.productBtns(pnlCPU, "Files\\PCComponents\\3.png", "CPU003");
        btnCPU4 = UIDesign.productBtns(pnlCPU, "Files\\PCComponents\\4.png", "CPU004");
        btnGPU1 = UIDesign.productBtns(pnlGPU, "Files\\PCComponents\\5.png", "GPU001");
        btnGPU2 = UIDesign.productBtns(pnlGPU, "Files\\PCComponents\\6.png", "GPU002");
        btnGPU3 = UIDesign.productBtns(pnlGPU, "Files\\PCComponents\\7.png", "GPU003");
        btnGPU4 = UIDesign.productBtns(pnlGPU, "Files\\PCComponents\\8.png", "GPU004");
        btnMemory1 = UIDesign.productBtns(pnlMemory, "Files\\PCComponents\\9.png", "MEM001");
        btnMemory2 = UIDesign.productBtns(pnlMemory, "Files\\PCComponents\\10.png", "MEM002");
        btnMemory3 = UIDesign.productBtns(pnlMemory, "Files\\PCComponents\\11.png", "MEM003");
        btnMemory4 = UIDesign.productBtns(pnlMemory, "Files\\PCComponents\\12.png", "MEM004");
        btnStorage1 = UIDesign.productBtns(pnlStorage, "Files\\PCComponents\\13.png", "SSD001");
        btnStorage2 = UIDesign.productBtns(pnlStorage, "Files\\PCComponents\\14.png", "SSD002");
        btnStorage3 = UIDesign.productBtns(pnlStorage, "Files\\PCComponents\\15.png", "SSD003");
        btnStorage4 = UIDesign.productBtns(pnlStorage, "Files\\PCComponents\\16.png", "SSD004");
        btnMotherboard1 = UIDesign.productBtns(pnlMotherboard, "Files\\PCComponents\\17.png", "MBD001");
        btnMotherboard2 = UIDesign.productBtns(pnlMotherboard, "Files\\PCComponents\\18.png", "MBD002");
        btnMotherboard3 = UIDesign.productBtns(pnlMotherboard, "Files\\PCComponents\\19.png", "MBB003");
        btnMotherboard4 = UIDesign.productBtns(pnlMotherboard, "Files\\PCComponents\\20.png", "MBD004");
        btnCooler1 = UIDesign.productBtns(pnlCooler, "Files\\PCComponents\\21.png", "COL001");
        btnCooler2 = UIDesign.productBtns(pnlCooler, "Files\\PCComponents\\22.png", "COL002");
        btnCooler3 = UIDesign.productBtns(pnlCooler, "Files\\PCComponents\\23.png", "COL003");
        btnCooler4 = UIDesign.productBtns(pnlCooler, "Files\\PCComponents\\24.png", "COL004");
        btnPowerSupply1 = UIDesign.productBtns(pnlPowerSupply, "Files\\PCComponents\\26.png", "PSU001");
        btnPowerSupply2 = UIDesign.productBtns(pnlPowerSupply, "Files\\PCComponents\\27.png", "PSU002");
        btnPowerSupply3 = UIDesign.productBtns(pnlPowerSupply, "Files\\PCComponents\\28.png", "PSU003");
        btnPowerSupply4 = UIDesign.productBtns(pnlPowerSupply, "Files\\PCComponents\\1.png", "PSU004");
        btnCase1 = UIDesign.productBtns(pnlCase, "Files\\PCComponents\\29.png", "CASE001");
        btnCase2 = UIDesign.productBtns(pnlCase, "Files\\PCComponents\\30.png", "CASE002");
        btnCase3 = UIDesign.productBtns(pnlCase, "Files\\PCComponents\\31.png", "CASE003");
        btnCase4 = UIDesign.productBtns(pnlCase, "Files\\PCComponents\\32.png", "CASE004");
        btnCPU1.addActionListener(this);
        btnCPU2.addActionListener(this);
        btnCPU3.addActionListener(this);
        btnCPU4.addActionListener(this);
        btnGPU1.addActionListener(this);
        btnGPU2.addActionListener(this);
        btnGPU3.addActionListener(this);
        btnGPU4.addActionListener(this);
        btnStorage1.addActionListener(this);
        btnStorage2.addActionListener(this);
        btnStorage3.addActionListener(this);
        btnStorage4.addActionListener(this);
        btnMotherboard1.addActionListener(this);
        btnMotherboard2.addActionListener(this);
        btnMotherboard3.addActionListener(this);
        btnMotherboard4.addActionListener(this);
        btnCooler1.addActionListener(this);
        btnCooler2.addActionListener(this);
        btnCooler3.addActionListener(this);
        btnCooler4.addActionListener(this);
        btnPowerSupply1.addActionListener(this);
        btnPowerSupply2.addActionListener(this);
        btnPowerSupply3.addActionListener(this);
        btnPowerSupply4.addActionListener(this);
        btnCase1.addActionListener(this);
        btnCase2.addActionListener(this);
        btnCase3.addActionListener(this);
        btnCase4.addActionListener(this);

        pnlAccessories = new JPanel();
        pnlAccessories.setLayout(new GridLayout(2, 4, 0, 0));
        pnlAccessories.setBackground(Color.decode("#1d2a35"));
        pnlAccessories.setBounds(100, 345, 1300, 500);
        pnlAccessories.setVisible(false);
        btnAccessories1 = UIDesign.productBtns(pnlAccessories, "Files\\Products\\16.png",  "GACC001");
        btnAccessories2 = UIDesign.productBtns(pnlAccessories, "Files\\Products\\15.png", "GACC002");
        btnAccessories3 = UIDesign.productBtns(pnlAccessories, "Files\\Products\\11.png", "GACC003");
        btnAccessories4 = UIDesign.productBtns(pnlAccessories, "Files\\Products\\10.png", "GACC004");
        btnAccessories5 = UIDesign.productBtns(pnlAccessories, "Files\\Products\\14.png", "GACC005");
        btnAccessories6 = UIDesign.productBtns(pnlAccessories, "Files\\Products\\12.png", "GACC006");
        btnAccessories7 = UIDesign.productBtns(pnlAccessories, "Files\\Products\\13.png", "GACC007");
        btnAccessories8 = UIDesign.productBtns(pnlAccessories, "Files\\Products\\9.png", "GACC008");
        btnAccessories1.addActionListener(this);
        btnAccessories2.addActionListener(this);
        btnAccessories3.addActionListener(this);
        btnAccessories4.addActionListener(this);
        btnAccessories5.addActionListener(this);
        btnAccessories6.addActionListener(this);
        btnAccessories7.addActionListener(this);
        btnAccessories8.addActionListener(this);
        frm.add(pnlAccessories);

        pnlGames = new JPanel();
        pnlGames.setLayout(new GridLayout(2, 4, 0, 0));
        pnlGames.setBackground(Color.decode("#1d2a35"));
        pnlGames.setBounds(100, 345, 1300, 500);
        pnlGames.setVisible(false);
        btnGames1 = UIDesign.productBtns(pnlGames, "Files\\Products\\17.png", "GAME001");
        btnGames2 = UIDesign.productBtns(pnlGames, "Files\\Products\\18.png", "GAME002");
        btnGames3 = UIDesign.productBtns(pnlGames, "Files\\Products\\19.png", "GAME003");
        btnGames4 = UIDesign.productBtns(pnlGames, "Files\\Products\\20.png", "GAME004");
        btnGames5 = UIDesign.productBtns(pnlGames, "Files\\Products\\22.png", "GAME005");
        btnGames6 = UIDesign.productBtns(pnlGames, "Files\\Products\\24.png", "GAME006");
        btnGames7 = UIDesign.productBtns(pnlGames, "Files\\Products\\21.png", "GAME007");
        btnGames8 = UIDesign.productBtns(pnlGames, "Files\\Products\\23.png", "GAME008");
        btnGames1.addActionListener(this);
        btnGames2.addActionListener(this);
        btnGames3.addActionListener(this);
        btnGames4.addActionListener(this);
        btnGames5.addActionListener(this);
        btnGames6.addActionListener(this);
        btnGames7.addActionListener(this);
        btnGames8.addActionListener(this);
        frm.add(pnlGames);

        frm.setVisible(true);
    }

    public static void main(String[] args) {
        HomePage homePage = new HomePage();
        homePage.HomePageUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton[] allLeftBtns = {
                 btnCPU, btnGPU, btnMemory, btnStorage,
                btnMotherboard, btnCooler, btnCase, btnPowerSupply,
                btnConsoles, btnAccessories, btnGames
        };

        JButton[] allTabBtns = {btnConsoles, btnPCComponents, btnAccessories, btnGames};
        if (e.getSource() == btnConsoles) {
            pnlConsoles.setVisible(true);
            pnlGames.setVisible(false);
            pnlAccessories.setVisible(false);
            pnlLeftBtns.setVisible(false);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlCase.setVisible(false);
            UIDesign.pressedTabBtn(btnConsoles, allTabBtns);
        } else if (e.getSource() == btnPCComponents) {
            pnlConsoles.setVisible(false);
            pnlGames.setVisible(false);
            pnlAccessories.setVisible(false);
            pnlLeftBtns.setVisible(true);
            pnlCPU.setVisible(true);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlCase.setVisible(false);
            UIDesign.pressedTabBtn(btnPCComponents, allTabBtns);
            UIDesign.pressedLeftBtn(btnCPU, allLeftBtns);
        } else if (e.getSource() == btnGames) {
            pnlConsoles.setVisible(false);
            pnlLeftBtns.setVisible(false);
            pnlAccessories.setVisible(false);
            pnlGames.setVisible(true);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlCase.setVisible(false);
            pnlPowerSupply.setVisible(false);
            UIDesign.pressedTabBtn(btnGames, allTabBtns);
        } else if (e.getSource() == btnAccessories) {
            pnlConsoles.setVisible(false);
            pnlLeftBtns.setVisible(false);
            pnlGames.setVisible(false);
            pnlAccessories.setVisible(true);
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlCase.setVisible(false);
            pnlPowerSupply.setVisible(false);
            UIDesign.pressedTabBtn(btnAccessories, allTabBtns);
        } else if (e.getSource() == btnCPU) {
            pnlCPU.setVisible(true);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlCase.setVisible(false);
            pnlPowerSupply.setVisible(false);
            UIDesign.pressedTabBtn(btnPCComponents, allTabBtns);
            UIDesign.pressedLeftBtn(btnCPU, allLeftBtns);
        } else if (e.getSource() == btnGPU) {
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(true);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlCase.setVisible(false);
            pnlPowerSupply.setVisible(false);
            UIDesign.pressedTabBtn(btnPCComponents, allTabBtns);
            UIDesign.pressedLeftBtn(btnGPU, allLeftBtns);
        } else if (e.getSource() == btnMemory) {
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(true);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlCase.setVisible(false);
            pnlPowerSupply.setVisible(false);
            UIDesign.pressedTabBtn(btnPCComponents, allTabBtns);
            UIDesign.pressedLeftBtn(btnMemory, allLeftBtns);
        } else if (e.getSource() == btnStorage) {
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(true);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlCase.setVisible(false);
            pnlPowerSupply.setVisible(false);
            UIDesign.pressedTabBtn(btnPCComponents, allTabBtns);
            UIDesign.pressedLeftBtn(btnStorage, allLeftBtns);
        } else if (e.getSource() == btnMotherboard) {
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(true);
            pnlCooler.setVisible(false);
            pnlCase.setVisible(false);
            pnlPowerSupply.setVisible(false);
            UIDesign.pressedTabBtn(btnPCComponents, allTabBtns);
            UIDesign.pressedLeftBtn(btnMotherboard, allLeftBtns);
        } else if (e.getSource() == btnCooler) {
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(true);
            pnlCase.setVisible(false);
            pnlPowerSupply.setVisible(false);
            UIDesign.pressedTabBtn(btnPCComponents, allTabBtns);
            UIDesign.pressedLeftBtn(btnCooler, allLeftBtns);
        } else if (e.getSource() == btnCase) {
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlCase.setVisible(true);
            pnlPowerSupply.setVisible(false);
            UIDesign.pressedTabBtn(btnPCComponents, allTabBtns);
            UIDesign.pressedLeftBtn(btnCase, allLeftBtns);
        } else if (e.getSource() == btnPowerSupply) {
            pnlCPU.setVisible(false);
            pnlGPU.setVisible(false);
            pnlMemory.setVisible(false);
            pnlStorage.setVisible(false);
            pnlMotherboard.setVisible(false);
            pnlCooler.setVisible(false);
            pnlCase.setVisible(false);
            pnlPowerSupply.setVisible(true);
            UIDesign.pressedTabBtn(btnPCComponents, allTabBtns);
            UIDesign.pressedLeftBtn(btnPowerSupply, allLeftBtns);
        }else if(e.getSource() == btnBackCart) {
            frmCart.setVisible(false);
            lblCartBar.setVisible(false);
            lblUserBar.setVisible(true);
        }else  if (e.getSource() == btnConsole1) {
            ProductsPreview.console1();
        } else if (e.getSource() == btnConsole2) {
            ProductsPreview.console2();
        } else if(e.getSource() == btnConsole3 ) {
            ProductsPreview.console3();
        } else if(e.getSource() == btnConsole4 ) {
            ProductsPreview.console4();
        } else if(e.getSource() == btnConsole5 ) {
            ProductsPreview.console5();
        } else if(e.getSource() == btnConsole6 ) {
            ProductsPreview.console6();
        } else if(e.getSource() == btnConsole7 ) {
            ProductsPreview.console7();
        } else if(e.getSource() == btnConsole8 ) {
            ProductsPreview.console8();
        }else  if (e.getSource() == btnAccessories1) {
            ProductsPreview.accessories1();
        } else if (e.getSource() == btnAccessories2) {
            ProductsPreview.accessories2();
        } else if(e.getSource() == btnAccessories3 ) {
            ProductsPreview.accessories3();
        } else if(e.getSource() == btnAccessories4 ) {
            ProductsPreview.accessories4();
        } else if(e.getSource() == btnAccessories5 ) {
            ProductsPreview.accessories5();
        } else if(e.getSource() == btnAccessories6) {
            ProductsPreview.accessories6();
        } else if(e.getSource() == btnAccessories7 ) {
            ProductsPreview.accessories7();
        } else if(e.getSource() == btnAccessories8 ) {
            ProductsPreview.accessories8();
        } else if(e.getSource() == btnGames1 ) {
            ProductsPreview.game1();
        } else if(e.getSource() == btnGames2 ) {
            ProductsPreview.game2();
        } else if(e.getSource() == btnGames3 ) {
            ProductsPreview.game3();
        } else if(e.getSource() == btnGames4 ) {
            ProductsPreview.game4();
        } else if(e.getSource() == btnGames5  ) {
            ProductsPreview.game5();
        } else if(e.getSource() == btnGames6 ) {
            ProductsPreview.game6();
        } else if(e.getSource() == btnGames7 ) {
            ProductsPreview.game7();
        } else if(e.getSource() == btnGames8 ) {
            ProductsPreview.game8();
        }
        /*else if(e.getSource() == btnCPU1) {
            productDetails = "AMD RYZEN THREADRPPER PRO...$9999.99";
            //addToCart(productDetails);
        } else if(e.getSource() == btnCPU2) {
            productDetails = "AMD RYZEN 9 9950X...$629.99";
            //addToCart(productDetails);
        } else if(e.getSource() == btnCPU3) {
            productDetails = "INTEL i9 14900KS...$650.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnCPU4) {
            productDetails = "INTEL i9 14900K...$389.99";
            //addToCart(productDetails);
        } else if(e.getSource() == btnGPU1) {
            productDetails = "ASUS ROG RTX 4090...$1999.99";
            //addToCart(productDetails);
        } else if(e.getSource() == btnGPU2) {
            productDetails = "ASUS ROG STRIX RTX 4080...$1299.99";
            //addToCart(productDetails);
        } else if(e.getSource() == btnGPU3) {
            productDetails = "ASUS ROG STRIX RTX 4080 (WHITE)...$1299.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnGPU4) {
            productDetails = "NVIDIA RTX A6000..$4999.99";
           // addToCart(productDetails);
        } else if(e.getSource() == btnMemory1) {
            productDetails = "CORSAIR 64GB DDR5...$229.99";
           // addToCart(productDetails);
        } else if(e.getSource() == btnMemory2) {
            productDetails = "CORSAIR 96GB DDR5...$379.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnMemory3) {
            productDetails = "CORSAIR 128GB DDR5...$479.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnMemory4) {
            productDetails = "CORSAIR 64GB DDR5 (WHITE)...$279.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnStorage1) {
            productDetails = "SABRENT 8 TB SSD...$1199.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnStorage2) {
            productDetails = "SAMSUNG 980 EVO PRO SSD 1 TB...$99.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnStorage3) {
            productDetails = "CORSAIR MP600 8 TB ...$849.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnStorage4) {
            productDetails = "MSI SPATIUM 4TB...$289.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnMotherboard1) {
            productDetails = "ASUS ROG MAXIMUSS XII...$549.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnMotherboard2) {
            productDetails = "ASUS ROG STRIX B650...$299.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnMotherboard3) {
            productDetails = "GIGABYTE B650E AORUS...$249.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnMotherboard4) {
            productDetails = "MSI MPG z790 Carbon...$469.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnCase1) {
            productDetails = "CORSAIR ICUE 500T...$399.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnCase2) {
            productDetails = "COOLER MASTER TD500...$389.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnCase3) {
            productDetails = "ASUS ROG STRIX HELLOS...$289.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnCase4) {
            productDetails = "CORSAIR ICUE 500T (WHITE)...$399.99";
            ///addToCart(productDetails);
        }else if(e.getSource() == btnCooler1) {
            productDetails = "CORSAIR ICUE LCD LIQUID COOLER...$229.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnCooler2) {
            productDetails = "CORSAIR ICUE LCD LIQUID COOLER (WHITE)...$229.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnCooler3) {
            productDetails = "CORSAIR H100X RGB ELITE...$199.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnCooler4) {
            productDetails = "MSI MAG CORELIQUID...$159.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnPowerSupply1) {
            productDetails = "CORSAIR 1500W PLATINUM...$369.99";
            //addToCart(productDetails);
        }else if(e.getSource() == btnPowerSupply2) {
            productDetails = "ROG THOR 1200W PLATINUM...$329.99";
           // addToCart(productDetails);
        }else if(e.getSource() == btnPowerSupply3) {
            productDetails = "ROG STRIX 1000W GOLD...$189.99";
           // addToCart(productDetails);
        }else if(e.getSource() == btnPowerSupply4) {
            productDetails = "ROG STRIX 1000W GOLD AURA WHITE...$229.99";
           // addToCart(productDetails);
        } else if(e.getSource() == btnPCBuilder) {
            new BuildPc();
        } else if (e.getSource() == btnProceedToCheckout) {
            new PurchaseConfirmed(); */
        else if (e.getSource() == btnBack) {
            frm.dispose();
            new LoginPage2();
        } else if (e.getSource() == btnCart) {
            Cart cart = new Cart();
            cart.CartUI();
        } else if (e.getSource() == btnPCBuilder) {
            new BuildPc();
        }
    }




}


