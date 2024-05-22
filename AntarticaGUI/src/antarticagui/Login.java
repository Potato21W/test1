/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package antarticagui;

import java.awt.Dimension;
import java.lang.Math;
import java.awt.Font;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
    	
    	
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create an instance of ImagePanel
        ImagePanel backgroundPanel = new ImagePanel(loginImage);
        
        backgroundPanel.setLayout(null); // You may need to set layout as null for absolute positioning
        
        jTextField1 = new JTextField();
        jTextField1.setBounds(470, 352, 750, 97); // Example: Set position and size
        backgroundPanel.add(jTextField1);
        
        jPasswordField1 = new JPasswordField();
        jPasswordField1.setBounds(470, 600, 750, 100);
        backgroundPanel.add(jPasswordField1);
        
        jButton1 = new JButton("Login");
        Dimension buttonSize = new Dimension(200, 100); // Example size
        int buttonX = ((backgroundPanel.getWidth() - buttonSize.width) / 2)- 7;
        int buttonY = 700;
        jButton1.setBounds(buttonX, buttonY, buttonSize.width, buttonSize.height);
        backgroundPanel.add(jButton1);
        
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
                    // Close the current window
                    frame.dispose();
                    // Open another window
						try {
							System.out.println("works");
							openNextWindow(username, password);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
                }
                 
                 else {
                	 System.out.println("Your username or password doesn't match. Please check and try again");
                 }
            }
        });
        // Add the backgroundPanel to the frame
        frame.add(backgroundPanel);
        
        Dimension imageSize = backgroundPanel.getImageSize();
        frame.setSize(imageSize);
        
        frame.setResizable(false); // Prevent resizing
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        
        frame.pack();
        frame.setVisible(true);
    }
    
     private void openNextWindow(String username, String password) throws IOException {

        // Create and configure the next window
        JFrame nextFrame = new JFrame("Welcome " + username);
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
        
        Main.sort(Main.books);
        
        System.out.println("Here are some books you might like:");

        for (int i = 0; i < Main.books.size(); i++) {
        	System.out.println(Main.books.get(i).toString());
        	//System.out.println(Main.books.get(i));
        	 
        }
        
       
        // Add ActionListener to the button
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	
            	
                // Retrieve data
                String input = jTextField1.getText();
                
//                if (Main.bookData.contains(input)) {
//                	 printTextField(Main.bookData.get(Main.books.indexOf(input)).getData(3), jTextArea1);
//                }
                try {
					Main.signUp(input.split(",")[0], User.getHash(input.split(",")[1])+"");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                for (Map.Entry<String, Integer> entry : Main.userLookup.entrySet()) {
            	    System.out.println(entry.getKey() + "/" + entry.getValue());
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

    private String loginImage = "/resources/LoginPage.png";
    private String generalImage = "/resources/GeneralPage.png";
    private javax.swing.JButton jButton1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
