package Gui;

import java.awt.Color;

import java.awt.event.KeyEvent;
import java.security.KeyException;

import javax.swing.JToggleButton;


/**
 * In Klaviertasten sind alle Methoden, welche die Klaviertasten betreffen,
 * enthalten
 * 
 * @author Emanuel
 * @version 0.1
 */

public class Klaviertasten {

	/**
	 * Lässt Taste auf dem Bildschirm los, sobald die dazugehaerige Taste auf der
	 * Tastatur losgelassen wird.
	 * 
	 * @author Emanuel
	 * @param {@link Integer} intVonKey
	 * @param {@link JToggleButton[]} ltasten
	 * @param {@link JToggleButton[]} rtasten
	 */

	public static void releasButton(int intVonKey, JToggleButton[] ltasten, JToggleButton[] rtasten) {

		switch (intVonKey) {

		case 0:

			for (int i = 1; i < 88; i = i + 17) {
				ltasten[i].setSelected(false);
				;
				if (i == 69 | i == 86) {
					ltasten[i + 1].setSelected(false);
				}

			}
			break;

		case 1:

			int z = 2;
			ltasten[2].setSelected(false);

			for (int i = 0; i < 3; i++) {
				z++;
				ltasten[z].setSelected(false);
				z = z + 16;
				ltasten[z].setSelected(false);
			}
			ltasten[54].setSelected(false);

			break;

		case 2:

			for (int j = 4; j < 91; j = j + 17) {
				ltasten[j].setSelected(false);
				if (j == 72 | j == 89) {
					ltasten[j - 1].setSelected(false);
					ltasten[j].setSelected(false);
					ltasten[j + 1].setSelected(false);
				}
			}

			break;

		case 3:

			int z2 = 5;
			ltasten[5].setSelected(false);

			for (int j = 0; j < 3; j++) {
				z2++;
				ltasten[z2].setSelected(false);
				z2 = z2 + 16;
				ltasten[z2].setSelected(false);
			}
			ltasten[57].setSelected(false);

			break;

		case 4:

			for (int j = 7; j < 93; j = j + 17) {
				ltasten[j].setSelected(false);
				if (j == 75 | j == 92) {
					ltasten[j - 1].setSelected(false);
				}
			}

			break;

		case 5:

			for (int j = 8; j < 95; j = j + 17) {
				ltasten[j].setSelected(false);
				;
				if (j == 76 | j == 93) {
					ltasten[j + 1].setSelected(false);
				}

			}

			break;

		case 6:

			int z3 = 9;
			ltasten[9].setSelected(false);

			for (int j = 0; j < 3; j++) {
				z3++;
				ltasten[z3].setSelected(false);
				z3 = z3 + 16;
				ltasten[z3].setSelected(false);
			}
			ltasten[61].setSelected(false);

			break;

		case 7:

			for (int j = 11; j < 98; j = j + 17) {
				ltasten[j].setSelected(false);
				if (j == 79 | j == 96) {
					ltasten[j - 1].setSelected(false);
					ltasten[j].setSelected(false);
					ltasten[j + 1].setSelected(false);
				}
			}

			break;

		case 8:

			int z4 = 12;
			ltasten[12].setSelected(false);

			for (int j = 0; j < 3; j++) {
				z4++;
				ltasten[z4].setSelected(false);
				z4 = z4 + 16;
				ltasten[z4].setSelected(false);
			}
			ltasten[64].setSelected(false);

			break;

		case 9:

			for (int j = 14; j < 101; j = j + 17) {
				ltasten[j].setSelected(false);
				if (j == 82 | j == 99) {
					ltasten[j - 1].setSelected(false);
					ltasten[j].setSelected(false);
					ltasten[j + 1].setSelected(false);
				}
			}

			break;

		case 10:

			int z5 = 15;
			ltasten[15].setSelected(false);

			for (int j = 0; j < 3; j++) {
				z5++;
				ltasten[z5].setSelected(false);
				z5 = z5 + 16;
				ltasten[z5].setSelected(false);
			}
			ltasten[67].setSelected(false);

			break;

		case 11:

			for (int j = 17; j < 103; j = j + 17) {
				ltasten[j].setSelected(false);
				if (j == 85 | j == 102) {
					ltasten[j - 1].setSelected(false);
				}
			}

			break;


		case 12:

			for (int j = 1; j < 88; j = j + 17) {
				rtasten[j].setSelected(false);
				;
				if (j == 69 | j == 86) {
					rtasten[j + 1].setSelected(false);
				}

			}
			break;

		case 13:

			int z6 = 2;
			rtasten[2].setSelected(false);

			for (int j = 0; j < 3; j++) {
				z6++;
				rtasten[z6].setSelected(false);
				z6 = z6 + 16;
				rtasten[z6].setSelected(false);
			}
			rtasten[54].setSelected(false);

			break;

		case 14:

			for (int j = 4; j < 91; j = j + 17) {
				rtasten[j].setSelected(false);
				if (j == 72 | j == 89) {
					rtasten[j - 1].setSelected(false);
					rtasten[j].setSelected(false);
					rtasten[j + 1].setSelected(false);
				}
			}

			break;

		case 15:

			int z7 = 5;
			rtasten[5].setSelected(false);

			for (int j = 0; j < 3; j++) {
				z7++;
				rtasten[z7].setSelected(false);
				z7 = z7 + 16;
				rtasten[z7].setSelected(false);
			}
			rtasten[57].setSelected(false);

			break;

		case 16:

			for (int j = 7; j < 93; j = j + 17) {
				rtasten[j].setSelected(false);
				if (j == 75 | j == 92) {
					rtasten[j - 1].setSelected(false);
				}
			}

			break;

		case 17:

			for (int j = 8; j < 95; j = j + 17) {
				rtasten[j].setSelected(false);
				;
				if (j == 76 | j == 93) {
					rtasten[j + 1].setSelected(false);
				}

			}

			break;

		case 18:

			int z8 = 9;
			rtasten[9].setSelected(false);

			for (int j = 0; j < 3; j++) {
				z8++;
				rtasten[z8].setSelected(false);
				z8 = z8 + 16;
				rtasten[z8].setSelected(false);
			}
			rtasten[61].setSelected(false);

			break;

		case 19:

			for (int j = 11; j < 98; j = j + 17) {
				rtasten[j].setSelected(false);
				if (j == 79 | j == 96) {
					rtasten[j - 1].setSelected(false);
					rtasten[j].setSelected(false);
					rtasten[j + 1].setSelected(false);
				}
			}

			break;

		case 20:

			int z9 = 12;
			rtasten[12].setSelected(false);

			for (int j = 0; j < 3; j++) {
				z9++;
				rtasten[z9].setSelected(false);
				z9 = z9 + 16;
				rtasten[z9].setSelected(false);
			}
			rtasten[64].setSelected(false);

			break;

		case 21:

			for (int j = 14; j < 101; j = j + 17) {
				rtasten[j].setSelected(false);
				if (j == 82 | j == 99) {
					rtasten[j - 1].setSelected(false);
					rtasten[j].setSelected(false);
					rtasten[j + 1].setSelected(false);
				}
			}

			break;

		case 22:

			int z10 = 15;
			rtasten[15].setSelected(false);

			for (int j = 0; j < 3; j++) {
				z10++;
				rtasten[z10].setSelected(false);
				z10 = z10 + 16;
				rtasten[z10].setSelected(false);
			}
			rtasten[67].setSelected(false);

			break;

		case 23:

			for (int j = 17; j < 103; j = j + 17) {
				rtasten[j].setSelected(false);
				if (j == 85 | j == 102) {
					rtasten[j - 1].setSelected(false);
				}
			}

			break;

		default:
			break;
		}

	}

