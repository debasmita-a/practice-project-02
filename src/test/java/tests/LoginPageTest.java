package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public final class LoginPageTest extends BaseTest{

	private LoginPageTest() {}
	
	@Test
	public void isAppointmentbtnAvailableTest() {
		loginPage.isAppointmentbtnAvailable();
	}
	
	@Test
	public void getPageURL() {
		String url = loginPage.clickOnToggleMenuBtn().clickLoginLink().getPageURL();
		Assert.assertTrue(url.contains("login"));
	}
}
