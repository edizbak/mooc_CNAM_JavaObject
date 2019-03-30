package cnam1;

import java.util.Date;
import java.util.Scanner;

public class LectureCSV {
	static void bitch() { // balancer l'erreur
		System.out.println("Erreur de format");
		System.exit(0);
	}
	
	static String formatToNoQuotes(String x) { // on vérifie que la chaîne respecte le format et on vire les guillemets
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
			if (count == y.length())
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
		String intro = "Entrez vos nom, prénom et date de naissance au format: \"Nom\";\"Prénom\";jj/mm/aaaa";
		System.out.println(intro);
		
		String ligneCSV;
		Scanner toto = new Scanner(System.in);
		ligneCSV = toto.nextLine();
		String entrees[] = new String[3];
		String date[] = new String[3];
		int jour = 0;
		int mois = 0;
		int annee = 0;

		if (ligneCSV.contains(";")) {
			entrees = ligneCSV.split(";");
		}
		else
			bitch();
		
		String nom_untrim = entrees[0];
		String prenom_untrim = entrees[1];
		String date_raw = entrees[2];
		
		String nom = formatToNoQuotes(nom_untrim);
		String prenom = formatToNoQuotes(prenom_untrim);
		
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

	}

}