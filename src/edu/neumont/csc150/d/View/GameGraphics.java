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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

//import com.sun.org.apache.regexp.internal.CharacterArrayCharacterIterator;

import edu.neumont.csc150.d.Controller.Control;
import edu.neumont.csc150.d.Model.Door;
import edu.neumont.csc150.d.Model.Enemy;
import edu.neumont.csc150.d.Model.Key;
import edu.neumont.csc150.d.Model.NPC;
import edu.neumont.csc150.d.Model.Player;
import edu.neumont.csc150.d.Model.Wall;
import edu.neumont.csc150.d.Pong.Runner;

/*
 *Class that creates the graphics for the game. Using paint, all of the rooms, characters, and keys
 *are drawn in this class 
 */

public class GameGraphics extends JPanel implements ActionListener, KeyListener, Serializable {
	private Player character;
	private Control control;
	private Image documents, dialogueBox, theCommons, floor2, floor3, basement, keys, room1, room2, room3, standing,
			down, up, left, right, playerArt, mrCox, gameOver;
	// private String Dialouge = "There's nothing to interact with";
	private ArrayList<String> Objectives = new ArrayList<String>();
	private boolean document = true;
	private Audio audio = new Audio();

	// ListSpot - Each time a key is picked up +1 is added to ListSpot. This
	// allows for the objectives to
	// updated
	private int ListSpot = 0;

	private boolean f2 = false, f3 = false, b = false, p = false;
	private GUI gui;

	// Places each key into a floor/room
	private boolean key1Visible = true;
	private Key key1 = new Key();
	private boolean key2Visible = true;
	private Key key2 = new Key();
	private boolean key3Visible = true;
	private Key key3 = new Key();
//	private boolean coxHere = true;
	private Enemy cox = new Enemy();

	// Collision for all walls and doors as well as the ping pong table for
	// commons area. Starting area.
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
	private Door door1 = new Door(950, 925, 50, 200, false, '0');
	private Door door2 = new Door(2275, 125, 100, 275, false, '0');
	private Door MainDoor = new Door(2275, 1200, 200, 250, true, '0');

	// Collision for all walls and doors for floor 2
	private Wall wall10 = new Wall(0, 275, 60, 250);
	private Wall wall11 = new Wall(375, 275, 1150, 350);
	private Wall wall12 = new Wall(1500, 850, 50, 300);
	private Wall wall13 = new Wall(2150, 0, 450, 850);
	private Wall wall14 = new Wall(2160, 1080, 540, 270);
	private Door door3 = new Door(60, 275, 315, 210, true, 'a');
	private Door door4 = new Door(1400, 625, 100, 425, true, 'b');
	// private Door door5 = new Door(1400, 1000, 150, 475, false);
	private Door door6 = new Door(2500, 850, 50, 300, false, '0');
	private Door door7 = new Door(1550, 1250, 625, 100, false, '0');

	// Collision for all walls and doors for floor 3
	private Wall wall15 = new Wall(0, 0, 675, 1350);
	private Wall wall16 = new Wall(650, 525, 200, 200);
	private Wall wall17 = new Wall(1050, 1250, 1450, 150);
	private Wall wall18 = new Wall(2500, 1175, 100, 200);
	private Wall wall19 = new Wall(2500, 0, 100, 670);
	private Wall wall20 = new Wall(1900, 50, 300, 600);
	private Wall wall28 = new Wall(650, 500, 100, 50);
	private Door door8 = new Door(500, 75, 200, 250, true, 'c');
	private Door door9 = new Door(500, 800, 200, 250, true, 'd');
	// private Door door10 = new Door(500, 1250, 500, 150, false);
	private Door door11 = new Door(2500, 670, 100, 505, false, '0');

	// Collision for all walls and doors for basement
	private Wall wall21 = new Wall(0, 0, 475, 850);
	private Wall wall22 = new Wall(0, 0, 275, 1350);
	private Wall wall23 = new Wall(0, 1000, 1200, 350);
	private Wall wall24 = new Wall(1500, 0, 1050, 1350);
	private Wall wall25 = new Wall(1200, 0, 1350, 425);
	private Wall wall26 = new Wall(1400, 825, 1150, 575);
	private Wall wall27 = new Wall(1425, 425, 1150, 150);
	private Door door12 = new Door(750, 875, 200, 650, false, '0');
	private Door door13 = new Door(450, 50, 50, 250, true, 'e');
	private Door door14 = new Door(1200, 1250, 200, 150, true, 'f');

