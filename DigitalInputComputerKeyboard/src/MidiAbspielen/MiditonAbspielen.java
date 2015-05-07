package MidiAbspielen;


import javax.sound.midi.*;

/**
 * Kann einen Miditon abspielen
 * @author Emanuel
 * @version 0.1
 */

public class MiditonAbspielen implements Runnable {

	private int ton;
	private int tonLenght;
	private Synthesizer synthesizer;
	private MiditonStarten miditonStarten;
	private Thread thread;
	
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
		this.miditonStarten = new MiditonStarten();
		this.thread = new Thread(this);
		
	}

	/**
	 * Spielt einen Miditon ab
	 * @author Emanuel
	 */

	@Override
	public void run() {

		MidiChannel[] midiChannels = synthesizer.getChannels();

		midiChannels[10].noteOn(ton, tonLenght);
		try {
			thread.sleep(tonLenght);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		midiChannels[10].noteOff(ton, tonLenght);
		miditonStarten.removeSoundAbspielens(this);
		synthesizer.close();
		
	}
	
	public void start() {
		
		if (!thread.isAlive()) {
			thread.start();
		}
		
		
	}

}
