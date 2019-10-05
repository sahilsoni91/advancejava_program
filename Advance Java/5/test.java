import java.sql.*;
public class test
{
	public void show()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:mydsn1");
			Statement stmt=con.createStatement();
			String str="Select * from Btech where BRANCH='IT' and ADDRESS='DELHI' and HOSTEL='Ravidas'";
			ResultSet rs=stmt.executeQuery(str);
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
class demo
{
	public static void main(String ag[]) throws SQLException
	{
		test st=new test();
		st.show();
	}
}