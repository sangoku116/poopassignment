package utilitaires;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Sylvain Tremblay
 * 
 */
public class ArbreBinaireDerive<T> implements Serializable{
	private static final long serialVersionUID = 7347680253363846884L;
	/**
	 * le premier noeud
	 */
	private NoeudArbreDerive<T> racine = null;

	/**
	 * Constructeur
	 */
	public ArbreBinaireDerive() {
		racine = null;
	}

	/**
	 * verifie si l'arbre est vide
	 * 
	 * @return boolean, vrai si l'arbre est vide
	 */
	public boolean arbreVide() {
		return racine == null;

	}

	/**
	 * Vide l'arbre
	 */
	public void vider() {
		racine = null;
		System.gc();
	}

	/**
	 * Methode interne utilitaire qui retourne la reference au noeud dont l'element
	 * contient obj.
	 * 
	 * @param actuel
	 *            le noeud actuel
	 * @param obj
	 *            l'objet contenu dans le noeud recherché
	 * 
	 * @return NoeudArbreDerive, le noeud recherché, ou null si pas trouvé
	 */
	private NoeudArbreDerive<T> rechercherNoeud(NoeudArbreDerive<T> actuel, T obj) {
		NoeudArbreDerive<T> retour = null;

		// Si le noeud actuel n'est pas null
		if (actuel != null) {
			// Si le noeud actuel est le noeud recherché
			if (actuel.getElement().equals(obj)) {
				retour = actuel;
			} else {
				// Rechercher avec le noeud fils du noeud actuel
				retour = rechercherNoeud(actuel.getFils(), obj);

				// Rechercher avec le noeud frère du noeud actuel
				if (retour == null) {
					retour = rechercherNoeud(actuel.getFrere(), obj);
				}
			}
		}

		return retour;
	}

	/**
	 * Methode interne utilitaire qui retourne la reference au noeud dont l'attribut
	 * fils ou l'attribut frere qui refere a obj (en relite, au noeud qui contient
	 * obj); Par exemple, en cas de suppression d'un noeud, cette reference
	 * permettra a la methode supprimer de rattacher les noeuds restants a l'arbre
	 * 
	 * @param actuel
	 *            Noeud actuel
	 * @param obj
	 *            l'objet contenu dans le noeud recherche
	 * 
	 * @return NoeudArbreDerive, un pointeur sur le noeud precedent si trouve, ou
	 *         null si pas trouve
	 */
	private NoeudArbreDerive<T> rechercherPrec(NoeudArbreDerive<T> actuel,
											   T obj)
	{
		NoeudArbreDerive<T> retour = null;

		if (actuel != null)
		{
			// Si le fils du noeud actuel est le noeud contenant
			// l'objet recherché
			if ((actuel.getFils() != null)
					&& (actuel.getFils().getElement().equals(obj)))
			{
				retour = actuel;
			}
			else
			{
				// Si le noeud frere du noeud actuel est le noeud
				// contenant l'objet recherche
				if (actuel.getFrere() != null
						&& actuel.getFrere().getElement().equals(obj))
				{
					retour = actuel;
				}
				// Si le noeud rechercher n'est ni le fils, ni le
				// frere du noeud actuel
				else
				{
					// Rechercher avec le fils du noeud actuel
					if (actuel.getFils() != null)
					{
						retour = rechercherPrec(actuel.getFils(), obj);
					}
					// Rechercher avec le noeud frere du noeud actuel
					if ((retour == null) && (actuel.getFrere() != null))
					{
						retour = rechercherPrec(actuel.getFrere(), obj);
					}
				}
			}
		}

		return retour;
	}

