package driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.PropertiesReader;

public final class Driver {
	
	private Driver() {}
	
	public static WebDriver init_driver(String browser) {
		
		System.out.println("Launching browser :: " + browser);
		
		if(Objects.isNull(DriverManager.getDriver())) {
			switch (browser.toLowerCase().trim()) {
			case "chrome":
				DriverManager.setDriver(new ChromeDriver());
				break;
			case "edge":
				DriverManager.setDriver(new EdgeDriver());
				break;
			case "firefox":
				DriverManager.setDriver(new FirefoxDriver());
				break;

			default:
				System.out.println("Please provide a correct browser name.");
				break;
			}
		}
		
		DriverManager.getDriver().get(PropertiesReader.get("url"));
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().deleteAllCookies();
		
		return DriverManager.getDriver();
	}
	
	public static void quit_driver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}		
	}
	
}
