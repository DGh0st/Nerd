/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * Car class is a sub-class of MovableObstacle
 * TODO:
 *  - Implement draw() Method
 *  - Implement play() Method
 */

import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.image.BufferedImage;

class Car extends MovableObstacle{
  int RECT_WIDTH = Tile.TILE_WIDTH, RECT_HEIGHT = Tile.TILE_HEIGHT, tileLimit = Tile.TILE_WIDTH, x;
  int carType = ThreadLocalRandom.current().nextInt(0, 3);

  public Car(int x, int y){
   super(x, y);
   this.x = NerdGame.windowSize.width / RECT_WIDTH;
  }
  
  public void draw(){
   draw(GameState.getInstance().getGraphics());
  }
  public void draw(Graphics g){
   int xPos = position.getX();
   int yPos = position.getY();
   if (g != null) {
      BufferedImage image = Assets.getInstance().getCarSprite(carType);
      g.drawImage(image, xPos*RECT_WIDTH+tileLimit, yPos*RECT_HEIGHT, image.getWidth(), image.getHeight(), null);
    }
  }
  
  public void setSpeed(int speed){
   SPEED = ThreadLocalRandom.current().nextInt(speed, speed+RECT_WIDTH / 4);
  }
  
  public void moveLeft(){
    int xPos = position.getX();
    int yPos = position.getY();
    if (xPos < -2){
      xPos = x;
    }
    if (tileLimit <= 0) {
      tileLimit = 64;
      xPos--;
    }
    tileLimit-=SPEED;
    position.setPosition(xPos, yPos);
  }
  
  public void play(){
   //TODO
  }
  
  public void moveDown(){}
  public void moveUp(){}
  public void moveRight(){}
  
}
