package SoundAbspielen;
import java.awt.Frame;
import java.awt.event.*;
import java.security.KeyException;
import java.security.MessageDigest;
import java.util.Vector;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;
import javax.xml.ws.handler.MessageContext;

public class Gui extends JFrame implements KeyListener, Runnable {

	JPanel contentPane;
	private Vector<SoundAbspielen> soundAbspielens;
	private int anzTonAbgespielt;
	JButton[] btest;

	public Gui() {

		addKeyListener(this);

		initGui();

		this.soundAbspielens = new Vector<>();
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

		spieleTon(e);

	}

	public SoundAbspielen lastElement() {
		return soundAbspielens.lastElement();
	}

	public int indexOf(Object o) {
		return soundAbspielens.indexOf(o);
	}

	public boolean removeSoundAbspielens(Object o) {
		return soundAbspielens.remove(o);
	}

	
	
	public void spieleTon(KeyEvent e) {
		
		System.gc();
		
		try {
			soundAbspielens.add(new SoundAbspielen(SoundAbspielen.getIntVonKey(e), 10000, this));
		} catch (KeyException e1) {
			System.out.println("Key nicht belegt");
			e1.printStackTrace();
		} catch (MidiUnavailableException e1) {
			System.out.println("Midi nicht erreichbar");
			e1.printStackTrace();
		}


		soundAbspielens.lastElement().start();

		try {
			btest[SoundAbspielen.getIntVonKey(e) - 60].doClick();
		} catch (KeyException e1) {
			System.out.println("Key nicht belegt test2");
			e1.printStackTrace();
		}
		
		

	}

	@Override
	public void run() {
		
		
	}

}