	// Collision for all walls and doors for room 1
	private Wall wall29 = new Wall(0, 0, 100, 1350);
	private Wall wall30 = new Wall(0, 0, 2550, 150);
	private Wall wall31 = new Wall(0, 1230, 2550, 100);
	private Wall wall32 = new Wall(2350, 0, 200, 475);
	private Wall wall33 = new Wall(2350, 975, 200, 375);
	private Wall wall34 = new Wall(100, 150, 125, 125);
	private Wall wall35 = new Wall(310, 375, 115, 875);
	private Wall wall36 = new Wall(600, 375, 115, 875);
	private Wall wall37 = new Wall(965, 375, 115, 875);
	private Wall wall38 = new Wall(1200, 375, 115, 875);
	private Wall wall39 = new Wall(1450, 375, 115, 875);
	private Wall wall40 = new Wall(1765, 375, 115, 875);
	private Wall wall41 = new Wall(1990, 375, 115, 875);
	private Wall wall42 = new Wall(820, 275, 150, 120);
	private Wall wall43 = new Wall(1550, 275, 150, 120);
	private Door door15 = new Door(2350, 475, 100, 500, false, '0');
	private Door door17 = new Door(2350, 475, 100, 500, false, '0');

	// Collision for all walls and doors for room 2
	private Wall wall44 = new Wall(0, 0, 100, 1350);
	private Wall wall45 = new Wall(150, 50, 100, 150);
	private Wall wall46 = new Wall(450, 235, 120, 1000);
	private Wall wall47 = new Wall(875, 235, 120, 1000);
	private Wall wall48 = new Wall(1125, 350, 1375, 900);
	private Wall wall49 = new Wall(1125, 0, 1375, 900);

	private Wall Document = new Wall(200, 150, 80, 60);

	private Door door16 = new Door(1125, 150, 100, 200, false, '0');
	private Door door18 = new Door(1125, 150, 100, 200, false, '0');
	private Door door19 = new Door(1125, 150, 100, 200, false, '0');

	// Timer for movement within the game
	public Timer timer = new Timer(1000 / 30, this);

	/**
	 * builds a GameGraphics obj
	 * 
	 * @param chara
	 *            - Creates a reference to the already existing variable
	 *            instance of Player
	 * @param c
	 *            - Creates a reference to the already existing variable
	 *            instance of Control
	 * @param g
	 *            - Creates a reference to the already existing variable
	 *            instance of GUI
	 */

	public GameGraphics(Player chara, Control c, GUI g) {
		character = chara;
		control = c;
		gui = g;

		// Dialogue of character letting player know what they need to do
		Objectives.add("Maybe there is something in the school that I could use.");
		Objectives.add("I've got to figure out what this key's purpose is.");
		Objectives.add("There's another key. I should go pick it up.");
		Objectives.add("I should find another room to open.");
		Objectives.add("What do you know. There's another key!");
		Objectives.add("What's with all these KEYS!");
		Objectives.add("Maybe there's something else I can find.");
		Objectives.add("Let's see what this says. I should check my files.");

		setFocusable(true);
		addKeyListener(this);
		timer.start();
	}

	/**
	 * Method sets objects that will let the player know what they need to do
	 * after pressing "O" Letting them know in the form of character dialogue
	 * 
	 * @param d
	 *            - Creates a graphics 2D object
	 * @param g
	 *            - Creates a graphics object
	 */

