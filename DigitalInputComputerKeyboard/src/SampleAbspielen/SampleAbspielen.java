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
		
		switch (instrument) {
		case 0:
			source = "/SonstigeSample/Metronom.wav";
			break;

		case 1:
			source = "/SchalgzeugSample/Closed-Hi-Hat.wav";
			if (ton <= 7) {
				source = "/SchalgzeugSample/Kick.wav";
			} else if (8 <= ton && ton <= 16 ) {
				source = "/SchalgzeugSample/Clap.wav";
			} else {
				source = "/SchalgzeugSample/Closed-Hi-Hat.wav";
			} {
				
			}
			break;
			
		case 2:
			source = "/PianoSample/PianoC4.wav";
			switch (ton) {

			case 0:
				source = "/PianoSample/PianoC4.wav";
				break;
				
			case 1:
				source = "/PianoSample/PianoCis4.wav";
				break;	
				
			case 2:
				source = "/PianoSample/PianoD4.wav";
				break;	
				
			case 3:
				source = "/PianoSample/PianoDis4.wav";
				break;	
				
			case 4:
				source = "/PianoSample/PianoE4.wav";
				break;	
				
			case 5:
				source = "/PianoSample/PianoF4.wav";
				break;
				
			case 6:
				source = "/PianoSample/PianoFis4.wav";
				break;
				
			case 7:
				source = "/PianoSample/PianoG4.wav";
				break;
				
			case 8:
				source = "/PianoSample/PianoGis4.wav";
				break;
				
			case 9:
				source = "/PianoSample/PianoA4.wav";
				break;
				
			case 10:
				source = "/PianoSample/PianoAis4.wav";
				break;
				
			case 11:
				source = "/PianoSample/PianoB4.wav";
				break;
				
			case 12:
				source = "/PianoSample/PianoC5.wav";
				break;
				
			case 13:
				source = "/PianoSample/PianoCis5.wav";
				break;	
				
			case 14:
				source = "/PianoSample/PianoD5.wav";
				break;	
				
			case 15:
				source = "/PianoSample/PianoDis5.wav";
				break;	
				
			case 16:
				source = "/PianoSample/PianoE5.wav";
				break;	
				
			case 17:
				source = "/PianoSample/PianoF5.wav";
				break;
				
			case 18:
				source = "/PianoSample/PianoFis5.wav";
				break;
				
			case 19:
				source = "/PianoSample/PianoG5.wav";
				break;
				
			case 20:
				source = "/PianoSample/PianoGis5.wav";
				break;
				
			case 21:
				source = "/PianoSample/PianoA5.wav";
				break;
				
			case 22:
				source = "/PianoSample/PianoAis5.wav";
				break;
				
			case 23:
				source = "/PianoSample/PianoB5.wav";
				break;
				
			default:
				break;
			}
			break;
			
		default:
			break;
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
		
		sampleStarten.removeSoundAbspielens(this);
		

	}

}
