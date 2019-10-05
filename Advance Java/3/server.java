import java.io.*;
import java.net.*;
import java.util.*;
public class server
{
	DataInputStream dis;
	public server()
	{
		try
		{
			System.out.println("Server Started");
			ServerSocket s=new ServerSocket(8189);
			Socket incoming=s.accept();
			System.out.println("Client Connected");
			dis=new DataInputStream(incoming.getInputStream());
			serverchat();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void serverchat() throws IOException
	{
		String str;
		do
		{
			str=dis.readUTF();
			System.out.println("Client Message "+str);
		}
		while(!str.equals("stop"));
	}
	public static void main(String ag[])
	{
		new server();
	}
}