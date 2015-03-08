package SoundAbspielen;

import java.awt.event.KeyEvent;
import java.security.KeyException;

import javax.sound.midi.*;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class SoundAbspielen extends Thread {

	private int ton;
	private int tonLenght;
	private Synthesizer synthesizer;
	private Gui gui;
	private SampleAbspielen sampleAbspielen;

	public SoundAbspielen(int ton, int tonLenght, Gui gui) throws MidiUnavailableException {

		this.synthesizer = MidiSystem.getSynthesizer();
		synthesizer.open();
		this.ton = ton;
		this.tonLenght = tonLenght;
		this.gui = gui;
		this.sampleAbspielen = new SampleAbspielen();
	}

	public static int getIntVonKey(KeyEvent e) throws KeyException {

		switch (e.getKeyChar()) {
		case ' ':
			return 88;
		case '<':
			return 60;
		case 'a':
			return 61;
		case 'y':
			return 62;
		case 's':
			return 63;
		case 'x':
			return 64;
		case 'c':
			return 65;
		case 'f':
			return 66;
		case 'v':
			return 67;
		case 'g':
			return 68;
		case 'b':
			return 69;
		case 'h':
			return 70;
		case 'n':
			return 71;
		case 'j':
			return 72;
		case 'm':
			return 73;
		case 't':
			return 74;
		case '6':
			return 75;
		case 'z':
			return 76;
		case '7':
			return 77;
		case 'u':
			return 78;
		case 'i':
			return 79;
		case '9':
			return 80;
		case 'o':
			return 81;
		case '0':
			return 82;
		case 'p':
			return 83;
		case 'ß':
			return 84;
		case 'ü':
			return 85;
		case '+':
			return 86;
		default:
			return 87;
		}

	}

	@Override
	public void run() {

		if (ton == 88) {

			sampleAbspielen.clapAbspielen();

		} else {

			MidiChannel[] midiChannels = synthesizer.getChannels();

			midiChannels[0].noteOn(ton, tonLenght);
			try {
				sleep(tonLenght);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			midiChannels[0].noteOff(ton, tonLenght);
			gui.removeSoundAbspielens(this);
			synthesizer.close();
			this.interrupt();
		}

	}

}
=======
package SoundAbspielen;
import java.awt.event.KeyEvent;
import java.security.KeyException;

import javax.sound.midi.*;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class SoundAbspielen extends Thread {

	int ton;
	int tonLenght;
	Synthesizer synthesizer;
	Gui gui;

	public SoundAbspielen(int ton, int tonLenght, Gui gui) throws MidiUnavailableException {
		this.synthesizer = MidiSystem.getSynthesizer();
		synthesizer.open();
		this.ton = ton;
		this.tonLenght = tonLenght;
		this.gui = gui;

	}

	public static int getIntVonKey(KeyEvent e) throws KeyException{

		switch (e.getKeyChar()) {
		case '<':
			return 60;
		case 'a':
			return 61;
		case 'y':
			return 62;
		case 's':
			return 63;
		case 'x':
			return 64;
		case 'c':
			return 65;
		case 'f':
			return 66;
		case 'v':
			return 67;
		case 'g':
			return 68;
		case 'b':
			return 69;
		case 'h':
			return 70;
		case 'n':
			return 71;
		case 'j':
			return 72;
		case 'm':
			return 73;
		case 't':
			return 74;
		case '6':
			return 75;
		case 'z':
			return 76;
		case '7':
			return 77;
		case 'u':
			return 78;
		case 'i':
			return 79;
		case '9':
			return 80;
		case 'o':
			return 81;
		case '0':
			return 82;
		case 'p':
			return 83;
		case 'ß':
			return 84;
		case 'ü':
			return 85;
		case '+':
			return 86;
		default:
			return 87;
		}

	}

	@Override
	public void run() {

		MidiChannel[] midiChannels = synthesizer.getChannels();

		midiChannels[0].noteOn(ton, tonLenght);
		try {
			sleep(tonLenght);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		midiChannels[0].noteOff(ton, tonLenght);
		gui.removeSoundAbspielens(this);
		synthesizer.close();
		this.interrupt();
	}

}
