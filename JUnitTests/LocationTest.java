/*
 *  ~ NerdTester.java
 * Raymond Hruby II
 * 03/30/2017
 * Description: tester to collectively and extensively test each class 
 */

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
import junit.framework.TestCase;

public class LocationTest extends TestCase{
  //LOCATION
  @Ignore
  @Test
  public void testLocationGetters(){
    OzLocation test = new OzLocation(0);
    
    assertEquals(test.getWidth(),22);
    assertEquals(test.getHeight(),14);
    
    assertEquals(test.getSpawnX(),10);
    assertEquals(test.getSpawnY(),13);
    
    assertEquals(test.getId(),0);  
  }
  
  //LOCATION ARRAY
  @Ignore
  @Test
  public void testLocationArrayAsSingleton(){
    LocationArray test = LocationArray.getInstance();
    LocationArray test2 = LocationArray.getInstance();
    
    assertEquals(test,test2);
  }
  
  @Ignore
  @Test
  public void testLocationArrayGettersAndSetters(){
    LocationArray locations = LocationArray.getInstance();
    
    int spawnX = locations.getCurrentSpawnX();
    int spawnY = locations.getCurrentSpawnY();
    int spawnX2 = locations.getCurrentLocation().getSpawnX();
    int spawnY2 = locations.getCurrentLocation().getSpawnY();
    assertEquals(spawnX,spawnX2);
    assertEquals(spawnY2,spawnY2);
  }
  
  @Ignore
  @Test
  public void testLocationWithObstacles(){
    LocationArray locations = new LocationArray(7); 
    
    Car test = new Car(0, 0);  
    locations.getCurrentLocation().addMovable(test);
    Car test2 = (Car)locations.getCurrentLocation().getMovable(0);
    
    assertEquals(test,test2);
  }
};                 
                                      
