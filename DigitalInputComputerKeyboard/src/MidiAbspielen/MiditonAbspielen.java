package MidiAbspielen;

import java.awt.event.KeyEvent;
import java.security.KeyException;

import javax.sound.midi.*;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class MiditonAbspielen extends Thread {

	int ton;
	int tonLenght;
	Synthesizer synthesizer;
	MiditonStarten miditonStarten;
	
	public MiditonAbspielen(int ton, int tonLenght) throws MidiUnavailableException {
		
		this.synthesizer = MidiSystem.getSynthesizer();
		synthesizer.open();
		this.ton = ton;
		this.tonLenght = tonLenght;
		this.miditonStarten = new MiditonStarten();
		
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
		miditonStarten.removeSoundAbspielens(this);
		synthesizer.close();
		this.interrupt();
	}

}
