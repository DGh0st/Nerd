/*
 *  ~Location.java
 * Raymond Hruby II
 * 04/22/2017
 * Location - holds tileCodes and dimension of location
 */
import java.lang.*;
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.awt.*;
import java.util.Collections;
import java.util.Comparator;

//Location class to store data for locations
public abstract class Location implements Drawable
{
  private int id;                  //index for LocationArray, index used for theme(assetLoader)     
  private Position spawn;          //holds spawn location for player
  private String path;             //path to location data in .txt
  private LocationDimension dimensions;
  private int[][] tileCodes;       //holds the tile codes from the location.txt
  private ArrayList<MovableObstacle> movableObstacles;
  private ArrayList<StaticObstacle> staticObstacles;
  protected BufferedImage locationBackgroundImage = null; //drawing buffer 
  protected Position playerPosition;
  private int maxDistance; // for scoreboard
  
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

  public void resetScore() {
    maxDistance = getHeight() - 2;
  }

  public void update() {
    if (locationBackgroundImage == null) {
      locationBackgroundImage = getLocationBuffer();
      resetScore();
      playerPosition = null;
    }

    if (playerPosition != null && maxDistance > playerPosition.getY()) {
      maxDistance = playerPosition.getY();
    }
  }
  public BufferedImage getLocationBuffer(){
    int imageWidth = getWidth() * Tile.TILE_WIDTH;
    int imageHeight = getHeight() * Tile.TILE_HEIGHT;
    return new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
  }
  public int getYBounds(){
    int playerY = getHeight() - 2;
    if (playerPosition != null)
      playerY = playerPosition.getY();
    int y = 0;
    if (playerY <= 10) {
      y = 0;
    }else if (playerY >= getHeight() - 2) {
      y = getHeight() - 12;
    }else {
      y = playerY - 10;
    }
    return y;
  }

  public void drawPlayer(Character player) {
    if (locationBackgroundImage != null) {
      playerPosition = player.getPosition();
      Graphics g2 = locationBackgroundImage.getGraphics();
      
      int startY = getYBounds();
      for(int y = startY; y<startY + 12; y++){
        for(int x=0; x<getWidth(); x++){
          redrawTileAtPos( new Position(x,y), g2 );
        }
      }

      Collections.sort(movableObstacles, new Comparator<MovableObstacle>() {
        @Override
        public int compare(MovableObstacle mo1, MovableObstacle mo2) {
          int diffY = mo1.getPosition().getY() - mo2.getPosition().getY();
          if (diffY == 0) {
            return mo1.getPosition().getX() - mo2.getPosition().getX();
          }
          return diffY;
        }
      });

      boolean didDrawPlayer = false;
      int i = 0, j = 0;
      while (i < movableObstacles.size() && j < staticObstacles.size()) {
        MovableObstacle m = movableObstacles.get(i);
        StaticObstacle s = staticObstacles.get(j);
        if (m.getPosition().getY() > s.getPosition().getY()) {
          if (!didDrawPlayer && playerPosition.getY() < s.getPosition().getY()) {
            player.draw(g2);
            didDrawPlayer = true;
          }

          s.update();
          s.draw(g2);
          j++;
        } else {
          if (!didDrawPlayer && playerPosition.getY() < m.getPosition().getY()) {
            player.draw(g2);
            didDrawPlayer = true;
          }

          m.update();
          m.draw(g2);
          i++;
        }
      }

      for (; i < movableObstacles.size(); i++) {
        MovableObstacle m = movableObstacles.get(i);
        if (!didDrawPlayer && playerPosition.getY() < m.getPosition().getY()) {
          player.draw(g2);
          didDrawPlayer = true;
        }
        m.update();
        m.draw(g2);
      }
      for (; j < staticObstacles.size(); j++) {
        StaticObstacle s = staticObstacles.get(j);
        if (!didDrawPlayer && playerPosition.getY() < s.getPosition().getY()) {
          player.draw(g2);
          didDrawPlayer = true;
        }
        s.update();
        s.draw(g2);
      }
      if (!didDrawPlayer) {
        player.draw(g2);
        didDrawPlayer = true;
      }

      String score = "Score: " + (((getHeight() - 2) - maxDistance) * 10);
      g2.setFont(new Font(Font.SERIF, Font.PLAIN, 32));
      g2.drawString(score, 16, startY * Tile.TILE_HEIGHT + 32);
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
    g.drawImage( locationBackgroundImage, 0, -(getYBounds() * Tile.TILE_HEIGHT), null );
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
      int i = 0;
      while(i<sObs.imageWidth){
      if( (sObs.getPosition().getX()+i == xPos) && sObs.getPosition().getY() == yPos){
        return false; //no go, will collide with current object
      }
      i++;
      }
    }
    return true;     //no collisions, proceed
  }
  
