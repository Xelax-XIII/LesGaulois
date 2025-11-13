package personnages;

import objet.Equipement;

public class Romain {

	static final String SOLDAT = "Le soldat ";
	private String nom;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement=0;
	private int force;
	private boolean estVainqueur=false;
	
	private void isInvariantVerified(int force) {
		assert(force >= 0);
	}
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		isInvariantVerified(force);
	}

	public boolean estVainqueur() {
		return estVainqueur;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
	    Equipement[] equipementEjecte = null;
	    int oldForce = force;

	    forceCoup = calculResistanceEquipement(forceCoup); // Sera 0 si le coup est paré
	    
	    // On enlève le "if (forceCoup <= 0)" qui était faux
	    
	    force -= forceCoup; // La force diminue (ou reste la même si coup paré)

	    if (force == oldForce && force > 0) {
	        parler("Mon equipement m'a totalement protege.");        
	    } else if (force <= 0 && oldForce > 0){ // S'il meurt VRAIMENT
	        equipementEjecte = ejecterEquipement(); // Il éjecte les trophées
	        parler("J'abandonne...");
	        estVainqueur = true;
	    } else if (force > 0) {
	        parler("aie");
	    }
	    
	    return equipementEjecte; // Retourne les trophées (ou null)
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grâce à mon équipement sa force est diminuée de ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + " !";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup < 0) {
			forceCoup = 0;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	private void ajouterEquipement(int indice, Equipement equipement) {
		System.out.println(SOLDAT + nom + " s'equipe avec un " + equipement);
		equipements[indice]=equipement;
		nbEquipement++;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			ajouterEquipement(0, equipement);
			break;
			
		case 1:
			if ((equipements[0] == equipement) || (equipements[1] == equipement)) {
				System.out.println(SOLDAT + nom + " possede deja un " + equipement + ".");
			}
			else {
				if (equipements[0] == null) ajouterEquipement(0, equipement);
				else ajouterEquipement(1, equipement);
			}
			break;
			
		case 2:
			System.out.println(SOLDAT + nom + " est deja bien protege !");
			break;
			
		default:
			break;
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 4);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}

	public int getForce() {
		return force;
	}
}