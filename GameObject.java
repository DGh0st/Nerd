/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * GameObject class that handles position changes for all Objects
 */
import javax.swing.*;

public abstract class GameObject extends JPanel{
  int xPos, yPos;
  private Position currentPosition;
  
  public GameObject(){
  }
  
  void getPosition(){
    Position.getX(xPos);
    Position.getY(yPos);
  }
  void setPosition(){
      xPos = Position.x;
      yPos = Position.y;
  }
}