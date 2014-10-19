/**
 * Class for a Board Object
 * 
 * @author Colby
 * @author Casseia
 *
 */



public class Board 
{
	private Piece[][] spots;
	public static Debugging bugger = new Debugging();
	
	public Board()
	{
		spots = new Piece[4][4];
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				spots[i][j] = new Piece();
			}
		}
	}
	
	/*
	 * ints are 0-3 just like in the arrays, x is the first 
	 * array and y is the second array
	 */
	public boolean placePiece(Piece placeMe, int x, int y) 
	{
		if (spots[y][x].getName() != "    ") 
		{
			System.out.println("Can not place here, spot taken!");
			return false;
		}
		else if (x > 3 || y > 3 || x < 0 || y < 0)
		{
			System.out.println("Spot not on board");
			return false;
		}
		else
		{
			spots[y][x] = placeMe;
			return true;
		}
	}
	
	public String print()
	{
		String message = "";
		message += "    1        2        3        4   \n";
		for (int i = 0; i < 4; i++)
		{
			message += (i+1);
			for (int j = 0; j < 4; j++)
			{
				message +=  "[ " + this.at(i,j).getName() + " ]";
			}
			message += "\n";
		}
		
		return message;
	}
	
	public int getHeight()
	{
		return 4;
	}
	
	public int getWidth()
	{
		return 4;
	}
	
	public Piece at(int x, int y)
	{
		return spots[x][y];
	}
	
}
