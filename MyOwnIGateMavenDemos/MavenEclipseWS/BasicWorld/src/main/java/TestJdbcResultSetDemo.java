import java.sql.*;

public class TestJdbcResultSetDemo
{
	public static void main(String[] args) 
	{
		Connection cnn;
		Statement stmt;
		ResultSet rs;
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String query="SELECT * FROM eee1";

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Class not found!!!!!!"+e);
		}

		try
		{
			cnn=DriverManager.getConnection(url,"system","root");
			stmt=cnn.createStatement();
			rs=stmt.executeQuery(query);	
			
			System.out.println("Printing first row from result set........");
			rs.next();
			System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("..................."+e.getMessage());
		}
	}
}
