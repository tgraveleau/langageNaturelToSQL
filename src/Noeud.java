import java.util.ArrayList;


public class Noeud {
	
	static String FINAL = "final";
	static String INITIAL = "final";

	private boolean isInitial;
	private boolean isFinal;
	
	private ArrayList<Mot> motsTraitesJusquAPresent;
	
	public Noeud( String id ) {
		if ( id == INITIAL) {
			this.isInitial = true; 
		} else if ( id == FINAL ) {
			this.isFinal = true; 
		}
		motsTraitesJusquAPresent = new ArrayList<Mot>();
	}

	public boolean isInitial() {
		return this.isInitial == true;
	}
	
	public void addMot( Mot mot ) {
		this.motsTraitesJusquAPresent.add( mot );
	}
	
	public void clearMots() {
		this.motsTraitesJusquAPresent.clear();
	}

	public ArrayList<Mot> getMotsTraitesJusquAPresent() {
		return this.motsTraitesJusquAPresent;
	}
	
	public void transfereMotsTraitesJusquAPresent( Noeud n ) {
		this.motsTraitesJusquAPresent.clear();
		this.motsTraitesJusquAPresent.addAll( n.getMotsTraitesJusquAPresent() );
		n.clearMots();
	}

}
