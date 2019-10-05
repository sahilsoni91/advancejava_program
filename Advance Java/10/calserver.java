import java.rmi.Naming;
public class calserver
{
	public calserver()
	{
		try
		{
			cal c = new calimp();
			Naming.rebind("rmi://localhost:1099/calservice",c);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String args[])
	{
		new calserver();
	}
}