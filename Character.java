/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * Character class that character object movement, detects collisions with character, and other updates related to character.
 * Sub-class of GameObject
 * TODO: Implement collisionDetetcted() method
 */
import java.awt.event.*;

public abstract class Character extends GameObject implements CollisionListener, Movable, Drawable, Sound {

  public Character(int x, int y){
    super(x, y);
  }
  
  public void moveLeft(){
    int xPos = position.getX();
    int yPos = position.getY();
    if (xPos>0){
    if (LocationArray.getInstance().getCurrentLocation().canMoveToPosition(xPos-64, yPos) == true){
      xPos-=64;
      //System.out.println("x: " + xPos + " y: " + yPos);
      position.setPosition(xPos, yPos);
    }
    }
  }
  public void moveRight(){
    int xPos = position.getX();
    int yPos = position.getY();
    if (LocationArray.getInstance().getCurrentLocation().canMoveToPosition(xPos+64, yPos) == true){
      xPos+=64;
      System.out.println("x: " + xPos + " y: " + yPos);
      position.setPosition(xPos, yPos);
    }
  }
  public void moveUp(){
    int xPos = position.getX();
    int yPos = position.getY();
    if (yPos>0){
    if (LocationArray.getInstance().getCurrentLocation().canMoveToPosition(xPos, yPos-64) == true){
      yPos-=64;
      //System.out.println("x: " + xPos + " y: " + yPos);
      position.setPosition(xPos,yPos);
    }
    }
  }
  public void moveDown(){
    int xPos = position.getX();
    int yPos = position.getY();
    if (LocationArray.getInstance().getCurrentLocation().canMoveToPosition(xPos, yPos+64) == true){
      yPos+=64;
      //System.out.println("x: " + xPos + " y: " + yPos);
      position.setPosition(xPos, yPos);
    }
  }
  
  abstract public void draw();
  abstract public void play();
  
  public void collisionDetected(){
    //TODO
    //uses getPosition from GameObject Class which
    //sends current position of object to Position class then
    //use Position instamce to grab value of x and y for comparison
    //If collision is detected stop the game??
  }
}
