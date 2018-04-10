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

class ListOfElements {

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
	void test() {
		boolean isSelected = false;
		
		//tworzymy listê elementów
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@type,'radio') and contains(@name,'cars')]"));
		//rozmiar listy
		int sizeOfList = radioButtons.size();
		
		//dla ka¿dego elementu z listy..
		for (int i = 0; i < sizeOfList; i++) {
			
			isSelected = radioButtons.get(i).isSelected();
			
			//...jeœli radiobutton nie jest zaznaczony, kliknij
			if (!isSelected) {
				radioButtons.get(i).click();		
			}
		}
		
	}

}
