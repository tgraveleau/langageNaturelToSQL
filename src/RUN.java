import java.util.ArrayList;


public class RUN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Pronom
		Pronom quel = new Pronom( "quel" );
		
		// Etudiant
		String[] val_etudiant = { "nom", "prenom" };
		RubriqueNom etudiant = new RubriqueNom( "etudiant", val_etudiant );
		
		// Personne
		String[] val_personne = { "nom", "prenom" };
		RubriqueNom personne  = new RubriqueNom( "personne", val_personne );
		
		// M1 info
		RubriqueValeur m1info = new RubriqueValeur( "M1 info", "diplome" );
		
		// habiter
		String[] habiter_sujetsPossibles = { "etudiant", "personne" };
		String[] habiter_objetsPossibles = { "ville" };
		Verbe habiter = new Verbe( "habiter", habiter_sujetsPossibles, habiter_objetsPossibles );
		
		// preparer
		String[] preparer_sujetsPossibles = { "etudiant", "personne" };
		String[] preparer_objetsPossibles = { "ville" };
		Verbe preparer = new Verbe( "preparer", preparer_sujetsPossibles, preparer_objetsPossibles );
		
		// diplome
		String[] val_diplome = { "Bac +3", "Bac +5" };
		RubriqueNom diplome = new RubriqueNom( "diplome", val_diplome );
		
		// Noeud
		Noeud n1 = new Noeud( Noeud.INITIAL );
		Noeud n2 = new Noeud( null );
		Noeud n3 = new Noeud( null );
		Noeud n4 = new Noeud( Noeud.FINAL );
		
		// Transition
		Transition tr1 = new Transition( n1, n2, Pronom.type, null);
		Transition tr3 = new Transition( n2, n3, RubriqueNom.type, null);
		Transition tr2 = new Transition( n3, n4, Verbe.type, new Action());
		
		Transition[] transitions = { tr1, tr2, tr3};
		Mot[] requete = { quel, etudiant, habiter };
		
		Solveur solveur = Solveur.getInstance();
		solveur.solve( requete, transitions );
		

	}

}
