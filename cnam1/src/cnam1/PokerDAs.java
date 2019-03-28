package cnam1;

public class PokerDAs{
    public static void main(String[] args){
	int[] tirage = new int[5];
	for (int i=0; i<5; i++){
	    tirage[i] = (int) (Math.random()*6+1);
	}
	java.util.Arrays.sort(tirage);
	for (int i=0; i<5; i++){
	    System.out.print(tirage[i]+" ");
	}
	System.out.println();
	
	String[] resultat = {"poker","carré","full","grande suite","brelan","petite suite","double paire","paire","rien"} ;// résultats
	int[] pos_sci = new int[4]; // positions et valeurs des ruptures de continuité
	int comparateur = 0; // compte le nombre de valeurs identiques
	int suite = 0; // compte le nombre de valeurs qui se suivent
	
	for (int i=0; i<4; i++){
		pos_sci[i] = tirage[i+1] - tirage[i];
		if (pos_sci[i] == 1) {
			suite++;
		}
		if (tirage[i] == tirage[i+1]){
			comparateur++;
		}
	}
		
		switch(comparateur){
			case 4:
				System.out.print(resultat[0]);
				break;
			case 3:
				if (pos_sci[0] >= 1 || pos_sci[3] >= 1) {
					System.out.print(resultat[1]);
					break;
				}
				else {
					System.out.print(resultat[2]);
					break;
				}
			case 2:
				int brelan=0;
				for (int j=0; j<3; j++) {
					if(pos_sci[j] + pos_sci[j+1] == 0) {
						brelan++;
					}
					}
				if (brelan == 1) {
					System.out.print(resultat[4]);
					break;
				}
				else {
				System.out.print(resultat[6]);
				break;
				}
			case 1:
				if (suite == 3) {
					if (pos_sci[1] != 0 && pos_sci[2] != 0) {
						System.out.print(resultat[5]);
						break;
					}
					else {
						System.out.print(resultat[7]);
						break;
					}
				}
					else {
						System.out.print(resultat[7]);
						break;
					}
			case 0:
				if (suite == 4) {
					System.out.print(resultat[3]);
					break;
				}
				else if (suite == 3){
					if (pos_sci[1] == 1 && pos_sci[2] == 1) {
						System.out.print(resultat[5]);
						break;
					}
					else {
						System.out.print(resultat[8]);
						break;
					}
				}
				else {
					System.out.print(resultat[8]);
					break;
				}
		}
//	int passes = 1;
//	ArrayList<Integer> semblable = new ArrayList<>();
//	for (int num : tirage) {
//
//		if (passes < 5 ){
//			int count = 0;
//			for (int i=passes; i<5; i++) {
//				if (tirage[i] == num) {
//					count++ ;
//				}
//			}
//			if (count != 0)
//				semblable.add(count);
//			passes++ ;
//		}
//		
//		
//	}
//		System.out.print(semblable);
    }
}