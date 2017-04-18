/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * Character class that character object movement, detects collisions with character, and other updates related to character.
 * Sub-class of GameObject
 * TODO: Implement collisionDetetcted() method
 */
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Character extends GameObject implements CollisionListener, Movable, Drawable, Sound {
  private Position animator;

  public Character(int x, int y){
    super(x, y);

    animator = new Position(0, 0);
  }

  public void animate() {
    int destX = position.getX() * Tile.TILE_WIDTH;
    int destY = position.getY() * Tile.TILE_HEIGHT;

    int pixelX = pixel.getX();
    int pixelY = pixel.getY();

    if (pixelX != destX || pixelY != destY) {
      pixel.setX(pixelX + animator.getX());
      pixel.setY(pixelY + animator.getY());
    }
  }
  
  public void moveLeft(){
    if (position.getX() * Tile.TILE_WIDTH != pixel.getX() ||
        position.getY() * Tile.TILE_HEIGHT != pixel.getY()) {
      return;
    }
    int xPos = position.getX();
    int yPos = position.getY();
    //if (xPos>0){
    if (LocationArray.getInstance().getCurrentLocation().canMoveToPosition(xPos-1, yPos) == true){
      //xPos-=64;
      xPos--;
      //System.out.println("x: " + xPos + " y: " + yPos);
      position.setPosition(xPos, yPos);
      animator = new Position(-Tile.TILE_WIDTH / 4, 0);
    }
    //}
  }
  public void moveRight(){
    if (position.getX() * Tile.TILE_WIDTH != pixel.getX() ||
        position.getY() * Tile.TILE_HEIGHT != pixel.getY()) {
      return;
    }
    int xPos = position.getX();
    int yPos = position.getY();
    if (LocationArray.getInstance().getCurrentLocation().canMoveToPosition(xPos+1, yPos) == true){
      //xPos+=64;
      xPos++;
      //System.out.println("x: " + xPos + " y: " + yPos);
      position.setPosition(xPos, yPos);
      animator = new Position(Tile.TILE_WIDTH / 4, 0);
    }
  }
  public void moveUp(){
    if (position.getX() * Tile.TILE_WIDTH != pixel.getX() ||
        position.getY() * Tile.TILE_HEIGHT != pixel.getY()) {
      return;
    }
    int xPos = position.getX();
    int yPos = position.getY();
    //if (yPos>0){
    if (LocationArray.getInstance().getCurrentLocation().canMoveToPosition(xPos, yPos-1) == true){
      //yPos-=64;
      yPos--;
      //System.out.println("x: " + xPos + " y: " + yPos);
      position.setPosition(xPos,yPos);
      animator = new Position(0, -Tile.TILE_HEIGHT / 4);
    }
    if (yPos == 0) {
      GameState.getInstance().victory();
    }
    //}
  }
  public void moveDown(){
    if (position.getX() * Tile.TILE_WIDTH != pixel.getX() ||
        position.getY() * Tile.TILE_HEIGHT != pixel.getY()) {
      return;
    }
    int xPos = position.getX();
    int yPos = position.getY();
    if (LocationArray.getInstance().getCurrentLocation().canMoveToPosition(xPos, yPos+1) == true){
      //yPos+=64;
      yPos++;
      //System.out.println("x: " + xPos + " y: " + yPos);
      position.setPosition(xPos, yPos);
      animator = new Position(0, Tile.TILE_HEIGHT / 4);
    }
  }
  
  abstract public void draw();
  abstract public void draw(Graphics g);
  abstract public void play();
  abstract public BufferedImage getImage();
  
  public void collisionDetected(){
    //TODO
    //uses getPosition from GameObject Class which
    //sends current position of object to Position class then
    //use Position instamce to grab value of x and y for comparison
    //If collision is detected stop the game??
  }
}
