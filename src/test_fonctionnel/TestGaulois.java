package test_fonctionnel;

import java.util.Iterator;

import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {
	public static void main(String[] args) {
		Gaulois Asterix = new Gaulois("Asterix", 8);
		Gaulois Obelix = new Gaulois("Obelix", 16);
		Romain Minus =  new Romain("Minus", 6);
		Asterix.parler("Bonjour Obelix");
		Obelix.parler("Bonjour Asterix, sanglier manger tout ça tout ça ?");
		Asterix.parler("oui miam");
		System.out.println("foret " + Asterix.getNom() + " et " + Obelix.getNom() + " paf trouver : " + Minus.getNom());
		for (int i = 0; i < 3; i++) {
			Asterix.frapper(Minus);
		}
	}

	@Override
	public String toString() {
		return "TestGaulois []";
	}
}
