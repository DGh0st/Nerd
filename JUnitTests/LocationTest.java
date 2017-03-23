/*
 *  ~ NerdTester.java
 * Raymond Hruby II
 * 03/22/2017
 * Description: tester to collectively and extensively test each class 
 */

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
import junit.framework.TestCase;

public class LocationTest extends TestCase{
  
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
  
  @Ignore
  @Test
  public void testLocationObstacles(){
    LocationArray locations = new LocationArray(6); 
    
    Car test = new Car(0, 0);  
    locations.getCurrentLocation().addMovable(test);
    Car test2 = (Car)locations.getCurrentLocation().getMovable(0);
    
    assertEquals(test,test2);
  }
  /*
  @Ignore
  @Test
  //LOCATION ARRAY | TOTAL | LOCATIONINDEX 
  public void testLocationArray(){
    LocationArray locations = new LocationArray(7);    
    assertEquals(locations.getTotal(),7);
    //assertEquals(locations.getCurrentLocation(),null);
  }
  
  @Ignore
  @Test
  //LOCATION ARRAY | TOTAL | LOCATIONINDEX 
  public void testLocationInsertion(){
    LocationArray locations = new LocationArray(7);    
    //assertEquals(locations.getCurrentLocation());
    
    //Location test = new Location("",0,50,50);
    //locations.addLocation(test);
    //assertEquals(locations.getLocation(0),test);
  }
  */
};                 
                                      
