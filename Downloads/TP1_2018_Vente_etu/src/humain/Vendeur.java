package humain;

public class Vendeur extends Personne {

	private int id;
	private static int nbVendeur = 0;

	public Vendeur(String nom, String prenom, int age) {
		super(nom, prenom, age);
		id = ++nbVendeur;
	}
	
	public int getID() {
		return id;
	}

	@Override
	public String toString() {
		return "Vendeur [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", age=" + age + "]";
	}

}
