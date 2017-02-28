package edu.neumont.csc150.d.View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CharacterSelect implements ActionListener{
	
	private JFrame frame;
	private JPanel panel;
	private JButton Errlin, Lawrence, David;

	public void characterSelect() {
		panel = new JPanel();
		GridLayout layout = new GridLayout(1,3,10,10);
		panel.setLayout(layout);
		
		Errlin = new JButton("Errlin");
		Errlin.setIcon(new ImageIcon("Art//character portraits//Errlin"));
		Lawrence = new JButton("Lawrence");
		Lawrence.setIcon(new ImageIcon("Art//character portraits//Lawrence"));
		David = new JButton("David");
		David.setIcon(new ImageIcon("Art//character portraits//David"));
		
//		Errlin.setBounds(500, 500, 2000, 1000);
		panel.add(Errlin);
		panel.add(Lawrence);
		panel.add(David);
		
		frame.getContentPane().add(panel);
	}
	
	public void GUI() {
		frame = new JFrame("Character Select");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		characterSelect();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Errlin) {
			
		}
		
		if (e.getSource() == Lawrence) {
			
		}
		
		if (e.getSource() == David) {
			
		}
		
	}
}
