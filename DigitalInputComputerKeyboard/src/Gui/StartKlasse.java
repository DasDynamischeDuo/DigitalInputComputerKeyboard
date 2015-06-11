package Gui;

import Projekt.ProjektGui;

public class StartKlasse {

	/**
	 * Die StartKlasse. In dieser Main Methode wird die Gui gebaut und konfiguriert.
	 * @param args
	 */
	public static void main(String[] args) {

		
		Gui gui = new Gui();
		gui.setVisible(true);
		gui.pack();
		gui.setSize(985, 600);
		gui.setResizable(false);
	}

}
