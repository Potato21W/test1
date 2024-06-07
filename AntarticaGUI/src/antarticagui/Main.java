package antarticagui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
public class Main {
  
  static ArrayList<Book> books = new ArrayList<Book>();
  static ArrayList<String> bookData = new ArrayList<String>();
  
  static ArrayList<User> users = new ArrayList<User>();
  static Map<String, Integer> userLookup = new HashMap<String, Integer>();// Username, index in Users
  static Map<String, Integer> bookLookup = new HashMap<String, Integer>();

  static String bookFile = "C:\\Users\\Dapik\\OneDrive\\Documents\\GitHub\\test1\\AntarticaGUI\\BookData.csv";
  static String userFile = "C:\\Users\\Dapik\\OneDrive\\Documents\\GitHub\\test1\\AntarticaGUI\\UserInfo.csv";
  
  public static void main(String[] args) throws IOException {
    //Put sql connections/call methods here
    System.out.println("now time to book");
    for (int i = 0; i < 5;i++) {
    	System.out.println(books.size());
    }
  }

//  static void setBooks() throws FileNotFoundException{
//	  ArrayList<Book> temp = new ArrayList<Book>();
//	  File file = new File("BookData.csv");
//	  Scanner inFile = new Scanner(file);
//	  
//	  while(inFile.hasNext()) {
//		  String line = inFile.nextLine();
//		  temp.add(new Book(line.split(",")[0],line.split(",")[1],line.split(",")[2],line.split(",")[3],line.split(",")[4]));
//	  }
//  }
//  
  //MattK
  public static boolean login (String name, String pass){
	  System.out.println(pass.hashCode());
	    if (userLookup.containsKey(name)){
	      if (users.get(userLookup.get(name)).getUserData()[1].equals(Integer.toString(pass.hashCode()))) {
	        return true;
	      } 
	    	
	    }
	    return false;
	  }
  
	 	/**
	   * Adds a new user
	   * @param name
	   * @param pass
	   * @throws IOException
	   * By Kaya
	  */
	  @SuppressWarnings({ "unlikely-arg-type" })
	  public static void signUp (String name, String pass) throws IOException{

		String hashed = pass.hashCode()+""; // Gets the hashed password and converts it into a string
		User temp = new User(name, hashed, "false", "", ""); // Creates a new user object based on the given input
		users.add(temp); // Adds the new user to users
		userLookup.put(name, users.size()); // Adds the new user to userLookup;

		rewriteUsers(); // Updates UserInfo.csv
	    
	  }	
	
	  public static boolean registered(String name){
		if (userLookup.containsKey(name)){
			System.out.println("Username taken");
			return true;
		}
		return false;
	  }
	  
	  public static void getBook() throws IOException {
		  
		  System.out.println("something");
		  File file = new File(bookFile);
		  
		  Scanner inputFile = new Scanner(file);
		  int counter = 0;
		  
		  while(inputFile.hasNext()) {
			  counter++;
			  inputFile.nextLine();
		  }
		  
		  inputFile.close();
		  
		  System.out.println(counter);
		  
		  inputFile = new Scanner(file);
		  
		  int count = 0;
		  while(inputFile.hasNext()) {
			  String inputLine = inputFile.nextLine(); 
			  String[] data = inputLine.split(",");
			  
			  System.out.println(data[0]);
			  Book temp = new Book(data[0],data[1],data[2],data[3]);
			  books.add(temp);
			  bookLookup.put(data[0], count);			  
			  count++;

      	}
		  
		inputFile.close();		  
		 
	  }
	  
	  
	  static ArrayList<Book> sort(ArrayList<Book> books){
		   
		  
		    for (int i = 0; i < books.size(); i++){
		    	books.get(i).getData(4);
		    }
		    
		    Collections.sort(books, Comparator.comparing(Book::getRating).reversed());
		    
		    return books;
		  }
	  
	  public static void toMap(String name, String pass, String iA, String ratings, String booksRead) {
		  User temp = new User(name, pass, iA, ratings, booksRead);
	      users.add(temp);
	      userLookup.put(name, users.size() - 1);
	  }
	  
	  public static void checkMap() throws IOException{
		  File file = new File(userFile);
		  Scanner fileIn = new Scanner(file);
		  String[] in;
		  String line;
		  
		  while (fileIn.hasNext()) {
			  line = fileIn.nextLine();
			  System.out.println(line);
			  in = line.split(",");
			  toMap(in[0],in[1],in[2],in[3],in[4]);
			  setRatingData(in[3]);
			  System.out.println("Working");
			  
		  }
		  
		  fileIn.close();
	  }
	  
	//different books are separated by !
	   //rating to the book is separated by ?
	   public static void setRatingData(String data) {
		   String[] b = data.split("!");
		   for(String s : b) {
			   if (!s.equals("")) {
				   String[] temp = s.split("]");
				   System.out.println(temp[0] + bookLookup.get(temp[0]));
				   int i = bookLookup.get(temp[0]);
				   books.get(i).addRating(temp[1]);
				   try {
					rewriteUsers();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
		   }
	   }
	   
	   public static void rateBook(String[] s, String name) {
		
		   users.get(userLookup.get(name)).addRating(s[0]+"]"+s[1]+"!");
	   }
	   
	   public static void rewriteUsers() throws IOException {
		   PrintWriter pw = new PrintWriter(userFile);
		   String[] temp;
		   for(User u : users) {
			   temp = u.getUserData();
			   pw.println(temp[0]+","+temp[1]+","+temp[2]+","+temp[3]+","+temp[4]);
		   }
		   pw.close();		   
	   }
  
}