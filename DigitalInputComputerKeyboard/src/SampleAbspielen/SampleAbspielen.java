package SampleAbspielen;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.sound.sampled.*;

import Projekt.BenutzerProjekt;
import Projekt.ProjektGui;
import Projekt.exceptionFenster;
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
	private SampleStarten sampleStarten;
	private BenutzerProjekt benutzerProjekt;
	private ProjektGui projektGui;

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

	public SampleAbspielen(SampleStarten sampleStarten,
			BenutzerProjekt benutzerProjekt, ProjektGui projektGui) {

		this.sampleStarten = sampleStarten;
		this.mixerInfos = AudioSystem.getMixerInfo();
		this.mixer = AudioSystem.getMixer(mixerInfos[0]);
		this.dataInfo = new DataLine.Info(Clip.class, null);
		this.benutzerProjekt = benutzerProjekt;
		this.projektGui = projektGui;

		try {
			clip = (Clip) mixer.getLine(this.dataInfo);
		} catch (LineUnavailableException e) {
			e.printStackTrace();

		}

	}

	public void tonAbspielen(int ton, String instrumentPath) {


		String path;
		File file = null;

		if (instrumentPath.equals("/PianoSample") || instrumentPath.equals("/SchalgzeugSample") || instrumentPath.equals("/SonstigeSample/Metronom.wav")) {

			
			try {
				file = new File(SampleAbspielen.class.getResource(dateipfadVonTon(ton, instrumentPath)).toURI());
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		} else {
			
			path = dateipfadVonTon(ton, instrumentPath);

			file = new File(path);

		}
		

		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
			clip.open(audioInputStream);
		} catch (UnsupportedAudioFileException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			exeptionhandle();
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			exeptionhandle();
			e.printStackTrace();
		}

		clip.start();

		sampleStarten.removeSoundAbspielens(this);

	}

	private void exeptionhandle() {
		
		exceptionFenster exp = new exceptionFenster();
		exp.setVisible(true);
		exp.pack();
		
	}

	public String dateipfadVonTon(int ton, String instrumentPath) {
		

		if (instrumentPath.equals("/SchalgzeugSample")) {
			

			if (ton <= 7) {
				return instrumentPath += "/Kick.wav";
			} else if (8 <= ton && ton <= 16) {
				return instrumentPath += "/Clap.wav";
			} else {
				return instrumentPath += "/Closed-Hi-Hat.wav";
			}

			
		} else {
	

			switch (ton) {
			case 0:
				return instrumentPath += "/C4.wav";

			case 1:
				return instrumentPath += "/Cis4.wav";

			case 2:
				return instrumentPath += "/D4.wav";

			case 3:
				return instrumentPath += "/Dis4.wav";

			case 4:
				return instrumentPath += "/E4.wav";

			case 5:
				return instrumentPath += "/F4.wav";

			case 6:
				return instrumentPath += "/Fis4.wav";

			case 7:
				return instrumentPath += "/G4.wav";

			case 8:
				return instrumentPath += "/Gis4.wav";

			case 9:
				return instrumentPath += "/A4.wav";

			case 10:
				return instrumentPath += "/Ais4.wav";

			case 11:
				return instrumentPath += "/B4.wav";

			case 12:
				return instrumentPath += "/C5.wav";

			case 13:
				return instrumentPath += "/Cis5.wav";

			case 14:
				return instrumentPath += "/D5.wav";

			case 15:
				return instrumentPath += "/Dis5.wav";

			case 16:
				return instrumentPath += "/E5.wav";

			case 17:
				return instrumentPath += "/F5.wav";

			case 18:
				return instrumentPath += "/Fis5.wav";

			case 19:
				return instrumentPath += "/G5.wav";

			case 20:
				return instrumentPath += "/Gis5.wav";

			case 21:
				return instrumentPath += "/A5.wav";

			case 22:
				return instrumentPath += "/Ais5.wav";

			case 23:
				return instrumentPath += "/B5.wav";

			case 25:
				return instrumentPath += "";
				
			case -1:
				return instrumentPath;

			default:
				break;
			}
		}

		return "failed";

	}

	public void setBenutzerProjekt(BenutzerProjekt benutzerProjekt) {

		this.benutzerProjekt = benutzerProjekt;

	}

	public void setProjektGui(ProjektGui projektGui) {

		this.projektGui = projektGui;

	}

}
