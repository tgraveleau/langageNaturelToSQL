import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Window extends JPanel implements ActionListener{
	private static JComboBox l_opt;
	private static JComboBox l_pronoms;
	private static JComboBox l_determinants;
	private static JComboBox l_verbes;
	private static JComboBox l_personnes;

	private static final long serialVersionUID = 1L;
	
	public Window(){
		
	}
	
	
	
	   
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     */
    private static void createAndShowGUI() {
    	
        //Create and set up the window.
        JFrame frame = new JFrame("ATN");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        
        //Add content to the window.
        frame.add(new Window(), BorderLayout.CENTER);
        
        Object[] pronoms = new Object[]{"Quels", "Qui"};        
        l_pronoms = new JComboBox(pronoms);
		
		Object[] determinants = new Object[]{"la", "le", "les", "de", "un", "des"};
		l_determinants = new JComboBox(determinants);
        
        Object[] personnes = new Object[]{"étudiant", "personne", "responsable"};
        l_personnes = new JComboBox(personnes);
		
        Object[] verbes = new Object[]{ "être", "habiter", "préparer"};
        l_verbes = new JComboBox(verbes);
        
        Object[] opt = new Object[]{"-"};
        l_opt = new JComboBox(opt);
        l_verbes.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0) {
        		JComboBox l_verbes = (JComboBox) arg0.getSource();
        		String s = (String) l_verbes.getSelectedItem();//get the selected item
        		switch (s) {//check for a match
                case "préparer":
                	Object[] diplome = new Object[]{"M1 Info", "Bac +5", "CAP boulangerie", "Bac Pro STG"};
                	l_opt.removeAllItems();
                	for(Object st : diplome) {
                		l_opt.addItem(st.toString());
                	}
                    break;
                case "habiter":
                	Object[] ville = new Object[]{"Angers", "Maubeuge", "Roubaix", "Pellouailles les Vignes"};
                	l_opt.removeAllItems();
                	for(Object st : ville) {
                		l_opt.addItem(st.toString());
                	}
                    break;
                default:
                	l_opt.removeAllItems();
                	l_opt.addItem("-");
        		}

        		
        	}
        });
        
        
        
        
        
 
		panel.add(l_pronoms);
		//panel.add(l_determinants);
		panel.add(l_personnes);
		panel.add(l_verbes);
		panel.add(l_opt);
		
		JButton envoi = new JButton("Go!");
		envoi.addActionListener(new ActionListener() {

		    
		    public void actionPerformed(ActionEvent e) {

		    	Mot pronom = new Mot( (String) l_pronoms.getSelectedItem(),"pronom");
		    	Mot personne = new Mot((String) l_personnes.getSelectedItem(), "nomRubrique");
		        //String determinant = (String) l_determinants.getSelectedItem();
		        Mot verbe = new Mot((String) l_verbes.getSelectedItem(),"verbe");
		        Mot opt = new Mot((String) l_opt.getSelectedItem(), "opt");
		       // System.out.println("Question : " + pronom + " "+ determinant+ " "+personne+ " "+verbe+ " "+opt);
		     // Pronom
				Pronom quel = new Pronom( "Quels" );
				Pronom qui = new Pronom("Qui");
		        String[] val_personne = { "nom", "prenom" };
				RubriqueNom perso = new RubriqueNom( (String) l_personnes.getSelectedItem(), val_personne );
				// habiter
				String[] habiter_sujetsPossibles = { "etudiant", "personne", "responsable" };
				String[] habiter_objetsPossibles = { "Angers", "Maubeuge", "Roubaix", "Pellouailles les Vignes" };
				//Verbe habiter = new Verbe( "habiter", habiter_sujetsPossibles, habiter_objetsPossibles );
				
				// preparer
				String[] preparer_sujetsPossibles = { "etudiant", "personne" };
				String[] preparer_objetsPossibles = { "M1 Info", "Bac +5", "CAP boulangerie", "Bac Pro STG" };
				//Verbe preparer = new Verbe( "preparer", preparer_sujetsPossibles, preparer_objetsPossibles );
				
				// diplome
				String[] val_diplome = {"M1 Info", "Bac +5", "CAP boulangerie", "Bac Pro STG" };
				RubriqueNom diplome = new RubriqueNom( "diplome", val_diplome );
				
				// Noeud
				Noeud n1 = new Noeud( Noeud.INITIAL );
				Noeud n2 = new Noeud( null );
				Noeud n3 = new Noeud( null );
				Noeud n4 = new Noeud ( null );
				Noeud n5 = new Noeud( Noeud.FINAL );
				
				// Transition
				Transition tr1 = new Transition( n1, n2, Pronom.type, null);
				Transition tr2 = new Transition( n2, n3, RubriqueNom.type, null);
				Transition tr3 = new Transition( n3, n4, Verbe.type, null);
				//Transition tr4 = new Transition( n4, n5, RubriqueNom.type, new Action());
				
				Transition[] transitions = { tr1, tr2, tr3};
				Mot[] requete = { pronom, personne, verbe, opt };
				
				Solveur solveur = Solveur.getInstance();
				solveur.solve( requete, transitions );
		    }
		});
		panel.add(envoi);
        
        
        frame.add(panel);
        
        //Display the window.
        frame.setPreferredSize(new Dimension(700, 200));
        frame.pack();
        frame.setVisible(true);
    }
    
	public void actionPerformed(ActionEvent arg0) {
		JComboBox l_verbes = (JComboBox) arg0.getSource();
		String s = (String) l_verbes.getSelectedItem();//get the selected item
		switch (s) {//check for a match
        case "préparer":
        	Object[] diplome = new Object[]{"Bac +3", "Bac +5", "CAP boulangerie", "Bac Pro STG"};
        	l_opt = new JComboBox(diplome);
            break;
        case "habiter":
        	Object[] ville = new Object[]{"Angers", "Maubeuge", "Roubaix", "Pellouailles les Vignes"};
        	l_opt = new JComboBox(ville);
            break;
		}

		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

	}






}
