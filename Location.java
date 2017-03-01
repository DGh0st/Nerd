/*
 *  ~Location.java
 *
 * Raymond Hruby II
 */

import java.awt.Graphics;

//TODO: - implement string parser to get dimensions from location.txt file 
  
//Location class to store data for locations
public class Location
{
  private int id;                  //index for LocationList, index used for theme     
  private LocationDimension dimensions;
  private String path;             //path to location data in .txt
  
  public Location(String path, int id,int width, int height){
    //this.name = name;
    this.id = id;
    dimensions = new LocationDimension(width,height);
    createWorld(path);
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
    
  }
  public void draw(Graphics g){
    
  }
  
  public void createWorld(String path){
    //get data from location.txt file
    //get dimensions here
  }
}
