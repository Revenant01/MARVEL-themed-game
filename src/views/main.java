/*
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class main implements ActionListener
{
	public static void main (String[] args)
	{
	/*
		JFrame frame = new JFrame(); //creates a frame
		  frame.setTitle("JFrame title goes here"); //sets title of frame
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit from application
		  frame.setResizable(false); //prevent frame from being resized
		  frame.setSize(420,420); //sets the x-dimension, and y-dimension of frame
		  frame.setVisible(true); //make frame visible
		  
		  ImageIcon image = new ImageIcon("logo.png"); //create an ImageIcon
		  frame.setIconImage(image.getImage()); //change icon of frame
		  frame.getContentPane().setBackground(new Color(0x123456)); //change color of background
		 
		  		// JLabel = a GUI display area for a string of text, an image, or both
		  		
		  		ImageIcon image2 = new ImageIcon("dude.png");
		  		Border border = BorderFactory.createLineBorder(Color.green,3);
		  		
		  		JLabel label = new JLabel(); //create a label
		  		label.setText("bro, do you even code?"); //set text of label
		  		label.setIcon(image);
		  		label.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT,CENTER, RIGHT of imageicon
		  		label.setVerticalTextPosition(JLabel.TOP); //set text TOP,CENTER, BOTTOM of imageicon
		  		label.setForeground(new Color(0x00FF00)); //set font color of text
		  		label.setFont(new Font("MV Boli",Font.PLAIN,100)); //set font of text
		  		label.setIconTextGap(-25); //set gap of text to image
		  		label.setBackground(Color.black); //set background color
		  		label.setOpaque(true); //display background color
		  		//label.setBorder(border); //sets border of label (not image+text)
		  		label.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text within label
		  		label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label
		  		//label.setBounds(100, 100, 250, 250); //set x,y position within frame as well as dimensions
		  			
		  		JFrame frame2 = new JFrame();
		  		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  		//frame.setSize(500,500);
		  		//frame.setLayout(null);
		  		frame2.setVisible(true);	 
		  		frame2.add(label);
		  		frame2.pack();
		  		
		  		// JPanel = a GUI component that functions as a container to hold other components
				ImageIcon icon = new ImageIcon("thumbsup.png");
				
				JLabel label2 = new JLabel();
				label.setText("Hi");
				label.setIcon(icon);
				label.setVerticalAlignment(JLabel.TOP);
				label.setHorizontalAlignment(JLabel.LEFT);
				//label.setBounds(100, 100, 75, 75);
				
				JPanel redPanel = new JPanel();
				redPanel.setBackground(Color.red);
				redPanel.setBounds(0, 0, 250, 250);
				redPanel.setLayout(new BorderLayout());
				
				JPanel bluePanel = new JPanel();
				bluePanel.setBackground(Color.blue);
				bluePanel.setBounds(250, 0, 250, 250);
				bluePanel.setLayout(new BorderLayout());
				
				JPanel greenPanel = new JPanel();
				greenPanel.setBackground(Color.green);
				greenPanel.setBounds(0, 250, 500, 250);
				greenPanel.setLayout(new BorderLayout());
				
				JFrame frame3 = new JFrame();
				frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame3.setLayout(null);
				frame3.setSize(750,750);
				frame3.setVisible(true);	
				greenPanel.add(label);
				frame3.add(redPanel);
				frame3.add(bluePanel);
				frame3.add(greenPanel);
		
				/*
				 * import java.awt.event.*;
					import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{

	JButton button;
	JLabel label;
	
	MyFrame(){
		
		ImageIcon icon = new ImageIcon("point.png");
		ImageIcon icon2 = new ImageIcon("face.png");
		
		label = new JLabel();
		label.setIcon(icon2);
		label.setBounds(150, 250, 150, 150);
		label.setVisible(false);
		
		button = new JButton();
		button.setBounds(100, 100, 250, 100);
		button.addActionListener(this);
		button.setText("I'm a button!");
		
		button.setFocusable(false);
		button.setIcon(icon);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setFont(new Font("Comic Sans",Font.BOLD,25));
		button.setIconTextGap(-15);
		button.setForeground(Color.cyan);
		button.setBackground(Color.lightGray);
		button.setBorder(BorderFactory.createEtchedBorder());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,500);
		this.setVisible(true);
		this.add(button);
		this.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			System.out.println("poo");
			button.setEnabled(false);
			label.setVisible(true);
		}	
	}
				 
	
	
		
		
	
	
import javax.swing.*;
import java.awt.*;

public class Main {
 
  public static void main(String[] args) {
   
   // JLayeredPane = Swing container that provides a 
   //    third dimension for positioning components
   //    ex. depth, Z-index     
   
   JLabel label1= new JLabel();
   label1.setOpaque(true);
   label1.setBackground(Color.RED);
   label1.setBounds(50,50,200,200);
   
   JLabel label2= new JLabel();
   label2.setOpaque(true);
   label2.setBackground(Color.GREEN);
   label2.setBounds(100,100,200,200);
   
   JLabel label3= new JLabel();
   label3.setOpaque(true);
   label3.setBackground(Color.BLUE);
   label3.setBounds(150,150,200,200);
   
   JLayeredPane layeredPane = new JLayeredPane();
   layeredPane.setBounds(0,0,500,500);
   
   //layeredPane.add(label1, JLayeredPane.DEFAULT_LAYER);
   layeredPane.add(label1, Integer.valueOf(0));
   layeredPane.add(label2, Integer.valueOf(2));
   layeredPane.add(label3, Integer.valueOf(1));
    
      JFrame frame = new JFrame("JLayeredPane");
      frame.add(layeredPane);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(new Dimension(500, 500));
      frame.setLayout(null);
      frame.setVisible(true);
  }

}
*/