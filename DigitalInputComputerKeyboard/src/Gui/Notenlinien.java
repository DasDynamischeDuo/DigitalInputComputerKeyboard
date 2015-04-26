package Gui;

import java.awt.Graphics;
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

    private BufferedImage image;
    private JLabel lNotenschl;

    public Notenlinien(Gui g) {
       
    	try {
    		image = ImageIO.read(getClass().getResource("/Images/notenschluessel.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	lNotenschl = new JLabel(new ImageIcon(image));
    	g.notenpane.add(lNotenschl);
    	
    }

   
}
