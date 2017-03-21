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
    if (g != null) {
      g.drawImage(Assets.player01,position.getX()-10, position.getY()-13, null);
    }
  }
  
  public void play(){
   //TODO
  }
}