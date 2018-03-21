import java.util.ArrayList;


public class RUN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Pronom
		Pronom quel = new Pronom( "quel" );
		Pronom qui = new Pronom("qui");
		
		// Etudiant
		String[] val_etudiant = { "nom", "prenom" };
		RubriqueNom etudiant = new RubriqueNom( "etudiant", val_etudiant );
		
		// Personne
		String[] val_personne = { "nom", "prenom" };
		RubriqueNom personne  = new RubriqueNom( "personne", val_personne );

		// diplome
		String[] val_diplome = { "Licence info", "M1 Info" };
		RubriqueNom diplome = new RubriqueNom( "diplome", val_diplome );

		// ville
		String[] val_ville= { "Angers", "Paris" };
		RubriqueNom ville = new RubriqueNom( "ville", val_ville);
		
		// Responsable
		String[] val_resp= { "nom", "prenom" };
		RubriqueNom reponsable  = new RubriqueNom( "responsable", val_personne );
		
		// M1 info
		RubriqueValeur m1info = new RubriqueValeur( "M1 info", diplome );
		
		// Bac +5
		RubriqueValeur bac5 = new RubriqueValeur( "Bac +5", "diplome" );
		
		// CAP
		RubriqueValeur cap = new RubriqueValeur( "CAP boulangerie", "diplome" );
		
		// Bac Pro
		RubriqueValeur bacpro = new RubriqueValeur( "Bac Pro STG", "diplome" );
		
		
		// Angers
		RubriqueValeur angers = new RubriqueValeur( "Angers", ville );
		
		// habiter
		String[] habiter_sujetsPossibles = { "etudiant", "personne" };
		String[] habiter_objetsPossibles = { "ville" };
		Verbe habiter = new Verbe( "habiter", "habite", habiter_sujetsPossibles, habiter_objetsPossibles );
		
		// preparer
		String[] preparer_sujetsPossibles = { "etudiant" };
		String[] preparer_objetsPossibles = { "diplome" };
		Verbe preparer = new Verbe( "preparer", "prepare", preparer_sujetsPossibles, preparer_objetsPossibles );
		
		// Noeud
		Noeud n1 = new Noeud( Noeud.INITIAL );
		Noeud n2 = new Noeud( null );
		Noeud n3 = new Noeud( null );
		Noeud n4 = new Noeud( null );
		Noeud n5 = new Noeud( Noeud.FINAL );
		
		// Automate principal
		Transition tr1 = new Transition( n1, n2, Pronom.type, null);
		Transition tr2 = new Transition( n2, n3, RubriqueNom.type, null);
		Transition tr3 = new Transition( n3, n4, Verbe.type, null);
		// Automate secondaire
		Transition tr4 = new Transition( n4, n5, RubriqueValeur.type, new ActionRequete());
		
		Transition[] transitions = { tr1, tr2, tr3, tr4 };
		Mot[] requete = { quel, etudiant, habiter, angers };
		
		Solveur solveur = Solveur.getInstance();
		solveur.solve( requete, transitions );
		

	}

}
