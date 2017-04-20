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
  int constSpeed;
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
   int lane = (position.getY())%2;
   switch(lane){
      case 0:  SPEED = speed; break;
      default: SPEED = speed+10;
    }
   constSpeed = speed;
  }
  
  public void moveLeft(){
    int xPos = position.getX();
    int yPos = position.getY();
    if (xPos < -2){
      int randMovableRange = ThreadLocalRandom.current().nextInt(1, LocationArray.getInstance().getCurrentLocation().getTotalMovableRanges()*2);
      if(randMovableRange%2 == 0){ randMovableRange-=1;}
      xPos = x;
      yPos = ThreadLocalRandom.current().nextInt(LocationArray.getInstance().getCurrentLocation().getMovableRanges().get(randMovableRange-1), LocationArray.getInstance().getCurrentLocation().getMovableRanges().get(randMovableRange));
    }
    if (tileLimit <= 0) {
      tileLimit = 64;
      xPos--;
    }
    tileLimit-=SPEED;
    position.setPosition(xPos, yPos);
    setSpeed(constSpeed);
  }
  
  public void play(){
   //TODO
  }
  
  
  public boolean checkPlayerCollision(Character player) {
    if (position.getX() == player.getPosition().getX() || position.getX() + 1 == player.getPosition().getX()){
      if (position.getY() == player.getPosition().getY()){     
        return true;
      }
    }
    return false;
  }
  
    public void checkSelfCollision() {
  for (int i = 0; i < LocationArray.getInstance().getCurrentLocation().getMovableObstacles().size(); i++){
    for (int k = i+1; k < LocationArray.getInstance().getCurrentLocation().getMovableObstacles().size(); k++){
      if(Math.abs(LocationArray.getInstance().getCurrentLocation().getMovableObstacles().get(i).getPosition().getX()-LocationArray.getInstance().getCurrentLocation().getMovableObstacles().get(k).getPosition().getX())<3){
        if (LocationArray.getInstance().getCurrentLocation().getMovableObstacles().get(i).getPosition().getY() == LocationArray.getInstance().getCurrentLocation().getMovableObstacles().get(k).getPosition().getY()){           
          int pos = LocationArray.getInstance().getCurrentLocation().getMovableObstacles().get(i).getPosition().getX();
          LocationArray.getInstance().getCurrentLocation().getMovableObstacles().get(i).getPosition().setX(pos+2); 
        }
      }
    }
  }
 }
  
  public void moveDown(){}
  public void moveUp(){}
  public void moveRight(){}
  
}
