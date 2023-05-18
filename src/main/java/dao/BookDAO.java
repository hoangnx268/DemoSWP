package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Book;
import model.Author;

public class BookDAO extends DBcontext {

	private PreparedStatement ps = null;
	private ResultSet rs;
	private String sql = null;

	public ArrayList<Book> getAllBook() {
		ArrayList<Book> books = new ArrayList<>();

		try {
			sql = "select b.*, a.Author_Name\r\n" + "from Book b, Author a\r\n" + "where b.Author_Id = a.Author_Id";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Book b = new Book();
				b.setBook_ID(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setPageCount(rs.getInt(3));
				b.setDatepublished(rs.getDate(4));
				b.setPrice(rs.getDouble(5));
				b.setStatus(rs.getBoolean(6));

				Author a = new Author();
				a.setAuthor_Id(rs.getInt(7));
				a.setAuthor_Name(rs.getString(8));

				b.setAuth(a);

				books.add(b);
			}

		} catch (SQLException ex) {

		}

		return books;

	}

	public void insert(Book b) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO dbo.Book (Title, Page_Count, Date_published,Price, Status,Author_Id)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, b.getTitle());
			stm.setInt(2, b.getPageCount());
			stm.setDate(3, b.getDatepublished());
			stm.setDouble(4, b.getPrice());
			stm.setBoolean(5, b.isStatus());
			stm.setInt(6, b.getAuth().getAuthor_Id());
			stm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Book getBook(int id) {

		try {
			String sql = "SELECT [Book_ID]\r\n" + "      ,[Title]\r\n" + "      ,[Page_Count]\r\n"
					+ "      ,[Date_published]\r\n" + "      ,[Price]\r\n" + "      ,[Status]\r\n"
					+ "      ,b.[Author_Id]\r\n" + "	  ,a.Author_Name\r\n"
					+ "  FROM [dbo].[Book] b join Author a \r\n" + "  on b.Author_Id=a.Author_Id\r\n"
					+ "  where Book_ID=?";
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, id);

			ResultSet rs = stm.executeQuery();

			if (rs.next()) {
				Book book = new Book();
				book.setBook_ID(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setPageCount(rs.getInt(3));
				book.setDatepublished(rs.getDate(4));
				book.setPrice(rs.getDouble(5));
				book.setStatus(rs.getBoolean(6));

				Author author = new Author();
				author.setAuthor_Id(rs.getInt(7));
				author.setAuthor_Name(rs.getString(8));

				book.setAuth(author);
				return book;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void update(Book b) {
		// TODO Auto-generated method stub

		try {
			String sql = "UPDATE Book \r\n"
					+ "set Title=?, Page_Count=?, Date_published=?, Price=?, Status=?, Author_Id=?\r\n"
					+ "where Book_ID=?";

			PreparedStatement stm = connection.prepareStatement(sql);

			stm.setString(1, b.getTitle());
			stm.setInt(2, b.getPageCount());
			stm.setDate(3, b.getDatepublished());
			stm.setDouble(4, b.getPrice());
			stm.setBoolean(5, b.isStatus());
			stm.setInt(6, b.getAuth().getAuthor_Id());
			stm.setInt(7, b.getBook_ID());
			stm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		// TODO Auto-generated method stub

		try {
			String sql = "DELETE FROM [dbo].[Book]\r\n" + "      WHERE Book_ID=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
