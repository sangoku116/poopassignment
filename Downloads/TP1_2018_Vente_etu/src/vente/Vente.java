package vente;

import humain.Client;

public class Vente {
	
	private int idVente;
	private Client client;
	private static int nbVentes = 0;
	private float prix;
	
	public Vente(Client client, float prix) {
		idVente = ++nbVentes;
		this.client = client;
		this.prix = prix;
	}

	public int getID() {
		return idVente;
	}

	public Client getClient() {
		return client;
	}


	@Override
	public String toString() {
		return "Vente [idVente=" + idVente + ", client=" + client + ", prix=" + prix + "]";
	}

	public float getPrix() {
		return prix;
	}
}
