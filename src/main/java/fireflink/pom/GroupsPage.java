package fireflink.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	@FindBy(xpath = "//div[text()='Recipien Name']//span[@class='ff-checkbox-custom']")
	private WebElement allUsersCheckBox;

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

	public void selectAllUsers() {

		allUsersCheckBox.click();

	}

	public void clickCreateButtonUsingJS() {
		waitUtils.waitTillElementIsClickable(createButton);
		jse.executeScript("arguments[0].click();", createButton);
	}

}
