package poker_classic;

public class Carte {
	private final int[] index = new int[2];
	final String[] faces = {"7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};
	final String[] couleurs = {"Carreau", "Coeur", "Pique", "Trèfle"};
	protected Carte() {
		this.index[0] = (int) (Math.random()*8);
		this.index[1] = (int) (Math.random()*4);
	}
	
	public String toString() {
		return faces[index[0]] + " de " + couleurs[index[1]];
	}
	
	public int[] getIndex() {
		return index;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if(!(o instanceof Carte))
			return false;
		Carte c = (Carte) o;
		return index[0] == c.index[0] &&
				index[1] == c.index[1];
	}
}
