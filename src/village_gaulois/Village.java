package village_gaulois;

import personnages.Gaulois;

public class Village {
	private String nom;
	private Gaulois chef;
	private int nbVillageois = 0;

	private Gaulois[] villageois;

	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois doublepolemix = new Gaulois("Doublepolémix", 4);

		Village village = new Village("Village des Irréductibles", abraracourcix, 30);
		village.trouverVillageois(30);
		village.ajouterVillageois(asterix);
		village.ajouterVillageois(obelix);

		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);

		village.afficherVillageois();
		
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublepolemix.sePresenter();
	}

	public Village(String nom, Gaulois chef, int nbVillageoisMax) {
		this.nom = nom;
		this.chef = chef;
		chef.setVillage(this);
		villageois = new Gaulois[nbVillageoisMax];
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
		gaulois.setVillage(this);
	}

	public Gaulois trouverVillageois(int numVillageois) {
		numVillageois--;

		if (numVillageois < 0 || numVillageois >= nbVillageois || villageois[numVillageois] == null) {
			System.out.println("Il n’y a pas autant d’habitants dans notre village !");
			return null;
		} else {
			return villageois[numVillageois];
		}
	}

	public void afficherVillage() {

	}

	public void afficherVillageois() {
		System.out.println(
				"Dans le village \"" + nom + "\" du chef " + chef.getNom() + " vivent les légendaires gaulois :");

		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}

}
