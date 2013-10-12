/*
 * Tekstanalyse.java
 *
 * Klasse for Oppg783.java. Finner ut endel ting&tang om teksten.
 *
 * huxflux
 */

public class Tekstanalyse {
	private int[]	antallTegn = new int[30];			// [0-28] a-z/A-Z, [29] alle andre tegn.
	private String	inputString = "";

	public Tekstanalyse (String inputString) {
		this.inputString = inputString;
		analyserTekst();
	}

	public int getAntallForskjelligeBokstaver() {
		int antallBokstaver = 0;
		for (int i = 0; i < antallTegn.length - 1; i++) {
			if (antallTegn[i] != 0) {
				antallBokstaver++;
			}
		}
		return antallBokstaver;
	}

	public int getTotaltAntallBokstaver() {
		int antallBokstaverTilSammen = 0;
		for (int i = 0; i < antallTegn.length - 1; i++) {
			antallBokstaverTilSammen += antallTegn[i];
		}
		return antallBokstaverTilSammen;
	}

	public String getFlestAvBokstav () {
		String bokstaver = "";
		int maxVerdi = 0;

		for (int i = 0; i < antallTegn.length - 1; i++) {
			if (antallTegn[i] > maxVerdi) {
				maxVerdi = antallTegn[i];
			}
		}
		int indexForBokstaver = 0;
		char bokstav = 'a';

		for (int i = 0; i < antallTegn.length - 1; i++) {
			if (antallTegn[i] == maxVerdi) {
				bokstaver += bokstav + " ";
			}
			bokstav++;
		}
		return bokstaver;
	}

	public double getProsentSomIkkeErBokstaver() {
		double verdiAlleTegn = (double)getTotaltAntallBokstaver();
		double verdiAndreTegn = (double)antallTegn[29];
		verdiAlleTegn += verdiAndreTegn;
		return (verdiAndreTegn / verdiAlleTegn) * 100;

//		return (((double)antallTegn[29]) / ((double)getTotaltAntallBokstaver() + (double)antallTegn[29])) * 100;
	}

	public int getAntallBestemtBokstav(char bokstav) {
		int bokstavSatan = bokstav;
		bokstavSatan -= 'a';
		return antallTegn[bokstavSatan];
	}

	private void analyserTekst() {
		int verdiChar = 0;
		for (int i = 0; i < inputString.length(); i++) {
			verdiChar = inputString.charAt(i);
			if ((verdiChar >= 'a') && (verdiChar <= 'z')) {
				verdiChar -= 'a';
				antallTegn[verdiChar]++;
			} else if ((verdiChar >= 'A') && (verdiChar <= 'Z')) {
				verdiChar -= 'A';
				antallTegn[verdiChar]++;
			} else {
				antallTegn[29]++;
			}
		}
	}
}