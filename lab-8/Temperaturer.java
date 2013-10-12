/*
 * Temperaturer.java
 *
 * Klasse blablabla
 *
 * huxflux
 */

import java.util.Random;

public class Temperaturer {
	final int			DAYS_IN_MONTH = 30;
	final int			HOURS_IN_DAY = 24;
	private double[][] 	tempTabell = new double[DAYS_IN_MONTH][HOURS_IN_DAY];

	public Temperaturer() {
		randomShit();
	}

	public double[] middelTempHverDag() {
		double[] tmp = new double[DAYS_IN_MONTH];

		for (int i = 0; i < DAYS_IN_MONTH; i++) {
			for (int j = 0; j < HOURS_IN_DAY; j++) {
				tmp[i] += tempTabell[i][j];
			}
			tmp[i] /= HOURS_IN_DAY;
		}
		return tmp;
	}

	public double[] middelTempHverTimeHverDag() {
		double[] tmp = new double[HOURS_IN_DAY];

		for (int i = 0; i < HOURS_IN_DAY; i++) {
			for (int j = 0; j < DAYS_IN_MONTH; j++) {
				tmp[i] += tempTabell[j][i];
			}
			tmp[i] /= DAYS_IN_MONTH;
		}
		return tmp;
	}

	public double middelTempMaaned() {
		double[] temp = middelTempHverDag();
		double middelTemp = 0;

		for (int i = 0; i < DAYS_IN_MONTH; i++) {
			middelTemp += temp[i];
		}
		return (middelTemp / DAYS_IN_MONTH);
	}

	public double[] middelTempGruppert() {
		double[] temp = middelTempHverDag();
		double[] dager = new double[5];

		for (int i = 0; i < DAYS_IN_MONTH; i++) {
			if (temp[i] < -5) {
				dager[0]++;
			}
			if (temp[i] > -5 && temp[i] < 0) {
				dager[1]++;
			}
			if (temp[i] > 0 && temp[i] < 5) {
				dager[2]++;
			}
			if (temp[i] > 5 && temp[i] < 10) {
				dager[3]++;
			}
			if (temp[i] > 10) {
				dager[4]++;
			}
		}
		return dager;
	}

	private void randomShit() {
		Random random = new Random();

		for (int i = 0; i < DAYS_IN_MONTH; i++) {
			for (int j = 0; j < HOURS_IN_DAY; j++) {
				this.tempTabell[i][j] = random.nextDouble() * (60 - (-60)) + (-60);
			}
		}
	}
}