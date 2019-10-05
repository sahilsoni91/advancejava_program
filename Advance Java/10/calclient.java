import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
public class calclient
{
	public static void main(String args[])
	{
		try
		{
			cal c=(cal)Naming.lookup("rmi://localhost/calservice");
			System.out.println(c.add(5,10));
			System.out.println(c.sub(20,10));
			System.out.println(c.mul(2,4));
			System.out.println(c.div(16,4));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}