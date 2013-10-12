/*
 * SmileyApplet.java
 *
 * Lag en smiley, weeeeee!
 *
 * fuckflux
 */

import javax.swing.*;
import java.awt.*;

class Drawing extends JPanel {
	public void paintComponent(Graphics graphicsContext) {
		super.paintComponent(graphicsContext);
		setBackground(Color.YELLOW);
		setForeground(Color.BLACK);
		graphicsContext.drawOval(0, 0, 500, 500);
		graphicsContext.fillOval(150, 100, 500/12, 500/12);
		graphicsContext.fillOval(290, 100, 500/12, 500/12);
		graphicsContext.fillArc(120, 150, 500/2, 500/2, 0, -180);
	}
}

public class SmileyApplet extends JApplet {
	public void init() {
		add(new Drawing());
	}
}