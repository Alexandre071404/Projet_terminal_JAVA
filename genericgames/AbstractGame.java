package games.genericgames;
import games.players.Player;

public abstract class AbstractGame implements Game{/*une classe absract possédant une interface nommé Game*/
	protected Player Joueur1;
	protected Player Joueur2;
	protected Player JoueurC;
	
	public AbstractGame (Player Joueur1,Player Joueur2){/*on défini la structure de Abstract game avec le joueur1 et le joueur2*/
		this.Joueur1=Joueur1;
		this.Joueur2=Joueur2;
		this.JoueurC=Joueur1;
	}
	
	public abstract void doExecute(int val);/*récupère "doExecute" de ces différentes class extends(Nim et TicTacToe)*/

	public void execute(int val){/*fonction effectuant une action dans le jeux en modifiant le joueur Courant*/
		doExecute(val);/*utilise la fonction des différents classes extends*/
		if(this.JoueurC.equals(Joueur1)){
			this.JoueurC=Joueur2;
			}
		else{
			this.JoueurC=Joueur1;}}
	
	public Player getCurrentPlayer(){
		return this.JoueurC;/*renvoie le joueur Courant*/
	}
	
	
}
