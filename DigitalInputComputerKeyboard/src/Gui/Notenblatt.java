package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;


import Projekt.ProjektGui;
import Rekorder.Player;

public class Notenblatt extends JFrame {

	private JPanel contentPane;
	private JLabel lNoten;
	private JToggleButton tbPause;
	private boolean istButtonBetaetigt = true, istPausiert = true;
	private Player player;
	private ProjektGui projektGui;

	public Notenblatt(Player player, ProjektGui projektGui) {
		contentPane = new JPanel();
		setContentPane(contentPane);
		lNoten = new JLabel();
		tbPause = new JToggleButton("Pause");
		contentPane.add(lNoten);
		contentPane.add(tbPause);
		this.setSize(100, 100);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.player = player;
		this.projektGui = projektGui;

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

		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent e) {
				istPausiert = true;
				getProjektGui().removePlayer(getPlayer());

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	public boolean isIstPausiert() {
		return istPausiert;
	}

	public void setIstPausiert(boolean istPausiert) {
		this.istPausiert = istPausiert;
	}

	public void setIstButtonBetaetigt(boolean istButtonBetaetigt) {
		this.istButtonBetaetigt = istButtonBetaetigt;
	}

	public JLabel getlNoten() {
		return lNoten;
	}

	public Player getPlayer() {
		return player;
	}
	
	public ProjektGui getProjektGui(){
		return projektGui;
	}


	
	

}
