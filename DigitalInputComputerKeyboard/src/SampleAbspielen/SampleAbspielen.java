package SampleAbspielen;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;

import Projekt.BenutzerProjekt;
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
	private BenutzerProjekt benutzerProjekt;

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

		soundURL = SampleAbspielen.class.getResource(dateipfadVonTon(ton,
				instrument));

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

	public String dateipfadVonTon(int ton, int instrument) {

		String source = "";

		switch (instrument) {
		case 0:
			return source = "/SonstigeSample/Metronom.wav";

		case 1:
			source = "/SchalgzeugSample/Closed-Hi-Hat.wav";
			if (ton <= 7) {
				return source = "/SchalgzeugSample/Kick.wav";
			} else if (8 <= ton && ton <= 16) {
				return source = "/SchalgzeugSample/Clap.wav";
			} else {
				return source = "/SchalgzeugSample/Closed-Hi-Hat.wav";
			}

		case 2:

			source = "/PianoSample/PianoC4.wav";

			switch (ton) {

			case 0:
				return source = "/PianoSample/PianoC4.wav";

			case 1:
				return source = "/PianoSample/PianoCis4.wav";

			case 2:
				return source = "/PianoSample/PianoD4.wav";

			case 3:
				return source = "/PianoSample/PianoDis4.wav";

			case 4:
				return source = "/PianoSample/PianoE4.wav";

			case 5:
				return source = "/PianoSample/PianoF4.wav";

			case 6:
				return source = "/PianoSample/PianoFis4.wav";

			case 7:
				return source = "/PianoSample/PianoG4.wav";

			case 8:
				return source = "/PianoSample/PianoGis4.wav";

			case 9:
				return source = "/PianoSample/PianoA4.wav";

			case 10:
				return source = "/PianoSample/PianoAis4.wav";

			case 11:
				return source = "/PianoSample/PianoB4.wav";

			case 12:
				return source = "/PianoSample/PianoC5.wav";

			case 13:
				return source = "/PianoSample/PianoCis5.wav";

			case 14:
				return source = "/PianoSample/PianoD5.wav";

			case 15:
				return source = "/PianoSample/PianoDis5.wav";

			case 16:
				return source = "/PianoSample/PianoE5.wav";

			case 17:
				return source = "/PianoSample/PianoF5.wav";

			case 18:
				return source = "/PianoSample/PianoFis5.wav";

			case 19:
				return source = "/PianoSample/PianoG5.wav";

			case 20:
				return source = "/PianoSample/PianoGis5.wav";

			case 21:
				return source = "/PianoSample/PianoA5.wav";

			case 22:
				return source = "/PianoSample/PianoAis5.wav";

			case 23:
				return source = "/PianoSample/PianoB5.wav";

			case 25:
				return source = " ";

			default:
				break;
			}

		case -1:

			source = benutzerProjekt.getUrlSamples();

			switch (ton) {
			case 0:
				return source += "/C4.wav";

			case 1:
				return source += "/4.wav";

			case 2:
				return source += "/D4.wav";

			case 3:
				return source += "/Dis4.wav";

			case 4:
				return source += "/E4.wav";

			case 5:
				return source += "/F4.wav";

			case 6:
				return source += "/Fis4.wav";

			case 7:
				return source += "/G4.wav";

			case 8:
				return source += "/Gis4.wav";

			case 9:
				return source += "/A4.wav";

			case 10:
				return source += "/Ais4.wav";

			case 11:
				return source += "/B4.wav";

			case 12:
				return source += "/C5.wav";

			case 13:
				return source += "/Cis5.wav";

			case 14:
				return source += "/D5.wav";

			case 15:
				return source += "/Dis5.wav";

			case 16:
				return source += "/E5.wav";

			case 17:
				return source += "/F5.wav";

			case 18:
				return source += "/Fis5.wav";

			case 19:
				return source += "/G5.wav";

			case 20:
				return source += "/Gis5.wav";

			case 21:
				return source += "/A5.wav";

			case 22:
				return source += "/Ais5.wav";

			case 23:
				return source += "/B5.wav";

			case 25:
				return source += "";

			default:
				break;
			}

		default:
			break;
		}

		return "failed";

	}

	public void setBenutzerProjekt(BenutzerProjekt benutzerProjekt) {

		this.benutzerProjekt = benutzerProjekt;

	}
}
