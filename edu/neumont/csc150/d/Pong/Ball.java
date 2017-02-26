package edu.neumont.csc150.d.Pong;

/**
 * 
 * @author Errlin Deleon
 *
 */
public class Ball {
	private int x, y, height, width, xVel, yVel;
	
	/**
	 * default instance of ball
	 */
	public Ball(){}
	
	/**
	 * instance of ball
	 * @param x
	 * @param y
	 * @param height
	 * @param width
	 * @param xVelocity
	 * @param yVelocity
	 */
	public Ball(int x, int y, int height, int width, int xVel, int yVel){
		this.setX(x);
		this.setHeight(height);
		this.setWidth(width);
		this.setxVel(xVel);
		this.setY(y);
		this.setyVel(yVel);
	}
	
	/**
	 * Detects collision of the ball to an object
	 * @param rObjX
	 * @param rObjY
	 * @param lObjX
	 * @param lObjY
	 */
	public void detectCollision(int rObjX,int height, int lObjX, int height2) {
		if(this.x >= rObjX - this.width || this.x < lObjX) {
			this.xVel *= -1;
		}
	}
	
	/**
	 * @return the x position of the ball
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @param sets the x position of the ball
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * @return the y posotion of the ball
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * @param sets the y position of the ball
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * @return the height of the ball
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @param sets the height of the ball
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * @return the width of the ball
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @param sets the width of the ball
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * @return the xVelovity of the ball
	 */
	public int getxVel() {
		return xVel;
	}
	
	/**
	 * @param sets the xVelocity of the ball
	 */
	public void setxVel(int xVel) {
		this.xVel = xVel;
	}
	
	/**
	 * @return the yVelocity of the ball
	 */
	public int getyVel() {
		return yVel;
	}
	
	/**
	 * @param sets the yVelocity of the ball
	 */
	public void setyVel(int yVel) {
		this.yVel = yVel;
	}
}
