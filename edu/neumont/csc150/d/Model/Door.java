package edu.neumont.csc150.d.Model;

import java.io.Serializable;

/**
 * 
 * @author Errlin Deleon
 *
 */
public class Door extends Object implements Serializable, SolidObject{
	private boolean locked;
	private int x, y, width, height;
	private char KeyType;
	
	/**
	 * Default instance of door
	 */
	public Door() {}
	
	/**
	 * Instance of door with parameters
	 * @param x position
	 * @param y position
	 * @param width
	 * @param height
	 * @param locked
	 * @param character value
	 */
	public Door(int x, int y, int width, int height, boolean locked, char type){
		this.setHeight(height);
		this.setLocked(locked);
		this.setWidth(width);
		this.setX(x);
		this.setY(y);
		this.setKeyType(type);
	}
	
	/**
	 * @return x-position
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x-position
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return y-position
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y-position
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the width of the door
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width of the door
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height of the door
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height of the door
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return true if door is locked, false if door is unlocked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * @param true if door is locked, false if door is unlocked 
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	/**
	 * Collision detection for the player
	 */
	@Override
	public boolean collider(Player p) {
		if(p.Collision(this.x, this.y, this.width, this.height)==true){
			return true;
		}else 
			return false;
	
	}

	/**
	 * @return the doors character type
	 */
	public char getKeyType() {
		return KeyType;
	}

	/**
	 * @param char vlaue of the door
	 */
	public void setKeyType(char keyType) {
		KeyType = keyType;
	}
	
}
