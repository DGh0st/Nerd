/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * Weaboo class that is a subclass of Character
 * TODO:
 *  - Implement draw() Method
 *  - Implement play() Method
 */
import java.awt.Graphics;

class Weaboo extends Character{
  int RECT_X = 10, RECT_Y = 10, RECT_WIDTH = 10, RECT_HEIGHT = 10;
  
  public Weaboo(int x, int y){
    super(x,y);
    Graphics g = getGraphics();
    g.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
  }
  
  public void draw(){
   //TODO
  }
  public void play(){
   //TODO
  }
}
