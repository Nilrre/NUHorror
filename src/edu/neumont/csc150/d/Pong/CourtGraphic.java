package edu.neumont.csc150.d.Pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class CourtGraphic extends JPanel implements ActionListener, KeyListener {

	private Player player1;
	private Player player2;
	private Ball ball;
	private Controller control;

	public CourtGraphic(Player one, Player two, Ball baller, Controller c) {
		setBackground(Color.black);
		player1 = one;
		player2 = two;
		ball = baller;
		control = c;

		setFocusable(true);
		addKeyListener(this);

		Timer timer = new Timer(1000 / 60, this);
		timer.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.white);

		g.fillOval(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
		g.fillRect(player1.getX(), player1.getY(), player1.getWidth(), player1.getHeight());
		g.fillRect(player2.getX(), player2.getY(), player2.getWidth(), player2.getHeight());

		for (int lineY = 0; lineY < getHeight(); lineY += 50) {
			g.drawLine((this.getWidth() / 2), lineY, (this.getWidth() / 2), lineY + 25);
		}

		g.setFont(new Font(Font.DIALOG, Font.BOLD, 60));
		g.drawString(String.valueOf(player1.getScore()), (this.getWidth() / 2) + 200, 100);
		g.drawString(String.valueOf(player2.getScore()), (this.getWidth() / 2) - 200, 100);
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		control.move();

		if (ball != null) {
			ball.setX(ball.getX() + ball.getxVel());
			ball.setY(ball.getY() + ball.getyVel());
		}

		if (ball.getY() <= 0 || ball.getY() >= this.getHeight() - ball.getHeight()) {
			int speed = ball.getyVel() * -1;
			ball.setyVel(speed);
		}

		player1.paddleLeftCollision(ball, player1);
		player2.paddleRightCollision(ball, player2);
		
		control.scoreCheck();

		this.repaint();
			
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			control.setUpPressed(true);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			control.setDownPressed(true);
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			control.setwPressed(true);
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			control.setsPressed(true);
		}
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			control.setUpPressed(false);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			control.setDownPressed(false);
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			control.setwPressed(false);
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			control.setsPressed(false);
		}
		this.repaint();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	


}
