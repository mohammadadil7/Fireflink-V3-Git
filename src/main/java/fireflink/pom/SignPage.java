package fireflink.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import fireflink.components.BaseClass;
import io.qameta.allure.Step;

public class SignPage extends BaseClass {

	public SignPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailTextfield;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTextfield;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInButton;

	@FindBy(xpath = "//div[@class='product_1']")
	private WebElement fireflinkPlatformLink;

	@FindBy(xpath = "//span[text()='All Projects']")
	private WebElement allProjectsText;

	@Step("Sign-in to Fireflink")
	public void signToFireflink(String email, String password) {

		waitUtils.waitForSeconds(10000);
		emailTextfield.sendKeys(email);
		passwordTextfield.sendKeys(password);
		signInButton.click();
		verificationUtils.verifyElementisDisplayed(allProjectsText);
		Reporter.log("Successfully signed in to fireflink", true);
	}

}
