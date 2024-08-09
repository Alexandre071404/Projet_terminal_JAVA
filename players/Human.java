package games.players;
import games.genericgames.Game;

public class Human implements Player{
	private String nom;
	private java.util.Scanner scanner;
	public Human(String nom,java.util.Scanner scanner){/*On définit la structure "Human" avec l'aide d'un scanner et du nom du joueur*/
		this.nom=nom;
		this.scanner=scanner;
	}
	public int chooseMove(Game game){
		System.out.println("Voici tous les coups possibles "+game.validMoves());/*On affiche l'ensemble des coups possibles par l'utilisateur*/
		int coup=Integer.parseInt(scanner.next());/*Demande a l'utilisateur le coup qu'il souhaite exécuter*/
		while(!game.isValid(coup)){
			System.out.println("Coup invalide veuillez choisir un coup parmi "+game.validMoves());
			coup=Integer.parseInt(scanner.next());/*redemande à l'utilisateur son coup si le premier était invalide et redemande jusqu'à ce que celui-ci soit valide*/
		}
		return coup;/*renvoie le coup sélectionné*/
		}
	public String toString(){
		return this.nom;/*retourne le nom du joueur*/
	}
} 
