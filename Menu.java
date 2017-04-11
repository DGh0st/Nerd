/**
 * Nerd 03/11/2017
 * Deep Patel
 * Menu Abstract class that is used to display various menus.
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public abstract class Menu extends JPanel implements ActionListener {

	public Menu() {
		this.setPreferredSize(NerdGame.windowSize);
		this.setSize(NerdGame.windowSize);

		FlowLayout layout = (FlowLayout)getLayout();
		layout.setVgap(0);
	}

	@Override
  	public abstract void actionPerformed(ActionEvent event);

	public abstract void update();

	public void draw() {
		addCurrentCanvasIfNeeded();
		this.requestFocus();
		this.repaint();
	}

	protected void addCurrentCanvasIfNeeded() {
		DisplayState currentDisplayState = DisplayState.getInstance();
		if (this.getParent() == null || this.getParent() != currentDisplayState) {
			currentDisplayState.add(this);
			this.paintComponents(this.getGraphics());
		}
	}

	protected void removeCurrentCanvasIfNeeded() {
		DisplayState currentDisplayState = DisplayState.getInstance();
		if (this.getParent() != null && this.getParent() == currentDisplayState) {
			currentDisplayState.remove(this);
		}
	}

	protected HoverButton createHoverButton(String title, String actionCommand, Font font, BufferedImage regularButtonImage, BufferedImage hoverButtonImage) {
		HoverButton hb = new HoverButton(title, regularButtonImage, hoverButtonImage);
		hb.addActionListener(this);
		hb.setActionCommand(actionCommand);
		hb.setFont(font);
		return hb;
	}

	protected JLabel createLabel(String title, Font font) {
		JLabel label = new JLabel(title);
		label.setForeground(Color.white);
		label.setFont(font);
		return label;
	}

	protected JPanel createScreen(Dimension windowSize, FlowLayout layout) {
		JPanel screen = new JPanel(layout);
		screen.setBackground(Color.black);
		screen.setPreferredSize(windowSize);
		screen.setSize(windowSize);
		return screen;
	}

	protected void clear(Color color) {
		Graphics g = getGraphics();
		Dimension canvasSize = getSize();
		if (g != null) {
			g.setColor(color);
			g.fillRect(0, 0, (int)canvasSize.getWidth(), (int)canvasSize.getHeight());
		}
	}
}