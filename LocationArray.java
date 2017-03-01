public class LocationArray
{
  private int totalLocations;
  private Location[] locations;
  
  LocationArray(int totalLocations){
    this.totalLocations = totalLocations;
    locations = new Location[totalLocations];
  }
  
  public int getTotal(){
    return totalLocations;
  }
  public Location getLocation(int index){
    return locations[index];
  }
  public void addLocation(Location location){
    locations[location.getId()]=location;
  }
}