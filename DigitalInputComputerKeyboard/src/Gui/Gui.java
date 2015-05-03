package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.KeyException;
import java.security.acl.LastOwnerException;

import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import MidiAbspielen.*;

/**
 * Die Graphische Benutzeroberfläche des Digital Input Computer Keyboard
 * 
 * @author Emanuel
 * @version 0.1
 */

public class Gui extends JFrame {

	private MiditonStarten miditonStarten;

	private JLabel label1, label2;
	private JPanel contentpane;
	private JPanel notenpane, buttonpane, tastenpane;
	private JLabel bildSchluessel;
	private JPanel lklav, rklav;
	private JPanel lgrid, rgrid;
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

		try {
			this.miditonStarten = new MiditonStarten();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}

		try {
			this.tastenListener = new TastenListener(this);
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tastenListener.start();

	}

	private void initFrameElemente() {

		label1 = new JLabel("Noten");
		label2 = new JLabel("Verschiedenes");

		notenpane = new JPanel();

		Notenlinien.NotenschluesselSetzten(this);
		buttonpane = new JPanel();
		tastenpane = new JPanel();

		lklav = new JPanel();
		rklav = new JPanel();

		lgrid = new JPanel();
		rgrid = new JPanel();

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

		notenpane.add(label1);
		notenpane.setFocusable(true);
		buttonpane.add(label2);

		tastenpane.add(lklav);
		tastenpane.add(rklav);

		contentpane.add(notenpane);
		contentpane.add(buttonpane);
		contentpane.add(tastenpane);

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
				
				System.out.println("test");
/*
				try {
					istTasteGedrueckt[Klaviertasten.getIntVonKey(e)] = false;
				} catch (KeyException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					System.out.println(istTasteGedrueckt[Klaviertasten.getIntVonKey(e)]);
					System.out.println(Klaviertasten.getIntVonKey(e));
				} catch (KeyException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
*/
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				
				
				/*
				
				try {
					istTasteGedrueckt[Klaviertasten.getIntVonKey(e)] = true;
				} catch (KeyException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					System.out.println(istTasteGedrueckt[Klaviertasten.getIntVonKey(e)]);
					System.out.println(Klaviertasten.getIntVonKey(e));
				} catch (KeyException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

*/

			}
		});

		for (int i = 1; i < ltasten.length; i++) {
			lgrid.add(ltasten[i]);
		}

		for (int i = 1; i < rtasten.length; i++) {
			rgrid.add(rtasten[i]);
		}

	}

	public boolean[] getIstTasteGedrueckt() {
		return istTasteGedrueckt;
	}

	public JToggleButton[] getRtasten() {
		return rtasten;
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
