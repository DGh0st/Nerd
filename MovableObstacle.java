/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * MovableObstacle class that handles updates for movable obstacles locations such as Car.
 * TODO:Implement Update() Method
 */
public abstract class MovableObstacle extends Obstacle{
  int SPEED;
  public MovableObstacle(int x, int y) {
   super(x, y);
  }

  public void update(){
    moveLeft();
    moveDown();
    moveUp();
    moveRight();
    checkSelfCollision();
  }
  
  abstract public void setSpeed(int speed);
  abstract public void checkSelfCollision();
  abstract public void moveLeft();
  abstract public void moveDown();
  abstract public void moveUp();
  abstract public void moveRight();
}