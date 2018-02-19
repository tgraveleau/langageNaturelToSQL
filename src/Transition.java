
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
		System.out.println("Transition");
		Noeud toReturn = null;
		
			toReturn = this.arrive;
			if ( action != null ) {
				action.doAction();
			}
		
		return toReturn;
	}

	public boolean accept(Noeud current, Mot mot) {
		if ( this.depart == current && mot.getType() == etiquette ) {
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
