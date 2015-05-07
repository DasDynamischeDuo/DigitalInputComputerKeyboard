package Gui;

import javax.sound.midi.MidiUnavailableException;

import MidiAbspielen.MiditonStarten;
import SampleAbspielen.SampleAbspielen;
import SampleAbspielen.SampleStarten;

public class TastenListener implements Runnable {

	private Thread thread;
	private Gui gui;
	private MiditonStarten miditonStarten;
	private SampleStarten sampleStarten;
	
	private boolean[] istTonAbgespielt;

	public TastenListener(Gui gui) throws MidiUnavailableException {

		this.thread = new Thread(this);
		this.gui = gui;

		this.istTonAbgespielt = new boolean[27];
		
		this.miditonStarten = new MiditonStarten();
		this.sampleStarten = new SampleStarten();
		
	}

	@Override
	public void run() {
		while (true) {

			
			
			for (int i = 0; i < gui.getIstTasteGedrueckt().length; i++) {
				if (!gui.getIstTasteGedrueckt(i) && istTonAbgespielt[i]) {
					Klaviertasten.releasButton(i + 60, gui.getLtasten(), gui.getRtasten());
					istTonAbgespielt[i] = false;

				}

			}

			for (int i = 0; i < gui.getIstTasteGedrueckt().length; i++) {
				if (gui.getIstTasteGedrueckt(i) && !istTonAbgespielt[i]) {
					Klaviertasten.pressButton(i + 60, gui.getLtasten(), gui.getRtasten());
					
					
					if (gui.getRbSample1().isSelected()) {
						sampleStarten.spieleSampleton(1);
					} else {
						
						try {
							miditonStarten.spieleMiditon(i + 60);
						} catch (MidiUnavailableException e) {
							// TODO Auto-generated catch block
						e.printStackTrace();
						}
						
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

}
