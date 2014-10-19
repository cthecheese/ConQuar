/*
 * 
 * I love you! <3
 * 
 */

import java.util.Scanner;


public class SimpleDriver 
{

	public static PieceList unUsedList = new PieceList();
	public static PieceList usedList = new PieceList();
	public static Board myBoard = new Board();
	public static Piece currentPiece = new Piece();
	public static Player playerOne = new Player();
	public static Player playerTwo = new Player();
	public static Player currentPlayer = new Player();
	public static Debugging bugger = new Debugging();
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		setUpGame();
		
		System.out.println("Welcome to Quorto! \n"
				+ "Chose amungst yourselves who will go first.\n"
				+ "Here is the current board.");
		
		System.out.println(myBoard.print());
		
		System.out.println("To play a piece type in the name of the piece you\n"
				+ "wish for your opponent to play, and wait for the prompt.\n"
				+ "Then your opponent will enter in the coordinates they would\n"
				+ "like for their piece to be.\n\n"
				+ "Here are the list of pieces you can choose from, please \n"
				+ "type the number of the piece you would like to give to your\n"
				+ "opponent.\n"
				+ unUsedList.printList());
		
		System.out.println(currentPlayer.getName() + ", please choose piece: ");
		
		while( in.hasNextLine() )
		{		
			String command = in.next().trim().toLowerCase();
			
			//Player wants to quit
			
			if (command.equals("quit"))
			{
				// TODO: Ask if we want to save (for later);
				System.out.println("Thank you for playing! \nBye bye!");
				break;
			}
			//Player's command is a piece
			else if (currentPlayer.getPhase() == 2)
			{
				if	(Integer.parseInt(command) <= 16 &&
					 Integer.parseInt(command) > 0
					 )
				currentPiece = unUsedList.at(Integer.parseInt(command)-1);
				usedList.add(currentPiece);
				String namePiece = currentPiece.getName();
				unUsedList.removePieceByName(namePiece);
				nextPlayer();
				
				System.out.println(currentPlayer.getName() + ",please place piece " 
						+ currentPiece.getName() + ":");
			}
			//Player's command is a coordinate
			else if(currentPlayer.getPhase() == 1)
			{
				if(		(command.equals("1,1")) ||
						(command.equals("1,2")) ||
						(command.equals("1,3")) ||
						(command.equals("1,4")) ||
						(command.equals("2,1")) ||
						(command.equals("2,2")) ||
						(command.equals("2,3")) ||
						(command.equals("2,4")) ||
						(command.equals("3,1")) ||
						(command.equals("3,2")) ||
						(command.equals("3,3")) ||
						(command.equals("3,4")) ||
						(command.equals("4,1")) ||
						(command.equals("4,2")) ||
						(command.equals("4,3")) ||
						(command.equals("4,4")))
				{
					int xCord = Integer.parseInt(Character.toString(command.charAt(0)));
					int yCord = Integer.parseInt(Character.toString(command.charAt(2)));
					//Put piece on the board
					if(myBoard.placePiece(currentPiece, xCord-1, yCord-1) == true)
					{
						//Piece is already in correct list, so that's taken care of
						System.out.println(myBoard.print());
						if (didWin(myBoard, xCord - 1, yCord - 1))
						{
							System.out.println("YOU WIN! Congrats!");
							break;
						}
						//by placing on the board, the player didn't win
						else
						{
							currentPlayer.setPhase(2);
							System.out.print("Here are the list of pieces to choose \n"
									+ "from to give to your opponent.  \n" 
									+ unUsedList.printList());
							System.out.println(currentPlayer.getName() + ", please choose a piece: ");
						}
					}
					else
					{
						System.out.println(currentPlayer.getName() + ",please place piece " 
								+ currentPiece.getName() + ":");
					}
				}
			}
			
			
			
		} // close while loop
		
		
		
