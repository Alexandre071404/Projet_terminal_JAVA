package games.factoredgames;
import gamestests.factoredgames.NimTests;
import gamestests.factoredgames.TicTacToeTests;


public class Test1{
	public static void main(String[] arg){
		boolean ok = true;
		NimTests nimTester = new NimTests();
		ok = ok && nimTester.testExtends();
		ok = ok && nimTester.testGetCurrentPlayer();
		ok = ok && nimTester.testExecute();
		ok = ok && nimTester.testIsValid();
		ok = ok && nimTester.testIsOver();
		ok = ok && nimTester.testGetWinner();
		TicTacToeTests ticTacToeTester = new TicTacToeTests();
		ok = ok && ticTacToeTester.testExtends();
		ok = ok && ticTacToeTester.testGetCurrentPlayer();
		ok = ok && ticTacToeTester.testExecuteAndIsValid();
		ok = ok && ticTacToeTester.testValidMoves();
		/*ok = ok && ticTacToeTester.testWins();*//*fonction GetWinner fait sans sous fonction wins*/
		ok = ok && ticTacToeTester.testGetWinner();
		ok = ok && ticTacToeTester.testIsOver();
		System.out.println(ok ? "All␣tests␣OK" : "At␣least␣one␣test␣KO");}
	}
