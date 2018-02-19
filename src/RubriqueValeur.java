
public class RubriqueValeur extends Lexique {

	static String type = "valeurRubrique";
	
	private String rubrique;

	public RubriqueValeur(  String nom, String r ) {
		super(nom, type);
		this.rubrique = r;
	}

	
	
}
