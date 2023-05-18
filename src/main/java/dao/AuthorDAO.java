package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Author;


public class AuthorDAO extends DBcontext {
	public ArrayList<Author> getAuthor(){
		ArrayList<Author> auth= new ArrayList<>();
		
		
		try {
			String sql="SELECT [Author_Id]\r\n"
					+ "      ,[Author_Name]\r\n"
					+ "  FROM [dbo].[Author]";
	        PreparedStatement stm = connection.prepareStatement(sql);
	        ResultSet rs = stm.executeQuery();
	        
	        while(rs.next()) {
	        	Author a= new Author();
	        	a.setAuthor_Id(rs.getInt(1));
	        	a.setAuthor_Name(rs.getString(2));
	        	auth.add(a);
	        }
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return auth;
	}
}
