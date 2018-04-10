package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	
	//WA¯NE
	public static WebElement element = null;
	
	/**
	 * Returns the flight button
	 * @param driver
	 * @return
	 */
	public static WebElement flightButton(WebDriver driver) {
		element = driver.findElement(By.id("tab-flight-tab-hp"));
		return element;
	}
	
	/**
	 * Click on the flightButton
	 * @param driver
	 * @return
	 */
	public static void clickFlightButton(WebDriver driver) {
		element = flightButton(driver);
		element.click();
	}
	
	
	
	/**
	 * Returns the flight origin text box element
	 * @param driver
	 * @return
	 */
	public static WebElement originTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-origin-hp-flight"));
		return element;
	}
	
	public static void fillOriginTextBox(WebDriver driver, String origin) {
		element = originTextBox(driver);
		element.sendKeys(origin);
	}

	/**
	 * Returns the flight destination text box element
	 * @param driver
	 * @return
	 */
	public static WebElement destinationTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-destination-hp-flight"));
		return element;
	}

	/**
	 * Returns the departure date text box element
	 * @param driver
	 * @return
	 */
	public static WebElement departureDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-departing-hp-flight"));
		return element;
	}

	/**
	 * Returns the return date text box element
	 * @param driver
	 * @return
	 */
	public static WebElement returnDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-returning-hp-flight"));
		return element;
	}

	/**
	 * Returns the search button box element
	 * @param driver
	 * @return
	 */
	public static WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.linkText("Search"));
		return element;
	}

	/**
	 * Click on search button
	 * @param driver
	 */
	public static void clickOnSearchButton(WebDriver driver) {
		element = searchButton(driver);
		element.click();
	}
	
	
}
