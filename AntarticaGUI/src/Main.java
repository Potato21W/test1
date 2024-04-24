package CongoBasin;
import java.sql.*;
import java.util.*;
public class Main {
  
  static ArrayList<Book> books = new ArrayList<Book>();
  
  static ArrayList<User> users = new ArrayList<User>();
  static Map<String, Integer> userLookup = new HashMap<String, Integer>();// Username, index in Users
  

  public static void main(String[] args) {
    //Put sql connections/call methods here
    
    //add user's index to map
    for(int i = 0; i < users.size(); i++){
      userLookup.put(users.get(i).getUserData()[0], i);
    }
    System.out.println("Hello world");
    //Register cycle (Kaya)
    
  }
  //Kaya
  public static boolean login (String name, String pass){
    /*if (userLookup.containsKey(name)){
      if (users.get(userLookup.get(name)).checkPass(pass)){
        return true;
      }
    }
    return false;*/
    if (name.equals("User1")){
      System.out.println("Test1");
      if (Integer.toString("Password123".hashCode()).equals(Integer.toString(pass.hashCode()))){
        System.out.println("Test2");
        return true;
      }
    }
    return false;
  }
  //Kaya
  public static void signUp (String name, String pass){
    do{

      if (userLookup.containsValue(name)){
        System.out.println("That username already exists");
      }
      else{
        User temp = new User(name, pass, "false");
    users.add(temp);
    userLookup.put(name, users.size());
      }
    }while(userLookup.containsKey(name));
    
  }
  
}