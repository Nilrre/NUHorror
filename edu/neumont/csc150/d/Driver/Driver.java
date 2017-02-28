package edu.neumont.csc150.d.Driver;

import edu.neumont.csc150.d.Controller.Control;

public class Driver {

	public static void main(String[] args) throws InterruptedException {
		Control control = new Control();
		Thread.sleep(1000);
		control.ControlGUI();
	}

}
