package fireflink.tests.configuration;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import fireflink.TestComponents.BaseClass;
import fireflink.TestComponents.RetryMechanism;
import io.qameta.allure.Description;

public class GroupsTest extends BaseClass {
	@Test(description = "Verify user is able to view create group slider")
	public void GR001()

	{

		signPage.signToFireflink(email, password);
		allProjectsPage.navigateToGroups();
		assertTrue(groupsPage.addGroupButtonIsDisplayed(), "Add group button is not displayed");
		groupsPage.clickOnAddgroupButton();
		assertTrue(groupsPage.createGroupSliderIsDisplayed(), "Create group slider is not displayed");

	}

	@Test(description = "Verify user is able to create a group", retryAnalyzer = RetryMechanism.class)
	public void GR002()

	{

		signPage.signToFireflink(email, password);
		allProjectsPage.navigateToGroups();
		assertTrue(groupsPage.addGroupButtonIsDisplayed(), "Add group button is not displayed");
		groupsPage.clickOnAddgroupButton();
		assertTrue(groupsPage.createGroupSliderIsDisplayed(), "Create group slider is not displayed");

	}

}
