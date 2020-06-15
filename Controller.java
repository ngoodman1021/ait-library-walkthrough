package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.Book;
import library.BookDAO;

public class Controller extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  private BookDAO dao;
  
  public void init()
  {
    final String url = getServletContext().getInitParameter("JDBC-URL");
    final String username = getServletContext().getInitParameter("JDBC-USERNAME");
    final String password = getServletContext().getInitParameter("JDBC-PASSWORD");
    
    dao = new BookDAO(url, username, password);
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
  {
    doGet(request, response);
  }
  
  @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
{
  final String action = request.getServletPath();
  
  try {
    switch (action) {
	    case "/add":
      case "/edit":
	      showEditForm(request, response);
	    	break;
      case "/update":
        updateBook(request, response);
        break;
      default:
        viewBooks(request, response);
        break;
    }
  } catch (SQLException e) {
    throw new ServletException(e);
  }
}
 private void updateBook(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException
{	
  final String action = request.getParameter("action");
  final int id = Integer.parseInt(request.getParameter("id"));
  
  Book book = dao.getBook(id);
  switch (action) {
    case "rent":
      book.rentMe();
      break;
    case "return":
      book.returnMe();
      break;
  }
  dao.updateBook(book);
  
  response.sendRedirect(request.getContextPath() + "/");
}
 
 private void viewBooks(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException
  {
    List<Book> books = dao.getBooks();
    request.setAttribute("books", books);
    
    RequestDispatcher dispatcher = request.getRequestDispatcher("inventory.jsp");
    dispatcher.forward(request, response);
  }
}
