package fireflink.testutils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;

import fireflink.components.BaseClass;

public class VerificationUtils extends BaseClass {

	public boolean verifyElementisClickable(WebElement element) {
		if (element.isDisplayed() && element.isEnabled()) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyElementisDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean verifyElementisNotDisplayed(WebElement element) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			element.isDisplayed();
			return false;
		} catch (org.openqa.selenium.NoSuchElementException e) {

			return true;
		}

	}

}
