/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * Position class that handles the x/y coordinate positions of all game objects.
 * Sub-class of GameObject
 */
public class Position extends GameObject{
  
  LocationDimension location;
  static int x , y; 
  //x = location.getWidth()/2, y = 0; <----- TODO: starting xPos. should be at bottom of screen in the center. DOES NOT WORK!
  
  public Position(){
    System.out.println("");
  }
  
  static void getX(int posX){//takes x parameter given by Object Class and up
    x = posX;
  }
  static void getY(int posY){
    y = posY;
  }
  
  void setX(int posX){//takes x coordinate given the parameter and updates it in Object Class.
    x = posX;
    setPosition();
  }
  void setY(int posY){// Same as setX() above
    y = posY;
    setPosition();
  }
}