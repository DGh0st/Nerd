/**
 * Nerd 02/26/2017
 * Deep Patel
 * Test cases related to NerdGame class
 * Todo:
 *  - Add more test cases for NerdGame class
 */

import static org.junit.Assert.assertEquals;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Test;
import org.junit.Ignore;

public class NerdGameTest {
	@Test
	public void displayStatusShouldBeInitializedToStartMenu() {
		NerdGame tester = new NerdGame();

		assertEquals(NerdGame.DisplayStatus.STARTMENU, tester.getCurrentDisplayStatus());
	}

	@Test
	public void displayStatusChangesShouldTakeEffect() {
		NerdGame tester = new NerdGame();

		tester.setCurrentDisplayStatus(NerdGame.DisplayStatus.CLOSE);
		assertEquals(NerdGame.DisplayStatus.CLOSE, tester.getCurrentDisplayStatus());
		tester.setCurrentDisplayStatus(NerdGame.DisplayStatus.LOSEMENU);
		assertEquals(NerdGame.DisplayStatus.LOSEMENU, tester.getCurrentDisplayStatus());
		tester.setCurrentDisplayStatus(NerdGame.DisplayStatus.VICTORYMENU);
		assertEquals(NerdGame.DisplayStatus.VICTORYMENU, tester.getCurrentDisplayStatus());
		tester.setCurrentDisplayStatus(NerdGame.DisplayStatus.PAUSEMENU);
		assertEquals(NerdGame.DisplayStatus.PAUSEMENU, tester.getCurrentDisplayStatus());
		tester.setCurrentDisplayStatus(NerdGame.DisplayStatus.INGAME);
		assertEquals(NerdGame.DisplayStatus.INGAME, tester.getCurrentDisplayStatus());
		tester.setCurrentDisplayStatus(NerdGame.DisplayStatus.STARTMENU);
		assertEquals(NerdGame.DisplayStatus.STARTMENU, tester.getCurrentDisplayStatus());
	}
}