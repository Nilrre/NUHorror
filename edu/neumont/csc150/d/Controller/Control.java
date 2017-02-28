package edu.neumont.csc150.d.Controller;

import edu.neumont.csc150.d.Model.Player;
import edu.neumont.csc150.d.View.Floor1;
import edu.neumont.csc150.d.View.Floor2;
import edu.neumont.csc150.d.View.GUI;
import edu.neumont.csc150.d.View.GameGraphics;

public class Control {
	private boolean dPressed = false;
	private boolean aPressed = false;
	private boolean sPressed = false;
	private boolean wPressed = false;
	private Player Character;
	private GameGraphics game;
	private Floor1 f1;
	private boolean floor1 = true;
	private Floor2 f2;
	private boolean floor2 = false;
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

	private GUI gui;

	public Control() {
	}

	public void ControlGUI() {
		Character = new Player(30, 30, 6, 6);
		game = new GameGraphics(Character, this);
//		if(floor1 == true){
//			f1 = new Floor1(Character, this);			
//		}else if(floor2 == true){
//			f2 = new Floor2(Character, this);
//		}
		gui = new GUI();
		gui.guiMain(game,this);
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

}
