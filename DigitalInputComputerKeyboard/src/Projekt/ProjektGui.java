package Projekt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Gui.Gui;
import Rekorder.Player;
import Rekorder.Rekorder;

public class ProjektGui extends JFrame {

	private JPanel contentpane;
	private JTextField tfDateiname, tfTempo;
	private JButton bAufnehmen, bStop, bPlay;
	private JFileChooser jFileChooser;
	private JComboBox<String> cbSamples;

	private Vector<Player> player;
	private Rekorder rekorder;

	private BenutzerProjekt benutzerProjekt;
	private Gui gui;

	public ProjektGui(Gui gui, BenutzerProjekt benutzerProjekt) {

		this.benutzerProjekt = benutzerProjekt;

		this.player = new Vector<Player>();

		this.gui = gui;

		contentpane = new JPanel();
		setContentPane(contentpane);

		tfDateiname = new JTextField("Dateiname");
		tfTempo = new JTextField("Tempo");
		bAufnehmen = new JButton("Aufnehmen");
		bStop = new JButton("Stop");
		bPlay = new JButton("Play");
		cbSamples = new JComboBox<String>();

		bAufnehmen.setFocusable(false);
		bStop.setFocusable(false);
		bPlay.setFocusable(false);

		contentpane.add(cbSamples);
		contentpane.add(tfDateiname);
		contentpane.add(tfTempo);
		contentpane.add(bAufnehmen);
		contentpane.add(bStop);
		contentpane.add(bPlay);

		File file = new File(benutzerProjekt.getUrlSamples());
		String[] sampels = file.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {

				return new File(dir, name).isDirectory();
			}
		});

		if (sampels.length != 0) {
			for (int i = 0; i < sampels.length; i++) {
				cbSamples.addItem(sampels[i]);
			}
		} else {
			cbSamples.addItem("Keine Sampels");
		}

		setTitle(benutzerProjekt.getProjektName());

		bAufnehmen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int instrument = getGui().getSelectedRB();
				String dateipfad = getBenutzerProjekt().getUrlAufnahmen() + "/"
						+ tfDateiname.getText();

				try {
					rekorder = new Rekorder(dateipfad, Integer.parseInt(tfTempo.getText()), instrument, getGui().getTastenListener());
					rekorder.setProjektGui(getProjektGui());
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
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
				jFileChooser = new JFileChooser();
				jFileChooser.setCurrentDirectory(new File(getBenutzerProjekt()
						.getUrlAufnahmen()));
				int ret = jFileChooser.showSaveDialog(bPlay);
				if (ret == 0) {
					File file = new File(jFileChooser.getSelectedFile()
							.getAbsolutePath());

					try {
						Player neuerPlayer = new Player(getProjektGui());
						player.add(neuerPlayer);
						player.lastElement().abspielen(file);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});

	}

	public boolean removePlayer(Object o) {
		return player.remove(o);
	}

	public Vector<Player> getPlayer() {
		return player;
	}

	public Rekorder getRekorder() {
		return rekorder;
	}

	public ProjektGui getProjektGui() {
		return this;
	}

	public Gui getGui() {
		return gui;
	}

	public BenutzerProjekt getBenutzerProjekt() {
		return benutzerProjekt;
	}
	
	public void close() {
		
		this.dispose();

	}

	public JComboBox<String> getCbSamples() {
		return cbSamples;
	}
	
	

}
