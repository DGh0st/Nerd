/*
 *  ~Location.java
 * Raymond Hruby II
 * 04/18/2017
 * Location - holds tileCodes and dimension of location
 * 
 * TODO: Getting ranges from methods
 */
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.image.BufferedImage;

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
  protected BufferedImage locationBackgroundImage = null; //drawing buffer 
  protected Position playerPosition;
  
  private int totalStaticRanges;
  private int totalMovableRanges;
  protected ArrayList<Integer> staticRanges;
  protected ArrayList<Integer>movableRanges;
  
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
        redrawTileAtPos( new Position(x,y), g2 );
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
      playerPosition = player.getPosition();
    }
  }

  public void redrawTileAtPos(Position pos, Graphics g) {
    int x = pos.getX();
    int y = pos.getY();
    
    int tileId = getTile(x,y).getId();
    //System.out.println("TILE ID: "+ tileId);
    
    getTile(x, y).draw(g, (int)(x*Tile.TILE_WIDTH), (int)(y*Tile.TILE_HEIGHT));
    //g.drawImage(Assets.getInstance().getSprite(tileId), x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT, null);
    //Assets.getInstance().getSprite(tileId).draw(g, (int)(x*Tile.TILE_WIDTH), (int)(y*Tile.TILE_HEIGHT));
  }
  
  public void draw() {
    draw(GameState.getInstance().getGraphics());
  }

  public void draw(Graphics g) {
    if (locationBackgroundImage == null) {
      return;
    }
    int playerY = playerPosition.getY();
    int y = 0;
    if (playerY <= 10) {
      y = 0;
    }else if (playerY >= getHeight() - 2) {
      y = getHeight() - 12;
    }else {
      y = playerY - 10;
    }
    g.drawImage( locationBackgroundImage, 0, -(y * Tile.TILE_HEIGHT), null );
  }
  
  //GETTERS AND SETTERS
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
  public int getTotalStaticRanges(){
    return totalStaticRanges;
  }
  public int getTotalMovableRanges(){
    return totalMovableRanges;
  }
  public ArrayList<Integer> getStaticRanges(){
    return staticRanges;
  }
  public ArrayList<Integer> getMovableRanges(){
    return movableRanges;
  }
  
  //TILES
  public Tile getTile(int x, int y){
    //protection against going outside boundary(glitches)
    if(x<0 || y<0 || x>=dimensions.getWidth() || y>=dimensions.getHeight()){
      return Tile.grass01Tile;
    }
    int tileCode = tileCodes[x][y];
    Tile t = Tile.tiles[ tileCode ];
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
  
  //BOUNDS CHECKING
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
    System.out.println("initializeLocation()...");
    System.out.println("  path: " + path);
    this.movableObstacles = new ArrayList<MovableObstacle>();
    this.staticObstacles = new ArrayList<StaticObstacle>();
    
    String file = Utilities.loadFileAsString(path);
    int statics = ObjectQuantities.getMaxStatic(id);
    int movables = ObjectQuantities.getMaxMovables(1);
    
    StaticObstacle[] tree;
    StaticObstacle[] cone;
    MovableObstacle[] car;
    tree = new StaticObstacle[statics];
    cone = new StaticObstacle[statics];
    car = new MovableObstacle[movables];
    
    int index = 0;
    
    //FILE PARSING
    //System.out.println("Location | FILE: "+file+"\n");
    String[] tokens = file.split("\\s+");//split on space or newline
    
    int width = Utilities.parseInt(tokens[0]);   
    int height = Utilities.parseInt(tokens[1]);
    dimensions = new LocationDimension(width,height);
    tileCodes = new int[width][height];
    System.out.println("width: " + width);
    System.out.println("height: " + height);
    
    int spawnX = Utilities.parseInt(tokens[2]);
    int spawnY = Utilities.parseInt(tokens[3]);
    spawn = new Position(spawnX, spawnY);
    
    staticRanges = new ArrayList<Integer>();
    movableRanges = new ArrayList<Integer>();
    
    totalStaticRanges = Utilities.parseInt(tokens[4]);
    totalMovableRanges = Utilities.parseInt(tokens[5]);
    System.out.println("totalStaticRanges: " + totalStaticRanges);
    System.out.println("totalMovableRanges: " + totalMovableRanges);
    
    for(int i = 0; i<totalStaticRanges*2; i++){  //start 6 | end 11
      staticRanges.add( Utilities.parseInt(tokens[6+i]) ); 
    }
    index = 6 + (totalStaticRanges*2); //12
   
    for(int i = 0; i<totalMovableRanges*2; i++){ //start 12 | end 15
      movableRanges.add( Utilities.parseInt(tokens[index+i]) );
    }   
    index = index + totalMovableRanges*2; //16
    System.out.println("index: " + index);
    //System.out.println(statics);
    
    for(int i = 0; i<statics; i++){
      int randStaticRange = ThreadLocalRandom.current().nextInt(1, totalStaticRanges*2);
      if(randStaticRange%2 == 0){ randStaticRange-=1;}
      int randY = ThreadLocalRandom.current().nextInt(staticRanges.get(randStaticRange-1), staticRanges.get(randStaticRange));
      int randX = ThreadLocalRandom.current().nextInt(0, width );
      if(randX == getSpawnX() && randY == getSpawnY()){randX = ThreadLocalRandom.current().nextInt(0, width);}
      tree[i] = new Tree(randX,randY);
      addStatic(tree[i]);
    }
    
    for(int i = 0; i<statics; i++){
      //TODO
      //cone[i] = new Cone(randX,randY);
      //addStatic(cone[i]);
    }
    
    for(int i = 0; i<movables; i++){
      int randMovableRange = ThreadLocalRandom.current().nextInt(1, totalMovableRanges*2);
      if(randMovableRange%2 == 0){ randMovableRange-=1;}
      int randX = ThreadLocalRandom.current().nextInt(width, width+64);
      int randY = ThreadLocalRandom.current().nextInt(movableRanges.get(randMovableRange-1), movableRanges.get(randMovableRange));
      car[i] = new Car(randX, randY);
      car[i].setSpeed(ObjectQuantities.getSpeed(id));
      addMovable(car[i]);
    }
    
    int tile;
    for(int y=0; y<height; y++){
      for(int x=0; x<width; x++){
        //add index because of previous set values 
        tile = Utilities.parseInt( tokens[(x+y*width) + index] );                           
        tileCodes[x][y] = tile;
      }
    }
  }
}
