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
    locations[0] = loc01;
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
  public Location getCurrentLocation(){ //return Location
    return locations[currentLocation];
  }
  public void setCurrentLocation(int id){
    currentLocation = id;
  }
  public int getCurrentLocationIndex(){
    return currentLocation;
  }
  public void updateCurrentLocation(){
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

