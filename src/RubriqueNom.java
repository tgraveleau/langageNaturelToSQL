
public class RubriqueNom extends Lexique {

	static String type = "nomRubrique";
	
	private String[] valeursPossibles;
	
	public RubriqueNom( String nom, String[] vp ) {
		super(nom, type);
		this.valeursPossibles = vp;
	}
	
}
