import java.util.ArrayList;


public class ActionRequete extends Action {
	
	public void doAction(ArrayList<Mot> mots) {
		System.out.println("\nAction requete");
		
		String table = "", field="", value="";
		
		for (Mot mot: mots) {
			if ( mot instanceof RubriqueNom && table == "" ) {
				RubriqueNom rubrique = (RubriqueNom) mot;
				table = rubrique.value;
			} else if ( mot instanceof RubriqueValeur && value == "" ) {
				RubriqueValeur rubrique = (RubriqueValeur) mot;
				value = rubrique.value;
			} else if ( mot instanceof Verbe && field == "" ) {
				Verbe verbe = (Verbe) mot;
				field = verbe.getChamps();
			}
		}
		
		System.out.println("\n###\nSelect * FROM "+ table +" WHERE "+ field +" = "+ value +"\n###\n" );
		
	}

}
