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

	public static int getIntVonKey(KeyEvent e) throws KeyException {

		switch ((int) e.getKeyChar()) {
		case AsciiCode.BRACKET_LEFT:
			return 60;
		case AsciiCode.A:
			return 61;
		case AsciiCode.Y:
			return 62;
		case AsciiCode.S:
			return 63;
		case AsciiCode.X:
			return 64;
		case AsciiCode.C:
			return 65;
		case AsciiCode.F:
			return 66;
		case AsciiCode.V:
			return 67;
		case AsciiCode.G:
			return 68;
		case AsciiCode.B:
			return 69;
		case AsciiCode.H:
			return 70;
		case AsciiCode.N:
			return 71;
		case AsciiCode.J:
			return 72;
		case AsciiCode.M:
			return 73;
		case AsciiCode.T:
			return 74;
		case AsciiCode.ZAHL_6:
			return 75;
		case AsciiCode.Z:
			return 76;
		case AsciiCode.ZAHL_7:
			return 77;
		case AsciiCode.U:
			return 78;
		case AsciiCode.I:
			return 79;
		case AsciiCode.ZAHL_9:
			return 80;
		case AsciiCode.O:
			return 81;
		case AsciiCode.ZAHL_0:
			return 82;
		case AsciiCode.P:
			return 83;
		case AsciiCode.SCHARF_S:
			return 84;
		case AsciiCode.UE:
			return 85;
		case AsciiCode.PLUS:
			return 86;
		default:
			return 1;
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
		miditonStarten.removeSoundAbspielens(this);
		synthesizer.close();
		this.interrupt();
	}

}
