import java.io.*;
import java.net.*;
import java.util.*;
public class client
{
	Socket s;
	DataOutputStream dout;
	public client()
	{
		try
		{
			s=new Socket("127.0.0.1",8189);
			dout=new DataOutputStream(s.getOutputStream());
			System.out.println("Enter data to send to server");
			clientchat();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void clientchat() throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str;
		do
		{
			str=br.readLine();
			dout.writeUTF(str);
			dout.flush();
		}
		while(!str.equals("stop"));
	}
	public static void main(String bc[])
	{
		new client();
	}
}