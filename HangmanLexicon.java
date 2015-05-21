/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import java.util.*;
import java.io.*;

public class HangmanLexicon {

	/** Returns the number of words in the lexicon. */
	private static final String DATA_FILE = "HangmanLexicon.txt";
	private ArrayList<String> wordList;

	public HangmanLexicon() {
		try {
			BufferedReader rd = new BufferedReader(new FileReader(DATA_FILE));

			wordList = new ArrayList<String>();

			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				if (!wordList.contains(line)) {
					wordList.add(line);
				}
				rd.close();
			}
		} catch (IOException e) {
			throw new ErrorException(e);
		}
	}

	/** Returns the number of words in the lexicon */
	public int getWordCount() {
		return wordList.size();
	}

	/** Returns the word at the specific index */
	public String getWord(int index) {
		return wordList.get(index);
	}

	// public int getWordCount() {
	// return 10;
	// }
	//
	// /** Returns the word at the specified index. */
	// public String getWord(int index) {
	// switch (index) {
	// case 0: return "BUOY";
	// case 1: return "COMPUTER";
	// case 2: return "CONNOISSEUR";
	// case 3: return "DEHYDRATE";
	// case 4: return "FUZZY";
	// case 5: return "HUBBUB";
	// case 6: return "KEYHOLE";
	// case 7: return "QUAGMIRE";
	// case 8: return "SLITHER";
	// case 9: return "ZIRCON";
	// default: throw new ErrorException("getWord: Illegal index");
	// }
	// };
}
