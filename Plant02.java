/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * Tree class that is a subclass StaticObstacle class
 * TODO:
 *  - Implement draw() Method
 *  - Implement play() Method
 */

import java.awt.Graphics;
//import java.util.concurrent.ThreadLocalRandom;
import java.awt.image.BufferedImage;

class Plant02 extends StaticObstacle{
  int RECT_WIDTH = Tile.TILE_WIDTH, RECT_HEIGHT = Tile.TILE_HEIGHT;
  BufferedImage image;

  public Plant02(int x, int y) {
   super(x, y);
  }
  public void draw(){
   draw(GameState.getInstance().getGraphics());
  }
  public void draw(Graphics g){
   int x = position.getX();
   int y = position.getY();
    if (g != null) {
      BufferedImage image = Assets.getInstance().getSprite(38);
      g.drawImage(image, x*64, y*64, image.getWidth(), image.getHeight(), null);
    }
  }
  public void play(){
   //TODO
  }
}