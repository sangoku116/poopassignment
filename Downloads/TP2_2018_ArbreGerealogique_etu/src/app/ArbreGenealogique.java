package app;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import utilitaires.ArbreBinaireDerive;
import utilitaires.Personne;
public class ArbreGenealogique implements Serializable {
	private static final long serialVersionUID = 103190847568241619L;
	private ArbreBinaireDerive arbre = new ArbreBinaireDerive();
	Set<String> setString;

	public ArbreGenealogique() {
	}




	public void genererArbreGenealogique() {
		arbre.ajouter(new Personne("Lucie", 13);
		arbre.ajouter(new Personne("Sofie", 56);
		arbre.ajouter(new Personne("Christian", 22);
		arbre.ajouter(new Personne("Mathieu", 3);
		arbre.ajouter(new Personne("Roxanne", 43);
		arbre.ajouter(new Personne("Kim", 21);
		arbre.ajouter(new Personne("lyne", 77);
		arbre.ajouter(new Personne("Maxime", 37);
		arbre.ajouter(new Personne("Ludovic", 63);
		arbre.ajouter(new Personne("Julliette", 25);
		arbre.ajouter(new Personne("Simon", 45);
		arbre.ajouter(new Personne("Leo", 18);
		arbre.ajouter(new Personne("Victor", 5);
	}

	public void ajouterEnfant(String enfant, String parent) {
		arbre.ajouter(enfant, parent);
	}

	public List<String> getListeElement() {
		return arbre.getListeElement();
	}

	public Set<String> transformeSetString() {
		return setString = this.getListeElement().stream().map(ArbreGenealogique::mapToString).collect(Collectors.toSet());
	}
	private static String mapToString(String i)
	{
		return i;
	}

	public List<String> getListeString40ansEtMoins() {
		if(setString==null)
		transformeSetString();
		return setString.stream().filter(ArbreGenealogique::filter40Moins).collect(Collectors.toList());

	}
	private static boolean filter40Moins(Personne p)
	{
		return p.getAge() <= 40;

	}



	public void serialize()
	{
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(new File("arbre.ser")))))
		{
			oos.writeObject(arbre);
			oos.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Problème lors de la sérialisation...");
		}
	}

	// WARNING ENLEVÉ -- CAST SUR L'OBJET LU
	@SuppressWarnings("unchecked")
	public void deserialize()
	{
		try (ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(new File("arbre.ser")))))
		{
			arbre = (ArbreBinaireDerive<String>) ois.readObject();
		}
		catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("Problème lors de la désérialisation...");
	
	@Override
	public String toString() {
		return arbre.toString();
	}
}
