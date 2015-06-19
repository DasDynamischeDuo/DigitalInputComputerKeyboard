package Rekorder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Gui.Gui;
import Gui.Notenblatt;
import Projekt.BenutzerProjekt;
import Projekt.ProjektGui;
import SampleAbspielen.SampleStarten;

public class Player implements Runnable {

	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private Thread thread;
	private String str;
	private int tempo;
	private String instrument;
	private SampleStarten sampleStarten;
	private Notenblatt notenblatt;
	private String noten = "";
	private ProjektGui projektGui;

	public Player(ProjektGui projektGui) {

		this.thread = new Thread(this);
		this.projektGui = projektGui;
		this.sampleStarten = new SampleStarten();
		this.notenblatt = new Notenblatt(this, projektGui);
		notenblatt.setVisible(true);

	}

	public void abspielen(File file) throws IOException {

		notenblatt.setTitle(file.getName());

		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);

		tempo = Integer.parseInt(bufferedReader.readLine());
		instrument = bufferedReader.readLine();
		str = bufferedReader.readLine();

		thread.start();

	}

	@Override
	public void run() {
		int pause = 15000 / tempo;
		int taste[] = new int[3];
		String[] einzelTon = new String[3];

		while (notenblatt.isIstPausiert()) {
			try {
				thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < 4; i++) {
			sampleStarten.spieleSampleton(-1, "/SonstigeSample/Metronom.wav");
			try {
				thread.sleep(pause * 3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		while (str != null) {

			try {
				
				str = bufferedReader.readLine();
				if (str != null) {
					while (notenblatt.isIstPausiert()) {
						thread.sleep(50);
					}

					int i = 0;
					while (i * 2 + 1 < str.length()
							&& str.charAt(i * 2 + 1) != '-') {

						einzelTon[i] = "" + str.charAt(i * 2)
								+ str.charAt(i * 2 + 1);
						taste[i] = Integer.parseInt(einzelTon[i]);
						sampleStarten.spieleSampleton(taste[i], instrument);
						noten += getNoteName(taste[i]);

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

		projektGui.removePlayer(this);

	}
	
	
	public String getNoteName(int ton) {
		
		switch (ton) {
		case 0:
			return "C4";

		case 1:
			return "Cis4";

		case 2:
			return "D4";

		case 3:
			return "Dis4";

		case 4:
			return "E4";

		case 5:
			return "F4";

		case 6:
			return "Fis4";

		case 7:
			return "G4";

		case 8:
			return "Gis4";

		case 9:
			return "A4";

		case 10:
			return "Ais4";

		case 11:
			return "B4";

		case 12:
			return "C5";

		case 13:
			return "Cis5";

		case 14:
			return "D5";

		case 15:
			return "Dis5";

		case 16:
			return "E5";

		case 17:
			return "F5";

		case 18:
			return "Fis5";

		case 19:
			return "G5";

		case 20:
			return "Gis5";

		case 21:
			return "A5";

		case 22:
			return "Ais5";

		case 23:
			return "B5";
		
		default:
			break;
			
		}
		return "";
				
	}
	

	public void start() {

		if (!thread.isAlive()) {
			thread.run();
		}

	}

	public void setIstPausiert(boolean istPausiert) {
		notenblatt.setIstPausiert(istPausiert);
	}

}
