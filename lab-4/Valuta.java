/*
 * Valuta.java
 *
 * En klasse som skal benyttes i Oppg592.java
 * Klassen skal ha metoder for aa regne fra og til norske kroner.
 *
 * huxflux
 */

class Valuta {
	private final double valutaVerdi;

	public Valuta(double valutaVerdi) {
		this.valutaVerdi = valutaVerdi;
	}

	public double setTilAnnenValuta(double norskeKroner) {
		norskeKroner /= valutaVerdi;
		return norskeKroner;
	}

	public double setTilNorskeKroner(double antallEnheter) {
		antallEnheter *= valutaVerdi;
		return antallEnheter;
	}
}
