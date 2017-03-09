package edu.neumont.csc150.d.View;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import edu.neumont.csc150.d.Controller.Control;
import edu.neumont.csc150.d.Controller.SaveLoad;
//import edu.neumont.csc150.d.Controller.SaveLoad;
import edu.neumont.csc150.d.Model.Player;

/*
 *Class creates all the frames for the game. Class also houses the Java menu. Java Menu options
 *include Save, Load, and Main Menu. 
 */

public class GUI implements ActionListener {
	private JFrame frame;
	public JButton Errlin, Lawrence, David, NewGame, LoadGame, SaveGame, Quit, Resume, MainMenu;
	private JPanel window;
	private GameGraphics test;
	private Control control;
	private Audio audio = new Audio();
	private Audio audio2 = new Audio();
	private Player player;
	private SaveLoad sl = new SaveLoad();
	private ImageIcon img = new ImageIcon("Pics//NU.png");

	
	/**
	 * builds a GUI object
	 * @param game - Creates a reference to the already existing variable instance of GameGraphics
	 * @param c - Creates a reference to the already existing variable instance of Control
	 * @param p - Creates a reference to the already existing variable instance of Player
	 */
	
	public GUI(GameGraphics game, Control c, Player p) {
		test = game;
		control = c;
		player = p;
	}
	
	/**
	 *Creates the frame for the Main Menu of the game. 
	 */
	
	public void guiMain() {
		frame = new JFrame("NUHorror");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		try {
			mainPanel();
		} catch (IOException e) {
			e.printStackTrace();
		}
		audio.mainMenuMusic();
		frame.setVisible(true);
	}
	
	/**
	 * Creates a new frame for the character select
	 */
	
	public void guiCharacterSelect() {
		frame = new JFrame("Character Select");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		characterSelectPanel();
		frame.setVisible(true);
	}
	
	/**
	 * Creates a new frame for the actual game to be displayed on
	 * @param game - Creates a reference to the varaible of type GameGraphics
	 * @param c - Creates a reference to the variable of type Control
	 */
	
	public void guiGame(GameGraphics game, Control c) {
		frame = new JFrame("NUHorror");
		frame.setIconImage(img.getImage());
		test = game;
		control = c;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		menuItems(frame);
		audio.mainMenuMusicStopped();
		
		audio.gameMusic(control);
		
		frame.getContentPane().add(test);
		frame.setVisible(true);
	}

	/**
	 * Creates the buttons that are displayed on the Main Menu frame as well as the art
	 * @throws IOException - catches any exception the coder might have created
	 */
	
	public void mainPanel() throws IOException {
		window = new JPanel();
		window.setLayout(null);

		NewGame = new JButton("Start");
		NewGame.setBounds(500, 1100, 250, 100);
		NewGame.setIcon(new ImageIcon("Pics//Start.jpg"));
		NewGame.setIconTextGap(-30);
		NewGame.addActionListener(this);
		LoadGame = new JButton("Load");
		LoadGame.setBounds(1150, 1100, 250, 100);
		LoadGame.setIcon(new ImageIcon("Pics//Load.jpg"));
		LoadGame.setIconTextGap(-30);
		LoadGame.addActionListener(this);
		Quit = new JButton("Quit");
		Quit.setBounds(1800, 1100, 250, 100);
		Quit.setIcon(new ImageIcon("Pics//Quit.jpg"));
		Quit.setIconTextGap(-30);
		Quit.addActionListener(this);

		frame.getContentPane().add(NewGame);
		frame.getContentPane().add(LoadGame);
		frame.getContentPane().add(Quit);
		frame.getContentPane().add(new MenuGraphics("Pics//MainMenu.jpg"));
	}
	
	/**
	 *Creates and sets the buttons and art displayed on the buttons to be displayed on characterSelect
	 *frame
	 */
	