	public void Objective(Graphics2D d, Graphics g) {
		if (control.isoPressed()) {
			ImageIcon dialogue = new ImageIcon("Pics//box.png");
			dialogueBox = dialogue.getImage();
			d.drawImage(dialogueBox, 10, 800, 2500, 500, this);

			// For Errlin character
			if (this.character.isEarl()) {
				ImageIcon character = new ImageIcon("Pics//character portraits//Errlin.png");
				playerArt = character.getImage();
				d.drawImage(playerArt, 65, 460, 800, 800, this);
				g.setColor(Color.RED);
				g.setFont(new Font("Impact", Font.PLAIN, 50));
				// Dialouge = "We will figure it out. Don't worry about it.";
				g.drawString(Objectives.get(ListSpot), 700, 900);
			}

			// For Lawrence character
			if (this.character.isLaw()) {
				ImageIcon character = new ImageIcon("Pics//character portraits//Lawrence.png");
				playerArt = character.getImage();
				d.drawImage(playerArt, 65, 460, 800, 800, this);
				g.setColor(Color.RED);
				g.setFont(new Font("Impact", Font.PLAIN, 50));
				// Dialouge = "I just want a switch";
				g.drawString(Objectives.get(ListSpot), 700, 900);
			}

			// For David character
			if (this.character.isDave()) {
				ImageIcon character = new ImageIcon("Pics//character portraits//David.png");
				playerArt = character.getImage();
				d.drawImage(playerArt, 65, 460, 800, 800, this);
				g.setColor(Color.RED);
				g.setFont(new Font("Impact", Font.PLAIN, 50));
				// Dialouge = "The Legend of Zelda: Breath of the Wild is
				// coming";
				g.drawString(Objectives.get(ListSpot), 700, 900);
			}
		}
	}

	// Resets game after player chooses to go back to main menu
	public void reset() {
		if(!timer.isRunning()){
			timer.start();
			}
		this.character.setDave(false);
		this.character.setEarl(false);
		this.character.setLaw(false);
		key1Visible = true;
		key2Visible = true;
		key3Visible = true;
		character.setKey(false);
		door3.setLocked(true);
		door8.setLocked(true);
		door13.setLocked(true);
		ListSpot = 0;
		control.setFloor1(true);
		control.setBasement(false);
		control.setFloor2(false);
		control.setFloor3(false);
		control.setRoom1(false);
		control.setRoom2(false);
		control.setRoom3(false);
		control.setRoom4(false);
		control.setRoom5(false);
		character.setX(2100);
		character.setY(1150);
	}

	/**
	 * Paint method that creates the floors, the keys, the doors, the
	 * characters, and the logic used to traverse through each of the rooms
	 */

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D d = (Graphics2D) g;

		// Draws image for the commons area of the game
		if (control.isFloor1()) {
			ImageIcon commons = new ImageIcon("Pics//floors//commons of horror.png");
			theCommons = commons.getImage();
			d.drawImage(theCommons, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);

			// Checks to see if key is visible on floor
			if (key1Visible) {
				key1 = new Key(1, 0, 300, 100, 40, 'a');
				ImageIcon key = new ImageIcon("Pics//Key.png");
				keys = key.getImage();
				d.drawImage(keys, key1.getX(), key1.getY(), key1.getWidth(), key1.getHeight(), this);
			}
			
			if (!key1Visible) {
				cox = new Enemy(character);
				ImageIcon enemy = new ImageIcon("Pics//Cox.gif");
				mrCox = enemy.getImage();
				d.drawImage(mrCox, cox.getX(), cox.getY(), cox.getWidth(), cox.getHeight(), this);
			}
			Objective(d, g);
		}

		// Draws image for the second floor area of the game
		else if (control.isFloor2()) {
			ImageIcon theSecondFloor = new ImageIcon("Pics//floors//floor 2.png");
			floor2 = theSecondFloor.getImage();
			d.drawImage(floor2, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);

			Objective(d, g);
		}

		// Draws image for the third floor area of the game
		else if (control.isFloor3()) {
			ImageIcon theThirdFloor = new ImageIcon("Pics//floors//floor 3.png");
			floor3 = theThirdFloor.getImage();
			d.drawImage(floor3, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);

			Objective(d, g);
		}

		// Draws image for the basement area of the game
		else if (control.isBasement()) {
			ImageIcon theBasement = new ImageIcon("Pics//floors//basement of horror.png");
			basement = theBasement.getImage();
			d.drawImage(basement, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);

			Objective(d, g);
		} 
		// Draws an image for the Game Over Screen, stops the game, and centers the player position
		else if (control.isGameOver()) {
			ImageIcon youAreDead = new ImageIcon("Pics//Game-Over.jpg");
			gameOver = youAreDead.getImage();
			d.drawImage(gameOver, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);
			timer.stop();
			
			character.setX((this.getWidth() / 2) - 30);
			character.setY(this.getHeight() / 2);
			
			Objective(d, g);
		}

