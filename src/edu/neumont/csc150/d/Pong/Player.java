package edu.neumont.csc150.d.Pong;

/**
 * 
 * @author Errlin Deleon
 *
 */
public class Player extends Bar {
	private String name;
	private int score;

	/**
	 * default instance of player
	 */
	public Player() {
	}
	
	/**
	 * instance of player, player extends bar
	 * @param score
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param yvel
	 */
	public Player(int score, int x, int y, int width, int height, int yvel) {
		this.setHeight(height);
		this.setWidth(width);
		this.setX(x);
		this.setY(y);
		this.setyVel(yvel);
		this.setScore(score);
	}

	/**
	 * Collision for left paddle
	 * @param b
	 * @param one
	 */
	public void paddleLeftCollision(Ball b, Player one) {
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
	public void paddleRightCollision(Ball b, Player two) {
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
	 * @return the name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param sets the name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the score of the player
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param sets the score of the player
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * resets score for players
	 * @return
	 */
	public int resetScore() {
		score = 0;
		return score;
	}
}
