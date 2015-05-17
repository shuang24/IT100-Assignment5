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

	private String wordToGuess;
	private String currentWord;
	private HangmanCanvas canvas;

	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
	}

	public void run() {
		println("Welcome to Hangman!");

		HangmanLexicon lexicon = new HangmanLexicon();
		RandomGenerator rgen = RandomGenerator.getInstance();

		wordToGuess = lexicon.getWord(rgen.nextInt(lexicon.getWordCount()));
		currentWord = dashifyWord();
		boolean gameWon = false;
		int numberOfGuessesLeft = 8;
		canvas.reset();

		while (!gameWon && (numberOfGuessesLeft > 0)) {
			canvas.displayWord(currentWord);
		}
	}

	private String dashifyWord() {
		String result = "";
		for (int i = 0; i < wordToGuess.length(); i++) {
			result += "-";
		}
		return result;
	}

}
