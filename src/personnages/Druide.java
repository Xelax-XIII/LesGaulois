package personnages;

public class Druide {
	private String nom;
	private int force; // present dans le diagramme UML du TP
	private Chaudron chaudron;

	public Druide(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.chaudron = new Chaudron();
	}

	public String getNom() {
		return nom;
	}

	public void fabriquerPotion(int qte, int forcePotion) {
		chaudron.remplirChaudron(qte, forcePotion);
		parler("j'ai concocte " + chaudron.getQte() + " dose de portion magique. Elle a une force de "
				+ chaudron.getForcePotion());
	}

	public void boosterGaulois(Gaulois gaulois) {
		String nomGaulois = gaulois.getNom();
		if (chaudron.resterPotion()) {
			if (nomGaulois != null && nomGaulois.equals("Obelix")) {
				parler("ma belle tu peux pas");
			} else {
				int forcePotion = chaudron.prendreLouche();
				gaulois.boirePotion(forcePotion);
				parler("Tiens " + nomGaulois + " un peu de potion magique");
			}
		} else {
			parler("dsl " + nomGaulois + " j'ai plus potion bro");
		}
	}

	public void parler(String texte) {
		System.out.println(prendreparole() + "\"" + texte + "\"");
	}

	private String prendreparole() {
		return "Le Druide " + nom + " : ";
	}
}
