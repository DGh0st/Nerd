/**
 * Nerd 03/05/2017
 * Deep Patel
 * DisplayState class that handles drawing and updating of scene/display.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameState extends JPanel implements KeyListener {
	private static GameState instance = null;
	private LocationArray locations;
	private CollisionEvent collisionChecker;
	// private Character player;

	private GameState() {
		collisionChecker = new CollisionEvent();
		// TODO: 
		//  - add CollisionListeners
		//  - set locations to LocationArray singleton
		//  - initialize player

		this.setBackground(Color.black);
		this.setPreferredSize(NerdGame.windowSize);
		this.setSize(NerdGame.windowSize);
		this.setFocusable(true);
		this.addKeyListener(this);

		FlowLayout layout = (FlowLayout)getLayout();
		layout.setVgap(0);
	}

	public static synchronized GameState getInstance() {
		if (instance == null) {
			instance = new GameState();
		}
		return instance;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		// Nothing additional to do as of yet...
	}

	@Override
	public void keyReleased(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
			DisplayState.getInstance().setCurrentDisplayStatus(DisplayStatus.PAUSEMENU);
			removeCurrentCanvasIfNeeded();
		}
	}

	@Override
	public void keyTyped(KeyEvent event) {
		// Nothing additional to do as of yet...
	}

	public void update() {
		// TODO: update current location and check collisions with movable objects
	}

	public void draw() {
		addCurrentCanvasIfNeeded();
		this.requestFocus();

		clear(Color.green);
		// TODO: draw current location and character
	}

	private void addCurrentCanvasIfNeeded() {
		if (this.getParent() == null) {
			DisplayState.getInstance().add(this);
		}
	}

	private void removeCurrentCanvasIfNeeded() {
		DisplayState currentDisplayState = DisplayState.getInstance();
		if (this.getParent() != null && this.getParent() == currentDisplayState) {
			currentDisplayState.remove(this);
		}
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