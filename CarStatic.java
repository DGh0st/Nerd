/**
 * Nerd 04/22/2017
 * Kandyce Burks
 * Tree class that is a subclass StaticObstacle class
 * TODO:
 *  - Implement draw() Method
 *  - Implement play() Method
 */

import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.image.BufferedImage;

class CarStatic extends StaticObstacle{
  int RECT_WIDTH = Tile.TILE_WIDTH, RECT_HEIGHT = Tile.TILE_HEIGHT;
  int carType = ThreadLocalRandom.current().nextInt(0, 6);
  BufferedImage image;

  public CarStatic(int x, int y) {
   super(x, y);
  }
  public void draw(){
   draw(GameState.getInstance().getGraphics());
  }
  public void draw(Graphics g){
   int x = position.getX();
   int y = position.getY();
    if (g != null) {
      BufferedImage image = Assets.getInstance().getCarSprite(carType);
      g.drawImage(image, x*RECT_WIDTH, y*RECT_HEIGHT, image.getWidth(), image.getHeight(), null);
    }
  }
  public void play(){
   //TODO
  }
}