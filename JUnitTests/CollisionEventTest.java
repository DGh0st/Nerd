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

		cEvent.checkCollision();

		assertEquals(false, collisionEventRegisteredListenerWasCalled);
	}

	@Test
	public void collisionEventShouldRegisterListener() {
		collisionEventRegisteredListenerWasCalled = false;

		CollisionEvent cEvent = new CollisionEvent();

		cEvent.addListener(this);
		cEvent.checkCollision();

		assertEquals(true, collisionEventRegisteredListenerWasCalled);

		cEvent.removeListener(this);
	}
}