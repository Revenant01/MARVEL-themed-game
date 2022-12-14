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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Conroller.Controller;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.world.Direction;
public class moveview extends JFrame  implements ActionListener{
	private Controller controller;
	private JTextField m;
	private JButton ok;
	private JButton up;
	private JButton down;
	private JButton left;
	private JButton right;
	BoardView view;
	public moveview(Controller c, BoardView v) {
		view = v;
		controller =c;
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
		//The text "firstPlayerName" 
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
		this.setTitle("movedirection");
		this.setBackground(Color.LIGHT_GRAY);
		this.add(layeredPane);
}
	public Controller getController() {
		return controller;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	public JTextField getm() {
		return m;
	}
	public void setm(JTextField m) {
		this.m = m;
	}
	public JButton getButton() {
		return ok;
	}
	public void setButton(JButton button) {
		this.ok = button;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==up) {
			try {
				getController().getGame().move(Direction.DOWN);
				getController().toBoardView();
				int j=0;
				while(j<1000000)
					j++;
				view.dispose();
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				new PopupView(e1.getMessage());
			} catch (UnallowedMovementException e1) {
				// TODO Auto-generated catch block
				new PopupView(e1.getMessage());
			}
	}
	if(e.getSource()==down) {
			try {
				getController().getGame().move(Direction.UP);
				getController().toBoardView();
				int j=0;
				while(j<1000000)
					j++;
				view.dispose();
				
			} catch (NotEnoughResourcesException e1) {
				// TODO Auto-generated catch block
				new PopupView(e1.getMessage());
			} catch (UnallowedMovementException e1) {
				// TODO Auto-generated catch block
				new PopupView(e1.getMessage());
			}
	}
	if(e.getSource()==right) {
		try {
			getController().getGame().move(Direction.RIGHT);
			getController().toBoardView();
			int j=0;
			while(j<1000000)
				j++;
			view.dispose();
		} catch (NotEnoughResourcesException e1) {
			// TODO Auto-generated catch block
			new PopupView(e1.getMessage());
		} catch (UnallowedMovementException e1) {
			// TODO Auto-generated catch block
			new PopupView(e1.getMessage());
		}
	}
	if(e.getSource()==left) {
		try {
			getController().getGame().move(Direction.LEFT);
			getController().toBoardView();
			int j=0;
			while(j<1000000)
				j++;
			view.dispose();
			
		} catch (NotEnoughResourcesException e1) {
			// TODO Auto-generated catch block
			new PopupView(e1.getMessage());
		} catch (UnallowedMovementException e1) {
			// TODO Auto-generated catch block
			new PopupView(e1.getMessage());
		}
	}
	this.dispose();
}
	}
