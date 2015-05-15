package SoundAbspielen;

import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

import SampleAbspielen.SampleAbspielen;

public class Gui extends JFrame implements KeyListener, Runnable {

	JPanel contentPane;
	private Vector<SampleAbspielen> soundAbspielens;
	private int anzTonAbgespielt;
	JButton[] btest;

	public Gui() {

		addKeyListener(this);

		initGui();

		this.soundAbspielens = new Vector<SampleAbspielen>();
		this.setFocusable(true);
		anzTonAbgespielt = 0;

	}

	private void initGui() {
		this.contentPane = new JPanel();
		setContentPane(contentPane);
		btest = new JButton[28];

		for (int i = 0; i < btest.length; i++) {
			this.btest[i] = new JButton("Nummer: " + i);
			contentPane.add(btest[i]);
			btest[i].setFocusable(false);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {

/*<<<<<<< HEAD ======= >>>>>>> branch 'master' of https://github.com/DasDynamischeDuo/DigitalInputComputerKeyboard.git*/
		
	}

	public SampleAbspielen lastElement() {
		return soundAbspielens.lastElement();
	}

	public int indexOf(Object o) {
		return soundAbspielens.indexOf(o);
	}

	public boolean removeSoundAbspielens(Object o) {
		return soundAbspielens.remove(o);
	}

	
	
	

	@Override
	public void run() {
		
		
	}

}
