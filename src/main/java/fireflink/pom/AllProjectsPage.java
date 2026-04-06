package fireflink.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fireflink.TestComponents.BaseClass;

public class AllProjectsPage extends BaseClass {

	public AllProjectsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='ff-app-header-nav-bar-item']/div[text()='Configuration']")
	private WebElement configurationTab;

	@FindBy(xpath = "//div[text()='User Management']")
	private WebElement userManagementTab;

	@FindBy(xpath = "//span[text()='Groups']")
	private WebElement groupsTab;

	public void navigateToGroups() {
		waitUtils.waitTillElementIsClickable(configurationTab);
		configurationTab.click();
		userManagementTab.click();
		groupsTab.click();

	}

}
