package fireflink.tests.allprojects.usermanagment.configuration;

import org.testng.Assert;
import org.testng.annotations.Test;

import fireflink.components.BaseClass;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;

public class UsersTest extends BaseClass {

	String usersTestdataFile = "usermanagment/usersTestdata";
	String userName;

	@Feature("Users")
	@Story("Add new user as admin")
	@Owner("Mohammad Adil")
	@Test(description = "UR001-Verify user can be added as admin", groups = "smoke")
	public void UR001() throws Throwable {

		userName = jsonUtils.getJsonValue(usersTestdataFile, "$.UR001.userName");
		String userEmail = userName + javaUtility.generateRandomNumber(5) + "@gmail.com";
		String privilage = jsonUtils.getJsonValue(usersTestdataFile, "$.UR001.privilege");

		signPage.signToFireflink(email, password);
		allProjectsPage.navigateToUsers();
		usersPage.clickOnAddUserButton();
		usersPage.enterUserEmail(userEmail);
		usersPage.selectPrivilage(privilage);
		usersPage.enterNameAndClickOnCreateButton(userName);
		Assert.assertTrue(commonPage.successToasterIsDisplayed(), "Success toaster is not displayed");

	}

	@Feature("Users")
	@Story("Invalid email error message if the email does not have '@' and domain name")
	@Owner("Mohammad Adil")
	@Test(description = "UR002-Verify email invalid error text is displayed")
	public void UR002() throws Throwable {

		String name = jsonUtils.getJsonValue(usersTestdataFile, "$.UR002.userName");
		String userEmail = name + javaUtility.generateRandomNumber(5);
		String privilage = jsonUtils.getJsonValue(usersTestdataFile, "$.UR002.privilege");

		signPage.signToFireflink(email, password);
		allProjectsPage.navigateToUsers();
		usersPage.clickOnAddUserButton();
		usersPage.enterUserEmail(userEmail);
		usersPage.selectPrivilage(privilage);
		Assert.assertTrue(usersPage.enterValidEmailIsDisplayed(), "Enter valid email id text is not displayed");

	}

	@Feature("Users")
	@Story("Search an added user")
	@Owner("Mohammad Adil")
	@Test(description = "UR003-Verify admin user is able to search for an added user", dependsOnMethods = "UR001")
	public void UR003() throws Throwable {

		signPage.signToFireflink(email, password);
		allProjectsPage.navigateToUsers();
	 	Assert.assertTrue(commonPage.searchForAnEntity(userName));
	 	
	}

}
