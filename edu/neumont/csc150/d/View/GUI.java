package edu.neumont.csc150.d.View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	private JFrame frame;
	private JButton NewGame, LoadGame, Quit;
	private JPanel window;
	
	public void guiMain(GameGraphics game) {
		frame = new JFrame("NUHorror");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(game);
		frame.setVisible(true);
	}
}
