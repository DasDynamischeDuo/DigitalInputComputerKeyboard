package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
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


public class Gui extends JFrame {
	
	MiditonStarten miditonStarten;
	

	JLabel label1, label2;
	JPanel contentpane;
	JPanel notenpane, buttonpane, tastenpane;
	JPanel lklav, rklav;
	JPanel lgrid, rgrid;

	JToggleButton[] rtasten = new JToggleButton[103];// Buttonanzahlt einfuegen
	JToggleButton[] ltasten = new JToggleButton[103];

	public Gui() {

		initFrameElemente();
		initButtons();
		
		try {
			this.miditonStarten = new MiditonStarten();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void initFrameElemente() {

		label1 = new JLabel("Noten");
		label2 = new JLabel("Verschiedenes");

		notenpane = new JPanel();
		buttonpane = new JPanel();
		tastenpane = new JPanel();

		lklav = new JPanel();
		rklav = new JPanel();

		lgrid = new JPanel();
		rgrid = new JPanel();

		contentpane = new JPanel();

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
		buttonpane.add(label2);

		tastenpane.add(lklav);
		tastenpane.add(rklav);

		contentpane.add(notenpane);
		contentpane.add(buttonpane);
		contentpane.add(tastenpane);

		this.setContentPane(contentpane);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	private void initButtons() {

		Klaviertasten.buttonsInitialisieren(rtasten, ltasten);
		Klaviertasten.buttonsKonfig(rtasten, ltasten);

		lgrid.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

				try {
					Klaviertasten.releasButton(MidiAbspielen.MiditonAbspielen.getIntVonKey(e) , ltasten, rtasten);
				} catch (KeyException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				

			}

			@Override
			public void keyPressed(KeyEvent e) {

				try {
					Klaviertasten.pressButton(MidiAbspielen.MiditonAbspielen.getIntVonKey(e), ltasten, rtasten);
				} catch (KeyException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				miditonStarten.spieleTon(e);

			}

		});

		for (int i = 1; i < ltasten.length; i++) {
			lgrid.add(ltasten[i]);
		}

		for (int i = 1; i < rtasten.length; i++) {
			rgrid.add(rtasten[i]);
		}

	}

}
