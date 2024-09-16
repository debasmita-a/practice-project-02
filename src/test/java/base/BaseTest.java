package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.Driver;
import pages.LoginPage;
import utils.PropertiesReader;

public class BaseTest {
	
	protected WebDriver driver;
	protected LoginPage loginPage;
	
	@BeforeMethod
	public void setup() {
		driver = Driver.init_driver(PropertiesReader.get("browser"));
		loginPage = new LoginPage(driver);
	}
	
	@AfterMethod
	public void teardown() {
		
	}
	
}
