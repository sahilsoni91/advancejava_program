import java.sql.*;
public class update
{
	public static void main(String ag[]) throws SQLException
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mydsn1");
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String str="Select * from Btech";
			ResultSet rs=stmt.executeQuery(str);
			if(rs.next())
			{
				rs.updateString("NAME","KARAN");
				rs.updateRow();
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}