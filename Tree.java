/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * Tree class that is a subclass StaticObstacle class
 * TODO:
 *  - Implement draw() Method
 *  - Implement play() Method
 */

import java.awt.Graphics;
import java.awt.image.BufferedImage;

class Tree extends StaticObstacle{
  int RECT_WIDTH = Tile.TILE_WIDTH, RECT_HEIGHT = Tile.TILE_HEIGHT;
  BufferedImage image;

  public Tree(int x, int y) {
   super(x, y);

   image = ImageLoader.loadImage("./resources/textures/Tree.png");
  }
  public void draw(){
   draw(GameState.getInstance().getGraphics());
  }
  public void draw(Graphics g){
    int x = (position.getX() * RECT_WIDTH + RECT_WIDTH / 2) - image.getWidth() / 2;
    int y = (position.getY() * RECT_HEIGHT + RECT_HEIGHT / 2) - image.getHeight() * 4 / 5;
    if (g != null) {
      g.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
    }
  }
  public void play(){
   //TODO
  }
}