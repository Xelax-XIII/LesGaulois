package personnages;

public class Chaudron {
	private int qte;
	private int forcePotion;

	public Chaudron() {
	}

	public void remplirChaudron(int qte, int forcePotion) {
		this.qte = qte;
		this.forcePotion = forcePotion;
	}

	public boolean resterPotion() {
		if (qte == 0) {
			return false;
		} else {
			return true;
		}
	}

	public int prendreLouche() {

	}

	public int getQte() {
		return qte;
	}

	public int getForcePotion() {
		return forcePotion;
	}
}
