package bevco;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection1 {
	private static Connection NULL;
	public Connection getconnection()throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c=null;
		c=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bevco","root","");
		if(c!=null)
			return c;
		else
			return null;
	
					
	}

}
