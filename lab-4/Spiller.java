/*
 * Spiller.java
 *
 * Spiller klasse
 *
 * huxflux
 */

import java.util.Random;

class Spiller {

	private int			sumPoeng = 0;
	private int			terningKastSum = 0;
	private int			poengSum = 0;
	private boolean		erSpillerFerdig = false;

	Random terning = new Random();

	public Spiller(int poengSum) {
		this.poengSum = poengSum;
	}

	public int getSumPoeng() {
		return sumPoeng;
	}

	public boolean isFerdig() {
		return erSpillerFerdig;
	}

	public void kastTerningen(int typeOfDice) {
		terningKastSum = (terning.nextInt(typeOfDice) + 1);
		if (terningKastSum == 1) {
			sumPoeng = 0;
		} else {
			sumPoeng += terningKastSum;
		}
		if (sumPoeng >= poengSum) {
			erSpillerFerdig = true;
		}
	}

}