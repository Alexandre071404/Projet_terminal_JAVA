package games.factoredgames;

public abstract class AbstractGame{
	/*Déclaration des diverses variable qui seront utilisées */
	protected String Joueur1;
	protected String Joueur2;
	protected String JoueurC;
	
	public AbstractGame (String Joueur1,String Joueur2){
	/*Attribution des diverses variables précédemment déclarées*/
		this.Joueur1=Joueur1;
		this.Joueur2=Joueur2;
		this.JoueurC=Joueur1;
	}
	
	public abstract void doExecute(int val);
	/*Exécution des diverses classes possédant la méthode "doExecute" */
	public void execute(int val){
		doExecute(val);
		/*Changement de joueur courant après chaque coup*/
		if(this.JoueurC.equals(Joueur1)){
			this.JoueurC=Joueur2;
			}
		else{
			this.JoueurC=Joueur1;}}
	
	public String getCurrentPlayer(){
		return this.JoueurC;
	}
	
	
}
