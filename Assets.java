/**
 * ~ Assets.java
 * Raymond Hruby II
 * 04/20/2017
 * Assets class holds sprite images
 */
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Assets
{
  private static int WIDTH=64, HEIGHT=64, 
    ROWS,COLS;
  
  private static Assets instance = null;
  
  public static ArrayList<BufferedImage> sprites;
  public static ArrayList<BufferedImage> sprites_cars;
  private String path;        //path to Spritesheet 
  private SpriteSheet sheet;
  
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
    
    updateRowsAndCols(locationId);
    initialize();
  }
  public void initialize(){
    sheet = new SpriteSheet(this.path);
    sprites = new ArrayList<BufferedImage>(ROWS*COLS);
    
    for (int i = 0; i < ROWS; i++){
      for (int j = 0; j < COLS; j++){
        sprites.add( i*COLS+j, sheet.crop( j*WIDTH, i*HEIGHT, WIDTH, HEIGHT ) );
      }
    }
    
    //CARS
    int locationIndex=LocationArray.getInstance().getCurrentLocationIndex();
    switch(locationIndex){
      case 0: initializeCars();
        break;
      case 1: initializeCars();
        break;
      default: initializeCars();
        break;
    }
  }
  public void initializeCars(){
    sprites_cars = new ArrayList<BufferedImage>(6);
      
    sprites_cars.add( 0, sheet.crop( WIDTH*5, HEIGHT*4, WIDTH*3, HEIGHT*2 ) );
    sprites_cars.add( 1, sheet.crop( WIDTH*5, HEIGHT*6, WIDTH*3, HEIGHT*2 ) );
    sprites_cars.add( 2, sheet.crop( WIDTH*5, HEIGHT*8, WIDTH*3, HEIGHT*2 ) );
    sprites_cars.add( 3, sheet.crop( WIDTH*8, HEIGHT*4, WIDTH*3, HEIGHT*2 ) );
    sprites_cars.add( 4, sheet.crop( WIDTH*8, HEIGHT*6, WIDTH*3, HEIGHT*2 ) );
    sprites_cars.add( 5, sheet.crop( WIDTH*8, HEIGHT*8, WIDTH*3, HEIGHT*2 ) );
  }
  
  public void update(){ 
    int newLocationId = LocationArray.getInstance().getCurrentLocationIndex();
    
    System.out.println("inpath" + this.path);
    this.path = AssetsLoader.getAssetsPath(newLocationId);
    System.out.println("inpath" + this.path);
    
    updateRowsAndCols(newLocationId);
    initialize();
  }
  public void updateRowsAndCols(int id){
    switch (id){
      case 0:  ROWS = 7; COLS = 5;
      break;
      case 1:  ROWS = 8; COLS = 5;
      break;
      default: ROWS = 7; COLS = 5;
      break;
    }
  }
  
  //GETTERS
  public BufferedImage getSprite(int index){
    return sprites.get(index);
  }
  public BufferedImage getCarSprite(int index){
    return sprites_cars.get(index);
  }
  public int getCarSpritesSize(){
    return sprites_cars.size();
  }
  public int getRows(){
    return ROWS;
  }
  public int getCols(){
    return COLS;
  }

}