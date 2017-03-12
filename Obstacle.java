/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * Obstacle class that handles declaration methods for both movable and non-movable obstacles such as Car and Tree.
 * Handles check for collisions with obstacles. Sub-class of GameObject
 * TODO: Implement collisionDetected() Method
 */
public abstract class Obstacle extends GameObject implements CollisionListener, Drawable, Sound {
abstract public void update();  
abstract public void draw();
abstract public void play();

public void collisionDetected(){
 //TODO
}

}