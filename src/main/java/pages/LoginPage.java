package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementUtil;

public final class LoginPage {

	private ElementUtil util;
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}
	
	private static final By btn_aapointment = By.id("btn-make-appointment");
	private static final By btn_toggle = By.id("menu-toggle");
	private static final By link_login = By.linkText("Login");
	private static final By text_username = By.id("txt-username");
	private static final By text_password = By.id("txt-password");
	private static final By btn_login = By.id("btn-login");
	
	
	public boolean isAppointmentbtnAvailable() {		
		return util.isElementPresent(btn_aapointment);
	}
	
	public LoginPage clickOnToggleMenuBtn() {
		util.doClick(btn_toggle);
		return this;
	}
	
	public LoginPage clickLoginLink() {
		util.doClick(link_login);
		return this;
	}
	
	public String getPageURL() {
		return util.getPageURL();
	}
	
	public LoginPage enterUsername(String username) {
		util.doSendKeys(text_username, username);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		util.doSendKeys(text_password, password);
		return this;
	}
	
	public AppointmentPage clickLoginBtn() {
		util.doClick(btn_login);
		return new AppointmentPage(driver);
	}
	
}
