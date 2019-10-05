interface Suzuki
{
	public abstract void body();
}

interface Ford
{
	public abstract void engine();
}

public class motor implements Suzuki, Ford
{
	public void body()
	{
		System.out.println("Fit Suzuki body");
	}
	public void engine()
	{
		System.out.println("Fit Ford engine");
	}
	public static void main(String args[])
	{
		motor mc1 = new motor();
		mc1.body();
		mc1.engine();
	}
}