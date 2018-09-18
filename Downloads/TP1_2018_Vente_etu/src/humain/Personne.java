package humain;

public class Personne {

	protected String prenom;
	protected String nom;
	protected int age;

	public Personne() {
	}

	public Personne(String nom, String prenom, int age) {
		super();
		setNom(nom);
		setPrenom(prenom);
		setAge(age);
	}

	public static boolean validerPersonne(String nom, String prenom) {
		return valideNomPrenom(nom) && valideNomPrenom(prenom);
	}

	/**
	 * Modifie le nom. Doit respecter ces criteres (non null, min de 2 caracteres)
	 * 
	 * @param prenom
	 * 
	 */
	public void setNom(String nom) {
		if (valideNomPrenom(nom))
			this.nom = nom;
	}

	/**
	 * Modifie le prenom. Doit respecter ces criteres (non null, min de 2
	 * caracteres)
	 * 
	 * @param prenom
	 * 
	 */
	public void setPrenom(String prenom) {
		if (valideNomPrenom(prenom))
			this.prenom = prenom;
	}

	public static boolean valideNomPrenom(String nomPrenom) {
		return (nomPrenom != null && nomPrenom.length() >= 2);
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAge(String age) {
		this.age = Integer.parseInt(age);
	}

	public int getAge() {
		return age;
	}

	public int getID() {
		return -1;
	}
}
