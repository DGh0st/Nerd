/**
 * KeysImagePanel 04/03/2017
 * Deep Patel
 * KeysImagePanel class that is used to display images.
 */

import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;

public class KeysImagePanel extends JPanel {
	private BufferedImage selectedImage;
	private BufferedImage regular, up, left, down, right;
	private int counter;
	private Position playerPixelPosition;

	public KeysImagePanel(BufferedImage regular, BufferedImage up, BufferedImage left, BufferedImage down, BufferedImage right) {
		super();

		if (regular != null) {
			selectedImage = regular;
		} else if (up != null) {
			selectedImage = up;
		} else if (left != null) {
			selectedImage = left;
		} else if (down != null) {
			selectedImage = down;
		} else if (right != null) {
			selectedImage = right;
		}

		if (selectedImage != null) {
			this.setPreferredSize(new Dimension(selectedImage.getWidth() + 256, selectedImage.getHeight()));
		}

		this.regular = regular;
		this.up = up;
		this.left = left;
		this.down = down;
		this.right = right;

		this.counter = 0;

		this.setOpaque(false);

		playerPixelPosition = new Position(selectedImage.getWidth() + 128, selectedImage.getHeight() - 64 - 8);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(Assets.getInstance().getSprite(0), playerPixelPosition.getX(), playerPixelPosition.getY(), this);
		super.paintComponent(g);
		g.drawImage(selectedImage, 0, 0, this);
		counter++;

		if (counter == 5) {
			if (selectedImage == up) {
				playerPixelPosition.setY(playerPixelPosition.getY() - 64);
			} else if (selectedImage == left) {
				playerPixelPosition.setX(playerPixelPosition.getX() - 64);
			} else if (selectedImage == down) {
				playerPixelPosition.setY(playerPixelPosition.getY() + 64);
			} else if (selectedImage == right) {
				playerPixelPosition.setX(playerPixelPosition.getX() + 64);
			}
			return;
		} else if (counter < 20) {
			return;
		} else {
			counter = 0;
		}

		if (selectedImage == regular) {
			selectedImage = up;
		} else if (selectedImage == up) {
			selectedImage = left;
		} else if (selectedImage == left) {
			selectedImage = down;
		} else if (selectedImage == down) {
			selectedImage = right;
		} else {
			selectedImage = regular;
		}
	}
}