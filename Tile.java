/**
 * ~ Tile.java
 * Raymond Hruby II
 * 03/31/2017
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
  public static Tile grass02Tile = new Tile(Assets.getInstance().getSprite(6),6); 
  public static Tile grass03Tile = new Tile(Assets.getInstance().getSprite(7),7);
  public static Tile trail01Tile = new Tile(Assets.getInstance().getSprite(8),8);
  public static Tile trail02Tile = new Tile(Assets.getInstance().getSprite(9),9);
  public static Tile rock01Tile = new Tile(Assets.getInstance().getSprite(10),10);
  public static Tile rock02Tile = new Tile(Assets.getInstance().getSprite(11),11);
  public static Tile road01Tile = new Tile(Assets.getInstance().getSprite(15),15);
  public static Tile road02Tile = new Tile(Assets.getInstance().getSprite(16),16);
  
  public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
  /*
  public static BufferedImage getImage(int id){
    return tiles.get(id).sprite;
  }
  public static Tile getTile(int id){
    return tiles.get(id);
  }
  */ 
  private int id;
  BufferedImage sprite;
  
  public Tile(BufferedImage sprite, int id){
    this.id=id;
    this.sprite = sprite;
    
    tiles[id]= this;
    //tiles.add(id,this);
  }
  
  public void update(){}
  
  public void draw(Graphics g, int x, int y){
    //g.drawImage( tiles.get(id).sprite, x, y, TILE_WIDTH, TILE_HEIGHT, null ); 
    g.drawImage(tiles[id].sprite, x, y, TILE_WIDTH, TILE_HEIGHT, null); 
    //g.drawImage(Assets.getInstance().getSprite(id), x, y, TILE_WIDTH, TILE_HEIGHT, null);
  }

  //getters and setters
  public int getId(){
    return id;
  }
    
}
