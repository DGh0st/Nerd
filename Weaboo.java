/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * Weaboo class that is a subclass of Character
 * TODO:
 *  - Implement draw() Method
 *  - Implement play() Method
 */
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;

class Weaboo extends Character{
  int RECT_WIDTH = Tile.TILE_WIDTH, RECT_HEIGHT = Tile.TILE_HEIGHT;
  BufferedImage upImage, leftImage, downImage, rightImage, image;
  
  public Weaboo(int x, int y){
    super(x,y);

    upImage = ImageLoader.loadImage("./resources/textures/WeabooB.png");
    leftImage = ImageLoader.loadImage("./resources/textures/WeabooL.png");
    downImage = ImageLoader.loadImage("./resources/textures/Weaboo.png");
    rightImage = ImageLoader.loadImage("./resources/textures/WeabooR.png");
    image = upImage;
   // draw();
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
    //System.out.println("x "+position.x+" y "+position.y);
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
