package edu.neumont.csc150.d.Controller;

import edu.neumont.csc150.d.Model.Player;
import edu.neumont.csc150.d.View.Audio;
import edu.neumont.csc150.d.View.GUI;
import edu.neumont.csc150.d.View.GameGraphics;

public class Control {
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
//	private Audio audio = new Audio();
	private boolean room1 = false;
	private boolean room2 = false;
	private boolean room3 = false;

	private GUI gui;

	public Control() {

	}

	public void ControlGUI() {
		Character = new Player(2100, 1150, 20, 20);
		game = new GameGraphics(Character, this, gui);
		// if(floor1 == true){
		// f1 = new Floor1(Character, this);
		// }else if(floor2 == true){
		// f2 = new Floor2(Character, this);
		// }
		gui = new GUI();
		gui.guiMain(game, this, Character);
	}

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

	public boolean isFloor3() {
		return floor3;
	}

	public void setFloor3(boolean floor3) {
		this.floor3 = floor3;
	}

	public boolean isBasement() {
		return basement;
	}

	public void setBasement(boolean basement) {
		this.basement = basement;
	}

	public boolean isFloor1() {
		return floor1;
	}

	public void setFloor1(boolean floor1) {
		this.floor1 = floor1;
	}

	public boolean isFloor2() {
		return floor2;
	}

	public void setFloor2(boolean floor2) {
		this.floor2 = floor2;
	}

	public boolean ispPressed() {
		return pPressed;
	}

	public void setpPressed(boolean pPressed) {
		this.pPressed = pPressed;
	}

	public boolean isiPressed() {
		return iPressed;
	}

	public void setiPressed(boolean iPressed) {
		this.iPressed = iPressed;
	}
	
	public boolean isRoom1() {
		return room1;
	}
	
	public void setRoom1(boolean room1) {
		this.room1 = room1;
	}
	
	public boolean isRoom2() {
		return room2;
	}
	
	public void setRoom2(boolean room2) {
		this.room2 = room2;
	}
	
	public boolean isRoom3() {
		return room3;
	}
	
	public void setRoom3(boolean room3) {
		this.room3 = room3;
	}

	public boolean isoPressed() {
		return oPressed;
	}

	public void setoPressed(boolean oPressed) {
		this.oPressed = oPressed;
	}
}

