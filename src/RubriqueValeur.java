
public class RubriqueValeur extends Lexique {

	static String type = "valeurRubrique";
	
	private RubriqueNom rubrique;

	public RubriqueValeur(  String nom, RubriqueNom rubrique ) {
		super(nom, type);
		this.rubrique = rubrique;
	}

	
	
}
