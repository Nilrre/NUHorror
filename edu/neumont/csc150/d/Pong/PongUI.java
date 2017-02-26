package edu.neumont.csc150.d.Pong;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * 
 * @author Errlin Deleon
 *
 */
public class PongUI {
	private JMenuItem newGame, quit;
	private JFrame frame;
	private JOptionPane over, start;
	
	/**
	 * @return the the over panel
	 */
	public JOptionPane getOver() {
		return over;
	}

	/**
	 * @param sets the game to over
	 */
	public void setOver(JOptionPane over) {
		this.over = over;
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param sets the frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * main for the gui
	 * @param court
	 * @param control
	 */
	public void guiMain(CourtGraphic court, Controller control) {
		frame = new JFrame("Pong");
		setStart(new JOptionPane("start"));
		over = new JOptionPane("you won");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(court);
		addMenu(frame, control);
		frame.setVisible(true);
	}
	
	/**
	 * adds menu to JFrame
	 * @param frame
	 * @param graphic
	 */
	public void addMenu(JFrame frame, Controller graphic) {
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(graphic);
		quit = new JMenuItem("Quit");
		quit.addActionListener(graphic);
		JMenu menu = new JMenu("Game");
		JMenuBar menuBar = new JMenuBar();
		
		menu.add(newGame);
		menu.addSeparator();
		menu.add(quit);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
	}

	/**
	 * @return the newGame
	 */
	public JMenuItem getNewGame() {
		return newGame;
	}

	/**
	 * @param newGame the newGame to set
	 */
	public void setNewGame(JMenuItem newGame) {
		this.newGame = newGame;
	}

	/**
	 * @return the quit
	 */
	public JMenuItem getQuit() {
		return quit;
	}

	/**
	 * @param quit the quit to set
	 */
	public void setQuit(JMenuItem quit) {
		this.quit = quit;
	}

	/**
	 * 
	 * @return
	 */
	public JOptionPane getStart() {
		return start;
	}
	
	/**
	 * 
	 * @param start
	 */
	public void setStart(JOptionPane start) {
		this.start = start;
	}
}