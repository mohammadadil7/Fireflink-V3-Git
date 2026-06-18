package fireflink.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fireflink.components.BaseClass;
import io.qameta.allure.Step;

public class AllProjectsPage extends BaseClass {

	public AllProjectsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}
	
	//Elements

	@FindBy(xpath = "//div[@class='ff-app-header-nav-bar-item']/div[text()='Configuration']")
	private WebElement configurationTab;

	@FindBy(xpath = "//div[text()='User Management']")
	private WebElement userManagementTab;

	@FindBy(xpath = "//span[text()='Groups']")
	private WebElement groupsTab;

	
	//Steps
	@Step("Navigate to groups page")

	public void navigateToGroups() {
		waitUtils.waitTillElementIsClickable(configurationTab);
		configurationTab.click();
		userManagementTab.click();
		groupsTab.click();

	}

}
