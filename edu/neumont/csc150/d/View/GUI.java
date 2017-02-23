package edu.neumont.csc150.d.View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI implements ActionListener{
	private JFrame frame;
	private JButton NewGame, LoadGame, Quit, Resume, MainMenu;
	private JPanel window;
	
	public void guiMain(GameGraphics game) {
		frame = new JFrame("NUHorror");
		mainPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().add(game);
		frame.setVisible(true);
	}
	
	public void mainPanel(){
		window = new JPanel();
		window.setLayout(new GridLayout(3,1,10,10));
		
		NewGame = new JButton("New Game");
		NewGame.setFont(NewGame.getFont().deriveFont(30.0f));
		NewGame.addActionListener(this);
		
		LoadGame = new JButton("Load Game");
		LoadGame.setFont(LoadGame.getFont().deriveFont(30.0f));
		LoadGame.addActionListener(this);
		
		Quit = new JButton("Exit");
		Quit.setFont(Quit.getFont().deriveFont(30.0f));
		Quit.addActionListener(this);
	
		window.add(new JPanel());
		window.add(NewGame);
		window.add(new JPanel());

		window.add(new JPanel());
		window.add(LoadGame);
		window.add(new JPanel());
	
		window.add(new JPanel());
		window.add(Quit);
		window.add(new JPanel());
	
		frame.getContentPane().add(window);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == NewGame){
			
		}else if(e.getSource() == LoadGame){
			
		}else if(e.getSource() == Quit){
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
		
	}
}
