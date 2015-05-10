package Gui;

import java.io.IOException;

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
					Klaviertasten.pressButton(i, gui.getLtasten(),
							gui.getRtasten());

					try {
						if (gui.getRbDrum().isSelected()) {
							sampleStarten.spieleSampleton(i, 1);
							if (gui.getRekorder() != null && anzToeneGleichzeitig == 0) {
								gui.getRekorder().aufnehmen(i);
								anzToeneGleichzeitig++;

							} else if (gui.getRekorder() != null && gui.getRekorder().isRekorderAsleep() && anzToeneGleichzeitig <= 2) {
								gui.getRekorder().gleichzeitigerTonSchreiben(i);
								anzToeneGleichzeitig++;
							}

						}

						if (gui.getRbPiano().isSelected()) {
							sampleStarten.spieleSampleton(i, 2);

							if (gui.getRekorder() != null && anzToeneGleichzeitig == 0) {
								gui.getRekorder().aufnehmen(i);
								anzToeneGleichzeitig++;
								
							} else if (gui.getRekorder() != null && gui.getRekorder().isRekorderAsleep() && anzToeneGleichzeitig <= 2) {
								gui.getRekorder().gleichzeitigerTonSchreiben(i);
								anzToeneGleichzeitig++;
							}

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
