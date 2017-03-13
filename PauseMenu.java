/**
 * Nerd 03/11/2017
 * Deep Patel
 * PauseMenu class that is used to display the menu on game pause.
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PauseMenu extends Menu implements KeyListener {
	private JPanel pauseScreen;

	public PauseMenu() {
		super();

		this.setFocusable(true);
		this.addKeyListener(this);

		setupPauseScreen(NerdGame.windowSize);

		this.add(pauseScreen);
	}

	private void setupPauseScreen(Dimension windowSize) {
		pauseScreen = createScreen(windowSize, new FlowLayout());

		Font titleFont = new Font(Font.SERIF, Font.PLAIN, 128);
		Font buttonFont = new Font(Font.SERIF, Font.PLAIN, 48);

		JLabel title = createLabel("Pause", titleFont);
		pauseScreen.add(title);

		pauseScreen.add(Box.createRigidArea(new Dimension(windowSize.width, 20)));

		String buttonTitles[] = {"Resume", "Restart", "Main Menu", "Exit Game"};
		String buttonCommands[] = {"resumeGame", "restartGame", "mainMenu", "closeGame"};
		String regularButtonPath = "./resources/menus/pauseButton.png";
		String hoverButtonPath = "./resources/menus/hoverPauseButton.png";

		for (int i = 0; i < 4; i++) {
			pauseScreen.add(Box.createRigidArea(new Dimension(windowSize.width, 20)));

			HoverButton hb = createHoverButton(buttonTitles[i], buttonCommands[i], buttonFont, regularButtonPath, hoverButtonPath);
			hb.setPreferredSize(new Dimension(windowSize.width / 2, hb.getPreferredSize().height));
			hb.setHorizontalAlignment(SwingConstants.CENTER);
			pauseScreen.add(hb);
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		// Nothing additional to do as of yet...
	}

	@Override
	public void keyReleased(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
			DisplayState.getInstance().setCurrentDisplayStatus(DisplayStatus.INGAME);
			super.removeCurrentCanvasIfNeeded();
		}
	}

	@Override
	public void keyTyped(KeyEvent event) {
		// Nothing additional to do as of yet...
	}

	public void update() {
		// Nothing additional to update as of yet...
	}

  	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("resumeGame")) {
			DisplayState.getInstance().setCurrentDisplayStatus(DisplayStatus.INGAME);
			super.removeCurrentCanvasIfNeeded();
		} else if (event.getActionCommand().equals("restartGame")) {
			GameState.getInstance().start();
			DisplayState.getInstance().setCurrentDisplayStatus(DisplayStatus.INGAME);
			super.removeCurrentCanvasIfNeeded();
		} else if (event.getActionCommand().equals("mainMenu")) {
			DisplayState.getInstance().setCurrentDisplayStatus(DisplayStatus.STARTMENU);
			super.removeCurrentCanvasIfNeeded();
		} else if (event.getActionCommand().equals("closeGame")) {
			NerdGame.getInstance().close();
		}
  	}
}