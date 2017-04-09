/**
 * Nerd 03/12/2017
 * Deep Patel
 * LoseMenu class that is used to display the menu on lose.
 * TODO: Add Lose Pose
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

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

		String buttonTitles[] = {"Restart", "Main Menu"};
		String buttonCommands[] = {"restartGame", "mainMenu"};
		BufferedImage regularButtonImage = AllMenuAssets.getInstance().getSprite(1);
		BufferedImage destructiveButtonImage = AllMenuAssets.getInstance().getSprite(2);
		BufferedImage hoverButtonImage = AllMenuAssets.getInstance().getSprite(0);
		BufferedImage destructiveHoverButtonImage = AllMenuAssets.getInstance().getSprite(3);

		for (int i = 0; i < buttonTitles.length; i++) {
			loseScreen.add(Box.createRigidArea(new Dimension(windowSize.width, 20)));

			BufferedImage image = regularButtonImage;
			BufferedImage hoverImage = hoverButtonImage;
			if (i == buttonTitles.length - 1) {
				image = destructiveButtonImage;
				hoverImage = destructiveHoverButtonImage;
			}

			HoverButton hb = createHoverButton(buttonTitles[i], buttonCommands[i], buttonFont, image, hoverImage);
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
			GameState.getInstance().start();
			DisplayState.getInstance().setCurrentDisplayStatus(DisplayStatus.INGAME);
			super.removeCurrentCanvasIfNeeded();
		} else if (event.getActionCommand().equals("mainMenu")) {
			DisplayState.getInstance().setCurrentDisplayStatus(DisplayStatus.STARTMENU);
			super.removeCurrentCanvasIfNeeded();
		}
  	}
}