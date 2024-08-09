package games.plays;
import java.util.Scanner;
import java.util.Random;
import games.genericgames.*;

import games.players.*;

public class Main{ 	
	/*Début du programme avec la création des diverses variables issues des classes qui seront utilisées par la suite*/
		public static void main(String[] arg){
		Random rand = new Random(123);
		Scanner scanner=new Scanner(System.in);
		Player player1 = new Human("Moi", scanner);
		Player player2 = new NegamaxPlayer();
		/*Demande à l'utilisateur quel est le jeu auquel il veut jouer*/
		System.out.println("1=Jeux de Nim ou 2=Jeux du TicTacToe");
		int choixDuJeux=Integer.parseInt(scanner.next());
		if(choixDuJeux==1){
			/*Si le joueur choisit le 1 alors le jeu de Nim se lance en demandant aux joueurs les paramètres avec lesquels ils veulent jouer*/
			System.out.println("Nombre de bâtons ?");
			int n = Integer.parseInt(scanner.next());
			System.out.println("Nombre maximal de bâtons à enlever par coup ?");
			int nm = Integer.parseInt(scanner.next());
			Nim game=new Nim(n,nm,player1 , player2);
			/* La création du jeu faite nous créons maintenant un Orchestrator*/
			Orchestrator orchestrator = new Orchestrator(game);
			orchestrator.play();
		}
		else{
			/*Sinon le jeu de TicTacToe se lance avec la création d'un Orchestrator*/
			TicTacToe game = new TicTacToe(player1, player2);
			Orchestrator orchestrator = new Orchestrator(game);
			orchestrator.play();
		}
		
		
		scanner.close();
	}
}


/*Exercice 6.6 ) L'algorithme "NegamaxPlayer" devient de plus en plus lent à répondre car on lui demande de faire de plus en plus de calculs ce qui le ralentit */
