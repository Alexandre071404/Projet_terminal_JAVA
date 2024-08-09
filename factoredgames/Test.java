package games.factoredgames;
import gamestests.factoredgames.AbstractGameTests;


public class Test{
	public static void main(String[] arg){	
		boolean ok = true;
		AbstractGameTests abstractGameTester = new AbstractGameTests();
		ok = ok && abstractGameTester.testGetCurrentPlayer();
		ok = ok && abstractGameTester.testExecute();
		System.out.println(ok ? "All␣tests␣OK" : "At␣least␣one␣test␣KO");}
	}
