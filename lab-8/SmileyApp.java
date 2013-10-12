/*
 * SmileyApp.java
 *
 * Lag en smiley, weeeeee!
 *
 * fuckflux
 */

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Window extends JFrame {
	final int		WIDTH = 500;
	final int		HEIGHT = 500;

	public Window(String title) {
		setTitle(title);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Drawing drawing = new Drawing();
		add(drawing);
	}
}

class Drawing extends JPanel {
	public void paintComponent(Graphics graphicsContext) {
		super.paintComponent(graphicsContext);
		setBackground(Color.YELLOW);
		setForeground(Color.BLACK);
		graphicsContext.drawOval(0, 0, getWidth(), getHeight());
		graphicsContext.fillOval(150, 100, getWidth()/12, getHeight()/12);
		graphicsContext.fillOval(290, 100, getWidth()/12, getHeight()/12);
		graphicsContext.fillArc(120, 150, getWidth()/2, getHeight()/2, 0, -180);

	}
}

public class SmileyApp {
	public static void main(String[] args) {
		Window window = new Window("Smiley");
		window.setVisible(true);
	}
}