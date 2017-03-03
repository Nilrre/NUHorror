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
	
	private void save(GameGraphics graphics) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Saves//saveFile.nu"));
		out.writeObject(graphics);
		out.flush();
	}
	
	private void load(GameGraphics graphics, Player p) throws FileNotFoundException, IOException, ClassNotFoundException {
//		character = p;
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Saves//saveFile.nu"));
		
		Object obj = in.readObject();
		GameGraphics gg = (GameGraphics)obj;
		
//		character.setX();
	}
}
