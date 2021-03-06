
public class Solveur {
	
	static Solveur instance;
	
	private Solveur() {
		// juste pour le private
	}

	public static Solveur getInstance() {
		if ( instance == null ) {
			instance = new Solveur();
		}
		return instance;
	}

	public void solve(Mot[] requete, Transition[] transitions) {
		Noeud current = null;
		String fausseRequete = "";
		
		// Pour chaque transition...
		for (Transition t : transitions) {
			// On regarde lequel est l'état initial
			if ( t.isInitial() ) {
				current = t.getDepart();
				break;
			}
		}
		
		// Si on n'a pas trouvé de noeud initial il y a un problème
		if ( current == null ) {
			System.err.println("Aucun noeud inital trouvé");
			System.exit(1);
		}
		
		// Pour chaque mot de la requete ...
		for (Mot mot : requete) {
			System.out.println("mot: "+ mot.value+ "," +mot.getType());
			// On regarde pour chaque transition ...
			for (Transition t : transitions) {
				// Si la configuration (noeudActuel, motActuel) peut donner une transition
				if ( t.accept( current, mot ) ) {
					// Si oui, on change le noeud actuel
					current = t.doTransition( current, mot );
				} else {
					;
				}
				
			}
			switch (mot.type) {
			case "pronom":
				fausseRequete+="SELECT * FROM ";					
				break;
			case "nomRubrique":
				fausseRequete+=mot.value;					
				break;
			case "verbe":
				fausseRequete+=" WHERE ville = ";					
				break;
			case "opt":
				fausseRequete+=mot.value+";";

			default:
				break;
			}
		}
		System.out.println(fausseRequete);
	}
	
	

}
