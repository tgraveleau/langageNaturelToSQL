import java.util.ArrayList;


public class ActionSelect extends Action {

	public void doAction(ArrayList<Mot> mots) {
		
		System.out.println("Select");
		
		for (Mot m : mots)
			System.out.println("mot: "+m);
	}

}
