package games.factoredgames; 

public class main{
	public static void main(String[]arg){
	/*exécution du jeu de Nim*/
		System.out.println("Nim");
		AbstractGame test1 = new Nim(10,2,"Jean","Pierre");
		System.out.println(test1.getCurrentPlayer());
		test1.doExecute(2);
		System.out.println(test1.getCurrentPlayer());
		System.out.println("execute");
		System.out.println(test1.getCurrentPlayer());
		test1.execute(2);
		System.out.println(test1.getCurrentPlayer());
		test1.execute(2);
		System.out.println(test1.getCurrentPlayer());
		
	/*exécution du jeu de TicTacToe*/
		
		System.out.println("TicTacToe");
		AbstractGame test2 = new TicTacToe("Jean","Pierre");
		System.out.println(test2.getCurrentPlayer());
		test2.doExecute(2);
		System.out.println(test2.getCurrentPlayer());
		System.out.println("execute");
		System.out.println(test2.getCurrentPlayer());
		test2.execute(2);
		System.out.println(test2.getCurrentPlayer());
		test2.execute(2);
		System.out.println(test2.getCurrentPlayer());
		
		

		
	}



}
