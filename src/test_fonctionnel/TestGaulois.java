package test_fonctionnel;

import java.util.Iterator;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {
	public static void main(String[] args) {
		Gaulois Asterix = new Gaulois("Asterix", 8);
		Gaulois Obelix = new Gaulois("Obelix", 16);
		Romain Minus =  new Romain("Minus", 6);
		Romain Brutus =  new Romain("Brutus", 14);
		Druide Panoramix = new Druide("panoramix", 2);
		Asterix.parler("Bonjour Obelix");
		Obelix.parler("Bonjour Asterix, sanglier manger tout ça tout ça ?");
		Asterix.parler("oui miam");
		System.out.println("foret " + Asterix.getNom() + " et " + Obelix.getNom() + " paf trouver : " + Minus.getNom());
		for (int i = 0; i < 3; i++) {
			Asterix.frapper(Minus);
		}
		Panoramix.fabriquerPotion(4, 3);
		Panoramix.boosterGaulois(Obelix);
		Panoramix.boosterGaulois(Asterix);
		for (int i = 0; i < 3 ; i++) {
			Asterix.frapper(Brutus);			
		}
	}

	@Override
	public String toString() {
		return "TestGaulois []";
	}
}
