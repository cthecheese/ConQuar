public class Debugging 
{
	public Debugging()
	{
		
	}
	
	public void print(String... strings)
	{
		for (String i : strings)
		{
			System.out.println(i);
		}
		
		System.out.println("\n");
	}
	
	public void print(int... ints)
	{
		for (int i : ints)
		{
			System.out.print(i);
		}
		
		System.out.println("\n");
	}
	
	public void print(String string, int... ints)
	{
		System.out.println(string + "\n");
		
		for(int i : ints)
		{
			System.out.println(i);
		}
		
		System.out.println("\n");
	}
	
	/*
	public void printWins(int h, int s, int f, int c)
	{
		this.print(String.format(
				"H: %d \n S: %d \n F: %d \n C: %d \n",
				h,s,f,c));
	}
	*/
}