	/**
	 * Betätigt Taste auf dem Bildschirm, sobald die dazugehörige Taste auf der
	 * Tastatur losgelassen wird.
	 * 
	 * @author Emanuel
	 * @param {@link Integer} intVonKey
	 * @param {@link JToggleButton[]} ltasten
	 * @param {@link JToggleButton[]} rtasten
	 */

	public static void pressButton(int intVonKey, JToggleButton[] ltasten, JToggleButton[] rtasten) {

		switch (intVonKey) {

		case 0:


			for (int j = 1; j < 88; j = j + 17) {
				ltasten[j].setSelected(true);
				;
				if (j == 69 | j == 86) {
					ltasten[j + 1].setSelected(true);
				}

			}
			break;

		case 1:

			int z = 2;
			ltasten[2].setSelected(true);

			for (int j = 0; j < 3; j++) {
				z++;
				ltasten[z].setSelected(true);
				z = z + 16;
				ltasten[z].setSelected(true);
			}
			ltasten[54].setSelected(true);

			break;

		case 2:

			for (int j = 4; j < 91; j = j + 17) {
				ltasten[j].setSelected(true);
				if (j == 72 | j == 89) {
					ltasten[j - 1].setSelected(true);
					ltasten[j].setSelected(true);
					ltasten[j + 1].setSelected(true);
				}
			}

			break;

		case 3:

			int z2 = 5;
			ltasten[5].setSelected(true);

			for (int j = 0; j < 3; j++) {
				z2++;
				ltasten[z2].setSelected(true);
				z2 = z2 + 16;
				ltasten[z2].setSelected(true);
			}
			ltasten[57].setSelected(true);

			break;

		case 4:

			for (int j = 7; j < 93; j = j + 17) {
				ltasten[j].setSelected(true);
				if (j == 75 | j == 92) {
					ltasten[j - 1].setSelected(true);
				}
			}

			break;

		case 5:

			for (int j = 8; j < 95; j = j + 17) {
				ltasten[j].setSelected(true);
				;
				if (j == 76 | j == 93) {
					ltasten[j + 1].setSelected(true);
				}

			}

			break;

		case 6:

			int z3 = 9;
			ltasten[9].setSelected(true);

			for (int j = 0; j < 3; j++) {
				z3++;
				ltasten[z3].setSelected(true);
				z3 = z3 + 16;
				ltasten[z3].setSelected(true);
			}
			ltasten[61].setSelected(true);

			break;

		case 7:

			for (int j = 11; j < 98; j = j + 17) {
				ltasten[j].setSelected(true);
				if (j == 79 | j == 96) {
					ltasten[j - 1].setSelected(true);
					ltasten[j].setSelected(true);
					ltasten[j + 1].setSelected(true);
				}
			}

			break;

		case 8:

			int z4 = 12;
			ltasten[12].setSelected(true);

			for (int j = 0; j < 3; j++) {
				z4++;
				ltasten[z4].setSelected(true);
				z4 = z4 + 16;
				ltasten[z4].setSelected(true);
			}
			ltasten[64].setSelected(true);

			break;

		case 9:

			for (int j = 14; j < 101; j = j + 17) {
				ltasten[j].setSelected(true);
				if (j == 82 | j == 99) {
					ltasten[j - 1].setSelected(true);
					ltasten[j].setSelected(true);
					ltasten[j + 1].setSelected(true);
				}
			}

			break;

		case 10:

			int z5 = 15;
			ltasten[15].setSelected(true);

			for (int j = 0; j < 3; j++) {
				z5++;
				ltasten[z5].setSelected(true);
				z5 = z5 + 16;
				ltasten[z5].setSelected(true);
			}
			ltasten[67].setSelected(true);

			break;

		case 11:

			for (int j = 17; j < 103; j = j + 17) {
				ltasten[j].setSelected(true);
				if (j == 85 | j == 102) {
					ltasten[j - 1].setSelected(true);
				}
			}

			break;

		case 12:

			for (int j = 1; j < 88; j = j + 17) {
				rtasten[j].setSelected(true);
				;
				if (j == 69 | j == 86) {
					rtasten[j + 1].setSelected(true);
				}

			}
			break;

		case 13:

			int z6 = 2;
			rtasten[2].setSelected(true);

			for (int j = 0; j < 3; j++) {
				z6++;
				rtasten[z6].setSelected(true);
				z6 = z6 + 16;
				rtasten[z6].setSelected(true);
			}
			rtasten[54].setSelected(true);

			break;

		case 14:

			for (int j = 4; j < 91; j = j + 17) {
				rtasten[j].setSelected(true);
				if (j == 72 | j == 89) {
					rtasten[j - 1].setSelected(true);
					rtasten[j].setSelected(true);
					rtasten[j + 1].setSelected(true);
				}
			}

			break;

		case 15:

			int z7 = 5;
			rtasten[5].setSelected(true);

			for (int j = 0; j < 3; j++) {
				z7++;
				rtasten[z7].setSelected(true);
				z7 = z7 + 16;
				rtasten[z7].setSelected(true);
			}
			rtasten[57].setSelected(true);

			break;

		case 16:

			for (int j = 7; j < 93; j = j + 17) {
				rtasten[j].setSelected(true);
				if (j == 75 | j == 92) {
					rtasten[j - 1].setSelected(true);
				}
			}

			break;

		case 17:

			for (int j = 8; j < 95; j = j + 17) {
				rtasten[j].setSelected(true);
				;
				if (j == 76 | j == 93) {
					rtasten[j + 1].setSelected(true);
				}

			}

			break;

		case 18:

			int z8 = 9;
			rtasten[9].setSelected(true);

			for (int j = 0; j < 3; j++) {
				z8++;
				rtasten[z8].setSelected(true);
				z8 = z8 + 16;
				rtasten[z8].setSelected(true);
			}
			rtasten[61].setSelected(true);

			break;

		case 19:

			for (int j = 11; j < 98; j = j + 17) {
				rtasten[j].setSelected(true);
				if (j == 79 | j == 96) {
					rtasten[j - 1].setSelected(true);
					rtasten[j].setSelected(true);
					rtasten[j + 1].setSelected(true);
				}
			}

			break;

		case 20:

			int z9 = 12;
			rtasten[12].setSelected(true);

			for (int j = 0; j < 3; j++) {
				z9++;
				rtasten[z9].setSelected(true);
				z9 = z9 + 16;
				rtasten[z9].setSelected(true);
			}
			rtasten[64].setSelected(true);

			break;

		case 21:

			for (int j = 14; j < 101; j = j + 17) {
				rtasten[j].setSelected(true);
				if (j == 82 | j == 99) {
					rtasten[j - 1].setSelected(true);
					rtasten[j].setSelected(true);
					rtasten[j + 1].setSelected(true);
				}
			}

			break;

		case 22:

			int z10 = 15;
			rtasten[15].setSelected(true);

			for (int j = 0; j < 3; j++) {
				z10++;
				rtasten[z10].setSelected(true);
				z10 = z10 + 16;
				rtasten[z10].setSelected(true);
			}
			rtasten[67].setSelected(true);

			break;

		case 23:

			for (int j = 17; j < 103; j = j + 17) {
				rtasten[j].setSelected(true);
				if (j == 85 | j == 102) {
					rtasten[j - 1].setSelected(true);
				}
			}

			break;

		default:
			break;
		}
	}

