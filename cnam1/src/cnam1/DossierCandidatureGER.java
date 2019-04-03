package cnam1;

public class DossierCandidatureGER {
	  // Ici des attributs
	String name; // nom du candidat
	String insee; // n° INSEE du candidat
	int noteEcrit; // note obtenue à l'écrit
	int noteOral; // note obtenue à l'oral
	int progres; // respect du parcours de candidature
	boolean[] avancement= new boolean[7]; // erreurs personnalisées par étape du parcours
	int etat;
	String[] etatDossier = new String[] {"ENREGISTRE", "EMARGE", "NOTE_ECRIT_TRANSMISE", "ADMISSIBLE", "NON_ADMISSIBLE", "NOTE_ORAL_TRANSMISE", 
			  "ADMIS", "NON_ADMIS"}; //
	String[] erreurs = new String[] {"Parcours de candidature non respecté", "Pas d'émargement enregistré", "Pas de note transmise pour l'écrit",
			"Candidat non-admissible", "Candidat absent à l'oral", "Pas de note transmise pour l'oral"};
	
	  // constructeur
	  public DossierCandidatureGER(String nom, String numero){
		  name = nom;
		  insee = numero;
		  progres = 0;
		  avancement[0] = true;
		  etat = 0;
	  }
	  
	  public void checkProgres (int p) {
		  if (progres > p) {
			  throw new IllegalStateException(erreurs[0]);
		  }
	  }
	  public void enregistrerEmargementEpreuveEcrite(){
		  checkProgres(0);
		  progres++;
		  avancement[1] = true;		 
		  etat = 1;
	  }
	  
	  public void enregistrerNoteEpreuveEcrite(int note){
		  if (avancement[1] != true) {
			  throw new IllegalStateException(erreurs[1]);
		  }
		  else {
			  checkProgres(1);
			  if (note <= 20 && note >= 0) {
				  noteEcrit = note;
				  progres++;
				  avancement[2] = true;
				  etat = 2;
			  }
			  else {
				  throw new IllegalArgumentException();
			  }
		  }
	  }
	  
	  public void publierResultatEcrit(){
		  if (avancement[2] != true) {
			  throw new IllegalStateException(erreurs[2]);
		  }
		  else {
			  checkProgres(2);
			  progres++;
			  if (noteEcrit > 9) {				  
				  avancement[3] = true;
				  etat = 3;
			  }
			  else {
				  avancement[3] = false;
				  etat = 4;
			  }
		  }
	  }
	  
	  public void enregistrerNoteEpreuveOrale(int note){
		  checkProgres(3);
		  if (avancement[4] = false) {
			  throw new IllegalStateException(erreurs[4]);
		  }
		  else {
			  if (avancement[3] == false) {
				  throw new IllegalStateException(erreurs[3]);
			  }
			  else {				  
				  if (note >= 0 && note <= 20) {
					  noteOral = note;
					  progres++;
					  avancement[4] = true;
					  etat = 5;
				  }
				  else {
					  throw new IllegalArgumentException();
				  }
			  }
		  }
	  }
	  
	  public void enregistrerAbsenceALOral(){
		  checkProgres(3);
		  if (progres < 3) {
			  throw new IllegalStateException(erreurs[0]);
		  }
		  avancement[4] = false;
		  etat = 7;
	  }
	  
	  public void publierResultatFinal(){
		  if (avancement[4] != true) {
			  throw new IllegalStateException(erreurs[5]);
		  }
		  else {
			  checkProgres(4);
			  progres++;
			  if (noteOral > 10) {
				  avancement[5] = true;
				  etat = 6;
			  }
			  else {
				  avancement[5] = false;
				  etat = 7;
			  }
		  }
	  }
	  
	  public String toString(){
		  String current = name + " " + insee + " Statut du dossier : " + etatDossier[etat];
		  if (progres > 2) {
			  current = current + " Note Ecrit : " + noteEcrit;
		  }
		  if (progres > 4 && avancement[4] == true) {
			  current = current + " Note Oral : " + noteOral;
		  }
		  return current;
	  }
}
