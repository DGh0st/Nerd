/*
 *  ~ NerdTester.java
 * Raymond Hruby II
 * 03/06/2017
 * Description: tester to collectively and extensively test each class 
 */

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
import junit.framework.TestCase;

public class LocationTest extends TestCase{
  @Ignore
  @Test
  //LOCATION | DIMENSION
  public void testLocationGetters(){
    Location test = new Location("",0,50,60);
    assertEquals(test.getWidth(),50);
    assertEquals(test.getHeight(),60);
    assertEquals(test.getId(),0);  
  }
  
  @Ignore
  @Test
  //LOCATION ARRAY | TOTAL | LOCATIONINDEX 
  public void testLocationArray(){
    LocationArray locations = new LocationArray(5);    
    assertEquals(locations.getTotal(),5);
    assertEquals(locations.getLocation(0),null);
  }
  
  @Ignore
  @Test
  //LOCATION ARRAY | TOTAL | LOCATIONINDEX 
  public void testLocationInsertion(){
    LocationArray locations = new LocationArray(6);    
    assertEquals(locations.getLocation(0),null);
    
    //Location test = new Location("",0,50,50);
    //locations.addLocation(test);
    //assertEquals(locations.getLocation(0),test);
  }
};                 
                                      
