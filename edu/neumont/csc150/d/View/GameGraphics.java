package edu.neumont.csc150.d.View;

import java.awt.Color;
import java.awt.Font;
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
import edu.neumont.csc150.d.Model.Door;
import edu.neumont.csc150.d.Model.Key;
import edu.neumont.csc150.d.Model.NPC;
import edu.neumont.csc150.d.Model.Player;
import edu.neumont.csc150.d.Model.Wall;

public class GameGraphics extends JPanel implements ActionListener, KeyListener {

	private Player character;
	private Control control;
	private Image theCommons, floor2, floor3, basement, standing, down, up, left, right;
	private String Dialouge;

	// floor1
	private Wall wall1 = new Wall(650, 900, 500, 50);
	private Wall wall2 = new Wall(650, 1175, 500, 50);
	private Wall wall3 = new Wall(1150, 900, 50, 325);
	private Wall wall4 = new Wall(0, 250, 100, 300);
	private Wall wall5 = new Wall(0, 650, 300, 50);
	private Wall wall6 = new Wall(0, 900, 350, 50);
	private Wall wall7 = new Wall(0, 1190, 350, 40);
	private Wall wall8 = new Wall(2275, 400, 50, 800);
	private Wall wall9 = new Wall(2275, 0, 100, 125);

	//need to fix
	private Door door1 = new Door(950, 925, 50, 700, false);
	private Door door2 = new Door(2275, 125, 100, 1075, false);
	private Door MainDoor = new Door(2275, 12, 200, 100, true);

	// floor2
	private Wall wall10 = new Wall(0, 275, 60, 250);
	private Wall wall11 = new Wall(375, 275, 1150, 350);
	private Wall wall12 = new Wall(1500, 850, 50, 150);
	private Wall wall13 = new Wall(2150, 0, 250, 850);
	private Wall wall14 = new Wall(2160, 1080, 540, 270);

	//need to fix most of these
	private Door door3 = new Door(60, 275, 315, 210, true);
	private Door door4 = new Door(1400, 625, 150, 425, true);
	private Door door5 = new Door(1400, 1000, 150, 475, true);
	private Door door6 = new Door(2500, 850, 50, 300, false);
	private Door door7 = new Door(1550, 1300, 625, 50, false);

