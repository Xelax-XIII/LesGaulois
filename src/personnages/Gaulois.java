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
		Gaulois Asterix = new Gaulois("Asterix", 8);
		System.out.println(Asterix);
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup((force*effetPotion)/3); 
		if (effetPotion == 1) {
			;
		} else {
			effetPotion -= 1;
		}
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}
	
	public void sePresenter() {
		if (village == null) {
			parler("Bonjour, je m'appelle "+nom+". Je voyage de villages en villages");
		}
		else if (this == village.getChef()) {
			parler("Bonjour, je m'appelle "+nom+". Je suis le chef du village "+village.getNom()+".");
		}
		else {
			parler("Bonjour, je m'appelle "+nom+". Je suis un habitant du village "+village.getNom()+".");
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
