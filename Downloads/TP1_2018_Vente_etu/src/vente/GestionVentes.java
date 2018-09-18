package vente;


import java.util.*;

import humain.Client;
import humain.Generateur;
import humain.Personne;
import humain.Vendeur;

public class GestionVentes {

	public enum OrdreCroissant {
		AGE, PRENOM
	};

	// Set de vente base sur l'id, donc aucune vente en double
	private Map<Vendeur, Set<Vente>> ventesEnCours = new HashMap<>();
	private Map<Vendeur, Set<Vente>> ventesConclues = new HashMap<>();
	private Map<Vendeur, Set<Vente>> ventesAnnulees = new HashMap<>();

	// map des id et des objets relie, evite de faire des rechercher sur des
	// attributs d'un objet cle d'une map.
	private  Map<Integer, Vendeur> ID_VENDEUR = new HashMap<>();
	private  Map<Integer, Client> ID_CLIENT = new HashMap<>();

	private SortedSet<Personne> clientsSet;
	private SortedSet<Personne> vendeursSet;

	public GestionVentes() {
		vendeursSet = Generateur.genererPersonne(Generateur.TypePersonne.VENDEUR);
		for (Personne vendeur : vendeursSet)
			ID_VENDEUR.put(vendeur.getID(), (Vendeur) vendeur);

		clientsSet = Generateur.genererPersonne(Generateur.TypePersonne.CLIENT);
		for (Personne client : clientsSet)
			ID_CLIENT.put(((Client) client).getID(), (Client) client);
	}

	public void ajouterVenteEnCours(int idVendeur, int idClient, float prix) {
		ajouterVenteEnCours(ID_VENDEUR.get(idVendeur), ID_CLIENT.get(idClient), prix);
	}

	public void ajouterVenteEnCours(Vendeur vendeur, Client client, float prix) {
		Set<Vente> venteTemp = null;
		if (ventesEnCours.containsKey(vendeur)){
			venteTemp = ventesEnCours.get(vendeur);
			venteTemp.add(new Vente(client, prix));
		}
		else
		{
			venteTemp = new HashSet<>();
			venteTemp.add(new Vente(client, prix));
			ventesEnCours.put(vendeur, venteTemp);
		}

	}

	public void annuleVente(int idVendeur, int idVente) {
	//	annuleVente(ID_VENDEUR.get(idVendeur), (Vente) ventesEnCours.get(idVente));
	//	annuleVente(ID_VENDEUR.get(idVendeur), idVente);

	}

	public void annuleVente(Vendeur vendeur, Vente vente) {
		Set<Vente> venteTemp = null;
		if (ventesAnnulees.containsKey(vendeur)) {
			venteTemp = ventesAnnulees.get(vendeur);
			venteTemp.add(vente);

		} else {
			venteTemp = new HashSet<>();
			venteTemp.add(vente);
			ventesAnnulees.put(vendeur, venteTemp);


		}
	}

	public void conclureVente(int idVendeur, int idVente) {
		conclureVente(ID_VENDEUR.get(idVendeur), (Vente) ventesEnCours.get(idVente));
	}

	public void conclureVente(Vendeur vendeur, Vente vente) {

	}

	public void afficherVentes(StatusVente statusVente) {
		System.out.println("VENTES EN COURS :");
		if(statusVente.equals(StatusVente.EN_COURS))
		{
			System.out.println(ventesEnCours);
		}
		else if (statusVente.equals(StatusVente.CONCLU))
		{
			System.out.println(ventesConclues);
		}
		else if(statusVente.equals(StatusVente.ANNULE)){
			System.out.println(ventesAnnulees);
		}
	}

	//public void afficherVendeurs() {
	//}

	//public void afficherClients() {
	//}

	public void afficherVendeursCroissant(OrdreCroissant ordre) {
	}

	public void afficherVendeurs3Maps() {
	}

	public void afficherMeilleursVendeursNbrVentes() {
	}

	public void afficherMeilleursVendeursMontantTotalVentes() {
	}
}
