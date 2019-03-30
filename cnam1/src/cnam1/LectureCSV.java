package cnam1;

import java.util.Date;
import java.util.Scanner;

public class LectureCSV {
	static void bitch() {
		System.out.println("Erreur de format");
		System.exit(0);
	}
	
	static String formatte(String x) {
		char delim = '"';
		int count = 0;
		if(x.charAt(0) == delim && x.charAt(x.length()-1) == delim) {
			String y = x.substring(1, x.length()-1);
			for (int i=0; i<y.length(); i++) {
				if(Character.isLetter(y.charAt(i))) {
					count++;
				}
				else
					bitch();
			}
			if (count == y.length()-1)
				return y;
			else {
				bitch();
				return x;
			}
		}
		else
			bitch();return x;
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		String ligneCSV;
		Scanner toto = new Scanner(System.in);
		ligneCSV = toto.nextLine();
		String entrees[] = new String[3];
		//char delim = '"';
		String date[] = new String[3];
		int jour = 0;
		int mois = 0;
		int annee = 0;

		if (ligneCSV.contains(";")) {
			entrees = ligneCSV.split(";");
		}
		else
			bitch();
		
		
		//if (entrees.charAt(entrees.indexOf(entrees[0])) == delim && entrees.charAt([entrees[0].length]) == delim) {
		String nom_untrim = entrees[0];
		String prenom_untrim = entrees[1];
		String date_raw = entrees[2];
		
//		if (nom_untrim.charAt(0) == delim && nom_untrim.charAt(nom_untrim.length()) == delim) {
//			String nom = nom_untrim.replace('"', ' ');
//			nom = nom.trim();
//		}
//		else
//			bitch();
		String nom = formatte(nom_untrim);
		String prenom = formatte(prenom_untrim);
		
//		if (prenom_untrim.charAt(0) == delim && prenom_untrim.charAt(prenom_untrim.length()) == delim) {
//			String prenom = prenom_untrim.replace('"', ' ');
//			prenom = prenom_untrim.trim();
//		}
//		else
//			bitch();
		
		if (date_raw.contains("/") && date_raw.length() == 10) {
			date = date_raw.split("/");
			for (int i=0; i<2; i++) {
				char num = date[0].charAt(i);
				if (Character.isDigit(num))
					jour = Integer.parseInt(date[0]);
				else {
					jour = 0;
					bitch();
				}
			}
			for (int i=0; i<2; i++) {
				char num = date[1].charAt(i);
				if (Character.isDigit(num))
					mois = Integer.parseInt(date[1]);
				else{
					mois = 0;
					bitch();
				}
			}
			for (int i=0; i<4; i++) {
				char num = date[2].charAt(i);
				if (Character.isDigit(num))
					annee = Integer.parseInt(date[2]);
				else{
					annee = 0;
					bitch();
				}
			}

		}
		
		Date naissance = new Date(annee-1900, mois-1, jour);
		String date_naiss = naissance.toString();
		
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(date_naiss);
		//}

	}

}
