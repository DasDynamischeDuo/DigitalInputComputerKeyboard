package MidiAbspielen;

import java.awt.event.KeyEvent;
import java.security.KeyException;
import java.util.Vector;

import javax.sound.midi.MidiUnavailableException;

/**
 * Startet einen Miditon
 * @author Emanuel
 * @version 0.1
 */

public class MiditonStarten {
	
	Vector<MiditonAbspielen> miditonAbspielen;
	
	/**
	 * Initialisiert einen Vektor aus MiditonAbspielen
	 * @author Emanuel
	 * @throws MidiUnavailableException
	 */
		
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
	
	/**
	 * Startet das letzte Element des Vektors {@link miditonAbspielen}
	 * @author Emanuel
	 * @param {@link Integer} taste
	 * @throws MidiUnavailableException
	 */
	
	public void spieleMiditon(int taste) throws MidiUnavailableException {

		System.gc();

		
			miditonAbspielen.add(new MiditonAbspielen(taste, 10000));
		

		miditonAbspielen.lastElement().start();

	}

}
