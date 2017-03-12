/**
 * Nerd 03/04/2017
 * Deep Patel
 * DisplayState class that handles drawing and updating of scene/display.
 * TODO:
 *  - Add Menus
 */

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class HoverButton extends JButton {
	private BufferedImage regularImage;
	private BufferedImage hoverImage;
	private BufferedImage pressedImage;

	public HoverButton() {
		hoverImage = null;
		pressedImage = null;
	}

	public HoverButton(String title, String path) {
		super(title);
		setupButtonAttributes();
		regularImage =  ImageLoader.loadImage(path);
		hoverImage = regularImage;
		pressedImage = regularImage;
	}

	public HoverButton(String title, String regularImagePath, String hoverImagePath) {
		super(title);
		setupButtonAttributes();
		regularImage = ImageLoader.loadImage(regularImagePath);
		hoverImage =  ImageLoader.loadImage(hoverImagePath);
		pressedImage = hoverImage;
	}

	private void setupButtonAttributes() {
		this.setFocusable(false);
		this.setBorderPainted(false);
		this.setRolloverEnabled(true);
		this.setHorizontalAlignment(SwingConstants.LEFT);
		this.setContentAreaFilled(false);
		this.setForeground(Color.white);
	}

	@Override
	public void paintComponent(Graphics g) {
		if (getModel().isPressed()) {
			g.drawImage(pressedImage, 0, 0, null);
		} else if (getModel().isRollover()) {
			g.drawImage(hoverImage, 0, 0, null);
		} else {
			g.drawImage(regularImage, 0, 0, null);
		}
		super.paintComponent(g);
	}

	public BufferedImage getHoverImage() {
		return hoverImage;
	}

	public void setHoverImage(BufferedImage image) {
		hoverImage = image;
	}

	public BufferedImage getPressedImage() {
		return pressedImage;
	}

	public void setPressedImage(BufferedImage image) {
		pressedImage = image;
	}
}