package Gui;

import java.io.IOException;

import Projekt.BenutzerProjekt;
import Projekt.ProjektGui;
import SampleAbspielen.SampleStarten;

public class TastenListener implements Runnable {

	private Thread thread;
	private Gui gui;
	private SampleStarten sampleStarten;
	private int anzToeneGleichzeitig = 0;

	private boolean[] istTonAbgespielt;

	public TastenListener(Gui gui) {

		this.thread = new Thread(this);
		this.gui = gui;
		this.istTonAbgespielt = new boolean[27];
		this.sampleStarten = new SampleStarten();

	}

	@Override
	public void run() {
		String instrumentPath = "";
		while (true) {

			for (int i = 0; i < gui.getIstTasteGedrueckt().length; i++) {
				if (!gui.getIstTasteGedrueckt(i) && istTonAbgespielt[i]) {
					Klaviertasten.releasButton(i, gui.getLtasten(),
							gui.getRtasten());
					istTonAbgespielt[i] = false;

				}

			}

			for (int i = 0; i < gui.getIstTasteGedrueckt().length; i++) {
				if (gui.getIstTasteGedrueckt(i) && !istTonAbgespielt[i]) {
					Klaviertasten.pressButton(i, gui.getLtasten(), gui.getRtasten());

					
					try{
						if (gui.getRbDrum().isSelected()) {
						
							instrumentPath = "/SchalgzeugSample";
							sampleStarten.spieleSampleton(i, instrumentPath);

						} else if (gui.getRbPiano().isSelected()) {
							
							instrumentPath = "/PianoSample";
							sampleStarten.spieleSampleton(i, instrumentPath);
							
						} else if (gui.getRbEigenes().isSelected()) {
							
							try {
								instrumentPath = instrumentPath = gui.getBenutzerProjekt().getUrlSamples() + "/" + gui.getProjektGui().getCbSamples().getSelectedItem();
								sampleStarten.spieleSampleton(i, instrumentPath, gui.getBenutzerProjekt(), gui.getProjektGui());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
						
						
						gui.getNotenlinien().zeichneNote(i);
						
						if (gui.getProjektGui() != null && gui.getProjektGui().getRekorder() != null && anzToeneGleichzeitig == 0) {
							gui.getProjektGui().getRekorder().aufnehmen(i);
							anzToeneGleichzeitig++;

						} else if (gui.getProjektGui() != null && gui.getProjektGui().getRekorder() != null && gui.getProjektGui().getRekorder().isRekorderAsleep() && anzToeneGleichzeitig <= 2) {
							gui.getProjektGui().getRekorder().gleichzeitigerTonSchreiben(i);
							anzToeneGleichzeitig++;
						}
						
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
					
						
					istTonAbgespielt[i] = true;

				}

			}

		}
	}

	public void start() {

		if (!thread.isAlive()) {
			thread.start();
		}

	}

	public void setAnzToeneGleichzeitig(int anzToeneGleichzeitig) {
		this.anzToeneGleichzeitig = anzToeneGleichzeitig;
	}

}
