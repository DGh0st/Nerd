/**
 * Nerd 03/05/2017
 * Deep Patel
 * DisplayState class that handles drawing and updating of scene/display.
 * TODO:
 *  - Add Character for player
 *  - Add CollisionEvent for collisionChecker
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

import javax.swing.*;

public class GameState extends JPanel {
	private static GameState instance = null;
	private LocationArray locations;

	private GameState() {
		this.setBackground(Color.black);
		// TODO: set locations to LocationArray singleton
	}

	public static synchronized GameState getInstance() {
		if (instance == null) {
			instance = new GameState();
		}
		return instance;
	}

	public void update() {
		// update current location and check collisions with movable objects
	}

	public void draw() {
		clear(Color.black);
		// draw current location and character
	}

	private void clear(Color color) {
		Graphics g = getGraphics();
		Dimension canvasSize = getSize();
		if (g != null) {
			g.setColor(color);
			g.fillRect(0, 0, (int)canvasSize.getWidth(), (int)canvasSize.getHeight());
		}
	}
}