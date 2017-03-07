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
	 * Gets x-position of this door
	 * @return x-position
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets x-position of this door
	 * @param x-position
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets y-position of the door
	 * @return y-position
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets y-position of the door
	 * @param y-position
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the width of the Door
	 * @return the width of the door
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width of the door
	 * @param width of the door
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * 
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	@Override
	public boolean collider(Player p) {
		if(p.Collision(this.x, this.y, this.width, this.height)==true){
			return true;
		}else 
			return false;
	
	}

	public char getKeyType() {
		return KeyType;
	}

	public void setKeyType(char keyType) {
		KeyType = keyType;
	}
	
}
