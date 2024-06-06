package antarticagui;

import java.sql.*;
import java.util.*;
import java.io.*;

public class User {
  private String username;
  private String hashedPass;
  private String ratings;
  private boolean isAdmin;

  ArrayList<String> list = new ArrayList<String>();
  String[] bData = new String[list.size()];
 

  //MW
  /**
  Creates a user object
  **/
  public User(String n, String pass, String iA, String ratings) {
    username = n;
    //hashedPass = Integer.toString(pass.hashCode());
    hashedPass = pass;
    this.ratings = ratings;
    
    if (iA.equalsIgnoreCase("true")) {
      isAdmin = true;
    } else {
      isAdmin = false;
    }
  }  

  
  
  

  //MW
  /**
  Gets the stored data
  **/
  public String[] getUserData() {
	    String[] temp = new String[4];

	    temp[0] = username;
	    temp[1] = hashedPass;
	    temp[2] = Boolean.toString(isAdmin);
	    temp[3] = ratings;

	    return temp;
	  }

  public void addHasRead(String bookName, String rating) {
    list.add(bookName + "," + rating);
    
  }

  public void toDatabase() throws IOException {
    
      
  }  
  
  
  public static void addReadBooks(String book, double rating) {
	  
  }
  
  public static String getReadBooks(User user) {
	  return null;
  }
  
  public void addRating(String s) {
	  ratings += s;
  }
  
  public static int getHash(String input) {
	  return input.hashCode();
  }
  
  public static int userInfoFileLength() throws IOException {
	  int length = 0;
	  File file = new File("UserInfo.csv");
	  Scanner fileIn = new Scanner(file);
	  
	  while (fileIn.hasNext()) {
		  length++;
		  fileIn.nextLine();
	  }
	  fileIn.close();
	  
	  return length;
	  
  }
  
  
}

	

/*
This class is the dashboard for the menu
*/
 class Dashboard{
   //MattK

   /**
    gets a list of books stored in the "database", puts it into an array and gets 10 random books to display
   */
   public static ArrayList<Book> generate(){
     ArrayList<Book> temp = new ArrayList<Book>();
   
     //Make a copy of books and shuffle it
     temp = new ArrayList<Book>(Main.books);
     Collections.shuffle(temp);

     for (int i = 9; i < temp.size(); i++){
       temp.remove(i);
     }
     return temp;
   }
   
   
   
}