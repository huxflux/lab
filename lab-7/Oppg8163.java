/*
 * Oppg8163.java
 *
 * Klient
 *
 * suckstobefucksflux
 */

import static javax.swing.JOptionPane.*;

public class Oppg8163 {
	public static void main(String[] args) {
		String 	outputString = "";

		TekstBehandling myText = new TekstBehandling(showInputDialog("Type some mumbojumbo pl0x: "));
		String wordToReplace = showInputDialog("Hvilket ord vil du erstatte: ");
		String wordReplace = showInputDialog(wordToReplace + " skal erstattes med: ");

		outputString += "Original tekst: " + myText.getOriginalString() + "\n";
		outputString += "Store bokstaver: " + myText.getOriginalStringUpperCase() + "\n";
		outputString += wordToReplace + " erstattes med " + wordReplace + ": " + myText.getStringWithWordChange(wordToReplace, wordReplace) + "\n";
		outputString += "Antall ord: " + myText.getAmountOfWords() + "\n";
		outputString += "Gjennomsnittlig ordlengde: " + myText.getAverageWordLength() + "\n";
		outputString += "Gjennomsnittlig ord per periode: " + myText.getAverageWordsSkitFaen();

		showMessageDialog(null, outputString);
	}
}