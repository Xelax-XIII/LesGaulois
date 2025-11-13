package personnages;
import objet.Equipement;
import lieux.Musee;
import lieux.Village;

public class Gaulois {

	private String nom;
	private int effetPotion = 1;
	private Village village = null;
	
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	private void isInvariantVerified(int force) {
		assert(force >= 0);
	}

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		isInvariantVerified(force);
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
	    return "Le gaulois " + nom + " : ";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
	}
	
	public void frapper(Romain romain) {
	    System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
	    Equipement[] trophee = romain.recevoirCoup((force / 3) * effetPotion);
	    if (effetPotion > 1) {
	        effetPotion--;
	    }
	    for (int i = 0; trophee != null && i < trophee.length; i++, nbTrophees++) {
	        this.trophees[nbTrophees] = trophees[i];
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
	
	public void faireUneDonation(Musee musee) {
		if (nbTrophees > 0) {
			parler("je fait don au musee de tout mes trophees :");
			for (int i = 0; i < nbTrophees; i++) {
				musee.donnerTrophees(this, trophees[i]);
				System.out.println("- " + trophees[i]);
				trophees[i] = null;
			}
			nbTrophees = 0;
		} else {
			parler("je n'ai rien a donner au musee :/");
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
