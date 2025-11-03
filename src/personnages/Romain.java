package personnages;
import objet.Equipement;

public class Romain {

	private String nom;
	private Equipement equipements[] = new Equipement[2];
	private int nbEquipement=0;
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
	
	private void ajouterEquipement(int indice, Equipement equipement) {
		System.out.println("Le soldat " + nom + " s'equipe avec un " + equipement);
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
				System.out.println("Le soldat " + nom + " possede deja un " + equipement + ".");
			}
			else {
				if (equipements[0] == null) ajouterEquipement(0, equipement);
				else ajouterEquipement(1, equipement);
			}
			break;
			
		case 2:
			System.out.println("Le soldat " + nom + " est deja bien protege !");
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
}