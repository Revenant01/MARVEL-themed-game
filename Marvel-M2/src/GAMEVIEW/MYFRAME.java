package GAMEVIEW;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MYFRAME  extends JFrame implements ActionListener{
	JButton button;
	JLabel label;
 public MYFRAME() {
	 ImageIcon image= new ImageIcon("dude.png");
	   label=new JLabel();
	   label.setText("kosssssmmmmk");
	   label.setBounds(500, 50, 300,300);
	   label.setFont(new Font("MV Boli",Font.ITALIC,30));
	 this.setVisible(true);
	 this.setTitle("abooo al3rby");
	 this.setSize(950,950);
	 this.setResizable(true);// mt3rf4 tl34b feha tkbrha y3neee//
	 this.getContentPane().setBackground(Color.BLACK);
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//y5leha t2fl lma tdos x fe 2ltb3y m4 bt2f//
	 button=new JButton();
	 button.setBounds(300, 100, 800, 700);
	 button.setText("lw ragl dos 3la al3rbyaaaaa");
	 button.setFont(new Font("MV Boli",Font.ITALIC,59));
	 button.setBackground(Color.CYAN);
	 button.setBorder(BorderFactory.createEtchedBorder());//de 3l4an a5ly leha 7dddod alnoo3 da elhwa etched by5leha ka2nha 3d//(zy elframe)
	 button.setFocusable(false);// de 3mltha 3l4an lma agy ados 3la elbutton my3lm3e4 3la alkam kda al4klll yb2a a7ulaa//
	 button.setIcon(image);
	 button.setHorizontalTextPosition(JButton.CENTER);
	 button.setVerticalTextPosition(JButton.TOP);
	 button.setIconTextGap(30);
	 button.addActionListener(this);//de 3l4an lma ados 3leh y3ml action b2ad leeh elframe //
	 label.setVisible(false);
	 this.add(label);
	 this.add(button);
	 this.setLayout(null);
	 
 }
@Override
public void actionPerformed(ActionEvent e) {// elmotod mn elinterface//
	if(e.getSource()==button) {// a4oof lw na dost 3la button alfolany//
		//System.out.print("kosmk ya 3rsss");
		label.setVisible(true);// tzhr awl ma adoooos//
	}
}
}
