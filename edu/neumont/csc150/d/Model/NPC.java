package edu.neumont.csc150.d.Model;

public class NPC extends Player{
	private String saying;
	
	public NPC() {}
	
	public NPC(int x, int y, int xvel, int yvel, String speak){
		this.setX(x);
		this.setY(y);
		this.setxVel(xvel);
		this.setyVel(yvel);
		this.setSaying(speak);
	}

	public String getSaying() {
		return saying;
	}

	public void setSaying(String saying) {
		this.saying = saying;
	}

}
