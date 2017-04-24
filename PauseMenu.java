/**
 * Nerd 03/11/2017
 * Deep Patel
 * PauseMenu class that is used to display the menu on game pause.
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

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

		String buttonTitles[] = {"Resume", "Restart", "Main Menu"};
		String buttonCommands[] = {"resumeGame", "restartGame", "mainMenu"};
		BufferedImage regularButtonImage = AllMenuAssets.getInstance().getSprite(1);
		BufferedImage destructiveButtonImage = AllMenuAssets.getInstance().getSprite(2);
		BufferedImage hoverButtonImage = AllMenuAssets.getInstance().getSprite(0);
		BufferedImage destructiveHoverButtonImage = AllMenuAssets.getInstance().getSprite(3);

		for (int i = 0; i < buttonTitles.length; i++) {
			pauseScreen.add(Box.createRigidArea(new Dimension(windowSize.width, 20)));

			BufferedImage image = regularButtonImage;
			BufferedImage hoverImage = hoverButtonImage;
			if (i == buttonTitles.length - 1) {
				image = destructiveButtonImage;
				hoverImage = destructiveHoverButtonImage;
			}

			HoverButton hb = createHoverButton(buttonTitles[i], buttonCommands[i], buttonFont, image, hoverImage);
   			hb.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
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
		}
  	}

  	@Override
  	protected void paintComponent(Graphics g) {
  		super.paintComponent(g);
  		LocationArray.getInstance().getCurrentLocation().draw(g);
  		g.setColor(new Color(0, 0, 0, 170));
  		g.fillRect(0, 0, NerdGame.windowSize.width, NerdGame.windowSize.height);
  	}
}