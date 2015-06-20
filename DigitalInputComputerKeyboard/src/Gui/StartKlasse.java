package Gui;



public class StartKlasse {

	/**
	 * Die StartKlasse. In dieser Main Methode wird die Gui gebaut und konfiguriert.
	 * @param args
	 */
	public static void main(String[] args) {

		
		try {
			Gui gui = new Gui();
			gui.setVisible(true);
			gui.pack();
			gui.setSize(985, 600);
			gui.setResizable(false);
		} catch (Exception e) {
			System.out.println("Nice");
			e.printStackTrace();
		}
	}

}
