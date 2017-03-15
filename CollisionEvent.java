/**
 * Nerd 03/09/2017
 * Deep Patel
 * CollisionEvent class used to check for collisions call observers when collision occurs
 */

import java.util.ArrayList;
import java.util.List;

public class CollisionEvent {
	private ArrayList<CollisionListener> listeners = new ArrayList<CollisionListener>();

	public void addListener(CollisionListener listener) {
		listeners.add(listener);
	}

	public void removeListener(CollisionListener listener) {
		listeners.remove(listener);
	}

	public void checkCollision(Character player, List<MovableObstacle> moveableObstacles) {
		int playerPos[] = player.getPosition;
		for (MovableObstacle mo : moveableObstacles) {
			int moPos[] = mo.getPosition;
			if (playerPos[0] == moPos[0] && playerPos[1] == moPos[1]) {
				for (CollisionListener listener : listeners) {
					if (listener != null) {
						listener.collisionDetected();
					}
				}
				break;
			}
		}
	}
}