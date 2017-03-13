package edu.neumont.csc150.d.Model;

/**
 * 
 * @author Errlin Deleon
 *
 */
public class NPC extends Player implements SolidObject{
	private String saying;
	
	/**
	 * defalut instance of NPC
	 */
	public NPC() {}
	
	/**
	 * instance of NPC with parameters
	 * @param x position
	 * @param y position
	 * @param x velocity
	 * @param y velocity
	 * @param NPC sayings
	 */
	public NPC(int x, int y, int xvel, int yvel, String speak){
		this.setX(x);
		this.setY(y);
		this.setxVel(xvel);
		this.setyVel(yvel);
		this.setSaying(speak);
	}

	/**
	 * @return the NPC's saying
	 */
	public String getSaying() {
		return saying;
	}

	/**
	 * @param NPC's Saying
	 */
	public void setSaying(String saying) {
		this.saying = saying;
	}

	/**
	 * Collision detection for the player
	 */
	@Override
	public boolean collider(Player p) {
		if(p.Collision(this.getX(), this.getY(), this.getWidth(), this.getHeight())==true){
			return true;
		}else 
			return false;
	
	}
}
