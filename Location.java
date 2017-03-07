/*
 *  ~Location.java
 * Raymond Hruby II
 * 03/06/2017
 * Location - holds tileCodes and dimension of location
 */

import java.awt.Graphics;

//TODO: - implement string parser to get dimensions from location.txt file 
  
//Location class to store data for locations
public class Location
{
  private int id;                  //index for LocationArray, index used for theme(assetLoader)     
  private LocationDimension dimensions;
  private String path;             //path to location data in .txt
  private int tileCodes[][];       //holds the tile codes from the location.txt
  
  public Location(String path, int id,int width, int height){
    //this.name = name;
    this.id = id;
    dimensions = new LocationDimension(width,height);
    createLocation(path);
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
  
  public void update(){
    //not yet implemented
  }
  public void draw(Graphics g){
    //not yet implemented
  }
  
  public void createLocation(String path){
    //get data from location.txt file
    //get dimensions here
    
    //not yet implemented
  }
}
