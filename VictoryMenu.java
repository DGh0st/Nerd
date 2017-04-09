/**
 * Nerd 03/12/2017
 * Deep Patel
 * VictoryMenu class that is used to display the menu on victory.
 * TODO: Add Victory Pose and change level
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class VictoryMenu extends Menu {
 private JPanel victoryScreen;

 public VictoryMenu() {
  super();

  setupVictoryScreen(NerdGame.windowSize);

  this.add(victoryScreen);
 }

 private void setupVictoryScreen(Dimension windowSize) {
  victoryScreen = createScreen(windowSize, new FlowLayout());

  Font titleFont = new Font(Font.SERIF, Font.PLAIN, 128);
  Font buttonFont = new Font(Font.SERIF, Font.PLAIN, 48);

  JLabel title = createLabel("Victory!", titleFont);
  victoryScreen.add(title);

  victoryScreen.add(Box.createRigidArea(new Dimension(windowSize.width, 20)));

  // TODO: Add Victory Pose

  String buttonTitles[] = {"Next Level", "Restart", "Main Menu"};
  String buttonCommands[] = {"nextLevel", "restartGame", "mainMenu"};
  BufferedImage regularButtonImage = AllMenuAssets.getInstance().getSprite(1);
  BufferedImage destructiveButtonImage = AllMenuAssets.getInstance().getSprite(2);
  BufferedImage hoverButtonImage = AllMenuAssets.getInstance().getSprite(0);
  BufferedImage destructiveHoverButtonImage = AllMenuAssets.getInstance().getSprite(3);

  for (int i = 0; i < buttonTitles.length; i++) {
   victoryScreen.add(Box.createRigidArea(new Dimension(windowSize.width, 20)));

   BufferedImage image = regularButtonImage;
   BufferedImage hoverImage = hoverButtonImage;
   if (i == buttonTitles.length - 1) {
    image = destructiveButtonImage;
    hoverImage = destructiveHoverButtonImage;
   }

   HoverButton hb = createHoverButton(buttonTitles[i], buttonCommands[i], buttonFont, image, hoverImage);
   hb.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
   hb.setHorizontalAlignment(SwingConstants.CENTER);
   victoryScreen.add(hb);
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
   } else if (event.getActionCommand().equals("nextLevel")) {
     LocationArray.getInstance().incrementCurrentLocation();
     GameState.getInstance().start();
     DisplayState.getInstance().setCurrentDisplayStatus(DisplayStatus.INGAME);
     super.removeCurrentCanvasIfNeeded();
   }
 }
}