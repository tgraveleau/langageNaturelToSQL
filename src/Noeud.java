
public class Noeud {
	
	static String FINAL = "final";
	static String INITIAL = "final";

	private boolean isInitial;
	private boolean isFinal;
	
	public Noeud( String id ) {
		if ( id == INITIAL) {
			this.isInitial = true; 
		} else if ( id == FINAL ) {
			this.isFinal = true; 
		}
	}

	public boolean isInitial() {
		return this.isInitial == true;
	}
	
	
}
