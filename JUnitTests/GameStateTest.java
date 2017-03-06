/**
 * Nerd 03/05/2017
 * Deep Patel
 * Test cases related to GameState class
 * TODO:
 *  - Add more test cases
 */

import static org.junit.Assert.assertEquals;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Test;
import org.junit.Ignore;

public class GameStateTest {
	@Test
	public void gameStateShouldBeASingleton() {
		GameState tester = GameState.getInstance();
		GameState tester2 = GameState.getInstance();

		assertEquals(tester, tester2);
	}
}