import java.sql.*;
public class meta
{
	public static void main(String arg[]) throws SQLException
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mydsn1");
			Statement stmt=con.createStatement();
			String str="Select * from Btech";
			ResultSet rs=stmt.executeQuery(str);
			DatabaseMetaData mtd=con.getMetaData();
			System.out.println("\nMajor version:"+mtd.getJDBCMajorVersion());
			ResultSetMetaData metad=rs.getMetaData();
			System.out.println("\nCOLUMN NAME:\n");
			for(int i=1;i<metad.getColumnCount();i++)
			{
				System.out.println(i+". "+metad.getColumnName(i));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}