	/**
	 * 
	 * Initalisiert alle Buttons in 2 schleifen.
	 * 
	 * @param rtasten
	 *            []
	 * @param ltasten
	 *            []
	 * 
	 */

	public static void buttonsInitialisieren(JToggleButton rtasten[], JToggleButton ltasten[]) {

		for (int i = 1; i < ltasten.length; i++) {
			ltasten[i] = new JToggleButton();
		}

		for (int i = 1; i < rtasten.length; i++) {
			rtasten[i] = new JToggleButton();
		}

	}

	/**
	 * 
	 * Faerbt erst alle Butons weiss und dann bestimmte Buttons schwarz.
	 * Konfiguriert Buttons(kein Rand)
	 * 
	 * @param rtasten
	 *            []
	 * @param ltasten
	 *            []
	 * 
	 */

	public static void buttonsKonfig(JToggleButton rtasten[], JToggleButton ltasten[]) {

		for (int i = 1; i < ltasten.length; i++) {
			ltasten[i].setBackground(Color.white);
			ltasten[i].setBorderPainted(false);
		}

		for (int i = 1; i < rtasten.length; i++) {
			rtasten[i].setBackground(Color.white);
			rtasten[i].setBorderPainted(false);
		}

		ltasten[2].setBackground(Color.BLACK);
		ltasten[3].setBackground(Color.BLACK);
		ltasten[5].setBackground(Color.BLACK);
		ltasten[6].setBackground(Color.BLACK);
		ltasten[9].setBackground(Color.BLACK);
		ltasten[10].setBackground(Color.BLACK);
		ltasten[12].setBackground(Color.BLACK);
		ltasten[13].setBackground(Color.BLACK);
		ltasten[15].setBackground(Color.BLACK);
		ltasten[16].setBackground(Color.BLACK);
		ltasten[19].setBackground(Color.BLACK);
		ltasten[20].setBackground(Color.BLACK);
		ltasten[22].setBackground(Color.BLACK);
		ltasten[23].setBackground(Color.BLACK);
		ltasten[26].setBackground(Color.BLACK);
		ltasten[27].setBackground(Color.BLACK);
		ltasten[29].setBackground(Color.BLACK);
		ltasten[30].setBackground(Color.BLACK);
		ltasten[32].setBackground(Color.BLACK);
		ltasten[33].setBackground(Color.BLACK);
		ltasten[36].setBackground(Color.BLACK);
		ltasten[37].setBackground(Color.BLACK);
		ltasten[39].setBackground(Color.BLACK);
		ltasten[40].setBackground(Color.BLACK);
		ltasten[43].setBackground(Color.BLACK);
		ltasten[44].setBackground(Color.BLACK);
		ltasten[46].setBackground(Color.BLACK);
		ltasten[47].setBackground(Color.BLACK);
		ltasten[49].setBackground(Color.BLACK);
		ltasten[50].setBackground(Color.BLACK);
		ltasten[53].setBackground(Color.BLACK);
		ltasten[54].setBackground(Color.BLACK);
		ltasten[56].setBackground(Color.BLACK);
		ltasten[57].setBackground(Color.BLACK);
		ltasten[60].setBackground(Color.BLACK);
		ltasten[61].setBackground(Color.BLACK);
		ltasten[63].setBackground(Color.BLACK);
		ltasten[64].setBackground(Color.BLACK);
		ltasten[66].setBackground(Color.BLACK);
		ltasten[67].setBackground(Color.BLACK);

		rtasten[2].setBackground(Color.BLACK);
		rtasten[3].setBackground(Color.BLACK);
		rtasten[5].setBackground(Color.BLACK);
		rtasten[6].setBackground(Color.BLACK);
		rtasten[9].setBackground(Color.BLACK);
		rtasten[10].setBackground(Color.BLACK);
		rtasten[12].setBackground(Color.BLACK);
		rtasten[13].setBackground(Color.BLACK);
		rtasten[15].setBackground(Color.BLACK);
		rtasten[16].setBackground(Color.BLACK);
		rtasten[19].setBackground(Color.BLACK);
		rtasten[20].setBackground(Color.BLACK);
		rtasten[22].setBackground(Color.BLACK);
		rtasten[23].setBackground(Color.BLACK);
		rtasten[26].setBackground(Color.BLACK);
		rtasten[27].setBackground(Color.BLACK);
		rtasten[29].setBackground(Color.BLACK);
		rtasten[30].setBackground(Color.BLACK);
		rtasten[32].setBackground(Color.BLACK);
		rtasten[33].setBackground(Color.BLACK);
		rtasten[36].setBackground(Color.BLACK);
		rtasten[37].setBackground(Color.BLACK);
		rtasten[39].setBackground(Color.BLACK);
		rtasten[40].setBackground(Color.BLACK);
		rtasten[43].setBackground(Color.BLACK);
		rtasten[44].setBackground(Color.BLACK);
		rtasten[46].setBackground(Color.BLACK);
		rtasten[47].setBackground(Color.BLACK);
		rtasten[49].setBackground(Color.BLACK);
		rtasten[50].setBackground(Color.BLACK);
		rtasten[53].setBackground(Color.BLACK);
		rtasten[54].setBackground(Color.BLACK);
		rtasten[56].setBackground(Color.BLACK);
		rtasten[57].setBackground(Color.BLACK);
		rtasten[60].setBackground(Color.BLACK);
		rtasten[61].setBackground(Color.BLACK);
		rtasten[63].setBackground(Color.BLACK);
		rtasten[64].setBackground(Color.BLACK);
		rtasten[66].setBackground(Color.BLACK);
		rtasten[67].setBackground(Color.BLACK);

	}

