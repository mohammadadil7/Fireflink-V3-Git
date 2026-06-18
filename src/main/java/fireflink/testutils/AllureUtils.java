package fireflink.testutils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import fireflink.components.BaseClass;
import io.qameta.allure.Attachment;

public class AllureUtils extends BaseClass {

	@Attachment(value = "Failure Screenshot", type = "image/png")
	public static byte[] attachScreenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}