package Gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

class GlassPane extends JPanel {
	Gui g;
	private JLabel[] beschreibungNoten = new JLabel[12];

	public GlassPane(Gui g) {
		this.g = g;
		beschreibungsArrayfuellen();

		this.add(beschreibungNoten[0]);

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
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent m) {

				System.out.println(m.getPoint());
				if (m.getY() > 360) {

					System.out.println("Y");
				} else {
					System.out.println("N");
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
	}

	private void redispatchMouseEvent(MouseEvent e) {
		Point glassPanePoint = e.getPoint();
		Container container = g.getContentPane();
		Point containerPoint = SwingUtilities.convertPoint(this,
				glassPanePoint, g.getContentPane());
		if (containerPoint.y < 0) { // we're not in the content pane
		} else {
			// The mouse event is probably over the content pane.
			// Find out exactly which component it's over.
			Component component = SwingUtilities.getDeepestComponentAt(
					container, containerPoint.x, containerPoint.y);

			if ((component != null) && (component.equals(g.bAufnehmen))) {
				g.bAufnehmen.doClick();
			}
			if ((component != null) && (component.equals(g.bPlay))) {
				g.bPlay.doClick();
			}
			if ((component != null) && (component.equals(g.bStop))) {
				g.bStop.doClick();
			}
			if ((component != null) && (component.equals(g.rbDrum))) {
				g.rbDrum.doClick();
			}
			if ((component != null) && (component.equals(g.rbPiano))) {
				g.rbPiano.doClick();
			}
		}
	}

	private void beschreibungsArrayfuellen() {

		beschreibungNoten[0] = new JLabel(new ImageIcon("/Images/C.png"));

	}
}
