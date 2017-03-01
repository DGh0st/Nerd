import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
import junit.framework.TestCase;
 
public class NerdTester extends TestCase{
  @Ignore
  @Test
  //LOCATION | DIMENSION
  public void testLocation(){
    Location test = new Location("",0,50,50);
    assertEquals(test.getWidth(),50);
  }
  
  @Ignore
  @Test
  //LOCATION ARRAY | TOTAL | ADDLOCATION 
  public void testLocationArray(){
    LocationArray locations = new LocationArray(5);    
    assertEquals(locations.getTotal(),5);
    assertEquals(locations.getLocation(0),null);
  }
};                 
                                      