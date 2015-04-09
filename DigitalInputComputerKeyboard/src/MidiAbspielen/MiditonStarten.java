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
	
	public void spieleTon(int taste) throws MidiUnavailableException {

		System.gc();

		
			miditonAbspielen.add(new MiditonAbspielen(taste, 10000));
		

		miditonAbspielen.lastElement().start();

	}

}
