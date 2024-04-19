import java.sql.*;
import java.util.*;

public class User {
  private String username;
  private String hashedPass;
  private boolean isAdmin;

  ArrayList<String> list = new ArrayList<String>();
  String[] bData = new String[list.size()];
 

  //MW
  public User(String n, String pH, String iA) {
    username = n;
    hashedPass = Integer.toString(pH.hashCode());
    
    if (iA.equalsIgnoreCase("true")) {
      isAdmin = true;
    } else {
      isAdmin = false;
    }
  }  

  //MattK
  public boolean checkPass(String pass){
    if (hashedPass.equals(Integer.toString(pass.hashCode()))){
      return true;
    }
    else{
      return false;
    }
  }

  //MW
  public String[] getUserData() {
    String[] temp = new String[2];

    temp[0] = username;
    temp[1] = hashedPass;
    temp[2] = Boolean.toString(isAdmin);

    return temp;
  }

  public void addHasRead(String bookName, String rating) {
    list.add(bookName + "," + rating);
    
  }

  public void toDatabase() throws SQLException {
    String stmnt = "INSERT INTO Users (USERNAME, PASSHASH )";
      
  }  
}

 class Dashboard{
   //MattK
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