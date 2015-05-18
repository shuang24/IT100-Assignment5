/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;
import java.awt.Canvas.*;
import sun.misc.Cleaner.*;
import java.awt.Graphics.*;

public class HangmanCanvas extends GCanvas {

	private double xHangman, yHangman, yBody, yLeg;
	private int numberOfWrongGuesses;
	private GLabel wrongGuesses, currentWord;

	/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		removeAll();
		numberOfWrongGuesses = 0;
		xHangman = getWidth() / 2;
		yHangman = (getHeight() - SCAFFOLD_HEIGHT) * 0.25 + ROPE_LENGTH;
		GPen scaffold = new GPen(xHangman, yHangman);
		scaffold.drawLine(0, -ROPE_LENGTH);
		scaffold.drawLine(-BEAM_LENGTH, 0);
		scaffold.drawLine(0, SCAFFOLD_HEIGHT);
		add(scaffold);

		double xLabels = xHangman - BEAM_LENGTH;
		double yLabels = yHangman + SCAFFOLD_HEIGHT;
		currentWord = new GLabel("");
		currentWord.setLocation(xLabels, yLabels + HEAD_RADIUS / 2);
		currentWord.setFont("Verdana-30");
		add(currentWord);
		wrongGuesses = new GLabel("");
		wrongGuesses.setLocation(xLabels, yLabels + HEAD_RADIUS);
		add(wrongGuesses);
	}

	/**
	 * Draw head and set y position
	 */

	private void drawHead() {
		double d = 2 * HEAD_RADIUS;
		GOval Head = new GOval(xHangman - HEAD_RADIUS, yHangman, d, d);
		yBody = yHangman + d;
		add(Head);
	}

	/**
	 * Draw Body and leg
	 */
	private void drawBody() {
		yLeg = yBody + BODY_LENGTH;
		GLine body = new GLine(xHangman, yBody, xHangman, yLeg);
		add(body);
	}

	/**
	 * Draw arms
	 */
	private void drawArm(int side) {
		GPen arm = new GPen(xHangman, yBody + ARM_OFFSET_FROM_HEAD);
		arm.drawLine(side * UPPER_ARM_LENGTH, 0);
		arm.drawLine(0, LOWER_ARM_LENGTH);
		add(arm);
	}

	/**
	 * Draw Leg
	 */
	private void drawLeg(int side) {
		GPen leg = new GPen(xHangman, yLeg);
		leg.drawLine(side * HIP_WIDTH, 0);
		leg.drawLine(0, LEG_LENGTH);
		add(leg);
	}

	/**
	 * draw foot
	 */
	private void drawFoot(int side) {
		double y = yLeg + LEG_LENGTH;
		double x = xHangman + side * HIP_WIDTH;
		GLine foot = new GLine(x, y, x + side * FOOT_LENGTH, y);
		add(foot);
	}

	/**
	 * Updates the word on the screen to correspond to the current state of the
	 * game. The argument string shows what letters have been guessed so far;
	 * unguessed letters are indicated by hyphens.
	 */
	public void displayWord(String word) {
		/* You fill this in */
		currentWord.setLabel(word);
	}

	/**
	 * Updates the display to correspond to an incorrect guess by the user.
	 * Calling this method causes the next body part to appear on the scaffold
	 * and adds the letter to the list of incorrect guesses that appears at the
	 * bottom of the window.
	 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
		numberOfWrongGuesses++;
		switch (numberOfWrongGuesses) {
		case 1:
			drawHead();
			break;
		case 2:
			drawBody();
			break;
		case 3:
			drawArm(-1);
			break;
		case 4:
			drawArm(1);
			break;
		case 5:
			drawLeg(-1);
			break;
		case 6:
			drawLeg(1);
			break;
		case 7:
			drawFoot(-1);
			break;
		case 8:
			drawFoot(1);
			break;
		default:
			break;
		}
		updateWrongGuesses(letter);
	}

	private void updateWrongGuesses(char letter) {

		letter = Character.toUpperCase(letter);
		String newString = "";
		String oldString = wrongGuesses.getLabel();
		int length = oldString.length();
		boolean letterAdded = false;
		for (int i = 0; i < length; i++) {
			char ch = oldString.charAt(i);
			if (ch < letter) {
				newString += ch;
			} else {
				if (ch > letter) {
					newString += letter;
				}
				newString += oldString.substring(i);
				letterAdded = true;
				break;
			}
		}
		if (!letterAdded) {
			newString += letter;
		}
		wrongGuesses.setLabel(newString);
	}

	/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
