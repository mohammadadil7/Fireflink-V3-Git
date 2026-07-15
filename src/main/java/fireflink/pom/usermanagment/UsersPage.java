package fireflink.pom.usermanagment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import fireflink.components.BaseClass;
import io.qameta.allure.Step;

public class UsersPage extends BaseClass {

	public UsersPage(WebDriver driver) {

		// this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@class='ff-plus-icon']")
	private WebElement addUserButton;

	@FindBy(xpath = "//div[text()='Add User to License']")
	private WebElement addUserToLicenseSlider;

	@FindBy(css = "#email")
	private WebElement emailTextfield;

	@FindBy(css = "#select-input-element")
	private WebElement privilageDropdown;

	@FindBy(id = "name")
	private WebElement nameTextfield;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement createButton;

	@FindBy(xpath = "//span[contains(text(),'Enter valid email Id')]")
	private WebElement enterValidEmailText;

	// Steps

	public WebElement privilegeOption(String option) {
		String dynamicXpath = String.format("//span[text()='%s']", option);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpath)));
	}

	@Step("Click on add user button")
	public boolean clickOnAddUserButton() {
		waitUtils.waitTillElementIsClickable(addUserButton);
		addUserButton.click();
		return addUserToLicenseSlider.isDisplayed();

	}

	@Step("Enter user email: {email}")
	public void enterUserEmail(String email) {
		waitUtils.waitTillElementIsClickable(emailTextfield);
		emailTextfield.sendKeys(email);

	}

	@Step("Select privilage as admin")
	public void selectPrivilage(String privilage) {
		privilageDropdown.click();
		
		//Handling StaleElementReferenceException
		int retries = 3;

		while (retries > 0) {

			try {
				waitUtils.waitTillElementIsClickable(privilegeOption(privilage));
				privilegeOption(privilage).click();
				return;

			} catch (StaleElementReferenceException e) {
				retries--;
			}

		}

	}

	@Step("Enter name and click on create button")
	public void enterNameAndClickOnCreateButton(String name) {

		waitUtils.waitTillElementIsVisible(nameTextfield);
		nameTextfield.sendKeys(name);
		waitUtils.waitTillElementIsClickable(createButton);
		createButton.click();

	}

	@Step("Enter valid email id error message is displayed")
	public boolean enterValidEmailIsDisplayed() {

		return enterValidEmailText.isDisplayed();

	}
}
