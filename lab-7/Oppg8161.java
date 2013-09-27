/*
 * Oppg8161.java
 *
 * Klient blablabla
 *
 * huxfuckshit
 */

import static javax.swing.JOptionPane.*;

public class Oppg8161 {
	public static void main(String[] args) {
		String		basjString = "";
		NyString 	minString = new NyString(showInputDialog("Skriv inn den satans teksten din: "));

		basjString = "Din tekst: " + minString.getOriginalString() + "\n";
		basjString += "F0rstebokstav i hvert ord: " + minString.getForkortString() + "\n";
		basjString += "Tekst uten valgt bokstav: " + minString.getFjernTegnString(showInputDialog("Hvilken bokstav skal d0? : "));

		showMessageDialog(null, basjString);
	}
}