	/**
	 * Gibt zu einem Zeichen einer Taste den Integer Wert zurück
	 * 
	 * @author Emanuel
	 * @param {@link KeyEvent} e
	 * @return {@link Integer}
	 * @throws KeyException
	 */

	public static int getIntVonKey(KeyEvent e) throws KeyException {

		switch ((int)e.getKeyChar()) {
		case (int) '<':
			return 0;
		case (int) 'a':
			return 1;
		case (int) 'y':
			return 2;
		case (int) 's':
			return 3;
		case (int) 'x':
			return 4;
		case (int) 'c':
			return 5;
		case (int) 'f':
			return 6;
		case (int) 'v':
			return 7;
		case (int) 'g':
			return 8;
		case (int) 'b':
			return 9;
		case (int) 'h':
			return 10;
		case (int) 'n':
			return 11;
		case (int) 't':
			return 12;
		case (int) '6':
			return 13;
		case (int) 'z':
			return 14;
		case (int) '7':
			return 15;
		case (int) 'u':
			return 16;
		case (int) 'i':
			return 17;
		case (int) '9':
			return 18;
		case (int) 'o':
			return 19;
		case (int) '0':
			return 20;
		case (int) 'p':
			return 21;
		case (int) '�':
			return 22;
		case (int) '�':
			return 23;
		default:
			return 25;
		}

	}
	
	

}
