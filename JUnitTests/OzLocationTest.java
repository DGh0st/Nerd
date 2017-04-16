/*
 *  ~ OzLocationTest.java
 * Raymond Hruby II
 * 04/09/2017
 */

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
import junit.framework.TestCase;

import java.util.ArrayList;

public class OzLocationTest extends TestCase{
  
  @Test
  @Ignore
  public void testOzLocationRanges(){
    LocationArray testArray = LocationArray.getInstance();
    
    ArrayList<Integer> range1Test = new ArrayList<Integer>();
    range1Test.add(0);
    range1Test.add(3);
    
    //cannot grab getStaticRange()
    ArrayList range = testArray.getCurrentLocation().getStaticRanges();
    
    assertEquals( range.get(0),range1Test.get(0) );
  }
  
  
}