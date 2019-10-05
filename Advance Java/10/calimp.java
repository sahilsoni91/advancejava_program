import java.rmi.*;
public class calimp extends java.rmi.server.UnicastRemoteObject implements cal
{
	public calimp() throws RemoteException
	{
		super();
	}
	public int add(int a,int b) throws RemoteException
	{
		return (a+b);
	}
	public int sub(int a,int b) throws RemoteException
	{
		return (a-b);
	}
	public int mul(int a,int b) throws RemoteException
	{
		return (a*b);
	}
	public int div(int a,int b) throws RemoteException
	{
		return (a/b);
	}
}