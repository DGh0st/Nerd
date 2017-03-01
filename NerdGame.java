/**
 * Nerd 02/24/2017
 * Deep Patel
 * NerdGame class which handles displaying and updating of our game
 * TODO:
 *  - Add player
 *  - Add menus
 *  - Add game display
 */

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class NerdGame extends JFrame {
	private static DisplayStatus currentDisplayStatus;

	private final static Dimension windowSize = new Dimension(1024, 768);

	public enum DisplayStatus {
		STARTMENU,
		INGAME,
		PAUSEMENU,
		VICTORYMENU,
		LOSEMENU,
		CLOSE
	}

	public static void main(String[] args) {
		NerdGame game = new NerdGame(true);

		while (game.getCurrentDisplayStatus() != DisplayStatus.CLOSE) {
			game.handleCurrentDisplayStatus();
		}

		game.close();
	}

	public NerdGame() {
		initialize();
	}

	public NerdGame(boolean shouldCreateWindow) {
		initialize();

		if (shouldCreateWindow) {
			createWindow();
		}
	}

	private void initialize() {
		// TODO: add player, initialize location and add menus
		currentDisplayStatus = DisplayStatus.STARTMENU;		
	}

	private void createWindow() {
		this.setTitle("Nerd");
		this.setSize(windowSize);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void handleCurrentDisplayStatus() {
		switch (currentDisplayStatus) {
			case STARTMENU:
				// TODO: display start menu which includes title, shop and settings screens
				break;
			case INGAME:
				// TODO: update/display the game world with player
				break;
			case PAUSEMENU:
				// TODO: display pause menu overlay on top of the game
				break;
			case VICTORYMENU:
				// TODO: display victory menu
				break;
			case LOSEMENU:
				// TODO: display lose menu
				break;
			case CLOSE:
				close();
				break;
			default:
				break;
		}
	}

	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

	public DisplayStatus getCurrentDisplayStatus() {
		return currentDisplayStatus;
	}

	public void setCurrentDisplayStatus(DisplayStatus newDisplayStatus) {
		currentDisplayStatus = newDisplayStatus;
	}
}