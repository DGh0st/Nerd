/**
 * Nerd 03/12/2017
 * Deep Patel
 * Test cases related to HoverButton class
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Test;
import org.junit.Ignore;

public class HoverButtonTest {
	@Test
	public void defaultImagesShouldBeNull() {
		HoverButton tester = new HoverButton();

		assertEquals(tester.getImage(), null);
		assertEquals(tester.getHoverImage(), null);
		assertEquals(tester.getPressedImage(), null);
	}

	@Test
	public void twoParamsShouldHaveSameNonNullImage() {
		HoverButton tester = new HoverButton("hi", MainMenuAssets.getInstance().getSprite(0));

		assertNotEquals(tester.getImage(), null);
		assertEquals(tester.getImage(), tester.getHoverImage());
		assertEquals(tester.getHoverImage(), tester.getPressedImage());
	}

	@Test
	public void threeParamsShouldHaveSameHoverAndPressedImage() {
		HoverButton tester = new HoverButton("hi", MainMenuAssets.getInstance().getSprite(0), AllMenuAssets.getInstance().getSprite(1));

		assertNotEquals(tester.getImage(), null);
		assertNotEquals(tester.getImage(), tester.getHoverImage());
		assertNotEquals(tester.getHoverImage(), null);
		assertEquals(tester.getHoverImage(), tester.getPressedImage());
	}

	@Test
	public void settersAndGettersShouldTakeEffect() {
		HoverButton tester = new HoverButton();

		assertEquals(tester.getImage(), null);
		tester.setImage(AllMenuAssets.getInstance().getSprite(0));
		assertNotEquals(tester.getImage(), null);

		assertEquals(tester.getHoverImage(), null);
		tester.setHoverImage(AllMenuAssets.getInstance().getSprite(1));
		assertNotEquals(tester.getHoverImage(), null);

		assertEquals(tester.getPressedImage(), null);
		tester.setPressedImage(AllMenuAssets.getInstance().getSprite(0));
		assertNotEquals(tester.getPressedImage(), null);
	}
}