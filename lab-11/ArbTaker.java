/*
 * ArbTaker.java
 *
 * Fuckshitklasse
 *
 * Helvete
 */

class ArbTaker {
	java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
	private int aar = kalender.get(java.util.Calendar.YEAR);
	Person personalia;
	private int arbTakerNr;
	private int ansettelsesAar;
	private int maanedsLonn;
	private double skatteProsent;

	public void setPersonalia (String fornavn, String etternavn, int fodselsaar) {
		this.personalia = new Person(fornavn, etternavn, fodselsaar);
	}

	public void setArbTakerNr(int arbTakerNr) {
		this.arbTakerNr = arbTakerNr;
	}

	public void setAnsattelsesAar (int ansattelsesAar) {
		this.ansettelsesAar = ansattelsesAar;
	}

	public void setMaanedsLonn(int maanedsLonn) {
		this.maanedsLonn = maanedsLonn;
	}

	public void setSkatteProsent(double skatteProsent) {
		this.skatteProsent = skatteProsent;
	}

	public Person getPersonalia() {
		return personalia;
	}

	public int getArbTakerNr() {
		return arbTakerNr;
	}

	public int getAnsettelsesAar() {
		return ansettelsesAar;
	}

	public int getMaanedsLonn() {
		return maanedsLonn;
	}

	public double getSkatteProsent() {
		return skatteProsent;
	}

	public int getSkattPrMaaned() {
		return (getMaanedsLonn() * (int)getSkatteProsent()) / 100;
	}

	public int getBruttoLonn() {
		return getMaanedsLonn() * 12;
	}

	public int getSkattPrAar() {
		return (getSkattPrMaaned() * 10) + (getSkattPrMaaned()) + ((getSkattPrMaaned() * (int)(getSkatteProsent() / 2)) / 100);
	}

	public String getFormWTF() {			// wtf???????!!!?!!?!1oneone
		return personalia.getFornavn();
	}

	public int getAlder() {
		Person temp = getPersonalia();
		return aar - temp.getFodselsAar();
	}

	public int getAntallAar() {
		return aar - getAnsettelsesAar();
	}

	public boolean getAnsattMerEnn(int skit) {
		return getAntallAar() > skit;
	}
}