	public void characterSelectPanel() {
		window = new JPanel();
		GridLayout layout = new GridLayout(1,3,10,10);
		window.setLayout(layout);
		
		Errlin = new JButton();
		Errlin.setIcon(new ImageIcon("Pics//character portraits//Errlin.png"));
		Errlin.setForeground(Color.red);
		Errlin.setVerticalAlignment(SwingConstants.BOTTOM);
		Errlin.setVerticalTextPosition(SwingConstants.BOTTOM);
		Errlin.setText("Errlin");
		Errlin.setFont(new Font("Impact", Font.PLAIN, 100));
		Errlin.setIconTextGap(-800);
		Errlin.addActionListener(this);
		
		Lawrence = new JButton();
		Lawrence.setIcon(new ImageIcon("Pics//character portraits//Lawrence.png"));
		Lawrence.setForeground(Color.red);
		Lawrence.setVerticalAlignment(SwingConstants.BOTTOM);
		Lawrence.setVerticalTextPosition(SwingConstants.BOTTOM);
		Lawrence.setText("Lawrence");
		Lawrence.setFont(new Font("Impact", Font.PLAIN, 100));
		Lawrence.setIconTextGap(-890);
		Lawrence.addActionListener(this);
		
		
		David = new JButton();
		David.setIcon(new ImageIcon("Pics//character portraits//David.png"));
		David.setForeground(Color.red);
		David.setVerticalAlignment(SwingConstants.BOTTOM);
		David.setVerticalTextPosition(SwingConstants.BOTTOM);
		David.setText("David");
		David.setFont(new Font("Impact", Font.PLAIN, 100));
		David.setIconTextGap(-700);
		David.addActionListener(this);
		
		window.add(Errlin);
		window.add(Lawrence);
		window.add(David);
		
		frame.getContentPane().add(window);
	}
	
	/**
	 * Creates the Java Menu items for the game
	 * @param frame - the frame displayed. (guiGame frame)
	 */
	
	public void menuItems(JFrame frame) {
		JMenuItem saveGame = new JMenuItem("Save Game");
		saveGame.addActionListener(this);
		saveGame.setFont(saveGame.getFont().deriveFont(25.0f));
		JMenuItem loadGame = new JMenuItem("Load Game");
		loadGame.addActionListener(this);
		loadGame.setFont(loadGame.getFont().deriveFont(25.0f));
		JMenuItem mainMenu = new JMenuItem("Main Menu");
		mainMenu.addActionListener(this);
		mainMenu.setFont(mainMenu.getFont().deriveFont(25.0f));
		JMenu menu = new JMenu("Options");
		menu.setFont(menu.getFont().deriveFont(20.0f));
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(menuBar.getFont().deriveFont(25.0f));

		menu.add(saveGame);
		menu.add(loadGame);
		menu.add(mainMenu);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
	}
	
	/**
	 * Creates action listeners for the Menu Items and the JButtons
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		//Starts a new game
		if (e.getSource() == NewGame) {
			frame.dispose();
			guiCharacterSelect();
		}
		
		//In character select if Errlin is chosen, it loads up game with Errlin's character sprite 
		if (e.getSource() == Errlin) {
			frame.dispose();
			guiGame(test, control);
			player.setEarl(true);
		}
		
		//In character select if Lawrence is chosen, it loads up game with Lawrence's character sprite 
		if (e.getSource() == Lawrence) {
			frame.dispose();
			guiGame(test, control);
			player.setLaw(true);
		}
		
		//In character select if David is chosen, it loads up game with David's character sprite 
		if (e.getSource() == David) {
			frame.dispose();
			guiGame(test, control);
			player.setDave(true);
		}
		
		if (e.getSource() == LoadGame) {
			try {
				sl.load(control, player);
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
		}
		
		//On Main Menu if quit is selected the frame closes
		else if (e.getSource() == Quit) {
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
		
		//The Menu Items for the game
		if (e.getSource() instanceof JMenuItem) {
			JMenuItem menuItem = (JMenuItem)e.getSource();
			
			//Save game allows user to save everything
			if (menuItem.getText().equals("Save Game")) {
//				try {
//					sl.save(control, player);
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
			}
			//Load game allows player to load his previous progress 
			else if (menuItem.getText().equals("Load Game")) {
//				try {
//					sl.load(control, player);
//				} catch (ClassNotFoundException | IOException e1) {
//					e1.printStackTrace();
//				}
			}
			//Main Menu allow player to go back to the main menu. Reseting all progress in the process
			else if (menuItem.getText().equals("Main Menu")) {
				frame.dispose();
				test.reset();
				audio.stopMusic();
				guiMain();
			}
		}
	}
}