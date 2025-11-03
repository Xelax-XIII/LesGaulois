package test_fonctionnel;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("asterix", 8);
		Gaulois obelix = new Gaulois("obelix", 16);
		Romain minus =  new Romain("minus", 6);
		Romain brutus =  new Romain("brutus", 14);
		Druide panoramix = new Druide("panoramix", 2);
		asterix.parler("Bonjour obelix");
		obelix.parler("Bonjour asterix, sanglier manger tout �a tout �a ?");
		asterix.parler("oui miam");
		System.out.println("foret " + asterix.getNom() + " et " + obelix.getNom() + " paf trouver : " + minus.getNom());
		for (int i = 0; i < 3; i++) {
			asterix.frapper(minus);
		}
		panoramix.fabriquerPotion(4, 3);
		panoramix.boosterGaulois(obelix);
		panoramix.boosterGaulois(asterix);
		for (int i = 0; i < 3 ; i++) {
			asterix.frapper(brutus);			
		}
	}

	@Override
	public String toString() {
		return "TestGaulois []";
	}
}
