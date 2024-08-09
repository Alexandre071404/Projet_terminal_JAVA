package games.factoredgames;
import java.util.ArrayList;
public class TicTacToe extends AbstractGame{
	/*Définition des variables de la classe*/
	private String [][] tab=new String[3][3];
	/*Attribution des différentes variables*/
	public TicTacToe (String Joueur1,String Joueur2){
		super(Joueur1,Joueur2);
		for(int i =0;i<3;i++){
			for(int j=0;j<3;j++){
				this.tab[i][j]=".";
			}
		}
	}
	/*Auxiliaire qui renvoie la ligne correspondante a la valeur donnée*/
	public int auxLi(int val){
		return val/3;
	}
	/*Auxiliaire qui renvoie la colonne correspondante a la valeur donnée*/
	public int auxCol(int val){
		return val%3;
	}
	/*Place le nom du joueur courant a l'emplacement "val" avec l'aide des fonctions auxiliaires auxLi et auxCol*/
	@Override public void doExecute(int val){
		int ligne=auxLi(val);
		int colone=auxCol(val);
		if(super.JoueurC==super.Joueur1){
			this.tab[ligne][colone]=super.Joueur1;
		}
		else{
			this.tab[ligne][colone]=super.Joueur2;
		}
		
	}
	/*Vérifie si le coup "val" est possible en vérifiant si la case est bien vide renvoie vrai si le coup est possible*/
	public boolean isValid(int val){
		if (val>-1 && val<9){
			if (this.tab[auxLi(val)][auxCol(val)]=="."){
				return true;
			}
		}
		return false;
	}
	/*renvoie un array de tous les coups encore possibles*/
	public ArrayList<Integer> validMoves(){
		ArrayList<Integer> liste= new ArrayList<Integer>(); 
		for(int i=0;i<9;i++){
			if (isValid(i)){
				liste.add(i);
			}
		}
		return liste;
	}
	/*Vérifie si 3 éléments d'un joueur sont alignés et renvoie le nom du joueur s'il existe sinon renvoi null*/
	public String getWinner(){
		for(int i=0;i<3;i++){
			if(this.tab[i][i]!="."){
				if(i==0){
					if(this.tab[i][i]==this.tab[i][i+1] && this.tab[i][i]==this.tab[i][i+2]){
						return this.tab[i][i];
					}
					if(this.tab[i][i]==this.tab[i+1][i] && this.tab[i][i]==this.tab[i+2][i]){
						return this.tab[i][i];
					}
					if(this.tab[i][i]==this.tab[i+1][i+1] && this.tab[i][i]==this.tab[i+2][i+2]){
						return this.tab[i][i];
					}
				}
				if(i==1){
					if(this.tab[i][i]==this.tab[i][i-1] && this.tab[i][i]==this.tab[i][i+1]){
						return this.tab[i][i];
					}
					if(this.tab[i][i]==this.tab[i-1][i] && this.tab[i][i]==this.tab[i+1][i]){
						return this.tab[i][i];
					}
					if(this.tab[i][i]==this.tab[i+1][i-1] && this.tab[i][i]==this.tab[i-1][i+1]){
						return this.tab[i][i];
					}
				}
				if(i==2){
					if(this.tab[i][i]==this.tab[i-1][i] && this.tab[i][i]==this.tab[i-2][i]){
						return this.tab[i][i];
					}
					if(this.tab[i][i]==this.tab[i][i-1] && this.tab[i][i]==this.tab[i][i-2]){
						return this.tab[i][i];
					}
				}
		}}
		return null;
	}
	
	/*revoie vrai s'il y a un gagnant ou s'il n'y a plus de coup possible*/
	public boolean isOver(){
		boolean res=true;
		if(getWinner()!=null){
			return true;
		}
		else{
			
			for(int i=0;i<9;i++){
				if(isValid(i)){
					return(!isValid(i));
				} 
			}
			return true ;
		}
	}
	/*permet de donner à l'utilisateur les coordonées selon la valeur qu'il rentre*/
	public String moveToString(int move){
		return("("+auxLi(move)+","+auxCol(move)+")");
	}
	/*affiche le tableau à l'utilisateur*/
	public String situationToString(){
		String tableau="";
		int ligne=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if (this.tab[i][j]==super.Joueur1){
					tableau=(tableau+"|"+"X");
				}
				else if (this.tab[i][j]==super.Joueur2){
					tableau=(tableau+"|"+"0");
				}
				else{
					tableau=(tableau+"|"+this.tab[i][j]);
				}
				
			}
			tableau=tableau+"|\n";
			}
			
		return(tableau);}
}
	
	
