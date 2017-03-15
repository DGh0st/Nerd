/**
 * Nerd 03/09/2017
 * Deep Patel
 * Test cases related to CollisionEvent class
 * TODO:
 *  - Add more test cases
 */

import static org.junit.Assert.assertEquals;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.Before;
import java.util.ArrayList;

public class CollisionEventTest implements CollisionListener {
	private boolean collisionEventRegisteredListenerWasCalled = false;

	@Override
	public void collisionDetected() {
		collisionEventRegisteredListenerWasCalled = true;
	}

	@Test
	public void collisionEventShouldNotDefaultRegisterListener() {
		collisionEventRegisteredListenerWasCalled = false;

		CollisionEvent cEvent = new CollisionEvent();
		Character player = new Weaboo(0, 0);
		player.setObjectPosition(0, 0);
		ArrayList<MovableObstacle> mo = new ArrayList<MovableObstacle>();
		mo.add(new Car());
		mo.get(0).setObjectPosition(0, 0);

		cEvent.checkCollision(player, mo);

		assertEquals(false, collisionEventRegisteredListenerWasCalled);
	}

	@Test
	public void collisionEventShouldRegisterListener() {
		collisionEventRegisteredListenerWasCalled = false;

		CollisionEvent cEvent = new CollisionEvent();
		Character player = new Weaboo(0, 0);
		player.setObjectPosition(0, 0);
		ArrayList<MovableObstacle> mo = new ArrayList<MovableObstacle>();
		mo.add(new Car());
		mo.get(0).setObjectPosition(0, 0);

		cEvent.addListener(this);
		cEvent.checkCollision(player, mo);

		assertEquals(true, collisionEventRegisteredListenerWasCalled);

		cEvent.removeListener(this);
	}

	@Test
	public void collisionEventShouldNotTrigger() {
		collisionEventRegisteredListenerWasCalled = false;

		CollisionEvent cEvent = new CollisionEvent();
		Character player = new Weaboo(100, 100);
		player.getPosition[0] = player.getPosition[1] = 100;
		ArrayList<MovableObstacle> mo = new ArrayList<MovableObstacle>();
		mo.add(new Car());
		mo.get(0).getPosition[0] = mo.get(0).getPosition[1] = 0;

		cEvent.addListener(this);
		cEvent.checkCollision(player, mo);

		assertEquals(false, collisionEventRegisteredListenerWasCalled);

		cEvent.removeListener(this);
	}
}