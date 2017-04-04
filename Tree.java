/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * Tree class that is a subclass StaticObstacle class
 * TODO:
 *  - Implement draw() Method
 *  - Implement play() Method
 */

import java.awt.Graphics;

class Tree extends StaticObstacle{
  int RECT_WIDTH = Tile.TILE_WIDTH, RECT_HEIGHT = Tile.TILE_HEIGHT;
  public Tree(int x, int y) {
   super(x, y);
  }
  public void draw(){
   draw(GameState.getInstance().getGraphics());
  }
  public void draw(Graphics g){
   int x = position.getX() * RECT_WIDTH;
   int y = position.getY() * RECT_HEIGHT;
   if (g != null) {
      g.drawImage(Assets.getInstance().getSprite(20),x, y, RECT_WIDTH, RECT_HEIGHT, null);
    }
  }
  public void play(){
   //TODO
  }
}