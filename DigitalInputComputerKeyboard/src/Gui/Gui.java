package Gui;

import java.awt.BorderLayout;
import java.awt.DefaultKeyboardFocusManager;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.KeyEventPostProcessor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.KeyException;
import java.util.Vector;

import javax.swing.*;

import Projekt.BenutzerProjekt;
import Projekt.ProjektGui;
import Rekorder.Player;
import SampleAbspielen.SampleAbspielen;

/**
 * Die Graphische Benutzeroberflaeche des Digital Input Computer Keyboard
 * 
 * @author Emanuel
 * @version 0.1
 */

public class Gui extends JFrame {

	Notenlinien NL = new Notenlinien(this);

	private JPanel contentpane;
	public JPanel notenpane, buttonpane, tastenpane;
	private JPanel lklav, rklav;
	private JPanel lgrid, rgrid;

	public JRadioButton rbDrum;
	public JRadioButton rbPiano;

	public JRadioButton rbEigenes;

	private ButtonGroup groupRadioButton;

	private JFileChooser jFileChooser;

	
	private ObjectInputStream objectInputStream;
	
	private ProjektGui projektGui;
	private BenutzerProjekt benutzerProjekt;

	public JMenuBar menuBar;
	public JMenu mProjekt, mHilfe;
	public JMenuItem miNewProject, miOpenProject, miHilfe;


	private TastenListener tastenListener;

	public boolean[] istTasteGedrueckt = new boolean[27];

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

		for (int i = 0; i < istTasteGedrueckt.length; i++) {
			istTasteGedrueckt[i] = false;
		}

		istTasteGedrueckt = new boolean[27];

		initFrameElemente();
		initButtons();

		this.tastenListener = new TastenListener(this);
		tastenListener.start();

		this.setTitle("DigitalInputComputerKeyboard");

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
		rbEigenes = new JRadioButton("Eigenes Sample");
		rbPiano.setSelected(true);

		rbPiano.setFocusable(false);
		rbDrum.setFocusable(false);
		rbEigenes.setFocusable(false);

		menuBar = new JMenuBar();
		mProjekt = new JMenu("Projekt");
		mHilfe = new JMenu("Hilfe");
		miNewProject = new JMenuItem("Neues Projekt");
		miOpenProject = new JMenuItem("Projekt Öffnen");
		miHilfe = new JMenuItem("Hilfe");
		mProjekt.add(miOpenProject);
		mProjekt.add(miNewProject);
		mHilfe.add(miHilfe);
		menuBar.add(mProjekt);
		menuBar.add(mHilfe);
		this.setJMenuBar(menuBar);

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
		groupRadioButton.add(rbEigenes);

		notenpane.setFocusable(true);
		buttonpane.add(rbPiano);

		buttonpane.add(rbDrum);
		buttonpane.add(rbEigenes);


		tastenpane.add(lklav);
		tastenpane.add(rklav);

		contentpane.add(notenpane);
		contentpane.add(buttonpane);
		contentpane.add(tastenpane);
		
		GlassPane glassPane = new GlassPane(this);
		this.setGlassPane(glassPane);
		this.getGlassPane().setVisible(true);

		Dimension d = this.getToolkit().getScreenSize();

		this.setLocation((int) ((d.getWidth() - this.getWidth()) / 4),
				(int) ((d.getHeight() - this.getHeight()) / 4));

		NL.NotenlinienSchluesselSetzenLeer();
		this.setContentPane(contentpane);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		
		miOpenProject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				jFileChooser = new JFileChooser();
				int ret = jFileChooser.showSaveDialog(miOpenProject);
				if (ret == 0) {
					
					try {
						FileInputStream fileInputStream = new FileInputStream(jFileChooser.getSelectedFile());
						objectInputStream = new ObjectInputStream(fileInputStream);
						projektGui = new ProjektGui(getGui(), (BenutzerProjekt)objectInputStream.readObject());
						projektGui.setVisible(true);
						projektGui.pack();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}

			}
		});

		miNewProject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = JOptionPane.showInputDialog("Bitte Geben sie den Namen des Projektes ein");
				
				jFileChooser = new JFileChooser();
				jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int ret = jFileChooser.showSaveDialog(miNewProject);
				if (ret == 0) {
					String str = jFileChooser.getSelectedFile().getAbsolutePath();
					str = str.replace("\\", "/");
					benutzerProjekt = new BenutzerProjekt(str, name);
					projektGui = new ProjektGui(getGui(), benutzerProjekt);
					projektGui.setVisible(true);
					projektGui.pack();
				}

			}
		});

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
					projektGui.requestFocusInWindow();
				}

				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					Vector<Player> player = projektGui.getPlayer();

					for (int i = 0; i < player.size(); i++) {
						player.elementAt(i).setIstPausiert(false);
					}

					player.lastElement().setIstPausiert(false);
				}

				if (e.getID() == KeyEvent.KEY_PRESSED) {

					try {
						istTasteGedrueckt[Klaviertasten.getIntVonKey(e)] = true;
						NL.zeichneNote(Klaviertasten.getIntVonKey(e));
					} catch (KeyException e2) {
						e2.printStackTrace();
					}

				} else if (e.getID() == KeyEvent.KEY_RELEASED) {

					try {
						istTasteGedrueckt[Klaviertasten.getIntVonKey(e)] = false;
					} catch (KeyException e1) {
						e1.printStackTrace();
					}
				}

				return true;
			}
		};

		DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventPostProcessor(postProcessor);

		

	}


	public Gui getGui() {
		return this;
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


	public TastenListener getTastenListener() {
		return tastenListener;
	}

	public JRadioButton getRbEigenes() {
		return rbEigenes;
	}
	
	


}
