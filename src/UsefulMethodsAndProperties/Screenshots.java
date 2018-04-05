package UsefulMethodsAndProperties;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;

public class Screenshots {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\- Programy -\\- Instalki\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		
		// Maximize the browser's window
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testScreenshots() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		
		// Find Elements
		WebElement flight_origin = driver.findElement(By.id("flight-origin-hp-flight"));
		WebElement flight_destination = driver.findElement(By.id("flight-destination-hp-flight"));
		WebElement departure_date = driver.findElement(By.id("flight-departing-hp-flight"));
		WebElement return_date = driver.findElement(By.id("flight-returning-hp-flight"));
		//WebElement search = driver.findElement(By.partialLinkText("Search"));
		
		// Send data to elements
		flight_origin.sendKeys("New York");
		flight_destination.sendKeys("Washington DC");
		return_date.clear();
		return_date.sendKeys("06/09/2018");
		departure_date.sendKeys("04/09/2018");
		departure_date.submit();
		//search.click();
		
		Thread.sleep(2000);
	}
	
	//metoda do nadawania nazw plikom
	public static String getRandomString(int length) {
		//tworzymy String Buildera
		StringBuilder stringBuilder = new StringBuilder();
		//tworzymy zmienn¹ z dozwolonymi znakami
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		//dla ka¿dego i mniejszego ni¿ d³ugoœæ zmiennej z dozwolonymi znakami..
		for (int i = 0; i < length; i++) {
			//...stwórz zmienn¹ index i przypisz jej wynik mno¿enia funkcji Math.random x d³ugoœæ zmiennej z dozwolonymi znakami...
			int index = (int) (Math.random() * characters.length());
			//...i dodaj do String Buildera znak na pozycji index ze zmiennej z dowolonymi znakami
			stringBuilder.append(characters.charAt(index));
		}
		
		return stringBuilder.toString();
	}
		
		
		
	@After
	public void tearDown() throws Exception {
		//tworzymy zmienn¹ z nazw¹ pliku screenshota
		String fileName = getRandomString(10) + ".png";
		//tworzymy zmienn¹ ze œcie¿k¹ zapisu pliku screenshota
		String directory = "\\Users\\LukTMS\\Pulpit\\";
		
		//tworzymy zmienn¹ typu FILE
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//kopiujemy plik do wskazanej lokalizacji
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		
		driver.quit();
	}
}
