/*
 *
 * This class handles the GUI of the actual program
 */

package antarticagui;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.Color;

public class Login extends javax.swing.JFrame {

private String homeImage = "/resources/HomePage.png";
private String loginImage = "/resources/LoginPage.png";
private String profileImage = "/resources/ProfilePage.png";
Color boxColor = new Color(217, 240, 241);
Color iconColor = new Color(127, 201, 255);
private String whiteImage = "/resources/White.jpg";
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton2;
private javax.swing.JButton jButton3;
private javax.swing.JButton jButton4;
private javax.swing.JButton jButton5;
private javax.swing.JButton jButton6;
// Variables declaration - do not modify//GEN-BEGIN:variables
private javax.swing.JFrame jFrame1;
private javax.swing.JFrame jFrame2;
private javax.swing.JFrame jFrame3;
private JFrame frame;
private JFrame profile;
private ImagePanel backgroundPanel;
private javax.swing.JPasswordField jPasswordField1;
private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JTextArea jTextArea1;
private javax.swing.JTextField jTextField1;
private javax.swing.JTextField jTextField2;
// End of variables declaration//GEN-END:variables
	

    /**
     * Creates new form GUI
     */
    public Login() throws IOException{
    	Main.main(null);
        login();
        
    }
    public void login(){
    frame = new JFrame("Login");
    Dimension buttonSize = new Dimension(200, 100); // Example size        
    setLoginBackground();
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
    /**
     * Creates a new button and sets its colour
     * @param b The button
     * @param x x coordinate
     * @param y y coordinate
     * @param width The width
     * @param  The height
     * By Kaya
     */
    public void setButton(JButton b, int x, int y, int width, int height){
        b.setBounds(x, y, width, height);
        b.setBackground(new Color(44, 125, 200));
        b.setForeground(Color.WHITE);
    }
    /**
     * Set's up the background of the login page
     * By Matt K
     */
    private void setLoginBackground(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create an instance of ImagePanel
        backgroundPanel = new ImagePanel(loginImage);

        backgroundPanel.setLayout(null); // You may need to set layout as null for absolute positioning
        
        // Username field
        jTextField1 = new JTextField();
        jTextField1.setBounds(468, 350, 750, 100); // Example: Set position and size
        jTextField1.setBackground(Color.LIGHT_GRAY);
        backgroundPanel.add(jTextField1);

        //Password field
        jPasswordField1 = new JPasswordField();
        jPasswordField1.setBounds(468, 600, 750, 100);
        jPasswordField1.setBackground(Color.LIGHT_GRAY);
        backgroundPanel.add(jPasswordField1);

    }
    /**
     * Creates a button to log in the user
     * @param size The size of the button
     * By Matt K
     */
    private void loginButton(Dimension size){
        //Actual login button
        jButton1 = new JButton("Login");
        int buttonX = ((backgroundPanel.getWidth() - size.width) / 2)- 150;
        int buttonY = 700;
        setButton(jButton1, buttonX, buttonY, size.width, size.height);
        backgroundPanel.add(jButton1);


        // Add ActionListener to the login button
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // Retrieve username and password
                String username = jTextField1.getText();
                String password = new String(jPasswordField1.getPassword());
                
                // Checks if the credentials are correct
                if (Main.login(username, password)){
                    User user = Main.users.get(Main.userLookup.get(username)); // Stores the current user
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
                    errorMessage("Your username or password was inccorect, please try again");
                }
            }
        });
    }
    //Kaya
    /**
     * Creates a button to register a new user
     * @param size The size of the button
     * By Kaya
     */
    private void registerButton(Dimension size){
        
        jButton2 = new JButton("Register"); // Creates register button
        int registerX = ((backgroundPanel.getWidth() - size.width) / 2) + 150; // Sets the button's x coordinate to 200px more than the login button
        int registerY = 700; // Sets the buttons y coordinate
        setButton(jButton2, registerX, registerY, size.width, size.height);
        backgroundPanel.add(jButton2);
        
        
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
                    errorMessage("That username already exists");
                }
                else{
                    try {
                        Main.signUp(username, password);
                        User user = Main.users.get(Main.userLookup.get(username));
                        frame.dispose();
                        openHome(user);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    
                }

            }
        });
    }
    

     /**
      * Opens up the homepage
      * @param u The current user
      * @throws IOException
      */
     private void openHome(User u) throws IOException {

         // Create and configure the next window
         JFrame nextFrame = new JFrame("Welcome " + u.getUsername());
         nextFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         // Create an instance of ImagePanel with the second image
         ImagePanel backgroundPanel = new ImagePanel(homeImage);
         
         // Text box to display books
         jTextArea1 = new JTextArea();
         jTextArea1.setEditable(false);
         jTextArea1.setBounds(225, 332, 1392, 359);
         backgroundPanel.add(jTextArea1);
         
         // Profile button
         jButton1 = new JButton("Profile");
         setButton(jButton1, 5, 5, 122, 122);
         backgroundPanel.add(jButton1);
         
         // Reccomended button
         jButton2 = new JButton("Reccomended");
         setButton(jButton2, 5, 132, 122, 122);
         backgroundPanel.add(jButton2);
             
         // Search bar
         jTextField1 = new JTextField("Search");
         jTextField1.setBounds(655,200,600,80);
         backgroundPanel.add(jTextField1);
  
         // Search button
         jButton3 = new JButton("Search");
         setButton(jButton3, 570,200,80,80);
         backgroundPanel.add(jButton3);
         
         // Button to rate new books
         jButton4 = new JButton("Enter");
         setButton(jButton4,555,800,100,80);
         backgroundPanel.add(jButton4);
         
         // Text box for the user to rate new books
         jTextField2 = new JTextField("");
         jTextField2.setBounds(656,800,700,80);
         backgroundPanel.add(jTextField2);
         
         // Help button
         jButton5 = new JButton("Help");
        setButton(jButton5,5,776,122,122);
         backgroundPanel.add(jButton5);
         
         // Back button
         jButton6 = new JButton("Back");
         setButton(jButton6,220,800,100,80);
         backgroundPanel.add(jButton6);
         
         PrintStream outStream = new PrintStream( new TextAreaOutputStream(jTextArea1));
         jTextArea1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));

    	 System.setOut(outStream);
         Main.getTopBooks();
    	 
         // Opens profile, By Kaya
         jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
                try{
                    openProfile(u);
                } catch (IOException eIO){
                    eIO.printStackTrace();
                }
                
                nextFrame.dispose();
            }
         });
         // Opens reccomende, By Jonah
         jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                jTextArea1.setText(null);
                openRec(u);

            }
         });
        //Search button, By Matt K
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
        // Rates books, By Matt K
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Retrieve data
                String input = jTextField2.getText();
                //split by comma
                String[] temp = input.split("_");

                if (temp[0].equalsIgnoreCase("rate")) {
                    String[] temp2 = temp[1].split(",");
                    if (Main.bookLookup.containsKey(temp2[0])) {
                        u.rateBook(temp2);
                        jTextArea1.setText(null);
                        
                        try {
                            Main.rewriteUsers();
                            
                            Main.userLookup.clear();
                            Main.users.clear();
                            Main.books.clear();
                            Main.getBook();
                            Main.checkMap();
                            Main.getTopBooks();
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
         
        // Opens help, By MattK
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
        // Back button, By Kaya
        jButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                jTextArea1.setText(null);
                Main.getTopBooks();
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
     * Help System
     * By Matt K, Modified by Kaya
     * @throws IOException
     */
    private void openHelp() throws IOException {
    	 ImagePanel backgroundPanel = new ImagePanel(whiteImage);
    	 JFrame nextFrame = new JFrame("Help");

    	 jTextArea1 = new JTextArea();
    	 jTextArea1.setEditable(false);
         jTextArea1.setBounds(0, 0, 500, 500);
		 backgroundPanel.add(jTextArea1);
         
    	 String help1 = "Search Parameters should be seperated with commas and not spaces";
    	 String help2 = "To add a rating, type in the bottom box \"rate BookName,rating\" \nand press the button labled \"Enter\". Once you've done that, press \"Back\" to return to viewing the top books";
    	 String help3 = "To add a read book, go to profile and enter the title, then press \"Mark as read\"";
         String help4 = "When searching for a book, spelling mistakes can be handled, but your input must be spelled correctly when rating or marking one as read";
         String help5 = "The \"Sign out\" button is available from the profile";
    	 
    	 jTextArea1.setText(help1 + "\n\n" + help2 + "\n\n" + help3 + "\n\n" + help4 + "\n\n" + help5);
    	 
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
     /**
      * Reccomends the user books
      * @param u The current user
      * By Jonah
      */
    private void openRec(User u) {
 
        ArrayList<Integer> likedBooks = new ArrayList<>(); // Arraylist of books the user has rated 4+
        
        jTextArea1.setText(null);
        for (int i = 0; i < u.rateList.size(); i++) {

            if (u.rateList.get(i).equals("Unrated")) {

                continue;

            } else if (Integer.parseInt(u.rateList.get(i)) > 3) {

            likedBooks.add(i);

            }

        }

        ArrayList<Integer> recs = new ArrayList<>();
        // Goes through users to find ones with similar ratings
        for (int i = 0; i < Main.users.size(); i++) {

            for (int j = 0; j < Main.users.get(i).rateList.size(); j++) {

                if (!Main.users.get(i).rateList.get(j).equals("Unrated")) {

                    if (j == likedBooks.get(0)) {

                        for (int k = 0; k < Main.users.get(i).rateList.size(); k++) {
                            
                            if (!Main.users.get(i).rateList.get(k).equals("Unrated")) {
                                
                                if (Integer.parseInt(Main.users.get(i).rateList.get(k)) > 3) {

                                    recs.add(k + 1);

                                }                          
                            }
                        }
                    }
                }
            }
        }

        ArrayList<Integer> uRecs = (ArrayList) recs.stream().distinct().collect(Collectors.toList());

        for (int i = 0; i < uRecs.size(); i++) {
            for (int j = 0; j < u.rateList.size(); j++) {
                if ((!u.rateList.get(j).equals("Unrated")) && (j == (uRecs.get(0) - 1))) {
                    uRecs.remove(i);
                }
            }
        }
        System.out.println("Best Recommendations For You:");

        for (int i = 0; i < uRecs.size(); i++) {

            System.out.println(Main.books.get(uRecs.get(i)).toString());

        }
 
     }


     /**
      * Opens up the profile
      * @param u The current user
      * @throws IOException
      */
     private void openProfile(User u) throws IOException{
        profile = new JFrame(u.getUsername());
        setProfileBackground(u);      
        
        //Prints out read books
        printRead(u);  
        

        jButton1 = new JButton("Mark as read");
        setButton(jButton1, jTextField1.getX()+jTextField1.getWidth()+20, jTextField1.getY(), 200, 100);
        backgroundPanel.add(jButton1);
        
        jButton2 = new JButton("Home");
        setButton(jButton2,5,5,122,122);
        backgroundPanel.add(jButton2);

        jButton3 = new JButton("Sign out");
        setButton(jButton3, 5, 776, 122, 122);
        backgroundPanel.add(jButton3);

        //Marks a new book as read
        jButton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String input = jTextField1.getText();
                if (Main.bookLookup.containsKey(input)) {
                    u.addHasRead(input);
                    int index = Main.bookLookup.get(input);
                    System.out.println(input + " , " + u.rateList.get(index));
                    
                    try {
                        antarticagui.Main.rewriteUsers();
                    } catch (IOException eIO) {
                        eIO.printStackTrace();
                    }
                    
                }
            }
        });
        // Returns to home
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               
                    profile.dispose();
                    
                    // Open another window
                    try {
                        
                        openHome(u);
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                
            }
        });
        
        // Logs out
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                profile.dispose();
               login();
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

    /**
     * Prints out the books the user has read
     * @param u
     */
    private void printRead(User u){
        // Sets System to print to jTextArea1
        PrintStream outStream = new PrintStream( new TextAreaOutputStream(jTextArea1));
        System.setOut(outStream);

        jTextArea1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        jTextArea1.setEditable(false);
        // Checks if readList is empty
        if (u.readList.get(0).equals(null)){
            System.out.println("You have no read books");
        }
        for (int i = 1; i < u.readList.size(); i++){
            String book = u.readList.get(i);
            System.out.println(book + "," + u.rateList.get(Main.bookLookup.get(book)));

        }  
    }
    /**
     * Sets the profile background
     * @param u The user
     * By Kaya
     */
    private void setProfileBackground(User u){
        profile.setDefaultCloseOperation(EXIT_ON_CLOSE);
        backgroundPanel = new ImagePanel(profileImage);
        
        // Creates text box to display read books
        jTextArea1 = new JTextArea();
        jTextArea1.setBounds(backgroundPanel.getWidth()/4 -80, 250, 3*backgroundPanel.getWidth()/4 -150, 400);
        jTextArea1.setBackground(boxColor);
        backgroundPanel.add(jTextArea1);

        // Creates text box for the user to add new read books
        jTextField1 = new JTextField();
        jTextField1.setBounds(jTextArea1.getX(), 700, jTextArea1.getWidth(), 100);
        jTextArea1.setBackground(boxColor);
        backgroundPanel.add(jTextField1);


    }     
  
    /**
     * Creates a temporary frame to give the user a message
     * @param msg The message displayed
     * By Kaya
     */
    private void errorMessage (String msg){
        JFrame errorFrame = new JFrame();
        JLabel messagLabel = new JLabel(msg);
        errorFrame.setSize(300,200);
        errorFrame.add(messagLabel);
        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        errorFrame.setVisible(true);
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
    
    
    public void printTextField(String text, JTextArea textArea) {
        textArea.setText(text);
    }



}
