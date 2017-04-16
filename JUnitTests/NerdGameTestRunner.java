/**
 * Nerd 02/28/2017
 * Deep Patel
 * Run All Test Cases
 * Todo:
 *  - Run more test classes
 */

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class NerdGameTestRunner {
	public static void main(String[] args) {
		// Todo: Add more test case classes
		Class testClasses[] = { 
								AllMenuAssetsTest.class,
								AssetsTest.class,
								CharacterTest.class,
								CollisionEventTest.class,
								DisplayStateTest.class,
								GameObjectAndPositionRelationshipTest.class,
								GameStateTest.class,
								HelpAssetsTest.class,
								HoverButtonTest.class,
								LocationTest.class,
								NerdGameTest.class,
								OzLocationTest.class
							};

		Result result = JUnitCore.runClasses(testClasses);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
			System.out.println(failure.getTrace());
		}
		if (result.wasSuccessful()) {
			System.out.println("Passed All Tests!" + " (" + result.getRunTime() + " ms)");
		} else {
			System.out.println("Failed: " + result.getFailureCount() + " (" + result.getRunTime() + " ms)");
		}
	}
}