/**
 * Nerd 04/03/2017
 * Deep Patel
 * MainMenu class that is used to display the menu on game start.
 * TODO: Add more characters and settings
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.image.BufferedImage;
import java.net.*;

public class MainMenu extends Menu implements ChangeListener {
  // TODO: Add more characters
 private static final BufferedImage characters[] = {new Weaboo(1 , 1).getImage(), new Prophet(1, 1).getImage()};
 private static final String charactersCommands[] = {"0", "1"};
 private static final Class charactersClasses[] = {Weaboo.class, Prophet.class};

 private JPanel mainScreen;
 private JPanel shopScreen;
 private JPanel settingsScreen;
 private String selectedCharacter;
 private HoverButton selectedCharacterButton;
 private BufferedImage backgroundImage;

 public MainMenu() {
  super();

  selectedCharacter = charactersCommands[0];
  selectedCharacterButton = null;

  setupMainScreen(NerdGame.windowSize);

  backgroundImage = ImageLoader.loadImage("./resources/menus/MainMenuBackground.png");

  this.add(mainScreen);
 }

 @Override
 protected void paintComponent(Graphics g) {
  super.paintComponent(g);

  g.drawImage(backgroundImage, 0, 0, null);
  if (mainScreen.getParent() == null) {
    g.setColor(new Color(25, 25, 25, 150));
    g.fillRect(15, 15,  NerdGame.windowSize.width - 30, NerdGame.windowSize.height - 30);
  }
 }

 private void setupMainScreen(Dimension windowSize) {
  mainScreen = createScreen(windowSize, new FlowLayout(FlowLayout.LEFT));

  Font titleFont = new Font(Font.SERIF, Font.PLAIN, 128);
  Font buttonFont = new Font(Font.SERIF, Font.PLAIN, 48);

  JLabel title = createLabel("Nerd", titleFont);
  title.setForeground(new Color(25, 25, 25, 200));
  mainScreen.add(Box.createRigidArea(new Dimension(windowSize.width - title.getPreferredSize().width * 5 / 4, 0)));
  mainScreen.add(title);

  String buttonTitles[] = {"Start", "Shop", "Settings", "Exit"};
  String buttonCommands[] = {"startGame", "shopMenu", "settingsMenu", "closeGame"};
  BufferedImage regularButtonImage = MainMenuAssets.getInstance().getSprite(7);
  BufferedImage destructiveButtonImage = MainMenuAssets.getInstance().getSprite(8);
  BufferedImage hoverButtonImage = MainMenuAssets.getInstance().getSprite(6);
  BufferedImage destructiveHoverButtonImage = MainMenuAssets.getInstance().getSprite(5);

  for (int i = 0; i < buttonTitles.length; i++) {
   mainScreen.add(Box.createRigidArea(new Dimension(windowSize.width, 20)));

   BufferedImage image = regularButtonImage;
   BufferedImage hoverImage = hoverButtonImage;
   if (i == buttonTitles.length - 1) {
    image = destructiveButtonImage;
    hoverImage = destructiveHoverButtonImage;
   }

   HoverButton hb = createHoverButton(buttonTitles[i], buttonCommands[i], buttonFont, image, hoverImage);
   hb.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
   hb.setShouldCenter(false);
   hb.setForeground(new Color(25, 25, 25, 200));
   mainScreen.add(hb);
  }
 }

 private void setupShopScreen(Dimension windowSize) {
  shopScreen = createScreen(windowSize, new FlowLayout(FlowLayout.LEFT));

  Font characterFont = new Font(Font.SERIF, Font.PLAIN, 24);

  addHeader(shopScreen, "Nerd Shop", "mainFromShop", windowSize);

  addSubHeader(shopScreen, "Characters:", windowSize);

  shopScreen.add(Box.createRigidArea(new Dimension(40, 20)));

  BufferedImage regularButtonImage = MainMenuAssets.getInstance().getSprite(2);
  BufferedImage hoverButtonImage = MainMenuAssets.getInstance().getSprite(3);
  BufferedImage selectedButtonImage = MainMenuAssets.getInstance().getSprite(4);
  Graphics g2 = selectedButtonImage.getGraphics();
  Font font = new Font(Font.SERIF, Font.PLAIN, 16);
  g2.setFont(font);
  int length = g2.getFontMetrics(font).stringWidth("Selected");
  g2.drawString("Selected", selectedButtonImage.getWidth() / 2 - length / 2, 24);

  for (int i = 0; i < characters.length; i++) {
    BufferedImage character = new BufferedImage(characters[i].getWidth(), characters[i].getHeight(), characters[i].getType());
    Graphics g = character.getGraphics();
    g.drawImage(characters[i], 0, 0, null);
    if (selectedCharacter.equals(charactersCommands[i])) {
      g.drawImage(selectedButtonImage, 0, 0, null);
    } else {
      g.drawImage(regularButtonImage, 0, 0, null);
    }
    g.dispose();

    shopScreen.add(Box.createRigidArea(new Dimension(20, 20)));

    HoverButton characterButton = createHoverButton("", charactersCommands[i], characterFont, character, hoverButtonImage);

    if (selectedCharacter.equals(charactersCommands[i])) {
      selectedCharacterButton = characterButton;
    }

    characterButton.setShouldCenter(true);
    characterButton.setPreferredSize(new Dimension(character.getWidth(), character.getHeight()));

    shopScreen.add(characterButton);
  }
 }

 private void setupSettingsScreen(Dimension windowSize) {
  settingsScreen = createScreen(windowSize, new FlowLayout(FlowLayout.LEFT));

  addHeader(settingsScreen, "Settings", "mainFromSet", windowSize);

  addSubHeader(settingsScreen, "Volume:", windowSize);

  settingsScreen.add(Box.createRigidArea(new Dimension(40, 20)));

  JSlider volumeControlSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 25);
  volumeControlSlider.addChangeListener(this);
  volumeControlSlider.setPreferredSize(new Dimension(windowSize.width - 100, 40));
  volumeControlSlider.setOpaque(false);
  settingsScreen.add(volumeControlSlider);

  settingsScreen.add(Box.createRigidArea(new Dimension(windowSize.width, 20)));

  // TODO: Add more settings
 }

 private void addHeader(JPanel panel, String displayTitle, String backButtonCommand, Dimension windowSize) {
  Font titleFont = new Font(Font.SERIF, Font.PLAIN, 80);
  Font buttonFont = new Font(Font.SERIF, Font.PLAIN, 32);
  Font backFont = new Font(Font.SERIF, Font.PLAIN, 16);

  panel.add(Box.createRigidArea(new Dimension(20, 20)));

  BufferedImage image = MainMenuAssets.getInstance().getSprite(0);
  BufferedImage hoverImage = MainMenuAssets.getInstance().getSprite(1);
  HoverButton backButton = createHoverButton("", backButtonCommand, backFont, image, hoverImage);
  backButton.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
  panel.add(backButton);

  JLabel title = createLabel(displayTitle, titleFont);

  panel.add(Box.createRigidArea(new Dimension(windowSize.width / 2 - (int)(title.getPreferredSize().getWidth() / 2) - (int)(backButton.getPreferredSize().getWidth()) - 20, 20)));

  panel.add(title);

  panel.add(Box.createRigidArea(new Dimension(windowSize.width / 2 - (int)(title.getPreferredSize().getWidth() / 2) - (int)(backButton.getPreferredSize().getWidth()), 20)));
 }

 private void addSubHeader(JPanel panel, String displayTitle, Dimension windowSize) {
  Font titleFont = new Font(Font.SERIF, Font.PLAIN, 56);

  JLabel title = createLabel(displayTitle, titleFont);

  panel.add(Box.createRigidArea(new Dimension(40, 20)));

  panel.add(title);

  panel.add(Box.createRigidArea(new Dimension(windowSize.width, 20)));
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
  } else if (selectedCharacter != event.getActionCommand()) {
   int i = Integer.parseInt(selectedCharacter);
   BufferedImage normalCharacter = new BufferedImage(characters[i].getWidth(), characters[i].getHeight(), characters[i].getType());
   Graphics g = normalCharacter.getGraphics();
   g.drawImage(characters[i], 0, 0, null);
   g.drawImage(MainMenuAssets.getInstance().getSprite(2), 0, 0, null);
   g.dispose();

   i = Integer.parseInt(event.getActionCommand());
   BufferedImage selectCharacter = new BufferedImage(characters[i].getWidth(), characters[i].getHeight(), characters[i].getType());
   Graphics g2 = selectCharacter.getGraphics();
   g2.drawImage(characters[i], 0, 0, null);
   g2.drawImage(MainMenuAssets.getInstance().getSprite(4), 0, 0, null);
   g2.dispose();

   selectedCharacterButton.setImage(normalCharacter);
   selectedCharacterButton.repaint();
   selectedCharacter = event.getActionCommand();
   selectedCharacterButton = (HoverButton)event.getSource();
   selectedCharacterButton.setImage(selectCharacter);
   selectedCharacterButton.repaint();

   GameState.getInstance().setSelectedCharacterClass(charactersClasses[i]);
  }
 }

 public void stateChanged(ChangeEvent event) {
  DisplayState.getInstance().setBackgroundMusicVolume(((JSlider)event.getSource()).getValue() / 100.0f);
 }

 private void changeScreen(JPanel fromScreen, JPanel toScreen) {
  this.remove(fromScreen);
  clear(Color.black);
  this.add(toScreen);
  this.paintComponents(this.getGraphics());
 }
}
