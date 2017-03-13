/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * Character class that character object movement, detects collisions with character, and other updates related to character.
 * Sub-class of GameObject
 * TODO: Implement collisionDetetcted() method
 */
import java.awt.event.*;

public abstract class Character extends GameObject implements CollisionListener, Movable, Drawable, Sound {
  private int xPos, yPos;
  Location location;
  private Position position;

  public Character(int x, int y){
    this.xPos = x;
    this.yPos = y;
    position = new Position();
    //location = new Location ();
  }
  
  public void moveLeft(){
    if (location.canMoveToPosition(xPos-1, yPos) == true){
      xPos--;
      position.setX(xPos);
    }
  }
  public void moveRight(){
    if (location.canMoveToPosition(xPos+1, yPos) == true){
      xPos++;
      position.setX(xPos);
    }
  }
  public void moveUp(){
    if (location.canMoveToPosition(xPos, yPos+1) == true){
      yPos++;
      position.setY(yPos);
    }
  }
  public void moveDown(){
    if (location.canMoveToPosition(xPos, yPos-1) == true){
      yPos--;
      position.setY(yPos);
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
