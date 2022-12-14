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
import engine.Game;
import engine.Player;

public class NamesFrame extends JFrame implements ActionListener
{
	//String firstPlayerName;
	//String secondPlayerName;
	private JTextField firstPlayer;
	private JTextField secondPlayer;
	private JButton ok;
	private Controller controller;
	private Game game2;
	
	public NamesFrame(Controller q)
	{
		controller = q;
		//The 'ok' button
		ok = new JButton();
		ok.setFont(new Font("Comic Sans",Font.BOLD,25));
		ok.setText("OK");
		ok.addActionListener(this);
		ok.setIconTextGap(-15);
		ok.setForeground(Color.black);
		ok.setBackground(Color.LIGHT_GRAY);
		ok.setBounds(200, 150, 200, 50);
		
		//The Textfield of the first player
		firstPlayer = new JTextField();
		firstPlayer.setPreferredSize(new Dimension(100,200));
		firstPlayer.setText("First player name");
		firstPlayer.setCaretColor(Color.white);
		firstPlayer.setFont(new Font("Consolas" , Font.PLAIN, 15));
		firstPlayer.setForeground(Color.red);
		firstPlayer.setBounds(210,13,200,30);
		
		//The text "firstPlayerName" 
		JLabel firstPlayerName= new JLabel();
		//labelText.setOpaque(true);
		firstPlayerName.setText("1st player name : ");
		firstPlayerName.setForeground(Color.BLACK);
		firstPlayerName.setFont(new Font("Arial Black",Font.BOLD,20));
		firstPlayerName.setBounds(0,0,250,50);
		
		//The Textfield of the first player
		secondPlayer = new JTextField();
		secondPlayer.setPreferredSize(new Dimension(100,200));
		secondPlayer.setText("Second player name");
		secondPlayer.setCaretColor(Color.white);
		secondPlayer.setFont(new Font("Consolas" , Font.PLAIN, 15));
		secondPlayer.setForeground(Color.red);
		secondPlayer.setBounds(210,74,200,30);
				
		
		//The text "secondPlayerName" 
		JLabel secondPlayerName= new JLabel();
		//secondPlayer.setOpaque(true);
		secondPlayerName.setText("2nd player name :");
		secondPlayerName.setForeground(Color.BLACK);
		secondPlayerName.setFont(new Font("Arial Black",Font.BOLD,20));
		secondPlayerName.setBounds(0,70,250,30);
		
		
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
		
		layeredPane.add(firstPlayer, Integer.valueOf(1));
		layeredPane.add(secondPlayer, Integer.valueOf(1));
		layeredPane.add(ok, Integer.valueOf(1));
		layeredPane.add(firstPlayerName, Integer.valueOf(1));
		layeredPane.add(secondPlayerName, Integer.valueOf(1));
	//	layeredPane.add(backgroundImage ,Integer.valueOf(0));
		
		
		//The frame 
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		ImageIcon logo = new ImageIcon("logo.jpeg");
		this.setIconImage(logo.getImage());
		this.setLocation(new Point(250,100));
		this.setSize(600,300);
		this.setTitle("Marvel Ultimate War");
		this.setBackground(Color.LIGHT_GRAY);
		this.add(layeredPane);
	}

	public JTextField getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(JTextField firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public JTextField getSecondPlayer() {
		return secondPlayer;
	}

	public JButton getOk() {
		return ok;
	}

	public void setOk(JButton ok) {
		this.ok = ok;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void setSecondPlayer(JTextField secondPlayer) {
		this.secondPlayer = secondPlayer;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok)
		{
			//this.setVisible(false);
			//firstPlayerName = getFirstPlayer().getText();
			//secondPlayerName =getSecondPlayer().getText();
			Player p1 = new Player(firstPlayer.getText());
			Player p2 = new Player(secondPlayer.getText());
			controller.setGame(new Game(p1,p2));
			//setGame2((new Game(p1, p2)));
			this.dispose();
			getController().toChampionsSelectionView();
			
			
		}

	
		
	}

	public Game getGame2() {
		return game2;
	}

	public void setGame2(Game game2) {
		this.game2 = game2;
	}
}
