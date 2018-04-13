package PageObjectFactory;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//WA¯NE
import PageObjectFactory.SearchPageFactory;

public class FrameworkTestCase {
	private WebDriver driver;
	private String baseUrl;
	//WA¯NE
	SearchPageFactory searchPage;

	@Before
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "D:\\- Programy -\\- Instalki\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		
		//WA¯NE
		searchPage = new SearchPageFactory(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {
		searchPage.clickFlightsTab();
		searchPage.setOriginCity("New York");
		searchPage.setDestinationCity("San Francisco");
		searchPage.returnDate.sendKeys("05/07/2018");
		searchPage.departureDate.sendKeys("04/05/2018");
		
	}
	


	@After
	public void afterClass() {
	}
}