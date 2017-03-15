/**
 * Nerd 03/11/2017
 * Deep Patel
 * MainMenu class that is used to display the menu on game start.
 * TODO:
 *  - Add Shop
 *  - Add Settings
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MainMenu extends Menu {
	private JPanel mainScreen;
	private JPanel shopScreen;
	private JPanel settingsScreen;
	
	public MainMenu() {
		super();

		setupMainScreen(NerdGame.windowSize);

		this.add(mainScreen);
	}

	private void setupMainScreen(Dimension windowSize) {
		mainScreen = createScreen(windowSize, new FlowLayout(FlowLayout.LEFT));

		Font titleFont = new Font(Font.SERIF, Font.PLAIN, 128);
		Font buttonFont = new Font(Font.SERIF, Font.PLAIN, 48);

		mainScreen.add(Box.createRigidArea(new Dimension(windowSize.width * 5 / 7, 0)));

		JLabel title = createLabel("Nerd", titleFont);
		mainScreen.add(title);

		String buttonTitles[] = {"Start", "Shop", "Settings", "Exit"};
		String buttonCommands[] = {"startGame", "shopMenu", "settingsMenu", "closeGame"};
		String regularButtonPath = "./resources/menus/mainButton.png";
		String hoverButtonPath = "./resources/menus/hoverMainButton.png";

		for (int i = 0; i < 4; i++) {
			mainScreen.add(Box.createRigidArea(new Dimension(windowSize.width, 20)));

			HoverButton hb = createHoverButton(buttonTitles[i], buttonCommands[i], buttonFont, regularButtonPath, hoverButtonPath);
			hb.setPreferredSize(new Dimension(windowSize.width / 4, hb.getPreferredSize().height));
			mainScreen.add(hb);
		}
	}

	private void setupShopScreen(Dimension windowSize) {
		shopScreen = createScreen(windowSize, new FlowLayout());

		addHeader(shopScreen, "Nerd Shop", "mainFromShop", windowSize);

		// TODO: Add characters to buy

		// TODO: remove under construction
		Font constructionFont = new Font(Font.SERIF, Font.PLAIN, 32);
		JLabel underConstruction = createLabel("Under Construction", constructionFont);
		shopScreen.add(Box.createRigidArea(new Dimension(windowSize.width / 2 - (int)(underConstruction.getPreferredSize().getWidth() - 30), 20)));
		shopScreen.add(underConstruction);
		shopScreen.add(Box.createRigidArea(new Dimension(windowSize.width / 2 - (int)(underConstruction.getPreferredSize().getWidth() + 30), 20)));
	}

	private void setupSettingsScreen(Dimension windowSize) {
		settingsScreen = createScreen(windowSize, new FlowLayout());

		addHeader(settingsScreen, "Settings", "mainFromSet", windowSize);

		// TODO: Add settings

		// TODO: remove under construction
		Font constructionFont = new Font(Font.SERIF, Font.PLAIN, 32);
		JLabel underConstruction = createLabel("Under Construction", constructionFont);
		settingsScreen.add(Box.createRigidArea(new Dimension(windowSize.width / 2 - (int)(underConstruction.getPreferredSize().getWidth() - 30), 20)));
		settingsScreen.add(underConstruction);
		settingsScreen.add(Box.createRigidArea(new Dimension(windowSize.width / 2 - (int)(underConstruction.getPreferredSize().getWidth() + 30), 20)));
	}

	private void addHeader(JPanel panel, String displayTitle, String backButtonCommand, Dimension windowSize) {
		Font titleFont = new Font(Font.SERIF, Font.PLAIN, 80);
		Font buttonFont = new Font(Font.SERIF, Font.PLAIN, 32);
		Font backFont = new Font(Font.SERIF, Font.PLAIN, 16);

		HoverButton backButton = createHoverButton("", backButtonCommand, backFont, "./resources/menus/backButton.png", "./resources/menus/hoverBackButton.png");
		backButton.setPreferredSize(new Dimension(64, 64));
		panel.add(backButton);

		JLabel title = createLabel(displayTitle, titleFont);

		panel.add(Box.createRigidArea(new Dimension(windowSize.width / 2 - (int)(title.getPreferredSize().getWidth() / 2) - (int)(backButton.getPreferredSize().getWidth()), 20)));

		panel.add(title);

		panel.add(Box.createRigidArea(new Dimension(windowSize.width / 2 - (int)(title.getPreferredSize().getWidth() / 2) - (int)(backButton.getPreferredSize().getWidth()), 20)));
	}

	public void update() {
		// Nothing additional to update as of yet...
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("startGame")) {
			GameState.getInstance().start();
			DisplayState.getInstance().setCurrentDisplayStatus(DisplayStatus.INGAME);
			super.removeCurrentCanvasIfNeeded();
		} else if (event.getActionCommand().equals("shopMenu")) {
			if (shopScreen == null) {
				setupShopScreen(NerdGame.windowSize);
			}
			changeScreen(mainScreen, shopScreen);
		} else if (event.getActionCommand().equals("settingsMenu")) {
			if (settingsScreen == null) {
				setupSettingsScreen(NerdGame.windowSize);
			}
			changeScreen(mainScreen, settingsScreen);
		} else if (event.getActionCommand().equals("closeGame")) {
			NerdGame.getInstance().close();
		} else if (event.getActionCommand().equals("mainFromShop")) {
			changeScreen(shopScreen, mainScreen);
		} else if (event.getActionCommand().equals("mainFromSet")) {
			changeScreen(settingsScreen, mainScreen);
		}
	}

	private void changeScreen(JPanel fromScreen, JPanel toScreen) {
		this.remove(fromScreen);
		clear(Color.black);
		this.add(toScreen);
		this.paintComponents(this.getGraphics());
	}
}