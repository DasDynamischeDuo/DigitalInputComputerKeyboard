package SampleAbspielen;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;


public class SampleAbspielen {
	
	private Mixer mixer;
	private Clip clip;
	
	
	public void clapAbspielen() {
		
		Mixer.Info[] mixerInfos = AudioSystem.getMixerInfo();
		
		/**
		for (int i = 0; i < mixerInfos.length; i++) {
			System.out.println(mixerInfos[i] +"----" +mixerInfos[i].getDescription());
		}
		*/
		
		mixer = AudioSystem.getMixer(mixerInfos[1]);
		DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
		
		try {
			clip = (Clip)mixer.getLine(dataInfo);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
		URL soundURL = SampleAbspielen.class.getResource("/SoundAbspielen/Clap.wav");

		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
			clip.open(audioInputStream);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
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
