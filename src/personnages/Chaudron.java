package personnages;

public class Chaudron {
	private int qte;
	private int forcePotion;
	public void remplirChaudron(int qte, int forcePotion) {
		this.qte = qte;
		this.forcePotion = forcePotion;
	}

	public boolean resterPotion() {
		return qte != 0;
	}

	public int prendreLouche() {
		if (qte == 0) {
			forcePotion = 0;
			return 0;
		} else {
			qte = qte - 1;
			return forcePotion;
		}
	}

	public int getQte() {
		return qte;
	}

	public int getForcePotion() {
		return forcePotion;
	}
}
