/**
 * Nerd 02/24/2017
 * Deep Patel
 * NerdGame class which instantiates and displays a window.
 */

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class NerdGame extends JFrame {
	private static NerdGame instance = null;
	private static DisplayState currentDisplayState;

	private final static Dimension windowSize = new Dimension(1024, 768);

	public static void main(String[] args) {
		NerdGame game = getInstance();
		currentDisplayState.setCurrentDisplayStatus(DisplayStatus.INGAME); // For testing in game related stuff

		while (currentDisplayState.getCurrentDisplayStatus() != DisplayStatus.CLOSE) {
			currentDisplayState.updateCurrentDisplayStatus();
			currentDisplayState.drawCurrentDisplayStatus();
		}

		game.close();
	}

	private NerdGame() {
		createWindow();

		currentDisplayState = DisplayState.getInstance();
	}

	public static synchronized NerdGame getInstance() {
		if (instance == null) {
			instance = new NerdGame();
		}
		return instance;
	}

	private void createWindow() {
		this.setTitle("Nerd");
		this.setSize(windowSize);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
