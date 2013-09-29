/*
 * NyString.java
 *
 * Yeye..
 *
 * huxfluxshitfuck
 */

public class NyString {
	private String		inputString = "";

	public NyString (String inputString) {
		this.inputString = inputString;
	}

	public String getForkortString() {
		String[] 	ord = inputString.split(" ");
		String 		forkortetString = "";

		for (int i = 0; i < ord.length; i++) {
			forkortetString += ord[i].charAt(0);
		}
		return forkortetString;
	}

	public String getFjernTegnString(String tegn) {
		return inputString.replaceAll(tegn, "");		// gode GUD saa digg replaceAll(String, String) var.. Mmmmm!
	}

	public String getOriginalString() {
		return inputString;
	}
}