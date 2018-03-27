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

class MultipleSelect {

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
		WebElement element = driver.findElement(By.id("multiple-select-example"));
		Select select = new Select(element);
		
		//zaznaczenie i odznaczenie pozycji po value
		select.selectByValue("orange");
		Thread.sleep(2000);
		//select.deselectByValue("orange");
		//Thread.sleep(2000);
		
		//wydrukowanie wszystkich elementów z listy wyboru
		List<WebElement> listOfOptions = select.getAllSelectedOptions();
				
		for (WebElement option : listOfOptions) {
			System.out.println(option.getText());
		
		//odznaczenie wszystkich opcji
		select.deselectAll();
			
		}
		
		
	}

}
