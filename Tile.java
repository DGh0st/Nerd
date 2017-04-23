/**
 * ~ Tile.java
 * Raymond Hruby II
 * 04/22/2017
 * Tile solidifies tileId to a sprite image
 */
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.ArrayList;

public class Tile
{
  //indexes based on location on spritesheet
  public static Tile[] tiles = new Tile[50];
  //public static ArrayList<Tile> tiles = new ArrayList<Tile>(50);
  
  public static Tile grass01Tile = new Tile(Assets.getInstance().getSprite(5),5); 
  public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;

  private int id;
  BufferedImage sprite;
  
  public Tile(){
    initializeArray();
  }
  
  public Tile(BufferedImage sprite, int id){
    this.id=id;
    this.sprite = sprite;
    
    tiles[id]= this;
  }
  
  public void initializeArray(){
    System.out.println("INITIALIZING ARRAY");
    
    int totalRange = Assets.getInstance().getRows() * Assets.getInstance().getCols();
    
    for(int i = 0; i<50; i++){
      try{
        Tile newTile = new Tile(Assets.getInstance().getSprite(i),i);
      }catch(Exception e){ //might be out of bounds since is not >50
        Tile newTile = new Tile(Assets.getInstance().getSprite(0),i);
      }
    }
  }
  
  public void update(){}
  
  public void draw(Graphics g, int x, int y){
    //g.drawImage( tiles.get(id).sprite, x, y, TILE_WIDTH, TILE_HEIGHT, null ); 
    //g.drawImage(tiles[id].sprite, x, y, TILE_WIDTH, TILE_HEIGHT, null); 
    g.drawImage(Assets.getInstance().getSprite(id), x, y, TILE_WIDTH, TILE_HEIGHT, null);
  }

  //getters and setters
  public int getId(){
    return id;
  }
    
}
