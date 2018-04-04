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

public class Autocomplete {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\- Programy -\\- Instalki\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://www.southwest.com/";

		// Maximize the browser's window
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testAutocomplete() throws Exception {
		driver.get(baseUrl);
		String searchingText = "New York/Newark, NJ - EWR";
		String partialText = "New York";

		//znajdujemy pole z autouzupe³nieniem
		WebElement text = driver.findElement(By.id("air-city-departure"));
		//wpisujemy w znalezionym polu tekst
		text.sendKeys(partialText);

		//znajdujemy pole z list¹ podpowiedzi (lotniskami)
		WebElement element = driver.findElement(By.id("air-city-departure-menu"));
		
		//znajdujemy wszystkie elementy z tagiem 'li'
		List<WebElement> results = element.findElements(By.tagName("li"));
		int size = results.size();

		//wypisujemy rozmiar listy
		System.out.println("The size of the airport's list is: " + (size-1));

		//dla ka¿dego elmentu na liœcie, wypisz ten element
		for (int i = 0; i < size; i++) {
			System.out.println("An airport on the position " + i + " is " + results.get(i).getText());
		}

		Thread.sleep(3000);
		
		//dla ka¿dego elementu na liœcie, jeœli pobrany tekst jest równy szukanemu tekstowi, kliknij
		for (WebElement result : results) {
			if (result.getText().equals(searchingText)) {
				System.out.println("Selected airport is " + result.getText());
				result.click();
				
				break;
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
