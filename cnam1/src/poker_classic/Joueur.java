package poker_classic;
import java.util.ArrayList;

public class Joueur {
	public ArrayList<Carte> main;
	public final int id;
	
	public Joueur (int id) {
		this.id = id;
		this.main = new ArrayList<Carte>();
	}
	
	public void change(int[] nbCartes) {
		
		if(nbCartes.length <= main.size()) {
			for(int i=nbCartes.length; i>0; i--) {
				Paquet.tas.add(0, main.get(nbCartes[i-1]));
				main.remove(nbCartes[i-1]);
			}
			Paquet.donne(nbCartes.length, this);
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	public String toString() {
		String burp = "";
		for(int i=0; i<main.size(); i++)
			burp += main.get(i).toString() + "\n";
		return burp;
	}
}
