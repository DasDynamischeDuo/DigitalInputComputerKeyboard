package Gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Notenblatt extends JFrame {

	private JPanel contentPane;
	private JLabel lNoten;
	
	public Notenblatt() {
		 contentPane = new JPanel();
		 setContentPane(contentPane);
		 lNoten = new JLabel("test");
		 contentPane.add(lNoten);
		 this.setSize(100, 100);
		 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
		
	}

	public JLabel getlNoten() {
		return lNoten;
	}
	
}
