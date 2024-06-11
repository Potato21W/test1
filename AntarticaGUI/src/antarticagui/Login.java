/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package antarticagui;

import java.awt.Container;
import java.awt.Dimension;
import java.lang.Math;
import java.awt.Font;
import java.awt.Frame;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

/**
 *
 * 
 */
public class Login extends javax.swing.JFrame {
	
	

    /**
     * Creates new form GUI
     */
    public Login() throws IOException{
    	Main.main(null);

        Dimension buttonSize = new Dimension(200, 100); // Example size        
        setLoginBackground(buttonSize);
        loginButton(buttonSize);
        registerButton(buttonSize);
        
        // Add the backgroundPanel to the frame
        frame.add(backgroundPanel);
        
        Dimension imageSize = backgroundPanel.getImageSize();
        frame.setSize(imageSize);
        
        frame.setResizable(false); // Prevent resizing
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        
        frame.pack();
        frame.setVisible(true);
    }

    private void setLoginBackground(Dimension size){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create an instance of ImagePanel
        backgroundPanel = new ImagePanel(loginImage);

        backgroundPanel.setLayout(null); // You may need to set layout as null for absolute positioning
        
        jTextField1 = new JTextField();
        jTextField1.setBounds(468, 350, 750, 100); // Example: Set position and size
        jTextField1.setBackground(Color.LIGHT_GRAY);
        backgroundPanel.add(jTextField1);

        jPasswordField1 = new JPasswordField();
        jPasswordField1.setBounds(468, 600, 750, 100);
        jPasswordField1.setBackground(Color.LIGHT_GRAY);
        backgroundPanel.add(jPasswordField1);
        JLabel buttonLabel = new JLabel(new ImageIcon(button));
        buttonLabel.setBounds((backgroundPanel.getWidth() - size.width) / 2- 150, 700, size.width, size.height);
        buttonLabel.setVisible(true);
        backgroundPanel.add(buttonLabel);


    }
    private void loginButton(Dimension size){
        //Actual login button
        jButton1 = new JButton("Login");
        int buttonX = ((backgroundPanel.getWidth() - size.width) / 2)- 150;
        int buttonY = 700;
        jButton1.setBounds(buttonX, buttonY, size.width, size.height);
        jButton1.setBackground(new Color(44, 125, 200));
        jButton1.setForeground(Color.WHITE);  
        backgroundPanel.add(jButton1);
        //backgroundPanel.add(buttonLabel);

        // Add ActionListener to the login button
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Retrieve username and password
                String username = jTextField1.getText();
                String password = new String(jPasswordField1.getPassword());
                
                // Do something with username and password
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                if (Main.login(username, password)){
                    System.out.println("working");
                    System.out.println("Opening window");
                    User user = Main.users.get(Main.userLookup.get(username));
                    // Close the current window
                    frame.dispose();
                    // Open another window
                    try {
                        
                        openHome(user);
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                
                else {
                    JFrame wrongIntputFrame = new JFrame();
                    JLabel wrongInputLabel = new JLabel("Your username or password is incorrect. Please check and try again");
                    wrongIntputFrame.setSize(300,200);
                    wrongIntputFrame.add(wrongInputLabel);
                    wrongIntputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    wrongIntputFrame.setVisible(true);
                    System.out.println("Your username or password doesn't match. Please check and try again");


                }
            }
        });
    }
    //Kaya
    /**
     * 
     * @param size
     * By Kaya
     */
    private void registerButton(Dimension size){
        
        jButton2 = new JButton("Register"); // Creates register button
        int registerX = ((backgroundPanel.getWidth() - size.width) / 2) + 150; // Sets the button's x coordinate to 200px more than the login button
        int registerY = 700; // Sets the buttons y coordinate
        jButton2.setBounds(registerX, registerY, size.width, size.height); // Sets the size and location
        jButton2.setBackground(new Color(44, 125, 200));
        jButton2.setForeground(Color.WHITE);
        backgroundPanel.add(jButton2); // Adds it to the background
        
        
        // Add ActionListener to register button
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // Retrieve username and password
                String username = jTextField1.getText();
                String password = new String(jPasswordField1.getPassword());
                
                // Do something with username and password
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);

                // Error message if the username is already registered
                if(Main.registered(username)){
                    JFrame errorFrame = new JFrame();
                    JLabel messagLabel = new JLabel("That username already exists");
                    errorFrame.setSize(300,200);
                    errorFrame.add(messagLabel);
                    errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    errorFrame.setVisible(true);
                }
                else{
                    try {
                        Main.signUp(username, password);
                        User user = Main.users.get(Main.userLookup.get(username));
                        frame.dispose();
                        openDashboard(user);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    
                }

            }
        });
    }
    
    
    private void openDashboard(User u) throws IOException {

        // Create and configure the next window
        JFrame nextFrame = new JFrame("Welcome " + u.getUsername());
        nextFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create an instance of ImagePanel with the second image
        ImagePanel backgroundPanel = new ImagePanel(generalImage);
        
        jTextArea1 = new JTextArea();
        jTextArea1.setBounds(470, 100, 750, 400);
        backgroundPanel.add(jTextArea1);
        
        jTextField1 = new JTextField();
        jTextField1.setBounds(470, 550, 750, 100);
        backgroundPanel.add(jTextField1);
        
        jButton1 = new JButton("Enter");
        Dimension buttonSize = new Dimension(200, 100); // Example size
        int buttonX = ((backgroundPanel.getWidth() - buttonSize.width) / 2)- 7;
        int buttonY = 700;
        jButton1.setBounds(buttonX, buttonY, buttonSize.width, buttonSize.height);
        backgroundPanel.add(jButton1);
        
        PrintStream outStream = new PrintStream( new TextAreaOutputStream(jTextArea1));
        jTextArea1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
        
        System.setOut(outStream);
        
        Main.getRecBook();
        
       
        // Add ActionListener to the button
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                // Retrieve data
                String input = jTextField1.getText();
                //split by comma
                String temp[] = input.split(",");
                //lookup book
                if (Main.bookLookup.containsKey(temp[0])) {
                	Main.rateBook(temp, u.getUsername());
                	try {
						Main.rewriteUsers();
						jTextArea1.setText(null);
						Main.userLookup.clear();
						Main.users.clear();
						Main.books.clear();
						Main.getBook();
						Main.checkMap();
				    	Main.getRecBook();
				        
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } else {
                	System.out.println("404 book doesn't exist");
                }
               
                //add rating for book
            }
        });
        
        // Add the backgroundPanel to the nextFrame
        nextFrame.add(backgroundPanel);
        
        // Set the frame resizable to false
        nextFrame.setResizable(false);
        
        // Set the size of the nextFrame to match the size of the image
        Dimension imageSize = backgroundPanel.getImageSize();
        nextFrame.setSize(imageSize);
        
        // Center the nextFrame on the screen
        nextFrame.setLocationRelativeTo(null);
        
        // Display the nextFrame
        nextFrame.setVisible(true);
    }
     
     
     private void openHome(User u) throws IOException {
    	 
    	
         // Create and configure the next window
         JFrame nextFrame = new JFrame("Welcome " + u.getUsername());
         nextFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         // Create an instance of ImagePanel with the second image
         ImagePanel backgroundPanel = new ImagePanel(homeImage);
         
         jTextArea1 = new JTextArea();
         jTextArea1.setEditable(false);
         jTextArea1.setBounds(225, 332, 1392, 359);
         backgroundPanel.add(jTextArea1);
         
         jButton1 = new JButton("Profile");
         jButton1.setBounds(5,5,122,122);
         backgroundPanel.add(jButton1);
         
         jButton2 = new JButton("Reccomended");
         jButton2.setBounds(5,132,122,122);
         backgroundPanel.add(jButton2);
         
                
         jTextField1 = new JTextField("Search");
         jTextField1.setBounds(655,200,600,80);
         backgroundPanel.add(jTextField1);
         
         jButton3 = new JButton("Search");
         jButton3.setBounds(570,200,80,80);
         backgroundPanel.add(jButton3);
         
         jButton4 = new JButton("Enter");
         jButton4.setBounds(555,800,100,80);
         backgroundPanel.add(jButton4);
         
         jTextField2 = new JTextField("");
         jTextField2.setBounds(656,800,700,80);
         backgroundPanel.add(jTextField2);
         
         jButton5 = new JButton("Help");
         jButton5.setBounds(5,776,122,122);
         backgroundPanel.add(jButton5);
         
         PrintStream outStream = new PrintStream( new TextAreaOutputStream(jTextArea1));
         jTextArea1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));

    	 System.setOut(outStream);
    	 
         jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    openProfile(u);
                } catch (IOException eIO){
                    eIO.printStackTrace();
                }
                
                nextFrame.dispose();
            }
         });
         jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea1.setText(null);

                // Retrieve data
                String input = jTextField1.getText();
                jTextArea1.setText(null);
                //split by comma
                String[] temp = {input};
                jTextArea1.setText(null);
                ArrayList<String> desires = new ArrayList<String>(Arrays.asList(temp));
                for (int i = 0; i < 10; i ++) {
                    System.out.println(Main.search(Main.books, desires).get(i));
                }
            }
        });
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Retrieve data
                String input = jTextField2.getText();
                //split by comma
                String[] temp = input.split(" ");


                if (temp[0].equalsIgnoreCase("rate")) {
                    String[] temp2 = temp[1].split(",");
                    if (Main.bookLookup.containsKey(temp2[0])) {
                        Main.rateBook(temp2, u.getUsername());
                        try {
                            Main.rewriteUsers();
                            jTextArea1.setText(null);
                            Main.userLookup.clear();
                            Main.users.clear();
                            Main.books.clear();
                            Main.getBook();
                            Main.checkMap();
                            Main.getRecBook();

                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    } 
                    jTextArea1.setText(null);
                }

                else if(temp[0].equalsIgnoreCase("read")) {
                    jTextArea1.setText(null);
                }


            }
        });
         
         jButton5.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
            	 try {
					openHelp();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
             }
         });
         // Add the backgroundPanel to the nextFrame
         nextFrame.add(backgroundPanel);
         
         // Set the frame resizable to false
         nextFrame.setResizable(false);
         
         // Set the size of the nextFrame to match the size of the image
         Dimension imageSize = backgroundPanel.getImageSize();
         nextFrame.setSize(imageSize);
         
         // Center the nextFrame on the screen
         nextFrame.setLocationRelativeTo(null);
         
         // Display the nextFrame
         nextFrame.setVisible(true);
     }
     
     private void openHelp() throws IOException {
    	 
    	 
    	 ImagePanel backgroundPanel = new ImagePanel(whiteImage);
    	 JFrame nextFrame = new JFrame("Help");
    	 

    	 jTextArea1 = new JTextArea();
    	 jTextArea1.setEditable(false);
         jTextArea1.setBounds(0, 0, 500, 500);
		 backgroundPanel.add(jTextArea1);
         
    	 String help1 = "Search Parameters should be seperated with commas and not spaces";
    	 String help2 = "To add a rating, type in the bottom box \"rate BookName,rating\" \nand press the button labled \"Enter\"";
    	 String help3 = "To add a read book, type in the bottom box \"read BookName\" \nand press the button labled \"Enter\"";
    	 
    	 jTextArea1.setText(help1 + "\n\n" + help2 + "\n\n" + help3);
    	 
		// Add the backgroundPanel to the nextFrame
         nextFrame.add(backgroundPanel);
         
         // Set the frame resizable to false
         ((Frame) nextFrame).setResizable(false);
         
         // Set the size of the nextFrame to match the size of the image
        
         Dimension imageSize = backgroundPanel.getImageSize();
         nextFrame.setSize(imageSize);
         
         // Center the nextFrame on the screen
         nextFrame.setLocationRelativeTo(null);
         
         // Display the nextFrame
         nextFrame.setVisible(true);
     
     }
     
     private void openProfile(User u) throws IOException{
        profile = new JFrame(u.getUsername());
        setProfileBackground(u);      
                               
        /*for (int i = 0; i < u.readList.size(); i++){
            readTable.setValueAt(u.readList.get(i), i, 0);
        }    */   
        printRead(u);  
        

        jButton1 = new JButton("Mark as read");
        jButton1.setBounds(jTextField1.getX()+jTextField1.getWidth()+20, jTextField1.getY(), 200, 100);
        jButton1.setBackground(new Color(44, 125, 200));
        jButton1.setForeground(Color.WHITE);  
        backgroundPanel.add(jButton1);

        jButton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String input = jTextField1.getText();
                if (Main.bookLookup.containsKey(input)) {
                    u.addHasRead(input);
                    System.out.println(input + " , " + u.rateList.get(Main.bookLookup.get(input)));
                    
                    try {
                        Main.rewriteUsers();
                    } catch (IOException eIO) {
                        eIO.printStackTrace();
                    }
                    
                }
            }
        });
        
        

        profile.add(backgroundPanel);


        // Set the frame resizable to false
       profile.setResizable(false);
       
       // Set the size of the dashboard to match the size of the image
       Dimension imageSize = backgroundPanel.getImageSize();
       profile.setSize(imageSize);
       
       // Center the dashboard on the screen
       profile.setLocationRelativeTo(null);
       
       // Display the dashboard
       profile.setVisible(true);
    }
    private void printRead(User u){
        PrintStream outStream = new PrintStream( new TextAreaOutputStream(jTextArea1));
        System.setOut(outStream);
        jTextArea1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        for (int i = 0; i < u.readList.size(); i++){
            String book = u.readList.get(i);
            System.out.println(book + "," + u.rateList.get(Main.bookLookup.get(book)));

        }  
    }
    private void setProfileBackground(User u){
        profile.setDefaultCloseOperation(EXIT_ON_CLOSE);
        backgroundPanel = new ImagePanel(profileImage);
        
        /*readTable = new JTable(u.readList.size(), 3);
        readTable.setBounds(100,100, 500,350);*/
        jTextArea1 = new JTextArea();
        jTextArea1.setBounds(backgroundPanel.getWidth()/4 -80, 250, 3*backgroundPanel.getWidth()/4 -150, 400);
        jTextArea1.setBackground(boxColor);
        backgroundPanel.add(jTextArea1);

        jTextField1 = new JTextField();
        jTextField1.setBounds(jTextArea1.getX(), 700, jTextArea1.getWidth(), 100);
        jTextArea1.setBackground(boxColor);
        backgroundPanel.add(jTextField1);


    }     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
    	 

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setText("jTextField1");

        jPasswordField1.setText("jPasswordField1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(1880, 1880, 1880)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(893, 893, 893)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(680, 680, 680)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new Login().setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }
    
    public void printTextField(String text, JTextArea textArea) {
        textArea.setText(text);
    }
    
    public static void getRandBook(int r) {
    	
    }

    private String homeImage = "/resources/HomePage.png";
    private String loginImage = "/resources/LoginPage.png";
    private String generalImage = "/resources/GeneralPage.png";
    private String dashboardImage = "/resources/Dashboard.png";
    private String profileImage = "/resources/ProfilePage.png";
    private String button = "/resources/Button.png";

    Color boxColor = new Color(217, 240, 241);
    Color iconColor = new Color(127, 201, 255);
    private String whiteImage = "/resources/White.jpg";
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private JFrame frame = new JFrame("Login");
    private JFrame dashboard;
    private JFrame profile;
    private ImagePanel backgroundPanel;
    private JTable readTable;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
