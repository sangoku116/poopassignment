package app;

import java.util.Scanner;

import vente.GestionVentes;
import vente.GestionVentes.OrdreCroissant;
import vente.StatusVente;

public class Application {

	public static void main(String[] args) {

		GestionVentes gestionVentes = new GestionVentes();
		Scanner scan = new Scanner(System.in);
		int entree, idVendeur, idClient, idVente;

		while (true) {
			System.out.println("\n            MENU GESTION VENTES\n");
			System.out.println("1-Ajouter vente en cours");
			System.out.println("2-Conclure vente en cours");
			System.out.println("3-Annuler vente en cours");
			System.out.println("4-Afficher les ventes en cours");
			System.out.println("5-Afficher les ventes conclues");
			System.out.println("6-Afficher les ventes annules");
			System.out.println("7-Afficher le meilleur vendeur selon le nombre de ventes");
			System.out.println("8-Afficher le meilleur vendeur selon le montant total des ventes");
			System.out.println("9-Afficher les vendeurs en ordre croissant d'age");
			System.out.println("10-Afficher les vendeurs en ordre croissant de prenom");
			System.out.println("11-Afficher les vendeurs qui sont dans les 3 maps");
			System.out.println("12-Serialiser les 3 maps");
			// serialiser gestion vente
			System.out.println("13-Deserialiser les 3 maps");
			System.out.println("14-Generer donnees");
			System.out.println("0-Quitter");

			entree = scan.nextInt();
			switch (entree) {

			case 1:
				float prix;
				System.out.println("Entrez l'id du vendeur");
				idVendeur = scan.nextInt();
				System.out.println("Entrez l'id du client");
				idClient = scan.nextInt();
				System.out.println("Entrez le prix de la vente");
				prix = scan.nextFloat();
				gestionVentes.ajouterVenteEnCours(idVendeur, idClient, prix);
				break;
			case 2:
				System.out.println("Entrez l'id du vendeur");
				idVendeur = scan.nextInt();
				System.out.println("Entrez l'id de la vente");
				idVente = scan.nextInt();
				gestionVentes.conclureVente(idVendeur, idVente);
				break;
			case 3:
				System.out.println("Entrez l'id du vendeur");
				idVendeur = scan.nextInt();
				System.out.println("Entrez l'id de la vente");
				idVente = scan.nextInt();
				gestionVentes.annuleVente(idVendeur, idVente);
				break;
			case 4:
				gestionVentes.afficherVentes(StatusVente.EN_COURS);
				break;
			case 5:
				gestionVentes.afficherVentes(StatusVente.CONCLU);
				break;
			case 6:
				gestionVentes.afficherVentes(StatusVente.ANNULE);
				break;
			case 7:
				gestionVentes.afficherMeilleursVendeursNbrVentes();
				break;
			case 8:
				gestionVentes.afficherMeilleursVendeursMontantTotalVentes();
				break;
			case 9:
				gestionVentes.afficherVendeursCroissant(OrdreCroissant.AGE);
				break;
			case 10:
				gestionVentes.afficherVendeursCroissant(OrdreCroissant.PRENOM);
				break;
			case 11:
				gestionVentes.afficherVendeurs3Maps();
				break;
				case 12:
					//serializeJDK7(gestionVentes);
					break;
				//case 13: gestionVentes = (gestionVentes) deserializeJDK7();
					//System.out.println("Allo");
					//break;

			case 14:
				gestionVentes.ajouterVenteEnCours(1, 1, 100);
				gestionVentes.ajouterVenteEnCours(1, 2, 100);
				gestionVentes.ajouterVenteEnCours(1, 3, 100);
				gestionVentes.ajouterVenteEnCours(1, 4, 100);
				gestionVentes.conclureVente(1, 1);
				gestionVentes.annuleVente(1, 2);

				gestionVentes.ajouterVenteEnCours(3, 3, 10);
				gestionVentes.ajouterVenteEnCours(3, 3, 10);
				gestionVentes.ajouterVenteEnCours(3, 8, 10);
				gestionVentes.ajouterVenteEnCours(3, 9, 10);

				gestionVentes.conclureVente(3, 5);
				gestionVentes.conclureVente(3, 6);
				
				gestionVentes.ajouterVenteEnCours(4, 10, 10);
				gestionVentes.ajouterVenteEnCours(4, 11, 10);
				gestionVentes.ajouterVenteEnCours(4, 12, 10);
				gestionVentes.ajouterVenteEnCours(4, 14, 10);

				gestionVentes.afficherVentes(StatusVente.EN_COURS);
				gestionVentes.afficherVentes(StatusVente.CONCLU);
				gestionVentes.afficherVentes(StatusVente.ANNULE);
				break;
			case 0:
				scan.close();
				System.exit(0);
			}
		}
	}
}
