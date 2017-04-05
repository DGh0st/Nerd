/**
 * Nerd 04/04/2017
 * Deep Patel
 * ObstacleState class that handles drawing obstacles.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

public class ObstacleState extends JPanel {
	private Character player = null;
	private LocationArray locations = null;

	public ObstacleState() {
		super();

		this.setPreferredSize(NerdGame.windowSize);
		this.setSize(NerdGame.windowSize);
		this.setFocusable(false);
		this.setOpaque(false);
	}

	public void draw(Character player, LocationArray locations) {
		this.player = player;
		this.locations = locations;
		this.paintComponent(getGraphics());
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.clearRect(0, 0, NerdGame.windowSize.width, NerdGame.windowSize.height);

		if (player != null) {
			player.draw(g);
		}

		if (locations != null) {
			for(MovableObstacle m : locations.getCurrentLocation().getMovableObstacles()){
				m.draw(g);
			}
		}

		g.dispose();
	}
}