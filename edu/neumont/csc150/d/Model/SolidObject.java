package edu.neumont.csc150.d.Model;

public interface SolidObject {
	
	/**
	 * checks to see if the player character is colliding with this solid object
	 * @param p, the player character
	 */
	public void collider(Player p) ;
	
}
