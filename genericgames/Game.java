package games.genericgames;
import games.players.Player;
import java.util.ArrayList;
public interface Game{
	
	public Player getCurrentPlayer();/*Dans AbstractGame*/
	
	public ArrayList<Integer> validMoves();/*Dans Nim et TicTacToe*/
	
	public boolean isValid(int val);/*Dans Nim et TicTacToe*/
	
	public void execute(int val);/*Dans AbstractGame*/
	
	public boolean isOver();/*Dans Nim et TicTacToe*/
	
	public Player getWinner();/*Dans Nim et TicTacToe*/
	
	String moveToString(int move);/*Dans Nim et TicTacToe*/
	
	public String situationToString();/*Dans Nim et TicTacToe*/
	
	public Game copy();/*Dans Nim et TicTacToe*/
	
}
