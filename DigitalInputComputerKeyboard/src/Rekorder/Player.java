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
	private int tempo, instrument;
	private SampleStarten sampleStarten;
	private Notenblatt notenblatt;
	private String noten;
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
		instrument = Integer.parseInt(bufferedReader.readLine());
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
			sampleStarten.spieleSampleton(-1, 0);
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

		projektGui.removePlayer(this);

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