	public GameGraphics(Player chara, Control c) {
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
		Graphics2D d = (Graphics2D) g;
		g.setColor(Color.green);

		if (control.isFloor1() == true) {
			ImageIcon commons = new ImageIcon("Pics//floors//commons of horror.png");
			theCommons = commons.getImage();
			d.drawImage(theCommons, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);

//			g.fillRect(wall1.getX(), wall1.getY(), wall1.getWidth(), wall1.getHeight());
//			g.fillRect(wall2.getX(), wall2.getY(), wall2.getWidth(), wall2.getHeight());
//			g.fillRect(wall3.getX(), wall3.getY(), wall3.getWidth(), wall3.getHeight());
//			g.fillRect(wall4.getX(), wall4.getY(), wall4.getWidth(), wall4.getHeight());
//			g.fillRect(wall5.getX(), wall5.getY(), wall5.getWidth(), wall5.getHeight());
//			g.fillRect(wall6.getX(), wall6.getY(), wall6.getWidth(), wall6.getHeight());
//			g.fillRect(wall7.getX(), wall7.getY(), wall7.getWidth(), wall7.getHeight());
//			g.fillRect(wall8.getX(), wall8.getY(), wall8.getWidth(), wall8.getHeight());
//			g.fillRect(wall9.getX(), wall9.getY(), wall9.getWidth(), wall9.getHeight());

			g.drawRect(door1.getX(), door1.getY(), door1.getWidth(), door1.getWidth());
			g.drawRect(door2.getX(), door2.getY(), door2.getWidth(), door2.getWidth());
			g.drawRect(MainDoor.getX(), MainDoor.getY(), MainDoor.getWidth(), MainDoor.getWidth());

			// for (int y = 0; y < this.getHeight(); y += 50) {
			// for (int i = 0; i < this.getWidth(); i += 50) {
			// g.drawString("-", i, y);
			// g.drawString("|", i, y);
			// g.drawString(Integer.toString(y), this.getWidth() - 30, y);
			// g.drawString(Integer.toString(i), i, this.getHeight() - 30);
			// }
			// }
		} else if (control.isFloor2() == true) {
			ImageIcon theSecondFloor = new ImageIcon("Pics//floors//floor 2.png");
			floor2 = theSecondFloor.getImage();
			d.drawImage(floor2, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);

//			g.fillRect(wall10.getX(), wall10.getY(), wall10.getWidth(), wall10.getHeight());
//			g.fillRect(wall11.getX(), wall11.getY(), wall11.getWidth(), wall11.getHeight());
//			g.fillRect(wall12.getX(), wall12.getY(), wall12.getWidth(), wall12.getHeight());
//			g.fillRect(wall13.getX(), wall13.getY(), wall13.getWidth(), wall13.getHeight());
//			g.fillRect(wall14.getX(), wall14.getY(), wall14.getWidth(), wall14.getHeight());

			g.drawRect(door3.getX(), door3.getY(), door3.getWidth(), door3.getWidth());
			g.drawRect(door4.getX(), door4.getY(), door4.getWidth(), door4.getWidth());
			g.drawRect(door5.getX(), door5.getY(), door5.getWidth(), door5.getWidth());
			g.drawRect(door6.getX(), door6.getY(), door6.getWidth(), door6.getWidth());
			g.drawRect(door7.getX(), door7.getY(), door7.getWidth(), door7.getWidth());

			for (int y = 0; y < this.getHeight(); y += 50) {
				for (int i = 0; i < this.getWidth(); i += 50) {
					g.drawString("-", i, y);
					g.drawString("|", i, y);
					g.drawString(Integer.toString(y), this.getWidth() - 30, y);
					g.drawString(Integer.toString(i), i, this.getHeight() - 30);
				}
			}
		} else if (control.isFloor3() == true) {
			ImageIcon theThirdFloor = new ImageIcon("Pics//floors//floor 3.png");
			floor3 = theThirdFloor.getImage();
			d.drawImage(floor3, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);

			for (int y = 0; y < this.getHeight(); y += 50) {
				for (int i = 0; i < this.getWidth(); i += 50) {
					g.drawString("-", i, y);
					g.drawString("|", i, y);
					g.drawString(Integer.toString(y), this.getWidth() - 30, y);
					g.drawString(Integer.toString(i), i, this.getHeight() - 30);
				}
			}
		}
		

		// if (character.getY() > 900) {
		// g.setColor(Color.BLUE);
		// g.fillRect(200, 900, 2200, 500);
		// g.setFont(new Font("Impact", Font.BOLD, 100));
		// g.setColor(Color.BLACK);
		// g.drawString("Wassup", 300, 1200);
		// }
		// g.fillOval(character.getX(), character.getY(), character.getWidth(),
		// character.getHeight());
		
		if (character.isEarl() == true) {
		if (!control.iswPressed() && !control.isaPressed() && !control.issPressed() && !control.isdPressed()) {
			ImageIcon image = new ImageIcon("Errlin Walk//front//Errlin2.png");
			standing = image.getImage();
			d.drawImage(standing, character.getX(), character.getY(), character.getWidth(), character.getHeight(), this);
		}
		// Walking Down
		else if (control.issPressed()) {
			ImageIcon image1 = new ImageIcon("Errlin Walk//front//animated.gif");
			down = image1.getImage();
			d.drawImage(down, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
					this);
		}
		// Walking Up
		else if (control.iswPressed()) {
			ImageIcon image1 = new ImageIcon("Errlin Walk//Back//animated.gif");
			up = image1.getImage();
			d.drawImage(up, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
					this);
		}
		// Walking to the right
		else if (control.isdPressed()) {
			ImageIcon image1 = new ImageIcon("Errlin Walk//side//animated.gif");
			right = image1.getImage();
			d.drawImage(right, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
					this);
		}
		// walking to the right
		else if (control.isaPressed()) {
			ImageIcon image1 = new ImageIcon("Errlin Walk//side//animated.gif");
			left = image1.getImage();
			d.drawImage(left, character.getX() + 60, character.getY(), -(character.getWidth()),
					character.getHeight(), this);
			}
		}
		
		else if (character.isLaw() == true) {
			if (!control.iswPressed() && !control.isaPressed() && !control.issPressed() && !control.isdPressed()) {
				ImageIcon image = new ImageIcon("Lawrence Walk//front//0.png");
				standing = image.getImage();
				d.drawImage(standing, character.getX(), character.getY(), character.getWidth(), character.getHeight(), this);
			}
			// Walking Down
			else if (control.issPressed()) {
				ImageIcon image1 = new ImageIcon("Lawrence Walk//front//animated.gif");
				down = image1.getImage();
				d.drawImage(down, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
			}
			// Walking Up
			else if (control.iswPressed()) {
				ImageIcon image1 = new ImageIcon("Lawrence Walk//back//animated.gif");
				up = image1.getImage();
				d.drawImage(up, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
			}
			// Walking to the right
			else if (control.isdPressed()) {
				ImageIcon image1 = new ImageIcon("Lawrence Walk//side//animated.gif");
				right = image1.getImage();
				d.drawImage(right, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
			}
			// walking to the right
			else if (control.isaPressed()) {
				ImageIcon image1 = new ImageIcon("Lawrence Walk//side//animated.gif");
				left = image1.getImage();
				d.drawImage(left, character.getX() + 60, character.getY(), -(character.getWidth()),
						character.getHeight(), this);
				}
		}
		
		else if (character.isDave() == true) {
			if (!control.iswPressed() && !control.isaPressed() && !control.issPressed() && !control.isdPressed()) {
				ImageIcon image = new ImageIcon("David Walk//front//0.png");
				standing = image.getImage();
				d.drawImage(standing, character.getX(), character.getY(), character.getWidth(), character.getHeight(), this);
			}
			// Walking Down
			else if (control.issPressed()) {
				ImageIcon image1 = new ImageIcon("David Walk//front//animated.gif");
				down = image1.getImage();
				d.drawImage(down, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
			}
			// Walking Up
			else if (control.iswPressed()) {
				ImageIcon image1 = new ImageIcon("David Walk//back//animated.gif");
				up = image1.getImage();
				d.drawImage(up, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
			}
			// Walking to the right
			else if (control.isdPressed()) {
				ImageIcon image1 = new ImageIcon("David Walk//side//animated.gif");
				right = image1.getImage();
				d.drawImage(right, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
			}
			// walking to the right
			else if (control.isaPressed()) {
				ImageIcon image1 = new ImageIcon("David Walk//side//animated.gif");
				left = image1.getImage();
				d.drawImage(left, character.getX() + 60, character.getY(), -(character.getWidth()),
						character.getHeight(), this);
				}
		}
		
		this.repaint();
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------
	public void doorCollision(Door door) {
		if (door.collider(character) == true) {
			if (door.isLocked() == false) {
				// make if statement for each door
				if (door.equals(door2)) {
					control.setFloor1(false);
					control.setFloor2(true);
					character.setX(2300);
					character.setY(900);
				}else if(door.equals(door1)){
					control.setFloor1(false);
					control.setFloor3(true);
//					character.setX();
//					character.setY();
				}
			} else if (door.isLocked() == true && character.hasKey() == true) {
				door.setLocked(false);
			} else {
				Dialouge = "I cannot enter without a key";
				// inside draw string put in dialouge
			}
		}
	}

	public void keyCollision(Key key) {
		if (key.collider(character) == true) {
			if (control.isiPressed() == true) {
				// set key visibility to false
				// AKA make boolean for key
				// in paint method make an if statement for key
				character.setKey(true);
			}
		}
	}

	public void NPCCollision(NPC ai) {
		if (ai.collider(character) == true) {
			Dialouge = ai.getSaying();
		}
	}

	// --------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (control.isFloor1()) {
			wall1.collider(character);
			wall2.collider(character);
			wall3.collider(character);
			wall4.collider(character);
			wall5.collider(character);
			wall6.collider(character);
			wall7.collider(character);
			wall8.collider(character);
			wall9.collider(character);

			doorCollision(door1);
			doorCollision(door2);
			doorCollision(MainDoor);

		} else if (control.isFloor2() == true) {
			wall10.collider(character);
			wall11.collider(character);
			wall12.collider(character);
			wall13.collider(character);
			wall14.collider(character);

			doorCollision(door3);
			doorCollision(door4);
			doorCollision(door5);
			doorCollision(door6);
			doorCollision(door7);
		}

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
		} else if (e.getKeyCode() == KeyEvent.VK_I) {
			control.setiPressed(true);
		} else if (e.getKeyCode() == KeyEvent.VK_P) {
			control.setpPressed(true);
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
		} else if (e.getKeyCode() == KeyEvent.VK_I) {
			control.setiPressed(false);
		} else if (e.getKeyCode() == KeyEvent.VK_P) {
			control.setpPressed(false);
		}

		this.repaint();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
