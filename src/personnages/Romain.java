package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", -6);
		System.out.println(minus.getNom());
		
	}

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified() == true;		
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
		this.force -= forceCoup;
		if (this.force > 0) {
			parler("Aïe");
		}
		else {
			parler("J'abandonne !");
			force = 0;
		}
	}
	
	private Boolean isInvariantVerified() {
		if (force >= 0) {
			
			return true;
		}
		else {
			return false;
		}
	}
	
}
