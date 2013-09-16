/*
 * Oppg6102.java
 *
 * Klasse og blablablabla.
 *
 * huxflux
 */

public class Brok {
	private int			teller = 0;
	private int 		nevner = 0;

	public Brok(int teller, int nevner) {
		if (nevner == 0) {
			throw new IllegalArgumentException("feil");
		}
		this.teller = teller;
		this.nevner = nevner;
	}

	public Brok(int teller) {
		this.teller = teller;
		this.nevner = 1;
	}

	public void adder(Brok brok) {
		int	nevnerBackup = this.nevner;
		this.teller *= brok.getNevner();
		this.nevner *= brok.getNevner();
		this.teller += brok.getTeller() * nevnerBackup;
	}

	public void subtraher(Brok brok) {
		int nevnerBackup = this.nevner;
		this.teller *= brok.getNevner();
		this.nevner *= brok.getNevner();
		this.teller -= brok.getTeller() * nevnerBackup;
	}

	public void multipliser(Brok brok) {
		this.teller *= brok.getTeller();
		this.nevner *= brok.getNevner();
	}

	public void divider(Brok brok) {
		this.teller *= brok.getNevner();
		this.nevner *= brok.getTeller();
	}

	public int getTeller() {
		return this.teller;
	}

	public int getNevner() {
		return this.nevner;
	}

	public String toString() {
		return ("teller: " + this.teller + "\n" + "nevner: " + this.nevner);
	}
}


