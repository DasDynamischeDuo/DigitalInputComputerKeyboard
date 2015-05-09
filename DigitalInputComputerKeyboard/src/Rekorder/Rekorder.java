package Rekorder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Rekorder {

	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	private File file;

	public Rekorder(String name, int tempo, int instrument) throws IOException {

		name = "C:/Users/Emanuel/git/DigitalInputComputerKeyboard/DigitalInputComputerKeyboard/Aufnahmen/"
				+ name + ".txt";

		file = new File(name);
		file.createNewFile();

		fileWriter = new FileWriter(file);
		bufferedWriter = new BufferedWriter(fileWriter);

	
		bufferedWriter.write(Integer.toString(tempo));
		bufferedWriter.newLine();
		bufferedWriter.write(Integer.toString(instrument));
		bufferedWriter.newLine();
		bufferedWriter.newLine();

	}

	public void aufnehmen(String text) throws IOException {

		bufferedWriter.write(text);
		bufferedWriter.newLine();

	}

	public void aufnahmeBeenden() throws IOException {
		bufferedWriter.close();
	}

}
