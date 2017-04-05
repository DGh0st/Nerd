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
 private ObstacleState obstacleCanvas;
 private boolean shouldRedraw = true;

 private GameState() {
  super();

  locations = LocationArray.getInstance();
  Assets assets = Assets.getInstance(); //needs to be under locationArray (dependent)

  collisionChecker = new CollisionEvent();
  collisionChecker.addListener(this);

  this.setBackground(Color.black);
  this.setPreferredSize(NerdGame.windowSize);
  this.setSize(NerdGame.windowSize);
  this.setFocusable(true);
  this.addKeyListener(this);
  this.setOpaque(true);

  FlowLayout layout = (FlowLayout)getLayout();
  layout.setVgap(0);

  obstacleCanvas = new ObstacleState();
 }

 public static synchronized GameState getInstance() {
  if (instance == null) {
   instance = new GameState();
  }
  return instance;
 }

 @Override
 public void keyPressed(KeyEvent event) {
  // Nothing additional to do as of yet...
 }

 @Override
 public void keyReleased(KeyEvent event) {
  int keyCode = event.getKeyCode();
  if (keyCode == KeyEvent.VK_ESCAPE) {
    DisplayState.getInstance().setCurrentDisplayStatus(DisplayStatus.PAUSEMENU);
    removeCurrentCanvasIfNeeded();
    shouldRedraw = true;
  } else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
    locations.getCurrentLocation().redrawTileAtPos(player.getPosition(), getGraphics());
    player.moveUp();
  } else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
    locations.getCurrentLocation().redrawTileAtPos(player.getPosition(), getGraphics());
    player.moveDown();
  } else if (keyCode ==KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
    locations.getCurrentLocation().redrawTileAtPos(player.getPosition(), getGraphics());
    player.moveLeft();
  } else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
    locations.getCurrentLocation().redrawTileAtPos(player.getPosition(), getGraphics());
    player.moveRight();
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
  addCurrentCanvasIfNeeded();

  player = new Weaboo(locations.getCurrentSpawnX(), locations.getCurrentSpawnY());
  collisionChecker.addListener(player);
  locations.getCurrentLocation().initializeLocation(locations.getCurrentLocation().getPath());
  shouldRedraw = true;
 }

 public void update() {
  collisionChecker.checkCollision(player, locations.getMovableObstacles());
  locations.updateCurrentLocation();
 }

 public void draw() {
  addCurrentCanvasIfNeeded();
  this.requestFocus();

  if (shouldRedraw) {
    this.paintComponent(getGraphics());
    shouldRedraw = false;
  }

  obstacleCanvas.draw(player, locations);
 }

 private void addCurrentCanvasIfNeeded() {
  if (this.getParent() == null) {
    DisplayState.getInstance().add(this);
  }
  if (obstacleCanvas.getParent() == null) {
    DisplayState.getInstance().add(obstacleCanvas);
  }
 }

 private void removeCurrentCanvasIfNeeded() {
  DisplayState currentDisplayState = DisplayState.getInstance();
  if (this.getParent() != null && this.getParent() == currentDisplayState) {
   currentDisplayState.remove(this);
  }
  if (obstacleCanvas.getParent() != null && obstacleCanvas.getParent() == currentDisplayState) {
   currentDisplayState.remove(obstacleCanvas);
  }
 }

 protected void paintComponent(Graphics g) {
  super.paintComponent(g);

  locations.drawCurrentLocation();
  for(StaticObstacle s : locations.getCurrentLocation().getStaticObstacles()){
    s.draw();
  }

  g.dispose();
 }
}
