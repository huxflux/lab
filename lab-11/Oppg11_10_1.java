/*
 * Oppg11_10_1.java
 *
 * Vettafaen !
 *
 * Jajajajajajja... saa jaeeeevlig lei
 *
 */

import static javax.swing.JOptionPane.*;

public class Oppg11_10_1 {
	public static void main(String[] args) {
		ArbTaker test = new ArbTaker();
		String testString = new String();

		test.setPersonalia("John Inge", "Sivertsvik", 1980);
		test.setArbTakerNr(1);
		test.setAnsattelsesAar(2004);
		test.setMaanedsLonn(30000);
		test.setSkatteProsent(36);

		testString = test.personalia.getFornavn() + " " + test.personalia.getEtternavn();
		testString += "\n" + "Fodselsaar: " + test.personalia.getFodselsAar();
		testString += "\n" + "Arbeidstakernummer: " + test.getArbTakerNr();
		testString += "\n" + "Ansettelsesaar: " + test.getAnsettelsesAar();
		testString += "\n" + "Maanedslonn: " + test.getMaanedsLonn();
		testString += "\n" + "Skatteprosent: " + test.getSkatteProsent();
		testString += "\n" + "Skattetrekk pr. maaned: " + test.getSkattPrMaaned();
		testString += "\n" + "Bruttolonn pr. aar: " + test.getBruttoLonn();
		testString += "\n" + "Skattetrekk pr. aar: " + test.getSkattPrAar();
		testString += "\n" + "Navn paa formen wtf: ";
		testString += "\n" + "Alder: " + test.getAlder();
		testString += "\n" + "Antall aar i bedriften: " + test.getAntallAar();
		testString += "\n" + "Ansatt mere enn 5 aar: " + test.getAnsattMerEnn(5);

		showMessageDialog(null, testString);

		/* Menystyrt shit , I CUM SOON, IN YOU FAAAAACE.. BIAAAAAAAAAAAATCH*/


	}
}