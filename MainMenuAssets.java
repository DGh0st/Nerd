/**
 * MainMenuAssets.java
 * Deep Patel
 * 04/08/2017
 * MainMenuAssets class holds sprite images for the main menu
 */

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MainMenuAssets
{
  private static final int WIDTH=64, HEIGHT=64, ROWS=1, COLS=5;
  private static final int WIDTH_BIG=256, HEIGHT_BIG=64, ROWS_BIG=4, COLS_BIG=1;
  private static final String PATH="./resources/menus/MainMenuSpriteSheet.png";
  
  private static MainMenuAssets instance = null;

  private ArrayList<BufferedImage> sprites;

  private MainMenuAssets() {
    SpriteSheet sheet = new SpriteSheet(PATH);
    sprites = new ArrayList<BufferedImage>(ROWS * COLS + ROWS_BIG * COLS_BIG);
    
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        sprites.add(sheet.crop(j * WIDTH, i * HEIGHT, WIDTH, HEIGHT));
      }
    }

    for (int i = 0; i < ROWS_BIG; i++) {
      for (int j = 0; j < COLS_BIG; j++) {
        sprites.add(sheet.crop(j * WIDTH_BIG, ROWS * HEIGHT + i * HEIGHT_BIG, WIDTH_BIG, HEIGHT_BIG));
      }
    }
  }

  public static MainMenuAssets getInstance() {
    if (instance == null) {
      instance = new MainMenuAssets();
    }
    return instance;
  }
  
  public BufferedImage getSprite(int index) {
    return sprites.get(index);
  }
}