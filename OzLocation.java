/**
 * ~ OzLocation.java
 * Raymond Hruby II
 * 04/03/2017
 * Test location for use in Oz demonstration
 */
import java.awt.Graphics;

public class OzLocation extends Location{
  public OzLocation(int id){
    super(id);
  }
  public void draw(){  
    draw(GameState.getInstance().getGraphics());
  }
  public void draw(Graphics g){
    for(int y=0; y<super.getHeight(); y++){
      for(int x=0; x<super.getWidth(); x++){
        //FROM TILES
        super.redrawTileAtPos(new Position(x, y), g);
      }
    }
  }
  
}