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
  int RECT_WIDTH = 64, RECT_HEIGHT = 64;
  
  public Weaboo(int x, int y){
    super(x,y);
   // draw();
  }
  
  public void draw(){
    draw(GameState.getInstance().getGraphics());
    //System.out.println("x "+position.x+" y "+position.y);
  }

  public void draw(Graphics g){
    int x = position.getX() * 64;
    int y = position.getY() * 64;
    if (g != null) {
      g.drawImage(Assets.player01,x, y, null);
    }
  }
  
  public void play(){
   //TODO
  }
}