package fireflink.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fireflink.components.BaseClass;

public class CommonPage extends BaseClass {

	public CommonPage(WebDriver driver) {

		// this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()='Success']")
	private WebElement successToasterText;

	public boolean successToasterIsDisplayed() {
		waitUtils.waitTillElementIsVisible(successToasterText);

		return successToasterText.isDisplayed();

	}

}
