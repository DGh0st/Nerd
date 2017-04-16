/*
 *  ~ HelpAssetsTest.java
 * Deep Patel
 * 04/16/2017
 * test cases for HelpAssets class
 */

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
import junit.framework.TestCase;

import java.awt.image.BufferedImage;
import java.awt.event.*;

public class HelpAssetsTest extends TestCase{
  @Test
  public void testAssetsAsSingleton(){    
    HelpAssets test = HelpAssets.getInstance();
    HelpAssets test2 = HelpAssets.getInstance();
    
    assertEquals(test,test2);
  }
  
  @Test
  public void testAssetsGetSprite(){
    HelpAssets assets = HelpAssets.getInstance();

    assertEquals(assets.getSprite(0), assets.getSprite(0));
  }

  @Test
  public void testAssetsGetCurrentSprite() {
    HelpAssets assets = HelpAssets.getInstance();

    assertEquals(assets.getSprite(0), assets.getCurrentSprite());
    assets.updateCurrentSprite(KeyEvent.VK_UP);
    assertEquals(assets.getSprite(1), assets.getCurrentSprite());
  }
};                 
                                      
