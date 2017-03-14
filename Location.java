/*
 *  ~Location.java
 * Raymond Hruby II
 * 03/13/2017
 * Location - holds tileCodes and dimension of location
 */
import java.util.List;
import java.awt.Graphics;

//TODO: - implement string parser to get dimensions from location.txt file 
  
//Location class to store data for locations
public abstract class Location implements Drawable
{
  private int id;                  //index for LocationArray, index used for theme(assetLoader)     
  private int spawnX,spawnY;
  private String path;             //path to location data in .txt
  private LocationDimension dimensions;
  private int[][] tileCodes;       //holds the tile codes from the location.txt
  private List<MovableObstacle> moveableObjects;
  private List<StaticObstacle> staticObjects;
  
  public Location(int locationId){
    ///grabbing width and height from location.txt files in createLocation()
    this.id = locationId; 
    this.path = AssetsLoader.getLocationPath(locationId);
    initializeLocation(path);
  }
  
  abstract public void update();
  abstract public void draw();
  
  //getters and setters below:
  public String getPath(){
    return this.path;
  }
  public int getId(){
    return this.id;
  }
  
  public int getWidth(){
    return this.dimensions.getWidth();
  } 
  public int getHeight(){
    return this.dimensions.getHeight();
  }
  public int getSpawnX(){
    return this.spawnX;
  }
  public int getSpawnY(){
    return this.spawnY;
  }
  public Tile getTile(int x, int y){
    //protection against going outside boundary(glitches)
    if(x<0 || y<0 || x>=dimensions.getWidth() || y>=dimensions.getHeight()){
      return Tile.grass01Tile;
    }
    
    Tile t = Tile.tiles[ tileCodes[x][y] ];
    if(t==null){  //default to grassTile if error occured
      return Tile.grass01Tile;
    }
    return t;
  }
  
  public boolean canMoveToPosition(int xPos, int yPos){   
    //check bounds    
    return checkBounds(xPos, yPos);
  }
  public boolean checkBounds(int xPos, int yPos){
    return (xPos>0 && xPos<dimensions.getWidth())&&(yPos>0 && yPos<dimensions.getHeight());
  }
 
  public void initializeLocation(String path){
    String file = Utilities.loadFileAsString(path);
    //System.out.println("Location | FILE: "+file+"\n");
    String[] tokens = file.split("\\s+");//split on space or newline
    
    int width = Utilities.parseInt(tokens[0]);
    int height = Utilities.parseInt(tokens[1]);
    dimensions = new LocationDimension(width,height);
    
    spawnX = Utilities.parseInt(tokens[2]);
    spawnY = Utilities.parseInt(tokens[3]);
    
    tileCodes = new int[width][height];
    
    for(int y=0; y<height; y++){
      for(int x=0; x<width; x++){
        tileCodes[x][y] = Utilities.parseInt( tokens[(x+y*width)+4] ); //add 4 becuase of previous set values (four values)                                          
      }
    }
  }
}
