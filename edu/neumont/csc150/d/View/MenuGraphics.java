package edu.neumont.csc150.d.View;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MenuGraphics extends JPanel{
	private Image background;

	public MenuGraphics(String filePath) throws IOException {//Constructor
		background = ImageIO.read(new File(filePath));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, this);	
	}
}
