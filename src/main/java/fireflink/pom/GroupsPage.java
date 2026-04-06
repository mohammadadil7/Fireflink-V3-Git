package fireflink.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fireflink.TestComponents.BaseClass;

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

	public boolean addGroupButtonIsDisplayed() {
		boolean displayed = addGroupButton.isDisplayed();
		return displayed;
	}

	public void clickOnAddgroupButton() {
		waitUtils.waitTillElementIsClickable(addGroupButton);
		addGroupButton.click();
	}

	public boolean createGroupSliderIsDisplayed() {
		waitUtils.waitTillElementIsVisible(createEmailGroupSlider);
		boolean displayed = createEmailGroupSlider.isDisplayed();
		return displayed;
	}

}
