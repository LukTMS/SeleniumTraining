package WorkingWithWebElements;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class ElementState {

	WebDriver driver;
	String baseURL;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\- Programy -\\- Instalki\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		baseURL = "https://www.google.com";
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
		
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	void test() {
		//tworzenie elementu
		WebElement e1 = driver.findElement(By.id("lst-ib"));
		
		//sprawdzanie stanu elmentu
		boolean isEnabled = e1.isEnabled();
		System.out.println(isEnabled);
		
		//wysy³anie tekstu do utworzonego elementu
		e1.sendKeys("has³o do wyszukania");
		
	}

}
