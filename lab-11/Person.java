/*
 * Person.java
 *
 * Skitklasse
 *
 * Fuck uuUUhuuuUUUuuu
 *
 */

 class Person {
	private final String fornavn;
	private final String etternavn;
	private final int fodselsaar;

 	public Person (String fornavn, String etternavn, int fodselsaar) {
	 	this.fornavn = fornavn;
	 	this.etternavn = etternavn;
	 	this.fodselsaar = fodselsaar;
 	}

 	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public int getFodselsAar() {
		return fodselsaar;
	}
}