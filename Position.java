/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * Position class that handles the x/y coordinate positions of all game objects.
 * Sub-class of GameObject
 */
public class Position {
  private int x , y; 
  
  public Position() {
    this.x = 0;
    this.y = 0;
    //x = location.getWidth()/2, y = 0; <----- TODO: starting xPos. should be at bottom of screen in the center. DOES NOT WORK!
  }

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  public int getX(){//takes x parameter given by Object Class and up
    return x;
  }

  public int getY(){
    return y;
  }
  
  void setPosition(int posX, int posY){//takes x coordinate given the parameter and updates it in Object Class.
    x = posX;
    y = posY;
  }

  void setX(int posX) {
    x = posX;
  }

  void setY(int posY) {
    y = posY;
  }

  boolean equals(Position other) {
    return x == other.x && y == other.y;
  }
}