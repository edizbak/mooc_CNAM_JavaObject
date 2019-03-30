package cnam1;

public class TabNoms {

	public static void main(String[] args) {
		String noms = "Émile; Félix; Arsène; Ferdinand";
		String manip = noms.toLowerCase();
		manip = manip.replace('é', 'e');
		manip = manip.replace('è', 'e');
		System.out.println(manip);
		String[] tabnoms = manip.split(";");
		for (int i=0; i<tabnoms.length; i++) {
			tabnoms[i] = tabnoms[i].trim();
			//System.out.println(tabnoms[i]);
		}

		int pos[][] = new int[tabnoms.length][2];

		java.util.Arrays.sort(tabnoms);

		for (int i=0; i<tabnoms.length; i++) {
			pos[i][0] = manip.indexOf(tabnoms[i]);
			pos[i][1] = manip.indexOf(tabnoms[i]) + tabnoms[i].length();
		}
		for (int i=0; i<tabnoms.length; i++) {
			//System.out.println(tabnoms[i]);
			System.out.println(noms.substring(pos[i][0], pos[i][1]));
}

	}

}
