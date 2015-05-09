package Rekorder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Rekorder implements Runnable {

	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	private File file;
	private Thread thread;
	private boolean istRekorderAktiv = false;
	private boolean istTonGespieltwurden;
	private int taste, tempo;

	public Rekorder(String name, int tempo, int instrument) throws IOException {

		name = "C:/Users/Emanuel/git/DigitalInputComputerKeyboard/DigitalInputComputerKeyboard/Aufnahmen/"
				+ name + ".txt";

		file = new File(name);
		file.createNewFile();

		fileWriter = new FileWriter(file);
		bufferedWriter = new BufferedWriter(fileWriter);

		this.tempo = tempo;

		thread = new Thread(this);

		bufferedWriter.write(Integer.toString(tempo));
		bufferedWriter.newLine();
		bufferedWriter.write(Integer.toString(instrument));
		bufferedWriter.newLine();
		bufferedWriter.newLine();
		istRekorderAktiv = true;
		thread.start();

	}

	public void aufnehmen(int taste) throws IOException {
		this.taste = taste;
		istTonGespieltwurden = true;

	}

	public void aufnahmeBeenden() throws IOException {
		bufferedWriter.close();
	}

	@Override
	public void run() {
		while (istRekorderAktiv) {
			
			if (istTonGespieltwurden) {
				try {
				if (taste < 10) {
					bufferedWriter.write("0" +Integer.toString(taste));
					System.out.print("0" +Integer.toString(taste));
				} else {
					bufferedWriter.write(Integer.toString(taste));
					System.out.print(Integer.toString(taste));
				}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				try {
					bufferedWriter.write("-");
					bufferedWriter.newLine();
					System.out.println("-");
					istTonGespieltwurden = false;
					Thread.sleep((15000/tempo));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		
		
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
		
	}

	public void setIstRekorderAktiv(boolean istRekorderAktiv) {
		this.istRekorderAktiv = istRekorderAktiv;
	}

	public void start() {

		if (!thread.isAlive()) {
			thread.run();
		}

	}

}
