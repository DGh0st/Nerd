/**
 * ~ Assets.java
 * Raymond Hruby II
 * 03/15/2017
 * Assets class holds sprite images, currently only worldTile data
 * TODO: Bounds check for getAsset()
 *       Change to singleton
 *       Change from hardcoded and loading first spritesheet to modular 
 */
import java.awt.image.BufferedImage;

public class Assets
{
  //private static final SpriteDimensions dimensions;
  private static final int WIDTH=64, HEIGHT=64, ROWS=5,COLS=5;
  
  //changed 2d array to 1d array so index acts as id for sprite image
  //public  static BufferedImage[] sprites = new BufferedImage[dimensions.DEFAULT_ROWS*dimensions.DEFAULT_COLS];
  //changed 1d array to individual sprites to attach sprites to name
  public static BufferedImage player01,player_Death,
    grass01,grass02,grass03,
    trail01,trail02,
    rock01,rock02,
    road01,road02,
    tree01,obstacle02,obstacle03,obstacle04,obstacle05;
  
  private String path;        //path to Spritesheet 
  /*
  public Assets(String path){ //Try not to use this one, use Assets(int id), 
    this.path = path;         //  which picks path based on the id
    initialize();
  }
  */
  public Assets(int locationId){
    System.out.println("inpath" + this.path);
    this.path = AssetsLoader.getAssetsPath(locationId);
    System.out.println("inpath" + this.path);
    initialize();
  }
  
  public void initialize(){
    SpriteSheet sheet = new SpriteSheet(this.path); 
    
    /*
    for (int i = 0; i < dimensions.DEFAULT_ROWS; i++){
      for (int j = 0; j < dimensions.DEFAULT_COLS; j++){
        sprites[i*dimensions.DEFAULT_ROWS+j] = sheet.crop(i * dimensions.DEFAULT_WIDTH,j * dimensions.DEFAULT_HEIGHT,
                                    dimensions.DEFAULT_WIDTH,dimensions.DEFAULT_HEIGHT);
      }
    }
    */
    //first row
    player01 =     sheet.crop(0    , 0, WIDTH, HEIGHT);
    player_Death = sheet.crop(WIDTH, 0, WIDTH, HEIGHT);
    
    //second row
    grass01 = sheet.crop(0      , HEIGHT, WIDTH, HEIGHT);
    grass02 = sheet.crop(WIDTH  , HEIGHT, WIDTH, HEIGHT);
    grass03 = sheet.crop(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
    trail01 = sheet.crop(WIDTH*3, HEIGHT, WIDTH, HEIGHT); 
    trail02 = sheet.crop(WIDTH*4, HEIGHT, WIDTH, HEIGHT);
    
    //third row
    rock01 = sheet.crop(0     , HEIGHT*2, WIDTH, HEIGHT);
    rock02 = sheet.crop(WIDTH , HEIGHT*2, WIDTH, HEIGHT);
    
    //fourth row
    road01 = sheet.crop(0     , HEIGHT*3, WIDTH, HEIGHT);
    road02 = sheet.crop(WIDTH , HEIGHT*3, WIDTH, HEIGHT);
                        
    //fifth row
    tree01     = sheet.crop(0      , HEIGHT*4, WIDTH, HEIGHT);
    obstacle02 = sheet.crop(WIDTH  , HEIGHT*4, WIDTH, HEIGHT);
    obstacle03 = sheet.crop(WIDTH*2, HEIGHT*4, WIDTH, HEIGHT);
    obstacle04 = sheet.crop(WIDTH*3, HEIGHT*4, WIDTH, HEIGHT);
    obstacle05 = sheet.crop(WIDTH*4, HEIGHT*4, WIDTH, HEIGHT);
  }
}