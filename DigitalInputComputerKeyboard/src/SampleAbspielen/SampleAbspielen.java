package SampleAbspielen;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;
import SampleAbspielen.SampleStarten;

/**
 * Spielt ein Sample ab
 * 
 * @author Emanuel
 * @version 0.1
 */

public class SampleAbspielen {

	private Mixer mixer;
	private Clip clip;
	private DataLine.Info dataInfo;
	private Mixer.Info[] mixerInfos;
	private URL soundURL;
	private SampleStarten sampleStarten;

	/**
	 * Spielt einen Clap-Ton ab
	 * 
	 * @author Emanuel
	 */

	public SampleAbspielen(SampleStarten sampleStarten) {

		this.sampleStarten = sampleStarten;
		this.mixerInfos = AudioSystem.getMixerInfo();
		this.mixer = AudioSystem.getMixer(mixerInfos[0]);
		this.dataInfo = new DataLine.Info(Clip.class, null);

		try {
			clip = (Clip) mixer.getLine(this.dataInfo);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}

		/*
		 * for (int i = 0; i < mixerInfos.length; i++) {
		 * System.out.println(mixerInfos[i] +"----"
		 * +mixerInfos[i].getDescription()); }
		 */

	}

	public void tonAbspielen(int ton, int instrument) {

		String source = "";

		if (instrument == 0) {
			source = "/SchalgzeugSample/Closed-Hi-Hat.wav";
			switch (ton) {
			case 0:
				source = "/SchalgzeugSample/Clap.wav";
				break;

			case 1:
				source = "/SchalgzeugSample/Kick.wav";
				break;

			case 2:
				source = "/SchalgzeugSample/Closed-Hi-Hat.wav";
				;
				break;

			default:
				break;
			}

		} else {
			source = "/PianoSample/PianoD2.wav";
			switch (ton) {

			case 0:
				source = "/PianoSample/PianoC5.wav";
				break;
				
			case 1:
				source = "/PianoSample/PianoD5.wav";
				break;	

			default:
				break;
			}
		}

		soundURL = SampleAbspielen.class.getResource(source);

		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(soundURL);
			clip.open(audioInputStream);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		clip.start();

	}

}
