package model;

import java.sql.Date;
import java.util.ArrayList;

public class Book {
	private int Book_ID;
	private String Title;
	private int PageCount;
	private Date Datepublished;
	private double price;
	private boolean Status;
	
	private Author auth;
		
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int book_ID, String title, int pageCount, Date datepublished, double price, boolean status,
			 Author auth) {
		super();
		this.Book_ID = book_ID;
		this.Title = title;
		this.PageCount = pageCount;
		this.Datepublished = datepublished;
		this.price = price;
		this.Status = status;
		
		this.auth = auth;
	}

	public int getBook_ID() {
		return Book_ID;
	}

	public void setBook_ID(int book_ID) {
		Book_ID = book_ID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public int getPageCount() {
		return PageCount;
	}

	public void setPageCount(int pageCount) {
		PageCount = pageCount;
	}

	public Date getDatepublished() {
		return Datepublished;
	}

	public void setDatepublished(Date datepublished) {
		Datepublished = datepublished;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}


	

	public Author getAuth() {
		return auth;
	}

	public void setAuth(Author auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "Book [Book_ID=" + Book_ID + ", Title=" + Title + ", PageCount=" + PageCount + ", Datepublished="
				+ Datepublished + ", price=" + price + ", Status=" + Status + ", auth="
				+ auth + "]";
	}
	
	
	
}
