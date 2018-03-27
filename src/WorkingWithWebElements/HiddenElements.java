package WorkingWithWebElements;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class HiddenElements {

	WebDriver driver;
	String baseURL_1;
	String baseURL_2;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\- Programy -\\- Instalki\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		baseURL_1 = "https://letskodeit.teachable.com/p/practice";
		baseURL_2 = "http://www.expedia.com";
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
		
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
		
		
	@Test
	void testLetsKodeIt() throws InterruptedException {
		driver.get(baseURL_1);
		
		//sprawdzenie czy pole tekstowe jes widoczne
		WebElement textBox = driver.findElement(By.id("displayed-text"));
		System.out.println("Is textbox displayed? " + textBox.isDisplayed());
		Thread.sleep(2000);

		//klikniêcie przycisku hide i sprawdzenie czy pole tekstowe jes widoczne
		WebElement hideButton = driver.findElement(By.id("hide-textbox"));
		hideButton.click();
		System.out.println("Clicked on a hide button");
		System.out.println("Is textbox displayed? " + textBox.isDisplayed());
		Thread.sleep(2000);
		
		//klikniêcie przycisku show i sprawdzenie czy pole tekstowe jes widoczne
		WebElement showButton = driver.findElement(By.id("show-textbox"));
		showButton.click();
		System.out.println("Clicked on a show button");
		System.out.println("Is textbox displayed? " + textBox.isDisplayed());
		Thread.sleep(2000);
		
	}
	
	@Test
	void testExpedia() throws InterruptedException {
		driver.get(baseURL_2);
		
		//sprawdzenie czy dropdown jest widoczny (powinno byæ fail)
		WebElement childDropdown = driver.findElement(By.id("package-1-age-select-1"));
		System.out.println("Is child dropdown displayed? " + childDropdown.isDisplayed());
		Thread.sleep(2000);
		
		
	}
		
		
	

}
