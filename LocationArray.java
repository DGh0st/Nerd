public class LocationArray
{
  private static LocationArray instance = null;
  private int totalLocations;
  private Location[] locations;
  private int currentLocation;
  
  LocationArray(int totalLocations){
    this.totalLocations = totalLocations;
    locations = new Location[totalLocations];
    
    //currentLocation defaulted to index 0
    OzLocation loc01 = new OzLocation(0);
    locations[0] = loc01;
    currentLocation = 0;
  }
  public static LocationArray getInstance() {
    if (instance == null) {
      instance = new LocationArray(7);
    }
    return instance;
  }
  
  public int getTotal(){
    return totalLocations;
  }
  
  public int getCurrentSpawnX(){
    return locations[currentLocation].getSpawnX();
  }
  public int getCurrentSpawnY(){
    return locations[currentLocation].getSpawnY();
  }
  
  public Location getLocationAtIndex(int index){
    return locations[index];
  }
  public void setLocationAtIndex(Location location){
    locations[location.getId()]=location;
  }
  public Location getCurrentLocation(){ //return Location
    //not yet implemented
    return locations[currentLocation];
  }
  public void setCurrentLocation(int id){
    //not yet implemented
    currentLocation = id;
  }
  public void updateCurrentLocation(){
    //not yet implemented
    locations[currentLocation].update();
  }
  public void drawCurrentLocation(){
    //not yet implemented
    locations[currentLocation].draw();
  }
}