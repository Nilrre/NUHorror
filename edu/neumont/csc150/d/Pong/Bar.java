package edu.neumont.csc150.d.Pong;

/**
 * 
 * @author Errlin Deleon
 *
 */
public class Bar {
	private int width;
	private int height;
	private int x;
	private int y;
	private int yVel;
	private int score = 0;
	
	/**
	 * default instance without parameter
	 */
	public Bar(){}
	
	/**
	 * instance with parameter
	 * @param x
	 * @param y
	 * @param height
	 * @param width
	 */
	public Bar(int x, int y, int height, int width){
		this.setHeight(height);
		this.setWidth(width);
		this.setX(x);
		this.setY(y);
	}
	

	/**
	 * Collision for left paddle
	 * @param b
	 * @param one
	 */
	public void paddleLeftCollision(Ball b, Bar one) {
		if (b.getX() < this.getX() + this.getWidth() - 10) {
			if (b.getY() > this.getY() && b.getY() < this.getY() + this.getHeight()) {
					int speed = b.getxVel() * -1;
					b.setxVel(speed);
			} else if (b.getX() <= 0) {
				one.score++;
				b.setX(1250);
				b.setY(600);
			}
		}
	}

	/**
	 * Collision for right paddle
	 * @param b
	 * @param two
	 */
	public void paddleRightCollision(Ball b, Bar two) {
		if (b.getX() + this.getWidth() >= this.getX() + 9) {
			if (b.getY() > this.getY() && b.getY() < this.getY() + this.getHeight()) {
					int speed = b.getxVel() * -1;
					b.setxVel(speed);
			} else if (b.getX() >= 2560) {
				two.score++;
				b.setX(1250);
				b.setY(600);
			}
		}
	}

	
	/**
	 * moves paddle up
	 */
	public void moveUp(){
        if (y-yVel > 0) {
        	y -= yVel;
        }
	}
	
	/**
	 * moves paddle down
	 */
	public void moveDown() {
        if (y + yVel + height < 1292) {
            y += yVel;
        }
	}
	
	/**
	 * @return the width of the paddle
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @param set the width of the paddle
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * @return the height of the paddle
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @param sets the height of the paddle
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * @return the x position of the paddle
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @param sets the x position of the paddle
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * @return the y position of the paddle
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * @param sets the y position of the paddle
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * @return the yVelocity of the paddle
	 */
	public int getyVel() {
		return yVel;
	}

	/**
	 * @param sets the yVelocity of the paddle
	 */
	public void setyVel(int yVel) {
		this.yVel = yVel;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
