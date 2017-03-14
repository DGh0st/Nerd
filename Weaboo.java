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
  Position position;
  int RECT_WIDTH = 64, RECT_HEIGHT = 64;
  
  public Weaboo(int x, int y){
    super(x,y);
   // draw();
  }
  
  public void draw(){
    if (GameState.getInstance().getGraphics() != null){
     Graphics g = GameState.getInstance().getGraphics();
     //System.out.println("x "+position.x+" y "+position.y);
     g.drawImage(Assets.player01,position.x-10, position.y-13, this);
    }
  }
  
  public void play(){
   //TODO
  }
}