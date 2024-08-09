package games.players;
import games.genericgames.*;
import games.plays.*;

public class NegamaxPlayer implements Player{
	public NegamaxPlayer(){/*On définit un constructeur vide pour la class NegamaxPlayer*/
	}
	
	public int evaluate(Game game){
		int res;
		Player j=game.getCurrentPlayer();
		if(game.getWinner()==j){
			return 1;/*Si le joueur Courant gagne on renvoie 1*/
		}
		else if(game.getWinner()!=null){
			return -1;/*Si le joueur Courant perd on renvoie -1*/
		} 
		else if(game.isOver()){
			return 0;/*Si c'est une égalitée alors on renvoie 0*/
		}
		else{
			res=-2;/*res=-2 car res ne peut pas être null pour pouvoir être comparé à une valeur int on utilise -2 car il est inférieur à -1,0 et 1*/
			for(int coup=0;coup<game.validMoves().size();coup++){/*on crée un compteur coup allant de 0 au nombre de coups possibles généré par "validMoves"*/
				Game gameTemp=game.copy();/*on crée une copie temporaires du jeux pour éviter de modifier le jeux principal*/
				gameTemp.execute(game.validMoves().get(coup));/*on éxecute le coup prévu parmis les coups possibles de validMoves*/
				int v=-evaluate(gameTemp);/*on teste le jeux après le coup exécuté*/
				if(v>res){
					res=v;/*on prend le meilleure cas possible pour le NegamaxPlayer*/
				}
			}
			return res;/*on renvoie res*/
		}
	}
	public int chooseMove(Game game){
		int meilleureValeur=-1;/*on défini la meilleure valeur a -1 qui est une valeur imposible et inférieure dans le jeux de Nim et de TicTacToe*/
		int meilleurCoup=-1;/*on défini le meilleur coup a -1 qui est une valeur imposible et inférieure dans le jeux de Nim et de TicTacToe*/
		for(int coup=0;coup<game.validMoves().size();coup++){
			Game gameTemp=game.copy();/*on créé une copie temporaire du jeux pour éviter de modifier le jeux principal*/
			gameTemp.execute(game.validMoves().get(coup));/*on éxecutes le coup prévu parmis les coups possibles de "validMoves"*/
			int v=-evaluate(gameTemp);/*on teste le jeux aprés le coup exécuté*/
			if(meilleurCoup==-1 || v>meilleureValeur){
				meilleureValeur=v;/*La meilleure valeur devient v*/
				meilleurCoup=game.validMoves().get(coup);/*Le meilleur coup devient le coup parmis la liste des coups possibles de "validMoves"*/
			}
		}
		return meilleurCoup;/*on renvoie meilleurCoup*/
	}
}
