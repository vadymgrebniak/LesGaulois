package personnages;

import village_gaulois.Musee;
import village_gaulois.Village;
import objets.Equipement;
import objets.Trophee;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Village village;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void sePresenter() {
		if (village == null) {
			parler("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
		} else if (village.getChef() == this) {
			parler("Bonjour, je m'appelle " + nom + ". Je suis le chef du village : " + village.getNom() + ".");
		} else {
			parler("Bonjour, je m'appelle " + nom + ". J'habite le village : " + village.getNom() + ".");
		}
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesRomain = romain.recevoirCoup((force / 2) * effetPotion);
		effetPotion--;
		if (effetPotion < 1) {
			effetPotion = 1;
		}
		for (int i = 0; tropheesRomain != null && i < tropheesRomain.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesRomain[i];
		}
	}
	
	public void faireUneDonnation(Musee musee) {
		if (nbTrophees != 0) {
			parler("Je donne au musee tous mes trophees :");
			for (int i = 0; i < nbTrophees; i++) {
				System.out.println("- " + trophees[i].toString());
				musee.donnerTrophees(this, trophees[i]);
				trophees[i] = null;
			}
		}
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
}
