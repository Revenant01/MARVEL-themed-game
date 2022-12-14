package GAMEVIEW;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class MYLABEL extends JLabel {
	public MYLABEL() {
	ImageIcon image=new ImageIcon("0766b851uol81.jpg");
	Border border=BorderFactory.createLineBorder(Color.BLUE,3);// hna na create 7dod lthis bta3y 5leet lono azr2 w width bta3y b 3//
	this.setText(" fifa 23 cover(HYBER MOTION)");//bt7ot 2lnt 3ayez tktob fe frame//
	//this.setIcon(image);
	//this.setHorizontalTextPosition(JLabel.CENTER);//by5ly text feeen m3 alsora y3ne center alklam hyb2a fe nos alsora right y3m3n alsora wkda//
	//this.setVerticalTextPosition(JLabel.TOP);//nfs alklam foo2 bs top aw bottom aw center//
	this.setForeground(Color.RED);//t5ly loon alklam ehhhh//
	this.setFont(new Font("MV Boli",Font.ITALIC,50));//no3 al5t bta3y ehh mv boli de no3 ktabt 5ttttt , a5r rkm da size bta3 al5ttt//
	//this.setIconTextGap(10);//almsafa ma been alklam w elsora ad eh//
	this.setBorder(border);//method bt7od alborder de//
	this.setVerticalAlignment(JLabel.CENTER);//btn2l alklam m3 alsora zy ma hma blgab el ma bynhom kddda wt7tohm fe alnos//
	this.setHorizontalAlignment(JLabel.CENTER);// nfs alklam bs de m3aha right w left alfo2 34an vetrical center w top w bottom//
	//this.setBackground(Color.BLACK);// de bt5ly back groung btat3t goz2 alframe bs m4 alframe kolooo b black//
	//this.setOpaque(true);//lazm t5ly de btrue 34an ground bta3t this ttlwn//
	//this.setBounds(0, 0, 800, 800);// b7dd bounds bta3t this alhyban feha  fe frame//
}
}
