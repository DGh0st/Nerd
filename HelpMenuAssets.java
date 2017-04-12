/**
 * HelpMenuAssets.java
 * Deep Patel
 * 04/11/2017
 * HelpMenuAssets class holds sprite images for the help menu
 */

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class HelpMenuAssets
{
  private static final int WIDTH=512, HEIGHT=144, ROWS=5, COLS=1;
  private static final String PRESSESPATH="./resources/menus/HelpMenuPressesSpriteSheet.png";
  
  private static HelpMenuAssets instance = null;

  private ArrayList<BufferedImage> sprites;

  private HelpMenuAssets() {
    SpriteSheet sheet = new SpriteSheet(PRESSESPATH);
    sprites = new ArrayList<BufferedImage>(ROWS * COLS);
    
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        sprites.add(sheet.crop(j * WIDTH, i * HEIGHT, WIDTH, HEIGHT));
      }
    }
  }

  public static HelpMenuAssets getInstance() {
    if (instance == null) {
      instance = new HelpMenuAssets();
    }
    return instance;
  }
  
  public BufferedImage getSprite(int index) {
    return sprites.get(index);
  }
}