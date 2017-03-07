/**
 * ~ SpriteSheet.java
 * Raymond Hruby II
 * 03/06/2017
 * SpriteSheet to hold SpriteSheet.png data
 * 
 */
import java.awt.image.BufferedImage;

public class SpriteSheet
{
  private BufferedImage spriteSheet;
  
  public SpriteSheet(String path){
    spriteSheet = ImageLoader.loadImage(path);
  }
  public SpriteSheet(BufferedImage sheet){
    this.spriteSheet = sheet;
  }
  public BufferedImage crop(int x, int y, int width, int height){
    return spriteSheet.getSubimage(x,y,width,height);
  }
}