package utilitaires;

public class Personne {

	private String prenom;
	private int age;
    private String NAS;

	public Personne() {
	}

	public Personne(String prenom,  int age) {
		super();
		setPrenom(prenom);
		setAge(age);
	}

	public static boolean validerPersonne(String nom, String prenom) {
		return valideNomPrenom(prenom);
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
    public int getNAS() {
        return NAS;
    }
    public void setNAS(String NAS){
        this.NAS = NAS;
    }
    public boolean validerNAS(String NAS) {
        return(NAS != null && NAS.length==9 && this.NAS!=NAS);
    }
    

	@Override
	public String toString() {
		return "Personne [prenom=" + prenom + ", age=" + age + "]";
	}
}
