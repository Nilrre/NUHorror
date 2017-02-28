package edu.neumont.csc150.d.View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.neumont.csc150.d.Controller.Control;

public class GUI implements ActionListener {
	private JFrame frame;
	private JButton NewGame, LoadGame, Quit, Resume, MainMenu;
	private JPanel window;
	private GameGraphics test;
	private Floor1 thisFloor;
	private Control control;
	private Audio audio = new Audio();
	public void guiMain(GameGraphics game, Control c) {
		frame = new JFrame("NUHorror");
		test = game;
		control = c;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frame.getContentPane().add(test);
		try {
			mainPanel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		audio.mainMenuMusic();
		frame.setVisible(true);
	}
	
	public void guiGame(GameGraphics game, Control c) {
		frame = new JFrame("NUHorror");
		test = game;
		control = c;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(test);
		audio.commonsMusic();
		frame.setVisible(true);
	}

	public void mainPanel() throws IOException {

		window = new JPanel();
//		FlowLayout lay = new FlowLayout(100, 500, 1000);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == NewGame) {
			frame.dispose();
			guiGame(test, control);
		} 
		else if (e.getSource() == LoadGame) {

		} 
		else if (e.getSource() == Quit) {
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}

	}
}
