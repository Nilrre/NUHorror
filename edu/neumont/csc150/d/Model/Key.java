package edu.neumont.csc150.d.Model;

public class Key extends Object {
	private int amount;
	
	public Key() {}
	
	public Key(int amount) {
		this.setAmount(amount);
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
