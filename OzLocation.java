/**
 * ~ OzLocation.java
 * Raymond Hruby II
 * 03/13/2017
 * Test location for use in Oz demonstration
 */
import java.awt.Graphics;
import java.awt.Graphics2D;

public class OzLocation extends Location{
  public OzLocation(String path, int id){
    super(path,id);
  }
  public void draw(){  

  }
  public void update(){
    //not yet implemented
  }
  public void drawLocation(Graphics g){
     //inefficient method, will render every tile even if out of screen
    for(int y=0; y<super.getHeight(); y++){
      for(int x=0; x<super.getWidth(); x++){
        getTile(x, y).draw(g, (int)(x*Tile.TILE_WIDTH), (int)(y*Tile.TILE_HEIGHT));
      }
    }
  }

}
