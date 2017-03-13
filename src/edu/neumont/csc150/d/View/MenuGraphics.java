package edu.neumont.csc150.d.View;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *Class that extends JPanel and calls Overrided paint method. Allows for the drawing of the Main Menu
 *image to be drawn on the screen
 */

public class MenuGraphics extends JPanel{
	private Image background;
	
	/**
	 * 
	 * @param filePath - the path of the image file
	 * @throws IOException - catches any exception thrown 
	 */
	
	public MenuGraphics(String filePath) throws IOException {//Constructor
		background = ImageIO.read(new File(filePath));
	}
	
	/**
	 *Paints the image 
	 */
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, this);	
	}
}
