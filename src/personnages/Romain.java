package personnages;

public class Romain {

	private String nom;
	private int force;
	
	private void isInvariantVerified(int force) {
		assert(force >= 0);
	}
	
	public Romain(String nom, int force) {
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
	
	public void recevoirCoup(int forceCoup) {
		int forceTemp = force;
		force = force - forceCoup;
		assert(forceTemp > force);
		
		if (force < 1) {
			parler("J'abandonne !");
		}
		else {
			parler("aie");
		}
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

}
