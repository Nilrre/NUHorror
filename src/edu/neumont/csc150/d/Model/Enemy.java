package edu.neumont.csc150.d.Model;

import edu.neumont.csc150.d.Model.Player;
import edu.neumont.csc150.d.Model.SolidObject;

public class Enemy implements SolidObject{
	
	private int x,y,width = 150,height = 150;
	private Player character;

	public Enemy() {
	}
	
	public Enemy(Player p) {
		this.setCharacter(p);
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
