package PageObjectFactory;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NoFrameworkTest {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "D:\\- Programy -\\- Instalki\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() {
		//driver.findElement(By.id("header-history")).click();
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		driver.findElement(By.id("flight-origin-hp-flight")).sendKeys("New York");
		driver.findElement(By.id("flight-destination-hp-flight")).sendKeys("Chicago");
		driver.findElement(By.id("flight-returning-hp-flight")).sendKeys("05/07/2018");
		driver.findElement(By.id("flight-departing-hp-flight")).sendKeys("04/05/2018");
		driver.findElement(By.id("search-button")).click();
	}

	@After
	public void afterClass() {
	}

}
