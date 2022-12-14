package tests;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.Game;
import engine.Player;
import model.abilities.Ability;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;

public class quiztest extends JFrame  implements ActionListener {
  JLabel label1;
  JLabel label2;
  JLabel label3;
  JButton button;
  JPanel panel1;
  JPanel panel2;
  JPanel panel3;
  JPanel panel4;
   private Game game;
	 public quiztest() {
		 label1=new JLabel();
		 label2=new JLabel();
		 label3=new JLabel();
		 button=new JButton();
		 panel1=new JPanel();
		 panel2=new JPanel();
		 panel3=new JPanel();
		 panel4=new JPanel();
		ArrayList<Ability> a=game.getAvailableAbilities();
		int x=(int)(Math.random()*(a.size()));
		String s1=a.get(x).getName();
		String s2="";
		if(a.get(x) instanceof DamagingAbility) {
			s2="DamagingAbility";
		}
		if(a.get(x) instanceof HealingAbility) {
			s2="HealingAbility";
		}
		if(a.get(x) instanceof CrowdControlAbility) {
			s2="CrowdControlAbility";
		}
		String s3=""+x;
		button.setText("next");
		button.addActionListener(this);
		label1.setText(s1);
		label2.setText(s2);
		label3.setText(s3);
		label1.setBackground(Color.RED);
		label1.setBounds(300, 10000, 900, 100);
		label1.setOpaque(true);
		panel1.add(label1);
		panel2.add(label2);
		panel3.add(label3);
		 this.setVisible(true);
		 this.setLayout(new GridLayout(2,2));
		 this.setSize(700,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(button);
	 }
	public static void main(String [] args) throws IOException {
		Player player1=new Player("maze");
		Player player2=new Player("maze");
		Game game=new Game(player1,player2);
		game.loadAbilities(("Abilities.csv"));
		 quiztest test=new quiztest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==button) {
		 new quiztest();
		 this.dispose();
	}
		
	}

}
