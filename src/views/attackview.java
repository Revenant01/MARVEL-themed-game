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
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.world.Direction;

public class attackview extends JFrame implements ActionListener{
private Controller controller;
private JButton ok;
private JTextField a;
private JButton up;
private JButton down;
private JButton left;
private JButton right;
private BoardView view;
public attackview(Controller c,BoardView v) {
	controller =c;
	view = v;
	ok = new JButton();
	ok.setFont(new Font("Comic Sans",Font.BOLD,25));
	ok.setText("OK");
	ok.addActionListener(this);
	ok.setIconTextGap(-15);
	ok.setForeground(Color.black);
	ok.setBackground(Color.LIGHT_GRAY);
	ok.setBounds(50, 300, 200, 50);
	
	//The Textfield of the first player
	up = new JButton();
	up.setFont(new Font("Comic Sans",Font.BOLD,25));
	up.setText("UP");
	up.addActionListener(this);
	up.setIconTextGap(-15);
	up.setForeground(Color.black);
	up.setBackground(Color.LIGHT_GRAY);
	up.setBounds(150, 50, 200, 50);
	down = new JButton();
	down.setFont(new Font("Comic Sans",Font.BOLD,25));
	down.setText("DOWN");
	down.addActionListener(this);
	down.setIconTextGap(-15);
	down.setForeground(Color.black);
	down.setBackground(Color.LIGHT_GRAY);
	down.setBounds(150, 100, 200, 50);
	right = new JButton();
	right.setFont(new Font("Comic Sans",Font.BOLD,25));
	right.setText("RIGHT");
	right.addActionListener(this);
	right.setIconTextGap(-15);
	right.setForeground(Color.black);
	right.setBackground(Color.LIGHT_GRAY);
	right.setBounds(150,150, 200, 50);
	left = new JButton();
	left.setFont(new Font("Comic Sans",Font.BOLD,25));
	left.setText("LEFT");
	left.addActionListener(this);
	left.setIconTextGap(-15);
	left.setForeground(Color.black);
	left.setBackground(Color.LIGHT_GRAY);
	left.setBounds(150, 200, 200, 50);
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
	layeredPane.add(up, Integer.valueOf(1));
	layeredPane.add(down, Integer.valueOf(1));
	layeredPane.add(right, Integer.valueOf(1));
	layeredPane.add(left, Integer.valueOf(1));
//	layeredPane.add(backgroundImage ,Integer.valueOf(0));
	
	
	//The frame 
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setLayout(null);
	this.setLocation(new Point(600,250));
	this.setSize(600,300);
	this.setTitle("attack direction");
	this.setBackground(Color.LIGHT_GRAY);
	this.add(layeredPane);
}

public Controller getController() {
	return controller;
}
public void setController(Controller controller) {
	this.controller = controller;}
public JTextField geta() {
	return a;
}
public void seta(JTextField a) {
	this.a = a;
}
public JButton getButton() {
	return ok;
}
public void setButton(JButton button) {
	this.ok = button;}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==up) {
				try {
					getController().getGame().attack(Direction.DOWN);
					getController().toBoardView();
					view.dispose();
				} catch (NotEnoughResourcesException e1) {
					new PopupView(e1.getMessage());
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				} catch (ChampionDisarmedException e1) {
					// TODO Auto-generated catch block
					new PopupView(e1.getMessage());
					//e1.printStackTrace();
				} catch (InvalidTargetException e1) {
					// TODO Auto-generated catch block
					new PopupView(e1.getMessage());
					//e1.printStackTrace();
				}
		}
		if(e.getSource()==down) {
			try {
				getController().getGame().attack(Direction.UP);
				getController().toBoardView();
				view.dispose();
			} catch (NotEnoughResourcesException e1) {
				new PopupView(e1.getMessage());
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			} catch (ChampionDisarmedException e1) {
				// TODO Auto-generated catch block
				new PopupView(e1.getMessage());
				//e1.printStackTrace();
			} catch (InvalidTargetException e1) {
				// TODO Auto-generated catch block
				new PopupView(e1.getMessage());
				//e1.printStackTrace();
			}
		}
		if(e.getSource()==right) {
			try {
				getController().getGame().attack(Direction.RIGHT);
				getController().toBoardView();
				view.dispose();
			} catch (NotEnoughResourcesException e1) {
				new PopupView(e1.getMessage());
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			} catch (ChampionDisarmedException e1) {
				// TODO Auto-generated catch block
				new PopupView(e1.getMessage());
				//e1.printStackTrace();
			} catch (InvalidTargetException e1) {
				// TODO Auto-generated catch block
				new PopupView(e1.getMessage());
				//e1.printStackTrace();
			}
		}
		if(e.getSource()==left) {
			try {
				getController().getGame().attack(Direction.LEFT);
				getController().toBoardView();
				view.dispose();
			} catch (NotEnoughResourcesException e1) {
				new PopupView(e1.getMessage());
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			} catch (ChampionDisarmedException e1) {
				// TODO Auto-generated catch block
				new PopupView(e1.getMessage());
				//e1.printStackTrace();
			} catch (InvalidTargetException e1) {
				// TODO Auto-generated catch block
				new PopupView(e1.getMessage());
				//e1.printStackTrace();
			}
		}
		this.dispose();

}
}
