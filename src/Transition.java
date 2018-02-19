
public class Transition {
	
	private Noeud depart;
	private Noeud arrive;
	private String etiquette;
	private Action action;
	
	public Transition(Noeud depart, Noeud arrive, String etiquette, Action action) {
		super();
		this.depart = depart;
		this.arrive = arrive;
		this.etiquette = etiquette;
		this.action = action;
	}
	
	public Noeud doTransition( Noeud n, Mot mot ) {
		Noeud toReturn = this.arrive;
		
		toReturn.transfereMotsTraitesJusquAPresent( n );

		if ( mot.type == RubriqueNom.type || mot.type == RubriqueValeur.type || mot.type == Verbe.type ) {
			toReturn.addMot(mot);
		}
		
		if ( action != null ) {
			action.doAction( toReturn.getMotsTraitesJusquAPresent() );
			toReturn.clearMots();
		}
		
		return toReturn;
	}

	public boolean accept(Noeud current, Mot mot) {
		// Si le noeud actuel est le noeud de départ et que la transition attend bien un mot du type etiquette
		if ( this.depart == current && mot.getType() == this.etiquette ) {
			return true;
		}
		return false;
	}

	public boolean isInitial() {
		return this.depart.isInitial();
	}
	
	public Noeud getDepart() {
		return this.depart;
	}
	
}
