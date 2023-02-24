package unit_testing.First_one;
import java.sql.*;

public class database {
	public Connection con;
	public static void main(String[]args) {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/deekshith","root","Deekshith@24");
			if(con!=null) 
			{
				System.out.println("Successfully connected");
				
			}
		}
		catch(Exception e) 
		{
			System.out.println(e);
			System.out.println("not connected");
		}
	}

}
