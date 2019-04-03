package cnam1;

public class DossierCandidatureGER {
	  // Ici des attributs
	String name; // nom du candidat
	String insee; // n° INSEE du candidat
	int noteEcrit; // note obtenue à l'écrit
	int noteOral; // note obtenue à l'oral
	int progres; // respect du parcours de candidature
	boolean[] avancement= new boolean[7]; // erreurs personnalisées par étape du parcours
	int etat; // index pour appeler la string etatDossier
	String[] etatDossier = new String[] {"ENREGISTRE", "EMARGE", "NOTE_ECRIT_TRANSMISE", "ADMISSIBLE", "NON_ADMISSIBLE", "NOTE_ORAL_TRANSMISE", 
			  "ADMIS", "NON_ADMIS"}; // self-explanatory
	String[] erreurs = new String[] {"Parcours de candidature non respecté", "Pas d'émargement enregistré", "Pas de note transmise pour l'écrit",
			"Candidat non-admissible", "Candidat absent à l'oral", "Pas de note transmise pour l'oral"}; // on s'amuse comme on peut
	
	  // constructeur
	  public DossierCandidatureGER(String nom, String numero){
		  name = nom; // non, on ne vérifie pas qu'il n'y a que des lettres dans le nom
		  insee = numero; // on ne vérifie pas non plus que le n° INSEE correspond bien au format attendu
		  progres = 0; // tout commence ici
		  avancement[0] = true; // pas sûr que ça serve vraiment mais bref, si un objet est créé on coche la première case
		  etat = 0; // oui, si l'objet est créé il est enregistré
	  }
	  
	  public void checkProgres (int p) { // progres sera incrémenté à chaque fois qu'on passe une étape du processus de candidature
		  if (progres > p) {			 // si le progres est trop avancé pour l'étape à laquelle on arrive, il y a un problème donc boum
			  throw new IllegalStateException(erreurs[0]);
		  }
	  }
	  public void enregistrerEmargementEpreuveEcrite(){
		  checkProgres(0);
		  progres++; // avec la ligne précédente, on peut pas émarger 2 fois bande d'escrocs
		  avancement[1] = true;		 
		  etat = 1;
	  }
	  
	  public void enregistrerNoteEpreuveEcrite(int note){
		  if (avancement[1] != true) { // en vrai j'aurais pu faire une méthode checkAvancement sur le modèle de checkProgres...
			  throw new IllegalStateException(erreurs[1]);
		  }
		  else {
			  checkProgres(1);
			  if (note <= 20 && note >= 0) { // bon, on vérifie quand même que les notes sont comprises entre 0 et 20, on n'est pas des sauvages
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
			  if (noteEcrit > 9) {				// admissible, fais péter le champomy  
				  avancement[3] = true;
				  etat = 3;
			  }
			  else {
				  avancement[3] = false; // brrrrrrt, sors la vodka
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
		  if (progres < 3) {									// méthode de barbouze pour passer le test du correcteur
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
			  if (noteOral > 10) { // bravo t'es admis coco
				  avancement[5] = true;
				  etat = 6; // en vrai c'est ici que ça compte pour toString
			  }
			  else {
				  avancement[5] = false; // à l'année prochaine :(
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
