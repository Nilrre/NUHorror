package edu.neumont.csc150.d.Model;

/**
 * 
 * @author Errlin Deleon
 *
 */
public class Key extends Object implements SolidObject {
	
	private int amount, x, y, width, height;
	private char KeyType;
	
	/**
	 * Default instance of door
	 */
	public Key() {}
	
	/**
	 * Instance of door with no parameters
	 * @param amount of keys
	 * @param x position
	 * @param y position
	 * @param width 
	 * @param height
	 * @param char value
	 */
	public Key(int amount, int x, int y, int w, int h, char type) {
		this.setAmount(amount);
		this.setX(x);
		this.setY(y);
		this.setWidth(w);
		this.setHeight(h);
		this.setKeyType(type);
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
	 * Sets amount of keys used
	 * @param amount of keys
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/**
	 * @return the x position
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param sets the x position
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y position
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param sets the y position
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the width of the key
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param sets the width of the key
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height of the key
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param sets the height of the key
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return char value of the key
	 */
	public char getKeyType() {
		return KeyType;
	}

	/** 
	 * @param char value of key
	 */
	public void setKeyType(char keyType) {
		KeyType = keyType;
	}
}