	/**
	 * Methode interne utilitaire qui retourne la reference au parent du noeud
	 * contenant obj.
	 * 
	 * @param actuel
	 *            le noeud actuel
	 * @param obj
	 *            l'objet du noeud rechercher
	 * 
	 * @return NoeudArbreDerive, un pointeur sur le noeud parent si trouve, sinon,
	 *         null
	 */
	private NoeudArbreDerive<T> rechercherParent(NoeudArbreDerive<T> actuel,
												 T obj)
	{
		NoeudArbreDerive<T> parent = null;
		NoeudArbreDerive<T> temp = null;

		if (actuel != null)
		{
			// Boucle pour verifier si le noeud actuel est parent
			// du noeud contenant obj
			temp = actuel.getFils();
			while ((temp != null) && !temp.getElement().equals(obj))
			{
				temp = temp.getFrere();
			}

			// Si l'element d'un des fils du noeud actuel
			// correspond a obj
			if ((temp != null) && temp.getElement().equals(obj))
			{
				parent = actuel;
			}
			else
			{
				// Sinon, rechercher avec le noeud fils du noeud
				// actuel
				parent = rechercherParent(actuel.getFils(), obj);

				// Si le retour est null, rechercher avec le
				// frere du noeud actuel
				if (parent == null)
				{
					parent = rechercherParent(actuel.getFrere(), obj);
				}
			}
		}

		return parent;
	}

	/**
	 * Savoir si un noeud existe dans l'arbre
	 * 
	 * @param obj
	 *            Objet recherche
	 * 
	 * @return boolean, vrai si l'element obj appartient a l'arbre, faux sinon
	 */
	public boolean existe(T obj) {
		// Vrai si la recherche retourne quelque chose, faux sinon
		return (rechercherNoeud(this.racine, obj) != null);
	}

	/**
	 * Sert a ajouter un noeud a l'arbre; ce nouveau noeud contiendra obj; son
	 * parent dans l'arbre est pParent mais obj n'est pas forcement le premier
	 * enfant de paramParent! Retourne
	 * 
	 * @param obj
	 *            objet a ajouter
	 * @param pParent
	 *            objet parent ou le noeud doit etre ajoute
	 * 
	 * @return boolean, vrai si reussite et faux sinon.
	 */
	public boolean ajouter(T obj,T  pParent) {
		boolean reussite = true;
		NoeudArbreDerive<T> temp;
		if (pParent == null)
		{
			if (racine == null)
			{
				racine = new NoeudArbreDerive<T>(obj);
			}
			else
			{
				temp = racine;
				while (temp.getFrere() != null)
				{
					temp = temp.getFrere();
				}
				temp.setFrere(new NoeudArbreDerive<T>(obj));

			}
		}
		else if (obj != null)
		{
			if (existe(pParent))
			{
				temp = rechercherNoeud(racine, pParent);
				if (temp.getFils() != null)
				{
					temp = temp.getFils();
					while (temp.getFrere() != null)
					{
						temp = temp.getFrere();
					}
					temp.setFrere(new NoeudArbreDerive<T>(obj));
				}
				else
				{
					temp.setFils(new NoeudArbreDerive<T>(obj));
				}

			}
			else
				reussite = false;
		}
		return reussite;
	}

	/**
	 * Methode qui met a jour l'element du noeud recherche avec le nouvel
	 * element recu
	 * 
	 * @param actuel
	 *            le noeud actuel
	 * @param obj
	 *            l'objet contenu dans le noeud recherche
	 * @param newObj
	 *            le nouveau contenu du noeud recherche
	 * 
	 * @return si la mise a jour a reussit
	 */
	private boolean mettreAJour(NoeudArbreDerive actuel, T obj, T newObj) {
		boolean reussite = false;

		// Si le noeud actuel n'est pas null
		if (actuel != null) {
			// Si le noeud actuel est le noeud recherche
			if (actuel.getElement().equals(obj)) {
				actuel.setElement(newObj);
				reussite = true;
			} else {
				// rechercher avec le noeud fils du noeud actuel
				reussite = mettreAJour(actuel.getFils(), obj, newObj);

				// rechercher avec le noeud frere du noeud actuel
				if (!reussite) {
					reussite = mettreAJour(actuel.getFrere(), obj, newObj);
				}
			}
		}

		return reussite;
	}

