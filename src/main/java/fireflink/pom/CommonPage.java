package fireflink.pom;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import fireflink.components.BaseClass;
import io.qameta.allure.Step;

public class CommonPage extends BaseClass {

	public CommonPage(WebDriver driver) {

		// this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()='Success']")
	private WebElement successToasterText;

	@FindBy(xpath = "//div[@class='ff-search-icon']/div")
	private WebElement searchIcon;

	@FindBy(xpath = "//input[@class='ff-search-input expanded']")
	private WebElement elasticSearchTextfield;

	@FindBy(xpath = "(//span[@class='ff-highlight-bg'])[1]")
	private WebElement highlihtedLink;

	@FindBy(xpath = "//div[@class='ff-menuicon-container']")
	private WebElement moreIcon;

	@FindBy(xpath = "//label[text()='Delete']/..")
	private WebElement deleteLink;

	@FindBy(xpath = "//span[text()='Delete']/parent::button")
	private WebElement deleteButton;

	@FindBy(xpath = "//span[text()='Delete']")
	private WebElement deletePopup;

	@Step("Success toaster message is displayed")
	public boolean successToasterIsDisplayed() {
		waitUtils.waitTillElementIsVisible(successToasterText);

		return successToasterText.isDisplayed();

	}

	@Step("Search for an entity: {entityName}")
	public void searchForAnEntity(String entityName) {

		waitUtils.waitTillElementIsClickable(commonPage.searchIcon);
		waitUtils.waitForSeconds(3);
		action.moveToElement(commonPage.searchIcon).perform();
		action.click().perform();
		//jse.executeScript("arguments[0].click();", commonPage.searchIcon);
		waitUtils.waitTillElementIsVisible(commonPage.elasticSearchTextfield);
		commonPage.elasticSearchTextfield.sendKeys(entityName);
		waitUtils.waitForSeconds(2);
		action.sendKeys(Keys.ENTER).perform();
		Assert.assertTrue(commonPage.highlihtedLink.isDisplayed());

	}

	@Step("Delete an entity")
	public boolean deleteAnEntityAndVerify() {

		action.moveToElement(commonPage.highlihtedLink).perform();
		waitUtils.waitTillElementIsVisible(commonPage.moreIcon);
		commonPage.moreIcon.click();
		commonPage.deleteLink.click();
		commonPage.deleteButton.click();
		waitUtils.waitTillElementIsVisible(commonPage.successToasterText);
	    return commonPage.successToasterText.isDisplayed();

	}

}
