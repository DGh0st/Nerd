/**
 * Nerd 03/30/2017
 * Deep Patel
 * DisplayState class that handles drawing and updating of scene/display.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

public class GameState extends JPanel implements KeyListener, CollisionListener {
 private static GameState instance = null;
 private LocationArray locations;
 private CollisionEvent collisionChecker;
 private Character player;
 private Class selectedCharacterClass = Weaboo.class;
 private long lastCharacterMillis;
 private int lastKeyCode;

 private GameState() {
  super();

  locations = LocationArray.getInstance();
  Assets assets = Assets.getInstance(); //needs to be under locationArray (dependent)

  collisionChecker = new CollisionEvent();
  collisionChecker.addListener(this);

  this.setPreferredSize(NerdGame.windowSize);
  this.setSize(NerdGame.windowSize);
  this.setFocusable(true);
  this.addKeyListener(this);
 }

 public static synchronized GameState getInstance() {
  if (instance == null) {
   instance = new GameState();
  }
  return instance;
 }

 @Override
 public void keyPressed(KeyEvent event) {
  int keyCode = event.getKeyCode();
  long elapsedTime = System.currentTimeMillis() - lastCharacterMillis;
  if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
    if ((lastKeyCode == KeyEvent.VK_UP || lastKeyCode == KeyEvent.VK_W) && elapsedTime <= 150) {
      return;
    }
    lastCharacterMillis = System.currentTimeMillis();
    lastKeyCode = keyCode;
    player.moveUp();
  } else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
    if ((lastKeyCode == KeyEvent.VK_DOWN || lastKeyCode == KeyEvent.VK_S) && elapsedTime <= 150) {
      return;
    }
    lastCharacterMillis = System.currentTimeMillis();
    lastKeyCode = keyCode;
    player.moveDown();
  } else if (keyCode ==KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
    if ((lastKeyCode == KeyEvent.VK_LEFT || lastKeyCode == KeyEvent.VK_A) && elapsedTime <= 150) {
      return;
    }
    lastCharacterMillis = System.currentTimeMillis();
    lastKeyCode = keyCode;
    player.moveLeft();
  } else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
    if ((lastKeyCode == KeyEvent.VK_RIGHT || lastKeyCode == KeyEvent.VK_D) && elapsedTime <= 150) {
      return;
    }
    lastCharacterMillis = System.currentTimeMillis();
    lastKeyCode = keyCode;
    player.moveRight();
  }
 }

 @Override
 public void keyReleased(KeyEvent event) {
  if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
    DisplayState.getInstance().setCurrentDisplayStatus(DisplayStatus.PAUSEMENU);
    removeCurrentCanvasIfNeeded();
  }
 }

 @Override
 public void keyTyped(KeyEvent event) {
  // Nothing additional to do as of yet...
 }

 @Override
 public void collisionDetected() {
  DisplayState.getInstance().setCurrentDisplayStatus(DisplayStatus.LOSEMENU);
  removeCurrentCanvasIfNeeded();
 }

 public void victory() {
  DisplayState.getInstance().setCurrentDisplayStatus(DisplayStatus.VICTORYMENU);
  removeCurrentCanvasIfNeeded();
 }

 public void start() {
  locations.getCurrentLocation().initializeLocation(locations.getCurrentLocation().getPath());
  if (selectedCharacterClass == Weaboo.class) {
    player = new Weaboo(locations.getCurrentSpawnX(), locations.getCurrentSpawnY());
  } // TODO: Add more character classes
  collisionChecker.addListener(player);
  lastCharacterMillis = System.currentTimeMillis();
  lastKeyCode = KeyEvent.VK_ESCAPE;
 }

 public void setSelectedCharacterClass(Class newCharacterClass) {
  selectedCharacterClass = newCharacterClass;
 }

 public void update() {
  collisionChecker.checkCollision(player, locations.getMovableObstacles());
  locations.updateCurrentLocation();
 }

 public void draw() {
  addCurrentCanvasIfNeeded();
  this.requestFocus();

  locations.getCurrentLocation().drawPlayer(player);
  locations.drawCurrentLocation();
 }

 private void addCurrentCanvasIfNeeded() {
  if (this.getParent() == null) {
    DisplayState.getInstance().add(this);
  }
 }

 private void removeCurrentCanvasIfNeeded() {
  DisplayState currentDisplayState = DisplayState.getInstance();
  if (this.getParent() != null && this.getParent() == currentDisplayState) {
   currentDisplayState.remove(this);
  }
 }
}
