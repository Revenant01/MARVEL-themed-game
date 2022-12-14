package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Test extends JFrame implements ActionListener
{
	JButton button;
	JTextField textField;
	
	public Test ()
	{
		button = new JButton();
		button.setFont(new Font("Comic Sans",Font.BOLD,25));
		button.setText("OK");
		button.addActionListener(this);
		button.setIconTextGap(-15);
		button.setForeground(Color.black);
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(0, 0, 200, 50);
		
		
		textField = new JTextField();
		textField.setSize(100,50);
		textField.setFont(new Font("Consolas",Font.PLAIN,35));
		textField.setForeground(new Color(0x00FF00));
		textField.setBackground(Color.black);
		textField.setCaretColor(Color.white);
		textField.setText("username");
		textField.setBounds(300, 150, 200, 50);

		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,800);
		frame.setLayout(null);
		frame.add(textField);
		frame.add(button);
		//frame.pack();
	}
	
	public static void main (String[] args)
		{
			
		 String s = "Line 1\n" +
	                "Line 2\n" +
	                "Line 3";
	 
	        System.out.println(s);
			
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button)
			System.out.println("welcome" + textField.getText());
		
	}

	
}
