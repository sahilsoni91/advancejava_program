import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class two extends Frame implements Runnable, ActionListener
{
	Thread t;
	Button b;
	public two()
	{
		b=new Button("Start");
		b.addActionListener(this);
		setLayout(new FlowLayout());
		add(b);
		setFont(new Font("Comic sans ms",Font.BOLD,20));
		setSize(600,600);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		t=new Thread(this);
		t.start();
	}
	public void paint(Graphics g)
	{
		Random x=new Random();
		int v=x.nextInt(500);
		System.out.println("v="+v);
		g.drawString("HELLO",v,v);
	}
	public void run()
	{
		while(true)
		{
			repaint();
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException e)
			{
			}
		}
	}
	public static void main(String ag[])
	{
		new two();
	}
}