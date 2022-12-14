package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Conroller.Controller;
import exceptions.AbilityUseException;
import exceptions.NotEnoughResourcesException;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.world.Champion;
import model.world.Direction;

public class directionalabilityview  extends JFrame implements ActionListener{
 private Controller controller;
 private JButton ok;
 private JButton up;
 private JButton down;
 private JButton left;
 private JButton right;
 private JLabel label;
 private JTextField d;
 private JTextField n;
 private BoardView view;
private boolean directionchosen;
 private boolean abilitychosen;
 private Ability theability;
 private Direction thedirection;
 int chosen;
 public directionalabilityview(Controller s, BoardView v) {
	   int chosen=0;
	 controller=s;
	 view = v;
	 //direction = false;
	 //ability=false;
	 this.setLayout(new BorderLayout(10,10));   
	    JPanel p1 = new JPanel();
	    JPanel p2 = new JPanel();
	    JPanel p3 = new JPanel();
	    JPanel p4 = new JPanel();
	    JPanel p5 = new JPanel();
	    
	    p1.setPreferredSize(new Dimension(100,100));
		p2.setPreferredSize(new Dimension(100,100));
		p3.setPreferredSize(new Dimension(100,100));
		p4.setPreferredSize(new Dimension(200,200));
		p5.setPreferredSize(new Dimension(100,100));
		
		
		p3.setLayout(new GridLayout());
		this.add(p1,BorderLayout.NORTH);
		this.add(p2,BorderLayout.SOUTH);
		//this.add(p3,BorderLayout.CENTER);
		this.add(p4,BorderLayout.EAST);
		this.add(p5,BorderLayout.WEST);
		
		
		ok= new JButton();
		ok.setFont(new Font("Comic Sans",Font.BOLD,25));
		ok.setText("ok");
		//button1.addActionListener(this);
	//ok.setIconTextGap(-15);
		ok.setForeground(Color.black);
		ok.setBackground(Color.LIGHT_GRAY);
		ok.setBounds(50, 200, 300, 50);
		ok.addActionListener(this);
		 label= new JLabel();
		//secondPlayer.setOpaque(true);
		label.setText(" choose the direction and the ability :");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial Black",Font.BOLD,20));
		label.setBounds(10,50,300,30);
		//d = new JTextField();
		//d.setPreferredSize(new Dimension(100,200));
		//d.setText("DIRECTION");
		//d.setCaretColor(Color.white);
		//d.setFont(new Font("Consolas" , Font.PLAIN, 15));
	    //d.setForeground(Color.red);
		//d.setBounds(30,100,200,30);
		//n = new JTextField();
		//n.setPreferredSize(new Dimension(100,200));
		//n.setText("name of ability ");
		//n.setCaretColor(Color.white);
		//n.setFont(new Font("Consolas" , Font.PLAIN, 15));
	    //n.setForeground(Color.red);
		//n.setBounds(50,150,200,30);
		p1.setLayout(new GridLayout());
		p1.add(label);
		
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//this.setLayout(null);
		this.setLocation(new Point(600,250));
		this.setSize(400,400);
		this.setBackground(Color.LIGHT_GRAY);
		//this.add(label);
		p2.add(ok);
		//this.add(p2,BorderLayout.SOUTH);
		
		//this.add(d);
		//this.add(n);
		up = new JButton();
		up.setText("U");
		up.addActionListener(this);
		
		down = new JButton();
		down.setText("D");
		down.addActionListener(this);
		
		right = new JButton();
		right.setText("R");
		right.addActionListener(this);
		
		left = new JButton();
		left.setText("L");
		left.addActionListener(this);
		
		//p3.setLayout(new BorderLayout());
		p4.setLayout(new GridLayout());
		p5.setLayout(new GridLayout(3,1));
		p4.add(down);
		p4.add(up);
		p4.add(left);
		p4.add(right);
		Champion c = controller.getGame().getCurrentChampion();
		for(int i=0;i<c.getAbilities().size();i++) {
			Ability a = c.getAbilities().get(i);
			if(a.getCastArea()==AreaOfEffect.DIRECTIONAL) {
				JButton b= new JButton();
				b.setText(a.getName());
				b.addActionListener(this);
				p5.add(b);
			}
		}
		//p3.add(p4,BorderLayout.NORTH);
		//p3.add(p5,BorderLayout.SOUTH);
		//this.add(p3,BorderLayout.CENTER);
		p1.setVisible(true);
		p2.setVisible(true);
		p3.setVisible(true);
		p4.setVisible(true);
		p5.setVisible(true);
		this.setVisible(true);
		
 }
 public Controller getController() {
		return controller;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==ok) {
		if((!(abilitychosen))&& (! (directionchosen) ) )
			new PopupView("Please choose ability and direction");
		else if(!abilitychosen)
			new PopupView("please choose ability");
		else if (!directionchosen)
			new PopupView("Please choose direction");
		if(abilitychosen&&directionchosen) {
			try {
				controller.getGame().castAbility(theability, thedirection);
				controller.toBoardView();
				int j=0;
				while(j<1000000)
					j++;
				view.dispose();
			} catch (NotEnoughResourcesException e1) {
				new PopupView(e1.getMessage());
			} catch (AbilityUseException e1) {
				new PopupView(e1.getMessage());
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				new PopupView("");
			}
			this.dispose();
		}
}
	else if(e.getSource()==up) {
		thedirection= Direction.DOWN;
		directionchosen = true;
		up.setVisible(false);
	}
	else if(e.getSource()==down) {
		thedirection= Direction.UP;
		directionchosen = true;
		down.setVisible(false);
	}
	else if(e.getSource()==right) {
		JButton temp = (JButton)(e.getSource());
		
		thedirection= Direction.RIGHT;
		directionchosen = true;
		temp.setVisible(false);
	}
	else if(e.getSource()==left ) {
		thedirection= Direction.LEFT;
		directionchosen = true;
		left.setVisible(false);
	}
	else {
		if(chosen>0) {
			new PopupView("you have already chosen one");
			return;
		}
		JButton temp =(JButton) (e.getSource());
		for(int i =0;i<controller.getGame().getCurrentChampion().getAbilities().size();i++) {
			Ability a = controller.getGame().getCurrentChampion().getAbilities().get(i);
			if(temp.getText().equals(a.getName())) {
				theability = a;
				abilitychosen=true;
				temp.setVisible(false);
			}
		}
		chosen++;
	}
	
	
	
	
}
}
