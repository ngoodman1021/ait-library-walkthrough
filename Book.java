package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main
{
  public static void main(String[] args) throws SQLException
  {
    final String url = "jdbc:mysql://localhost:3306/library?serverTimezone=EST";
    final String username = "root";
    final String password = "rootpwd";

    Connection conn = DriverManager.getConnection(url, username, password);
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM books");

    System.out.println("Books in the Library:\n");
    while (rs.next()) {
      String title = rs.getString("title");
      String author = rs.getString("author");
      int copies = rs.getInt("copies");
      int available = rs.getInt("available");

      System.out.println(" --> " + title + " by " + author + " (" + available + " of " + copies + ")");
    }
    
    rs.close();
    stmt.close();
    conn.close();
  }
}

package library;

public class Book
{
  private int id;
  private String title;
  private String author;
  private int copies;
  private int available;

  public Book(int id, String title, String author, int copies, int available)
  {
    super();

    this.id = id;
    this.title = title;
    this.author = author;
    this.copies = copies;
    this.available = available;
  }
  
  public int getId()
  {
    return id;
  }

  public String getTitle()
  {
    return title;
  }
    
  public String getAuthor()
  {
    return author;
  }

  public int getCopies()
  {
    return copies;
  }
    
  public void setCopies(int copies)
  {
    this.copies = copies;
  }
    
  public int getAvailable()
  {
    return available;
  }
    
  public void setAvailable(int available)
  {
    this.available = available;
  }
}
