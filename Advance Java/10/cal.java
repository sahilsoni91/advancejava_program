import java.rmi.*;
public interface cal extends java.rmi.Remote
{
	public int add(int a,int b) throws RemoteException;
	public int sub(int a,int b) throws RemoteException;
	public int mul(int a,int b) throws RemoteException;
	public int div(int a,int b) throws RemoteException;
}