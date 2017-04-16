/*
 *  ~ AllMenuAssetsTest.java
 * Deep Patel
 * 04/15/2017
 * test cases for AllMenuAssets class
 */

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
import junit.framework.TestCase;

import java.awt.image.BufferedImage;

public class AllMenuAssetsTest extends TestCase{
  @Test
  public void testAssetsAsSingleton(){    
    AllMenuAssets test = AllMenuAssets.getInstance();
    AllMenuAssets test2 = AllMenuAssets.getInstance();
    
    assertEquals(test,test2);
  }
  
  @Test
  public void testAssetsGetSprite(){
    AllMenuAssets assets = AllMenuAssets.getInstance();

    assertEquals(assets.getSprite(0), assets.getSprite(0));
  }
};                 
                                      
