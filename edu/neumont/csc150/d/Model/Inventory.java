package edu.neumont.csc150.d.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventory extends Object implements Serializable {
	private ArrayList<Object> inventory = new ArrayList<>();
	
	public Inventory() {}
	
	public void addInventory(Object obj){
		inventory.add(obj);		
	}
	
	public void removeInventory(Object obj){
		inventory.remove(obj);
	}
}
