package CongoBasin;
import java.sql.*;
import java.util.*;
public class SQLQueries{

  //MattK
  public static ArrayList<String[]> getUserData(Connection con) throws SQLException {
    String query = "select USERNAME, PASSHASH, BOOKSRATED, RATINGS, ISADMIN, BOOKSREAD from USERS";
    ArrayList<String[]> data = new ArrayList<String[]>();
    String[] temp;
    try (Statement stmt = con.createStatement()) {
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        temp = new String[6];
        temp[0] = (rs.getString("USERNAME"));
        temp[1] = (rs.getString("PASSHASH"));
        temp[2] = (rs.getString("BOOKSRATED"));
        temp[3] = (rs.getString("RATINGS"));
        temp[4] = (rs.getString("ISADMIN"));
        temp[5] = (rs.getString("BOOKSREAD"));
        data.add(temp);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return data;
  }

  //MattK
  public static ArrayList<String[]> getBookData(Connection con) throws SQLException {
    String query = "select TITLE, AUTHOR, GENRE, DESC from BOOKS";
    ArrayList<String[]> data = new ArrayList<String[]>();
    String[] temp;
    try (Statement stmt = con.createStatement()) {
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        temp = new String[4];
        temp[0] = (rs.getString("TITLE"));
        temp[1] = (rs.getString("AUTHOR"));
        temp[2] = (rs.getString("GENRE"));
        temp[3] = (rs.getString("DESC"));
        data.add(temp);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return data;
  }
  
}
