package edu.neumont.csc150.d.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import edu.neumont.csc150.d.Controller.Control;
import edu.neumont.csc150.d.Model.Player;
import edu.neumont.csc150.d.Model.Wall;

public class GameGraphics extends JPanel implements ActionListener, KeyListener {

	private Player character;
	private Control control;
	private Image Errlin;
	public Wall wall = new Wall(300,200,700,100);

	public GameGraphics(Player chara, Control c) {
		setBackground(Color.black);
		character = chara;
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
//		g.fillOval(character.getX(), character.getY(), character.getWidth(), character.getHeight());
		ImageIcon image = new ImageIcon("Errlin Walk//front//Errlin2.png");
		Errlin = image.getImage();
		Graphics2D d = (Graphics2D)g; 
		d.drawImage(Errlin, character.getX(), character.getY(), this);

		
		g.fillRect(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
//		character.Collision(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
		wall.collider(character);
		control.move();
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
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}


}
