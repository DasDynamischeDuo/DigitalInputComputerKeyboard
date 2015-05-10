package Gui;

import java.awt.BorderLayout;
import java.awt.DefaultKeyboardFocusManager;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.KeyEventPostProcessor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.security.KeyException;

import javax.swing.*;

import Rekorder.Player;
import Rekorder.Rekorder;

/**
 * Die Graphische Benutzeroberflaeche des Digital Input Computer Keyboard
 * 
 * @author Emanuel
 * @version 0.1
 */

public class Gui extends JFrame {

	Notenlinien NL = new Notenlinien();

	private JPanel contentpane;
	public JPanel notenpane, buttonpane, tastenpane;
	private JLabel bildSchluessel;
	private JPanel lklav, rklav;
	private JPanel lgrid, rgrid;
	private JRadioButton rbDrum;
	private JRadioButton rbPiano;
	private ButtonGroup groupRadioButton;
	private JTextField tfDateiname, tfTempo;
	private JButton bAufnehmen, bStop, bPlay;
	private JFileChooser jFileChooser;
	private Rekorder rekorder;
	private Player player;

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

	

		notenpane = new JPanel(new GridLayout(1, 15));
		buttonpane = new JPanel();
		tastenpane = new JPanel();

		lklav = new JPanel();
		rklav = new JPanel();

		lgrid = new JPanel();
		rgrid = new JPanel();

		rbDrum = new JRadioButton("Drum");
		rbPiano = new JRadioButton("Piano");
		rbDrum.setSelected(true);

		rbPiano.setFocusable(false);
		rbDrum.setFocusable(false);

		tfDateiname = new JTextField("Dateiname");
		tfTempo = new JTextField("Tempo");
		bAufnehmen = new JButton("Aufnehmen");
		bStop = new JButton("Stop");
		bPlay = new JButton("Play");

		bAufnehmen.setFocusable(false);
		bStop.setFocusable(false);

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
		groupRadioButton.add(rbDrum);
		groupRadioButton.add(rbPiano);

		notenpane.setFocusable(true);
		buttonpane.add(rbDrum);
		buttonpane.add(rbPiano);
		buttonpane.add(tfDateiname);
		buttonpane.add(tfTempo);
		buttonpane.add(bAufnehmen);
		buttonpane.add(bStop);
		buttonpane.add(bPlay);

		tastenpane.add(lklav);
		tastenpane.add(rklav);

		contentpane.add(notenpane);
		contentpane.add(buttonpane);
		contentpane.add(tastenpane);

		Dimension d = this.getToolkit().getScreenSize();
		this.setLocation((int) ((d.getWidth() - this.getWidth()) / 4),
				(int) ((d.getHeight() - this.getHeight()) / 4));

		NL.NotenlinienSchluesselSetzenLeer(this);
		NL.NotenLinienLaufen(this);
		this.setContentPane(contentpane);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		jFileChooser = new JFileChooser();
		jFileChooser
				.setCurrentDirectory(new File(
						"C:/Users/Emanuel/git/DigitalInputComputerKeyboard/DigitalInputComputerKeyboard/Aufnahmen/"));

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

		for (int i = 1; i < ltasten.length; i++) {
			lgrid.add(ltasten[i]);
		}

		for (int i = 1; i < rtasten.length; i++) {
			rgrid.add(rtasten[i]);
		}

		KeyEventPostProcessor postProcessor = new KeyEventPostProcessor() {
			public boolean postProcessKeyEvent(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					requestFocusInWindow();
				}
				
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					
				}

				
				if (e.getID() == KeyEvent.KEY_PRESSED) {

					try {
						istTasteGedrueckt[Klaviertasten.getIntVonKey(e)] = true;
					} catch (KeyException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

				} else if (e.getID() == KeyEvent.KEY_RELEASED) {

					try {
						istTasteGedrueckt[Klaviertasten.getIntVonKey(e)] = false;
					} catch (KeyException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				return true;
			}
		};

		DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager()
				.addKeyEventPostProcessor(postProcessor);

		bAufnehmen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int instrument = 1;

				if (rbPiano.isSelected()) {
					instrument = 2;
				}

				try {
					rekorder = new Rekorder(tfDateiname.getText(), Integer.parseInt(tfTempo.getText()), instrument, tastenListener);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		bStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				rekorder.setIstRekorderAktiv(false);
				rekorder = null;

			}
		});

		bPlay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int ret = jFileChooser.showSaveDialog(bPlay);
				if (ret == 0) {
					File file = new File(jFileChooser.getSelectedFile()
							.getAbsolutePath());

					try {
						player = new Player();
						player.abspielen(file);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});

	}

	public Rekorder getRekorder() {
		return rekorder;
	}

	public boolean[] getIstTasteGedrueckt() {
		return istTasteGedrueckt;
	}

	public JToggleButton[] getRtasten() {
		return rtasten;
	}

	public JRadioButton getRbDrum() {
		return rbDrum;
	}

	public JRadioButton getRbPiano() {
		return rbPiano;
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
