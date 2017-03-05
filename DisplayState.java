/**
 * Nerd 03/04/2017
 * Deep Patel
 * DisplayState class that handles drawing and updating of scene/display.
 * TODO:
 *  - Add GameState
 *  - Add Menus
 */

import javax.swing.*;

public class DisplayState {
	private static DisplayState instance = null;
	private DisplayStatus currentDisplayStatus;
	private GameState gameCanvas;

	private DisplayState() {
		currentDisplayStatus = DisplayStatus.STARTMENU;
		gameCanvas = GameState.getInstance();
	}

	public static synchronized DisplayState getInstance() {
		if (instance == null) {
			instance = new DisplayState();
		}
		return instance;
	}

	public DisplayStatus getCurrentDisplayStatus() {
		return currentDisplayStatus;
	}

	public void setCurrentDisplayStatus(DisplayStatus newDisplayStatus) {
		currentDisplayStatus = newDisplayStatus;
	}

	public void updateCurrentDisplayStatus() {
		switch (currentDisplayStatus) {
			case STARTMENU:
				break;
			case INGAME:
				gameCanvas.update();
				break;
			case PAUSEMENU:
				break;
			case VICTORYMENU:
				// TODO: update animation state
				break;
			case LOSEMENU:
				break;
			case CLOSE:
				break;
			default:
				break;
		}
	}

	public void drawCurrentDisplayStatus() {
		NerdGame gameWindow = NerdGame.getInstance();
		switch (currentDisplayStatus) {
			case STARTMENU:
				// TODO: display start menu which includes title, shop and settings screens
				break;
			case INGAME:
				if (gameCanvas.getParent() == null) {
					gameWindow.add(gameCanvas);
				}
				gameCanvas.draw();
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
				break;
			default:
				break;
		}
	}
}