package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1; 

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	public void frapper(Romain romain) {
		String nomRomain = romain.getNom();
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + nomRomain);
		
		int forceCoup = force * effetPotion / 3;
		romain.recevoirCoup(forceCoup);
		
		effetPotion--;
		if (effetPotion < 1 ) {
			effetPotion = 1;
		}
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
	}

	private String prendreParole() {
		return "Le Gaulois " + nom + " : ";
	}
}
