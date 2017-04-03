/**
 * ~ AlphaLocation.java
 * Raymond Hruby II
 * 04/03/2017
 * Test location for use in Alpha demonstration
 */
import java.awt.Graphics;
import java.awt.Graphics2D;

public class AlphaLocation extends Location{
  public AlphaLocation(int id){
    super(id);
  }
  public void draw(){  
    //inefficient method, will render every tile even if out of screen
    //will work for OzLocation
    draw(GameState.getInstance().getGraphics());
  }
  public void draw(Graphics g){
    for(int y=0; y<super.getHeight(); y++){
      for(int x=0; x<super.getWidth(); x++){
        //FROM TILES
        super.getTile(x, y).draw(g, (int)(x*Tile.TILE_WIDTH), (int)(y*Tile.TILE_HEIGHT));
      }
    }
  }
  public void update(){
    //not yet implemented
  }


}
