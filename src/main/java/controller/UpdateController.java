package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Author;
import model.Book;
import dao.AuthorDAO;
import dao.BookDAO;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/Update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id= Integer.parseInt(request.getParameter("id"));
		
		Book book= new BookDAO().getBook(id);
		request.setAttribute("book", book);
		
		AuthorDAO a= new AuthorDAO();
		ArrayList<Author> author= a.getAuthor();
		request.setAttribute("author", author);
		
		request.getRequestDispatcher("update-book.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Book b= new Book();
		b.setTitle(request.getParameter("title"));
		b.setPageCount(Integer.parseInt(request.getParameter("pageCount")));
		b.setPrice(Double.parseDouble(request.getParameter("price")));
		b.setDatepublished(Date.valueOf(request.getParameter("datePublished")));
		b.setStatus(request.getParameter("status").equals("active"));
		
		Author a= new Author();
		a.setAuthor_Id(Integer.parseInt(request.getParameter("Author_Id")));
		b.setAuth(a);
		
		BookDAO bd= new BookDAO();
		bd.update(b);
		
		response.sendRedirect("List");
	}

}
