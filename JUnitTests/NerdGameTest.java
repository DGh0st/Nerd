/**
 * Nerd 03/05/2017
 * Deep Patel
 * Test cases related to NerdGame class
 */

import static org.junit.Assert.assertEquals;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Test;
import org.junit.Ignore;

public class NerdGameTest {
	@Ignore
	@Test
	public void nerdGameShouldBeASingleton() {
		NerdGame tester = NerdGame.getInstance();
		NerdGame tester2 = NerdGame.getInstance();

		assertEquals(tester, tester2);
	}
}