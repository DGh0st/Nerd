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

public class AssetsTest extends TestCase{
  @Ignore
  @Test
  public void testAssetsGetSprite(){
    int locationId = 0;
    Assets assets = new Assets(locationId);
    assertEquals(assets.getSprite(0,0),assets.getSprite(0,0));
  }
};                 
                                      
