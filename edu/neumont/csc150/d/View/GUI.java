package edu.neumont.csc150.d.View;

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
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import edu.neumont.csc150.d.Controller.Control;
import edu.neumont.csc150.d.Model.Player;

public class GUI implements ActionListener {
	private JFrame frame;
	private JButton NewGame, Errlin, Lawrence, David, LoadGame, Quit, Resume, MainMenu;
	private JPanel window;
	private GameGraphics test;
	private Control control;
	private Audio audio = new Audio();
	private Player player;
	public void guiMain(GameGraphics game, Control c, Player p) {
		frame = new JFrame("NUHorror");
		test = game;
		control = c;
		player = p;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		try {
			mainPanel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		audio.mainMenuMusic();
		frame.setVisible(true);
	}
	
	public void guiCharacterSelect() {
		frame = new JFrame("Character Select");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		characterSelectPanel();
		frame.setVisible(true);
	}

	public void guiGame(GameGraphics game, Control c) {
		frame = new JFrame("NUHorror");
		test = game;
		control = c;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(test);
		
//		if (control.isFloor1() == true) {
			audio.basementMusic();
//		}
//		if (control.isFloor2() == true) {
//			audio.mainMenuMusic();
//		}
//		if (control.isFloor3() == true) {
//			audio.mainMenuMusic();
//		}
		
		frame.setVisible(true);
	}

	public void mainPanel() throws IOException {

		window = new JPanel();
		// FlowLayout lay = new FlowLayout(100, 500, 1000);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == NewGame) {
			frame.dispose();
//			guiGame(test, control);
			guiCharacterSelect();
		} 
		if (e.getSource() == Errlin) {
			frame.dispose();
			guiGame(test, control);
			player.setEarl(true);
		}
		
		if (e.getSource() == Lawrence) {
			frame.dispose();
			guiGame(test, control);
			player.setLaw(true);
		}
		
		if (e.getSource() == David) {
			frame.dispose();
			guiGame(test, control);
			player.setDave(true);
		}
		
		else if (e.getSource() == LoadGame) {
		} 
		
		else if (e.getSource() == Quit) {
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
	}
}