package edu.neumont.csc150.d.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import edu.neumont.csc150.d.Controller.Control;
import edu.neumont.csc150.d.Model.Door;
import edu.neumont.csc150.d.Model.Key;
import edu.neumont.csc150.d.Model.Player;
import edu.neumont.csc150.d.Model.Wall;

public class Floor1 extends JPanel implements ActionListener, KeyListener {

	// change for when i have an outline
	private Wall wall1 = new Wall(400, 400, 200, 200);
	private Door door = new Door(300, 300, 30, 30, false);
	private Key key = new Key(1, 200, 200, 10, 10);

	// keep
	private Player player;
	private Control control;

	public Floor1(Player p, Control c) {
		player = p;
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
		g.fillOval(player.getX(), player.getY(), player.getWidth(), player.getHeight());
		g.drawRect(wall1.getX(), wall1.getY(), wall1.getWidth(), wall1.getHeight());
		this.repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			control.setaPressed(true);
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			control.setdPressed(true);
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			control.setwPressed(true);
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			control.setsPressed(true);
		}
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			control.setaPressed(false);
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			control.setdPressed(false);
		} else if (e.getKeyCode() == KeyEvent.VK_W) {
			control.setwPressed(false);
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			control.setsPressed(false);
		}
		this.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.Collision(wall1.getX(), wall1.getY(), wall1.getWidth(), wall1.getHeight());

		if (player.Collision(door.getX(), door.getY(), door.getWidth(), door.getHeight()) == true) {
			if (door.isLocked() == false) {
				// load next room
				// } else if (door.isLocked() == true && player.hasKey() ==
				// true) {
				// door.setLocked(false);
			} else {
				// Draw String "I cannot enter without a key"
			}
		} else if (player.Collision(key.getX(), key.getY(), key.getWidth(), key.getHeight()) == true) {
			// if(player pressed "i"){
			// make key disappear
			// }
		}
		// else if(player.Collision(npc.getX(), npc.GetY(), npc.getWidth(), npc.getHeight()) == true){
		// drawString npc.getSaying();
		// }

		control.move();
		this.repaint();
	}

}