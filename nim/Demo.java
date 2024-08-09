package games.nim;
import java.util.Scanner;
import games.nim.*;
public class Demo{
public static void main(String[] arg){
	String inputStr;
	int inputInt;
	/*Initialisation du jeu définie par le joueur*/
	Scanner scanner= new Scanner(System.in);
	System.out.println("Nom du joueur 1: ");
	String j1=scanner.next();
	/*Les variables qui succèdent aux println sont celles qui gardent en mémoire les différentes valeurs saisies par les joueurs qui permettront la création du jeu Nim. */
	System.out.println("Nom du joueur 2: ");
	String j2=scanner.next();
	System.out.println("Nombre d'allumettes : ");
	inputStr=scanner.next();
	int nballu =Integer.parseInt(inputStr);
	System.out.println("Nombre maximum d'allumettes que l'on peut retirer : ");
	inputStr=scanner.next();
	int lim =Integer.parseInt(inputStr);
	/*création du jeu nim avec les données récupérées dans les variables précédemment présentées. */
	Nim main=new Nim(nballu,lim,j1,j2);
	/*Boucle du jeu*/
	while (! main.isOver()){
		System.out.println(main.situationToString());
		System.out.println(main.getCurrentPlayer());
		System.out.println(main.nbMax());
		inputStr=scanner.next();
		inputInt =Integer.parseInt(inputStr);
		/*Vérification permettant de savoir si la valeur saisie est correcte*/
		while (! main.isValid(inputInt)){
			System.out.println("Valeur impossible !");
			System.out.println(main.situationToString());
			System.out.println(main.getCurrentPlayer());
			System.out.println(main.nbMax());
			inputStr=scanner.next();
			inputInt =Integer.parseInt(inputStr);}
		/*Si la valeur est valide alors on l'enlève à celle du jeu Nim*/	
		main.removeMatches(inputInt);
		}
		/*Le jeu est terminé nous donnons donc le vainqueur.*/
		scanner.close();
		System.out.println(main.getWinner()+" gagne la partie !");	
			
			
		}
	}

