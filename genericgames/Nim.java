package games.genericgames;


import java.lang.Math;
import games.genericgames.Game;
import games.players.Player;
import java.util.ArrayList;

public class Nim extends AbstractGame implements Game{
	/*Définition des variables de la classe*/
	private int nbAllumette;
	private int nbMaxAllumette;
	private int nbCAllumette;

	/*Attribution des différentes variables */
	public Nim(int n, int nm, Player Joueur1, Player Joueur2){
		super(Joueur1,Joueur2);
		this.nbAllumette=n; 
		this.nbMaxAllumette=nm;
		this.nbCAllumette=n;
	}
	
	/*Retourne le nombre d'allumettes au début du jeu Nim */
	public int getInitialNbMatches(){
		return this.nbAllumette;
	}
	/*Retourne le nombre d'allumettes restantes dans le jeu Nim */
	public int getCurrentNbMatches(){
		return this.nbCAllumette;
	}
	

	/*Renvoie le nombre d'allumettes restantes dans le jeu de nim*/
	@Override public String situationToString(){
		return "Il reste "+this.nbCAllumette+" allumettes.";
	}
	
	
	/*Ajout de cette fonction dans le but de rappeler aux joueurs le nombre maximal d'allumettes pouvant être enlevées par coup*/
	public String nbMax(){
		return "Sachant que la valeur maximale d'allumettes pouvant être retirées est de "+this.nbMaxAllumette+".";
	}
	
	/* Cette fonction permet de soustraire le nombre souhaité par le joueur dont c'est le tour au nombre d'allumettes restantes dans le jeu nim. */
	@Override public void doExecute(int nb){
		this.nbCAllumette=this.nbCAllumette-nb;
	}
	
	/*Permet de voir quand le nombre d'allumette est nul*/
	@Override public boolean isOver(){
		if(this.nbCAllumette<=0){
			return true;
			}
		else{
			return false;}
	}
	/*Permet de savoir si le nombre d'allumettes à enlever voulu par le joueur n'est pas supérieur au nombre d'allumette restantes.
	 Vérifie également que le nombre respecte également la règle définit dans "nbMaxAllumette" */
	
	@Override public boolean isValid(int nb_al){/*nb_al correspond au nombre d'allumettes que le joueur demande à enlever*/
		if (nb_al<1){
			return false;}
		if(this.nbCAllumette>=nb_al && nb_al<=this.nbMaxAllumette){
			return true;
		}
		else{
			return false;}
		}
		
	/*Permet de donner le gagnant de la partie autrement dit le joueur qui n'a pas retiré la dernière allumette.*/
	@Override public Player getWinner(){
		if(this.isOver()){
			if(super.JoueurC.equals(super.Joueur1)){
				return super.Joueur1;}
			else{
				return super.Joueur2;}}
		else{
			return null;}
	}
	
	@Override public String moveToString(int move){/*renvoie la valeur move en format chaîne de charactères*/ 
		return ""+move;
	}
	
	@Override public ArrayList<Integer> validMoves(){/*retourne la liste de tous les coup possibles*/
		ArrayList<Integer> liste= new ArrayList<Integer>(); 
		int min=Math.min(this.getCurrentNbMatches(),this.nbMaxAllumette);/*choisi la plus petite valeur parmis le nombre max d'allumetes à retirer et le nombre actuel d'allumettes*/
		for(int i=1;i<=min ;i++){
			liste.add(i);/*ajoute le coup à la liste*/
		}
		return liste;/*retourne la liste des coups*/
	}
	
	@Override public Game copy(){/*retourne une copie du jeux dans le même état que le jeux actuel*/
		Nim jeuxNim=new Nim(this.nbAllumette,this.nbMaxAllumette,this.Joueur1,this.Joueur2);/*récréé une nouvelle instance vierge du jeux avec les mêmes conditions initiales que la partie actuelle*/
		jeuxNim.nbCAllumette=this.nbCAllumette;/*change le nombre d'allumettes restantes*/
		jeuxNim.JoueurC=super.JoueurC;/*modifier le joueur courant*/
		return jeuxNim;
	}
}
