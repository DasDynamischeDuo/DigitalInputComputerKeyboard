package Projekt;




import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Hilfe extends JFrame {

	private JPanel contentpane;
	private JPanel buttonpane;
	private JPanel textpane;
	
	private JTextArea txt;
	
	private JButton bZrk;
	
	
	public Hilfe(){
	
		contentpane = new JPanel();
		contentpane.setLayout(new GridLayout(2,1));
		buttonpane = new JPanel();
		
		
		textpane = new JPanel();
		
		txt = new JTextArea();
		txt.setFocusable(false);
		
		txt.setText("Hallo hier ist ihre Hilfe :D");
		
		
		bZrk = new JButton("Zurück");
		bZrk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btOkClicked();
				
			}
		});
		
		
		textpane.add(txt);
		
		
		buttonpane.add(bZrk);
		
		contentpane.add(textpane);
		contentpane.add(buttonpane);
		
		this.setContentPane(contentpane);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
	}


	protected void btOkClicked() {
		this.dispose();
		
	}
	
	
	
	
}
