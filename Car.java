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

class Car extends MovableObstacle{
  int RECT_WIDTH = Tile.TILE_WIDTH, RECT_HEIGHT = Tile.TILE_HEIGHT, tileLimit = Tile.TILE_WIDTH, x;
  int carType = ThreadLocalRandom.current().nextInt(21, 23);

  public Car(int x, int y){
   super(x, y);
   this.x = x;
  }
  
  public void draw(){
   //moveLeft();
   draw(GameState.getInstance().getGraphics());
  }
  public void draw(Graphics g){
   int xPos = position.getX();
   int yPos = position.getY();
   if (g != null) {
      g.drawImage(Assets.getInstance().getSprite(carType), xPos*RECT_WIDTH+tileLimit, yPos*RECT_HEIGHT, RECT_WIDTH, RECT_HEIGHT, null);
    }
  }
  
  public void setSpeed(int speed){
   SPEED = ThreadLocalRandom.current().nextInt(speed, speed+RECT_WIDTH / 4);
  }
  
  public void moveLeft(){
    int xPos = position.getX();
    int yPos = position.getY();
    if (xPos < 0){
      xPos = x;
      yPos = ThreadLocalRandom.current().nextInt(3, 8);
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
