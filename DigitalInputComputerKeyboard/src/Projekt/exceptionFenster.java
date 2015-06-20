package Projekt;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class exceptionFenster extends JFrame {
	
	private JPanel contentpane;
	private JPanel buttonpane;
	private JPanel textpane;
	
	private JTextArea txt;
	
	private JButton bok;
	
	
	public exceptionFenster(){
	
		contentpane = new JPanel();
		contentpane.setLayout(new GridLayout(2,1));
		buttonpane = new JPanel();
		
		
		textpane = new JPanel();
		
		txt = new JTextArea();
		txt.setFocusable(false);
		
		txt.setText("Sie haben eine ungültige Taste oder einen ungültigen Befehl ausgeführt. ");
		txt.append("\nBitte überpfüfen sie ihre einstellung oder die betätigte Taste!");
		
		
		bok = new JButton("Ok");
		bok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btOkClicked();
				
			}
		});
		
		
		textpane.add(txt);
		
		
		buttonpane.add(bok);
		
		contentpane.add(textpane);
		contentpane.add(buttonpane);
		
		this.setTitle("Error");
		
		fensterZentrieren(this);
		this.setContentPane(contentpane);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
	}


	protected void btOkClicked() {
		this.dispose();
		
	}
	
	public static void fensterZentrieren(JFrame fenster) {
		 
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
 
		int x = dimension.width;
		int y = dimension.height;
 
		int fensterX = (x - fenster.getWidth()) / 2;
		int fensterY = (y - fenster.getHeight()) / 2;
 
		fenster.setLocation(fensterX, fensterY);
	}
	
	

}
