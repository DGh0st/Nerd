/**
 * AllMenuAssets.java
 * Deep Patel
 * 04/08/2017
 * AllMenuAssets class holds sprite images for the all menus but main
 */

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AllMenuAssets
{
  private static final int WIDTH=448, HEIGHT=64, ROWS=4, COLS=1;
  private static final String PATH="./resources/menus/AllMenuSpriteSheet.png";
  
  private static AllMenuAssets instance = null;

  private ArrayList<BufferedImage> sprites;

  private AllMenuAssets() {
    SpriteSheet sheet = new SpriteSheet(PATH);
    sprites = new ArrayList<BufferedImage>(ROWS * COLS);
    
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        sprites.add(sheet.crop(j * WIDTH, i * HEIGHT, WIDTH, HEIGHT));
      }
    }
  }

  public static AllMenuAssets getInstance() {
    if (instance == null) {
      instance = new AllMenuAssets();
    }
    return instance;
  }
  
  public BufferedImage getSprite(int index) {
    return sprites.get(index);
  }
}