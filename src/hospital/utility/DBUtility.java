package hospital.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DBUtility {
	Connection con;
	
	public Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pankaj","root","root");
			return con;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

}
