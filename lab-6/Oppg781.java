/*
 * Oppg781.java
 *
 * Lag noe randomshit
 *
 * huxflux
 */

import java.util.Random;
import static javax.swing.JOptionPane.*;

public class Oppg781 {
	public static void main(String[] args) {
		final int	LOOP_COUNTER = 1000;
		Random 		random = new Random();
		int[] 		number = new int[10];
		String		result = "";

		for (int i = 0; i < LOOP_COUNTER - 1; i++) {
			number[random.nextInt(10)]++;
		}
		for (int i = 0; i < number.length; i++) {
			result+="Tall " + i + ": " + number[i] + "\n";
		}
		showMessageDialog(null, result);
	}
}