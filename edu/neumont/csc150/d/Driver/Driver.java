package edu.neumont.csc150.d.Driver;

import edu.neumont.csc150.d.Controller.Control;

/**
 * 
 * @author Errlin Deleon, Lawrence Douglas, David Duran
 *
 */
public class Driver {

	/**
	 * Main Method to start the game
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Control control = new Control();
		Thread.sleep(1000);
		control.ControlGUI();
	}

}
