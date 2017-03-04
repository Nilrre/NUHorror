package edu.neumont.csc150.d.Model;

public class Wall extends Object implements SolidObject {
	
	private int x, y, height, width;
	private String saying;
	
	public Wall() {}

	public Wall(int x, int y, int width, int height){
		this.setHeight(height);
		this.setWidth(width);
		this.setX(x);
		this.setY(y);
	}
	
	@Override
	public boolean collider(Player p) {
		if(p.Collision(this.x, this.y, this.width, this.height)==true){
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
	 * @return the saying
	 */
	public String getSaying() {
		return saying;
	}

	/**
	 * @param saying the saying to set
	 */
	public void setSaying(String saying) {
		this.saying = saying;
	}
	
	
}
