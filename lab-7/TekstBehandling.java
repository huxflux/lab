/*
 * TekstBehandling.java
 *
 * Blablabla
 * Endel av disse metodene er fucked hvis man skriver fucked setninger.
 *
 * Fucksucks
 */

public class TekstBehandling {
	private String		inputString = "";
	char[]				skilleTegn = {'.', ',', '!', ':', '?'};

	public TekstBehandling (String inputString) {
		this.inputString = inputString;
	}

	public int getAmountOfWords() {
		String		tempString = new String(inputString);
		tempString = fjernSkilleTegn(tempString);
		String[] 	tempString2 = tempString.split(" ");
		return tempString2.length;
	}

	public int getAverageWordsSkitFaen() {
		int			antallOrd = 0;
		int			ikkeBokstaver = 0;
		String[]	tempString = inputString.split(" ");

		for (int i = 0; i < tempString.length; i++) {					// jesus what a CLUSTERFUCK!
			for (int j = 0; j < tempString[i].length(); j++) {
				for (int k = 0; k < skilleTegn.length; k++) {
					if (tempString[i].charAt(j) == skilleTegn[k]) {
						ikkeBokstaver++;
					}
				}
			}
			antallOrd++;
		}
		System.out.println(ikkeBokstaver);
		return (antallOrd / ikkeBokstaver);
	}


	public int getAverageWordLength() {
		int			average = 0;
		String		tempString = new String(inputString);

		tempString = fjernSkilleTegn(tempString);
		String[] 	tempString2 = tempString.split(" ");

		for (int i = 0; i < tempString2.length; i++) {
			average += tempString2[i].length();
		}
		return (average / tempString2.length);
	}

	public String getOriginalString() {
		return inputString;
	}

	public String getOriginalStringUpperCase() {
		String tempString = new String(inputString);
		return tempString.toUpperCase();
	}

	public String getStringWithWordChange(String wordToReplace, String replaceWord) {
		String tempString = new String(inputString);
		return tempString.replaceAll(wordToReplace, replaceWord);
	}

	private String fjernSkilleTegn (String inputString) {				//fjerner skilletegn (!?., etc)
			for (int i = 0; i < skilleTegn.length; i++) {
				inputString = inputString.replace(Character.toString(skilleTegn[i]), "");
			}
			return inputString;
	}
}
