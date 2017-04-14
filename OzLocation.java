/**
 * ~ OzLocation.java
 * Raymond Hruby II
 * 04/09/2017
 * Test location for use in Oz demonstration
 */
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

public class OzLocation extends Location{
  int movableTotalRanges = 2; //two ranges(roads) for statics
  int staticTotalRanges = 3; 
  ArrayList< ArrayList<Integer> > staticRanges = new ArrayList< ArrayList<Integer> >();
  ArrayList< ArrayList<Integer> >movableRanges = new ArrayList< ArrayList<Integer> >();
  //ArrayList<Integer> movableRanges = new ArrayList<Integer>(4);
  
  public OzLocation(int id){
    super(id);
    
    ArrayList<Integer> range = new ArrayList<Integer>(2);
    
    //STATIC
    range.add(1);
    range.add(3);    
    staticRanges.add(range);  
    range.add(0,11);
    range.add(1,14);
    staticRanges.add(range);    
    range.add(0,20);
    range.add(1,22);
    staticRanges.add(range);
    /*
    staticRanges.add(1);
    staticRanges.add(3);
    staticRanges.add(11);
    staticRanges.add(14);
    staticRanges.add(20);
    staticRanges.add(22);
    */
    
    //MOVABLE
    range.add(0,5);
    range.add(1,9);
    movableRanges.add(range);    
    range.add(0,16);
    range.add(1,18);
    movableRanges.add(range);
    /*
    movableRanges.add(5);
    movableRanges.add(9);
    movableRanges.add(16);
    movableRanges.add(18);  
    */
  }

  public void drawPlayer(Character player) {
    super.drawPlayer(player);

    int gridY = 19;
    int gridY2 = 15;
    int gridY3 = 11;

    Graphics g = locationBackgroundImage.getGraphics();
    g.setColor(Color.white);
    g.setFont(new Font(Font.SERIF, Font.PLAIN, 48));
    
    int playerY = playerPosition.getY();
    int playerX = playerPosition.getX();

    if (playerY > gridY) {
      g.drawString("Avoid being hit by cars.", NerdGame.windowSize.width * 7 / 20, gridY * Tile.TILE_HEIGHT - Tile.TILE_HEIGHT / 5);
    } else if (playerY < gridY2 && playerY > gridY3) {
      g.drawString("You can't climb trees.", NerdGame.windowSize.width * 7 / 20, gridY3 * Tile.TILE_HEIGHT - Tile.TILE_HEIGHT / 5);
    }

    int y = 0;
    if (playerY <= 10) {
      y = 10;
    }else if (playerY >= getHeight() - 2) {
      y = getHeight() - 2;
    }else {
      y = playerY;
    }

    BufferedImage keysImage = HelpAssets.getInstance().getCurrentSprite();
    int x = NerdGame.windowSize.width - keysImage.getWidth() - 64;
    if (playerX * Tile.TILE_WIDTH > NerdGame.windowSize.width / 2) {
      x = 64;
    }

    g.drawImage(keysImage, x, y * Tile.TILE_HEIGHT - keysImage.getHeight() / 2, null);
  }
  
  public int getMovableTotalRanges(){
    return movableTotalRanges;
  }
  public int getStaticTotalRanges(){
    return staticTotalRanges;
  }
  public ArrayList<Integer> getMovableRange(int range){
    return movableRanges.get(range);
  }
  
  public ArrayList<Integer> getStaticRange(int range){
    return staticRanges.get(range);
  }
  
  
  
}