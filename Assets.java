/**
 * ~ Assets.java
 * Raymond Hruby II
 * 03/06/2017
 * Assets class holds sprite images, currently only worldTile data
 * 
 * CHECK: may need to change implementation based on expanded use
 * 
 * TODO: Bounds check for getAsset()
 */
import java.awt.image.BufferedImage;

public class Assets
{
  private final int DEFAULT_WIDTH=64, DEFAULT_HEIGHT=64,
    DEFAULT_ROWS = 5, DEFAULT_COLS = 5;
  
  public  BufferedImage[][] sprites = new BufferedImage[DEFAULT_ROWS][DEFAULT_COLS];
  private String path;  //path to Spritesheet 
  
  public Assets(String path){
    this.path = path;
    initialize();
  }
  public Assets(int id){
    this.path = AssetsLoader.getAssetsPath(id);
    initialize();
  }
  
  public void initialize(){
    SpriteSheet sheet = new SpriteSheet(this.path); 
    
    for (int i = 0; i < DEFAULT_ROWS; i++){
      for (int j = 0; j < DEFAULT_COLS; j++){
        sprites[i][j] = sheet.crop(j * DEFAULT_WIDTH,i * DEFAULT_HEIGHT,
                                    DEFAULT_WIDTH,DEFAULT_HEIGHT);
      }
    }
  }
  
  public BufferedImage getSprite(int x, int y){
    return sprites[x][y];
  }
}