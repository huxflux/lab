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
		String skitString = "";
		skitString = inputString.replaceAll(tegn, "");	// gode GUD saa digg replaceAll(String, String) var.. Mmmmm!
		return skitString;
	}

	public String getOriginalString() {
		return inputString;
	}
}