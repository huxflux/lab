/*
 * Oppg6102klient.java
 *
 * Klient for brok-klassen
 *
 * huxflux
 */

import static javax.swing.JOptionPane.*;

public class Oppg6102klient {
	public static void main(String[] args) {

		int			teller = 4;
		int			nevner = 5;
		int			teller2 = 3;
		int			nevner2 = 2;

		Brok minBrok = new Brok(teller, nevner);
		Brok minBrok2 = new Brok(teller2, nevner2);
		minBrok.multipliser(minBrok2);
		showMessageDialog(null, minBrok.toString());

		Brok minBrok3 = new Brok(teller, nevner);
		minBrok3.divider(minBrok2);
		showMessageDialog(null, minBrok3.toString());

		Brok minBrok4 = new Brok(teller, nevner);
		minBrok4.adder(minBrok2);
		showMessageDialog(null, minBrok4.toString());

		Brok minBrok5 = new Brok(teller, nevner);
		minBrok5.subtraher(minBrok2);
		showMessageDialog(null, minBrok5.toString());

	}
}