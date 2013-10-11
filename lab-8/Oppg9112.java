/*
 * Oppg9112.java
 *
 * Temperaturbajs klient
 *
 * huxflux
 */

import static javax.swing.JOptionPane.*;
public class Oppg9112 {
	public static void main(String[] args) {
		final int			DAYS_IN_MONTH = 30;
		final int			HOURS_IN_DAY = 24;

		Temperaturer tempShit = new Temperaturer();
		tempShit.randomShit();

		double[] jegErLei = new double[DAYS_IN_MONTH];
		jegErLei = tempShit.middelTempHverDag();

		for (int i = 0; i < DAYS_IN_MONTH; i++) {
			System.out.println("Dag " + i + ": " + jegErLei[i]);
		}

		jegErLei = tempShit.middelTempHverTimeHverDag();

		for (int i = 0; i < HOURS_IN_DAY; i++) {
			System.out.println("Time " + i + ": " + jegErLei[i]);
		}

		System.out.println("\nMiddeltemperatur for hele maaneden: " + tempShit.middelTempMaaned() + "\n");

		jegErLei = tempShit.middelTempGruppert();

		System.out.println("Antall dager under -5 grader: " + jegErLei[0] + " dager");
		System.out.println("Antall dager mellom -5 og 0 grader: " + jegErLei[1] + " dager");
		System.out.println("Antall dager mellom 0 og 5 grader: " + jegErLei[2] + " dager");
		System.out.println("Antall dager mellom 5 og 10 grader: " + jegErLei[3] + " dager");
		System.out.println("Antall dager over 10: " + jegErLei[4] + " dager");
	}
}