		in.close();
	}
	
	public static void setUpGame()
	{
		playerOne.setName("Player Alice");
		playerOne.setPhase(2);
		playerTwo.setName("Player Hunter");
		currentPlayer = playerOne;
		
		
		for(int a = 0; a < 2; a++)
		{
			for(int b = 0; b < 2; b++)
			{
				for(int c = 0; c < 2; c++)
				{
					for(int d = 0; d < 2; d++)
					{
						unUsedList.add(new Piece(a+1, b+1, c+1, d+1, ""));
					}
				}
			}
		}
		
		for (int i = 0; i < unUsedList.size(); i++)
		{
			unUsedList.at(i).setName();
		}
		
	}
	
	public static boolean didWin(Board myBoard, int x, int y)
	{
		// Check down diagonal
		if(x == y)
		{
			if(checkDownDiagWin(myBoard)) return true;
		}
		
		// Check up diagonal
		if (x+y == 3)
		{
			if (checkUpDiagWin(myBoard)) return true;
		}
		
		
		// Check x row 		
		
		if (checkXWin(myBoard, x)) return true;;
		
		// Check y column
		
		if (checkYWin(myBoard, y)) return true;
		
		// Check box win
		
		if (checkBoxWin(myBoard, x, y)) return true;
		
		
		
		return false;
	}

	private static void nextPlayer()
	{
		if(currentPlayer.getName() == playerOne.getName())
		{
			currentPlayer = playerTwo;
			currentPlayer.setPhase(1);
		}
		else if (currentPlayer.getName() == playerTwo.getName())
		{
			currentPlayer = playerOne;
			currentPlayer.setPhase(1);
		}
	}
	
	private static boolean checkBoxWin(Board myBoard, int xSpot, int ySpot)
	{
		int minX = 0;
		int maxX = 0;
		int minY = 0;
		int maxY = 0;
		
		
		if (xSpot == 0)
		{
			minX = 0;
			maxX = 1;
		}
		if (xSpot == 3)
		{
			minX = 2;
			maxX = 3;
		}
		if (xSpot < 3 && xSpot > 0)
		{
			minX = xSpot - 1;
			maxX = xSpot + 1;
		}
		if (ySpot == 0)
		{
			minY = 0;
			maxY = 1;
		}
		if (ySpot == 3)
		{
			minY = 2;
			maxY = 3;
		}
		if (ySpot < 3 && ySpot > 0)
		{
			minY = ySpot - 1;
			maxY = ySpot + 1;
		}
		
		
		int h = 0; 
		int s = 0; 
		int f = 0; 
		int c = 0;
		int count = 0;
		
		for (int xx = minX; xx <= maxX; xx++)
		{
			for (int yy = minY; yy <= maxY; yy++)
			{
				if (!myBoard.at(xx, yy).isEmpty())
				{
					count++;
					h += myBoard.at(xx, yy).getHeight();
					s += myBoard.at(xx, yy).getShape();
					f += myBoard.at(xx, yy).getSurface();
					c += myBoard.at(xx, yy).getColor();	
				}
			}
		}
		
		
		if(calculate(h,s,f,c, count))
			return true;
		return false;
	}
	
	private static boolean checkUpDiagWin(Board myBoard)
	{
		int x = 0;
		int y = 0;
		
		int h = 0;
		int s = 0;
		int f = 0;
		int c = 0;
		int count = 0;
		
		for(int i = 0; i < 4; i++)
		{
			if(!myBoard.at(x, y).isEmpty())
			{
				x = i;
				y = myBoard.getHeight()-1-i;
			
				count++;
				h += myBoard.at(x, y).getHeight();
				s += myBoard.at(x, y).getShape();
				f += myBoard.at(x, y).getSurface();
				c += myBoard.at(x, y).getColor();
				
			}
			else
			{
				return false;
			}
		}
		
		
		// bugger.print("UpDiagWin", h,s,f,c);
		
		if(calculate(h,s,f,c, count))
			return true;
		return false;
	}
	
	private static boolean checkDownDiagWin(Board myBoard2) 
	{
		int h = 0;
		int s = 0;
		int f = 0;
		int c = 0;
		int count = 0;
		
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				if (i == j && !myBoard.at(i, j).isEmpty())
				{
					count++;
					h += myBoard.at(i, j).getHeight();
					s += myBoard.at(i, j).getShape();
					f += myBoard.at(i, j).getSurface();
					c += myBoard.at(i, j).getColor();
				}
				else if (i == j && myBoard.at(i,  j).isEmpty())
				{
					return false;
				}
			}
		}
		
		// bugger.print("DownDiagWin", h,s,f,c);
		
		if(calculate(h,s,f,c, count))
			return true;
		return false;
		
	}

	private static boolean checkYWin(Board myBoard, int y) 
	{
		int h = 0;
		int s = 0;
		int f = 0;
		int c = 0;
		int count = 0;
		for (int xx = 0; xx < 4; xx++)
		{
			if(!myBoard.at(xx, y).isEmpty())
			{
				count++;
				h += myBoard.at(xx, y).getHeight();
				s += myBoard.at(xx, y).getShape();
				f += myBoard.at(xx, y).getSurface();
				c += myBoard.at(xx, y).getColor();
			}
			else
			{
				return false;
			}
		}
		
		// bugger.print("YWin", h,s,f,c);
		
		if(calculate(h,s,f,c, count))
			return true;
		return false;
	}
	
	private static boolean checkXWin(Board myBoard, int x) 
	{
		int h = 0;
		int s = 0;
		int f = 0;
		int c = 0;
		int count = 0;
		
		for (int yy = 0; yy < 4; yy++)
		{
			if(!myBoard.at(x, yy).isEmpty())
			{
				count++;
				h += myBoard.at(x, yy).getHeight();
				s += myBoard.at(x, yy).getShape();
				f += myBoard.at(x, yy).getSurface();
				c += myBoard.at(x, yy).getColor();
			}
			else
			{
				return false;
			}
		}
		
		// bugger.print("XWin", h,s,f,c);
		
		if(calculate(h,s,f,c, count))
			return true;
		return false;
	}
	
	private static boolean calculate(int h, int s, int f, int c, int count)
	{
		if ((h%4 == 0 || s%4 == 0 || f%4 == 0 || c%4 == 0) && count == 4)
		{
			//bugger.printWins(h, s, f, c);
			return true;
		}
		
		return false;
	}
}
