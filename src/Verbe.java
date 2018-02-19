
public class Verbe extends Lexique {

	static String type = "verbe";
	
	private String[] sujetsPossibles;
	private String[] objetPossibles;

	public Verbe( String n, String[] sp, String[] op ) {
		super(n, type);
		this.sujetsPossibles = sp;
		this.objetPossibles = op;
	}

	
	
}
