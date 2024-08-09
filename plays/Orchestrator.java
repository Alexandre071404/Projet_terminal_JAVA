package games.plays;
import games.genericgames.*;

import games.players.*;
public class Orchestrator{
	/*Déclaration de la variable prenant en paramètre un jeu*/
	private Game game;
	public Orchestrator(Game game){
	/*Attribution de la variable précédemment déclarée */
		this.game=game;
	}
	public void play(){
		while(this.game.isOver()!=true){
		/* renvoie aux joueurs la situation du jeu et réexécute ce dernier en prenant la fonction "chooseMove" du joueur courant en argument permettant la suite du jeu*/
			System.out.println(this.game.situationToString());
			this.game.execute(this.game.getCurrentPlayer().chooseMove(this.game));
		}
		/*Une fois la partie finie l'Orchestrator renvoie aux joueurs le gagnant du jeu lancé*/
		System.out.println(this.game.getWinner()+" remporte la partie");
	}

	
	

	
	}
