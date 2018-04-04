package UsefulMethodsAndProperties;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalendarSelectionRealUsing {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\- Programy -\\- Instalki\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://www.expedia.com/";

		// Maximize the browser's window
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void test1() throws Exception {
		driver.get(baseUrl);
		// Click flights tab
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		// Find departing field
		WebElement departingField = driver.findElement(By.id("flight-departing-hp-flight"));
		// Click departing field
		departingField.click();
		Thread.sleep(3000);
		// Find the date to be selected (TABLE style)
		WebElement dateToSelect = driver.findElement(By.xpath("//button[contains(@class, 'datepicker-cal-date') and contains(text(), '30')]"));
		// Click the date
		dateToSelect.click();
	}
	
	@Test
	public void test2() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		WebElement departingField = driver.findElement(By.id("flight-departing-hp-flight"));
		departingField.click();
		
		//znalezienie sekcji kalendarza
		WebElement calMonth = driver.findElement(By.xpath("//tbody[@class='datepicker-cal-dates']"));
		
		//znalezienie wszystkich elementów z tagiem 'button' (dni w miesi¹cy)
		List<WebElement> allValidDates = calMonth.findElements(By.tagName("button"));
		
		Thread.sleep(3000);
		
		//dla ka¿dego elementu w liœcie, jeœli pobrany tekst jest równy '31' kliknij
		for (WebElement date : allValidDates) {
			if (date.getText().equals("30")) {
				date.click();
				break;
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}