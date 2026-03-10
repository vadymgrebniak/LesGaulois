package objets;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;
	
	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}
	
	public Boolean restePotion() {
		if (quantitePotion > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int prendreLouche() {
		if (restePotion()) {
			quantitePotion--;
			return forcePotion;
		}
		else {
			quantitePotion = 0;
			return 0;
		}
	}
	
	
}
