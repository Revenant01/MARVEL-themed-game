package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PopupView extends JFrame implements ActionListener{
	//JFrame frame ;
	JLabel label;
	JButton button;
    public PopupView(String s) {
    	ImageIcon logo = new ImageIcon("logo.jpeg");
		this.setIconImage(logo.getImage()); 
    	label = new JLabel();
		label.setText(s);
		label.setBounds(250,30,300,40);
		button = new JButton();
		button.setFont(new Font("Comic Sans",Font.BOLD,13));
		button.setText("ok");
		button.addActionListener(this);
		//button.setIconTextGap(-15);
		button.setForeground(Color.black);
		button.setBackground(Color.red);
		button.setBounds(330, 80, 50, 30);
		this.setLocation(new Point(380,300));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(700, 150);
		this.setTitle("pop up message");
		this.add(button);
		this.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button)
		  this.dispose();
		
	}

}
