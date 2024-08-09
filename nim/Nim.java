package games.nim; 
public class Nim{
	/*Définition des variables de la classe*/
	private int nbAllumette;
	private int nbMaxAllumette;
	private String J1;
	private String J2;
	private int nbCAllumette;
	private String joueurC;
	
	
	/*Attribution des différentes variables */
	public Nim(int n, int nm, String J1, String J2){
		this.nbAllumette=n; 
		this.nbMaxAllumette=nm;
		this.J1=J1;
		this.J2=J2;
		this.nbCAllumette=n;
		this.joueurC=J1;
	}
	
	/*Retourne le nombre d'allumettes au début du jeu Nim */
	public int getInitialNbMatches(){
		return this.nbAllumette;
	}
	/*Retourne le nombre d'allumettes restante dans le jeu Nim */
	public int getCurrentNbMatches(){
		return this.nbCAllumette;
	}
	
	/*Renvoie le joueur dont c'est le tour de jouer*/
	public String getCurrentPlayer(){
		return this.joueurC;
	}

	/*Renvoie le nombre d'allumettes restantes dans le jeu de nim*/
	public String situationToString(){
		return "Il reste "+this.nbCAllumette+" allumettes.";
	}
	
	
	/*Ajout de cette fonction dans le but de rappeler aux joueurs le nombre maximal d'allumettes pouvant être enlevées par coup*/
	public String nbMax(){
		return "Sachant que la valeur maximale d'allumettes pouvant être retirées est de "+this.nbMaxAllumette+".";
	}
	
	
	
	/* Cette fonction permet de soustraire le nombre souhaité par le joueur dont c'est le tour au nombre d'allumettes restantes dans le jeu nim. */
	public void removeMatches(int nb){
		this.nbCAllumette=this.nbCAllumette-nb;
		if(this.joueurC.equals(this.J1)){
			joueurC=this.J2;
			}
		else{
			joueurC=this.J1;}
	}
	
	/*Permet de voir quand le nombre d'allumette est nul*/
	public boolean isOver(){
		if(this.nbCAllumette<=0){
			return true;
			}
		else{
			return false;}
	}
	
	
	
	/*Permet de savoir si le nombre d'allumettes à enlever voulu par le joueur n'est pas supérieur au nombre d'allumette restante*/
	/* Vérifie également que le nombre respecte également la règle définit dans "nbMaxAllumette" */
	
	public boolean isValid(int nb_al){/*nb_al correspond au nombre d'allumettes que le joueur demande à enlever*/
		if (nb_al<1){
			return false;}
		if(this.nbCAllumette>=nb_al && nb_al<=this.nbMaxAllumette){
			return true;
		}
		else{
			return false;}
		}
		
	/*Permet de donner le gagnant de la partie autrement le joueur qui n'a pas retiré les dernières allumettes.*/
	public String getWinner(){
		if(this.isOver()){
			if(this.joueurC.equals(this.J1)){
				return J1;}
			else{
				return J2;}}
		else{
			return null;}
	}}
