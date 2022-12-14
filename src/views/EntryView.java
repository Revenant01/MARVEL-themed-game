package views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

import Conroller.Controller;

public class EntryView extends JFrame implements ActionListener
{
	private JButton play;
	private Controller controller;
	
	
	public EntryView()
	{	

		
		//The Button "play" 
		play = new JButton();
//		ImageIcon playclick = new ImageIcon("play.png");
//		play.setIcon(playclick);
//		play.setHorizontalTextPosition(JButton.CENTER);
//		play.setVerticalTextPosition(JButton.BOTTOM);
		play.setFont(new Font("Comic Sans",Font.BOLD,25));
		play.setText("PLAY");
		play.addActionListener(this);
		play.setIconTextGap(-15);
		play.setForeground(Color.black);
		play.setBackground(Color.red);
		play.setBounds(300, 615, 200, 50);
	
		//The image 
		JLabel backgroundImage= new JLabel();
		backgroundImage.setOpaque(true);
		ImageIcon backGround = new ImageIcon("entry.jpg");
		backgroundImage.setIcon(backGround);
		//backgroundImage.setBackground(Color.RED);
		backgroundImage.setBounds(0,0,800,750);
		
		//The text "labeltext" 
		JLabel labelText= new JLabel();
		//labelText.setOpaque(true);
		labelText.setText("M  U   W");
		labelText.setForeground(Color.RED);
		labelText.setFont(new Font("ALGERIAN",Font.BOLD,80));
		labelText.setBounds(250,350,400,400);
		
		JLabel labelText2= new JLabel();
		//labelText.setOpaque(true);
		labelText2.setText("Marvel Ultimate War");
		labelText2.setForeground(Color.RED);
		labelText2.setFont(new Font("ALGERIAN",Font.BOLD,25));
		labelText2.setBounds(250,400,400,400);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0,0,800,750);
		layeredPane.add(backgroundImage, Integer.valueOf(0));
		layeredPane.add(labelText, Integer.valueOf(1));
		layeredPane.add(labelText2, Integer.valueOf(2));
		layeredPane.add(play , Integer.valueOf(2));
		
		//The frame
		ImageIcon logo = new ImageIcon("logo.jpeg");
		this.setIconImage(logo.getImage());
		this.setLocation(new Point(250,20));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(800, 730);
		this.setTitle("Marvel Ultimate War");
		this.add(layeredPane);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == play)
		{
			this.dispose();
			//this.setVisible(false);
			
			getController().toNamesFrame();
			
		}
		
		
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	
}
