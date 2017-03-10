/**
 * Nerd 03/09/2017
 * Deep Patel
 * CollisionEvent class used to check for collisions call observers when collision occurs
 * TODO: Implement collision check
 */

import java.util.ArrayList;

public class CollisionEvent {
	private ArrayList<CollisionListener> listeners = new ArrayList<CollisionListener>();

	public void addListener(CollisionListener listener) {
		listeners.add(listener);
	}

	public void removeListener(CollisionListener listener) {
		listeners.remove(listener);
	}

	public void checkCollision() {
		// TODO: Implement the collision check
		for (CollisionListener listener : listeners) {
			if (listener != null) {
				listener.collisionDetected();
			}
		}
	}
}