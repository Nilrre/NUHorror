package edu.neumont.csc150.d.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import edu.neumont.csc150.d.Model.Player;
import edu.neumont.csc150.d.View.GameGraphics;

public class SaveLoad {
	
	public void save(Control control, Player p) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream
				("Saves//saveGame.nu"));
		ObjectOutputStream outChar = new ObjectOutputStream(new FileOutputStream
				("Saves//saveCharacter.nu"));
		out.writeObject(control);
		outChar.writeObject(p);
		out.flush();
		outChar.flush();
	}
	
	public void load(Control control, Player p) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream
				("Saves//saveGame.nu"));
		ObjectInputStream inChar = new ObjectInputStream(new FileInputStream
				("Saves//saveCharacter.nu"));
		
		Object obj = in.readObject();
		Control cont = (Control)obj;
		Object objChar = inChar.readObject();
		Player character = (Player)objChar;
		
		p.setX(character.getX());
		p.setY(character.getY());
		
		control.setFloor1(cont.isFloor1());
		control.setFloor2(cont.isFloor2());
		control.setFloor3(cont.isFloor3());
		
	}
}
