package games.players;
import games.genericgames.Game;
import java.util.ArrayList;
public class RandomPlayer implements Player{
	private java.util.Random rand;
	
	public RandomPlayer(java.util.Random rand){/*la structure Random player est composée d'un random rand */
		this.rand=rand;
	}
	public int chooseMove(Game game){
		ArrayList<Integer> liste = game.validMoves();/*créé une variable de type Arraylist qui est égale à "validMoves"*/
		int coup=liste.get(rand.nextInt(liste.size()));/*permet de garder en mémoire la case jouée par l'ordinateur*/
		System.out.println("L'ordinateur joue la valeur "+coup);/*Affiche à l'utilisateur le coup joué par l'ordinateur*/
		return(coup);/*renvoie les coups joués*/
	
	}
	
	public String toString(){
		return "Joueur aléatoire n° " + this.hashCode();/*renvoie le nom du joueur*/
	}

}
