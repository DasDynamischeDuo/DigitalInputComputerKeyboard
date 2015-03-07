package Gui;

import java.awt.Color;

import javax.swing.*;

public class Gui extends JFrame {

	JLabel label1,label2;
	JPanel notenpane, buttonpane, tastenpane;
		JPanel lklav,rklav;
			JPanel lgrid,rgrid;
				JPanel lborder,rborder;
				
	JToggleButton rtasten[];//Buttonanzahlt einfuegen
	JToggleButton ltasten[];
	
				
				
	public Gui(){
				 
		 buttonsinitialisieren(rtasten, ltasten);
		 buttonskonfig(rtasten, ltasten);
		 
				 
		
		
	}

	private void buttonsinitialisieren(JToggleButton rtasten[], JToggleButton ltasten[]  ) {
			
		for (int i = 0; i < ltasten.length; i++) {
			ltasten[i] = new JToggleButton();
		}
		
		for (int i = 0; i < rtasten.length; i++) {
			rtasten[i] = new JToggleButton();
		}
			
	}

	private void buttonskonfig(JToggleButton rtasten[], JToggleButton ltasten[]  ) {
		
		for (int i = 0; i < ltasten.length; i++) {
			ltasten[i].setBackground(Color.white);
		}
		
		for (int i = 0; i < rtasten.length; i++) {
			rtasten[i].setBackground(Color.white);
		}
	
		
	}


	
	
	
	
	
}
