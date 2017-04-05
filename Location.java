/*
 *  ~Location.java
 * Raymond Hruby II
 * 04/02/2017
 * Location - holds tileCodes and dimension of location
 * 
 * TODO: Checkbounds back to location height and width, 
 */
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.image.BufferedImage;

//TODO: - implement string parser to get dimensions from location.txt file 
  
//Location class to store data for locations
public abstract class Location implements Drawable
{
  private int id;                  //index for LocationArray, index used for theme(assetLoader)     
  private Position spawn;
  private String path;             //path to location data in .txt
  private LocationDimension dimensions;
  private int[][] tileCodes;       //holds the tile codes from the location.txt
  private ArrayList<MovableObstacle> movableObstacles;
  private ArrayList<StaticObstacle> staticObstacles;
  private BufferedImage locationBackgroundImage = null;
  
  public Location(int locationId){
    ///grabbing width and height from location.txt files in createLocation()
    this.id = locationId; 
    this.path = AssetsLoader.getLocationPath(locationId);

    initializeLocation(path);
  }
  
  public void update() {
    int imageWidth = getWidth() * Tile.TILE_WIDTH;
    int imageHeight = getHeight() * Tile.TILE_HEIGHT;
    locationBackgroundImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
    Graphics g2 = locationBackgroundImage.getGraphics();
    for(int y=0; y<getHeight(); y++){
      for(int x=0; x<getWidth(); x++){
        //FROM TILES
        redrawTileAtPos(new Position(x, y), g2);
      }
    }

    for(MovableObstacle m: movableObstacles){
      m.update();
      m.draw(g2);
    }
    for(StaticObstacle s: staticObstacles){
      s.update();
      s.draw(g2);
    }
  }

  public void drawPlayer(Character player) {
    if (locationBackgroundImage != null) {
      Graphics g2 = locationBackgroundImage.getGraphics();
      player.draw(g2);
    }
  }

  public void redrawTileAtPos(Position pos, Graphics g) {
    int x = pos.getX();
    int y = pos.getY();

    getTile(x, y).draw(g, (int)(x*Tile.TILE_WIDTH), (int)(y*Tile.TILE_HEIGHT));
  }
  
  public void draw() {
    draw(GameState.getInstance().getGraphics());
  }

  public void draw(Graphics g) {
    if (locationBackgroundImage == null) {
      return;
    }
    g.drawImage(locationBackgroundImage, 0, 0, null);
  }
  
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
    return this.spawn.getX();
  }
  public int getSpawnY(){
    return this.spawn.getY();
  }
  public Position getSpawn() {
    return spawn;
  }
  
  //TILES
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
  public int getTileCode(int x,int y){
    return tileCodes[x][y];
  }
  
  //OBSTACLES
  public void addMovable(MovableObstacle obstacle){
    movableObstacles.add(obstacle);
  }
  public void addStatic(StaticObstacle obstacle){
    staticObstacles.add(obstacle);
  } 
  public MovableObstacle getMovable(int index){
    return movableObstacles.get(index);
  }
  public StaticObstacle getStatic(int index){
    return staticObstacles.get(index);
  }
  //OBSTACLES LISTS
  public ArrayList<MovableObstacle> getMovableObstacles(){
    return movableObstacles;
  }
  public ArrayList<StaticObstacle> getStaticObstacles(){
    return staticObstacles;
  }
  
  public boolean canMoveToPosition(int xPos, int yPos){       
    boolean checkBounds = checkBounds(xPos, yPos);
    //boolean checkMovables = checkMovables(xPos, yPos);
    boolean checkStatics = checkStatics(xPos, yPos);
    
    return checkBounds && /*checkMovables &&*/ checkStatics;
  }
  public boolean checkBounds(int xPos, int yPos){
    return (xPos>=0 && xPos<dimensions.getWidth())&&(yPos>=0 && yPos<dimensions.getHeight());
  }
  public boolean checkMovables(int xPos, int yPos){
    for( MovableObstacle mObs : movableObstacles ){
      if( mObs.getPosition().getX() == xPos && mObs.getPosition().getY() == yPos){
        return false; //no go, will collide with current object
      }
    }
    return true;     //no collisions, proceed
  }
  public boolean checkStatics(int xPos, int yPos){
    for( StaticObstacle sObs : staticObstacles ){
      if( sObs.getPosition().getX() == xPos && sObs.getPosition().getY() == yPos){
        return false; //no go, will collide with current object
      }
    }
    return true;     //no collisions, proceed
  }

  public void initializeLocation(String path){
    this.movableObstacles = new ArrayList<MovableObstacle>();
    this.staticObstacles = new ArrayList<StaticObstacle>();
    
    String file = Utilities.loadFileAsString(path);
    int statics = ObjectQuantities.getMaxStatic(id);
    int movables = ObjectQuantities.getMaxMovables(1);
    
    StaticObstacle[] tree;
    MovableObstacle[] car;
    tree = new StaticObstacle[statics];
    car = new MovableObstacle[movables];
    //System.out.println("Location | FILE: "+file+"\n");
    String[] tokens = file.split("\\s+");//split on space or newline
    
    int width = Utilities.parseInt(tokens[0]);   
    int height = Utilities.parseInt(tokens[1]);
    dimensions = new LocationDimension(width,height);
    
    int spawnX = Utilities.parseInt(tokens[2]);
    int spawnY = Utilities.parseInt(tokens[3]);
    spawn = new Position(spawnX, spawnY);
    
    tileCodes = new int[width][height];
    
    //System.out.println(statics);
    
    for(int i = 0; i<statics; i++){
      int randX = ThreadLocalRandom.current().nextInt(0, 22);
      int randY = ThreadLocalRandom.current().nextInt(0, 12);
      if(randY <4){randY = ThreadLocalRandom.current().nextInt(0, 2);}
      else{randY = ThreadLocalRandom.current().nextInt(9, 11);}
      if(randX == 10 && randY == 10){randX = ThreadLocalRandom.current().nextInt(0, 22);}
      tree[i] = new Tree(randX,randY);
      addStatic(tree[i]);
    }
    
    for(int i = 0; i<movables; i++){
      car[i] = new Car((ThreadLocalRandom.current().nextInt(22, 32)),(ThreadLocalRandom.current().nextInt(3, 8)));
      car[i].setSpeed(ObjectQuantities.getSpeed(id));
      addMovable(car[i]);
    }

    for(int y=0; y<height; y++){
      for(int x=0; x<width; x++){
        //add 4 becuase of previous set values (four values)
        tileCodes[x][y] = Utilities.parseInt( tokens[(x+y*width)+4] );
      }
    }
  }
}
