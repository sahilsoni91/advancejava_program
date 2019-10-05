import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
//how touse sockets to send plain text mail messages
public class mail
{
	public static void main(String ag[])
	{
		JFrame frame=new mailFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}
}
//frame for mail GUI
class mailFrame extends JFrame
{
	public mailFrame()
	{
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setTitle("Mail Test");
		setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
		//we use the GBC convenience class
		add(new JLabel("From:"));
		from=new JTextField(20);
		add(from);
		add(new JLabel("To:"));
		to=new JTextField(20);
		add(to);
		add(new JLabel("SMTP Server:"));
		smtpServer=new JTextField(20);
		add(smtpServer);
		message=new JTextArea(10,10);
		add(new JScrollPane(message));
		comm=new JTextArea(10,10);
		add(new JScrollPane(comm));
		JPanel buttonPanel=new JPanel();
		add(buttonPanel);
		JButton sendButton=new JButton("Send");
		buttonPanel.add(sendButton);
		sendButton.addActionListener(new 
					ActionListener()
					{
						public void actionPerformed(ActionEvent event)
						{
							new Thread(new 
									Runnable()
									{
										public void run()
										{
											comm.setText("");
											sendMail();
										}
									}).start();
						}
					});
	}
	//sends the mail message that has been authored in the GUI
	public void sendMail()
	{
		try
		{
			Socket s=new Socket(smtpServer.getText(),25);
			InputStream inStream=s.getInputStream();
			OutputStream outStream=s.getOutputStream();
			in=new Scanner(inStream);
			out=new PrintWriter(outStream,true);
			String hostName=InetAddress.getLocalHost().getHostName();
			receive();
			send("HELLO"+hostName);
			receive();
			send("MAIL FROM:<"+from.getText()+">");
			receive();
			send("RCPT TO:<"+to.getText()+">");
			receive();
			send("DATA");
			receive();
			send(message.getText());
			send(".");
			receive();
			s.close();			
		}
		catch(IOException e)
		{
			comm.append("Error:"+e);
		}
	}
	//sends a string to the socket and echoes it in the comm text area
	public void send(String s) throws IOException
	{
		comm.append(s);
		comm.append("\n");
		out.print(s.replaceAll("\n","\r\n"));
		out.print("\r\n");
		out.flush();
	}
	//recieves a string from the socket and displays it in the comm text area
	public void receive() throws IOException
	{
		if(in.hasNextLine())
		{
			String line=in.nextLine();
			comm.append(line);
			comm.append("\n");
		}
	}
	private Scanner in;
	private PrintWriter out;
	private JTextField from;
	private JTextField to;
	private JTextField smtpServer;
	private JTextArea message;
	private JTextArea comm;
	public static final int DEFAULT_WIDTH=300;
	public static final int DEFAULT_HEIGHT=300;
}