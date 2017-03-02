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
	private Image theCommons, floor2, floor3, basement, room1, room2, room3, standing, down, up, left, right;
	private String Dialouge;
	private Audio audio;

	// place into each floor/room
	private boolean key1Visible = true;
	private Key key1 = new Key();

	// floor1
	private Wall wall1 = new Wall(650, 900, 500, 50);
	private Wall wall2 = new Wall(650, 1175, 500, 25);
	private Wall wall3 = new Wall(1150, 900, 50, 300);
	private Wall wall4 = new Wall(0, 250, 100, 250);
	private Wall wall5 = new Wall(0, 650, 300, 50);
	private Wall wall6 = new Wall(0, 900, 350, 50);
	private Wall wall7 = new Wall(0, 1190, 350, 25);
	private Wall wall8 = new Wall(2275, 400, 50, 800);
	private Wall wall9 = new Wall(2275, 0, 100, 125);
	private Wall pong = new Wall(825, 650, 425, 200);

	private Door door1 = new Door(950, 925, 50, 200, false);
	private Door door2 = new Door(2275, 125, 100, 275, false);
	private Door MainDoor = new Door(2275, 1200, 200, 250, true);

	// floor2
	private Wall wall10 = new Wall(0, 275, 60, 250);
	private Wall wall11 = new Wall(375, 275, 1150, 350);
	private Wall wall12 = new Wall(1500, 850, 50, 150);
	private Wall wall13 = new Wall(2150, 0, 450, 850);
	private Wall wall14 = new Wall(2160, 1080, 540, 270);

	private Door door3 = new Door(60, 275, 315, 210, true);
	private Door door4 = new Door(1400, 625, 150, 425, true);
	private Door door5 = new Door(1400, 1000, 150, 475, true);
	private Door door6 = new Door(2500, 850, 50, 300, false);
	private Door door7 = new Door(1550, 1250, 625, 100, false);

	// floor3
	private Wall wall15 = new Wall(0, 0, 675, 1350);
	private Wall wall16 = new Wall(650, 525, 200, 200);
	private Wall wall17 = new Wall(1050, 1250, 1450, 150);
	private Wall wall18 = new Wall(2500, 1175, 100, 200);
	private Wall wall19 = new Wall(2500, 0, 100, 670);
	private Wall wall20 = new Wall(1900, 50, 300, 600);
	private Wall wall28 = new Wall(650, 500, 100, 50);

	private Door door8 = new Door(500, 75, 200, 250, true);
	private Door door9 = new Door(500, 800, 200, 250, true);
	private Door door10 = new Door(500, 1250, 500, 150, false);
	private Door door11 = new Door(2500, 670, 100, 505, false);

	// basement
	private Wall wall21 = new Wall(0, 0, 475, 850);
	private Wall wall22 = new Wall(0, 0, 275, 1350);
	private Wall wall23 = new Wall(0, 1000, 1200, 350);
	private Wall wall24 = new Wall(1500, 0, 1050, 1350);
	private Wall wall25 = new Wall(1200, 0, 1350, 425);
	private Wall wall26 = new Wall(1400, 825, 1150, 575);
	private Wall wall27 = new Wall(1425, 425, 1150, 150);

	private Door door12 = new Door(750, 875, 200, 650, false);
	private Door door13 = new Door(450, 50, 50, 250, true);
	private Door door14 = new Door(1200, 1250, 200, 150, true);

	public GameGraphics(Player chara, Control c) {
		character = chara;
		control = c;
//		audio = a;
		setFocusable(true);
		addKeyListener(this);

		Timer timer = new Timer(1000 / 60, this);
		timer.start();
	}

	public void draw(Wall wall1, Graphics g) {
		g.fillRect(wall1.getX(), wall1.getY(), wall1.getWidth(), wall1.getHeight());
	}

	public void draw(Door wall1, Graphics g) {
		g.drawRect(wall1.getX(), wall1.getY(), wall1.getWidth(), wall1.getHeight());
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D d = (Graphics2D) g;
		g.setColor(Color.green);

		if (control.isFloor1()) {
			ImageIcon commons = new ImageIcon("Pics//floors//commons of horror.png");
			theCommons = commons.getImage();
			d.drawImage(theCommons, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);

			if (key1Visible) {
				key1 = new Key(1, 100, 100, 20, 20);
				g.fillOval(key1.getX(), key1.getY(), key1.getWidth(), key1.getHeight());
			}

			// for (int y = 0; y < this.getHeight(); y += 50) {
			// for (int i = 0; i < this.getWidth(); i += 50) {
			// g.drawString("-", i, y);
			// g.drawString("|", i, y);
			// g.drawString(Integer.toString(y), this.getWidth() - 30, y);
			// g.drawString(Integer.toString(i), i, this.getHeight() - 30);
			// }
			// }
		} else if (control.isFloor2()) {
			ImageIcon theSecondFloor = new ImageIcon("Pics//floors//floor 2.png");
			floor2 = theSecondFloor.getImage();
			d.drawImage(floor2, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);

			// for (int y = 0; y < this.getHeight(); y += 50) {
			// for (int i = 0; i < this.getWidth(); i += 50) {
			// g.drawString("-", i, y);
			// g.drawString("|", i, y);
			// g.drawString(Integer.toString(y), this.getWidth() - 30, y);
			// g.drawString(Integer.toString(i), i, this.getHeight() - 30);
			// }
			// }
		} else if (control.isFloor3()) {
			ImageIcon theThirdFloor = new ImageIcon("Pics//floors//floor 3.png");
			floor3 = theThirdFloor.getImage();
			d.drawImage(floor3, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);

			// for (int y = 0; y < this.getHeight(); y += 50) {
			// for (int i = 0; i < this.getWidth(); i += 50) {
			// g.drawString("-", i, y);
			// g.drawString("|", i, y);
			// g.drawString(Integer.toString(y), this.getWidth() - 30, y);
			// g.drawString(Integer.toString(i), i, this.getHeight() - 30);
			// }
			// }
		} else if (control.isBasement()) {
			ImageIcon theBasement = new ImageIcon("Pics//floors//basement of horror.png");
			basement = theBasement.getImage();
			d.drawImage(basement, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);

			// for (int y = 0; y < this.getHeight(); y += 50) {
			// for (int i = 0; i < this.getWidth(); i += 50) {
			// g.drawString("-", i, y);
			// g.drawString("|", i, y);
			// g.drawString(Integer.toString(y), this.getWidth() - 30, y);
			// g.drawString(Integer.toString(i), i, this.getHeight() - 30);
			// }
			// }
		} else if (control.isRoom1()) {
			ImageIcon Room = new ImageIcon("Pics//floors//rooms//room1.png");
			room1 = Room.getImage();
			d.drawImage(room1, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);

			for (int y = 0; y < this.getHeight(); y += 50) {
				for (int i = 0; i < this.getWidth(); i += 50) {
					g.drawString("-", i, y);
					g.drawString("|", i, y);
					g.drawString(Integer.toString(y), this.getWidth() - 30, y);
					g.drawString(Integer.toString(i), i, this.getHeight() - 30);
				}
			}
		} else if (control.isRoom2()) {
			ImageIcon Room = new ImageIcon("Pics//floors//rooms//room2.png");
			room2 = Room.getImage();
			d.drawImage(room2, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);
		
			for (int y = 0; y < this.getHeight(); y += 50) {
				for (int i = 0; i < this.getWidth(); i += 50) {
					g.drawString("-", i, y);
					g.drawString("|", i, y);
					g.drawString(Integer.toString(y), this.getWidth() - 30, y);
					g.drawString(Integer.toString(i), i, this.getHeight() - 30);
				}
			}
		} else if (control.isRoom3()) {
			ImageIcon Room = new ImageIcon("Pics//floors//rooms//room3.png");
			room3 = Room.getImage();
			d.drawImage(room3, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);
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
				d.drawImage(standing, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
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
				d.drawImage(up, character.getX(), character.getY(), character.getWidth(), character.getHeight(), this);
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
				d.drawImage(standing, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
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
				d.drawImage(up, character.getX(), character.getY(), character.getWidth(), character.getHeight(), this);
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
				d.drawImage(standing, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
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
				d.drawImage(up, character.getX(), character.getY(), character.getWidth(), character.getHeight(), this);
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
				if (door.equals(door1)) {
					control.setFloor1(false);
					control.setBasement(true);
					character.setX(800);
					character.setY(750);
				} else if (door.equals(door2)) {
					control.setFloor1(false);
					control.setFloor2(true);
					character.setX(2350);
					character.setY(900);
				} else if (door.equals(door3)) {
					control.setFloor2(false);
					control.setRoom1(true);
					// character.setX(x in new room);
					// character.setY(y in new room);
				} else if (door.equals(door4)) {
					// second room in floor 2
					control.setFloor2(false);
					control.setRoom2(true);
					// character.setX(x in new room);
					// character.setY(y in new room);
				} else if (door.equals(door5)) {
					// third room in floor 2
					// character.setX(x in new room);
					// character.setY(y in new room);
				} else if (door.equals(door6)) {
					control.setFloor1(true);
					control.setFloor2(false);
					character.setX(2100);
					character.setY(150);
				} else if (door.equals(door7)) {
					control.setFloor2(false);
					control.setFloor3(true);
					character.setX(2300);
					character.setY(850);
				} else if (door.equals(door8)) {
					// first room in floor 3
					// character.setX(x in new room);
					// character.setY(y in new room);
				} else if (door.equals(door9)) {
					// second room in floor 3
					// character.setX(x in new room);
					// character.setY(y in new room);
				} else if (door.equals(door10)) {
					// third room in floor 3
					// character.setX(x in new room);
					// character.setY(y in new room);
				} else if (door.equals(door11)) {
					control.setFloor3(false);
					control.setFloor2(true);
					character.setX(1700);
					character.setY(1050);
				} else if (door.equals(door12)) {
					control.setFloor1(true);
					control.setBasement(false);
					character.setX(600);
					character.setY(1000);
				} else if (door.equals(door13)) {
					// first room in basement
					// character.setX(x in new room);
					// character.setY(y in new room);
				} else if (door.equals(door14)) {
					// bunker room in basement
					// character.setX(x in new room);
					// character.setY(y in new room);
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
		if (key.collider(character)) {
			if (control.isiPressed() == true) {
				// change to if statements like in doors
				key1Visible = false;
				character.setKey(true);
			}
		}
	}

	public void NPCCollision(NPC ai) {
		if (ai.collider(character) == true) {
			if (control.isiPressed() == true) {
				Dialouge = ai.getSaying();
			}
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

			pong.collider(character);

			if (key1Visible) {
				keyCollision(key1);
			}

			doorCollision(door1);
			doorCollision(door2);
			doorCollision(MainDoor);

		} else if (control.isFloor2()) {
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
		} else if (control.isFloor3()) {
			wall15.collider(character);
			wall16.collider(character);
			wall17.collider(character);
			wall18.collider(character);
			wall19.collider(character);
			wall20.collider(character);
			wall28.collider(character);

			doorCollision(door8);
			doorCollision(door9);
			doorCollision(door10);
			doorCollision(door11);
		} else if (control.isBasement()) {
			wall21.collider(character);
			wall22.collider(character);
			wall23.collider(character);
			wall24.collider(character);
			wall25.collider(character);
			wall26.collider(character);
			wall27.collider(character);

			doorCollision(door12);
			doorCollision(door13);
			doorCollision(door14);
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
