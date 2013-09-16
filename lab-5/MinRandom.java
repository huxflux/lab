/*
 * MinRandom.java
 *
 * EN FANTASTISK KLASSE!!!!!
 *
 * huxflux
 */

import java.util.Random;

public class MinRandom {
	Random randomVerdi = new Random();

	public int nesteHelTall(int nedre, int ovre) {
		return (randomVerdi.nextInt(ovre - nedre) + nedre);
	}

	public double nesteDesimalTall(double nedre, double ovre) {
		return randomVerdi.nextDouble() * (ovre - nedre) + nedre;
	}

}