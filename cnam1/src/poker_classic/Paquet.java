package poker_classic;
import java.util.ArrayList;

public class Paquet {
	public static ArrayList<Carte> tas; // the field that stores the deck
	
	public Paquet() {
		tas = new ArrayList<Carte>();
		Carte tempCarte;
		tas.add(new Carte()); //the first card can be any card
		
		for (int i=1; i<32; i++) { // adding the 31 other cards
			tempCarte = new Carte();
			noDouble(tempCarte);
		}
	}
	private void noDouble(Carte check) {
		Carte checkedCarte = check;
		if (tas.contains(checkedCarte)) {//if the card already exists in the deck, 
			checkedCarte = new Carte();  //attribute a new value to the checked card
			noDouble(checkedCarte);      //then run the test again for the new value
		}
		else {
			tas.add(check); //card doesn't exist in the deck, we can add it
		}
	}
	public int getSize() {
		return tas.size();
	}

	public static void donne (Joueur id) {
		for(int i=0; i<5; i++) {
			id.main.add(tas.get(tas.size()-1));
			tas.remove(tas.size()-1);
		}
	}
	
	public static void donne (int nbCartes, Joueur id) {
		for(int i=0; i<nbCartes; i++) {
			id.main.add(tas.get(tas.size()-1));
			tas.remove(tas.size()-1);
		}
	}
	
	public String toString() {
		String burp = "";
		for(int i=0; i<tas.size(); i++)
			burp += tas.get(i).toString() + "\n";
		return burp;
	}
}
