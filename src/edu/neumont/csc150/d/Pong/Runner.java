package edu.neumont.csc150.d.Pong;

import javax.swing.JFrame;

/**
 * 
 * @author Errlin Deleon
 *
 */
public class Runner {
	Controller c = new Controller();
	private JFrame frame;

	public static void main(String[] args) {
	}
	
	public void runPongGame() {
		c.controlGUI();
	}

}
