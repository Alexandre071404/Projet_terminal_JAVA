package games.tictactoe;
import java.util.Scanner ;
public class main{
	public static void main(String[]arg){
		/*Initialisation du jeu définie par le joueur*/
		Scanner scanner = new Scanner ( System.in );
		System.out.println("Nom du joueur 1 ?");
		String j1 = scanner.next ();/*Les variables qui succèdent aux println sont celles qui gardent en mémoire les différentes valeurs saisies par les joueurs qui permettront la création du jeu Nim. */
		System.out.println("Nom du joueur 2 ?");
		String j2 = scanner.next ();
		System.out.println("\n\n");
		/*création du jeu nim avec les données récupérées dans les variables précédemment présentées. */
		TicTacToe tic = new TicTacToe(j1,j2);
		/*boucle verifiant si le jeux est terminé avec isOver*/
		while (tic.isOver()){
			System.out.println(tic.getCurrentPlayer()+"\n");
			System.out.println(tic.situationToString());
			for(int i=0;i<9;i++){
				System.out.println(i+1 +" = "+tic.moveToString(i));/* on utilise ici i+1 pour permettre a l'utilisateur d'avoir seulement besoin des touches de 1 à 9*/
			}
			System.out.println("Choisissez le numéro de l'emplacement que vous souhaitez sélectionner : ");
			String texte = scanner.next ();
			int chiffre = Integer.parseInt(texte)-1;
			System.out.println("\n\n");
			/*Vérification permettant de savoir si la valeur saisie est correcte*/
			if(tic.isValid(chiffre)){
				tic.execute(chiffre);
			}
			else{
				System.out.println("Valeur invalide");
			}
		}
		/*Le jeu est terminé nous donnons donc le vainqueur.*/
		System.out.println(tic.situationToString());
		System.out.println("Victoire : " + tic.getWinner());
}
}
