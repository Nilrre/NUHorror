package edu.neumont.csc150.d.Model;

import java.io.Serializable;

public class Player extends Object implements Serializable {
	private int x, y, xVel, yVel;
	private final int width = 80, height = 80;
	private boolean key = false;

	public Player() {
	}

	public Player(int x, int y, int xVel, int yVel) {
		this.setX(x);
		this.setxVel(xVel);
		this.setY(y);
		this.setyVel(yVel);
	}

	public boolean hasKey() {
		if(key == true){
			key = true;
		}else {
			key = false;
		}
		return key;
	}
	
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

	public void moveUp() {
		if (y - yVel > 0) {
			y -= yVel;
		}
	}

	public void moveDown() {
		if (y + yVel + height < 1292) {
			y += yVel;
		}
	}

	public void moveRight() {
		if (x + xVel + height < 2560) {
			x += xVel;
		}
	}

	public void moveLeft() {
		if (x - xVel > 0) {
			x -= xVel;
		}
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

	public int getxVel() {
		return xVel;
	}

	public void setxVel(int xVel) {
		this.xVel = xVel;
	}

	public int getyVel() {
		return yVel;
	}

	public void setyVel(int yVel) {
		this.yVel = yVel;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public boolean isKey() {
		return key;
	}
	
	public void setKey(boolean key) {
		this.key = key;
	}


}
