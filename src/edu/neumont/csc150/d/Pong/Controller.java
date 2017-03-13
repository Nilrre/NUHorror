package edu.neumont.csc150.d.Pong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * 
 * @author Errlin Deleon
 *
 */
public class Controller implements ActionListener {
	private boolean upPressed = false;
	private boolean downPressed = false;
	private boolean sPressed = false;
	private boolean wPressed = false;
	private PongUI ui;
	private Player player1;
	private Player player2;
	private Ball ball;
	private CourtGraphic court;
	
	/**
	 * sets up the gui
	 */
	public void controlGUI() {		
		player1 = new Player(0,10,400,80,450,10);
		player2 = new Player(0,2470,400, 80, 450, 10);
		ball = new Ball(1250, 600, 85,85,10,10);
		court = new CourtGraphic(player1, player2, ball, this);
		ui = new PongUI();
		ui.guiMain(court, this);
	}

	/**
	 * checks score of the players 
	 */
	@SuppressWarnings("static-access")
	public void scoreCheck() {
		if(player1.getScore() == 7) {
			ui.getOver().showMessageDialog(court, "Player 2 you won!\nPress OK to reset the game.");
			this.resetGame();
		}
		if(player2.getScore() == 7) {
			ui.getOver().showMessageDialog(court, "Player 1 you won!\nPress OK to reset the game.");
			this.resetGame();
		}
	}
	
	/**
	 * moves the paddles
	 */
	public void move(){
		//move player 1
		if (wPressed) {
			player1.moveUp();
        }
        if (sPressed) {
        	player1.moveDown();
        }

		//move player 2
        if (upPressed) {
        	player2.moveUp();
        }
        if (downPressed) {
            player2.moveDown();
        }
	}
	
	/**
	 * @return true if upPressed is pressed
	 */
	public boolean isUpPressed() {
		return upPressed;
	}

	/**
	 * @param sets upPressed to true if pressed
	 */
	public void setUpPressed(boolean upPressed) {
		this.upPressed = upPressed;
	}

	/**
	 * @return true if downPressed is pressed
	 */
	public boolean isDownPressed() {
		return downPressed;
	}

	/**
	 * @param sets downPressed to true if pressed 
	 */
	public void setDownPressed(boolean downPressed) {
		this.downPressed = downPressed;
	}

	/**
	 * @return true if sPressed is pressed
	 */
	public boolean issPressed() {
		return sPressed;
	}

	/**
	 * @param sets sPressed to true if pressed
	 */
	public void setsPressed(boolean sPressed) {
		this.sPressed = sPressed;
	}

	/**
	 * @return true if wPressed is pressed
	 */
	public boolean iswPressed() {
		return wPressed;
	}

	/**
	 * @param sets sPressed to true if pressed
	 */
	public void setwPressed(boolean wPressed) {
		this.wPressed = wPressed;
	}

	/**
	 * menu for the gui
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == ui.getNewGame()) {
			this.resetGame();
		}else if(evt.getSource() == ui.getQuit()) {
			ui.getFrame().dispatchEvent(new WindowEvent(ui.getFrame(), WindowEvent.WINDOW_CLOSING));
		}
	}
	
	/**
	 * resets the game
	 */
	public void resetGame() {
		player1.setScore(0);
		player1.setX(10);
		player1.setY(400);
		player2.setScore(0);
		player2.setX(2470);
		player2.setY(400);
		ball.setX(1250);
		ball.setY(600);
	}
}
