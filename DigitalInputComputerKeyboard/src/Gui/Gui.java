package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.KeyException;
import java.security.acl.LastOwnerException;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class Gui extends JFrame {

	JLabel label1,label2;
	JPanel contentpane; 
	JPanel notenpane, buttonpane, tastenpane;
		JPanel lklav,rklav;
			JPanel lgrid,rgrid;
				
				
	JToggleButton[] rtasten = new JToggleButton[103];//Buttonanzahlt einfuegen
	JToggleButton[] ltasten = new JToggleButton[103];
				
				
	 public Gui(){
				 
		 initalisierenallg();
		 buttonsinitialisieren(rtasten, ltasten);
		 buttonskonfig(rtasten, ltasten);
		 
		 buttonszusammenfg();
		 
		 
		 
		 
		 contentpane.setLayout(new GridLayout(3,1));
		 tastenpane.setLayout(new GridLayout(1,2));
		 
		 lklav.setLayout(new BorderLayout());
		 rklav.setLayout(new BorderLayout());
		 
		 lgrid.setLayout(new GridLayout(6,17));
		 rgrid.setLayout(new GridLayout(6,17));
		 
		 for (int i = 1; i < ltasten.length; i++) {
			lgrid.add(ltasten[i]);
		}
				
		 for (int i = 1; i < rtasten.length; i++) {
			rgrid.add(rtasten[i]);
		}
		
		 rgrid.setFocusable(true);
		 lgrid.setFocusable(true);
		 lklav.add(lgrid);
		 rklav.add(rgrid);
		 
		 
		 notenpane.add(label1);
		 buttonpane.add(label2);
		 
		 tastenpane.add(lklav);
		 tastenpane.add(rklav);
		 
		 contentpane.add(notenpane);
		 contentpane.add(buttonpane);
		 contentpane.add(tastenpane);
		 
		 this.setContentPane(contentpane);
		 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	private void buttonszusammenfg() {
		lgrid.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				int i = getIntvonKey(e);
				releaseButtons(i);
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				int i = getIntvonKey(e);
				drueckeButtons(i);
				
			}

			
			
			
		});
	}

	protected void releaseButtons(int i) {
switch (i) {
		
		case 60:
			
			for (int j = 1; j < 88; j = j+17) {
				ltasten[j].setSelected(false);;
				if (j==69|j==86) {
					ltasten[j+1].setSelected(false);
				}
				
			}
			break;
			
		case 61:
			
			int z = 2;
			ltasten[2].setSelected(false);
			
			for (int j = 0; j < 3 ; j++) {
				z++;
				ltasten[z].setSelected(false);
				z = z+16;
				ltasten[z].setSelected(false);
				}
			ltasten[54].setSelected(false);	
			
			break;
			
			
		case 62:
			
			for (int j = 4; j < 91; j=j+17) {
				ltasten[j].setSelected(false);
				if (j==72|j==89) {
					ltasten[j-1].setSelected(false);
					ltasten[j].setSelected(false);
					ltasten[j+1].setSelected(false);
				}
			}
			
			break;
			
		case 63:
			
			int z2 = 5;
			ltasten[5].setSelected(false);
			
			for (int j = 0; j < 3 ; j++) {
				z2++;
				ltasten[z2].setSelected(false);
				z2 = z2+16;
				ltasten[z2].setSelected(false);
				}
			ltasten[57].setSelected(false);	
			
			break;
			
		case 64:
			
			for (int j = 7; j < 93; j=j+17) {
				ltasten[j].setSelected(false);
				if (j==75|j==92) {
					ltasten[j-1].setSelected(false);
				}
			}			
			
			break;
			
			
		case 65:
			
			for (int j = 8; j < 95; j = j+17) {
				ltasten[j].setSelected(false);;
				if (j==76|j==93) {
					ltasten[j+1].setSelected(false);
				}
				
			}
			
			break;
			
		case 66:
			
			int z3 = 9;
			ltasten[9].setSelected(false);
			
			for (int j = 0; j < 3 ; j++) {
				z3++;
				ltasten[z3].setSelected(false);
				z3 = z3+16;
				ltasten[z3].setSelected(false);
				}
			ltasten[61].setSelected(false);	
			
			break;
			
		case 67:
			
			for (int j = 11; j < 98; j=j+17) {
				ltasten[j].setSelected(false);
				if (j==79|j==96) {
					ltasten[j-1].setSelected(false);
					ltasten[j].setSelected(false);
					ltasten[j+1].setSelected(false);
				}
			}
			
			break;
			
		case 68:
			
			int z4 = 12;
			ltasten[12].setSelected(false);
			
			for (int j = 0; j < 3 ; j++) {
				z4++;
				ltasten[z4].setSelected(false);
				z4 = z4+16;
				ltasten[z4].setSelected(false);
				}
			ltasten[64].setSelected(false);	
			
			break;

		case 69:
			
			for (int j = 14; j < 101; j=j+17) {
				ltasten[j].setSelected(false);
				if (j==82|j==99) {
					ltasten[j-1].setSelected(false);
					ltasten[j].setSelected(false);
					ltasten[j+1].setSelected(false);
				}
			}
			
			break;
			
		case 70:
			
			int z5 = 15;
			ltasten[15].setSelected(false);
			
			for (int j = 0; j < 3 ; j++) {
				z5++;
				ltasten[z5].setSelected(false);
				z5 = z5+16;
				ltasten[z5].setSelected(false);
				}
			ltasten[67].setSelected(false);	
			
			break;
			
		case 71:
			
			for (int j = 17; j < 103; j=j+17) {
				ltasten[j].setSelected(false);
				if (j==85|j==102) {
					ltasten[j-1].setSelected(false);
				}
			}			
			
			break;
			
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		case 74:
			
			for (int j = 1; j < 88; j = j+17) {
				rtasten[j].setSelected(false);;
				if (j==69|j==86) {
					rtasten[j+1].setSelected(false);
				}
				
			}
			break;
			
		case 75:
			
			int z6 = 2;
			rtasten[2].setSelected(false);
			
			for (int j = 0; j < 3 ; j++) {
				z6++;
				rtasten[z6].setSelected(false);
				z6 = z6+16;
				rtasten[z6].setSelected(false);
				}
			rtasten[54].setSelected(false);	
			
			break;
			
			
		case 76:
			
			for (int j = 4; j < 91; j=j+17) {
				rtasten[j].setSelected(false);
				if (j==72|j==89) {
					rtasten[j-1].setSelected(false);
					rtasten[j].setSelected(false);
					rtasten[j+1].setSelected(false);
				}
			}
			
			break;
			
		case 77:
			
			int z7 = 5;
			rtasten[5].setSelected(false);
			
			for (int j = 0; j < 3 ; j++) {
				z7++;
				rtasten[z7].setSelected(false);
				z7 = z7+16;
				rtasten[z7].setSelected(false);
				}
			rtasten[57].setSelected(false);	
			
			break;
			
		case 78:
			
			for (int j = 7; j < 93; j=j+17) {
				rtasten[j].setSelected(false);
				if (j==75|j==92) {
					rtasten[j-1].setSelected(false);
				}
			}			
			
			break;
			
			
		case 79:
			
			for (int j = 8; j < 95; j = j+17) {
				rtasten[j].setSelected(false);;
				if (j==76|j==93) {
					rtasten[j+1].setSelected(false);
				}
				
			}
			
			break;
			
		case 80:
			
			int z8 = 9;
			rtasten[9].setSelected(false);
			
			for (int j = 0; j < 3 ; j++) {
				z8++;
				rtasten[z8].setSelected(false);
				z8 = z8+16;
				rtasten[z8].setSelected(false);
				}
			rtasten[61].setSelected(false);	
			
			break;
			
		case 81:
			
			for (int j = 11; j < 98; j=j+17) {
				rtasten[j].setSelected(false);
				if (j==79|j==96) {
					rtasten[j-1].setSelected(false);
					rtasten[j].setSelected(false);
					rtasten[j+1].setSelected(false);
				}
			}
			
			break;
			
		case 82:
			
			int z9 = 12;
			rtasten[12].setSelected(false);
			
			for (int j = 0; j < 3 ; j++) {
				z9++;
				rtasten[z9].setSelected(false);
				z9 = z9+16;
				rtasten[z9].setSelected(false);
				}
			rtasten[64].setSelected(false);	
			
			break;

		case 83:
			
			for (int j = 14; j < 101; j=j+17) {
				rtasten[j].setSelected(false);
				if (j==82|j==99) {
					rtasten[j-1].setSelected(false);
					rtasten[j].setSelected(false);
					rtasten[j+1].setSelected(false);
				}
			}
			
			break;
			
		case 84:
			
			int z10 = 15;
			rtasten[15].setSelected(false);
			
			for (int j = 0; j < 3 ; j++) {
				z10++;
				rtasten[z10].setSelected(false);
				z10 = z10+16;
				rtasten[z10].setSelected(false);
				}
			rtasten[67].setSelected(false);	
			
			break;
			
		case 85:
			
			for (int j = 17; j < 103; j=j+17) {
				rtasten[j].setSelected(false);
				if (j==85|j==102) {
					rtasten[j-1].setSelected(false);
				}
			}			
			
			break;
			
			
			
			
		default:
			break;
		}
	
		
	}

	private void drueckeButtons(int i) {
		
		switch (i) {
		
		case 60:
			
			for (int j = 1; j < 88; j = j+17) {
				ltasten[j].setSelected(true);;
				if (j==69|j==86) {
					ltasten[j+1].setSelected(true);
				}
				
			}
			break;
			
		case 61:
			
			int z = 2;
			ltasten[2].setSelected(true);
			
			for (int j = 0; j < 3 ; j++) {
				z++;
				ltasten[z].setSelected(true);
				z = z+16;
				ltasten[z].setSelected(true);
				}
			ltasten[54].setSelected(true);	
			
			break;
			
			
		case 62:
			
			for (int j = 4; j < 91; j=j+17) {
				ltasten[j].setSelected(true);
				if (j==72|j==89) {
					ltasten[j-1].setSelected(true);
					ltasten[j].setSelected(true);
					ltasten[j+1].setSelected(true);
				}
			}
			
			break;
<<<<<<< HEAD
			
			
=======
>>>>>>> branch 'master' of https://github.com/DasDynamischeDuo/DigitalInputComputerKeyboard.git
			
		case 63:
			
			int z2 = 5;
			ltasten[5].setSelected(true);
			
			for (int j = 0; j < 3 ; j++) {
				z2++;
				ltasten[z2].setSelected(true);
				z2 = z2+16;
				ltasten[z2].setSelected(true);
				}
			ltasten[57].setSelected(true);	
			
			break;
			
		case 64:
			
			for (int j = 7; j < 93; j=j+17) {
				ltasten[j].setSelected(true);
				if (j==75|j==92) {
					ltasten[j-1].setSelected(true);
				}
			}			
			
			break;
			
			
		case 65:
			
			for (int j = 8; j < 95; j = j+17) {
				ltasten[j].setSelected(true);;
				if (j==76|j==93) {
					ltasten[j+1].setSelected(true);
				}
				
			}
			
			break;
			
		case 66:
			
			int z3 = 9;
			ltasten[9].setSelected(true);
			
			for (int j = 0; j < 3 ; j++) {
				z3++;
				ltasten[z3].setSelected(true);
				z3 = z3+16;
				ltasten[z3].setSelected(true);
				}
			ltasten[61].setSelected(true);	
			
			break;
			
		case 67:
			
			for (int j = 11; j < 98; j=j+17) {
				ltasten[j].setSelected(true);
				if (j==79|j==96) {
					ltasten[j-1].setSelected(true);
					ltasten[j].setSelected(true);
					ltasten[j+1].setSelected(true);
				}
			}
			
			break;
			
		case 68:
			
			int z4 = 12;
			ltasten[12].setSelected(true);
			
			for (int j = 0; j < 3 ; j++) {
				z4++;
				ltasten[z4].setSelected(true);
				z4 = z4+16;
				ltasten[z4].setSelected(true);
				}
			ltasten[64].setSelected(true);	
			
			break;

		case 69:
			
			for (int j = 14; j < 101; j=j+17) {
				ltasten[j].setSelected(true);
				if (j==82|j==99) {
					ltasten[j-1].setSelected(true);
					ltasten[j].setSelected(true);
					ltasten[j+1].setSelected(true);
				}
			}
			
			break;
			
		case 70:
			
			int z5 = 15;
			ltasten[15].setSelected(true);
			
			for (int j = 0; j < 3 ; j++) {
				z5++;
				ltasten[z5].setSelected(true);
				z5 = z5+16;
				ltasten[z5].setSelected(true);
				}
			ltasten[67].setSelected(true);	
			
			break;
			
		case 71:
			
			for (int j = 17; j < 103; j=j+17) {
				ltasten[j].setSelected(true);
				if (j==85|j==102) {
					ltasten[j-1].setSelected(true);
				}
			}			
			
			break;
			
			
			//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
			
			
		case 74:
			
			for (int j = 1; j < 88; j = j+17) {
				rtasten[j].setSelected(true);;
				if (j==69|j==86) {
					rtasten[j+1].setSelected(true);
				}
				
			}
			break;
			
		case 75:
			
			int z6 = 2;
			rtasten[2].setSelected(true);
			
			for (int j = 0; j < 3 ; j++) {
				z6++;
				rtasten[z6].setSelected(true);
				z6 = z6+16;
				rtasten[z6].setSelected(true);
				}
			rtasten[54].setSelected(true);	
			
			break;
			
			
		case 76:
			
			for (int j = 4; j < 91; j=j+17) {
				rtasten[j].setSelected(true);
				if (j==72|j==89) {
					rtasten[j-1].setSelected(true);
					rtasten[j].setSelected(true);
					rtasten[j+1].setSelected(true);
				}
			}
			
			break;
			
		case 77:
			
			int z7 = 5;
			rtasten[5].setSelected(true);
			
			for (int j = 0; j < 3 ; j++) {
				z7++;
				rtasten[z7].setSelected(true);
				z7 = z7+16;
				rtasten[z7].setSelected(true);
				}
			rtasten[57].setSelected(true);	
			
			break;
			
		case 78:
			
			for (int j = 7; j < 93; j=j+17) {
				rtasten[j].setSelected(true);
				if (j==75|j==92) {
					rtasten[j-1].setSelected(true);
				}
			}			
			
			break;
			
			
		case 79:
			
			for (int j = 8; j < 95; j = j+17) {
				rtasten[j].setSelected(true);;
				if (j==76|j==93) {
					rtasten[j+1].setSelected(true);
				}
				
			}
			
			break;
			
		case 80:
			
			int z8 = 9;
			rtasten[9].setSelected(true);
			
			for (int j = 0; j < 3 ; j++) {
				z8++;
				rtasten[z8].setSelected(true);
				z8 = z8+16;
				rtasten[z8].setSelected(true);
				}
			rtasten[61].setSelected(true);	
			
			break;
			
		case 81:
			
			for (int j = 11; j < 98; j=j+17) {
				rtasten[j].setSelected(true);
				if (j==79|j==96) {
					rtasten[j-1].setSelected(true);
					rtasten[j].setSelected(true);
					rtasten[j+1].setSelected(true);
				}
			}
			
			break;
			
		case 82:
			
			int z9 = 12;
			rtasten[12].setSelected(true);
			
			for (int j = 0; j < 3 ; j++) {
				z9++;
				rtasten[z9].setSelected(true);
				z9 = z9+16;
				rtasten[z9].setSelected(true);
				}
			rtasten[64].setSelected(true);	
			
			break;

		case 83:
			
			for (int j = 14; j < 101; j=j+17) {
				rtasten[j].setSelected(true);
				if (j==82|j==99) {
					rtasten[j-1].setSelected(true);
					rtasten[j].setSelected(true);
					rtasten[j+1].setSelected(true);
				}
			}
			
			break;
			
		case 84:
			
			int z10 = 15;
			rtasten[15].setSelected(true);
			
			for (int j = 0; j < 3 ; j++) {
				z10++;
				rtasten[z10].setSelected(true);
				z10 = z10+16;
				rtasten[z10].setSelected(true);
				}
			rtasten[67].setSelected(true);	
			
			break;
			
		case 85:
			
			for (int j = 17; j < 103; j=j+17) {
				rtasten[j].setSelected(true);
				if (j==85|j==102) {
					rtasten[j-1].setSelected(true);
				}
			}			
			
			break;
			
			
			
		default:
			break;
		}
	}
	

	private int getIntvonKey(KeyEvent e) {
		
		switch (e.getKeyChar()) {
		case '<':
			return 60;
		case 'a':
			return 61;
		case 'y':
			return 62;
		case 's':
			return 63;
		case 'x':
			return 64;
		case 'c':
			return 65;
		case 'f':
			return 66;
		case 'v':
			return 67;
		case 'g':
			return 68;
		case 'b':
			return 69;
		case 'h':
			return 70;
		case 'n':
			return 71;
		case 'j':
			return 72;
		case 'm':
			return 73;
		case 't':
			return 74;
		case '6':
			return 75;
		case 'z':
			return 76;
		case '7':
			return 77;
		case 'u':
			return 78;
		case 'i':
			return 79;
		case '9':
			return 80;
		case 'o':
			return 81;
		case '0':
			return 82;
		case 'p':
			return 83;
		case 'ß':
			return 84;
		case 'ü':
			return 85;
		case '+':
			return 86;
		default:
			return 87;
		}
		
	}

	private void initalisierenallg() {
		
		label1 = new JLabel("Noten");
		label2 = new JLabel("Verschiedenes");
		
		notenpane = new JPanel();
		buttonpane = new JPanel();
		tastenpane = new JPanel();
		
		lklav = new JPanel();
		rklav = new JPanel();
		
		lgrid = new JPanel();
		rgrid = new JPanel();
		
		
		
		contentpane = new JPanel();
		
		
		
	}

	private void buttonsinitialisieren(JToggleButton rtasten[], JToggleButton ltasten[]  ) {
			
		for (int i = 1; i < ltasten.length; i++) {
			ltasten[i] = new JToggleButton();
		}
		
		for (int i = 1; i < rtasten.length; i++) {
			rtasten[i] = new JToggleButton();
		}
			
	}

	private void buttonskonfig(JToggleButton rtasten[], JToggleButton ltasten[]  ) {
		
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


	
	
	
	
	
}
