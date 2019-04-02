package cnam1;

public class Tennis {
	//char stateJeu; //e = en cours, t = terminé
	char stateMatch; //e = en cours, t = terminé
	
	// points dans le jeu
	int ptsJ1; 
	int ptsJ2;
	
	// points dans la manche
	int jeuxJ1; 
	int jeuxJ2;
	
	// format des points en jeu
	String[] formatPts;
	
	// contructeur
	public Tennis () {
		stateMatch = 'e';
		//stateJeu = 'e';
		ptsJ1 = 0;
		ptsJ2 = 0;
		jeuxJ1 = 0;
		jeuxJ2 = 0;
		formatPts = new String[]{"0","15","30","40"};
	}
	
	// incrémentation des points du joueur 1
	public void incPtsJ1() {
		if (stateMatch == 'e') {
			if (jeuxJ1 > 5 && jeuxJ1 - jeuxJ2 > 1) {
				stateMatch = 't';
			}
			else {
				//if (stateJeu == 'e') {
					if (ptsJ1 > 3 && ptsJ1 - ptsJ2 > 1) {
						//stateJeu = 't';
						jeuxJ1++;
						ptsJ1 = 0;
						ptsJ2 = 0;
					}
					else {
						ptsJ1++;
					}
				}
				//else {
					
					//jeuxJ1++;
				//}
			//}
		}
		else {
			System.out.print("Non");
			System.exit(0);
		}
	}
	
	// incrémentation des points du joueur 2
	public void incPtsJ2() {
		if (stateMatch == 'e') {
			if (jeuxJ2 > 5 && jeuxJ2 - jeuxJ1 > 1) {
				stateMatch = 't';
			}
			else {
				//if (stateJeu == 'e') {
					if (ptsJ2 > 3 && ptsJ2 - ptsJ1 > 1) {
						//stateJeu = 't';
						jeuxJ2++;
						ptsJ2 = 0;
						ptsJ1 = 0;
					}
					else {
						ptsJ2++;
					}
				}
				//else {
					
					//jeuxJ1++;
				//}
			//}
		}
		else {
			System.out.print("Non");
			System.exit(0);
		}
	}
	
	//abandon du joueur 1
	public void forfJ1() {
		ptsJ1 = -1;
		stateMatch ='t';
	}
	
	//abandon du joueur 2
	public void forfJ2() {
		ptsJ2 = -1;
		stateMatch ='t';
	}
	
	//affichage du score
	public String toString() {
		if (ptsJ1 == -1) {
			return "abandon du Joueur 1";
		}
		if (ptsJ2 == -1) {
			return "abandon du Joueur 2";
		}
		else {
			if (stateMatch == 't') {
				return "Match terminé. Score " + jeuxJ1 + "-" + jeuxJ2;
			}
			else {
				if (ptsJ1 > 3 && ptsJ1 - ptsJ2 > 0) {
					return jeuxJ1 + "-" + jeuxJ2 + " avantage Joueur 1";
				}
				if (ptsJ2 > 3 && ptsJ2 - ptsJ1 > 0) {
					return jeuxJ1 + "-" + jeuxJ2 + " avantage Joueur 2";
				}
				if (ptsJ1 > 3 && ptsJ2 > 3) {
					return jeuxJ1 + "-" + jeuxJ2 + " égalité";
				}
				else {
					return jeuxJ1 + "-" + jeuxJ2 + " " + formatPts[ptsJ1] + "-" + formatPts[ptsJ2];
				}
			}
		}
	}

	public static void main(String[] args) {
		Tennis score = new Tennis();
		
//		while (true) {
			score.incPtsJ1();
			score.incPtsJ1();
			score.incPtsJ2();
			System.out.println(score.toString());
			score.forfJ2();
			System.out.println(score.toString());
			if(score.stateMatch == 't')
				System.exit(0);
//		}
//		for (int i=0; i<6; i++) {
//			System.out.println(score.formatPts[i]);
//		}

	}

}
