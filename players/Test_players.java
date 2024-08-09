package games.players;
import gamestests.players.HumanTests;
import gamestests.players.RandomPlayerTests;

public class Test_players{
	public static void main(String[] arg){
		boolean ok = true;
		HumanTests humanTester = new HumanTests();
		ok = ok && humanTester.testChooseMove(false);
		RandomPlayerTests randomTester = new RandomPlayerTests();
		ok = ok && randomTester.testChooseMove();
		System.out.println(ok ? "All␣tests␣OK" : "At␣least␣one␣test␣KO");}}
