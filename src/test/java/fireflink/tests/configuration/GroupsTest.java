package fireflink.tests.configuration;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import fireflink.components.BaseClass;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;

public class GroupsTest extends BaseClass {
	
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

	}

	@Feature("Groups")
	@Story("Create a group")
	@Owner("Mohammad Adil")
	@Test(description = "GR002_Verify user is able to create a group")
	public void GR002()

	{
		String groupName = "QaAutomationGroup" + javaUtility.generateRandomNumber(4);

		signPage.signToFireflink(email, password);
		allProjectsPage.navigateToGroups();
		assertTrue(groupsPage.addGroupButtonIsDisplayed(), "Add group button is not displayed");
		groupsPage.clickOnAddgroupButton();
		assertTrue(groupsPage.createGroupSliderIsDisplayed(), "Create group slider is not displayed");

		groupsPage.enterGroupName(groupName);
		groupsPage.selectAllUsers();
		groupsPage.clickCreateButtonUsingJS();
		assertTrue(commonPage.successToasterIsDisplayed(), "Success toaster is not displayed");

	}

	@Feature("Groups")
	@Story("Delete a created group")
	@Owner("Mohammad Adil")
	@Test(description = "GR003_Verify user is able to create a group and delete")
	public void GR003()

	{

		signPage.signToFireflink(email, password);
		allProjectsPage.navigateToGroups();
		assertTrue(groupsPage.addGroupButtonIsDisplayed(), "Add group button is not displayed");
		groupsPage.clickOnAddgroupButton();
		assertTrue(groupsPage.createGroupSliderIsDisplayed(), "Create group slider is not displayed");

	}

}
