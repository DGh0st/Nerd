/**
 * Nerd 03/12/2017
 * Deep Patel
 * LoseMenu class that is used to display the menu on lose.
 * TODO: Add Lose Pose and implement restart game
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class LoseMenu extends Menu {
	private JPanel loseScreen;

	public LoseMenu() {
		super();

		setupLoseScreen(NerdGame.windowSize);

		this.add(loseScreen);
	}

	private void setupLoseScreen(Dimension windowSize) {
		loseScreen = createScreen(windowSize, new FlowLayout());

		Font titleFont = new Font(Font.SERIF, Font.PLAIN, 128);
		Font buttonFont = new Font(Font.SERIF, Font.PLAIN, 48);

		JLabel title = createLabel("Game Over!", titleFont);
		loseScreen.add(title);

		loseScreen.add(Box.createRigidArea(new Dimension(windowSize.width, 20)));

		// TODO: Add Lose Pose

		String buttonTitles[] = {"Restart", "Main Menu", "Exit Game"};
		String buttonCommands[] = {"restartGame", "mainMenu", "closeGame"};
		String regularButtonPath = "./resources/menus/pauseButton.png";
		String hoverButtonPath = "./resources/menus/hoverPauseButton.png";

		for (int i = 0; i < 3; i++) {
			loseScreen.add(Box.createRigidArea(new Dimension(windowSize.width, 20)));

			HoverButton hb = createHoverButton(buttonTitles[i], buttonCommands[i], buttonFont, regularButtonPath, hoverButtonPath);
			hb.setPreferredSize(new Dimension(windowSize.width / 2, hb.getPreferredSize().height));
			hb.setHorizontalAlignment(SwingConstants.CENTER);
			loseScreen.add(hb);
		}
	}

	public void update() {
		// Nothing additional to update as of yet...
	}

  	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("restartGame")) {
			// TODO: restart game
		} else if (event.getActionCommand().equals("mainMenu")) {
			DisplayState.getInstance().setCurrentDisplayStatus(DisplayStatus.STARTMENU);
			super.removeCurrentCanvasIfNeeded();
		} else if (event.getActionCommand().equals("closeGame")) {
			NerdGame.getInstance().close();
		}
  	}
}