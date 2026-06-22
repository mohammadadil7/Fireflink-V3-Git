package fireflink.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import fireflink.components.BaseClass;
import io.qameta.allure.Step;

public class GroupsPage extends BaseClass {

	// private WebDriver driver;

	public GroupsPage(WebDriver driver) {

		// this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".ff-plus-icon")
	private WebElement addGroupButton;

	@FindBy(css = ".ff-drawer-title")
	private WebElement createEmailGroupSlider;

	@FindBy(xpath = "//input[@placeholder='Enter Group Name']")
	private WebElement enterGroupNameTextfield;

	@FindBy(xpath = "//button[@form='create group']")
	private WebElement createButton;

	@FindBy(xpath = "//span[text()='Maximum 25 characters allowed']")
	private WebElement max25CharText;

	@FindBy(xpath = "//div[text()='Recipient Name']//span[@class='ff-checkbox-custom']")
	private WebElement allUsersCheckBox;

	@FindBy(xpath = "//span[text()='Name is required']")
	private WebElement nameIsRequiredErrorText;

	@FindBy(xpath = "//div[text()='Add Recipient']/parent::button")
	private WebElement addRecipientButton;

	@FindBy(xpath = "//input[@name='recipientName']")
	private WebElement recipientNameTextfield;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement recipientEmailTextfield;

	@FindBy(xpath = "//div[contains(@class,'recipient_privilege_button')]/div[1]")
	private WebElement addRecipientIcon;

	@FindBy(xpath = "//div[text()='Guest']")
	private WebElement guestText;

	@FindBy(xpath = "//div[contains(@class,'recipient')]/div[contains(@class,'search')]//div[@class='ff-search-icon']")
	private WebElement recipientsSearchIcon;

	@FindBy(xpath = "//input[@placeholder='Search Name, Email']")
	private WebElement searchRecipientsTextfiled;

	// Dynamic element based on Recipients Name
	public WebElement highlightedRecipeintNameText(String recipeintName) {
		String dynamicXpath = String.format("//span[@class='ff-highlight-bg' and text()='%s']", recipeintName);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpath)));
	}

	@Step("Add group radio button is displayed")
	public boolean addGroupButtonIsDisplayed() {
		boolean displayed = addGroupButton.isDisplayed();
		return displayed;
	}

	@Step("Click on add group button")

	public void clickOnAddgroupButton() {
		waitUtils.waitTillElementIsClickable(addGroupButton);
		addGroupButton.click();
	}

	public boolean createGroupSliderIsDisplayed() {
		waitUtils.waitTillElementIsVisible(createEmailGroupSlider);
		boolean displayed = createEmailGroupSlider.isDisplayed();
		return displayed;
	}

	@Step("Enter group name: {groupName}")

	public void enterGroupName(String groupName) {

		enterGroupNameTextfield.sendKeys(groupName);
	}

	@Step("Select all users")

	public void selectAllUsers() {

		allUsersCheckBox.click();

	}

	@Step("Click on create button")

	public void clickCreateButtonUsingJS() {
		waitUtils.waitTillElementIsClickable(createButton);
		jse.executeScript("arguments[0].click();", createButton);
	}

	@Step("Maximum 25 characters allowed text is displayed")
	public boolean max25CharErrorIsDisplayed() {
		waitUtils.waitTillElementIsClickable(groupsPage.max25CharText);
		return groupsPage.max25CharText.isDisplayed();
	}

	@Step("Name is required error text is displayed")
	public boolean nameIsRequiredErrorTextIsDisplayed() {
		waitUtils.waitTillElementIsClickable(groupsPage.nameIsRequiredErrorText);
		return groupsPage.nameIsRequiredErrorText.isDisplayed();

	}

	@Step("Click on add recipient button")
	public void clickOnAddRecipientButton() {
		groupsPage.addRecipientButton.click();
	}

	@Step("Enter Recipient Name {name}")
	public void enterRecipientName(String name) {
		waitUtils.waitTillElementIsClickable(groupsPage.recipientNameTextfield);
		groupsPage.recipientNameTextfield.sendKeys(name);
		Reporter.log("Entered Recipient Name", true);

	}

	@Step("Enter Recipient Email {email}")
	public void enterRecipientEmail(String email) {
		groupsPage.recipientEmailTextfield.sendKeys(email);
		Reporter.log("Entered Recipient Email", true);

	}

	@Step("Add Recipient and verify")
	public boolean addTheRecipientAndVerify() {
		groupsPage.addRecipientIcon.click();
		waitUtils.waitTillElementIsVisible(groupsPage.guestText);
		return groupsPage.guestText.isDisplayed();

	}

	@Step("Search and verify the recipient name: {recipientName}")
	public boolean searchAndVerifyTheRecipientName(String recipientName) {
		groupsPage.recipientsSearchIcon.click();
		waitUtils.waitTillElementIsClickable(groupsPage.searchRecipientsTextfiled);
		groupsPage.searchRecipientsTextfiled.sendKeys(recipientName);
		waitUtils.waitForSeconds(2);
		action.sendKeys(Keys.ENTER).perform();
		return groupsPage.highlightedRecipeintNameText(recipientName).isDisplayed();
	}

}
