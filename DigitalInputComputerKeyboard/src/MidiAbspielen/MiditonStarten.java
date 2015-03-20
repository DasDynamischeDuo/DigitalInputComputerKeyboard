package MidiAbspielen;

import java.awt.event.KeyEvent;
import java.security.KeyException;
import java.util.Vector;

import javax.sound.midi.MidiUnavailableException;

public class MiditonStarten {
	
	Vector<MiditonAbspielen> miditonAbspielen;
	
	public MiditonStarten() throws MidiUnavailableException{
		
		this.miditonAbspielen = new Vector<MiditonAbspielen>();
		
		
	}
	
	
	public MiditonAbspielen lastElement() {
		return miditonAbspielen.lastElement();
	}

	public int indexOf(Object o) {
		return miditonAbspielen.indexOf(o);
	}

	public boolean removeSoundAbspielens(Object o) {
		return miditonAbspielen.remove(o);
	}
	
	public void spieleTon(KeyEvent e) {

		System.gc();

		try {
			miditonAbspielen.add(new MiditonAbspielen(MiditonAbspielen.getIntVonKey(e), 10000));
		} catch (KeyException e1) {
			System.out.println("Key nicht belegt");
			e1.printStackTrace();
		} catch (MidiUnavailableException e1) {
			System.out.println("Midi nicht erreichbar");
			e1.printStackTrace();
		}

		miditonAbspielen.lastElement().start();

	}

}
