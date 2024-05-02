package antarticagui;

import java.io.File;
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
  
  
  public static void main(String[] args) {
    //Put sql connections/call methods here
    
    //add user's index to map
    for(int i = 0; i < users.size(); i++){
      userLookup.put(users.get(i).getUserData()[0], i);
    }
  }

    //Register cycle (Kaya)
    /*do{
      //Get from GUI
      String user = ;
      String pass;

      if (userLookup.containsValue(user)) {
        System.out.println("That username already exists");
      }
      else{
        signUp(user, pass);
      }
    }while(userLookup.containsKey(users));
  }*/
  
  //Kaya
  public static boolean login (String name, String pass){
	  
	    if (userLookup.containsKey(name)){
	      if (users.get(userLookup.get(name)).checkPass(pass)) {
	        return true;
	      }
	    }
	    return false;
	  }
  
	  //Kaya
	  @SuppressWarnings({ "unlikely-arg-type" })
	  public static void signUp (String name, String pass) throws IOException{
	      if (userLookup.containsKey(name)){
	        System.out.println("That username already exists");
	      }
	      else{
	        User temp = new User(name, pass, "false");
	        users.add(temp);
	        userLookup.put(name, users.size());

	        FileWriter fw = new FileWriter("UserInfo.csv", true);
	        PrintWriter writeFile = new PrintWriter(fw);

	        writeFile.println(name + "," + pass + ",false");
	        writeFile.close();
	      }
	    
	  }
	  
	  public static void getBook() throws IOException{
		  File file = new File("BookData.csv");
		  
		  Scanner inputFile = new Scanner(file);
		  int counter = 0;
		  
		  
		  while(inputFile.hasNext()) {
          	bookData.add(inputFile.nextLine());
      	}
		  
		  inputFile.close();
		  
		  inputFile = new Scanner(file);
		  String[] line = new String[counter];
		  for (int j = 0; j < counter; j++) {
			  line[j] = inputFile.nextLine();
		  }
		  
		  inputFile.close();
		 
	  }
	  
	  public static void toMap(String name, String pass) {
		  User temp = new User(name, pass, "false");
	        users.add(temp);
	        userLookup.put(name, users.size());
	  }
	  
	  public static void checkMap() throws IOException{
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
  
}