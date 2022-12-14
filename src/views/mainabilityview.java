package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

import Conroller.Controller;

public class mainabilityview extends JFrame  implements ActionListener{
private Controller controller;
JButton button1;
JButton button2;
JButton button3;
private BoardView view;
public mainabilityview(Controller s,BoardView v) {
	controller=s;
	view = v;
	//The 'ok' button
	button1 = new JButton();
	button1.setFont(new Font("Comic Sans",Font.BOLD,25));
	button1.setText("Other");
	//button1.addActionListener(this);
	button1.setIconTextGap(-15);
	button1.setForeground(Color.black);
	button1.setBackground(Color.LIGHT_GRAY);
	button1.setBounds(50, 200, 300, 50);
	button1.addActionListener(this);
	
	//The Textfield of the first player
	button2 = new JButton();
	button2.setFont(new Font("Comic Sans",Font.BOLD,25));
	button2.setText("Directional ability");
	//button2.addActionListener(this);
	button2.setIconTextGap(-15);
	button2.setForeground(Color.black);
	button2.setBackground(Color.LIGHT_GRAY);
	button2.setBounds(50, 250, 300, 50);
	button2.addActionListener(this);
	
	//The text "firstPlayerName" 
	
	//The Textfield of the first player
	button3 = new JButton();
	button3.setFont(new Font("Comic Sans",Font.BOLD,25));
	button3.setText("Single target ability");
	//button3.addActionListener(this);
	button3.setIconTextGap(-15);
	button3.setForeground(Color.black);
	button3.setBackground(Color.LIGHT_GRAY);
	button3.setBounds(50, 300, 300, 50);
	button3.addActionListener(this);
	
	//The text "secondPlayerName" 
	JLabel ability= new JLabel();
	//secondPlayer.setOpaque(true);
	ability.setText(" which one  do you want :");
	ability.setForeground(Color.BLACK);
	ability.setFont(new Font("Arial Black",Font.BOLD,20));
	ability.setBounds(10,100,300,30);
	
	
	//The backgrund image
	JLabel backgroundImage= new JLabel();
	backgroundImage.setOpaque(true);
	ImageIcon backGround = new ImageIcon("marvel logo.PNG");
	backgroundImage.setIcon(backGround);
	//backgroundImage.setBackground(Color.RED);
	backgroundImage.setBounds(0,0,600,300);
	
	
	//The layerd pane
	JLayeredPane layeredPane = new JLayeredPane();
	layeredPane.setBounds(0,0,600,300);
	
	this.add(button1);
	this.add(button2);
	this.add(button3);
	this.add(ability);
	//layeredPane.add(button1, Integer.valueOf(1));
	//layeredPane.add(button2, Integer.valueOf(1));
	//layeredPane.add(button3, Integer.valueOf(1));
	//layeredPane.add(ability, Integer.valueOf(1));
	//layeredPane.add(secondPlayerName, Integer.valueOf(1));
//	layeredPane.add(backgroundImage ,Integer.valueOf(0));
	
	
	//The frame 
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setLayout(null);
	this.setLocation(new Point(600,250));
	this.setSize(400,400);
	this.setBackground(Color.LIGHT_GRAY);
	//this.add(layeredPane);
}
public Controller getController() {
	return controller;
}
public void setController(Controller controller) {
	this.controller = controller;
}
public JButton getButton1() {
	return button1;
}
public void setButton1(JButton button) {
	this.button1 = button;}
public JButton getButton2() {
	return button2;
}
public void setButton2(JButton button) {
	this.button2 = button;}
public JButton getButton3() {
	return button3;
}
public void setButton(JButton button) {
	this.button3 = button;}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==button1) {
		getController().tonormalbilityview(view);
	}
	if(e.getSource()==button2) {
		getController().todirectionalbilityview(view);
	}
	if(e.getSource()==button3) {
		getController().tosinglebilityview(view);
	}
	this.dispose();
	
}
}
