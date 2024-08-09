package games.tictactoe;
import java.util.ArrayList;
public class TicTacToe{
	/*Définition des variables de la classe*/
	private String [][] tab=new String[3][3];
	
	private String Joueur1;
	private String Joueur2;
	private String JoueurC;
	
	/*Attribution des différentes variables*/
	public TicTacToe (String Joueur1,String Joueur2){
		this.Joueur1=Joueur1;
		this.Joueur2=Joueur2;
		this.JoueurC=Joueur1;
		for(int i =0;i<3;i++){
			for(int j=0;j<3;j++){
				this.tab[i][j]=".";
			}
		}
	}
	
	/*Retourne le nom du joueur actuel*/
	public String getCurrentPlayer(){
		return this.JoueurC;
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
	public void execute(int val){
		int ligne=auxLi(val);
		int colone=auxCol(val);
		if(this.JoueurC==this.Joueur1){
			this.tab[ligne][colone]=this.Joueur1;
			this.JoueurC=this.Joueur2;
		}
		else{
			this.tab[ligne][colone]=this.Joueur2;
			this.JoueurC=this.Joueur1;
		}
		
	}
	/*Vérifie si le coup "val" est possible en vérifiant si la case est bien vide renvoie vrai si c'est le coup est possible*/
	public boolean isValid(int val){
		if (val>-1 && val<9){
			if (this.tab[auxLi(val)][auxCol(val)]=="."){
				return true;
			}
		}
		return false;
	}
	/*renvoie un array de tout les coups encore possibles*/
	public ArrayList<Integer> validMoves(){
		ArrayList<Integer> liste= new ArrayList<Integer>(); 
		for(int i=0;i<9;i++){
			if (isValid(i)){
				liste.add(i);
			}
		}
		return liste;
	}
	/*Vérifie si 3 éléments d'un joueur sont alignés et renvoie le nom du joueur s'il existe sinon renvoie null*/
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
		if(getWinner()!=null || validMoves().isEmpty()){
			return true;
		}
			return false ;
		}
	/*permet de donner à l'utilisateur les coordonées selon la valeur qu'il rentre*/
	public String moveToString(int val){
		return("("+auxLi(val)+","+auxCol(val)+")");
	}
	/*affiche le tableau à l'utilisateur*/
	public String situationToString(){
		String tableau="";
		int ligne=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if (this.tab[i][j]==this.Joueur1){
					tableau=(tableau+"|"+"X");
				}
				else if (this.tab[i][j]==this.Joueur2){
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
	
	
