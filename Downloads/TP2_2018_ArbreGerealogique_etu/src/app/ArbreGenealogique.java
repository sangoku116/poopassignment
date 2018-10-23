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
        Personne lucie = new Personne("Lucie", 13, "000000000");
        Personne sofie = new Personne("Sofie", 56, "000000001");
        Personne christian = new Personne("Christian", 22, "000000002");
        Personne mathieu = new Personne("Mathieu", 3, "000000003");
        Personne roxanne = new Personne("Roxanne", 43, "000000004");
        Personne kim = new Personne("Kim", 21, "000000005");
        Personne lyne = new Personne("Lyne", 77, "000000006");
        Personne maxime = new Personne("Maxime", 37, "000000007");
        Personne ludovic = new Personne("Ludovic", 63, "000000008");
        Personne juliette = new Personne("Juliette", 25, "00000009");
        Personne simon = new Personne("Simon", 45, "00000012");
        Personne leo = new Personne("Leo", 18, "00000010");
        Personne victor = new Personne("victor", 5, "00000011");

        arbre.ajouter(lucie, null);
        arbre.ajouter(sofie, null);
        arbre.ajouter(christian, null);
        arbre.ajouter(mathieu, lucie);
        arbre.ajouter(roxanne, mathieu);
        arbre.ajouter(kim, mathieu);
        arbre.ajouter(lyne, lucie);
        arbre.ajouter(maxime, lyne);
        arbre.ajouter(ludovic, christian);
        arbre.ajouter(juliette, maxime);
        arbre.ajouter(simon, maxime);
        arbre.ajouter(leo, simon);
        arbre.ajouter(victor, roxanne);
    }

    public void ajouterEnfant(String enfant, String parent) {
        arbre.ajouter(enfant, parent);
    }

    public List<String> getListeElement() {
        return arbre.getListeElement();
    }

    public Set<String> transformeSetString() {
        return setString = this.getListeElement().stream().map(ArbreGenealogique::mapToString).collect(Collectors.toSet());
        return null;
    }

    private static String mapToString(Personne i) {
        return i.toString();
    }

    public List<String> getListeString40ansEtMoins() {
        if (setString == null)
            transformeSetString();
        //	return setString.stream().filter(ArbreGenealogique::filter40Moins).collect(Collectors.toList());

        return null;
    }

    private static boolean filter40Moins(Personne p) {
        return p.getAge() <= 40;

    }


    public void serialize() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(new File("arbre.ser"))))) {
            oos.writeObject(arbre);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Problème lors de la sérialisation...");
        }
    }

    // WARNING ENLEVÉ -- CAST SUR L'OBJET LU
    @SuppressWarnings("unchecked")
    public void deserialize() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(new File("arbre.ser"))))) {
            arbre = (ArbreBinaireDerive<String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problème lors de la désérialisation...");
        }
    }

    @Override
    public String toString() {
        return arbre.toString();
    }
}
