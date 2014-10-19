
/**
 * Piece class that is used in the driver and other stuff.
 * 
 * @author Casseia
 * @author Colby!
 *
 */

public class Piece 
{
	/**
	 * Height:
	 * 1 - tall (t), 2 - short (s)
	 * Shape:
	 * 1 - square (*), 2 - round (o)
	 * Surface:
	 * 1 - smooth (-), 2 - hollowed (+)
	 * Color:
	 * 1 - brown (b), 2 - yellow (y)
	 */
	
	private int height;
	private int shape;
	private int surface;
	private int color;
	private String name;

	/*
	 * Constructor with no parameters, makes a piece with -1 properties
	 */
	public Piece()
	{
		this.height = -1;
		this.shape = -1;
		this.surface = -1;
		this.color = -1;
		this.name = "    ";
	}
	
	/*
	 * Constructor with 4 parameters, makes a piece that can be used.
	 */
	public Piece(int height, int shape, int surface, int color, String name)
	{
		this.height = height;
		this.shape = shape;
		this.surface = surface;
		this.color = color;
		this.name = name;
	}
	
	public void setName()
	{
		String tempName = "";
		if (this.height == 1) tempName += "t";
		if (this.height == 2) tempName += "s";
		if (this.shape == 1) tempName += "*";
		if (this.shape == 2) tempName += "o";
		if (this.surface == 1) tempName += "-";
		if (this.surface == 2) tempName += "+";
		if (this.color == 1) tempName += "b";
		if (this.color == 2) tempName += "y";
		
		this.name = tempName;
		
	}
	
	public boolean isEmpty()
	{
		if (this.height == -1 || this.shape == -1 || 
				this.surface == -1 || this.color == -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public String toString()
	{
		String Height;
		String Shape;
		String Surface;
		String Color;
		
		
		/// Checks to see if the piece is a 'null' piece, if so we state as much
		if ( 
				(  (this.height != 1) && (this.height != 2)  ) ||
				(  (this.shape != 1) && (this.shape != 2)  ) ||
				(  (this.surface != 1) && (this.surface != 2)  ) ||
				(  (this.color != 1) && (this.color != 2)  ) ||
				(  (this.name.equals("   "))  )
			)
		{
			return "This piece does not exist";
		}
		
		/// Because we've checked against the null piece, all fields will either
		/// be 1 or 2, hence the use of else and not else if
		
		if (this.height == 1)
		{
			Height = "tall";
		}
		else 
		{
			Height = "short";
		}
		
		
		if (this.shape == 1)
		{
			Shape = "square";
		}
		else 
		{
			Shape = "round";
		}
		
		
		if (this.surface == 1)
		{
			Surface = "smooth";
		}
		else 
		{
			Surface = "hollowed";
		}
		
		
		if (this.color == 1)
		{
			Color = "brown";
		}
		else 
		{
			Color = "yellow";
		}
			
		return ("This peice is called " + name + " and is " + Height + ", " + Shape + 
				", " + Surface + " and " + Color);
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public int getShape()
	{
		return this.shape;
	}
	
	public int getSurface()
	{
		return this.surface;
	}
	
	public int getColor()
	{
		return this.color;
	}
	
	public String getName()
	{
		return this.name;
	}
}
