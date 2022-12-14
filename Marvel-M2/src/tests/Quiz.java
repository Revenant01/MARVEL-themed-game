package tests;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import engine.Game;
import engine.Player;
import model.world.Champion;

public class Quiz extends JFrame implements ActionListener{
	private Game game;
	private JFrame frame;
	//private JPanel panel;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private String s1;
	private String s2;
	private String s3;
	Champion c1;
	Champion c2;
	Champion c3;
	
	public Quiz(){
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Player pl1= new Player("");
		Player pl2 = new Player("");
		game = new Game(pl1,pl2);
		try {
			game.loadAbilities("Abilities.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			game.loadChampions("Champions.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setLayout(new BorderLayout());
		
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		
		//a1 = new JTextArea();
		//a2 = new JTextArea();
		//a3 = new JTextArea();
		 
		b1.setPreferredSize(new Dimension(100,100));
		b2.setPreferredSize(new Dimension(100,100));
		b3.setPreferredSize(new Dimension(100,100));
		//this.setDefaultCloseOperation(ABORT);d
		this.add(b1,BorderLayout.NORTH);
		this.add(b2, BorderLayout.CENTER);
		this.add(b3,BorderLayout.SOUTH);
		
		int rand1 = (int) (Math.random()*game.getAvailableChampions().size());
		int rand2 = (int) (Math.random()*game.getAvailableChampions().size());
		int rand3 = (int) (Math.random()*game.getAvailableChampions().size());
		
		
		c1 = game.getAvailableChampions().get(rand1);
		c2 = game.getAvailableChampions().get(rand2);
		c3 = game.getAvailableChampions().get(rand3);
		
	    s1 = "name: "+ c1.getName()+" HP: "+c1.getCurrentHP();
	    s2 = "name: "+ c2.getName()+" HP: "+c2.getCurrentHP();
		s3 = "name: "+ c3.getName()+" HP: "+c3.getCurrentHP();
		
		
		b1.setText(s1);
		b2.setText(s2);
		b3.setText(s3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		//b1.add(a1);
		//b2.add(a2);
		//b3.add(a3);
		
	}
	public static void main(String[]args) {
		new Quiz();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			c1.setCurrentHP(c1.getCurrentHP()-500);
			s1 = "name: "+ c1.getName()+" HP: "+c1.getCurrentHP();
			b1.setText(s1);
		}
		else if(e.getSource()==b2) {
			c2.setCurrentHP(c2.getCurrentHP()-500);
			s2 = "name: "+ c2.getName()+" HP: "+c2.getCurrentHP();
			b2.setText(s2);
		}
		else if(e.getSource()==b3) {
			c3.setCurrentHP(c3.getCurrentHP()-500);
			s3 = "name: "+ c3.getName()+" HP: "+c3.getCurrentHP();
			b3.setText(s3);
		}
		
	}

}
