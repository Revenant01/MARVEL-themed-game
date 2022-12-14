 package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Conroller.Controller;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import model.abilities.Ability;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.effects.Effect;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Hero;
import model.world.Villain;

public class BoardView extends JFrame implements ActionListener{
	private Controller controller;
	//private JPanel panel;
	JButton move;
	JButton attack;
	JButton useleader;
	JButton ability;
	private JTextArea Area;
	private boolean flag;
	private JButton end;
	private boolean finished= false;;
	public BoardView(Controller q)
	{
		this.controller = q;
		
		ImageIcon logo = new ImageIcon("logo.jpeg");
		this.setIconImage(logo.getImage());
		this.setLocation(new Point(250,20));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setResizable(true);
		//this.setSize(getMaximumSize());
		this.setTitle("Marvel Ultimate War");
		JLayeredPane panel = new JLayeredPane();
		this.setLayout(new BorderLayout(0,0));
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		
		panel1.setBackground(Color.GRAY);
		panel2.setBackground(Color.GRAY);
		//panel1.setBackground(Color.GRAY);
		panel4.setBackground(Color.GRAY);
		panel5.setBackground(Color.GRAY);
		
		panel1.setPreferredSize(new Dimension(100,100));
		panel2.setPreferredSize(new Dimension(100,150));
		panel3.setPreferredSize(new Dimension(100,100));
		panel4.setPreferredSize(new Dimension(100,100));
		panel5.setPreferredSize(new Dimension(100,100));
		
		
		
		this.add(panel1,BorderLayout.NORTH);
		this.add(panel2,BorderLayout.SOUTH);
		this.add(panel3,BorderLayout.CENTER);
		this.add(panel4,BorderLayout.EAST);
		this.add(panel5,BorderLayout.WEST);
		
		panel2.setLayout(new GridLayout());
		
		JTextArea label1 = new JTextArea();
		JTextArea label2 = new JTextArea();
		String p1 = "Player 1: "+controller.getGame().getFirstPlayer().getName()+"\n";
		for(int i=0;i<controller.getGame().getFirstPlayer().getTeam().size();i++) {
			boolean isleader = false;
			Champion c = (Champion) (controller.getGame().getFirstPlayer().getTeam().get(i));
			if(c.equals(controller.getGame().getFirstPlayer().getLeader()))
				isleader = true;
			if(c instanceof Hero)
				p1 += "Champion"+(i+1)+":"+c.getName()+" Current HP:"+c.getCurrentHP()+" Speed:"+c.getSpeed()+ " max Action Points:"+c.getMaxActionPointsPerTurn()+" Mana:"+c.getMana()+" Attack range:"+c.getAttackRange()+" Attack damage:"+c.getAttackDamage()+" type:Hero "+"is leader:"+isleader+"\n";
			else if(c instanceof Villain)
				p1 += "Champion"+(i+1)+":"+c.getName()+" Current HP:"+c.getCurrentHP()+" Speed:"+c.getSpeed()+ " max Action Points:"+c.getMaxActionPointsPerTurn()+" Mana:"+c.getMana()+" Attack range:"+c.getAttackRange()+" Attack damage:"+c.getAttackDamage()+" type:Villain "+"is leader:"+isleader+"\n";
			else if(c instanceof AntiHero)
				p1 += "Champion"+(i+1)+":"+c.getName()+" Current HP:"+c.getCurrentHP()+" Speed:"+c.getSpeed()+ " max Action Points:"+c.getMaxActionPointsPerTurn()+" Mana:"+c.getMana()+" Attack range:"+c.getAttackRange()+" Attack damage:"+c.getAttackDamage()+" type:Antihero "+"is leader:"+isleader+"\n";
			ArrayList effects = c.getAppliedEffects();
			p1+= "Applied effects:";
			for(int j=0;j<effects.size();j++) {
				Effect e = (Effect) effects.get(j);
				p1+=" Effect"+(j+1)+":"+e.getName()+ "Duration:"+e.getDuration()+" ";
			}
			p1+="\n";
		}
		
		p1 += "Leader Ability Used: "+controller.getGame().isFirstLeaderAbilityUsed();
		label1.setBackground(Color.GREEN);
		label1.setText(p1);
		
		String p2 = "Player 2: "+controller.getGame().getSecondPlayer().getName()+"\n";
		for(int i=0;i<controller.getGame().getSecondPlayer().getTeam().size();i++) {
			boolean isleader = false;
			Champion c = (Champion) (controller.getGame().getSecondPlayer().getTeam().get(i));
			if(c.equals(controller.getGame().getSecondPlayer().getLeader()))
				isleader = true;
			if(c instanceof Hero)
				p2 += "Champion"+(i+1)+":"+c.getName()+" Current HP:"+c.getCurrentHP()+" Speed:"+c.getSpeed()+ " max Action Points:"+c.getMaxActionPointsPerTurn()+" Mana:"+c.getMana()+" Attack range:"+c.getAttackRange()+"Attack damage:"+c.getAttackDamage()+"type:Hero "+"Leader:"+isleader+"\n";
			else if(c instanceof Villain)
				p2 += "Champion"+(i+1)+":"+c.getName()+" Current HP:"+c.getCurrentHP()+" Speed:"+c.getSpeed()+ " max Action Points:"+c.getMaxActionPointsPerTurn()+" Mana:"+c.getMana()+" Attack range:"+c.getAttackRange()+"Attack damage:"+c.getAttackDamage()+"type:Villain "+"Leader:"+isleader+"\n";
			else if(c instanceof AntiHero)
				p2 += "Champion"+(i+1)+":"+c.getName()+" Current HP:"+c.getCurrentHP()+" Speed:"+c.getSpeed()+ " max Action Points:"+c.getMaxActionPointsPerTurn()+" Mana:"+c.getMana()+" Attack range:"+c.getAttackRange()+"Attack damage:"+c.getAttackDamage()+"type:Antihero "+"Leader:"+isleader+"\n";
			ArrayList effects = c.getAppliedEffects();
			p2+= "Applied effects:";
			for(int j=0;j<effects.size();j++) {
				Effect e = (Effect) effects.get(j);
				p2+=" Effect"+(j+1)+":"+e.getName()+ "Duration:"+e.getDuration()+" ";
			}
			p2+="\n";
		}
		p2 += "Leader Ability Used: "+controller.getGame().isSecondLeaderAbilityUsed();
		label2.setBackground(Color.RED);
		label2.setText(p2);
		
		panel2.add(label1,BorderLayout.WEST);
		panel2.add(label2,BorderLayout.EAST);
		
		
		panel3.setLayout(new GridLayout(5,5));
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				Object[][] board = controller.getGame().getBoard();
				if(board[i][j]==null) {
					 JButton button1=new JButton();
					button1.setText("free");
					panel3.add(button1);
				}
				else if(board[i][j] instanceof Champion) {
					JLabel l= new JLabel();
					JButton button = new JButton();
					Champion c = (Champion)(board[i][j]);
					l.setText(""+c.getCurrentHP());
					button.setText(c.getName());
					ImageIcon image = new ImageIcon(c.getName()+".jpg");
					Image img = image.getImage();
					Image photo = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
					image = new ImageIcon(photo);
					button.setIcon(image);
					button.add(l);
					if(controller.getGame().getCurrentChampion().equals(c))
						button.setBackground(Color.YELLOW);
					else if(controller.getGame().getFirstPlayer().getTeam().contains(c))
						button.setBackground(Color.GREEN);
					else
						button.setBackground(Color.RED);
					l.setBounds(0, 0, 10, 10);
					l.setBackground(Color.white);
					panel3.add(button);
				}
				else if(board[i][j] instanceof Cover) {
					Cover v = (Cover) (board[i][j]);
					JButton button2=new JButton();
					button2.setText("Cover  "  +v.getCurrentHP());
					panel3.add(button2);
				}
			}
		}
		Champion c=controller.getGame().getCurrentChampion();
		JTextArea labelnew=new JTextArea();
		ArrayList a= c.getAbilities();
		ArrayList effects=c.getAppliedEffects();
		String textability="";
		String texteffects="Applied Effects: ";
		String textchampion;
		String finish;
		if(c instanceof Hero) {
		 textchampion="current champion:"+c.getName()+" type:HERO "+"current hp:"+c.getCurrentHP()+" mana:"+c.getMana()+" action points:"+c.getCurrentActionPoints()+" attack damage:"+c.getAttackDamage()+" attack range:"+c.getAttackRange()+"\n";}
		else if(c instanceof Villain) {
			 textchampion="current champion:"+c.getName()+" type:villian "+"current hp:"+c.getCurrentHP()+" mana:"+c.getMana()+" action points:"+c.getCurrentActionPoints()+" attack damage:"+c.getAttackDamage()+" attack range:"+c.getAttackRange()+" "+"\n";}
		else {
			 textchampion="current champion:"+c.getName()+" type:Anti Hero "+"current hp:"+c.getCurrentHP()+" mana:"+c.getMana()+" action points:"+c.getCurrentActionPoints()+" attack damage:"+c.getAttackDamage()+" attack range:"+c.getAttackRange()+"\n";}
		for(int i=0;i<a.size();i++) {
		if(a.get(i) instanceof DamagingAbility) {
			DamagingAbility a1=(DamagingAbility) a.get(i);
			 textability=textability+"Ability"+(i+1)+":"+a1.getName()+" type:Damaging Ability "+"cast area:"+a1.getCastArea()+" cast range:"+a1.getCastRange()+" mana cost:"+a1.getManaCost()+" required action points:"+a1.getRequiredActionPoints()+" basecooldowwn:"+a1.getBaseCooldown()+" currentcooldown:"+a1.getCurrentCooldown()+" damage amount:"+a1.getDamageAmount()+"\n";}	
		if(a.get(i) instanceof HealingAbility) {
			HealingAbility a1=(HealingAbility) a.get(i);
			textability=textability+"Ability"+(i+1)+":"+a1.getName()+" type:Damaging Ability "+"cast area:"+a1.getCastArea()+" cast range:"+a1.getCastRange()+" mana cost:"+a1.getManaCost()+" required action points:"+a1.getRequiredActionPoints()+" basecooldowwn:"+a1.getBaseCooldown()+" currentcooldown:"+a1.getCurrentCooldown()+" heal amount:"+a1.getHealAmount()+"\n";}	
		if(a.get(i) instanceof CrowdControlAbility) {
			CrowdControlAbility a1=(CrowdControlAbility) a.get(i);
			textability=textability+"Ability"+(i+1)+":"+a1.getName()+" type:Damaging Ability "+"cast area:"+a1.getCastArea()+" cast range:"+a1.getCastRange()+" mana cost:"+a1.getManaCost()+" required action points:"+a1.getRequiredActionPoints()+" basecooldowwn:"+a1.getBaseCooldown()+" currentcooldown:"+a1.getCurrentCooldown()+" Effect:"+a1.getEffect().getName()+" Duration:"+a1.getEffect().getDuration()+"\n";}	
		}
		for(int i=0;i<effects.size();i++) {
			Effect e=(Effect) effects.get(i);
			texteffects=texteffects+"Effect"+(i+1)+":"+e.getName()+" "+"duration:"+e.getDuration()+"  ";
		}
		finish=textchampion+textability+texteffects;
		labelnew.setText(finish);
		labelnew.setBackground(Color.yellow);
		panel1.add(labelnew);
		ArrayList<Champion> tmp =new ArrayList<Champion>();
		JTextArea turn = new JTextArea();
		int j=1;
		String s ="turn order"+"\n";
	    while(controller.getGame().getTurnOrder().isEmpty()==false) {
	    	Champion t = (Champion) (controller.getGame().getTurnOrder().peekMin());
	    	tmp.add((Champion) controller.getGame().getTurnOrder().remove());
	    	s+=j+"."+ t.getName()+"\n";
	    	j++;
	    }
	    turn.setText(s);
	    panel4.add(turn);
	    for(int i=0;i<tmp.size();i++) {
	    	controller.getGame().getTurnOrder().insert(tmp.get(i));
	    }
		panel5.setLayout(new FlowLayout());
		 move=new JButton();
		 move.addActionListener(this);
		 move.setText("TO MOVE");
		panel5.add(move);
		attack=new JButton();
		attack.addActionListener(this);
		attack.setText("TO ATTACK");
		panel5.add(attack);
		useleader=new JButton();
		useleader.addActionListener(this);
		useleader.setText("leader ability");
		panel5.add(useleader);
		ability=new JButton();
		ability.addActionListener(this);
		ability.setText("ability");
		panel5.add(ability);
		end=new JButton();
		end.addActionListener(this);
		end.setText("end your turn");
		panel5.add(end);
		
		if(controller.getGame().checkGameOver()!=null) {
			this.remove(panel5);
			//new PopupView(""+controller.getGame().checkGameOver().getName()+" winss");
			JOptionPane.showMessageDialog(null,controller.getGame().checkGameOver().getName()+"Winss");
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==move) {
			getController().tomoveview(this);	
		}
		if(e.getSource()==attack) {
			getController().toattackview(this);
		}
		if(e.getSource()==useleader) {
			try {
				getController().getGame().useLeaderAbility();
			} catch (LeaderNotCurrentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (LeaderAbilityAlreadyUsedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		getController().toBoardView();
	}
		if(e.getSource()==ability) {
			getController().tomainabilityview(this);
		}
		if(e.getSource()==end) {
			getController().getGame().endTurn();
			getController().toBoardView();
			int j=0;
			while(j<1000000)
				j++;
			this.dispose();
		}
	}
	public Controller getController() {
		return controller;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	

}
