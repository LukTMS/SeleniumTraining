package WorkingWithWebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

class DropdownElements {

	WebDriver driver;
	String baseURL;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\- Programy -\\- Instalki\\geckodriver-v0.20.0-win64\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
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
	void test() throws InterruptedException {
		
		//znajdowanie listy rozwijanej
		WebElement element = driver.findElement(By.id("carselect"));
		
		Select select = new Select(element);
		
		//wybór z listy rozwijanej po value
		select.selectByValue("benz");
		Thread.sleep(1000);
		
		//wybór z listy rozwijanej po index
		select.selectByIndex(0);
		Thread.sleep(1000);
		
		//wybrór z listy rozwianej po widocznym tekœcie 
		select.selectByVisibleText("Honda");
		Thread.sleep(1000);	
		
		
		//wypisanie wszystkich elementów z listy rozwijanej
		List<WebElement> listOfElements = select.getOptions();
		int size = listOfElements.size();
		
		for (int i=0; i<size; i++) {
			System.out.println(listOfElements.get(i).getText());
			
		}
			
	}

}
