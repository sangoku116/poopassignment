package humain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Generateur {
	public enum TypePersonne {
		VENDEUR, CLIENT
	}

	public static SortedSet<Personne> genererPersonne(TypePersonne typePersonne) {
		SortedSet<Personne> retSetPersonne = new TreeSet<>();
		List<String> listePrenom = Arrays.asList("Dominique", "Caroline", "Jacques", "Rene", "Renee", "Lucie", "Maud",
				"Ginette", "Julie", "Catherine", "Mathieu", "Nicolas", "Jerome", "Maxime", "Roxanne", "Kim", "Audrey",
				"Andre", "Benoit", "Leonie");
		List<String> listeNom = Arrays.asList("Tremblay", "Luneau", "Seguin", "Boutin", "Goulet", "Aube", "Simoneau",
				"Noreau", "Pedneault", "Dubois", "Camara", "Drolet", "Jaras", "Audet", "Cloutier", "Hellie", "Gagnon",
				"Roy", "Bouchard", "Gauthier");

		List<String> listPrenom = new ArrayList<>(listePrenom);
		List<String> listNom = new ArrayList<>(listeNom);
		Collections.shuffle(listPrenom);
		Collections.shuffle(listNom);

		for (int i = 0; i < listNom.size(); i++)
			if (typePersonne == TypePersonne.CLIENT)
				retSetPersonne.add(new Client(listNom.get(i), listPrenom.get(i), (int) (Math.random() * 100)));
			else if (typePersonne == TypePersonne.VENDEUR)
				retSetPersonne.add(new Vendeur(listNom.get(i), listPrenom.get(i), (int) (Math.random() * 100)));

		return retSetPersonne;
	}
}
