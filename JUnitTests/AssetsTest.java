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

import java.awt.image.BufferedImage;

public class AssetsTest extends TestCase{
  @Ignore
  @Test
  public void testAssetsAsSingleton(){
    LocationArray locations = LocationArray.getInstance();
    
    Assets test = Assets.getInstance(); //needs LocationArray instance to grab location index
    Assets test2 = Assets.getInstance();
    
    assertEquals(test,test2); //should be equal as returns same instance if already called
  }
    
  @Ignore
  @Test
  public void testAssetsStaticSprites(){

  }
  
  @Ignore
  @Test
  public void testAssetsGetSprite(){
    LocationArray locations = LocationArray.getInstance();
    
    Assets assets =Assets.getInstance();
    assertEquals(assets.getSprite(0),assets.getSprite(0));
  }
};                 
                                      
