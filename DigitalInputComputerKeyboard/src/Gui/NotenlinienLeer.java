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

public class NotenlinienLeer extends JPanel{

    private BufferedImage notenschluessel;
    private BufferedImage notenlinien;
    private JLabel lNotenschl;
    private JLabel[] lNotenlinien = new JLabel[14];

    public NotenlinienLeer(Gui g) {
       
    	
    	
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

    @Override
    protected void paintComponent(Graphics g) {

      super.paintComponent(g);
          g.drawImage(notenlinien, 0, 0, null);
          g.drawImage(notenschluessel, 0, 0, null);
  }
   
}
