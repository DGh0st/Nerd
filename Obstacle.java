/**
 * Nerd 03/11/2017
 * Kandyce Burks
 * Obstacle class that handles declaration methods for both movable and non-movable obstacles such as Car and Tree.
 * Handles check for collisions with obstacles. Sub-class of GameObject
 * TODO: Implement collisionDetected() Method
 */

import java.awt.Graphics;

public abstract class Obstacle extends GameObject implements CollisionListener, Drawable, Sound {

public Obstacle(int x, int y) {
	super(x, y);
}

abstract public void update();  
abstract public void draw();
abstract public void draw(Graphics g);
abstract public void play();

public void collisionDetected(){
 //TODO
}

}