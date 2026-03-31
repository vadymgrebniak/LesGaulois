package personnages;

public class Romain {
	private String nom;
	private int force;

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 12);
		System.out.println(minus.getNom());
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

	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;

		int forceRomainDebut = this.force;

		this.force -= forceCoup;

		if (this.force > 0) {
			parler("Aïe");
		} 
		else {
			parler("J'abandonne !");
			this.force = 0;
		}
		
		assert this.force < forceRomainDebut;
	}

	private Boolean isInvariantVerified() {
		return this.force >= 0;
	}

}
