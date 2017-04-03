/**
 * Nerd 04/03/2017
 * Deep Patel
 * NerdGame class which instantiates and displays a window.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NerdGame extends JFrame {
 private static NerdGame instance = null;
 private static DisplayState currentDisplayState;

 public final static Dimension windowSize = new Dimension(Tile.TILE_WIDTH*22,Tile.TILE_HEIGHT*12);

 public static void main(String[] args) {
  NerdGame gameWindow = getInstance();

  while (currentDisplayState.getCurrentDisplayStatus() != DisplayStatus.CLOSE) {
   currentDisplayState.updateCurrentDisplayStatus();
   currentDisplayState.drawCurrentDisplayStatus();
  }

  gameWindow.close();
 }

 private NerdGame() {
  currentDisplayState = DisplayState.getInstance();
  this.add(currentDisplayState);

  createWindow();

  currentDisplayState.startBackgroundMusic();
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

 public void close() {
  currentDisplayState.stopBackgroundMusic();
  this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
 }
}
