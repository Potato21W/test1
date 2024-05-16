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
  
  
  public static void main(String[] args) throws IOException {
    //Put sql connections/call methods here
<<<<<<< HEAD
    
    //add user's index to map
    for(int i = 0; i < users.size(); i++){
      userLookup.put(users.get(i).getUserData()[0], i);
    }
  }



=======

    getBook();
    setBooks();
    System.out.println("now time to book");
    for (int i = 0; i < 5;i++) {
    	System.out.println(books.size());
    }
  }

  static void setBooks() throws FileNotFoundException{
	  ArrayList<Book> temp = new ArrayList<Book>();
	  File file = new File("BookData.csv");
	  Scanner inFile = new Scanner(file);
	  
	  while(inFile.hasNext()) {
		  String line = inFile.nextLine();
		  temp.add(new Book(line.split(",")[0],line.split(",")[1],line.split(",")[2],line.split(",")[3],line.split(",")[4]));
	  }
  }
  
>>>>>>> 8790ed4c021b2ecf35a69742edfd91aba7af07c8
  //MattK
  public static boolean login (String name, String pass){
	
	User user = new User("test7", "test7", "false");
	  if (userLookup.containsKey(name)){
		System.out.println(pass.hashCode());
	System.out.println(users.get(userLookup.get(name)).getUserData()[1]);
	System.out.println(Integer.toString(pass.hashCode()));
		if (users.get(userLookup.get(name)).getUserData()[1].equals(Integer.toString(pass.hashCode()))) {
		  return true;
		} 
		  
	  }
	  return false;
	}

  
	  //Kaya
	  @SuppressWarnings({ "unlikely-arg-type" })
	  public static void signUp (String name, String pass) throws IOException{

	        User temp = new User(name, pass, "false");
	        users.add(temp);
	        userLookup.put(name, users.size());

			
	        FileWriter fw = new FileWriter("/resources/UserInfo.csv", true);
	        PrintWriter writeFile = new PrintWriter(fw);

	        writeFile.println(name + "," + pass + ",false");
	        writeFile.close();
	    
	  }
	
	  public static boolean registered(String name){
		if (userLookup.containsKey(name)){
			System.out.println("Username taken");
			return true;
		}
		return false;
	  }
	
	  public static void getBook() throws IOException{
		  File file = new File("/resources/BookData.csv");
		  
		  Scanner inputFile = new Scanner(file);
		  int counter = 0;
		  
		  
		  while(inputFile.hasNext()) {
			  String inputLine = inputFile.nextLine(); 
			  String[] data = inputLine.split(",");
			  
			  books.add(new Book(data[0],data[1],data[2],data[3],data[4]));

      	}
		  
		  inputFile.close();
		  
		 
	  }
	  
<<<<<<< HEAD
=======
	  
	  static ArrayList<Book> sort(ArrayList<Book> books){
		   
		  
		    for (int i = 0; i < books.size(); i++){
		    	books.get(i).getData(4);
		    }
		    
		    Collections.sort(books, Comparator.comparing(Book::getScore).reversed());
		    
		    return books;
		  }
	  
>>>>>>> 8790ed4c021b2ecf35a69742edfd91aba7af07c8
	  public static void toMap(String name, String pass) {
		  User temp = new User(name, pass, "false");
	        users.add(temp);
	        userLookup.put(name, users.size());
	  }
	  
	  public static void checkMap() throws IOException{
<<<<<<< HEAD
		File file = new File("UserInfo.csv");
		Scanner fileIn = new Scanner(file);
		String[] in;
		String line;
		
		while (fileIn.hasNext()) {
			line = fileIn.nextLine();
			System.out.println(line);
			in = line.split(",");
			toMap(in[0],in[1]);
			
		}
		
		fileIn.close();
	}
=======
		  File file = new File("UserInfo.csv");
		  Scanner fileIn = new Scanner(file);
		  String[] in;
		  String line;
		  
		  while (fileIn.hasNext()) {
			  line = fileIn.nextLine();
			  System.out.println(line);
			  in = line.split(",");
			  toMap(in[0],in[1]);
			  System.out.println("Working");
			  
		  }
		  
		  fileIn.close();
	  }
>>>>>>> 8790ed4c021b2ecf35a69742edfd91aba7af07c8
  
}