		// Draws image for the room 1 area of the game
		else if (control.isRoom1()) {
			ImageIcon Room = new ImageIcon("Pics//floors//rooms//room1.png");
			room1 = Room.getImage();
			d.drawImage(room1, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);

			// Checks to see if key is visible in room 1
			if (key2Visible) {
				key2 = new Key(1, 60, 1100, 100, 40, 'c');
				ImageIcon key = new ImageIcon("Pics//Key.png");
				keys = key.getImage();
				d.drawImage(keys, key2.getX(), key2.getY(), key1.getWidth(), key1.getHeight(), this);
			}
			
			if (!key2Visible) {
				cox = new Enemy(character);
				ImageIcon enemy = new ImageIcon("Pics//Cox.gif");
				mrCox = enemy.getImage();
				d.drawImage(mrCox, cox.getX(), cox.getY(), cox.getWidth(), cox.getHeight(), this);
			}

			Objective(d, g);
		}

		// Draws image for the room 2 area of the game
		else if (control.isRoom2()) {
			ImageIcon Room = new ImageIcon("Pics//floors//rooms//room2.png");
			room2 = Room.getImage();
			d.drawImage(room2, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);

			Objective(d, g);
		}

		// Draws image for the room 3 area of the game
		else if (control.isRoom3()) {
			ImageIcon Room = new ImageIcon("Pics//floors//rooms//room1.png");
			room1 = Room.getImage();
			d.drawImage(room1, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);

			// Checks to see if key is visible in room 2
			if (key3Visible) {
				key3 = new Key(1, 600, 850, 100, 40, 'e');
				ImageIcon key = new ImageIcon("Pics//Key.png");
				keys = key.getImage();
				d.drawImage(keys, key3.getX(), key3.getY(), key1.getWidth(), key1.getHeight(), this);
			}
			
			if (!key3Visible) {
				cox = new Enemy(character);
				ImageIcon enemy = new ImageIcon("Pics//Cox.gif");
				mrCox = enemy.getImage();
				d.drawImage(mrCox, cox.getX(), cox.getY(), cox.getWidth(), cox.getHeight(), this);
			}

			Objective(d, g);
		}

		// Draws image for the room 4 area of the game
		else if (control.isRoom4()) {
			ImageIcon Room = new ImageIcon("Pics//floors//rooms//room2.png");
			room2 = Room.getImage();
			d.drawImage(room2, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);

			Objective(d, g);
		}

		// Draws image for the room 5 area of the game
		else if (control.isRoom5()) {
			ImageIcon Room = new ImageIcon("Pics//floors//rooms//room2.png");
			room2 = Room.getImage();
			d.drawImage(room2, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);

			Objective(d, g);

			if (document) {
				ImageIcon GameDocument = new ImageIcon("Pics//Paper.png");
				documents = GameDocument.getImage();
				d.drawImage(documents, Document.getX(), Document.getY(), Document.getWidth(), Document.getHeight(),
						this);
			}
		}
		/**
		 * Creates character animations for each character
		 */

