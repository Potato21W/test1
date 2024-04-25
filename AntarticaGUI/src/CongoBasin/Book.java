/*
 * 
 */
package CongoBasin;
class Book{
  private String author;
  private String title;
  private String genre;
  private String description;
  private String avgRating = "0";

  /**
   * Book constructor
   * @param t The book's title
   * @param a The book's author
   * @param g The book's genre
   * @param d The book's description
   * By Kaya
   */
  public Book (String t, String a, String g, String d){
    author = a;
    title = t;
    genre = g;
    description = d;
  }

  /**
   * Gets the book's title
   * @return the title
   */
  public String getTitle(){
    return title;
  }

  /**
  * Returns all the book data for the book
  * @return the data in a String array
  * By Matthew K
  */
  public String[] getData(){
    String[] temp = new String[5];
    
    temp[0] = author;
    temp[1] = title;
    temp[2] = genre;
    temp[3] = description;
    temp[4] = avgRating;
    
    return temp;
  }

  //will be changed as we work on the GUI
  /**
   * The toString method
   * @return A string containing the book's info
   * By Kaya
   */
  public String toString(){
    return title + "\nBy: " + author + "\n\nSynopsis:\n" + description + "\n\n" + avgRating +"/5\n" + genre + "\n";
  }
}
