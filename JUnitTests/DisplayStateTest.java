/**
 * Nerd 03/04/2017
 * Deep Patel
 * Test cases related to DisplayState class
 * Todo:
 *  - Add more test cases
 */

import static org.junit.Assert.assertEquals;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Test;
import org.junit.Ignore;

public class DisplayStateTest {
	@Test
	public void displayStateShouldBeASingleton() {
		DisplayState tester = DisplayState.getInstance();
		DisplayState tester2 = DisplayState.getInstance();

		assertEquals(tester, tester2);
	}

	@Test
	public void displayStatusShouldBeInitializedToStartMenu() {
		DisplayState tester = DisplayState.getInstance();

		assertEquals(DisplayStatus.STARTMENU, tester.getCurrentDisplayStatus());
	}

	@Test
	public void displayStatusChangesShouldTakeEffect() {
		DisplayState tester = DisplayState.getInstance();

		tester.setCurrentDisplayStatus(DisplayStatus.CLOSE);
		assertEquals(DisplayStatus.CLOSE, tester.getCurrentDisplayStatus());
		tester.setCurrentDisplayStatus(DisplayStatus.LOSEMENU);
		assertEquals(DisplayStatus.LOSEMENU, tester.getCurrentDisplayStatus());
		tester.setCurrentDisplayStatus(DisplayStatus.VICTORYMENU);
		assertEquals(DisplayStatus.VICTORYMENU, tester.getCurrentDisplayStatus());
		tester.setCurrentDisplayStatus(DisplayStatus.PAUSEMENU);
		assertEquals(DisplayStatus.PAUSEMENU, tester.getCurrentDisplayStatus());
		tester.setCurrentDisplayStatus(DisplayStatus.INGAME);
		assertEquals(DisplayStatus.INGAME, tester.getCurrentDisplayStatus());
		tester.setCurrentDisplayStatus(DisplayStatus.STARTMENU);
		assertEquals(DisplayStatus.STARTMENU, tester.getCurrentDisplayStatus());
	}

	@Test
	public void sizeShouldBeSameAsNerdGameWindowSize() {
		DisplayState tester = DisplayState.getInstance();

		assertEquals(tester.getSize(), NerdGame.windowSize);
	}
}