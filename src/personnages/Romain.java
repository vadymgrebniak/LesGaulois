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

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;

		int forceRomainDebut = this.force;

		this.force -= forceCoup;

		if (this.force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne !");
			this.force = 0;
		}

		assert this.force < forceRomainDebut;
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

}
