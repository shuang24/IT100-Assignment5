/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

    public void run() {
		println("Welcome to Hangman!");
		
		HangmanLexicon lexicon = new HangmanLexicon();
		RandomGenerator rgen = RandomGenerator.getInstance();
		
		wordToGuess = lexicon.getWord()(rgen.nextInt(lexicon.getWordCount()));
	}

}
