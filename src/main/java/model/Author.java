package model;

public class Author {
	private int Author_Id;
	private String Author_Name;
	public Author() {
		// TODO Auto-generated constructor stub
	}
	public Author(int author_Id, String author_Name) {
		super();
		Author_Id = author_Id;
		Author_Name = author_Name;
	}
	public int getAuthor_Id() {
		return Author_Id;
	}
	public void setAuthor_Id(int author_Id) {
		Author_Id = author_Id;
	}
	public String getAuthor_Name() {
		return Author_Name;
	}
	public void setAuthor_Name(String author_Name) {
		Author_Name = author_Name;
	}
	@Override
	public String toString() {
		return "Author [Author_Id=" + Author_Id + ", Author_Name=" + Author_Name + "]";
	}
	
}
