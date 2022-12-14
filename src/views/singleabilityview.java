package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.world.Champion;

public class singleabilityview  extends JFrame  implements ActionListener{
 private Controller controller;
 private JButton ok;
 private JLabel label;
 private JTextField x;
 private JTextField y;
 private Ability ability;
 private boolean abilitychosen;
// private JTextField n;
 private BoardView view;
  public singleabilityview(Controller s, BoardView v) {
	  view = v;
	  controller=s;
	  this.setLayout(new BorderLayout(10,10));
	  JPanel p1 = new JPanel();
	  JPanel p2 = new JPanel();
	  JPanel p3 = new JPanel();
	  
	  p1.setPreferredSize(new Dimension(300,200));
	  p2.setPreferredSize(new Dimension(100,100));
	  p3.setPreferredSize(new Dimension(300,200));
	  
	  p1.setLayout(new BorderLayout(10,10));
	  this.add(p1,BorderLayout.NORTH);
	  this.add(p2,BorderLayout.SOUTH);
	  this.add(p3,BorderLayout.CENTER);
	  
	  
		ok= new JButton();
		ok.setFont(new Font("Comic Sans",Font.BOLD,25));
		ok.setText("ok");
		//button1.addActionListener(this);
	    ok.setIconTextGap(-15);
		ok.setForeground(Color.black);
		ok.setBackground(Color.LIGHT_GRAY);
		ok.setBounds(100, 250, 300, 50);
		ok.addActionListener(this);
		p2.add(ok);
		label= new JLabel();
		//secondPlayer.setOpaque(true);
		label.setText(" write coordinates :");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial Black",Font.BOLD,20));
		label.setBounds(10,50,300,30);
		x = new JTextField();
		x.setPreferredSize(new Dimension(100,200));
		x.setText("write x");
		x.setCaretColor(Color.white);
		x.setFont(new Font("Consolas" , Font.PLAIN, 15));
	    x.setForeground(Color.red);
		x.setBounds(30,100,200,30);
		y = new JTextField();
		y.setPreferredSize(new Dimension(100,200));
		y.setText("write y");
		y.setCaretColor(Color.white);
		y.setFont(new Font("Consolas" , Font.PLAIN, 15));
	    y.setForeground(Color.red);
		y.setBounds(50,150,200,30);
		//n = new JTextField();
		//n.setPreferredSize(new Dimension(100,200));
		//n.setText("name of ability ");
		//n.setCaretColor(Color.white);
		//n.setFont(new Font("Consolas" , Font.PLAIN, 15));
	    //n.setForeground(Color.red);
		//n.setBounds(80,200,200,30)
		p1.add(x,BorderLayout.WEST);
		p1.add(y,BorderLayout.EAST);
		p1.add(label,BorderLayout.NORTH);
		Champion c = controller.getGame().getCurrentChampion();
		for(int i=0;i<c.getAbilities().size();i++) {
			Ability a = c.getAbilities().get(i);
			if(a.getCastArea()==AreaOfEffect.SINGLETARGET) {
				JButton b = new JButton();
				b.setText(a.getName());
				b.addActionListener(this);
				p3.add(b);
			}
			
			
		}
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(new Point(600,250));
		this.setSize(400,400);
		this.setBackground(Color.LIGHT_GRAY);
		//this.add(n);
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
		if(!abilitychosen)
			new PopupView("Please choose ability");
		else if(x.getText().equals("write x")||y.getText().equals("write y"))
			new PopupView("please choose the cooridinates");
		else if (x==null|| y==null)
			new PopupView("please choose the cooridinates");
		else {
			int xnew = Integer.parseInt(x.getText());
			int ynew = Integer.parseInt(y.getText());
			try {
				controller.getGame().castAbility(ability, 4-ynew, xnew);
				getController().toBoardView();
				int j=0;
				while(j<100000)
					j++;
				view.dispose();
			} catch (NotEnoughResourcesException e1) {
				new PopupView(e1.getMessage());
			} catch (AbilityUseException e1) {
				new PopupView(e1.getMessage());
			} catch (InvalidTargetException e1) {
				new PopupView(e1.getMessage());
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
		}
}
	else {
		JButton temp = (JButton) (e.getSource());
		Champion c = controller.getGame().getCurrentChampion();
		for(int i =0;i<c.getAbilities().size();i++) {
			Ability a = c.getAbilities().get(i);
			if(temp.getText().equals(a.getName())) {
				ability = a;
				abilitychosen = true;
				temp.setVisible(false);
			}
		}
	}
}
}
