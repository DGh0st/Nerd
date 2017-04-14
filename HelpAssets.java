/**
 * HelpAssets.java
 * Deep Patel
 * 04/11/2017
 * HelpAssets class holds sprite images for the help 
 */

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*;

public class HelpAssets
{
  private static final int WIDTH=512, HEIGHT=144, ROWS=5, COLS=1;
  private static final String PRESSESPATH="./resources/menus/HelpPressesSpriteSheet.png";
  
  private static HelpAssets instance = null;

  private ArrayList<BufferedImage> sprites;
  private BufferedImage currentSprite;

  private HelpAssets() {
    SpriteSheet sheet = new SpriteSheet(PRESSESPATH);
    sprites = new ArrayList<BufferedImage>(ROWS * COLS);
    
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        sprites.add(sheet.crop(j * WIDTH, i * HEIGHT, WIDTH, HEIGHT));
      }
    }

    currentSprite = sprites.get(0);
  }

  public static HelpAssets getInstance() {
    if (instance == null) {
      instance = new HelpAssets();
    }
    return instance;
  }
  
  public BufferedImage getSprite(int index) {
    return sprites.get(index);
  }

  public BufferedImage getCurrentSprite() {
    return currentSprite;
  }

  public void updateCurrentSprite(int keyCode) {
    if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
      currentSprite = sprites.get(1);
    } else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
      currentSprite = sprites.get(3);
    } else if (keyCode ==KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
      currentSprite = sprites.get(2);
    } else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
      currentSprite = sprites.get(4);
    } else {
      currentSprite = sprites.get(0);
    }
  }
}