package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	int nbEquipement = 0;

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 12);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
	}

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculerResistanceEquipement(forceCoup);
		force -= forceCoup;

		if (force == 0) {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		} else {
			parler("Aïe");
		}

		return equipementEjecte;
	}

	public void sEquiper(Equipement equipement) {
		Boolean isEquiped = false;

		switch (nbEquipement) {
		case 0:
			equipements[0] = equipement;
			isEquiped = true;
			break;

		case 1:
			if (equipements[0] == equipement) {
				System.out.println(adresserSoldat() + " possède déjà un " + equipement.toString() + ".");
			} else {
				equipements[1] = equipement;
				isEquiped = true;
			}
			break;

		case 2:
			System.out.println(adresserSoldat() + " est déjà bien protégé !");
			break;

		default:
			System.out.println("nbEquipement n'est pas valdie !");
		}

		if (isEquiped) {
			System.out.println(adresserSoldat() + " s’équipe avec un " + equipement.toString() + ".");
			nbEquipement++;
		}
	}

	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}

	private String adresserSoldat() {
		return "Le soldat " + this.nom;
	}

	private Boolean isInvariantVerified() {
		return this.force >= 0;
	}

	private int calculerResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;

		if (nbEquipement != 0) {
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null) {
					if (equipements[i].equals(Equipement.BOUCLIER)) {
						resistanceEquipement += 6;
					} else {
						resistanceEquipement += 3;
					}
				}
			}
		}

		texte += "\nMais heureusement, grace à mon équipement sa force ";
		forceCoup -= resistanceEquipement;

		if (forceCoup < 0) {
			forceCoup = 0;
			texte += "a été complètement absorbée.";
		} else {
			texte += "est diminué de " + resistanceEquipement + "!";
		}

		parler(texte);

		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}

		return equipementEjecte;
	}

	public int getForce() {
		return this.force;
	}

}
