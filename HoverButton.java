/**
 * Nerd 03/12/2017
 * Deep Patel
 * HoverButton class that is used to make custom hoverable JButtons.
 */

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class HoverButton extends JButton {
	private BufferedImage regularImage;
	private BufferedImage hoverImage;
	private BufferedImage pressedImage;
	private boolean shouldCenter;

	public HoverButton() {
		super("");
		hoverImage = null;
		pressedImage = null;
		hoverImage = null;
		shouldCenter = true;
	}

	public HoverButton(String title) {
		super(title);
		setupButtonAttributes();
		regularImage =  null;
		hoverImage = null;
		pressedImage = null;
		shouldCenter = true;
	}

	public HoverButton(String title, String path) {
		super(title);
		setupButtonAttributes();
		regularImage =  ImageLoader.loadImage(path);
		hoverImage = regularImage;
		pressedImage = regularImage;
		shouldCenter = true;
	}

	public HoverButton(String title, String regularImagePath, String hoverImagePath) {
		super(title);
		setupButtonAttributes();
		regularImage = ImageLoader.loadImage(regularImagePath);
		hoverImage =  ImageLoader.loadImage(hoverImagePath);
		pressedImage = hoverImage;
		shouldCenter = true;
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
		super.repaint();
		int width = (int)this.getPreferredSize().getWidth();
		if (getModel().isPressed()) {
			if (shouldCenter) {
				g.drawImage(pressedImage, width / 2 - pressedImage.getWidth() / 2, 0, null);
			} else {
				g.drawImage(pressedImage, 0, 0, null);
			}
		} else if (getModel().isRollover()) {
			if (shouldCenter) {
				g.drawImage(hoverImage, width / 2 - hoverImage.getWidth() / 2, 0, null);
			} else {
				g.drawImage(hoverImage, 0, 0, null);
			}
		} else {
			if (shouldCenter) {
				g.drawImage(regularImage, width / 2 - regularImage.getWidth() / 2, 0, null);
			} else {
				g.drawImage(regularImage, 0, 0, null);
			}
		}
		super.paintComponent(g);
	}

	public BufferedImage getImage() {
		return regularImage;
	}

	public void setImage(BufferedImage image) {
		regularImage = image;
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

	public void setShouldCenter(boolean center) {
		shouldCenter = center;
	}

	public boolean getShouldCenter() {
		return shouldCenter;
	}
}