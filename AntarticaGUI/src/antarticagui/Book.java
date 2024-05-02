package antarticagui;

public class Book{
  private String author;
  private String title;
  private String genre;
  private String description;
  private String avgRating = "0";

  //Kaya
  public Book (String t, String a, String g, String d, String r){
    author = a;
    title = t;
    genre = g;
    description = d;
    avgRating = r;
    
  }

  public String getTitle(){
    return title;
  }

  /**
  * Returns all the book data for the book
  * Coded by MattK
  * @return the data in a String array
  */
  public String getData(int i){
    String[] temp = new String[5];
    
    temp[0] = author;
    temp[1] = title;
    temp[2] = genre;
    temp[3] = description;
    temp[4] = avgRating;
    
    return temp[i];
  }

  //will be changed as we work on the GUI
  //Kaya
  public String toString(){
    return title + " By: " + author + " Synopsis: " + description + " " + avgRating +"/5 " + genre + " ";

  }
}