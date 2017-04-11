/*
 *  ~ LocationTest.java
 * Raymond Hruby II
 * 04/09/2017
 */


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Test;
import org.junit.Ignore;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;

public class LocationTest{
  //LOCATION
  @Test
  public void testLocationGetters(){
    LocationArray test = LocationArray.getInstance();
    
    assertEquals(test.getCurrentLocation().getWidth(),22);
    assertEquals(test.getCurrentLocation().getHeight(),22);
    
    assertEquals(test.getCurrentLocation().getSpawnX(),10);
    assertEquals(test.getCurrentLocation().getSpawnY(),13);
    
    assertEquals(test.getCurrentLocation().getId(),0);  
  }
  
  //LOCATION ARRAY
  @Test
  public void testLocationArrayAsSingleton(){
    LocationArray test = LocationArray.getInstance();
    LocationArray test2 = LocationArray.getInstance();
    
    assertEquals(test,test2);
  }
  
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
};                 
                                      
