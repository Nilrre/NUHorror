package edu.neumont.csc150.d.Controller;

import java.io.Serializable;

import edu.neumont.csc150.d.Model.Player;
import edu.neumont.csc150.d.View.Audio;
import edu.neumont.csc150.d.View.GUI;
import edu.neumont.csc150.d.View.GameGraphics;

/**
 * 
 * @author Errlin Deleon
 *
 */
public class Control implements Serializable {
	private boolean dPressed = false;
	private boolean aPressed = false;
	private boolean sPressed = false;
	private boolean wPressed = false;
	private boolean pPressed = false;
	private boolean iPressed = false;
	private boolean oPressed = false;

	private Player Character;
	private GameGraphics game;
	private boolean floor1 = true;
	private boolean floor2 = false;
	private boolean floor3 = false;
	private boolean basement = false;
	private boolean room1 = false;
	private boolean room2 = false;
	private boolean room3 = false;
	private boolean room4 = false;
	private boolean room5 = false;
	private boolean gameOver = false;
	private GUI gui;

	/**
	 * Default instance of control
	 */
	public Control() {}

	/**
	 * Sets up the gui of the game
	 */
	public void ControlGUI() {
		Character = new Player(2100, 1150, 20, 20);
		game = new GameGraphics(Character, this, gui);
		gui = new GUI(game, this, Character);
		gui.guiMain();
	}

	/**
	 * Instance to move the player
	 */
	public void move() {
		if (wPressed) {
			Character.moveUp();
		}
		if (sPressed) {
			Character.moveDown();
		}
		if (aPressed) {
			Character.moveLeft();
		}
		if (dPressed) {
			Character.moveRight();
		}
	}

	/**
	 * @return true if d is pressed
	 */
	public boolean isdPressed() {
		return dPressed;
	}

	/**
	 * @param true if d is pressed
	 */
	public void setdPressed(boolean dPressed) {
		this.dPressed = dPressed;
	}

	/**
	 * @return true if a is pressed
	 */
	public boolean isaPressed() {
		return aPressed;
	}

	/**
	 * @param true if a is pressed
	 */
	public void setaPressed(boolean aPressed) {
		this.aPressed = aPressed;
	}

	/**
	 * @return true if s is pressed
	 */
	public boolean issPressed() {
		return sPressed;
	}

	/**
	 * @param true if s is pressed
	 */
	public void setsPressed(boolean sPressed) {
		this.sPressed = sPressed;
	}
	
	/**
	 * @return true if w is pressed
	 */
	public boolean iswPressed() {
		return wPressed;
	}

	/**
	 * @param true if w is pressed
	 */
	public void setwPressed(boolean wPressed) {
		this.wPressed = wPressed;
	}

	/**
	 * @return true if player goes to floor 3
	 */
	public boolean isFloor3() {
		return floor3;
	}

	/**
	 * @param true if player goes to floor 3
	 */
	public void setFloor3(boolean floor3) {
		this.floor3 = floor3;
	}

	/**
	 * @return true if player goes to basement
	 */
	public boolean isBasement() {
		return basement;
	}

	/**
	 * @param true if player goes to basement
	 */
	public void setBasement(boolean basement) {
		this.basement = basement;
	}

	/**
	 * @return true if player goes to floor 1
	 */
	public boolean isFloor1() {
		return floor1;
	}

	/**
	 * @param true if player goes to floor 1
	 */
	public void setFloor1(boolean floor1) {
		this.floor1 = floor1;
	}

	/** 
	 * @return true if player goes to floor 2
	 */
	public boolean isFloor2() {
		return floor2;
	}

	/**
	 * @param true if player goes to floor 2
	 */
	public void setFloor2(boolean floor2) {
		this.floor2 = floor2;
	}

	/**
	 * @return true if p is pressed
	 */
	public boolean ispPressed() {
		return pPressed;
	}

	/**
	 * @param true if p is pressed
	 */
	public void setpPressed(boolean pPressed) {
		this.pPressed = pPressed;
	}

	/**
	 * @return true if i is pressed
	 */
	public boolean isiPressed() {
		return iPressed;
	}

	/**
	 * @param true if i is pressed
	 */
	public void setiPressed(boolean iPressed) {
		this.iPressed = iPressed;
	}
	
	/**
	 * @return true if player goes to room 1
	 */
	public boolean isRoom1() {
		return room1;
	}
	
	/**
	 * @param true if player goes to room 1
	 */
	public void setRoom1(boolean room1) {
		this.room1 = room1;
	}
	
	/**
	 * @return true if player goes to room 2
	 */
	public boolean isRoom2() {
		return room2;
	}
	
	/**
	 * @param true if player goes to room 2
	 */
	public void setRoom2(boolean room2) {
		this.room2 = room2;
	}
	
	/**
	 * @return true if player goes to room 3
	 */
	public boolean isRoom3() {
		return room3;
	}
	
	/**
	 * @param true if player goes to room 3
	 */
	public void setRoom3(boolean room3) {
		this.room3 = room3;
	}

	/**
	 * @return true if o is pressed
	 */
	public boolean isoPressed() {
		return oPressed;
	}

	/**
	 * @param true if o is pressed
	 */
	public void setoPressed(boolean oPressed) {
		this.oPressed = oPressed;
	}

	/**
	 * @return true if player goes to room 4
	 */
	public boolean isRoom4() {
		return room4;
	}

	/**
	 * @param true if player goes to room 4
	 */
	public void setRoom4(boolean room4) {
		this.room4 = room4;
	}

	/**
	 * @return true if player goes to room 5
	 */
	public boolean isRoom5() {
		return room5;
	}

	/**
	 * @param true if player goes to room 5
	 */
	public void setRoom5(boolean room5) {
		this.room5 = room5;
	}
	
	/**
	 * @return the gameOver
	 */
	public boolean isGameOver() {
		return gameOver;
	}

	/**
	 * @param gameOver the gameOver to set
	 */
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
}

