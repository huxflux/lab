/*
 * Oppg783.java
 *
 * Klient-program! Skriv inn en tekst og faa litt statistikk tilbacks!
 *
 * huxflux
 */

import static javax.swing.JOptionPane.*;
public class Oppg783 {
	public static void main(String[] args) {
		String 	inputString = "";

		while (inputString != null) {
			String 	analyseString = "";
			char	bokstav = ' ';
			Tekstanalyse tekstHelvett = new Tekstanalyse(showInputDialog("Write some text pl0x: "));
			String bokstavBajs = showInputDialog("Hvilken bokstav lurer du paa");
			bokstav = bokstavBajs.charAt(0);

			analyseString += "Antall forskjellige bokstaver: " + tekstHelvett.getAntallForskjelligeBokstaver() + "\n";
			analyseString += "Antall bokstaver i teksten totalt: " + tekstHelvett.getTotaltAntallBokstaver() + "\n";
			analyseString += "Antall forekomster av bokstaven " + bokstav + ": " + tekstHelvett.getAntallBestemtBokstav(bokstav) + "\n";
			analyseString += "Hvor mye av teksten er ikke bokstaver: " + tekstHelvett.getProsentSomIkkeErBokstaver() + "%\n";
			analyseString += "Bokstav(er) som forekommer flest ganger: " + tekstHelvett.getFlestAvBokstav();

			showMessageDialog(null, analyseString);
		}
	}
}