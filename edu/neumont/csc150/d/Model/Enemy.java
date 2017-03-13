package edu.neumont.csc150.d.Model;

import java.util.Random;

import javax.swing.Timer;

import edu.neumont.csc150.d.Model.Player;
import edu.neumont.csc150.d.Model.SolidObject;
import edu.neumont.csc150.d.View.GameGraphics;

public class Enemy implements SolidObject{
	
	private int x,y,width = 150,height = 150;
	private Player character;

	public Enemy() {
	}
	
	public Enemy(Player p, GameGraphics g) {
		this.setCharacter(p);
	}
	
	public void chase() {
		Random random = new Random();
		int movementX = random.nextInt((this.getX() + 100) - this.getX()) + this.getX();
		int movementY = random.nextInt((this.getY() + 100) - this.getY()) + this.getY();
		this.setX(movementX);
		this.setY(movementY);
	}
	
	@Override
	public boolean collider(Player p) {
		if(p.Collision(this.getX(), this.getY(), this.getWidth(), this.getHeight())==true){
			return true;
		}else 
			return false;
	
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the character
	 */
	public Player getCharacter() {
		return character;
	}

	/**
	 * @param character the character to set
	 */
	public void setCharacter(Player character) {
		this.character = character;
	}
}
