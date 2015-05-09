package Rekorder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import SampleAbspielen.SampleStarten;

public class Player implements Runnable {

	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private File file;
	private Thread thread;
	private String str;
	private int tempo, instrument;
	private SampleStarten sampleStarten;

	public Player() {

		this.thread = new Thread(this);
		this.sampleStarten = new SampleStarten();

	}

	public void abspielen(String name) throws IOException {

		file = new File(
				"C:/Users/Emanuel/git/DigitalInputComputerKeyboard/DigitalInputComputerKeyboard/Aufnahmen/"
						+ name + ".txt");
		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);

		tempo = Integer.parseInt(bufferedReader.readLine());
		instrument = Integer.parseInt(bufferedReader.readLine());
		str = bufferedReader.readLine();

		thread.start();

	}

	@Override
	public void run() {
		int pause = (tempo * 100) / 24;
		int taste[] = new int[3];
		String[] einzelTon = new String[3];

		while (str != null) {
			try {
				str = bufferedReader.readLine();
				if (str != null) {
					int i = 0;
						while (i*2+1 < str.length() && str.charAt(i * 2 + 1) != '-') {
				
								einzelTon[i] = "" +str.charAt(i * 2) +str.charAt(i * 2 + 1);
								taste[i] = Integer.parseInt(einzelTon[i]);
								sampleStarten.spieleSampleton(taste[i], instrument);
								System.out.print(taste[i] +", ");
							
							i++;
						}

						System.out.println("-");
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
