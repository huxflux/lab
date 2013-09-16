/*
 * Oppg593.java
 *
 * Bruker Spiller.java
 * Du skal programmere terningspillet 100 med 2 spillere, A og B.
 * Blablablablablablablaaaaaaaaaaa.
 *
 * huxflux
 */

import static javax.swing.JOptionPane.*;

public class Oppg593 {
	public static void main(String[] args) {

		final int			POENGSUM = 100;
		final int			TYPE_OF_DICE = 6;
		int					runde = 1;

		Spiller spillerA = new Spiller(POENGSUM);
		Spiller spillerB = new Spiller(POENGSUM);

		while (!spillerA.isFerdig() && !spillerB.isFerdig()) {
			spillerA.kastTerningen(TYPE_OF_DICE);
			spillerB.kastTerningen(TYPE_OF_DICE);
			System.out.println("Spiller A Runde " + runde + ": " + spillerA.getSumPoeng());
			System.out.println("Spiller B Runde " + runde + ": " + spillerB.getSumPoeng());
			runde++;
		}

		if (spillerA.isFerdig()) {
			showMessageDialog(null, "Spiller A vant i runde " + runde + " med " + spillerA.getSumPoeng() + " poeng!");
		} else {
			showMessageDialog(null, "Spiller B vant i runde " + runde + " med " + spillerB.getSumPoeng() + " poeng!");
		}

	}
}