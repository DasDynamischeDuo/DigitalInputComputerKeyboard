package MidiAbspielen;

import java.awt.event.KeyEvent;
import java.security.KeyException;

import javax.sound.midi.*;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/**
 * Kann einen Miditon abspielen
 * @author Emanuel
 * @version 0.1
 */

public class MiditonAbspielen extends Thread {

	int ton;
	int tonLenght;
	Synthesizer synthesizer;
	MiditonAbspielen miditonStarten;
	
	/**
	 * Erzeugt einen Synthesizer
	 * @author Emanuel
	 * @param {@link Integer} ton
	 * @param {@link Integer} tonLenght
	 * @throws MidiUnavailableException
	 */
	
	public MiditonAbspielen(int ton, int tonLenght) throws MidiUnavailableException {
		
		this.synthesizer = MidiSystem.getSynthesizer();
		synthesizer.open();
		this.ton = ton;
		this.tonLenght = tonLenght;
		this.miditonStarten = new MiditonAbspielen(0, 0);
		
	}

	/**
	 * Spielt einen Miditon ab
	 * @author Emanuel
	 */

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
		MiditonAbspielen.removeSoundAbspielens(this);
		synthesizer.close();
		
	}

	private static void removeSoundAbspielens(MiditonAbspielen miditonAbspielen) {
		// TODO Auto-generated method stub
		
	}

}
