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
	
	@Test
	public void loginTest() {
		loginPage.clickOnToggleMenuBtn().clickLoginLink().enterUsername("John Doe")
		.enterPassword("ThisIsNotAPassword").clickLoginBtn();
		String url = loginPage.getPageURL();
		Assert.assertTrue(url.contains("appointment"));
	}
}