	/**
	 * Enlever de l'arbre le noeud contenant obj. S'il a des descendants, ils
	 * doivent etre aussi supprimes; pas ses freres.
	 * 
	 * @param obj
	 *            Objet à supprimer
	 * 
	 * @return vrai si reussite et faux sinon.
	 */
	public boolean supprimer(T obj) {
		// Rechercher le noeud a supprimer
		NoeudArbreDerive recherche = rechercherNoeud(this.racine, obj);
		NoeudArbreDerive noeudPrec = null;
		boolean reussite = false;

		// Si le noeud a supprimer existe
		if (recherche != null) {
			// Rechercher le noeud precedent
			noeudPrec = rechercherPrec(this.racine, obj);

			// Si le noeud precedent est le pere du noeud à
			// supprimer
			if ((noeudPrec.getFils() != null) && recherche.getElement().equals(noeudPrec.getFils().getElement())) {
				// Prend le premier frere
				noeudPrec.setFils(recherche.getFrere());
			}

			// Si il est le frere du noeud a supprimer
			else {
				noeudPrec.setFrere(recherche.getFrere());
			}

			// La suppression est reussite
			reussite = true;
		}

		return reussite;
	}

	/**
	 * Retourne une chaine contenant le contenu de l'arbre
	 * 
	 * @return String le contenu de l'arbre
	 */
	public String toString() {
		String chaine = "";
		int niveau = 0; // le niveau permettra de gerer
						// l'indentation dans la chaine.

		chaine = assistantRecursif(this.racine, niveau);

		return chaine;
	}

	/**
	 * Methode recursive qui ajoute les elements de l'arbre a la chaine de
	 * caractaires ch retournee a la fin de la methode. Cette methode est appelee
	 * par la methode precedente. Cette methode utilise un parcours prefixe
	 * 
	 * @param noeud
	 *            le noeud actuel
	 * @param niveau
	 *            le niveau du noeud actuel
	 * @return la chaine contenant tout les noeud en dessous du noeud actuel
	 */
	private String assistantRecursif(NoeudArbreDerive<T> noeud, int niveau)
	{
		String chaine = "";

		if (noeud != null)
		{
			for (int i = 0; i < niveau; i++)
			{
				chaine += "\t";
			}

			chaine += noeud.getElement() + "\n";
			chaine += assistantRecursif(noeud.getFils(), niveau + 1);
			chaine += assistantRecursif(noeud.getFrere(), niveau);
		}
		return chaine;
	}

	/**
	 * Appel du parcours recursif prefixe
	 * 
	 */
	public String parcoursPrefixe() {
		return prefixe(this.racine);
	}

	/**
	 * Appel du parcours recursif infixe
	 * 
	 */
	public String parcoursInfixe() {
		return infixe(this.racine);
	}

	/**
	 * Appel du parcours recursif suffixe
	 * 
	 */
	public String parcoursSuffixe() {
		return suffixe(this.racine);
	}

	public List<String> getListeElement()
	{
		return ajouterDansListeElement(racine, new ArrayList<>());
	}
	public List<String> ajouterDansListeElement(NoeudArbreDerive<T> noeud,
												List<String> pListe)
	{
		if (noeud != null)
		{
			pListe.add(noeud.getElement().toString());
			ajouterDansListeElement(noeud.getFils(), pListe);
			ajouterDansListeElement(noeud.getFrere(), pListe);
		}
		return pListe;
	}


	/**
	 * Methodes privees pour le parcours recursif prefixe
	 * 
	 */
	private String prefixe(NoeudArbreDerive<T> nCourant)
	{
		String chaine = "";

		if (nCourant != null)
		{
			chaine += nCourant.getElement() + ", ";

			chaine += prefixe(nCourant.getFils());
			chaine += prefixe(nCourant.getFrere());
		}

		return chaine;
	}


