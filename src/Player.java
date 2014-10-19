/*
 * Player Class
 * 
 * @author Colby
 * @author Casseia
 * 
 * 
 * Notes:
 * - Each "Move" consists of 2 "Phases"
 * 		+ Phase 1 is placing a piece
 * 		+ Phase 2 is selecting a piece for opponent
 * 
 */

public class Player 
{
	private String _name = "Wonderland";
	private int _phase = 0;
	
	String getName()
	{
		return _name;
	}
	void setName(String name)
	{
		_name = name;
	}
	
	int getPhase()
	{
		return _phase;
	}
	void setPhase(int phase)
	{
		_phase = phase;
	}
	
	public Player()
	{
		
	}	
}
