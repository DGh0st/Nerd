/**
 * Nerd 04/25/2017
 * Deep Patel
 * Prophet class that is a subclass of Character
 */
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;

class Prophet extends Character{
  int RECT_WIDTH = Tile.TILE_WIDTH, RECT_HEIGHT = Tile.TILE_HEIGHT;
  BufferedImage upImage, leftImage, downImage, rightImage, image;
  
  public Prophet(int x, int y){
    super(x,y);

    upImage = ImageLoader.loadImage("./resources/characters/prophet/ProphetB_band.png");
    leftImage = ImageLoader.loadImage("./resources/characters/prophet/ProphetL_band.png");
    downImage = ImageLoader.loadImage("./resources/characters/prophet/Prophet_band.png");
    rightImage = ImageLoader.loadImage("./resources/characters/prophet/ProphetR_band.png");
    image = upImage;
  }

  public void moveLeft() {
    super.moveLeft();

    image = leftImage;
  }

  public void moveRight() {
    super.moveRight();

    image = rightImage;
  }

  public void moveUp() {
    super.moveUp();

    image = upImage;
  }

  public void moveDown() {
    super.moveDown();

    image = downImage;
  }
  
  public void draw(){
    draw(GameState.getInstance().getGraphics());
  }

  public void draw(Graphics g){
    int x = (pixel.getX() + RECT_WIDTH / 2) - image.getWidth() / 2;
    int y = (pixel.getY() + RECT_HEIGHT / 2) - image.getHeight() * 4 / 5;
    if (g != null) {
      g.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
    }
  }
  
  public void play(){
   //TODO
  }

  public BufferedImage getImage() {
    return downImage;
  }
}
