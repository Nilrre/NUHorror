package edu.neumont.csc150.d.Model;

/**
 * 
 * @author Errlin Deleon
 *
 */
public class Wall extends Object implements SolidObject {
	
	private int x, y, height, width;
	
	/**
	 * Default instance of a wall
	 */
	public Wall() {}

	/**
	 * Instance of wall with parameters
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Wall(int x, int y, int width, int height){
		this.setHeight(height);
		this.setWidth(width);
		this.setX(x);
		this.setY(y);
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
	 * @return the x position of the wall
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x position of the wall
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y position of the wall
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y position of the wall
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the height of the wall
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height of the wall
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the width of the wall
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width of the wall
	 */
	public void setWidth(int width) {
		this.width = width;
	}
}
