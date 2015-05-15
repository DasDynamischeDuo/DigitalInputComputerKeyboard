package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class Notenblatt extends JFrame {

	private JPanel contentPane;
	private JLabel lNoten;
	private JToggleButton tbPause;
	private boolean istButtonBetaetigt= true, istPausiert = true;
	
	public Notenblatt() {
		 contentPane = new JPanel();
		 setContentPane(contentPane);
		 lNoten = new JLabel("test");
		 tbPause = new JToggleButton("Pause");
		 contentPane.add(lNoten);
		 contentPane.add(tbPause);
		 this.setSize(100, 100);
		 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);		 
		 
		 tbPause.setSelected(true);
		 
		 tbPause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (istButtonBetaetigt) {
					istPausiert = false;
				} else {
					
					istPausiert = true;
					
				}
				
				istButtonBetaetigt = !istButtonBetaetigt;
				
			}
		});
		
	}



	public boolean isIstPausiert() {
		return istPausiert;
	}



	public void setIstButtonBetaetigt(boolean istButtonBetaetigt) {
		this.istButtonBetaetigt = istButtonBetaetigt;
	}



	public JLabel getlNoten() {
		return lNoten;
	}
	
	
	
}
