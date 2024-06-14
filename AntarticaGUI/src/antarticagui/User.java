
package antarticagui;
import antarticagui.Book;
import antarticagui.Main;

import java.sql.*;
import java.util.*;
import java.io.*;

public class User {
  private String username;
  private String hashedPass;
  private String ratings;
  private boolean isAdmin;
  private String booksRead;

  ArrayList<String> readList = new ArrayList<String>();
  ArrayList<String> rateList = new ArrayList<String>();
  String[] bData = new String[readList.size()];
 

  //MW
  /**
  Creates a user object
  **/
  public User(String n, String pass, String iA, String ratings, String read) {
    username = n;
    //hashedPass = Integer.toString(pass.hashCode());
    hashedPass = pass;
    this.ratings = ratings;
    booksRead = read;
    setReadList();
   // setRateList();
    setRateList();
    
    
    if (iA.equalsIgnoreCase("true")) {
      isAdmin = true;
    } else {
      isAdmin = false;
    }
  }  
  public void setReadList(){
    String temp[] = booksRead.split("!");
    for (int i = 0; i < temp.length; i++){
      readList.add(temp[i]); // Stores the books the user has read
    }
  }
 /*  public void setRateList() {
      String book[] = ratings.split("!"); // Makes an array of each book in ratings
      for (int i = 0; i < antarticagui.Main.books.size(); i++){
        try { 
          String[] temp = book[i].split("]"); // Split the book name and rating into an array
          if (antarticagui.Main.books.get(i).getTitle().equals(temp[0])){
          rateList.add(temp[1]); // Add the rating to index i if it's been rated
          }
        } catch (Exception e ) {
          rateList.add("Unrated"); // Add "unrated" to index i if it has not
        }
        
      }
  }*/

  public void setRateList() {

    String book[] = ratings.split("!");

    for (int i = 1; i < Main.books.size(); i++) {

      for (int j = 1; j < book.length; j++) {

        String[] temp = book[j].split("]");

        if (Main.books.get(i).getTitle().equals(temp[0])) {

          rateList.add(temp[1]);

        }

      }

      if (rateList.size() != i) {

        rateList.add("Unrated");

      }
     
    }

  }


  public String getUsername(){
    return username;
  }
  

  //MW
  /**
  Gets the stored data
  **/
  public String[] getUserData() {
	    String[] temp = new String[5];

	    temp[0] = username;
	    temp[1] = hashedPass;
	    temp[2] = Boolean.toString(isAdmin);
	    temp[3] = ratings;
      temp[4] = booksRead;

	    return temp;
	  }

  public void addHasRead(String bookName) {
    readList.add(bookName);
    booksRead += bookName + "!";
  }
  public void rateBook(String[] s){
    rateList.set(antarticagui.Main.bookLookup.get(s[0]), s[1]);
    ratings += s[0]+ "]" + s[1] + "!";

  }

  public void toDatabase() throws IOException {
    
      
  }  
  
  
  /*public static void addReadBooks(String book, double rating) {
	  
  }*/
  
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
	  File file = new File(antarticagui.Main.userFile);
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
   public static ArrayList<antarticagui.Book> generate(){
     ArrayList<antarticagui.Book> temp = new ArrayList<antarticagui.Book>();
   
     //Make a copy of books and shuffle it
     temp = new ArrayList<Book>(Main.books);
     Collections.shuffle(temp);

     for (int i = 9; i < temp.size(); i++){
       temp.remove(i);
     }
     return temp;
   }
   
   
   
}
