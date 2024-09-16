package driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	private DriverManager() {}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public static void setDriver(WebDriver driverRef) {	
			tlDriver.set(driverRef);				
	}
	
	public static void unload() {
			tlDriver.remove();
	}
}
