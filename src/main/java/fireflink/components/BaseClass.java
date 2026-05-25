package fireflink.components;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import fireflink.pom.AllProjectsPage;
import fireflink.pom.GroupsPage;
import fireflink.pom.SignPage;
import fireflink.testutils.JavaUtility;
import fireflink.testutils.VerificationUtils;
import fireflink.testutils.WaitUtils;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;

@Listeners({ AllureTestNg.class })

public class BaseClass {

	// Global Variables
	public static String email;
	public static String password;
	public static boolean isDisplayed;

	// Declaration of classes
	public static WebDriver driver;

	public static JavaUtility javaUtility = new JavaUtility();
	// public static LoginKeywords loginKeywords;
	public static SignPage signPage;
	public static WaitUtils waitUtils;
	public static AllProjectsPage allProjectsPage;
	public static VerificationUtils verificationUtils;
	public static GroupsPage groupsPage;
	public static Actions action;
	// public static RolesKeywords rolesKeywords;

	// public static Actions actions;

	@BeforeMethod
	public void setUp() throws Throwable {

		String browserName = javaUtility.getConfigData().getProperty("browser").toLowerCase().trim();
		int implicitWaitTime = Integer.parseInt(javaUtility.getConfigData().getProperty("implicitWait").trim());
		String url = javaUtility.getConfigData().getProperty("url");

		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();

			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browserName);

		}

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));

		signPage = new SignPage(driver);
		// loginKeywords = new LoginKeywords();
		waitUtils = new WaitUtils(driver);
		javaUtility = new JavaUtility();
		allProjectsPage = new AllProjectsPage(driver);
		verificationUtils = new VerificationUtils();
		groupsPage = new GroupsPage(driver);

		action = new Actions(driver);
		// rolesKeywords = new RolesKeywords();
		// action = new Actions(driver);

		email = javaUtility.getConfigData().getProperty("email").trim();
		password = javaUtility.getConfigData().getProperty("password").trim();

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

	// Allure Screenshot Attachment
	@Attachment(value = "Screenshot", type = "image/png")
	public byte[] takeScreenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

}
