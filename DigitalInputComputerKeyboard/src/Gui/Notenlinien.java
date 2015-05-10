package Gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.SliderUI;

public class Notenlinien extends JPanel{

	
	
    private BufferedImage notenschluessel;
    private BufferedImage[] Noten = new BufferedImage[50];
    private JLabel lNotenBild;
    
    private JLabel lNotenschl;
    private JLabel[] lNotenlinien = new JLabel[15];
    
    
    Gui g;
    
    
    
    /**
     * Konstruktor der Notenlinien Klasse.
     * Baut Notenlinien uns Schlüssel.
     * @author Fabian
     */
    
    public Notenlinien(Gui g) {
    	
    	this.g = g;
    	NotenArrayFuellen();
    	
    	
    	
    	for (int i = 0; i < lNotenlinien.length; i++) {
    		lNotenlinien[i] = new JLabel(new ImageIcon(Noten[0]));
		}
    	
    	
    	
    	lNotenschl = new JLabel(new ImageIcon(notenschluessel));
    	
    	
	}
    
    
    /**
     * Fügt Notenschlüssel und Notenlinien der Gui hinzu.
     * @author Fabian
     */
    
    public void NotenlinienSchluesselSetzenLeer() {
        
    	g.notenpane.add(lNotenschl);
    	for (int i = 0; i < lNotenlinien.length; i++) {
			g.notenpane.add(lNotenlinien[i]);
			
		}
    }
    
    /**
     * Zeichnet Bilder auf die Oberfläche
     * @author Fabian
     */
    
    @Override
    protected void paintComponent(Graphics g) {

      super.paintComponent(g);
      for (int i = 0; i < Noten.length; i++) {
    	  g.drawImage(Noten[i], 0, 0, null);
	}
         
          g.drawImage(notenschluessel, 0, 0, null);
  }

/**
 * Löscht das erste Bild der Notenlinien und fügt das der gespielten Note am ende hinzu.
 * @author Fabian
 * @param intVonKey
 */
	public void zeichneNote(int intVonKey) {
		
		switch (intVonKey) {
		
		case 0:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[2]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 1:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[3]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 2:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[4]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 3:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[5]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 4:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[6]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 5:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[7]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 6:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[8]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 7:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[9]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 8:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[10]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 9:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[11]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 10:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[12]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 11:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[13]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 12:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[14]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 13:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[15]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 14:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[16]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 15:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[17]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 16:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[18]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 17:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[19]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 18:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[20]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 19:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[21]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 20:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[22]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 21:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[23]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
		case 22:			
			try {
				lNotenBild = new JLabel(new ImageIcon (Noten[24]));
			} catch (Exception e) {
				// TODO: handle exception
			}
				g.notenpane.remove(1);
				g.notenpane.add(lNotenBild);			
			g.revalidate();
			break;
			
			
			

		default:
			break;
		}
		
	}
	
	/**
	 * Bilder werden einem Array zugewiesen. Jede Note hat seinen Platz.
	 * @author Fabian
	 */
	
	public void NotenArrayFuellen() {
		
		try {
    		notenschluessel = ImageIO.read(getClass().getResource("/Images/notenschluessel.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
    		Noten[0] = ImageIO.read(getClass().getResource("/Images/NotenLeer.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
    		Noten[1] = ImageIO.read(getClass().getResource("/Images/Noten/1unteresH.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		Noten[2] = ImageIO.read(getClass().getResource("/Images/Noten/2unteresC.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		//Noten[3] = ImageIO.read(getClass().getResource());// Hier Cis
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		Noten[4] = ImageIO.read(getClass().getResource("/Images/Noten/3unteresD.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		//Noten[5] = ImageIO.read(getClass().getResource());// Hier Dis
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		Noten[6] = ImageIO.read(getClass().getResource("/Images/Noten/4unteresE.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		Noten[7] = ImageIO.read(getClass().getResource("/Images/Noten/5unteresF.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		//Noten[8] = ImageIO.read(getClass().getResource());// Hier Fis
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		Noten[9] = ImageIO.read(getClass().getResource("/Images/Noten/6unteresG.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		//Noten[10] = ImageIO.read(getClass().getResource());// Hier Gis
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		Noten[11] = ImageIO.read(getClass().getResource("/Images/Noten/7unteresA.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		//Noten[12] = ImageIO.read(getClass().getResource());// Hier Ais
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		Noten[13] = ImageIO.read(getClass().getResource("/Images/Noten/8mittleresH.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		Noten[14] = ImageIO.read(getClass().getResource("/Images/Noten/9mittleresC.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}		
		try {
    		//Noten[15] = ImageIO.read(getClass().getResource());// Hier Cis
		} catch (Exception e) {
			e.printStackTrace();
		}		
		try {
    		Noten[16] = ImageIO.read(getClass().getResource("/Images/Noten/10mittleresD.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		//Noten[17] = ImageIO.read(getClass().getResource());// Hier Dis
		} catch (Exception e) {
			e.printStackTrace();
		}		
		try {
    		Noten[18] = ImageIO.read(getClass().getResource("/Images/Noten/11mittleresE.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		Noten[19] = ImageIO.read(getClass().getResource("/Images/Noten/12mittleresF.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		//Noten[20] = ImageIO.read(getClass().getResource());// Hier Fis
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		Noten[21] = ImageIO.read(getClass().getResource("/Images/Noten/13mittleresG.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		//Noten[22] = ImageIO.read(getClass().getResource());// Hier Gis
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		Noten[23] = ImageIO.read(getClass().getResource("/Images/Noten/14mittleresA.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		//Noten[24] = ImageIO.read(getClass().getResource());// Hier Ais
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
    		Noten[25] = ImageIO.read(getClass().getResource("/Images/Noten/15oberesH.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void NotenlinienLaufen() {
		
	
	
		
	}
   
}
