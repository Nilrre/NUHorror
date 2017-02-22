package edu.neumont.csc150.d.Controller;

import edu.neumont.csc150.d.Model.Player;

public class Control {
	private boolean dPressed = false;
	private boolean aPressed = false;
	private boolean sPressed = false;
	private boolean wPressed = false;
	private Player Character;
	
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

	public boolean isdPressed() {
		return dPressed;
	}

	public void setdPressed(boolean dPressed) {
		this.dPressed = dPressed;
	}

	public boolean isaPressed() {
		return aPressed;
	}

	public void setaPressed(boolean aPressed) {
		this.aPressed = aPressed;
	}

	public boolean issPressed() {
		return sPressed;
	}

	public void setsPressed(boolean sPressed) {
		this.sPressed = sPressed;
	}

	public boolean iswPressed() {
		return wPressed;
	}

	public void setwPressed(boolean wPressed) {
		this.wPressed = wPressed;
	}
}