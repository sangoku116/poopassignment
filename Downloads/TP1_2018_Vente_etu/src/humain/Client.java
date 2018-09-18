package humain;

public class Client extends Personne {

	private int id;
	private static int nbClients = 0;

	public Client(String nom, String prenom,  int age) {
		super(nom, prenom,  age);
		id = ++nbClients;
	}

	public int getID() {
		return id;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", age=" + age + "]";
	}
}
 