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

public class Notenlinien extends JPanel{

    private BufferedImage notenschluessel;
    private BufferedImage notenlinien;
    private JLabel lNotenschl;
    private JPanel pNotenlinien;

    public Notenlinien(Gui g) {
       
    	pNotenlinien = new JPanel();
    	
    	try {
    		notenschluessel = ImageIO.read(getClass().getResource("/Images/notenschluessel.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	Image notenlinien = Toolkit.getDefaultToolkit().createImage("Background.png");
    	
    	lNotenschl = new JLabel(new ImageIcon(notenschluessel));
    	g.notenpane.add(lNotenschl);
    	
    	
    }

    @Override
    protected void paintComponent(Graphics g) {

      super.paintComponent(g);
          g.drawImage(notenlinien, 0, 0, null);
  }
   
}
