package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

public class normalabilityview  extends JFrame  implements ActionListener{
private Controller controller;
 //private JButton ok;
 private JLabel ability;
 //private JTextField a;
 private BoardView view;
 //private boolean chosen;

public normalabilityview(Controller c,BoardView v) {
	controller=c;
	view = v;
	//ok= new JButton();
	//ok.setFont(new Font("Comic Sans",Font.BOLD,25));
	//ok.setText("ok");
	//button1.addActionListener(this);
	this.setLayout(new BorderLayout());
	JPanel p1 = new JPanel();
	//JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	 
	p1.setPreferredSize(new Dimension(100,100));
	//p2.setPreferredSize(new Dimension(100,100));
	p3.setPreferredSize(new Dimension(250,250)); 
	 
	this.add(p1,BorderLayout.NORTH);
	//this.add(p2,BorderLayout.SOUTH);
	this.add(p3,BorderLayout.CENTER);
	
	p3.setLayout(new GridLayout(5,5));
	
	
    //ok.setIconTextGap(-15);
	//ok.setForeground(Color.black);
	// ok.setBackground(Color.LIGHT_GRAY);
	//ok.setBounds(50, 200, 300, 50);
	//ok.addActionListener(this);
	 ability= new JLabel();
	//secondPlayer.setOpaque(true);
	 
	 
	ability.setText(" choose the ability ");
	ability.setForeground(Color.BLACK);
	ability.setFont(new Font("Arial Black",Font.BOLD,20));
	ability.setBounds(10,50,300,30);
	p1.add(ability);
	//p2.add(ok);
	Champion champ = controller.getGame().getCurrentChampion();
	for(int i=0;i<champ.getAbilities().size();i++) {
		Ability a = champ.getAbilities().get(i);
		if(a.getCastArea()!=AreaOfEffect.DIRECTIONAL&&a.getCastArea()!=AreaOfEffect.SINGLETARGET) {
			JButton b = new JButton();
			b.setText(a.getName());
			b.addActionListener(this);
			p3.add(b);
		}
	}
	
	
	
	//a = new JTextField();
	//a.setPreferredSize(new Dimension(100,200));
	//a.setText("name");
	//a.setCaretColor(Color.white);
	//a.setFont(new Font("Consolas" , Font.PLAIN, 15));
    //a.setForeground(Color.red);
	//a.setBounds(30,100,200,30);
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	//this.setLayout(null);
	this.setLocation(new Point(600,250));
	this.setSize(400,400);
	this.setBackground(Color.LIGHT_GRAY);
	//this.add(ability);
	//this.add(ok);
	//this.add(a);
}

public Controller getController() {
	return controller;
}
public void setController(Controller controller) {
	this.controller = controller;
}
@Override
public void actionPerformed(ActionEvent e) {
	JButton temp = (JButton) (e.getSource());
	Champion c = controller.getGame().getCurrentChampion();
	for(int i=0;i<c.getAbilities().size();i++) {
		Ability a = c.getAbilities().get(i);
		if(temp.getText().equals(a.getName())) {
			try {
				controller.getGame().castAbility(a);
				getController().toBoardView();
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
				e1.printStackTrace();
			}
			
		}
	}
    this.dispose();	

     }
            }
