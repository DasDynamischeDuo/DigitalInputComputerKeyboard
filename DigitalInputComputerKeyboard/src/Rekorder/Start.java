package Rekorder;

import java.io.IOException;

public class Start {

	public static void main(String[] args) {

		Rekorder rekorder;
		Player player = new Player();
		
		
		try {
			rekorder = new Rekorder("test", 120, 1);
			rekorder.aufnehmen("202122-");
			rekorder.aufnehmen("06-");
			rekorder.aufnehmen("-");
			rekorder.aufnehmen("-");
			rekorder.aufnehmen("10-");
			rekorder.aufnehmen("-");
			rekorder.aufnehmen("09-");
			rekorder.aufnehmen("-");
			rekorder.aufnehmen("-");
			rekorder.aufnehmen("08-");
			rekorder.aufnahmeBeenden();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			player.abspielen("test");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
