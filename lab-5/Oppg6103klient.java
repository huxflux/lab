/*
 * Oppg6103klient.java
 *
 * RANDOM SHIAAAAAT!
 *
 * huxflux
 */

import static javax.swing.JOptionPane.*;

public class Oppg6103klient {
	public static void main(String[] args) {

		String	minString = "";
		String	tallString = "";

		int		antallVerdier = 0;
		int		intOrDouble = 0;
		int		integerMin = 0;
		int		integerMax = 0;
		double	doubleMin = 0;
		double 	doubleMax = 0;

		MinRandom minTest = new MinRandom();

		while (minString != null) {
			try {
				intOrDouble = Integer.parseInt(showInputDialog("1: Integer\n2: Double\nESC: Quit"));
			} catch (Exception e) {
				showMessageDialog(null, "God natt!");
				System.exit(0);
			}

			if (intOrDouble == 1) {
				try {
					integerMin = Integer.parseInt(showInputDialog("Min. verdi: "));
					integerMax = Integer.parseInt(showInputDialog("Max. verdi: "));
					antallVerdier = Integer.parseInt(showInputDialog("Antall tilfeldige verdier: "));
				} catch (Exception e) {
					showMessageDialog(null, "God natt!");
					System.exit(0);
				}
				for (int i = 1; i < antallVerdier + 1; i++) {
					tallString+="Tall " + Integer.toString(i) + ": " + Integer.toString(minTest.nesteHelTall(integerMin, integerMax)) + "\n";
				}
				showMessageDialog(null, tallString);

			} else if (intOrDouble == 2) {
				try {
					doubleMin = Double.parseDouble(showInputDialog("Min. verdi: "));
					doubleMax = Double.parseDouble(showInputDialog("Max. verdi: "));
					antallVerdier = Integer.parseInt(showInputDialog("Antall tilfeldige verdier: "));
				} catch (Exception e) {
					showMessageDialog(null, "God natt!");
					System.exit(0);
				}
				for (int i = 1; i < antallVerdier + 1; i++) {
					tallString+="Tall " + Integer.toString(i) + ": " + Double.toString(minTest.nesteDesimalTall(doubleMin, doubleMax)) + "\n";
				}
				showMessageDialog(null, tallString);
			} else {
				showMessageDialog(null, "1, 2 eller ESC");
			}
			tallString = "";
		}
	}
}