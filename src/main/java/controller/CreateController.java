package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuthorDAO;
import dao.BookDAO;
import model.Author;
import model.Book;

/**
 * Servlet implementation class InsertController
 */
@WebServlet("/Create")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<Author> author= new AuthorDAO().getAuthor();
		request.setAttribute("author", author);
		request.getRequestDispatcher("add-a-book.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Book b= new Book();
		b.setTitle(request.getParameter("title"));
		b.setPageCount(Integer.parseInt(request.getParameter("pageCount")));
		b.setDatepublished(Date.valueOf(request.getParameter("datePublished")));
		b.setPrice(Double.parseDouble(request.getParameter("price")));		
		b.setStatus(request.getParameter("status").equals("active"));
		
		
		Author a= new Author();
		//a.setAuthor_Name(request.getParameter("authorName"));
		a.setAuthor_Id(Integer.parseInt(request.getParameter("Author_Id")) );		
		b.setAuth(a);
		
		BookDAO bd= new BookDAO();
		bd.insert(b);
		
		response.sendRedirect("List");
		
	}

}
