package edu.neumont.csc150.d.Model;

public class Key extends Object implements SolidObject {
	
	private int amount, x, y, width, height;
	
	
	public Key() {}
	
	public Key(int amount, int x, int y, int w, int h) {
		this.setAmount(amount);
		this.setX(x);
		this.setY(y);
		this.setWidth(w);
		this.setHeight(h);
	}
	
	@Override
	public void collider(Player p) {
		p.Collision(this.x, this.y, this.width, this.height);
//		if(p.colliding) {
			//TODO Collect the key and add to inventory or array of keys
//		}
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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


}
