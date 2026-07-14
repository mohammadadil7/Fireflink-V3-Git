package fireflink.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import fireflink.components.BaseClass;
import io.qameta.allure.Step;

public class AllProjectsPage extends BaseClass {

	public AllProjectsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	// Elements

	@FindBy(xpath = "//div[@class='ff-app-header-nav-bar-item']/div[text()='Configuration']")
	private WebElement configurationTab;

	@FindBy(xpath = "//div[text()='User Management']")
	private WebElement userManagementTab;

	@FindBy(xpath = "//span[text()='Groups']")
	private WebElement groupsTab;

	@FindBy(xpath = "//span[text()='Users']")
	private WebElement usersTab;

	@FindBy(css = ".ff-table-row-wrapper")
	private WebElement tableData;

	// Steps
	@Step("Navigate to groups page")

	public void navigateToGroups() {
		waitUtils.waitTillElementIsClickable(configurationTab);
		configurationTab.click();
		userManagementTab.click();
		groupsTab.click();
		waitUtils.waitTillElementIsVisible(tableData);
		Reporter.log("Successfully navigated to groups page", true);

	}

	@Step("Navigate to users page")

	public void navigateToUsers() {
		waitUtils.waitTillElementIsClickable(configurationTab);
		configurationTab.click();
		userManagementTab.click();
		usersTab.click();
		waitUtils.waitTillElementIsVisible(tableData);
		Reporter.log("Successfully navigated to users page", true);

	}

}
