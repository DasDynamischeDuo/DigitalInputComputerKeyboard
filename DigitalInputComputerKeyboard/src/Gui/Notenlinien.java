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
    private BufferedImage notenlinien;
    private JLabel lNotenschl;
    private JLabel[] lNotenlinien = new JLabel[15];
    
    
    
    /**
     * Konstruktor der Notenlinien Klasse
     * @author Fabian
     */
    
    public Notenlinien() {
		// TODO Auto-generated constructor stub
	}
    
    
    /**
     * Erzeugt einen Notenschlüssel und leere Notenlinien
     * @param g
     */
    
    public void NotenlinienSchluesselSetzenLeer(Gui g) {
        
    	
    	
    	try {
    		notenschluessel = ImageIO.read(getClass().getResource("/Images/notenschluessel.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    	try {
    		notenlinien = ImageIO.read(getClass().getResource("/Images/NotenLeer.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	for (int i = 0; i < lNotenlinien.length; i++) {
    		lNotenlinien[i] = new JLabel(new ImageIcon(notenlinien));
		}
    	
    	
    	
    	lNotenschl = new JLabel(new ImageIcon(notenschluessel));
    	g.notenpane.add(lNotenschl);
    	
    	for (int i = 0; i < lNotenlinien.length; i++) {
			g.notenpane.add(lNotenlinien[i]);
			
		}
    	
    	
    	
    }
    
    
    /**
     * Ersetzt das Bild der Leeren NotenLinie durch das bild der gespielten Note auf den Notenlinien.
     * @author Fabian
     * @param i
     */
    protected void BilderSetzen(int i){
    	
    	switch (i) {
		case 1:
			System.out.println("test");
		try {
    		notenlinien = ImageIO.read(getClass().getResource("/Images/Noten/mittleresC.png"));
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		lNotenlinien[14] = new JLabel(new ImageIcon(notenlinien));
		for (int j = 0; j < lNotenlinien.length; j++) {
			
			
		}
		
			break;

		default:
			break;
		}
    	
    }
    
    
    /**
     * Ersetzt die einzelnen Bilder der Notenlinien in einem bestimmten abstand durch das vorherige
     * @author Fabian
     */
    
    
    protected void NotenLinienLaufen(Gui g){
    	for (int i = 0; i < lNotenlinien.length; i++) {
    		if (i==lNotenlinien.length-1) {
				
    			try {
    	    		notenlinien = ImageIO.read(getClass().getResource("/Images/NotenLeer.png"));
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			break;
			}
			lNotenlinien[i] = lNotenlinien[i+1];		
			
			
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }

    
    /**
     * Zeichnet Bilder auf die Oberfläche
     * @author Fabian
     */
    
    @Override
    protected void paintComponent(Graphics g) {

      super.paintComponent(g);
          g.drawImage(notenlinien, 0, 0, null);
          g.drawImage(notenschluessel, 0, 0, null);
  }
   
}
