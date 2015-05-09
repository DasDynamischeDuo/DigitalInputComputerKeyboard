package Gui;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.KeyException;

import javax.swing.*;

import MidiAbspielen.MiditonAbspielen;

/**
 * Die Graphische Benutzeroberfläche des Digital Input Computer Keyboard
 * 
 * @author Emanuel
 * @version 0.1
 */

public class Gui extends JFrame {


	MiditonAbspielen miditonStarten;
	Notenlinien NL = new Notenlinien();
	
	private JLabel label1, label2;
	private JPanel contentpane;
	public JPanel notenpane, buttonpane, tastenpane;
	private JLabel bildSchluessel;
	private JPanel lklav, rklav;
	private JPanel lgrid, rgrid;
	private JRadioButton rbSample1;
	private JRadioButton rbMidi;
	private ButtonGroup groupRadioButton;


	private TastenListener tastenListener;

	private boolean[] istTasteGedrueckt;

	private JToggleButton[] rtasten = new JToggleButton[103];// Buttonanzahlt
																// einfuegen
	private JToggleButton[] ltasten = new JToggleButton[103];

	/**
	 * Konstruktor der GUI
	 * 
	 * @author Emanuel
	 * 
	 */

	public Gui() {

		
		
		
		this.setFocusable(true);
		
		istTasteGedrueckt = new boolean[27];

		initFrameElemente();
		initButtons();


		this.tastenListener = new TastenListener(this);
		tastenListener.start();


	}

	private void initFrameElemente() {

		
		label2 = new JLabel("Verschiedenes");


		notenpane = new JPanel(new GridLayout(1,15));
		buttonpane = new JPanel();
		tastenpane = new JPanel();

		lklav = new JPanel();
		rklav = new JPanel();

		lgrid = new JPanel();
		rgrid = new JPanel();

		rbSample1 = new JRadioButton("Drum");
		rbMidi = new JRadioButton("Piano");
		rbSample1.setSelected(true);

		rbMidi.setFocusable(false);
		rbSample1.setFocusable(false);

		contentpane = new JPanel();
		contentpane.setFocusable(true);

		contentpane.setLayout(new GridLayout(3, 1));
		tastenpane.setLayout(new GridLayout(1, 2));

		lklav.setLayout(new BorderLayout());
		rklav.setLayout(new BorderLayout());

		lgrid.setLayout(new GridLayout(6, 17));
		rgrid.setLayout(new GridLayout(6, 17));

		rgrid.setFocusable(true);
		lgrid.setFocusable(true);
		lklav.add(lgrid);
		rklav.add(rgrid);


		groupRadioButton = new ButtonGroup();
		groupRadioButton.add(rbSample1);
		groupRadioButton.add(rbMidi);


		notenpane.setFocusable(true);
		buttonpane.add(label2);
		buttonpane.add(rbSample1);
		buttonpane.add(rbMidi);

		tastenpane.add(lklav);
		tastenpane.add(rklav);

		
		
		contentpane.add(notenpane);
		contentpane.add(buttonpane);
		contentpane.add(tastenpane);
		
		Dimension d = this.getToolkit().getScreenSize();
		this.setLocation((int) ((d.getWidth() - this.getWidth())/4 ), (int) ((d.getHeight() - this.getHeight())/4));
		
		NL.NotenlinienSchluesselSetzenLeer(this);
		NL.NotenLinienLaufen(this);
		this.setContentPane(contentpane);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}


	/**
	 * 
	 * Buttons werden extern initalisiert. Allen Buttons wird ein KeyListener
	 * hinzugefuegt. Mithilfe von einem int Wert werden die Tasten
	 * identifiziert. Die Tasten werden einem Laben hinzugefuegt.
	 * 
	 * {@link Klaviertasten.buttonsInitialisieren}
	 * {@link Klaviertasten.buttonsKonfig}
	 * 
	 * @author Fabian
	 */

	private void initButtons() {

		Klaviertasten.buttonsInitialisieren(rtasten, ltasten);
		Klaviertasten.buttonsKonfig(rtasten, ltasten);

		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

				try {
					istTasteGedrueckt[Klaviertasten.getIntVonKey(e)] = false;
				} catch (KeyException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {

				try {
					istTasteGedrueckt[Klaviertasten.getIntVonKey(e)] = true;
				} catch (KeyException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
	}
		
	
	public boolean[] getIstTasteGedrueckt() {
		return istTasteGedrueckt;
	}

	public JToggleButton[] getRtasten() {
		return rtasten;
	}

	public JRadioButton getRbSample1() {
		return rbSample1;
	}

	public JRadioButton getRbMidi() {
		return rbMidi;
	}


	public JToggleButton[] getLtasten() {
		return ltasten;
	}


	public JPanel getNotenpane() {
		return notenpane;
	}

	public boolean getIstTasteGedrueckt(int stelle) {
		return istTasteGedrueckt[stelle];
	}

}
