/*
 * 
 * 
 */
package CongoBasin;
import java.sql.*;
import java.util.*;
import java.io.*;
public class Main {
  
  static ArrayList<Book> books = new ArrayList<Book>();
  
  static ArrayList<User> users = new ArrayList<User>();
  static Map<String, Integer> userLookup = new HashMap<String, Integer>();// Username, index in Users
  

  public static void main(String[] args) throws IOException{

    File myFile = new File("UserInfo.csv");
    Scanner readFile = new Scanner(myFile);

    //Read in all the usernames, passwords, and admin statuses
    while (readFile.hasNext()){
      String temp[] = readFile.nextLine().split(",");
      users.add(new User(temp[0], temp[1], temp[1]));
    }
    readFile.close();
    //Put sql connections/call methods here
    
    //add user's index to map
    for(int i = 0; i < users.size(); i++){
      userLookup.put(users.get(i).getUserData()[0], i);
    }
    
  }
  /**
   * Checks whether the users login is valid
   * @param name The user's username
   * @param pass The user's password
   * @return A boolean determining whether the login is valid
   * By Kaya
   */
  public static boolean login (String name, String pass){
    if (userLookup.containsKey(name)){
      if (users.get(userLookup.get(name)).checkPass(pass)){
        return true;
      }
    }
    return false;
  }

  /**
   * Registers a new User
   * @param name The inputted username
   * @param pass the inputed password
   * By Kaya
   */
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
  
}
