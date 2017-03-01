package edu.neumont.csc150.d.Model;

public class NPC extends Player implements SolidObject{
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

	@Override
	public boolean collider(Player p) {
		if(p.Collision(this.getX(), this.getY(), this.getWidth(), this.getHeight())==true){
			return true;
		}else 
			return false;
	
	}

}
