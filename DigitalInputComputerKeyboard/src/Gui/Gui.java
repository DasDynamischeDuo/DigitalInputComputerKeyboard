package Gui;

import java.awt.BorderLayout;
import java.awt.DefaultKeyboardFocusManager;
import java.awt.Dimension;

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
import Projekt.Hilfe;
import Projekt.ProjektGui;
import Rekorder.Player;


/**
 * Die Graphische Benutzeroberflaeche des Digital Input Computer Keyboard
 * 
 * @author Emanuel
 * @version 0.1
 */

public class Gui extends JFrame {

	private Notenlinien notenlinien;

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
	public JMenu mProjektOpen, mHilfe, mProjektNeu;
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
		
		notenlinien = new Notenlinien(this);

		initFrameElemente();
		initButtons();

		this.tastenListener = new TastenListener(this);
		tastenListener.start();

		this.setTitle("DigitalInputComputerKeyboard");
		

	}
	
	/**
	 * Initialisiert alle Frame Elemente. 
	 * @author Fabian
	 */

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
		mProjektNeu = new JMenu("Neues Projekt");
		mProjektOpen = new JMenu("Projekt Öffnen");
		mHilfe = new JMenu("Hilfe");
		
		
		miNewProject = new JMenuItem("Neues Projekt");
		miOpenProject = new JMenuItem("Projekt Öffnen");
		miHilfe = new JMenuItem("Hilfe");
		
		menuBar.add(mProjektNeu);
		menuBar.add(mProjektOpen);
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

		notenlinien.NotenlinienSchluesselSetzenLeer();
		this.setContentPane(contentpane);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		miHilfe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Hilfe hilfeklicked = new Hilfe();
				hilfeklicked.setVisible(true);
				hilfeklicked.pack();
				
			}
		});
		
		miOpenProject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				jFileChooser = new JFileChooser();
				int ret = jFileChooser.showSaveDialog(miOpenProject);
				if (ret == 0) {
					
					try {
						
						if (projektGui != null) {
							
							projektGui.close();
							
						}
						
						FileInputStream fileInputStream = new FileInputStream(jFileChooser.getSelectedFile());
						objectInputStream = new ObjectInputStream(fileInputStream);
						benutzerProjekt = (BenutzerProjekt)objectInputStream.readObject();
						projektGui = new ProjektGui(getGui(), benutzerProjekt);
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

	/**
	 * getter Methode für die Gui
	 * @return Gui
	 */

	public Gui getGui() {
		return this;
	}

	/**
	 * getter Methode für ein Array in dem der Zustand der Taste festgehalten wird.
	 * @return boolean[]
	 */
	public boolean[] getIstTasteGedrueckt() {
		return istTasteGedrueckt;
	}

	/**
	 * getter Methode für die rechten Tasten
	 * @return JToggleButton[]
	 */
	public JToggleButton[] getRtasten() {
		return rtasten;
	}

	/**
	 * get Methode für den DrumButton
	 * @return JRadioButton
	 */
	public JRadioButton getRbDrum() {
		return rbDrum;
	}
	
	/**
	 * get Methode für den PianoButton
	 * @return JRadioButton
	 */

	public JRadioButton getRbPiano() {
		return rbPiano;
	}
	
	/**
	 * get Methode für die linken Tasten
	 * @return JToggleButton[]
	 */

	public JToggleButton[] getLtasten() {
		return ltasten;
	}
	
	/**
	 * get Methode für die Notenpane
	 * @return JPanel
	 */

	public JPanel getNotenpane() {
		return notenpane;
	}
	
	/**
	 * get Methode um zu prüfen ob das array an einer bestimmten Stelle true ist.
	 * 
	 * @param stelle
	 * @return boolean 
	 */

	public boolean getIstTasteGedrueckt(int stelle) {
		return istTasteGedrueckt[stelle];
	}

	/**
	 * get Methode für den TastenListener 
	 * @return TastenListener
	 */

	public TastenListener getTastenListener() {
		return tastenListener;
	}

	/**
	 * get Methode für den RadioButton
	 * @return JRadioButton
	 */
	public JRadioButton getRbEigenes() {
		return rbEigenes;
	}

	
	/**
	 * get Methode für die Notenlinien
	 * @return Notenlinien
	 */
	public Notenlinien getNotenlinien() {
		return notenlinien;
	}

	/**
	 * get Methode für das BenutzerProjekt
	 * @return BenutzerProjekt
	 */
	public BenutzerProjekt getBenutzerProjekt() {
		return benutzerProjekt;
	}

	/**
	 * get Methode für das ProjektGui
	 * @return ProjektGui
	 */
	public ProjektGui getProjektGui() {
		return projektGui;
	}
	
	
	/**
	 * get Methode für die RadioButtons. Je nachdem welcher Button ausgewählt wird, wird eine andere Zahl
	 * zurückgegeben.
	 * @return int
	 */
	public int getSelectedRB() {
		
		if (rbDrum.isSelected()) {
			return 1;
		} else if (rbPiano.isSelected()) {
			return 2;
		} else if (rbEigenes.isSelected()) {
			return 3;
		}
	
		return 0;
		
	}


}
