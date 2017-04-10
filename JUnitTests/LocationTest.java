/*
 *  ~ LocationTest.java
 * Raymond Hruby II
 * 04/09/2017
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
    LocationArray test = LocationArray.getInstance();
    
    assertEquals(test.getCurrentLocation().getWidth(),22);
    assertEquals(test.getCurrentLocation().getHeight(),14);
    
    assertEquals(test.getCurrentLocation().getSpawnX(),10);
    assertEquals(test.getCurrentLocation().getSpawnY(),13);
    
    assertEquals(test.getCurrentLocation().getId(),0);  
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
    LocationArray locations = LocationArray.getInstance(); 
    
    Car test = new Car(0, 0);  
    locations.getCurrentLocation().addMovable(test);
    Car test2 = (Car)locations.getCurrentLocation().getMovable(0);
    
    assertEquals(test,test2);
  }
};                 
                                      
