/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * GameObject class that handles position changes for all Objects
 */
import javax.swing.*;

public abstract class GameObject extends JPanel{
  int xPos, yPos;
  Position currentPosition;
  
  public GameObject(){
  }
  
  void getPosition(){
    currentPosition.getX(xPos);
    currentPosition.getY(yPos);
  }
  void setPosition(){
    xPos = currentPosition.x;
    yPos = currentPosition.y;
  }
}