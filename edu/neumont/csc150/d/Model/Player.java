package edu.neumont.csc150.d.Model;

import java.io.Serializable;

public class Player extends Object implements Serializable {
	private int x,y,xVel,yVel;
	private final int width = 50, height = 50;
	
	public Player(){}
	
	public Player(int x, int y, int xVel, int yVel){
		this.setX(x);
		this.setxVel(xVel);
		this.setY(y);
		this.setyVel(yVel);
	}
	
	//need to figure this out
	public void Collision(Object obj) {	
	}
	
	public void moveUp(){
        if (y-yVel > 0) {
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

	public void moveLeft(){
        if (x-xVel > 0) {
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

}
