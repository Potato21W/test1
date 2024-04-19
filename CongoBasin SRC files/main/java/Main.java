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
  }
}