package fireflink.testutils;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import fireflink.components.BaseClass;

public class WaitUtils extends BaseClass {

	private int explicitWait;

	public WaitUtils(WebDriver driver) throws Throwable {

		try {

			String explicitWaitValue = javaUtility.getConfigData().getProperty("explicitWait");
			this.explicitWait = Integer.parseInt(explicitWaitValue.trim());
		} catch (NumberFormatException e) {

			throw new RuntimeException("Invalid timeout value in configuration: " + e.getMessage());
		}
	}

	// Wait until the element is visible
	public void waitTillElementIsVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			throw new RuntimeException("Error while waiting for element to be visible: " + e.getMessage());
		}
	}

	// Wait until the element is clickable
	public void waitTillElementIsClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			throw new RuntimeException("Error while waiting for element to be clickable: " + e.getMessage());
		}
	}

	public void waitTillPageLoad(int seconds) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
	}

	public void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitTillElementIsInvisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			throw new RuntimeException("Error while waiting for element to be visible: " + e.getMessage());
		}
	}

	public void setImplicitTimeout(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public void fluentWait_waitTillElementIsInvisible(WebElement element) {
		try {

			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(BaseClass.driver)
					.withTimeout(Duration.ofSeconds(20))
					.pollingEvery(Duration.ofMillis(100))
					.ignoring(RuntimeException.class)
					.ignoring(StaleElementReferenceException.class);

			         wait.until(ExpectedConditions.invisibilityOf(element));

		} catch (Exception e) {
			throw new RuntimeException("Error while waiting for element to be visible: " + e.getMessage());
		}
	}

}
