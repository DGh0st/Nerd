/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * GameObject class that handles position changes for all Objects
 */
import javax.swing.*;

public abstract class GameObject {
  protected Position position;
  
  public GameObject(){
    position = new Position();
  }

  public GameObject(int x, int y) {
    position = new Position(x, y);
  }
  
  Position getPosition(){
    return position;
  }
  void setObjectPosition(int x, int y){
      position.setPosition(x, y);
  }
  void setObjectPosition(Position newPosition){
    position = newPosition;
  }
}