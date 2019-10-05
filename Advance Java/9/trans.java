import java.sql.*;
public class trans
{
	public static void main(String ags[]) throws SQLException
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mydsn1");
			Statement stmt=con.createStatement();
			String str1="Select * from Btech";
			ResultSet rs=stmt.executeQuery(str1);
			while(rs.next())
			{
				System.out.println(rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			}
			System.out.println("\n");
			Statement stmt1=con.createStatement();
			stmt1.addBatch("insert into Btech(NAME,BRANCH,ADDRESS,HOSTEL) values('SANJANA','CSE','ROHTAK','HOME')");
			int a[]=stmt1.executeBatch();
			Statement stmt2=con.createStatement();
			String str2="Select * from Btech";
			ResultSet rs1=stmt2.executeQuery(str2);
			while(rs1.next())
			{
				System.out.println(rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getString(4)+"\t"+rs1.getString(5));
			}
			con.commit();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}