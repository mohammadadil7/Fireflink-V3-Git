package fireflink.tests.configuration;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import fireflink.components.BaseClass;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class GroupsTest extends BaseClass {
	@Test(description = "Verify user is able to view create group slider", groups = "smoke")
	public void GR001()

	{

		signPage.signToFireflink(email, password);
		allProjectsPage.navigateToGroups();
		assertTrue(groupsPage.addGroupButtonIsDisplayed(), "Add group button is not displayed");
		groupsPage.clickOnAddgroupButton();
		assertTrue(groupsPage.createGroupSliderIsDisplayed(), "Create group slider is not displayed");

	}

	@Test(description = "Verify user is able to create a group")
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

	@Test(description = "Verify user is able to create a group and delete")
	public void GR003()

	{

		signPage.signToFireflink(email, password);
		allProjectsPage.navigateToGroups();
		assertTrue(groupsPage.addGroupButtonIsDisplayed(), "Add group button is not displayed");
		groupsPage.clickOnAddgroupButton();
		assertTrue(groupsPage.createGroupSliderIsDisplayed(), "Create group slider is not displayed");

	}

}
