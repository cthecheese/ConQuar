/*
 * 
 * @author Casseia
 * 
 */
public class PieceList 
{
	private Piece[] listOPieces;
	
	public PieceList()
	{
		listOPieces = new Piece[16];
	}
	
	public String printList()
	{
		String bigString = "";
		int count = 0;
		for (int i = 0; i < listOPieces.length; i++)
		{
			bigString += i+1;
			bigString += ": ";
			bigString += listOPieces[i].getName();
			if (count%4 == 3) bigString += "\n";
			else bigString += "             	";
			count++;
		}
		bigString += "\n";
		return bigString;
	}
	
	public Piece at(int i)
	{
		return listOPieces[i];
	}
	
	public int size()
	{
		return listOPieces.length;
	}
	
	public void add(Piece addMe)
	{
		for(int i = 0; i < listOPieces.length; i++)
		{
			if (listOPieces[i] == null)
			{
				listOPieces[i] = addMe;
				return;
			}
		}
		//if none of them are null...therefore it's full
		return;
	}
	
	public Piece findPieceByName(String name)
	{
		for (int i = 0; i < 16; i++)
		{
			if (listOPieces[i].getName().equals(name))
			{
				return listOPieces[i];
			}
		}
		return null;
	}

	public void removePieceByName(String namePiece) 
	{
		Piece newList[] = new Piece[listOPieces.length-1];
		int indexOfPieceToRemove = -1;
		
		for (int i = 0; i < listOPieces.length; i++)
		{
			if (listOPieces[i].getName().equals(namePiece))
			{
				indexOfPieceToRemove = i;
			}
		}
		
		for (int i = 0; i < indexOfPieceToRemove; i++)
		{
			newList[i] = listOPieces[i];
		}
		for (int i = indexOfPieceToRemove; i < listOPieces.length -1;i++)
		{
			newList[i] = listOPieces[i+1];
		}
		
		this.listOPieces = newList;
	}
}
