/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * Character class that character object movement, detects collisions with character, and other updates related to character.
 * Sub-class of GameObject
 * TODO: Implement collisionDetetcted() method
 */
import java.awt.event.*;

public abstract class Character extends GameObject implements KeyListener, CollisionListener, Movable, Drawable, Sound {
  private int xPos, yPos;
  Location location;
  //Position position;

  public Character(int x, int y){
    this.addKeyListener(this);
    this.xPos = x;
    this.yPos = y;
  }
  public Character(){}
  
  public void moveLeft(){
    if (location.canMoveToPosition(xPos--, yPos) == true){
      xPos--;
      currentPosition.setX(xPos);
    }
  }
  public void moveRight(){
    if (location.canMoveToPosition(xPos++, yPos) == true){
      xPos++;
      currentPosition.setX(xPos);
    }
  }
  public void moveUp(){
    if (location.canMoveToPosition(xPos, yPos++) == true){
      yPos++;
      currentPosition.setY(yPos);
    }
  }
  public void moveDown(){
    if (location.canMoveToPosition(xPos, yPos--) == true){
      yPos--;
    currentPosition.setY(yPos);
    }
  }
  
  abstract public void draw();
  abstract public void play();
  
  public void collisionDetected(){
    //TODO
    //uses getX and getY from Position Class
  }
  
  public void keyPressed(KeyEvent e){
    System.out.println("KeyPressed");
    int keyCode = e.getKeyCode();
    switch( keyCode ) { 
        case KeyEvent.VK_UP:    // handle up 
            moveUp();
            break;
        case KeyEvent.VK_DOWN:  // handle down 
            moveDown();
            break;
        case KeyEvent.VK_LEFT:  // handle left
            moveLeft();
            break;
        case KeyEvent.VK_RIGHT : // handle right
            moveRight();
            break;
     }
  }
  public void keyReleased(KeyEvent e){
    System.out.println("KeyReleased");
  }
  public void keyTyped(KeyEvent e){
  }
}