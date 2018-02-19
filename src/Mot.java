
public class Mot {
	
	protected String type;
	protected String value;

	public Mot(String val, String type) {
		this.value = val;
		this.type = type;
	}
	
	public String toString() {
		return this.type+ ": " +this.value;
	}

	public String getType() {
		return this.type;
	}

}
