/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * GameObject class that handles position changes for all Objects
 */
import javax.swing.*;

public abstract class GameObject extends JPanel{
  static int xPos, yPos;
  int [] getPosition = new int[2];
  private Position currentPosition;
  
  public GameObject(){
  }
  
  int [] getPosition(){
    
    getPosition[0] = Position.getXpos();
    getPosition[1] = Position.getYpos();
    
    return getPosition;
  }
  int setObjectPosition(int x, int y){
      xPos = x;
      yPos = y;
      
      return 1;
  }
}