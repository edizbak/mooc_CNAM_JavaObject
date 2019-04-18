package poker_classic;
import java.util.ArrayList;

public class Paquet {
	private ArrayList<Carte> tas;
	public Paquet() {
		tas = new ArrayList<Carte>();
		Carte tempCarte;
		tas.add(new Carte());
		for (int i=1; i<32; i++) {
			tempCarte = new Carte();
			noDouble(tempCarte);
		}
	}
	private void noDouble(Carte check) {
		Carte checkedCarte = check;
		if (tas.contains(checkedCarte)) {
			checkedCarte = new Carte();
			noDouble(checkedCarte);
		}
		else
			tas.add(check);
	}
	public int getSize() {
		return tas.size();
	}
	
	public String toString() {
		String burp = "";
		for(int i=0; i<tas.size(); i++)
			burp += tas.get(i).toString() + "\n";
		return burp;
	}
}