  public void initializeLocation(String path){
    System.out.println("initializeLocation()...");
    System.out.println("  path: " + path);
    this.movableObstacles = new ArrayList<MovableObstacle>();
    this.staticObstacles = new ArrayList<StaticObstacle>();
    
    String mazePath = AssetsLoader.getMazePath(id);
    
    String file = Utilities.loadFileAsString(path);
    String maze = Utilities.loadFileAsString(mazePath); 
    
    int statics = ObjectQuantities.getMaxStatic(id);
    int movables = ObjectQuantities.getMaxMovables(1);
    
    StaticObstacle[] tree;
    StaticObstacle[] sobs;
    MovableObstacle[] car;
    
    tree = new StaticObstacle[statics];
    sobs = new StaticObstacle[1000];
    car = new MovableObstacle[movables];
    
    
    int index = 0;
    
    //FILE PARSING
    //System.out.println("Location | FILE: "+file+"\n");
    String[] tokens = file.split("\\s+");//split on space or newline
    String[] mazeTokens = maze.split("\\s+");//split on space or newline
    
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
    
    //randomized static objects
    for(int i = 0; i<statics; i++){
      int randStaticRange = ThreadLocalRandom.current().nextInt(1, totalStaticRanges*2);
      if(randStaticRange%2 == 0){ randStaticRange-=1;}
      int randY = ThreadLocalRandom.current().nextInt(staticRanges.get(randStaticRange-1), staticRanges.get(randStaticRange));
      int randX = ThreadLocalRandom.current().nextInt(0, width );
      if(randX == getSpawnX() && randY == getSpawnY()){randX = ThreadLocalRandom.current().nextInt(0, width);}
      tree[i] = new Tree(randX,randY);
      addStatic(tree[i]);
    }

      //non-randomized static objects
      int i = 0, j=0;  
      for(int y=0; y<height; y++){
      for(int x=0; x<width; x++){
        if ( Objects.equals(mazeTokens[(x+y*width) + index ],"*") ){
          sobs[i] = new Cone(x,y);
          addStatic(sobs[i]);
          i++;
        }
        if ( Objects.equals(mazeTokens[(x+y*width) + index ],"p") ){
          sobs[i] = new Plant01(x,y);
          addStatic(sobs[i]);
          i++;
        }
        if ( Objects.equals(mazeTokens[(x+y*width) + index ],"f") ){
          sobs[i] = new Plant02(x,y);
          addStatic(sobs[i]);
          i++;
        }
        if ( Objects.equals(mazeTokens[(x+y*width) + index ],"c") ){
          sobs[i] = new CarStatic(x,y);
          addStatic(sobs[i]);
          i++;
        }
      }
    }
      
      System.out.println("i "+i);
    
    for(i = 0; i<movables; i++){
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

    locationBackgroundImage = null;

    Collections.sort(staticObstacles, new Comparator<StaticObstacle>() {
      @Override
      public int compare(StaticObstacle so1, StaticObstacle so2) {
        int diffY = so1.getPosition().getY() - so2.getPosition().getY();
        if (diffY == 0) {
          return so1.getPosition().getX() - so2.getPosition().getX();
        }
        return diffY;
      }
    });
  }
}
