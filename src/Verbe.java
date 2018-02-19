
public class Verbe extends Lexique {

	static String type = "verbe";
	
	private String champs;
	private String[] sujetsPossibles;
	private String[] objetPossibles;

	public Verbe( String n, String champs, String[] sp, String[] op ) {
		super(n, type);
		this.champs = champs;
		this.sujetsPossibles = sp;
		this.objetPossibles = op;
	}

	public String getChamps() {
		return this.champs;
	}
	
	
}
