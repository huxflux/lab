/*
 * Oppg592.java
 *
 * Klient som bruker klassen Valuta fra Valuta.java (!)
 *
 * huxflux
 */

import static javax.swing.JOptionPane.*;

public class Oppg592 {

	public static void main(String[] args) {

	final double	DOLLAR = 6.07;
	final double	EURO = 8.01;
	final double	SEK = 0.92;
	double			antallEnheter = 0;
	int				valutaType = 0;
	boolean			escape = false;

	Valuta dollar = new Valuta(DOLLAR);
	Valuta euro = new Valuta(EURO);
	Valuta sek = new Valuta(SEK);

	while (!escape) {
		valutaType = Integer.parseInt(showInputDialog("Velg valuta:\n1: dollar\n2: euro:\n3: svenske kroner:\n4: avslutt"));
		if (valutaType < 4) {
			antallEnheter = Double.parseDouble(showInputDialog("Antall enheter:"));
		}

		switch (valutaType) {
			case 1:
				showMessageDialog(null, antallEnheter + " NOK = " + dollar.setTilAnnenValuta(antallEnheter) + " USD\n" +
				antallEnheter + " USD = " + dollar.setTilNorskeKroner(antallEnheter) + " NOK");
				break;
			case 2:
				showMessageDialog(null, antallEnheter + " NOK = " + euro.setTilAnnenValuta(antallEnheter) + " EUR\n" +
				antallEnheter + " EUR = " + euro.setTilNorskeKroner(antallEnheter) + " NOK");
				break;
			case 3:
				showMessageDialog(null, antallEnheter + " NOK = " + sek.setTilAnnenValuta(antallEnheter) + " SEK\n" +
				antallEnheter + " SEK = " + sek.setTilNorskeKroner(antallEnheter) + " NOK");
				break;
			case 4:
				escape = true;
				break;
			default:
				showMessageDialog(null, "Verdier mellom 1-4 dakkdakk");
				break;
			}
		}
	}
}