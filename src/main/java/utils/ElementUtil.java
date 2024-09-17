package utils;

import java.time.Duration;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class ElementUtil {

	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	//*****************browser utilities *************************************/
	
	public String getPageURL() {
		return driver.getCurrentUrl();
	}
	
	public boolean getPageURL(String url, int timeout) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(
				ExpectedConditions.urlContains(url));		
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean getPageTitle(String title, int timeout) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(
				ExpectedConditions.titleContains(title));
	}
	
	public boolean isElementPresent(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	public boolean isElementPresent(By locator, int timeout) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(
				ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
	}
	
	public void doClick(By locator) {
		driver.findElement(locator).click();
	}
	
	public void doClick(By locator, int timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(
				ExpectedConditions.elementToBeClickable(locator)).click();	
	}
	
	public void doSendKeys(By locator, String keys) {
		driver.findElement(locator).sendKeys(keys);
	}
	
	public void doSendKeys(By locator, String keys, int timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(
				ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(keys);
	}
	
	public void selectValueFromDropdown(By locator, String textValueIndex, String strategy) {
		Select select = new Select(driver.findElement(locator));
		if(strategy.equalsIgnoreCase("text")) {
			select.selectByVisibleText(textValueIndex);
		}else if(strategy.equalsIgnoreCase("value")) {
			select.selectByValue(textValueIndex);
		}else if(strategy.equalsIgnoreCase("option")) {
			select.deselectByIndex(Integer.parseInt(textValueIndex));
		}else {
			System.out.println("Invalid select strategy.");
		}
	}
	
	public void selectValueFromDropdown(Consumer<Select> consumer, WebElement element) {
		consumer.accept(new Select(element));
	}
}
