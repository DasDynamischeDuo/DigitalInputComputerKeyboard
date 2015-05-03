package SampleAbspielen;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.*;

/**
 * Spielt ein Sample ab
 * @author Emanuel
 * @version 0.1
 */

public class SampleAbspielen {
	
	private Mixer mixer;
	private Clip clip;
	
	/**
	 * Spielt einen Clap-Ton ab
	 * @author Emanuel
	 */
	
	public void clapAbspielen() {
		
		Mixer.Info[] mixerInfos = AudioSystem.getMixerInfo();
		
		
		//for (int i = 0; i < mixerInfos.length; i++) {
		//	System.out.println(mixerInfos[i] +"----" +mixerInfos[i].getDescription());
		//}
		
		
		mixer = AudioSystem.getMixer(mixerInfos[1]);
		DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
		
		try {
			clip = (Clip)mixer.getLine(dataInfo);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
		File file = new File("/DigitalInputComputerKeyboard/src/SampleAbspielen/clap-analog.wav");
		AudioFileFormat audiofile = null;
		
		try {
			audiofile = AudioSystem.getAudioFileFormat(file);
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		System.out.println(audiofile);
		
		
		URL soundURL = SampleAbspielen.class.getResource(file.getAbsolutePath());
		
		System.out.println(soundURL);			
		
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
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
		
		
		do {
			
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				
			}
			
		} while (clip.isActive());
		
		
	}
	

}
