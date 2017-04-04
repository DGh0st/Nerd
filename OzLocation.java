/**
 * ~ OzLocation.java
 * Raymond Hruby II
 * 04/03/2017
 * Test location for use in Oz demonstration
 */
import java.awt.Graphics;
import java.awt.Graphics2D;

public class OzLocation extends Location{
  public OzLocation(int id){
    super(id);
  }
  public void draw(){  
    draw(GameState.getInstance().getGraphics());
  }
  public void draw(Graphics g){
    //for(int y=0; y<super.getHeight(); y++){
      //for(int x=0; x<super.getWidth(); x++){
        //FROM TILES
        for (Position pos : redrawLocations) {
          super.drawTileAtPos(pos, g);
        }
        redrawLocations.clear();
      //}
    //}
    for(MovableObstacle m: super.getMovableObstacles()){
      m.draw();
    }
    for(StaticObstacle s: super.getStaticObstacles()){
      s.draw();
    }
  }
  
}