		// If Errlin was chosen at character selection screen
		if (character.isEarl() == true) {
			// Character standing animation
			if (!control.iswPressed() && !control.isaPressed() && !control.issPressed() && !control.isdPressed()) {
				ImageIcon image = new ImageIcon("Errlin Walk//front//Errlin2.png");
				standing = image.getImage();
				d.drawImage(standing, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
			}

			// Walking Down animation for Errlin
			else if (control.issPressed()) {
				ImageIcon image1 = new ImageIcon("Errlin Walk//front//animated.gif");
				down = image1.getImage();
				d.drawImage(down, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
			}

			// Walking Up animation for Errlin
			else if (control.iswPressed()) {
				ImageIcon image1 = new ImageIcon("Errlin Walk//Back//animated.gif");
				up = image1.getImage();
				d.drawImage(up, character.getX(), character.getY(), character.getWidth(), character.getHeight(), this);
			}

			// Walking to the right animation for Errlin
			else if (control.isdPressed()) {
				ImageIcon image1 = new ImageIcon("Errlin Walk//side//animated.gif");
				right = image1.getImage();
				d.drawImage(right, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
			}
			// walking to the left animation for Errlin
			else if (control.isaPressed()) {
				ImageIcon image1 = new ImageIcon("Errlin Walk//side//animated.gif");
				left = image1.getImage();
				d.drawImage(left, character.getX() + 60, character.getY(), -(character.getWidth()),
						character.getHeight(), this);
			}
		}

		// If Lawrence is chosen at character selection screen
		else if (character.isLaw() == true) {
			// Lawrence's standing animation
			if (!control.iswPressed() && !control.isaPressed() && !control.issPressed() && !control.isdPressed()) {
				ImageIcon image = new ImageIcon("Lawrence Walk//front//0.png");
				standing = image.getImage();
				d.drawImage(standing, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
			}

			// Walking Down animation for Lawrence
			else if (control.issPressed()) {
				ImageIcon image1 = new ImageIcon("Lawrence Walk//front//animated.gif");
				down = image1.getImage();
				d.drawImage(down, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
			}

			// Walking Up animation for Lawrence
			else if (control.iswPressed()) {
				ImageIcon image1 = new ImageIcon("Lawrence Walk//back//animated.gif");
				up = image1.getImage();
				d.drawImage(up, character.getX(), character.getY(), character.getWidth(), character.getHeight(), this);
			}

			// Walking to the right animation for Lawrence
			else if (control.isdPressed()) {
				ImageIcon image1 = new ImageIcon("Lawrence Walk//side//animated.gif");
				right = image1.getImage();
				d.drawImage(right, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
			}

			// walking to the left animation for Lawrence
			else if (control.isaPressed()) {
				ImageIcon image1 = new ImageIcon("Lawrence Walk//side//animated.gif");
				left = image1.getImage();
				d.drawImage(left, character.getX() + 60, character.getY(), -(character.getWidth()),
						character.getHeight(), this);
			}
		}

		// If David is chosen at character selection screen
		else if (character.isDave() == true) {
			// David's standing animation
			if (!control.iswPressed() && !control.isaPressed() && !control.issPressed() && !control.isdPressed()) {
				ImageIcon image = new ImageIcon("David Walk//front//0.png");
				standing = image.getImage();
				d.drawImage(standing, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
			}

			// Walking Down animation for David
			else if (control.issPressed()) {
				ImageIcon image1 = new ImageIcon("David Walk//front//animated.gif");
				down = image1.getImage();
				d.drawImage(down, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
			}

			// Walking Up animation for David
			else if (control.iswPressed()) {
				ImageIcon image1 = new ImageIcon("David Walk//back//animated.gif");
				up = image1.getImage();
				d.drawImage(up, character.getX(), character.getY(), character.getWidth(), character.getHeight(), this);
			}

			// Walking to the right animation for David
			else if (control.isdPressed()) {
				ImageIcon image1 = new ImageIcon("David Walk//side//animated.gif");
				right = image1.getImage();
				d.drawImage(right, character.getX() + 60, character.getY(), -(character.getWidth()),
						character.getHeight(), this);
			}

			// walking to the left animation for David
			else if (control.isaPressed()) {
				ImageIcon image1 = new ImageIcon("David Walk//side//animated.gif");
				left = image1.getImage();
				d.drawImage(left, character.getX(), character.getY(), character.getWidth(), character.getHeight(),
						this);
			}
		}
		this.repaint();
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------
	// Checks to see if character is colliding with door
	// If character has the right key then the door will open
	public void doorCollision(Door door, char key) {
		if (door.collider(character) == true) {
			// Dialouge = "I do not have the right key for this door";
			if (door.isLocked() == false) {
				if (door.equals(door1)) {
					control.setFloor1(false);
					control.setBasement(true);
					b = false;
					character.setX(800);
					character.setY(750);
				} else if (door.equals(door2)) {
					control.setFloor1(false);
					control.setFloor2(true);
					f2 = true;
					character.setX(2250);
					character.setY(900);
				} else if (door.equals(door3)) {
					control.setFloor2(false);
					control.setRoom1(true);
					character.setX(2150);
					character.setY(600);
				} else if (door.equals(door4)) {
					// second room in floor 2
					control.setFloor2(false);
					control.setRoom2(true);
					character.setX(950);
					character.setY(100);
				} else if (door.equals(door6)) {
					control.setFloor1(true);
					control.setFloor2(false);
					character.setX(2000);
					character.setY(150);
				} else if (door.equals(door7)) {
					control.setFloor2(false);
					control.setFloor3(true);
					f3 = true;
					f2 = false;
					character.setX(2300);
					character.setY(850);
				} else if (door.equals(door8)) {
					// first room in floor 3
					control.setRoom3(true);
					control.setFloor3(false);
					character.setX(2150);
					character.setY(600);
				} else if (door.equals(door9)) {
					// second room in floor 3
					control.setRoom4(true);
					control.setFloor3(false);
					character.setX(950);
					character.setY(100);
				} else if (door.equals(door11)) {
					control.setFloor3(false);
					control.setFloor2(true);
					f2 = true;
					f3 = false;
					character.setX(1700);
					character.setY(1050);
				} else if (door.equals(door12)) {
					control.setFloor1(true);
					control.setBasement(false);
					b = true;
					character.setX(600);
					character.setY(1000);
				} else if (door.equals(door13)) {
					// first room in basement
					control.setRoom5(true);
					control.setBasement(false);
					character.setX(950);
					character.setY(100);
				} else if (door.equals(door14)) {
					// bunker room in basement
					// character.setX(x in new room);
					// character.setY(y in new room);
				} else if (door.equals(door15)) {
					// first room in second floor
					control.setFloor2(true);
					control.setRoom1(false);
					character.setX(150);
					character.setY(150);
				} else if (door.equals(door16)) {
					// second room in second floor
					control.setFloor2(true);
					control.setRoom2(false);
					character.setX(1600);
					character.setY(650);
				} else if (door.equals(door17)) {
					// first room in third floor
					control.setFloor3(true);
					control.setRoom3(false);
					character.setX(750);
					character.setY(200);
				} else if (door.equals(door18)) {
					// second room in third floor
					control.setFloor3(true);
					control.setRoom4(false);
					character.setX(750);
					character.setY(850);
				} else if (door.equals(door19)) {
					// second room in basement
					control.setBasement(true);
					control.setRoom5(false);
					character.setX(550);
					character.setY(100);
				}
			} else if (door.isLocked() == true && character.hasKey() == true) {
				if (door.getKeyType() == key) {
					// Dialouge = "";
					ListSpot++;
					door.setLocked(false);
					character.setKey(false);
				}
			}
		}
	}

	// Checks the collision for the keys
	// If player is colliding with key, they press "i" to pick it up
	public void keyCollision(Key key) {
		if (key.collider(character)) {
			if (control.isiPressed() == true) {
				// Dialouge = "Let's see what this key is used for";
				key1Visible = false;
				if (key.equals(key1)) {
					character.setKeyType(key.getKeyType());
					key1Visible = false;
					ListSpot++; // Moves to the next objective
					audio.clip6.play();
				} else if (key.equals(key2)) {
					character.setKeyType(key.getKeyType());
					key2Visible = false;
					ListSpot++;
					audio.clip6.play();
				} else if (key.equals(key3)) {
					character.setKeyType(key.getKeyType());
					key3Visible = false;
					ListSpot++;
					audio.clip6.play();
				}
				character.setKey(true);
			}
		}
	}

	// Checks NPC Collision
	public void NPCCollision(NPC ai) {
		if (ai.collider(character) == true) {
			if (control.isiPressed() == true) {
				// Dialouge = ai.getSaying();
			}
		}
	}

	// --------------------------------------------------------------------------------------------------------------------------------------------

	/*
	 * Creates interactions with certain objects (Keys)
	 */

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

			if (pong.collider(character)) {
				// Dialouge = "I can interact with the ping pong table";
				if (control.isiPressed()) {
					// load pause
//					Runner run = new Runner();
//					run.runPongGame();
				}
			} else {
				// Dialouge = "There's nothing to interact with";
			}
			if (key1Visible) {
				keyCollision(key1);
			} else if (cox.collider(character)) {
				control.setGameOver(true);
				audio.stopMusic();
				audio.death();
				control.setFloor1(false);
			}

			doorCollision(door1, character.getKeyType());
			doorCollision(door2, character.getKeyType());
			doorCollision(MainDoor, character.getKeyType());

		} else if (control.isFloor2()) {
			wall10.collider(character);
			wall11.collider(character);
			wall12.collider(character);
			wall13.collider(character);
			wall14.collider(character);

			doorCollision(door3, character.getKeyType());
			doorCollision(door4, character.getKeyType());
			doorCollision(door6, character.getKeyType());
			doorCollision(door7, character.getKeyType());

		} else if (control.isFloor3()) {
			wall15.collider(character);
			wall16.collider(character);
			wall17.collider(character);
			wall18.collider(character);
			wall19.collider(character);
			wall20.collider(character);
			wall28.collider(character);

			doorCollision(door8, character.getKeyType());
			doorCollision(door9, character.getKeyType());
			doorCollision(door11, character.getKeyType());

		} else if (control.isBasement()) {
			wall21.collider(character);
			wall22.collider(character);
			wall23.collider(character);
			wall24.collider(character);
			wall25.collider(character);
			wall26.collider(character);
			wall27.collider(character);

			doorCollision(door12, character.getKeyType());
			doorCollision(door13, character.getKeyType());
			doorCollision(door14, character.getKeyType());

		} else if (control.isRoom1()) {
			wall29.collider(character);
			wall30.collider(character);
			wall31.collider(character);
			wall32.collider(character);
			wall33.collider(character);
			wall34.collider(character);
			wall35.collider(character);
			wall36.collider(character);
			wall37.collider(character);
			wall38.collider(character);
			wall39.collider(character);
			wall40.collider(character);
			wall41.collider(character);
			wall42.collider(character);
			wall43.collider(character);

			if (key2Visible) {
				keyCollision(key2);
			} else if (cox.collider(character)) {
				control.setGameOver(true);
				audio.stopMusic();
				audio.death();
				control.setRoom1(false);
			}

			doorCollision(door15, character.getKeyType());

		} else if (control.isRoom2()) {
			wall44.collider(character);
			wall45.collider(character);
			wall46.collider(character);
			wall47.collider(character);
			wall48.collider(character);
			wall49.collider(character);

			doorCollision(door16, character.getKeyType());

		} else if (control.isRoom3()) {
			wall29.collider(character);
			wall30.collider(character);
			wall31.collider(character);
			wall32.collider(character);
			wall33.collider(character);
			wall34.collider(character);
			wall35.collider(character);
			wall36.collider(character);
			wall37.collider(character);
			wall38.collider(character);
			wall39.collider(character);
			wall40.collider(character);
			wall41.collider(character);
			wall42.collider(character);
			wall43.collider(character);

			if (key3Visible) {
				keyCollision(key3);
			} else if (cox.collider(character)) {
				control.setGameOver(true);
				audio.stopMusic();
				audio.death();
				control.setRoom3(false);
			}

			doorCollision(door17, character.getKeyType());

		} else if (control.isRoom4()) {
			wall44.collider(character);
			wall45.collider(character);
			wall46.collider(character);
			wall47.collider(character);
			wall48.collider(character);
			wall49.collider(character);

			doorCollision(door18, character.getKeyType());

		} else if (control.isRoom5()) {
			wall44.collider(character);
			wall45.collider(character);
			wall46.collider(character);
			wall47.collider(character);
			wall48.collider(character);
			wall49.collider(character);

			//If special document is picked up a special txt file will be created in your directory that tells the story
			if (document) {
				if (Document.collider(character)) {
					if (control.isiPressed() == true) {
						audio.clip6.play();
						// place text file int here
						FileOutputStream anotherFile;
						File file = new File("BackStory.txt");
						try {
							anotherFile = new FileOutputStream(file, true);
							PrintStream print = new PrintStream(anotherFile);
							print.println("Cohort 32 Class Reunion");
							print.println("");
							print.println("It’s the year of 2032 and the class of 2019, cohort 32, has decided to have a class reunion.");
							print.println("They decide it’s best if they all have the reunion at the school. That way they can see all");
							print.println("of their former teachers and new students. It’s an exciting time for those past students of");
							print.println("of their former teachers and new students. It’s an exciting time for those past students of");
							print.println("cohort 32. The date for this specific event has been decided to be held on March 21st, 2032.");

							print.println("");
							print.println("");

							print.println("Project Showcase");
							print.println("");
							print.println("The project showcase is also happening at this time, but the students were able to get the ay ok from,");
							print.println("whoever is in charge of such things, and they finalized the date for the reunion to be March 21st, 2032.");
							
							print.println("");
							print.println("");

							print.println("The Biomechanical Outbreak");
							print.println("");
							print.println("During Neumont’s special project showcase event, A student decided that it would be a good idea to ");
							print.println("showcase a biomechanical miniature lifeform to show to his fellow students and professors. His initial ");
							print.println("idea was for the creature to be harmless and intriguing to his audience. But things took a turn for the ");
							print.println("worse, and the creature was all but harmless. It began causing mayhem among the school. It found a host to latch on");
							print.println("to which turned out to be an unlucky professor. After finding its host it worked on trapping everyone that was in the building.");
							
							print.println("");
							print.println("");


							print.println("The Worst Reunion Ever");
							print.println("");
							print.println("The students of Cohort 32 who attended their reunion got caught up in the");
							print.println("mayhem, and no one was able to escape.");
							
							print.println("");
							print.println("");

							print.println("Where We Come In");
							print.println("");
							print.println("There were only three lucky souls who weren’t affected. These three are known");
							print.println("as Lawrence Douglas, Errlin Deleon, and David Duran. They hadn’t been able to make it to the reunion. ");
							print.println("They all agreed that they’d venture off to the school the very next day. The next day they came to school"); 
							print.println("only to find that everything within a 25 mile radius of the school was completely covered in what seemed to be some kind of fleshy substance (Don’t ask). They all seemed");
							print.println("weirded out and started to head back home, but Lawrence decided it would be a good idea to go check it out (decided it wouldn’t be as cliche if the black person decided to go check it out)");
							print.println("With hesitation the gang decided it  would be best to go inside and see just what the hell was going on.");
							
							print.println("");
							print.println("");

							print.println("What Hell Have I Gotten Myself Into");
							print.println("");
							print.println("They journey inside the belly of the beast. They see all kinds of horrific things. Eventually they make it to one student who ");
							print.println("has the answers as to what exactly is going on. They figure out that this student was the cause, but he knows how to undo his wrong doings. ");
							print.println("They eventually figure out how to undo his wrong doings and set forth to find the monster known as, well we haven’t ");
							print.println("come up with a name yet, Mr. Cox. We find and ultimately defeat the monster. The parasite, or whatever we plan to call it, is destroyed and Cox ");
							print.println("is freed. All of the fleshy substance that covered the streets and insides of the school are all gone and everyone is saved.");

						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						document = false;
						ListSpot++;
					}
				}
			}
			doorCollision(door19, character.getKeyType());
		}
		control.move();
		this.repaint();
	}

	/*
	 * KeyEvents for certain pressed buttons P = pause I = Interaction
	 */

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
		} else if (e.getKeyCode() == KeyEvent.VK_O) {
			if(control.isoPressed() == false) {
			control.setoPressed(true);
			
			if (character.isLaw()) {
				audio.lawDialogue(ListSpot);
			}
			
			else if (character.isEarl()) {
				audio.earlDialogue(ListSpot);
			}
			
			else if (character.isDave()) {
				audio.daveDialogue(ListSpot);
			}
			timer.stop();
			}
			else {
				control.setoPressed(false);
				timer.start();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_I) {
			control.setiPressed(true);
		}

		if (e.getKeyCode() == KeyEvent.VK_P) {
			if (control.ispPressed() == false) {
				control.setpPressed(true);
				timer.stop();
			} else {
				control.setpPressed(false);
				timer.start();
			}
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
		}

		this.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}