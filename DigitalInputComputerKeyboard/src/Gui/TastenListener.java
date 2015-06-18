package Gui;

import java.io.IOException;


import Projekt.ProjektGui;
import SampleAbspielen.SampleStarten;

public class TastenListener implements Runnable {

	private Thread thread;
	private Gui gui;
	private ProjektGui projektGui;
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
		int instrument = 0;
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
							
							instrument = 1;
							sampleStarten.spieleSampleton(i, instrument);

						} else if (gui.getRbPiano().isSelected()) {
							
							instrument = 2;
							sampleStarten.spieleSampleton(i, instrument);
							
						} else if (gui.getRbEigenes().isSelected()) {
							
							instrument = 3;
							sampleStarten.spieleSampleton(i, instrument, gui.getBenutzerProjekt(), gui.getProjektGui());
							
						}
						
						
						gui.getNotenlinien().zeichneNote(i);
						
						if (projektGui != null && projektGui.getRekorder() != null && anzToeneGleichzeitig == 0) {
							projektGui.getRekorder().aufnehmen(i);
							anzToeneGleichzeitig++;

						} else if (projektGui != null && projektGui.getRekorder() != null && projektGui.getRekorder().isRekorderAsleep() && anzToeneGleichzeitig <= 2) {
							projektGui.getRekorder().gleichzeitigerTonSchreiben(i);
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
	
	public void setProjektGui(ProjektGui projektGui){
		this.projektGui = projektGui;
	}

}
