package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Conroller.Controller;
import engine.Game;
import model.abilities.Ability;
import model.world.Champion;

public class ChampionsSelectionView extends JFrame implements ActionListener {
	private Controller controller;
	private JTextArea label;
	private JButton button;
	private static int chosen=0;
	ArrayList<Champion> s;

	public Controller getController() {
		return controller;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public ChampionsSelectionView(Controller q)
	{
		controller = q;
		ImageIcon logo = new ImageIcon("logo.jpeg");
		this.setIconImage(logo.getImage());
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocation(new Point(250,20));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(false);
		this.setSize(800, 730);
		this.setTitle("Marvel Ultimate War");
		JLayeredPane panel = new JLayeredPane();
		panel.setBounds(0,0,500,500);
		panel.setBackground(Color.red);
		panel.setLayout(new GridLayout(5,5,5,5));
		
		

		try {
			getController().getGame().loadAbilities("Abilities.csv");
			getController().getGame().loadChampions("Champions.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		s = controller.getGame().getAvailableChampions();
		for(int i=0;i<s.size();i++) {
			Champion c =(Champion) s.get(i);
			label = new JTextArea();
			button = new JButton();
			
			String info = "maxhp:"+c.getMaxHP() +"\n"
			+"Mana:"+c.getMana() +"\n"
			+"Actions per turn:"+c.getMaxActionPointsPerTurn() +"\n" 
			+"speed: "+c.getSpeed() +"\n"
			+"range: "+c.getAttackRange() +"\n" 
			+"damage: "+c.getAttackDamage() +"\n";
			//System.out.println(info);
		
			ArrayList abilities = c.getAbilities();
			String theAbility =" The Abilities :";
			for(int j=0;j<abilities.size();j++) {
				Ability a =(Ability) abilities.get(j);
				if(a!=null)
				  theAbility+= a.getName()+" " + "\n";
			}
			
			
			String information = info +theAbility;
			label.setText(information);
			button.setText(c.getName());
			ImageIcon image = new ImageIcon(c.getName()+".jpg");
			Image img = image.getImage();
			Image photo = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			image = new ImageIcon(photo);
			button.setIcon(image);
			panel.add(label);
			panel.add(button);
			button.addActionListener(this);
			
		}
		//this.add(layeredPane);
		this.setVisible(true);
		this.add(panel);
		int i=0;
		JOptionPane.showMessageDialog(null, controller.getGame().getFirstPlayer().getName()+" choose your leader","team1",JOptionPane.PLAIN_MESSAGE);
		//new PopupView(controller.getGame().getFirstPlayer().getName()+" choose your leader");
	}
	private String newLine(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( !(e.getSource() instanceof JButton))
			return;
		JButton temp = (JButton) (e.getSource());
		for(int i=0;i<s.size();i++) {
			//Game game = getController().getGame();
			Champion c = s.get(i);
			if(temp.getText().equals(c.getName())) {
				if(chosen ==0) {
					controller.getGame().getFirstPlayer().getTeam().add(c);
					controller.getGame().getFirstPlayer().setLeader(c);
					controller.getGame().getTurnOrder().insert(c);
					temp.setVisible(false);
					JOptionPane.showMessageDialog(null, controller.getGame().getSecondPlayer().getName()+" choose your leader","team2",JOptionPane.PLAIN_MESSAGE);
				}
				else if(chosen==1) {
					getController().getGame().getSecondPlayer().getTeam().add(c);
					getController().getGame().getSecondPlayer().setLeader(c);
					controller.getGame().getTurnOrder().insert(c);
					temp.setVisible(false);
					JOptionPane.showMessageDialog(null, controller.getGame().getFirstPlayer().getName()+" choose your 2nd champion","team1",JOptionPane.PLAIN_MESSAGE);
				}
				else if(chosen==5) {
					getController().getGame().getSecondPlayer().getTeam().add(c);
					controller.getGame().getTurnOrder().insert(c);
					getController().toBoardView();
					this.dispose();
				}
				else if(chosen==2) {
					getController().getGame().getFirstPlayer().getTeam().add(c);
					controller.getGame().getTurnOrder().insert(c);
					temp.setVisible(false);
					JOptionPane.showMessageDialog(null, controller.getGame().getSecondPlayer().getName()+" choose your 2nd player","team2",JOptionPane.PLAIN_MESSAGE);
				}
				else if(chosen==3) {
					getController().getGame().getSecondPlayer().getTeam().add(c);
					controller.getGame().getTurnOrder().insert(c);
					temp.setVisible(false);
					JOptionPane.showMessageDialog(null, controller.getGame().getFirstPlayer().getName()+" choose your 3rd champion","team1",JOptionPane.PLAIN_MESSAGE);
				}
				else if(chosen==4) {
					getController().getGame().getFirstPlayer().getTeam().add(c);
					controller.getGame().getTurnOrder().insert(c);
					temp.setVisible(false);
					JOptionPane.showMessageDialog(null, controller.getGame().getSecondPlayer().getName()+" choose your 3rd champion","team2",JOptionPane.PLAIN_MESSAGE);
				}
				temp.setVisible(false);
				chosen++;
				
				
				
				
				
				
				
				
				
			}
		}
		
		
			
		
		
	}
	public JTextArea getLabel() {
		return label;
	}
	public void setLabel(JTextArea label) {
		this.label = label;
	}
	public JButton getButton() {
		return button;
	}
	public void setButton(JButton button) {
		this.button = button;
	}
	
	


}