	/**
	 * Methodes privees pour le parcours recursif infixe
	 * 
	 */
	private String infixe(NoeudArbreDerive<T> nCourant)
	{
		String chaine = "";

		if (nCourant != null)
		{

			chaine += infixe(nCourant.getFils());
			chaine += nCourant.getElement() + ", ";
			chaine += infixe(nCourant.getFrere());

		}

		return chaine;
	}


	/**
	 * Methodes privees pour le parcours recursif suffixe
	 */
	private String suffixe(NoeudArbreDerive nCourant) {
		String chaine = "";

		if (nCourant != null) {
			chaine += suffixe(nCourant.getFils());
			chaine += suffixe(nCourant.getFrere());
			chaine += nCourant.getElement() + ", ";
		}

		return chaine;
	}

	/**
	 * Tests unitaires
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArbreBinaireDerive arbre = new ArbreBinaireDerive();

		arbre.ajouter(new Character('W'), null);
		arbre.ajouter(new Character('N'), null);
		arbre.ajouter(new Character('K'), null);
		arbre.ajouter(new Character('P'), null);
		arbre.ajouter(new Character('F'), new Character('W'));
		arbre.ajouter(new Character('G'), new Character('W'));
		arbre.ajouter(new Character('D'), new Character('F'));
		arbre.ajouter(new Character('S'), new Character('F'));
		arbre.ajouter(new Character('Z'), new Character('S'));
		arbre.ajouter(new Character('J'), new Character('P'));
		arbre.ajouter(new Character('M'), new Character('J'));
		arbre.ajouter(new Character('C'), new Character('M'));

		System.out.println(arbre);
		System.out.println(arbre.parcoursPrefixe());
		System.out.println(arbre.parcoursInfixe());
		System.out.println(arbre.parcoursSuffixe());

		System.out.println(arbre.rechercherPrec(arbre.racine, new Integer(4)));

		System.out.println("Ajouter element:");
		arbre.ajouter(new Integer(1), null);
		arbre.ajouter(new Integer(2), new Integer(1));
		arbre.ajouter(new Integer(3), new Integer(1));
		arbre.ajouter(new Integer(4), new Integer(2));
		arbre.ajouter(new Integer(5), new Integer(3));
		arbre.ajouter(new Integer(6), new Integer(2));
		arbre.ajouter(new Integer(10), new Integer(2));
		arbre.ajouter(new Integer(11), new Integer(2));
		arbre.ajouter(new Integer(7), new Integer(3));
		arbre.ajouter(new Integer(8), new Integer(4));
		arbre.ajouter(new Integer(9), new Integer(5));
		System.out.println(arbre);

		System.out.println("Supprimer element:");
		arbre.supprimer(new Integer(5));
		arbre.supprimer(new Integer(8));
		System.out.println(arbre);

		System.out.println("Rechercher parent:");
		System.out.println(arbre.rechercherParent(arbre.racine, new Integer(4)).getElement());
		System.out.println(arbre.rechercherParent(arbre.racine, new Integer(6)).getElement());
		System.out.println(arbre.rechercherParent(arbre.racine, new Integer(10)).getElement());
		System.out.println(arbre.rechercherParent(arbre.racine, new Integer(11)).getElement());
		System.out.println(arbre.rechercherParent(arbre.racine, new Integer(2)).getElement());
		System.out.println(arbre.rechercherParent(arbre.racine, new Integer(3)).getElement());
		System.out.println(arbre.rechercherParent(arbre.racine, new Integer(7)).getElement());

		System.out.println("Mettre a jour element:");
		System.out.println(arbre.mettreAJour(arbre.racine, new Integer(7), new Integer(9)));
		System.out.println(arbre);
		System.out.println(arbre.mettreAJour(arbre.racine, new Integer(7), new Integer(9)));
		System.out.println(arbre);

		System.out.println("Rechercher parent:");
		System.out.println(arbre.rechercherParent(arbre.racine, new Integer(9)).getElement());

	}
}
