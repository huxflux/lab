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
		String[] testOption = {"Endre lonn", "Endre skatteprosent", "Vis info"};
		int elFinito = 0;

		test.setPersonalia("John Inge", "Sivertsvik", 1980);
		test.setArbTakerNr(1);
		test.setAnsattelsesAar(2004);
		test.setMaanedsLonn(30000);
		test.setSkatteProsent(36);

		while (elFinito != -1) {
			switch(showOptionDialog(null, "Velg", "can I haz cheezeburger?", 0, PLAIN_MESSAGE, null, testOption, testOption[0])) {
				case 0:
				test.setMaanedsLonn(Integer.parseInt(showInputDialog(null, "Ny lonn")));
				break;
				case 1:
				test.setSkatteProsent(Integer.parseInt(showInputDialog(null, "Ny skatteprosent")));
				break;
				case 2:
				testString = "Navn: " + test.personalia.getEtternavn() + ", " + test.personalia.getFornavn();
				testString += "\n" + "Fodselsaar: " + test.personalia.getFodselsAar();
				testString += "\n" + "Arbeidstakernummer: " + test.getArbTakerNr();
				testString += "\n" + "Ansettelsesaar: " + test.getAnsettelsesAar();
				testString += "\n" + "Maanedslonn: " + test.getMaanedsLonn();
				testString += "\n" + "Skatteprosent: " + test.getSkatteProsent();
				testString += "\n" + "Skattetrekk pr. maaned: " + test.getSkattPrMaaned();
				testString += "\n" + "Bruttolonn pr. aar: " + test.getBruttoLonn();
				testString += "\n" + "Skattetrekk pr. aar: " + test.getSkattPrAar();
				testString += "\n" + "Alder: " + test.getAlder();
				testString += "\n" + "Antall aar i bedriften: " + test.getAntallAar();
				testString += "\n" + "Ansatt mere enn 5 aar: " + test.getAnsattMerEnn(5);
				showMessageDialog(null, testString);
				break;
				default:
				elFinito = -1;
				System.out.println("AUS!");
				break;
			}
		}



	}
}