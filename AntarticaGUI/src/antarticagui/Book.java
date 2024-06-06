package antarticagui;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
public class Book{
  private String author;
  private String title;
  private String genre;
  private String description;
  private int score;
  private String[] ratings;

  //Kaya
  public Book (String t, String a, String g, String d){
    author = a;
    title = t;
    genre = g;
    description = d;
//    String[] rSplit = r.split(";");
//    double temp = 0;
//    for(String s : rSplit) {
//    	temp += Integer.parseInt(s);
//    }
//    avgRating = Math.round((temp*100)/rSplit.length)/100 + "";
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
    String[] temp = new String[4];
    
    temp[0] = author;
    temp[1] = title;
    temp[2] = genre;
    temp[3] = description;
    if (i == 4) {
    	return getRating()+"";
    }
    else {
    	return temp[i];
    }
    
  }
  
  public void calcScore(ArrayList<String> desires){
	  String temp[] = {author + title + genre};
	  ArrayList<String> attributesList = new ArrayList<String>(Arrays.asList(temp));
	    for(String s : desires) {
	    	for(String c : attributesList) {
	    		score = Main.spellcheck(s, c);
	    			
	    	}
	    }
	    
	   
	  }
  
  public int getScore() {
	  return score;
  }
  
  
  public double getRating() {
	  if (ratings == null) {
		  return 0;
	  }
	  int temp = 0;
	  
	  for (String s : ratings) {
		  try {
			  temp += Integer.parseInt(s);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	  return Math.round(((temp+0.0)*100)/ratings.length)/100;
	  
  }
  
  public void addRating(String r) {
	  if(ratings == null) {
		  ratings = new String[1];
		  ratings[0] = r;
//		  System.out.println(ratings.length + "ratings");
//		  System.out.println("null");
	  }
	  else {
//		  System.out.println(ratings.length + "ratings");
		  String[] temp = new String[ratings.length + 1];
		  for (int i = 0; i < ratings.length; i++) {
			  temp[i] = ratings[i];
		  }
	  temp[temp.length - 1] = r;
	  ratings = new String[temp.length];
	  for (int i = 0; i < temp.length; i++) {
		ratings[i] = temp[i];
//		System.out.println(ratings.length+"ratings");
//		System.out.println("not null");
	  }
	}
	  
	  
  }

  //will be changed as we work on the GUI
  //Kaya
  public String toString(){
    return title + " By: " + author + " Synopsis: " + description + " " + getRating() +"/5 " + genre + " ";

  }
}