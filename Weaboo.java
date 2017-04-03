/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * Weaboo class that is a subclass of Character
 * TODO:
 *  - Implement draw() Method
 *  - Implement play() Method
 */
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;

class Weaboo extends Character{
  int RECT_WIDTH = Tile.TILE_WIDTH, RECT_HEIGHT = Tile.TILE_HEIGHT;
  
  public Weaboo(int x, int y){
    super(x,y);
   // draw();
  }
  
  public void draw(){
    draw(GameState.getInstance().getGraphics());
    //System.out.println("x "+position.x+" y "+position.y);
  }

  public void draw(Graphics g){
    int x = position.getX() * RECT_WIDTH;
    int y = position.getY() * RECT_HEIGHT;
    if (g != null) {
      g.drawImage(Assets.getInstance().getSprite(0),x, y, RECT_WIDTH, RECT_HEIGHT, null);
    }
  }
  
  public void play(){
   //TODO
  }
}