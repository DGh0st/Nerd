/**
 * ~ Assets.java
 * Raymond Hruby II
 * 04/03/2017
 * Assets class holds sprite images, currently only worldTile data
 */
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Assets
{
  private static final int WIDTH=64, HEIGHT=64, ROWS=5,COLS=5;
  
  private static Assets instance = null;
  
  //changed 2d array to 1d array so index acts as id for sprite image
  //changed 1d array to individual sprites to attach sprites to name
  //changed back to 1d array so Assets can be only assets class, and will update and use one arrayList
  public static ArrayList<BufferedImage> sprites;
  private String path;        //path to Spritesheet 

  public static Assets getInstance() {
    if (instance == null) {
      instance = new Assets( LocationArray.getInstance().getCurrentLocationIndex() );
    }
    return instance;
  }
  private Assets(int locationId){ //private constructor for Singleton pattern, use getInstance()
    System.out.println("inpath" + this.path);
    this.path = AssetsLoader.getAssetsPath(locationId);
    System.out.println("inpath" + this.path);
    initialize();
  }
  public void initialize(){
    SpriteSheet sheet = new SpriteSheet(this.path);
    sprites = new ArrayList<BufferedImage>(ROWS*COLS);
    
    for (int i = 0; i < ROWS; i++){
        for (int j = 0; j < COLS; j++){
          sprites.add( i*ROWS+j, sheet.crop( j*WIDTH, i*HEIGHT, WIDTH, HEIGHT ) );
        }
      }
  }
  
  //Only call if there is a new locaiton
  public void update(){
    int newLocationId = LocationArray.getInstance().getCurrentLocationIndex();
    
    System.out.println("inpath" + this.path);
    this.path = AssetsLoader.getAssetsPath(newLocationId);
    System.out.println("inpath" + this.path);
    
    initialize();
  }
  public BufferedImage getSprite(int index){
    return sprites.get(index);
  }

}