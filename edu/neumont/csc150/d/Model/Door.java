package edu.neumont.csc150.d.Model;

public class Door {
	private boolean locked;
	private int x, y, width, height;
	
	public Door() {}
	
	public Door(int x, int y, int width, int height, boolean locked){
		this.setHeight(height);
		this.setLocked(locked);
		this.setWidth(width);
		this.setX(x);
		this.setY(y);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

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
	
}
