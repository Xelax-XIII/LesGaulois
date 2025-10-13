package personnages;

import lieux.Village;

public class Gaulois {

	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village = null;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreparole() + "\"" + texte + "\"");
	}

	private String prendreparole() {
		return "Le Gaulois " + nom + " : ";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup((force * effetPotion) / 3);
		if (effetPotion != 1) {
			effetPotion -= 1;
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void sePresenter() {
		final String PRESENTATION = "Bonjour, je m'appelle ";
		if (village == null) {
			parler(PRESENTATION + nom + ". Je voyage de villages en villages");
		} else if (this == village.getChef()) {
			parler(PRESENTATION + nom + ". Je suis le chef du village " + village.getNom() + ".");
		} else {
			parler(PRESENTATION + nom + ". Je suis un habitant du village " + village.getNom() + ".");
		}
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
	}

	public void setVillage(Village village) {
		this.village = village;
	}
}
