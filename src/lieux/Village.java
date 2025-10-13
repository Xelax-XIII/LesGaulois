package lieux;

import personnages.Gaulois;

public class Village {
	public Village(Gaulois chef, String nom, int nbVillageoisMax) {
		this.chef = chef;
		this.nom = nom;
		this.nbVillageoisMax = nbVillageoisMax;
		this.chef.setVillage(this);
		this.villageois = new Gaulois[nbVillageoisMax];
	}
	
	private int nbVillageoisMax ;
	private Gaulois chef;
	private String nom;
	private int nbVillageois=0;
	private Gaulois[] villageois;
	
	public String getNom() {
		return nom;
	}
	public int getNbVillageois() {
		return nbVillageois;
	}
	public Gaulois getChef() {
		return chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois < nbVillageoisMax) {
			villageois[nbVillageois]=gaulois;
			nbVillageois++;
			gaulois.setVillage(this);
		}
	}
	
	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois <= 0 || numVillageois > nbVillageois) {
			System.out.println("Il n'y a pas autant d'habitants dans le village !");
			return null;
		} else {
			return villageois[numVillageois-1];
		}
	}
	
	public void afficherVillage() {
		System.out.println("dans le village : \""+nom+"\" du chef "+chef.getNom()+" vivent les legendaires gaulois :");
		for (Gaulois gaulois : villageois) {
			if (gaulois != null) {
				System.out.println("- "+gaulois.getNom());
			}
		}
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village(abraracourcix, "Village des irr�ductibles", 30);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterVillageois(asterix);
		asterix.setVillage(village);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		village.afficherVillage();
		Gaulois obelix = new Gaulois("Obelix", 25);
		Gaulois doublepolemix = new Gaulois("Doublepolemix", 4);
		village.ajouterVillageois(obelix);
		asterix.sePresenter();
		abraracourcix.sePresenter();
		obelix.sePresenter();
		doublepolemix.sePresenter();
	}
}
