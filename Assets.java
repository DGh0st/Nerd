import java.awt.image.BufferedImage;

//assets = images, sound,music
public class Assets
{
  private static final int WIDTH=16, HEIGHT=16;
  public static BufferedImage player,enemy,grass_1,grass_2,mud_1,mud_2,stone_1,stone_2;
  
  public static void init(){
     SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Tutorial_SpriteSheet_Textured.png"));
     
     //first row
     player = sheet.crop(0    ,0,WIDTH,HEIGHT);
     enemy = sheet.crop (WIDTH,0,WIDTH,HEIGHT);
     
     //second row
     grass_1 = sheet.crop(0,      HEIGHT,WIDTH,HEIGHT);
     grass_2 = sheet.crop(WIDTH,  HEIGHT,WIDTH,HEIGHT);
     mud_1 = sheet.crop  (WIDTH*2,HEIGHT,WIDTH,HEIGHT);
     mud_2 = sheet.crop  (WIDTH*3,HEIGHT,WIDTH,HEIGHT);
     
     //third row
     stone_1 = sheet.crop(0,    HEIGHT*2,WIDTH,HEIGHT);
     stone_2 = sheet.crop(WIDTH,HEIGHT*2,WIDTH,HEIGHT);
  }
}