/*
 * Oppg9112.java
 *
 * Temperaturbajs klient
 *
 * huxflux
 */

public class Oppg9112 {
	public static void main(String[] args) {
		final int			DAYS_IN_MONTH = 30;
		final int			HOURS_IN_DAY = 24;

		Temperaturer tempShit = new Temperaturer();

		double[] jegErLei = new double[DAYS_IN_MONTH];
		jegErLei = tempShit.middelTempHverDag();

		for (int i = 0; i < DAYS_IN_MONTH; i++) {
			System.out.printf("Dag " + (i+1) + ": %.2f\n", jegErLei[i]);
		}

		jegErLei = tempShit.middelTempHverTimeHverDag();

		for (int i = 0; i < HOURS_IN_DAY; i++) {
			System.out.printf("Time " + (i+1) + ": %.2f\n", jegErLei[i]);
		}

		System.out.printf("\nMiddeltemperatur for hele maaneden: %.2f\n", tempShit.middelTempMaaned());

		jegErLei = tempShit.middelTempGruppert();

		System.out.println("\nAntall dager under -5 grader: " + (int)jegErLei[0] + " dager");
		System.out.println("Antall dager mellom -5 og 0 grader: " + (int)jegErLei[1] + " dager");
		System.out.println("Antall dager mellom 0 og 5 grader: " + (int)jegErLei[2] + " dager");
		System.out.println("Antall dager mellom 5 og 10 grader: " + (int)jegErLei[3] + " dager");
		System.out.println("Antall dager over 10: " + (int)jegErLei[4] + " dager");
	}
}