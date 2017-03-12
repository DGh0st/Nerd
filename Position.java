/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * Position class that handles the x/y coordinate positions of all game objects.
 * Sub-class of GameObject
 */
public abstract class Position extends GameObject{
  
  LocationDimension location;
  int x = location.getWidth()/2, y = 0;
  
  public Position(){
  }
  
  void getX(int posX){
    x = posX;
  }
  void getY(int posY){
    y = posY;
  }
  
  void setX(int posX){
    x = posX;
    setPosition();
  }
  void setY(int posY){
    y = posY;
    setPosition();
  }
}