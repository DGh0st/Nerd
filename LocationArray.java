/*
 *  ~LocationArray.java
 * Raymond Hruby II
 * 03/30/2017
 * LocationArray, holds Locations and defines currentLocation
 */
import java.util.ArrayList;

public class LocationArray
{
  private static LocationArray instance = null;
  private int totalLocations;
  private Location[] locations;
  private int currentLocation;
  
  public static LocationArray getInstance() {
    if (instance == null) {
      instance = new LocationArray(7);
    }
    return instance;
  }
  
  private LocationArray(int totalLocations){
    this.totalLocations = totalLocations;
    locations = new Location[totalLocations];
    
    //currentLocation defaulted to index 0
    OzLocation loc01 = new OzLocation(0);
    AlphaLocation loc02 = new AlphaLocation(1);
    locations[0] = loc01;
    locations[1] = loc02;
    currentLocation = 0;
  }
  
  //GETTERS AND SETTERS
  public int getTotal(){
    return totalLocations;
  } 
  public Location getLocationAtIndex(int index){
    return locations[index];
  }
  public void setLocationAtIndex(Location location){
    locations[location.getId()]=location;
  }
  
  //CURRENT LOCATION GETTERS AND SETTERS
  public int getCurrentSpawnX(){
    return locations[currentLocation].getSpawnX();
  }
  public int getCurrentSpawnY(){
    return locations[currentLocation].getSpawnY();
  }
  public Location getCurrentLocation(){
    return locations[currentLocation];
  }
  public void incrementCurrentLocation(){ //call if changing location
    if(currentLocation > 0){ //since we only have two levels setup, will repeat levels
      currentLocation = -1;  //adds one on next line (=0)
    }
    currentLocation += 1;
    
    Assets.getInstance().update();
  }
  public int getCurrentLocationIndex(){
    return currentLocation;
  }
  public void updateCurrentLocation(){
    //not implemented in specific locations
    locations[currentLocation].update();
  }
  public void drawCurrentLocation(){
    locations[currentLocation].draw();
  }
  
  /* ACCESS OBSTACLES THROUGH locations.getCurrentLocation(); */

  //OBSTACLE LISTS
  public ArrayList<MovableObstacle> getMovableObstacles(){
    return locations[currentLocation].getMovableObstacles();
  }
  public ArrayList<StaticObstacle> getStaticObstacles(){
    return locations[currentLocation].getStaticObstacles();
  }
}

