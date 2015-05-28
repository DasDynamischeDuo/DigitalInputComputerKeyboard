package Gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

class GlassPane extends JPanel {
	Gui g;
	private Image[] beschreibungNoten = new Image[14];

	public GlassPane(Gui g) {
		this.g = g;
		beschreibungsArrayfuellen();

		

		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
		this.revalidate();

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent m) {

			}

			@Override
			public void mousePressed(MouseEvent m) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent m) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent m) {
			
			}

			@Override
			public void mouseClicked(MouseEvent m) {

				System.out.println(m.getPoint());
				if (m.getY() > 360) {

					
				} else {
					
					redispatchMouseEvent(m);
				}

			}
		});

		setFocusTraversalKeysEnabled(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, getSize().width, getSize().height);
		ImageObserver m =  new ImageObserver() {
			
			@Override
			public boolean imageUpdate(Image img, int infoflags, int x, int y,
					int width, int height) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		int xWert1 = 15;
		int xWert2 = 45;
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < 7; i++) {
				g.drawImage(beschreibungNoten[i], xWert1, 515, null,m);
				xWert1=xWert1+70;
			}
			xWert1=515;
			
			for (int i = 7; i < beschreibungNoten.length; i++) {
				
				
				g.drawImage(beschreibungNoten[i], xWert2, 445, null,m);
				xWert2=xWert2+80;
				if (xWert2==125) {
					i++;
					g.drawImage(beschreibungNoten[i], xWert2, 445, null,m);
					xWert2=245;
				}
				if (xWert2==615) {
					i++;
					g.drawImage(beschreibungNoten[i], xWert2, 445, null,m);
					xWert2=735;
					
				}
			}
			xWert2=535;
		}
		
		 
		
		
       
    }
	
	

	private void redispatchMouseEvent(MouseEvent e) {
		Point glassPanePoint = e.getPoint();
		Container container = g.getContentPane();
		Point containerPoint = SwingUtilities.convertPoint(this,
				glassPanePoint, g.getContentPane());
		if (containerPoint.y < 0) { // we're not in the content pane
			Component component = SwingUtilities.getDeepestComponentAt(
					container, containerPoint.x, containerPoint.y);
			Point componentPoint = SwingUtilities.convertPoint(
                    this, glassPanePoint, component);
            component.dispatchEvent(new MouseEvent(component, e
                    .getID(), e.getWhen(), e.getModifiers(),
                    componentPoint.x, componentPoint.y, e
                            .getClickCount(), e.isPopupTrigger()));
			
			
		} else {
			// The mouse event is probably over the content pane.
			// Find out exactly which component it's over.
			Component component = SwingUtilities.getDeepestComponentAt(
					container, containerPoint.x, containerPoint.y);

			
			if ((component != null) && (component.equals(g.rbDrum))) {
				g.rbDrum.doClick();
			}
			if ((component != null) && (component.equals(g.rbPiano))) {
				g.rbPiano.doClick();
			}
			if ((component != null) && (component.equals(g.rbEigenes))) {
				g.rbEigenes.doClick();
			}
			
		}
	}

	private void beschreibungsArrayfuellen() {

		try {
			beschreibungNoten[0] = ImageIO.read(getClass().getResource("/Images/BeschreibungNoten/C.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			beschreibungNoten[1] = ImageIO.read(getClass().getResource("/Images/BeschreibungNoten/D.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			beschreibungNoten[2] = ImageIO.read(getClass().getResource("/Images/BeschreibungNoten/E.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			beschreibungNoten[3] = ImageIO.read(getClass().getResource("/Images/BeschreibungNoten/F.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			beschreibungNoten[4] = ImageIO.read(getClass().getResource("/Images/BeschreibungNoten/G.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			beschreibungNoten[5] = ImageIO.read(getClass().getResource("/Images/BeschreibungNoten/A.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			beschreibungNoten[6] = ImageIO.read(getClass().getResource("/Images/BeschreibungNoten/H.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			beschreibungNoten[7] = ImageIO.read(getClass().getResource("/Images/BeschreibungNoten/cis.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			beschreibungNoten[8] = ImageIO.read(getClass().getResource("/Images/BeschreibungNoten/dis.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			beschreibungNoten[9] = ImageIO.read(getClass().getResource("/Images/BeschreibungNoten/fis.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			beschreibungNoten[10] = ImageIO.read(getClass().getResource("/Images/BeschreibungNoten/gis.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			beschreibungNoten[11] = ImageIO.read(getClass().getResource("/Images/BeschreibungNoten/ais.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
