package Rekorder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Thread.State;

import Gui.Notenblatt;
import SampleAbspielen.SampleStarten;

public class Player implements Runnable {

	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private File file;
	private Thread thread;
	private String str;
	private int tempo, instrument;
	private SampleStarten sampleStarten;
	private Notenblatt notenblatt;
	private String noten;

	public Player() {

		this.thread = new Thread(this);
		this.sampleStarten = new SampleStarten();
		this.notenblatt = new Notenblatt();
		notenblatt.setVisible(true);

	}

	public void abspielen(File file) throws IOException {
		
		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);

		tempo = Integer.parseInt(bufferedReader.readLine());
		instrument = Integer.parseInt(bufferedReader.readLine());
		str = bufferedReader.readLine();

		thread.start();

	}

	@Override
	public void run() {
		int pause = 15000 / tempo;
		int taste[] = new int[3];
		String[] einzelTon = new String[3];

		while (str != null) {
			
			try {
				str = bufferedReader.readLine();
				if (str != null) {
					while(notenblatt.isIstPausiert()) {
						thread.sleep(50);
					}
					
					int i = 0;
						while (i*2+1 < str.length() && str.charAt(i * 2 + 1) != '-') {
				
								einzelTon[i] = "" +str.charAt(i * 2) +str.charAt(i * 2 + 1);
								taste[i] = Integer.parseInt(einzelTon[i]);
								sampleStarten.spieleSampleton(taste[i], instrument);
								noten += taste[i];
								
							
							i++;
						}
						noten += " - ";
						notenblatt.getlNoten().setText(noten);
						thread.sleep(pause);
						
					}

				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public void start() {

		if (!thread.isAlive()) {
			thread.run();
		}

	}

}
