package edu.neumont.csc150.d.Model;

import java.io.Serializable;

/**
 * 
 * @author Errlin Deleon
 *
 */
public class Player extends Object implements Serializable {
	private int x, y, xVel, yVel;
	private final int width = 80, height = 80;
	private boolean key = false;
	private boolean Earl = false, Law = false, Dave = false;
	private char KeyType = '0';

	/**
	 * Default instance of parameter
	 */
	public Player() {
	}

	/**
	 * Instance of parameter with parameters
	 * @param x position
	 * @param y position
	 * @param x velocity
	 * @param y velocity
	 */
	public Player(int x, int y, int xVel, int yVel) {
		this.setX(x);
		this.setxVel(xVel);
		this.setY(y);
		this.setyVel(yVel);
	}

	/**
	 * @return true if player has key
	 */
	public boolean hasKey() {
		if(key == true){
			key = true;
		}else {
			key = false;
		}
		return key;
	}
	
	/**
	 * Collision detection for the player
	 * @param other object x position
	 * @param other object y position
	 * @param other object width
	 * @param other object height
	 * @return
	 */
	public boolean Collision(int otherX, int otherY, int otherW, int otherH) {
		boolean colliding = false;

		if (this.getX() + this.getWidth() >= otherX && this.getX() <= otherX + otherW) {

			if (this.getY() <= otherY + otherH && this.getY() >= otherY + otherH - this.getyVel()) {
				this.setY(otherY + otherH);
				colliding = true;
			}

			if (this.getY() + this.getHeight() >= otherY && this.getY() + this.getHeight() <= otherY + this.getyVel()) {
				this.setY(otherY - this.getHeight());
				colliding = true;
			}

		} else
			colliding = false;
		if (this.getY() + this.getHeight() >= otherY && this.getY() <= otherY + otherH) {

			if (this.getX() + this.getWidth() <= otherX + this.getxVel() && this.getX() + this.getWidth() >= otherX) {
				this.setX(otherX - this.getWidth());
				colliding = true;
			}

			if (this.getX() <= otherX + otherW && this.getX() >= otherX + otherW - this.getxVel()) {
				this.setX(otherX + otherW);
				colliding = true;
			}
		} else {
			colliding = false;
		}
		return colliding;
	}

	/**
	 * Moves player up
	 */
	public void moveUp() {
		if (y - yVel > 0) {
			y -= yVel;
		}
	}

	/**
	 * Moves player down
	 */
	public void moveDown() {
		if (y + yVel + height < 1292) {
			y += yVel;
		}
	}

	/**
	 * Moves player right
	 */
	public void moveRight() {
		if (x + xVel + height < 2560) {
			x += xVel;
		}
	}

	/**
	 * Moves player left
	 */
	public void moveLeft() {
		if (x - xVel > 0) {
			x -= xVel;
		}
	}

	/**
	 * @return x position of player
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x position of player
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return y position of player
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param x position of the player
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return x velocity of the player
	 */
	public int getxVel() {
		return xVel;
	}

	/**
	 * @param x velocity of the player
	 */
	public void setxVel(int xVel) {
		this.xVel = xVel;
	}

	/**
	 * @return y velocity of the player
	 */
	public int getyVel() {
		return yVel;
	}

	/**
	 * @param y velocity of the player
	 */
	public void setyVel(int yVel) {
		this.yVel = yVel;
	}

	/**
	 * @return constant width of the player
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return constant height of the player
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @return true if player contains key
	 */
	public boolean isKey() {
		return key;
	}
	
	/**
	 * @param set to true if player contains key
	 */
	public void setKey(boolean key) {
		this.key = key;
	}

	/**
	 * @return true if errlin is selected
	 */
	public boolean isEarl() {
		return Earl;
	}

	/**
	 * @param set true if errlin is selected
	 */
	public void setEarl(boolean earl) {
		Earl = earl;
	}

	/**
	 * @return true if lawrence is selected
	 */
	public boolean isLaw() {
		return Law;
	}

	/**
	 * @param set true if lawrence is selected
	 */
	public void setLaw(boolean law) {
		Law = law;
	}

	/**
	 * @return true if david is selected
	 */
	public boolean isDave() {
		return Dave;
	}

	/**
	 * @param set true if david is selected
	 */
	public void setDave(boolean dave) {
		Dave = dave;
	}

	/**
	 * @return char value of the key
	 */
	public char getKeyType() {
		return KeyType;
	}

	/**
	 * @param return char value of the key
	 */
	public void setKeyType(char keyType) {
		KeyType = keyType;
	}
}
