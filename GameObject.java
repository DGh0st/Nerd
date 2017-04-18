/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * GameObject class that handles position changes for all Objects
 */
import javax.swing.*;

public abstract class GameObject {
  protected Position position;
  protected Position pixel;
  
  public GameObject(){
    position = new Position();
    pixel = new Position();
  }

  public GameObject(int x, int y) {
    position = new Position(x, y);
    pixel = new Position(x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
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
  
  Position getPixel(){
    return pixel;
  }
  void setPixel(int x, int y){
    pixel.setPosition(x, y);
  }
  void setPixel(Position newPixel){
    pixel = newPixel;
  }
}
