package fireflink.tests.allprojects.usermanagment.configuration;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import fireflink.components.BaseClass;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;

public class GroupsTest extends BaseClass {

	private String groupName;
	private String groupsTestdataFile = "usermanagment/groupsTestdata";

	@Feature("Groups")
	@Story("Open create group slider")
	@Owner("Mohammad Adil")
	@Test(description = "GR001_Verify user is able to view create group slider", groups = "smoke")
	public void GR001()

	{

		signPage.signToFireflink(email, password);
		allProjectsPage.navigateToGroups();
		assertTrue(groupsPage.addGroupButtonIsDisplayed(), "Add group button is not displayed");
		groupsPage.clickOnAddgroupButton();
		assertTrue(groupsPage.createGroupSliderIsDisplayed(), "Create group slider is not displayed");
		Reporter.log("Create group slider is displayed successfully", true);

	}

	@Feature("Groups")
	@Story("Create a group")
	@Owner("Mohammad Adil")
	@Test(description = "GR002_Verify user is able to create a group", groups = "smoke")
	public void GR002()

	{
		groupName = "QaAutomationGroup" + javaUtility.generateRandomNumber(4);

		signPage.signToFireflink(email, password);
		allProjectsPage.navigateToGroups();
		assertTrue(groupsPage.addGroupButtonIsDisplayed(), "Add group button is not displayed");
		groupsPage.clickOnAddgroupButton();
		assertTrue(groupsPage.createGroupSliderIsDisplayed(), "Create group slider is not displayed");

		groupsPage.enterGroupName(groupName);
		groupsPage.selectAllUsers();
		groupsPage.clickCreateButtonUsingJS();
		assertTrue(commonPage.successToasterIsDisplayed(), "Success toaster is not displayed");
		Reporter.log("Group is created successfully", true);

	}

	@Feature("Groups")
	@Story("Delete a created group")
	@Owner("Mohammad Adil")
	@Test(description = "GR003_Verify user is able to create a group and delete", dependsOnMethods = "GR002", groups = "smoke")
	public void GR003()

	{
		signPage.signToFireflink(email, password);
		allProjectsPage.navigateToGroups();
		commonPage.searchForAnEntity(groupName);
		Assert.assertTrue(commonPage.deleteAnEntityAndVerify());
		Reporter.log("Created group is deleted successfully", true);

	}

	@Feature("Groups")
	@Story("Error message should display if group name is skipped")
	@Owner("Mohammad Adil")
	@Test(description = "GR004_Verify Group Name is required error is displayed")
	public void GR004()

	{

		signPage.signToFireflink(email, password);
		allProjectsPage.navigateToGroups();
		groupsPage.clickOnAddgroupButton();
		Assert.assertTrue(groupsPage.createGroupSliderIsDisplayed());
		groupsPage.selectAllUsers();
		Assert.assertTrue(groupsPage.nameIsRequiredErrorTextIsDisplayed());
		Reporter.log("Name required error is displayed", true);

	}

	@Feature("Groups")
	@Story("User can add a guest in the create group slider")
	@Owner("Mohammad Adil")
	@Test(description = "GR005_Verify user is able to add a recipient in Create Email Group slider")
	public void GR005() throws Throwable

	{
		String recipientName = jsonUtils.getJsonValue(groupsTestdataFile, "$.GR005.recipientName");
		String recipietEmail = jsonUtils.getJsonValue(groupsTestdataFile, "$.GR005.recipientEmail");

		signPage.signToFireflink(email, password);
		allProjectsPage.navigateToGroups();
		groupsPage.clickOnAddgroupButton();
		Assert.assertTrue(groupsPage.createGroupSliderIsDisplayed());
		groupsPage.enterGroupName("Test001");
		groupsPage.clickOnAddRecipientButton();
		groupsPage.enterRecipientName(recipientName);
		groupsPage.enterRecipientEmail(recipietEmail);
		assertTrue(groupsPage.addTheRecipientAndVerify());
		Reporter.log("Recipient is added successfully", true);

	}

	@Feature("Groups")
	@Story("User can search the recipient in add groups slider")
	@Owner("Mohammad Adil")
	@Test(description = "GR006_Verify user is able to add a recipient and search the added recipient")
	public void GR006() throws Throwable

	{
		String recipientName = jsonUtils.getJsonValue(groupsTestdataFile, "$.GR005.recipientName");
		String recipietEmail = jsonUtils.getJsonValue(groupsTestdataFile, "$.GR005.recipientEmail");

		signPage.signToFireflink(email, password);
		allProjectsPage.navigateToGroups();
		groupsPage.clickOnAddgroupButton();
		Assert.assertTrue(groupsPage.createGroupSliderIsDisplayed());
		groupsPage.enterGroupName("Test001");
		groupsPage.clickOnAddRecipientButton();
		groupsPage.enterRecipientName(recipientName);
		groupsPage.enterRecipientEmail(recipietEmail);
		assertTrue(groupsPage.addTheRecipientAndVerify());
		Reporter.log("Recipient is added successfully", true);

		Assert.assertTrue(groupsPage.searchAndVerifyTheRecipientName(recipientName));
		Reporter.log("Recipient is added and searched successfully", true);

	}

	@Feature("Groups")
	@Story("User can search the recipient in add groups slider")
	@Owner("Mohammad Adil")
	@Test(description = "GR006_Verify user is able to add a recipient and search the added recipient", retryAnalyzer = fireflink.components.RetryMechanism.class)
	public void GR007() throws Throwable

	{
		signPage.signToFireflink(email, password);

		Assert.assertTrue(false);
	}

}
